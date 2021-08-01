package com.ajusworks.poc.dbgraph.dao.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.ajusworks.poc.dbgraph.dao.model.User;

public interface UserRepository extends CassandraRepository<User, String>{

}
