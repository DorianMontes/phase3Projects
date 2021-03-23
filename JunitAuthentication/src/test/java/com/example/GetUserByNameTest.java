package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entities.User;
import com.example.services.UserService;

@SpringBootTest
class GetUserByNameTest {
	
	@Autowired
	private UserService userService;

	@Test
	void test() {
		User us = new User();
		us.setName("dummyname");
		us.setPasscode("dummypassword");
		userService.UpdateUser(us);
		User u = new User();
		u = userService.GetUserByName("dummyname");
		assertEquals(u.getName(),"dummyname");
	}

}
