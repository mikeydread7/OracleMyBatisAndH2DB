package com.mybatis.demo.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mybatis.demo.constants.MockListOfUsers;
import com.mybatis.demo.utils.RESTFulHelper;
import com.mybatis.demo.utils.ValidateInput;

public class RESTFulHelperTest {

	@Test
	public void testRestFullHelperISODATE() throws JsonProcessingException {
		assertTrue(
				RESTFulHelper.getISOTimeStamp(MockListOfUsers.mockEntityUserList.get(2).getBirthday()).contains("Z"));
	}

	@Test
	public void testRestFullHelperGotGoodJSON() throws JsonProcessingException {
		assertTrue(ValidateInput
				.jsonCanBeTrusted(RESTFulHelper.getJsonLikeString(MockListOfUsers.mockEntityUserList.get(3))));
	}
}
