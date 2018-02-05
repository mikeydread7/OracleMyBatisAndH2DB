package com.mybatis.demo.utils;



import java.sql.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mybatis.demo.model.User;

public class RESTFulHelperTest {

	public  static void main(String[] arg) throws JsonProcessingException {		
		User user = new User(5, "userName", "black", 60,120, new Date(200L),45);
		System.out.printf("1.orig:%s = REST:%s\n",user.getBirthday(),RESTFulHelper.getISOTimeStamp(user.getBirthday()));
		System.out.printf("2.%s\n",RESTFulHelper.getJsonLikeString(user));
	}

}
