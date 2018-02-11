package com.mybatis.demo.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.mybatis.demo.constants.MockListOfUsers;
import com.mybatis.demo.mapper.UserMapper;
import com.mybatis.demo.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	private UserMapper useMapper;

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAll() {
		when(userRepository.selectUserAllUsers()).thenReturn(MockListOfUsers.mockEntityUserList);
		assertTrue(userService.selectAllUsers().size() > 1);
		verify(userRepository, times(1)).selectUserAllUsers();
	}

	@Test
	public void testById() {
		int userId = 2;
		when(userRepository.selectUserById(userId)).thenReturn(MockListOfUsers.mockEntityUserList.stream()
				.filter(e -> e.getUserId().intValue() == userId).findFirst().orElse(null));
		assertTrue(userService.selectUserById(userId).getEyeColor().equals("brown"));
		verify(userRepository, times(1)).selectUserById(userId);
	}

	@Test
	public void testFindById() {
		int userId = 3;
		when(userRepository.selectUserById(userId)).thenReturn(MockListOfUsers.mockEntityUserList.stream()
				.filter(e -> e.getUserId().intValue() == userId).findFirst().orElse(null));
		assertTrue(userService.selectUserById(userId).getUserName().equals("FOOBAR"));

	}
}
