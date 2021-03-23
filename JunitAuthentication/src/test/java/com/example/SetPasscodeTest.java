package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.entities.User;

class SetPasscodeTest {

	@Test
	void test() {
		User u = new User();
		u.setName("dummyname");
		u.setPasscode("dummypassword");
		assertEquals(u.getPasscode(),"dummypassword");
	}

}
