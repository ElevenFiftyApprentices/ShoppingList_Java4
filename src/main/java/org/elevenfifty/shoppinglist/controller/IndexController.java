package org.elevenfifty.shoppinglist.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.elevenfifty.shoppinglist.repositories.UserRoleRepository;

import java.util.Optional;

import org.elevenfifty.shoppinglist.repositories.UserRepository;




@Controller
public class IndexController {
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserRoleRepository userRoleRepo;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
		return new ModelAndView("login", "error", error);
	}
}
