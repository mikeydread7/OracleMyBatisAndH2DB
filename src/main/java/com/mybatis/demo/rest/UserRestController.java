package com.mybatis.demo.rest;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mybatis.demo.constants.UtilContsants;
import com.mybatis.demo.model.ModelResponse;
import com.mybatis.demo.model.User;
import com.mybatis.demo.model.UserList;
import com.mybatis.demo.service.UserService;
import com.mybatis.demo.validators.ValidateInput;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//http://localhost:8091/swagger-ui.html - ui
//http://localhost:8091/v2/api-docs
@RestController
@RequestMapping("/mybatis/v2")
public class UserRestController {

	// *************************************************************************************************
	// Constants
	private final Logger LOG = LoggerFactory.getLogger(UserRestController.class);
	private final Gson gson = new GsonBuilder().create();
	private final ObjectMapper objectMapper = new ObjectMapper();
	// *************************************************************************************************
	// member variables
	private UserService userService;

	// *************************************************************************************************
	// Constructors
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	// Implementation
	@ApiOperation(value = "Find a user by id", notes = "Retrive User Information", response = User.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved user"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/findUser/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getUser(@PathVariable Integer userId) {
		LOG.debug("findUser: {}", userId);
		return new ResponseEntity<>(userService.selectUserById(userId), HttpStatus.OK);
	}

	@ApiOperation(value = "Find  list of users", notes = "Retrive All User Information", response = UserList.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved users list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/findAllUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getAllUser() {
		LOG.debug("findAllUser:");
		return new ResponseEntity<>(userService.selectAllUsers(), HttpStatus.OK);
	}

	@ApiOperation(value = "delete user by id", notes = "delete user by id")
	@RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
		LOG.debug("deletUser: {}", userId);
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Add a user", httpMethod = "POST", notes = "Insert new User")
	@RequestMapping(value = "/insertNewUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> insertNewUser(@RequestBody User user)
			throws JsonParseException, JsonMappingException, IOException {

		String jsonLikeString = objectMapper.writeValueAsString(user);
		LOG.debug("insert new user: {}", jsonLikeString);
		ModelResponse obj = gson.fromJson("{}", ModelResponse.class);
		if (ValidateInput.jsonCanBeTrusted(jsonLikeString) || null == jsonLikeString) {
			obj.setError(UtilContsants.INVALID_USER_OBJ);
			obj.setSatus(UtilContsants.FAILED);
			return new ResponseEntity<>(obj, HttpStatus.BAD_REQUEST);
		}
		userService.saveUser(user);
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@ApiOperation(value = "update a users info", httpMethod = "POST", notes = "Update User")
	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> saveOrUpdateUser(@RequestBody User user)
			throws JsonParseException, JsonMappingException, IOException {

		String jsonLikeString = objectMapper.writeValueAsString(user);
		LOG.debug("save or update: {}", jsonLikeString);
		ModelResponse obj = gson.fromJson("{}", ModelResponse.class);
		if (ValidateInput.jsonCanBeTrusted(jsonLikeString) || null == jsonLikeString) {
			obj.setError(UtilContsants.INVALID_USER_ID);
			obj.setSatus(UtilContsants.FAILED);
			return new ResponseEntity<>(obj, HttpStatus.BAD_REQUEST);
		}
		userService.updateUser(user);
		return new ResponseEntity<>(obj, HttpStatus.ACCEPTED);
	}

}

// 349 -288