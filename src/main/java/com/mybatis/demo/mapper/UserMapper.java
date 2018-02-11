package com.mybatis.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mybatis.demo.model.User;

@Mapper
public interface UserMapper {
	static final String selectStr = "userId, userName, eyeColor, height, weight, birthday ,userAge";

	@Select("select " + selectStr + " from USER_DB where userId=#{userId}")
	User findOneUser(int userId);

	@Select("select " + selectStr + " from USER_DB")
	List<User> findAllUsers();

	@Insert("INSERT into USER_DB VALUES (user_id_seq.nextval, #{User.userName},#{User.eyeColor},"
			+ "#{User.height},#{User.weight},#{User.birthday},#{User.userAge} )")
	void insertUser(@Param("User") User user);

	@Update("UPDATE USER_DB SET userName=#{User.userName}, eyeColor=#{User.eyeColor}, "
			+ "height=#{User.height}, weight=#{User.weight}, birthday=#{User.birthday}, "
			+ "userAge=#{User.userAge} where userId=#{id}")
	void saveOrUpdateUser(@Param("User") User user, @Param("id") int id);

	@Delete("DELETE FROM USER_DB WHERE userId=#{id}")
	void deleteUser(@Param("id") int id);

	default List<User> defaultFindAll() {
		return findAllUsers();
	}

}
