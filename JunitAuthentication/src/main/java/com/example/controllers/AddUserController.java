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
import com.example.services.UserService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Controller
public class AddUserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/AddUser", method = RequestMethod.POST)
	public String showUsers(ModelMap model,@RequestParam String name,
			@RequestParam String password) {

		if(name != "" && password != "") {
			User u = new User();
			u.setName(name);
			u.setPasscode(password);
			userService.UpdateUser(u);
        	return "newentry";
		} else {
			return "inputerror";
		}
	}
}
