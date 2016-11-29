package org.elevenfifty.shoppinglist.controller;

import javax.validation.Valid;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.elevenfifty.shoppinglist.repositories.ShoppingListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShoppingListController {

	@Autowired
	private ShoppingListRepository shoppingListRepository;

	@GetMapping("/shoppinglists")
	public String getShoppingLists(Model model) {
		model.addAttribute("shoppinglists", shoppingListRepository.findAll());
		return "shoppinglist/shoppinglists";
	}
	
	@GetMapping("/shoppinglist/{id}")
	public String shoppinglist(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		ShoppingList s = shoppingListRepository.findOne(id);
		model.addAttribute("shoppinglist", s);
		return "shoppinglist/shoppinglist_detail";
	}

	@GetMapping("/product/{id}/edit")
	public String productEdit(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Product p = productRepo.findOne(id);
		model.addAttribute("product", p);
		return "product/product_edit";
	}
	
	@PostMapping("/product/{id}/edit")
	public String productEditSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid Product product,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			return "product/product_edit";
		} else {
			productRepo.save(product);
			return "redirect:/product/" + product.getId();
		}				
	}
	
	@GetMapping("/product/{id}/delete")
	public String productDelete(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Product p = productRepo.findOne(id);
		model.addAttribute("product", p);
		return "product/product_delete";
	}

	@PostMapping("/product/{id}/delete")
	public String productDeleteSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid Product product,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			return "product/products";
		} else {
			productRepo.delete(product);
			return "redirect:/products";
		}
	}

	@GetMapping("/product/create")
	public String productCreate(Model model) {
		model.addAttribute(new Product());
		return "product/product_create";
	}

	@PostMapping("/product/create")
	public String productCreate(@ModelAttribute @Valid Product product, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("product", product);
			return "product/product_create";
		} else {
			productRepo.save(product);
			return "redirect:/products";
		}

	}

}
			
			
		

