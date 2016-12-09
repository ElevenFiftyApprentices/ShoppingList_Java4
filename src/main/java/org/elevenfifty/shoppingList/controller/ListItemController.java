package org.elevenfifty.shoppinglist.controller;

import javax.validation.Valid;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.elevenfifty.shoppinglist.beans.ShoppingListItem;
import org.elevenfifty.shoppinglist.repositories.ShoppingListItemRepository;
import org.elevenfifty.shoppinglist.repositories.ShoppingListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ListItemController {

	private static final Logger log = LoggerFactory.getLogger(ListItemController.class);
	
	@Autowired
	private ShoppingListItemRepository shoppingListItemRepo;
	
	@Autowired
	private ShoppingListRepository shoppingListRepo;
	
	@GetMapping(path = {"/shoppingList/{shoppingListId}/items"})
	public String ShoppingListItems(ShoppingListItem shoppingListItem, Model model){
		model.addAttribute("shoppingListItem", shoppingListItemRepo.findAll());
		return "shoppingListItem/shoppingListItems";
	}
	
	@GetMapping(path = {"/shoppingList/{shoppingListId}/{id}"})
	public String ShoppingListItem(Model model, @PathVariable(name = "id") long id){
		model.addAttribute("id", id);
		ShoppingListItem sli = shoppingListItemRepo.findOne(id);
		model.addAttribute("shoppingListItem", sli);
		return "viewShoppingListItem";
	}	
	
	@GetMapping (path = {"/shoppingList/item/{id}/edit"})
	public String ShoppingListItemEdit(Model model, @PathVariable(name = "id")long id){
		ShoppingListItem sli = shoppingListItemRepo.findOne(id);
		model.addAttribute("shoppingList", sli);
		model.addAttribute("id", id);
		return "editShoppingListItem";
	}
	
	@PostMapping(path = {"/shoppingList/item/{id}/edit"})
	public String ShoppingListItemEditSave(@PathVariable(name = "id") long id,
			@ModelAttribute @Valid ShoppingListItem shoppingListItem, BindingResult result, Model model){
		if(result.hasErrors()) {
			log.info(shoppingListItem.toString());
			model.addAttribute("shoppingListItem", shoppingListItem);
			return "shoppingList/editShoppingListItem";
		}
		
		log.info(shoppingListItem.toString());
		shoppingListItem.setModifiedUtc();
		shoppingListItemRepo.save(shoppingListItem);
		model.addAttribute("message", "Shopping List Item " + shoppingListItem.getContents() + " saved.");

		return "redirect:/shoppingList/{shoppingListId}/" + shoppingListItem.getId();
	}
	
	@GetMapping(path = {"/shoppingList/{shoppingListId}/createItem"})
	public String ShoppingListItemCreate(@ModelAttribute @Valid ShoppingListItem shoppingListItem, Model model){
		return "shoppingList/addShoppingListItem";
	}
	
	@PostMapping (path = {"/shoppingList/{shoppingListId}/createItem"})
	public String ShoppingListItemCreateSave(@ModelAttribute @Valid ShoppingListItem shoppingListItem, Model model){
		log.info(shoppingListItem.toString());
		
		shoppingListItem.setCreatedUtc();
		shoppingListItem.setModifiedUtc();
		shoppingListItemRepo.save(shoppingListItem);
		
		return "redirect:/shoppingList/"+ shoppingListItem.getId();
	}
	
	@GetMapping (path = {"/shoppingList/{shoppingListId}/{id}/delete"})
	public String ShoppingListItemDelete(Model model, @PathVariable(name = "id") Long id) {
		model.addAttribute("id", id);
		ShoppingListItem sli = shoppingListItemRepo.findOne(id);
		model.addAttribute("shoppingListItem", sli);
		return "shoppingList/deleteShoppingList";
	}
	
	@PostMapping (path = {"/shoppingList/{shoppingListId}/{id}/delete"})
	public String ShoppingListItemDeleteSave(@PathVariable(name = "id") Long id, @ModelAttribute @Valid ShoppingListItem shoppingListItem,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("shoppingListItem", shoppingListItem);
			return "shoppingList/deleteShoppingList";
		} else {
			shoppingListItemRepo.delete(shoppingListItem);
			return "redirect:/shoppingListItems";
		}
	}
	
	

}