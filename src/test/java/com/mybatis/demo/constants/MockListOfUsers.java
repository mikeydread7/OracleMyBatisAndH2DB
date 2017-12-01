package com.mybatis.demo.constants;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.test.context.ActiveProfiles;

import com.mybatis.demo.model.User;

@ActiveProfiles("h2")
public interface MockListOfUsers {

	@SuppressWarnings("serial")
	List<User> mockEntityUserList = new ArrayList<User>() {
		{
			add(new User(1, "FOO", "brown", 3, 120, new Date(1003L), 3));
			add(new User(2, "BAR", "brown", 4, 150, new Date(1020L), 4));
			add(new User(3, "FOOBAR", "brown", 5, 170, new Date(1300L), 5));
			add(new User(4, "BARFOO", "brown", 6, 132, new Date(1050L), 6));
		}
	};

}