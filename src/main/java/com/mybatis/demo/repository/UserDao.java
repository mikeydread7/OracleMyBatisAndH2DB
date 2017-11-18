package com.mybatis.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis.demo.mapper.UserMapper;
import com.mybatis.demo.model.User;

@Repository
public class UserDao {

	@Autowired
	private UserMapper userMapper;
	
	public User selectUserById(int userId) {
		User user = userMapper.queryUserById(userId);
		return user;
   }
	public List<User> selectUserAllUsers() {
		return  userMapper.getAllUser();
		
   }
}
