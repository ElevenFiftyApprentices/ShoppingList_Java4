package org.elevenfifty.shoppinglist.controller;

import static org.elevenfifty.shoppinglist.security.Role.ROLE_ADMIN;
import static org.elevenfifty.shoppinglist.security.Role.ROLE_USER;

import java.util.List;

import org.elevenfifty.shoppinglist.beans.User;
import org.elevenfifty.shoppinglist.beans.UserRole;
import org.elevenfifty.shoppinglist.repositories.UserRepository;
import org.elevenfifty.shoppinglist.repositories.UserRoleRepository;
import org.elevenfifty.shoppinglist.security.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UserController
{
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private UserRepository userRepo;
	
	
	@Autowired
	private UserRoleRepository userRoleRepo;
	
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping("/user/{userId}")
	public String profile(@PathVariable long userId, Model model) {
		model.addAttribute("user", userRepo.findOne(userId));

		if (!permissionService.canAccessUser(userId)) {
			log.warn("Cannot allow user to view " + userId);
			return "redirect:/";
		}

		model.addAttribute("permissions", permissionService);
		return "users/profile";
	}

	@RequestMapping(value = "/user/{userId}/edit", method = RequestMethod.GET)
	public String profileEdit(@PathVariable long userId, Model model) {
		model.addAttribute("user", userRepo.findOne(userId));
		
		if (!permissionService.canAccessUser(userId)) {
			log.warn("Cannot allow user to edit " + userId);
			return "users/profile";
		}

		
		return "users/profileEdit";
	}

	@RequestMapping(value = "/user/{userId}/edit", method = RequestMethod.POST)
	public String profileSave(@ModelAttribute User user,
			@PathVariable long userId,
			@RequestParam(name = "removeImage", defaultValue = "false") boolean removeImage,
			@RequestParam("file") MultipartFile file,
			Model model) {

		if (!permissionService.canAccessUser(userId)) {
			log.warn("Cannot allow user to edit " + userId);
			return "users/profile";
		}
		
		log.debug("Saving user " + user);
		userRepo.save(user);
		model.addAttribute("message", "User " + user.getEmail() + " saved.");

		
		return profile(userId, model);
	}
	
	@RequestMapping("/myprofile")
	public String myprofile(Model model) {
		return profile(permissionService.findCurrentUserId(), model);
	}

	@RequestMapping("/register")
	public String register(Model model) {
	return createUser(model);
}
	
	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
	public String createUser(Model model) {
		model.addAttribute("user", new User());
		
		return "users/userCreate";
	}
	
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String createUser(@ModelAttribute User user,
			@RequestParam("file") MultipartFile file, Model model) {

		log.info(user.toString());
		
		User savedUser = userRepo.save(user);
		UserRole role = new UserRole(savedUser, ROLE_USER);		
		userRoleRepo.save(role);
	

		return profile(savedUser.getId(), model);
	}
}
