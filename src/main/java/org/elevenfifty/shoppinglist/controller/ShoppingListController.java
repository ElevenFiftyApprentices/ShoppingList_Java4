package org.elevenfifty.shoppinglist.controller;

import java.security.Permission;
import java.util.List;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.elevenfifty.shoppinglist.repositories.ShoppingListRepository;
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
import static org.h2.util.StringUtils.isNullOrEmpty;

@Controller
public class ShoppingListController {
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private ShoppingListRepository shoppingListRepo;

	@Autowired
	private Permission permissionService;

	@Secured("ROLE_USER")
	@RequestMapping(value = "/shoppingList/create", method = RequestMethod.GET)
	public String createContact(Model model) {
		model.addAttribute("shoppingList", new ShoppingList(permissionService.findCurrentUserId()));

		return "shoppingListCreate";
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/shoppingList/create", method = RequestMethod.POST)
	public String createShoppingList(@ModelAttribute ShoppingList shoppingList, @RequestParam("file") MultipartFile file,
			Model model) {

		ShoppingList savedShoppingList = shoppingListRepo.save(shoppingList);

		return profileSave(savedShoppingList, savedShoppingList.getId(), false, file, model);
	}

	@Secured("ROLE_USER")
	@RequestMapping("/shoppinglists")
	public String listContacts(Model model) {
		long currentUserId = permissionService.findCurrentUserId();
		model.addAttribute("shoppingList", shoppingListRepo.findAllByUserIdOrderByFirstNameAscLastNameAsc(currentUserId));
		return "listContacts";
	}

	@Secured("ROLE_USER")
	@RequestMapping("/contact/{contactId}")
	public String contact(@PathVariable long contactId, Model model) {
		model.addAttribute("shoppingList", shoppingListRepo.findOne(contactId));
		model.addAttribute("permissions", permissionService);
		return "contact";
	}

	}


