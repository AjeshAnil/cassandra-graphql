package com.ajusworks.poc.dbgraph.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajusworks.poc.dbgraph.dao.model.User;
import com.ajusworks.poc.dbgraph.service.UserGraphqlService;

@RestController("/api")
public class UserController {

	@Autowired 
	UserGraphqlService userGraphqlService;
	
	@GetMapping(path = "/getUsers" , produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> getUsers(){
		return userGraphqlService.getUsers();
	}
	
	@GetMapping(path = "/getUser" , produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User getUserById(@RequestParam Optional<String> id ) {
		Optional<User> user = id.isPresent()? userGraphqlService.getUserByEntityId(id.get()): Optional.empty();
		 return user.orElse(null);
	}

}
