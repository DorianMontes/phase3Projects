package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.entities.User;
import com.example.repositories.UserRepository;

@DataJpaTest
public class UserFindByNameTest {

	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void testGetUserByName() {
		User u = new User();
		u.setName("dummyname");
		u.setPasscode("dummypassword");
		userRepo.save(u);
		User us = userRepo.findByName("dummyname");
		assertEquals(us.getPasscode(),"dummypassword");
	}

}
