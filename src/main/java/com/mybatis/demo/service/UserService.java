package com.mybatis.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.demo.model.User;
import com.mybatis.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userDao;

	public User selectUserById(int userId) {

		return userDao.selectUserById(userId);
	}

	public List<User> selectAllUsers() {

		return userDao.selectUserAllUsers();
	}
}
