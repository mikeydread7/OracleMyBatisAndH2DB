package com.mybatis.demo.model;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.function.Consumer;

import com.mybatis.demo.rest.UserRestController;
public class UserResourceAssembler {

	
	public static List<User> assembleLink(List<User> jsonPayLoad) {
    	
		jsonPayLoad.stream().forEach(buildTheLink("self"));
		jsonPayLoad.stream().forEach(buildTheLink("username"));
		return jsonPayLoad;
	}

	/**
	 * @return
	 */
	private static Consumer<? super User> buildTheLink(String isSelf) {
		return (isSelf.contains("self")) 
				?e->e.add(linkTo(methodOn(UserRestController.class).getAllUser())
    							.slash(e.getUserId()).withRel(e.getUserName()))
				: e->e.add(linkTo(methodOn(UserRestController.class).getAllUser())
	    							.withSelfRel());
	}
	
}