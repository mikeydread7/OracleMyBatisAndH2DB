package com.mybatis.demo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mybatis.demo.model.User;

@Mapper
public interface UserMapper {
	static final String selectStr = "userId, userName, eyeColor, height, weight, birthday ,userAge";

	@Select("select " + selectStr + " from USER_DB where userId=#{userId}")
	User queryUserById(int userId);

	@Select("select " + selectStr + " from USER_DB")
	List<User> getAllUser();

	@Insert("INSERT into USER_DB VALUES (userIDs_ID.nextval, #{userName},#{eyeColor},"
			+ "#{height},#{weight},#{birthday},#{userAge} )")
	void insertUser(User user);

	@Update("UPDATE USER_DB SET userName=#{userName}, eyeColor=#{eyeColor}, "
			+ "height=#{height}, weight=#{weight}, birthday=#{birthday}, "
			+ "userAge=#{userAge} where userId=#{userId}")
	void saveOrUpdateUser(User user);

	@Delete("DELETE FROM USER_DB WHERE userId=#{userId}")
	void deleteUser(int id);
}
