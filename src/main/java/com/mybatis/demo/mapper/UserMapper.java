package com.mybatis.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mybatis.demo.model.User;

@Mapper
public interface UserMapper {

	@Select("select * from USER_DB where userId=#{userId}")
	public User queryUserById(int userId);
	
	@Select("select * from USER_DB")
	public List<User> getAllUser();
}
