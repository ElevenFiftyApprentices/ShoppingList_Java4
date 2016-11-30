package org.elevenfifty.shoppinglist.controller;

import javax.validation.Valid;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.elevenfifty.shoppinglist.repositories.ShoppingListRepository;
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

	@Autowired
	private ShoppingListRepository shoppingListRepository;

	@GetMapping("/shoppingLists")
	public String getShoppingList(Model model) {
		model.addAttribute("shoppingLists", shoppingListRepository.findAll());
		return "shoppingList/shoppingLists";
	}
	
	@GetMapping("/shoppingList/{id}")
	public String shoppingList(Model model, @PathVariable(value = "id") long id) {
		model.addAttribute("id", id);
		ShoppingList s = shoppingListRepository.findOne(id);
		model.addAttribute("shoppinglist", s);
		return "shoppinglist/shoppinglist_detail";
	}

//	@GetMapping("/shoppingList/{id}/edit")
//	public String productEdit(Model model, @PathVariable(name = "id") long id) {
//		model.addAttribute("id", id);
//		Product p = productRepo.findOne(id);
//		model.addAttribute("product", p);
//		return "product/product_edit";
//	}
//	
//	@PostMapping("/product/{id}/edit")
//	public String productEditSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid Product product,
//			BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			model.addAttribute("product", product);
//			return "product/product_edit";
//		} else {
//			productRepo.save(product);
//			return "redirect:/product/" + product.getId();
//		}				
//	}
	
//	@GetMapping("/product/{id}/delete")
//	public String productDelete(Model model, @PathVariable(name = "id") long id) {
//		model.addAttribute("id", id);
//		Product p = productRepo.findOne(id);
//		model.addAttribute("product", p);
//		return "product/product_delete";
//	}
//
//	@PostMapping("/product/{id}/delete")
//	public String productDeleteSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid Product product,
//			BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			model.addAttribute("product", product);
//			return "product/products";
//		} else {
//			productRepo.delete(product);
//			return "redirect:/products";
//		}
//	}

	@GetMapping("/shoppingList/create")
	public String shoppingListCreate(Model model) {
		model.addAttribute(new ShoppingList());
		return "shoppingList/shoppingList_create";
	}

	@PostMapping("/shoppingList/create")
	public String shoppingListCreate(@ModelAttribute @Valid ShoppingList shoppingList, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("shoppingList", shoppingList);
			return "shoppingList/shoppingList_create";
		} else {
			shoppingListRepository.save(shoppingList);
			return "redirect:/shoppingLists";
		}

	}

}
			
			
		

