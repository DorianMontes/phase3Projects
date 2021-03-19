package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entities.Feedback;
import com.example.services.FeedbackService;


@Controller
public class TestFormController {

	 @Autowired
	 FeedbackService feedbackService;
	
	 @GetMapping(value="/testform")
     public String showTestForm(ModelMap model) {  
		 return "testformjsp";
     }
	 
	 @RequestMapping(value = "/testform", method = RequestMethod.POST)
		public String showUsers(ModelMap model, @RequestParam String user,
				@RequestParam int rating, @RequestParam String comments) {
		 System.out.println("0");
			if(user != "" && 0 < rating && rating < 6 && comments != "") {
			    Feedback feed = new Feedback();
			    System.out.println("1");
			    feed.setUser(user);
			    System.out.println("2");
			    feed.setRating(rating);
			    System.out.println("3");
			    feed.setComments(comments);
			
				List<Feedback> us = new ArrayList<>();		
				us.add(feed);
				System.out.println("4");
				model.addAttribute("tabletest", us);
				System.out.println("5");
	        	return "tabletest";
			} else {
				return "error";
			}
	 
	 }
}