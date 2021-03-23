package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.entities.User;
import com.example.repositories.UserRepository;

@DataJpaTest
class UserRepo {

	@Autowired
	private UserRepository userService;
	@Test
	void test() {
		User u = new User();
		u.setName("dummyname");
		u.setPasscode("dummypassword");
		userService.save(u);
		System.out.println(u.getId());
		userService.findById(1);
		assertNotNull(userService.findById(1));
	}

}
