package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Feedback;

import com.example.repositories.*;

@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	public Iterable<Feedback> getAllFeedback() {
		return feedbackRepository.findAll();
	}
	
    public void updateFeedback(Feedback feedbacktoUpdate) {
    	feedbackRepository.save(feedbacktoUpdate);
    }
}