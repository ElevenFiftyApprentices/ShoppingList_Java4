package org.elevenfifty.shoppinglist.controller;

import java.security.Permission;
import java.util.List;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.elevenfifty.shoppinglist.beans.User;
import org.elevenfifty.shoppinglist.beans.UserRole;
import org.elevenfifty.shoppinglist.repositories.ShoppingListRepository;
import org.elevenfifty.shoppinglist.repositories.UserRepository;
import org.elevenfifty.shoppinglist.security.PermissionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import static org.elevenfifty.shoppinglist.security.Role.ROLE_USER;
import static org.h2.util.StringUtils.isNullOrEmpty;

@Controller
public class ShoppingListController {
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private ShoppingListRepository shoppingListRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PermissionService permissionService;

	@Secured("ROLE_USER")
	@RequestMapping("/shoppingLists")
	public String ShoppingList(Model model) {
		long currentUserId = permissionService.findCurrentUserId();
		model.addAttribute("shoppingList", shoppingListRepo.findAllById(currentUserId));
		return "shoppingList/shoppingLists";
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/shoppingList/shoppingList_create", method = RequestMethod.GET)
	public String createShoppingList(Model model) {
		model.addAttribute("shoppingList", new ShoppingList(permissionService.findCurrentUserId()));

		return "shoppingList_create";
	}

	@RequestMapping(value = "/shoppingList/shoppingList_create", method = RequestMethod.POST)
	public String createShoppingList(@ModelAttribute ShoppingList shoppingList,
			@RequestParam("file") MultipartFile file, Model model) {

		ShoppingList savedShoppingList = shoppingListRepo.save(shoppingList);

		return profileSave(savedShoppingList, savedShoppingList.getId(), false, file, model);
	}

	@RequestMapping(value = "/shoppingList/shoppingList_edit", method = RequestMethod.GET)
	public String editShoppingList(Model model) {
		model.addAttribute("shoppingList", new ShoppingList(permissionService.findCurrentUserId()));

		return "shoppingList/shoppingList_edit";
	}

	@RequestMapping(value = "/shoppingList/shoppingList_edit", method = RequestMethod.POST)
	public String editShoppingList(@ModelAttribute ShoppingList shoppingList,
			@RequestParam("file") MultipartFile file, Model model) {

		ShoppingList savedShoppingList = shoppingListRepo.save(shoppingList);

		return profileSave(savedShoppingList, savedShoppingList.getId(), false, file, model);
	}

}
