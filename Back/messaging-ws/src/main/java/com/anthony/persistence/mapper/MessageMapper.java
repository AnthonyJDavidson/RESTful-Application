package com.anthony.persistence.mapper;



import java.util.Map;

import com.anthony.model.Message;

public class MessageMapper {
	
	public static Message mapRow(Map<String, Object> row) {
		final Message message = new Message();

//		warrantDetails.setCustomerNumber((String)row.get("customernumber"));
//		warrantDetails.setEnforcementBailiwick((String)row.get("enforcementbailiwick"));
//		warrantDetails.setName((String)row.get("name"));
//		warrantDetails.setWarrantPos1((String)row.get("warrantpos1"));
//		warrantDetails.setWarrantNo((String)row.get("warrantno"));
//		warrantDetails.setResUser((String)row.get("userid"));

		return message;
	}

}
