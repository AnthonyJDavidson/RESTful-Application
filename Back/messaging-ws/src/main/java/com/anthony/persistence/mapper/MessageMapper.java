package com.anthony.persistence.mapper;



import java.math.BigDecimal;
import java.util.Map;

import com.anthony.model.Message;

public class MessageMapper {
	
	public static Message mapRow(Map<String, Object> row) {
		final Message message = new Message();

		message.setId((Integer)row.get("id"));
		message.setAmountBuy((BigDecimal)row.get("amountBuy"));
		message.setAmountSell((BigDecimal)row.get("amountSell"));
		message.setRate((BigDecimal)row.get("amountRate"));

		return message;
	}

}
