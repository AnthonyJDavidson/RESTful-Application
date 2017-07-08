package com.anthony.persistence.mapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.anthony.model.Message;

/**
 * Mapper to convert from result set row to Message Class
 * 
 * @author Anthony
 * @param ResultSet row of database to map to Message object
 * @throws SQLException
 *
 */
public class MessageMapper {

	public static Message mapRow(ResultSet rs) throws SQLException {
		final Message message = new Message();

		message.setId((Integer) rs.getInt("id"));
		message.setAmountBuy((BigDecimal) rs.getBigDecimal("amountBuy"));
		message.setAmountSell((BigDecimal) rs.getBigDecimal("amountSell"));
		message.setRate((BigDecimal) rs.getBigDecimal("rate"));
		message.setUserId((String) rs.getString("userId"));
		message.setCurrencyFrom((String) rs.getString("currencyFrom"));
		message.setCurrencyTo((String) rs.getString("currencyTo"));
		message.setOriginatingCountry((String) rs.getString("originatingCountry"));

		Date date = new Date(rs.getTimestamp("timePlaced").getTime());
		message.setTimePlaced(date);

		return message;
	}

}
