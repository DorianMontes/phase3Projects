package com.example.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Feedback;
import com.example.repositories.FeedbackRepository;
import com.example.services.FeedbackService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@GetMapping("/feedback")
	public @ResponseBody Iterable<Feedback> getAllFeedbacks() {
        // This returns a JSON or XML with the Feedbacks
        return feedbackService.getAllFeedback();
    }
	
	
	@RequestMapping(value = "/feedback", method = RequestMethod.POST)
	public String showUsers(ModelMap model,@RequestParam String user,
			@RequestParam int rating, @RequestParam String comments) {

		if(user != "" && 0 < rating && rating < 6 && comments != "") {
		    Feedback feed = new Feedback();
		    feed.setUser(user);
		    feed.setRating(rating);
		    feed.setComments(comments);
			feedbackService.updateFeedback(feed);
		
			List<Feedback> us = new ArrayList<>();		
			us.add(feed);
			model.addAttribute("usersfeed", us );    
		
        	return "feedback received";
		} else {
			return "invalid input";
		}
	}
	

}
