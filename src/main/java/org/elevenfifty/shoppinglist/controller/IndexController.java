package org.elevenfifty.shoppinglist.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.users.controller.IndexController;
import com.users.repositories.UserRepository;

@Controller
public class IndexController
{
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private UserRepository userRepo;
}
