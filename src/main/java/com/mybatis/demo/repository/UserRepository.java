package com.mybatis.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis.demo.mapper.UserMapper;
import com.mybatis.demo.model.User;

@Repository
public class UserRepository {

	@Autowired
	private UserMapper userMapper;

	public UserRepository(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public User selectUserById(int userId) {
		User user = userMapper.queryUserById(userId);
		return user;
	}

	public void saveOrUpdateUser(User user, int id) {
		
		userMapper.saveOrUpdateUser(user, id);
	}

	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	public void deleteUser(int userId) {
		userMapper.deleteUser(userId);
	}

	public List<User> selectUserAllUsers() {
		return userMapper.getAllUser();

	}
}
