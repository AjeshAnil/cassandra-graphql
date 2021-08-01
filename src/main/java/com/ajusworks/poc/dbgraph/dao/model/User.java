package com.ajusworks.poc.dbgraph.dao.model;

import java.util.ArrayList;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Data
@Table
public class User {
	
	@PrimaryKey
	String entityId;

	Info displayInfo;

	String username;
	
	ArrayList<String> chatIds;
	
	ArrayList<String> teamIds;

}
