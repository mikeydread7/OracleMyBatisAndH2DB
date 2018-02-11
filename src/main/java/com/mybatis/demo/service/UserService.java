package com.mybatis.demo.service;

import java.util.List;

import com.mybatis.demo.model.User;

public interface UserService {

	User selectUserById(int userId);

	void saveUser(User user);

	void deleteUser(int userId);

	void updateUser(User user, int id);

	List<User> selectAllUsers();

	Boolean exists(User user);

}