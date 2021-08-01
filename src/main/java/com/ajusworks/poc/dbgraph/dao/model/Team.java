package com.ajusworks.poc.dbgraph.dao.model;

import java.util.ArrayList;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Data
@Table
public class Team {
	
	@PrimaryKey
	String entityId;
		
	Info displayInfo;
	
	String teamName;
	
	ArrayList<String> chatIds;
		
	ArrayList<String> memberIds;

}
