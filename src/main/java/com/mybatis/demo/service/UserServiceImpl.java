package com.mybatis.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mybatis.demo.model.User;
import com.mybatis.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mybatis.demo.service.IUserservice#selectUserById(int)
	 */
	@Override
	public User selectUserById(int userId) {

		return userRepository.selectUserById(userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mybatis.demo.service.IUserservice#saveUser(com.mybatis.demo.model.
	 * User)
	 */
	@Override
	public void saveUser(User user) {
		userRepository.insertUser(user);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mybatis.demo.service.IUserservice#deleteUser(int)
	 */
	@Override
	public void deleteUser(int userId) {
		userRepository.deleteUser(userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mybatis.demo.service.IUserservice#updateUser(com.mybatis.demo.model.
	 * User, int)
	 */
	@Override
	public void updateUser(User user, int id) {
		userRepository.saveOrUpdateUser(user, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mybatis.demo.service.IUserservice#selectAllUsers()
	 */
	@Override
	public List<User> selectAllUsers() {

		return userRepository.selectUserAllUsers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mybatis.demo.service.IUserservice#exists(com.mybatis.demo.model.User)
	 */
	@Override
	public Boolean exists(User user) {
		return (null == userRepository.selectUserById(user.getUserId()));

	}
}
