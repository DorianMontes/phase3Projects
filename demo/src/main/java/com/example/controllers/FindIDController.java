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
import com.example.exceptions.UserNotFoundException;
import com.example.services.UserService;

import java.util.List;

@Controller
public class FindIDController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/findid", method = RequestMethod.POST)
	public String showUsers(ModelMap model, @RequestParam int id,@RequestParam String name,
			@RequestParam String password, @RequestParam String email) {

			User u = userService.GetUserById(id);
			if(email != "") {
				u.setEmail(email);
			}
			if(name != "") {
				u.setName(name);
			}
			if(password != "") {
			u.setPassword(password);
			}
			userService.UpdateUser(u);
		
			List<User> us = new ArrayList<>();		
			us.add(u);
			model.addAttribute("users", us );    
		
        	return "users";
	}
}
