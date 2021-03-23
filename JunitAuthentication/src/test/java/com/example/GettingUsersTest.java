package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entities.User;
import com.example.services.UserService;

@SpringBootTest
class GettingUsersTest {

	@Autowired
	private UserService userService;
	
	@Test
	void test() {
		User us = new User();
		us.setName("dummyname");
		us.setPasscode("dummypassword");
		userService.UpdateUser(us);
		Iterable<User> users = userService.GetAllUsers();
		
		Integer count = 0;
		for(User u: users) {
			count++;
		}
		
		assertNotEquals(count,0);
	}

}
