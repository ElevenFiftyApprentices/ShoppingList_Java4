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
	
	@GetMapping(path = {"/shoppingList/{id}/items"})
	public String ShoppingListItems(ShoppingListItem shoppingListItem, @PathVariable(name = "id") long id, Model model){
		model.addAttribute("shoppingList", shoppingListRepo.findOne(id));
		model.addAttribute("shoppingListItem", shoppingListItemRepo.findAll());
		return "shoppingListItem/shoppingListItems";
	}
	
	@GetMapping(path = {"/shoppingList/{id}/createItem"})
	public String ShoppingListItemCreate(Model model,  @PathVariable(name = "id") long id){
		model.addAttribute("id", id);
		model.addAttribute("shoppingList", shoppingListRepo.findOne(id));
		ShoppingListItem sli = new ShoppingListItem();
		model.addAttribute("shoppingListItem", sli);
		return "shoppingListItem/addShoppingListItem";
	}
	
	@PostMapping (path = {"/shoppingList/{id}/createItem"})
	public String ShoppingListItemCreateSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid ShoppingListItem shoppingListItem, BindingResult result,Model model){
		log.info(shoppingListItem.toString());
		model.addAttribute("id", id);
		shoppingListItem.setShoppingList(shoppingListRepo.findOne(id));		
		shoppingListItem.setCreatedUtc();
		shoppingListItem.setModifiedUtc();		
		shoppingListItemRepo.save(shoppingListItem);
		model.addAttribute("shoppingList", shoppingListRepo.findOne(id).getShoppingListItem());
		ShoppingList shoppingList = shoppingListRepo.findOne(id);
		shoppingListRepo.save(shoppingList);
		
		return "redirect:/shoppingList/"+ shoppingList.getId() + "/items";
	}
	
	@GetMapping(path = {"/shoppingList/{shoppingListId}/{id}"})
	public String ShoppingListItem(Model model, @PathVariable(name = "id") long id){
		model.addAttribute("shoppingList", shoppingListRepo.findOne(id));
	
		model.addAttribute("id", id);
		ShoppingListItem sli = shoppingListItemRepo.findOne(id);
		model.addAttribute("shoppingListItem", sli);
		return "shoppingListItem/viewShoppingListItem";
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