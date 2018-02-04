package com.mybatis.demo.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybatis.demo.OracleH2MemoryMyBatisApplication;
import com.mybatis.demo.constants.MockListOfUsers;
import com.mybatis.demo.mapper.UserMapper;
import com.mybatis.demo.model.User;
import com.mybatis.demo.repository.UserRepository;
import com.mybatis.demo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OracleH2MemoryMyBatisApplication.class)
public class UserRestIntegrationControllerPostDeleteUpdateTest implements MockListOfUsers {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
	@Mock
	private UserMapper userMapper;

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserService userService;

	@InjectMocks
	private UserRestController userRestController;
	private final String apiRoot = "/mybatis/v2";
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		userRepository = new UserRepository(userMapper);
		userService = new UserService(userRepository);
		when(userMapper.getAllUser()).thenReturn(mockEntityUserList);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFailToPostAUser() throws Exception {
        User user = new User();
        String jsonLikeString = objectMapper.writeValueAsString(user);
		assertThat(this.userService).isNotNull();
		mockMvc.perform(post(apiRoot.concat("/user/"))
				.contentType(MediaType.APPLICATION_JSON)
                .content(jsonLikeString))
				.andExpect(status().isConflict());
	    verify(userService, times(1)).exists(user);
	    verifyNoMoreInteractions(userService);
		
	}

}