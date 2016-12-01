package org.elevenfifty.shoppinglist.controller;

import org.elevenfifty.shoppinglist.beans.ShoppingListItem;
import org.elevenfifty.shoppinglist.repositories.ShoppingListItemRepository;
import org.elevenfifty.shoppinglist.security.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShoppingListItemController {
	private static final Logger log = LoggerFactory.getLogger(ShoppingListItem.class);
	
	@Autowired
	private ShoppingListItemRepository shoppingListItemRepo;

	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping(value = "/shoppingList/{shoppingListId}", method = RequestMethod.GET)
	public String shoppingListItems(@PathVariable long shoppingListId, Model model ){
		model.addAttribute("shoppingListItem", shoppingListItemRepo.findAllByShoppingListIdOrderByPriorityAscContentsAsc(shoppingListId));
		
		return "shoppingListItems";		
	}
	
	@RequestMapping(value = "/shoppingList/{shoppingListId}", method = RequestMethod.DELETE)
	public String shoppingListItemsDelete(@PathVariable long shoppingListId, @RequestParam(name = "isChecked", defaultValue = "false") boolean isChecked, Model model, ShoppingListItem shoppingListItem ){
		model.addAttribute("shoppingListItem", shoppingListItemRepo.findOne(shoppingListId));
		if(shoppingListItem.isChecked() == true){
			
		}
		return "shoppingListItems";		
	}
	
	@RequestMapping(value = "/shoppingList/{shoppingListId}/{shoppingListItemId}", method = RequestMethod.GET)
	public String shoppingListItemView(@PathVariable long shoppingListId, @PathVariable long shoppingListItemId, Model model){
		model.addAttribute("shoppingListItem", shoppingListItemRepo.findOne(shoppingListItemId));
		
		return "viewShoppingListItem";
		
	}
	
	@RequestMapping(value = "/shoppingList/{shoppingListId}/{shoppingListItemId}/edit", method = RequestMethod.GET)
	public String shoppingListItemEdit(@PathVariable ShoppingListItem savedShoppingListItem, @PathVariable long shoppingListItemId, Model model){
		model.addAttribute("shoppingListItem", shoppingListItemRepo.findOne(shoppingListItemId));
		
		
		return "editShoppingListItem";
	}
	
	@RequestMapping(value = "/shoppingList/{shoppingListId}/{shoppingListItemId}/edit", method = RequestMethod.POST)
	public String shoppingListItemEditSave(@ModelAttribute ShoppingListItem shoppingListItem, @PathVariable long shoppingListId, @PathVariable long shoppingListItemId, BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("shoppingListItem", shoppingListItem);
			return "editShoppingListItem";
		}
		shoppingListItemRepo.save(shoppingListItem);
		return "redirect:/shoppingList/{shoppingListId}/{shoppingListItemId}";
	}
	
	@RequestMapping(value = "/shoppingList/{shoppingListId}/add", method = RequestMethod.GET)
	public String shoppinListItemAdd(Model model){
		model.addAttribute("shoppingListItem", new ShoppingListItem(permissionService.findCurrentShoppingListId));
		
		return "shoppingListItemAdd";
	}
	
	@RequestMapping(value = "/shoppingList/{shoppingListId}/add")
	public String shoppingListItemAdd(@ModelAttribute ShoppingListItem shoppingListItem, Model model){
		ShoppingListItem savedShoppingListItem = shoppingListItemRepo.save(shoppingListItem);
		return shoppingListItemEdit(savedShoppingListItem, savedShoppingListItem.getId(), model);
		
		
	}
}
