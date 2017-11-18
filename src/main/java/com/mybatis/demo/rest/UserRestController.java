package com.mybatis.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mybatis.demo.service.UserService;

@RestController
@RequestMapping("/v2")
public class UserRestController {

	// *************************************************************************************************
	// Constants
	private final Logger LOG = LoggerFactory.getLogger(UserRestController.class);
	// *************************************************************************************************
	// member variables
	private UserService userService;

	// *************************************************************************************************
	// Constructors
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	// Implementation
	@RequestMapping(value = "/findUser/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getUser(@PathVariable Integer userId) {
		LOG.debug("findUser: {}", userId);
		System.out.println("Success!!! h2db memory implementation.................");
		return new ResponseEntity<>(userService.selectUserById(userId), HttpStatus.OK);
	}

	@RequestMapping(value = "/findAllUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getAllUser() {
		LOG.debug("findAllUser:");
		System.out.println("Success!!! h2db memory implementation.................");
		return new ResponseEntity<>(userService.selectAllUsers(), HttpStatus.OK);
	}

}