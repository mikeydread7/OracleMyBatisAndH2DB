package com.mybatis.demo.repository;

import java.util.List;

import com.mybatis.demo.model.User;

public interface UserRepository {

	User selectUserById(int userId);

	void saveOrUpdateUser(User user, int id);

	void insertUser(User user);

	void deleteUser(int userId);

	List<User> selectUserAllUsers();

}