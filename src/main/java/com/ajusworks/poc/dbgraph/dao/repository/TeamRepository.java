package com.ajusworks.poc.dbgraph.dao.repository;


import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.ajusworks.poc.dbgraph.dao.model.Team;

public interface TeamRepository  extends CassandraRepository<Team,String>{

	List<Team> findByEntityIdIn(List<String> ids);
}
