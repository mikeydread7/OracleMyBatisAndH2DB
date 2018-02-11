package com.mybatis.demo.repository;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.mybatis.demo.constants.MockListOfUsers;
import com.mybatis.demo.mapper.UserMapper;
import com.mybatis.demo.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryImplTest implements MockListOfUsers {

	// @Resource
	@Mock
	private UserMapper userMapperMock;

	@InjectMocks
	private UserRepositoryImpl userRepository;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindTAllUser() {
		when(userMapperMock.findAllUsers()).thenReturn(MockListOfUsers.mockEntityUserList);
		assertTrue(userRepository.selectUserAllUsers().size() > 0);
		verify(userMapperMock, times(1)).findAllUsers();
	}

	@Test
	public void testFindOneUserById() {
		when(userMapperMock.findOneUser(2)).thenReturn(
				MockListOfUsers.mockEntityUserList.stream().filter(e -> e.getUserId() == 2).findFirst().orElse(null));

		User user = userRepository.selectUserById(2);
		assertTrue(user != null && user.getEyeColor() != null);
		verify(userMapperMock, times(1)).findOneUser(2);
	}

	@Test
	public void testSaveUser() {

		doNothing().when(userMapperMock).insertUser(MockListOfUsers.mockEntityUserList.get(1));
		userRepository.insertUser(MockListOfUsers.mockEntityUserList.get(1));

		verify(userMapperMock, times(1)).insertUser(MockListOfUsers.mockEntityUserList.get(1));
		verify(userMapperMock, never()).deleteUser(1);
	}

	@Test
	public void testSaveOrUpdate() {
		User user = MockListOfUsers.mockEntityUserList.get(1);
		doNothing().when(userMapperMock).saveOrUpdateUser(user, user.getUserId());
		userRepository.saveOrUpdateUser(user, user.getUserId());

		verify(userMapperMock, times(1)).saveOrUpdateUser(user, user.getUserId());
		;
		verify(userMapperMock, never()).deleteUser(user.getUserId());
		verify(userMapperMock, never()).findOneUser(user.getUserId());
	}

}
