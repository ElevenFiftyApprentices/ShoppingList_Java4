package org.elevenfifty.shoppinglist.controller;

import javax.validation.Valid;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.elevenfifty.shoppinglist.repositories.ShoppingListRepository;
import org.elevenfifty.shoppinglist.repositories.UserRepository;
import org.elevenfifty.shoppinglist.security.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ShoppingListController {
	private static final Logger log = LoggerFactory.getLogger(ShoppingListController.class);
	
	@Autowired
	private ShoppingListRepository shoppingListRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PermissionService permissionService;

	@Secured("ROLE_USER")
	@RequestMapping("/shoppingLists")
	public String shoppingLists(Model model)
	{
		long currentUserId = permissionService.findCurrentUserId(); 
		model.addAttribute("shoppingList", shoppingListRepo.findAllById(currentUserId));
		return "shoppingList/shoppingLists";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping("/contact/{contactId}")
	public String shoppingList(@PathVariable long contactId, Model model) {
		model.addAttribute("contact", shoppingListRepo.findOne(contactId));
		model.addAttribute("permissions", permissionService);
		return "shoppingList/shoppingList";
	}
	
	@RequestMapping(value = "/shoppingList/{shoppingListId}/shoppingList_edit", method = RequestMethod.GET)
	public String editShoppingList(@PathVariable long shoppingListId, Model model){
		model.addAttribute("shoppingList", shoppingListRepo.findOne(shoppingListId));
		return "shoppingList_edit";
	}
	
	@RequestMapping(value = "/shoppingList/{shoppingListId}/shoppingList_edit", method = RequestMethod.POST)
	public String shoppingListSave(@ModelAttribute ShoppingList shoppingList, @PathVariable long shoppingListId, Model model){
		log.debug("Saving Shopping List" + shoppingList);
		shoppingListRepo.save(shoppingList);
		model.addAttribute("message", "Contact " + shoppingList.getEmail() + " saved.");
		return shoppingList(shoppingListId, model);
	}
	@RequestMapping(value = "/shoppingList/shoppingList_create", method = RequestMethod.GET)
	public String createShoppingList(Model model) {
		model.addAttribute("shoppingList", new ShoppingList(permissionService.findCurrentUserId()));
		
		return "shoppingList/shoppingList_create";
	}
	
	
	
	@RequestMapping(value = "/shoppingList/shoppingList_create", method = RequestMethod.POST)
	public String createShoppingList(@ModelAttribute @Valid ShoppingList shoppingList,
	    Model model) {

		log.info(shoppingList.toString());
		ShoppingList savedShoppingList = shoppingListRepo.save(shoppingList);
		
		return shoppingListSave(savedShoppingList, savedShoppingList.getId(), model);
	}


}


