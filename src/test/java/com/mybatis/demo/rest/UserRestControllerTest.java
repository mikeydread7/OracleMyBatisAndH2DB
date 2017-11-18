package com.mybatis.demo.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mybatis.demo.model.User;
import com.mybatis.demo.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserRestControllerTest {

	@Mock
	private HttpServletRequest mockHttpServletRequest;
	@Mock
	private UserService userService;

	@InjectMocks
	private UserRestController userRestController;

	private static List<User> mockEntityUserList;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@SuppressWarnings("serial")
	@Before
	public void setUp() throws Exception {
		userRestController = new UserRestController(userService);

		mockEntityUserList = new ArrayList<User>() {
			{
				add(new User(1, "FOO", "brown", 3, 120, 3));
				add(new User(2, "BAR", "brown", 4, 150, 4));
				add(new User(3, "FOOBAR", "brown", 5, 170, 5));
				add(new User(4, "BARFOO", "brown", 6, 132, 6));
			}
		};

	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testAllUsers() {
		when(mockHttpServletRequest.getAttribute(anyString())).thenReturn("/findAllUser");
		when((userService.selectAllUsers())).thenReturn(mockEntityUserList);
		ResponseEntity<?> results = userRestController.getAllUser();
		assertTrue("Found values", ((List<User>) results.getBody()).size() == 4);
		assertEquals(HttpStatus.OK, results.getStatusCode());
	}

	@Test
	public void testFindUser() {

		Integer userId = 3;
		when(mockHttpServletRequest.getAttribute(anyString()))
				.thenReturn("/findUser/".concat(Integer.toString(userId)));
		when((userService.selectUserById(userId))).thenReturn(find(userId));
		ResponseEntity<?> results = userRestController.getUser(userId);
		assertTrue("Found values", ((User) results.getBody()).getUserAge().equals(5));
		assertEquals(HttpStatus.OK, results.getStatusCode());
	}

	@Test
	public void testFindUserAgain() {

		Integer userId = 4;
		when(mockHttpServletRequest.getAttribute(anyString()))
				.thenReturn("/findUser/".concat(Integer.toString(userId)));
		when((userService.selectUserById(userId))).thenReturn(find(userId));
		ResponseEntity<?> results = userRestController.getUser(userId);
		assertTrue("Found values", ((User) results.getBody()).getUserAge().equals(6));
		assertEquals(HttpStatus.OK, results.getStatusCode());
	}

	// *************************************************************************************************
	// Utility
	private User find(Integer UserId) {

		// mockEntityUserList.stream().filter(u->u.getUserId())

		for (User u : mockEntityUserList) {
			if (u.getUserId().equals(UserId))
				return u;
		}
		return new User();
	}
}
