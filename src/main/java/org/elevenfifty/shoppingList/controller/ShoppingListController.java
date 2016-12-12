package org.elevenfifty.shoppinglist.controller;

import javax.validation.Valid;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
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
public class ShoppingListController {

	private static final Logger log = LoggerFactory.getLogger(ShoppingListController.class);

	@Autowired
	private ShoppingListRepository shoppingListRepo;

	@Autowired
	private ShoppingListItemRepository shoppingListItemRepo;

	@GetMapping(path = { "/shoppingLists" })
	public String ShoppingListsPage(ShoppingList shoppingList, Model model) {
		model.addAttribute("shoppingList", shoppingListRepo.findAll());
		return "shoppingList/shoppingLists";
	}

	@GetMapping(path = { "/shoppingList/{id}" })
	public String ShoppingListView(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);

		ShoppingList sl = shoppingListRepo.findOne(id);
		model.addAttribute("shoppingList", sl);
		

		return "shoppingList/shoppingList";

	}

	@GetMapping(path = { "/shoppingLists/{id}/edit" })
	public String ShoppingListEdit(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		ShoppingList s = shoppingListRepo.findOne(id);
		model.addAttribute("shoppingList", s);
		return "shoppingList/shoppingListEdit";
	}

	
	@PostMapping(path = {"/shoppingLists/{id}/edit"})
	public String ShoppingListEditSave(@PathVariable(name = "id") long id,
			@ModelAttribute @Valid ShoppingList shoppingList, BindingResult result, Model model){
		model.addAttribute("shoppingList", shoppingListRepo.findOne(id));
		if(result.hasErrors()) {

			log.info(shoppingList.toString());
			model.addAttribute("shoppingList", shoppingList);
			return "shoppingList/shoppingListEdit";
		}
		log.info(shoppingList.toString());
		shoppingList.setCreatedUtc();
		shoppingList.setModifiedUtc();
		shoppingListRepo.save(shoppingList);
		model.addAttribute("message", "ShoppingList " + shoppingList.getName() + " saved.");

		return "redirect:/shoppingList/" + shoppingList.getId();
	}

	@GetMapping(path = { "/shoppingLists/create" })
	public String ShoppingListCreate(@ModelAttribute @Valid ShoppingList shoppingList, Model model) {
		return "shoppingList/shoppingList_create";
	}

	@PostMapping(path = { "/shoppingLists/create" })
	public String ShoppingListCreateSave(@ModelAttribute @Valid ShoppingList shoppingList, Model model) {
		log.info(shoppingList.toString());

		shoppingList.setCreatedUtc();
		shoppingList.setModifiedUtc();
		shoppingListRepo.save(shoppingList);

		return "redirect:/shoppingList/" + shoppingList.getId();
	}

	@GetMapping(path = { "shoppingLists/{id}/delete" })
	public String listDelete(Model model, @PathVariable(name = "id") Long id) {
		model.addAttribute("id", id);
		ShoppingList s = shoppingListRepo.findOne(id);
		model.addAttribute("shoppingLists", s);
		return "shoppingList/shoppingList_delete";
	}

	@PostMapping(path = "/shoppingLists/{id}/delete")
	public String listDeleteSave(@PathVariable(name = "id") Long id, @ModelAttribute @Valid ShoppingList shoppingList,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("shoppingList", shoppingList);
			return "shoppingList/shoppingList_delete";
		} else {
			shoppingListRepo.delete(shoppingList);
			return "redirect:/shoppingLists";
		}
	}

}
