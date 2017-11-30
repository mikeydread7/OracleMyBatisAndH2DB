/*package com.mybatis.demo;

import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String password ="secret";
		Md5PasswordEncoder passwordEncoder=  new Md5PasswordEncoder();
		passwordEncoder.encodePassword(password, null);
	}
	
	@Test
	public void testBrypt() {
		String password ="userVader";
		BCryptPasswordEncoder passwordEncoder=  new BCryptPasswordEncoder();
		passwordEncoder.encode(password);
	}
	
	@Test
	public void testDeCryptBrypt() {
		String passwordUsedToLogIn ="secret";
		String hashedPassStoredInDb ="$2a$10$kRoS6E2e6RzVu.AHJVEBwOIqs6pmQFkzSM9NIE50n9whIgCeJNOGq";
		String anotherHashPassStoredInDb = "$2a$10$lq7/qTH.Pws51kYd8Sqf0uKJniPMsfcgGUCKWdkl5Wvuj971Ski/i";
		assertTrue( BCrypt.checkpw(passwordUsedToLogIn, hashedPassStoredInDb));
		assertTrue( BCrypt.checkpw(passwordUsedToLogIn, anotherHashPassStoredInDb));
	}
	
	

}
*/