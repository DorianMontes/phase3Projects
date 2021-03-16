package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entities.User;
import com.example.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public String showUsers(ModelMap model) {
		
		Iterable<User> users = userService.GetAllUsers();
		
	    model.addAttribute("users", users);    
		
        return "users";
    }
	

}