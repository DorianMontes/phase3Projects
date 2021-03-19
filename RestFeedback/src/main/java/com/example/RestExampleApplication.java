package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.entities.Feedback;
import com.example.repositories.FeedbackRepository;

@SpringBootApplication
@EnableJpaRepositories
public class RestExampleApplication {

	@Autowired
	
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(RestExampleApplication.class, args);
		FeedbackRepository feedbackRepository = ctx.getBean(FeedbackRepository.class);
		Feedback f1 = new Feedback();
		f1.setUser("dan");
		f1.setRating(3);
		f1.setComments("ok");
		feedbackRepository.save(f1);
	}

}
