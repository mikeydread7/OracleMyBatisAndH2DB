package com.mybatis.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mybatis.demo.model.User;
import com.mybatis.demo.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User selectUserById(int userId) {

		return userRepository.selectUserById(userId);
	}

	public void saveUser(User user) {
		userRepository.saveOrUpdateUser(user);
	}

	public void deleteUser(int userId) {
		userRepository.deleteUser(userId);
	}

	public void updateUser(User user) {
		userRepository.insertUser(user);
	}

	public List<User> selectAllUsers() {

		return userRepository.selectUserAllUsers();
	}
}
