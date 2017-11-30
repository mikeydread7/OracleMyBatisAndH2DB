package com.mybatis.demo.constants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mybatis.demo.model.User;

public interface MockListOfUsers {
    
	@SuppressWarnings("serial")
	List<User> mockEntityUserList = new ArrayList<User>() {
		{	
			add(new User( "FOO", "brown", 3, 120,(java.sql.Date) new Date(), 3));
			add(new User( "BAR", "brown", 4, 150,(java.sql.Date) new Date(), 4));
			add(new User( "FOOBAR", "brown", 5, 170,(java.sql.Date) new Date(),  5));
			add(new User( "BARFOO", "brown", 6, 132, (java.sql.Date)new Date(),  6));
		}
	};
	
}