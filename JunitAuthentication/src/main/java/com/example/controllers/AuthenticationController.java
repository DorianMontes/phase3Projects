package com.example.controllers;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entities.User;
//import com.example.exceptions.UserNotFoundException;
import com.example.services.UserService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Controller
public class AuthenticationController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String showUsers(ModelMap model,@RequestParam String name,
			@RequestParam String password) {

		User u = userService.GetUserByName(name);
		if(u.getPasscode().equals(password)) {
			List<User> us = new ArrayList<>();		
			us.add(u);
			model.addAttribute("welcome", us ); 
			return "welcome";
		} else {
			return "notuser";
		}
	}
}
