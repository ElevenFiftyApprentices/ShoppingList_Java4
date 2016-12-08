package org.elevenfifty.shoppinglist.controller;


import javax.validation.Valid;

import org.elevenfifty.shoppinglist.beans.Notes;
import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.elevenfifty.shoppinglist.repositories.NotesRepository;
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
public class NotesController {
	private static final Logger log = LoggerFactory.getLogger(NotesController.class);

	
	@Autowired
	private ShoppingListItemRepository shoppingListItemRepo;
	
	@Autowired
	private ShoppingListRepository shoppingListRepo;
	
	@Autowired
	private NotesRepository notesRepo;
	
	
	@GetMapping(path = {"/shoppingList/item/notes/{id}"})
	public String NotesView(Notes notes, Model model){
		model.addAttribute("notes", notesRepo.findAll());
		return "notes";
	}
	
	@GetMapping(path = {"/shoppingList/item/addnotes"})
	public String CreateNote(@ModelAttribute @Valid Notes notes, Model model){
		return "notes_add";
	}
	
	@PostMapping(path ={"/shoppingList/item/addnotes"})
	public String CreateNoteSave(@ModelAttribute @Valid Notes notes, Model model){

		notes.setCreatedUtc();
		notes.setModifiedUtc();
		notesRepo.save(notes);
		
		return "redirect:/shoppingList/item/notes/" + notes.getId();
	}
	@GetMapping(path={"shoppingList/item/notes/{id}/edit"})
	public String EditNote(Model model, @PathVariable(name = "id")long id){
		Notes n = notesRepo.findOne(id);
		model.addAttribute("notes", n);
		model.addAttribute("id", id);
		return "shoppingList/notes_edit";
	}
	@PostMapping(path={"shoppingList/item/notes/{id}/edit"})
	public String EditNoteSave(@PathVariable(name = "id") long id,@ModelAttribute @Valid Notes notes, BindingResult result, Model model){
		if(result.hasErrors()) {
			log.info(notes.toString());
			model.addAttribute("notes", notes);
			return "shoppingList/notes_edit";
		}
		log.info(notes.toString());
		notes.setModifiedUtc();
		notesRepo.save(notes);
		model.addAttribute("message", "ShoppingList " + notes.getId() + " saved.");

		return "redirect:/shoppingList/item/notes/" + notes.getId();
	}
}
