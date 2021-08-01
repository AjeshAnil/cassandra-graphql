package com.ajusworks.poc.dbgraph.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ajusworks.poc.dbgraph.dao.model.Team;
import com.ajusworks.poc.dbgraph.dao.model.User;
import com.ajusworks.poc.dbgraph.dao.repository.TeamRepository;
import com.ajusworks.poc.dbgraph.dao.repository.UserRepository;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Component
@GraphQLApi
public class UserGraphqlService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TeamRepository teamRepository;

	@GraphQLQuery(name = "users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GraphQLQuery(name = "user")
	public Optional<User> getUserByEntityId(@GraphQLArgument(name = "id") String entityId) {
		return userRepository.findById(entityId);
	}

	@GraphQLQuery
	public List<Team> teamList(@GraphQLContext User user) {
		System.out.println("Getting TeamList");
		return teamRepository.findAllById(user.getTeamIds());
	}

}
