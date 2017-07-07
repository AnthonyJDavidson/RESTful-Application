package com.anthony.persistence.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.anthony.model.Message;
import com.anthony.persistence.dao.MessagesDao;
import com.anthony.persistence.mapper.MessageMapper;

public class MessagesJdbcDaoImpl implements MessagesDao {

	/** Named JDBC template. */
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/** Contact lookup SQL. */
	final String SQL_GET_MESSAGE = "select * from messages";

	/**
	 * Returns list of warrants that user can access for given customerNumber
	 * 
	 * @param username User of RES
	 * @param customerNumber Customer Number to look up
	 * @return list of warrants for given customerNumber
	 */
	public ArrayList<Message> getMessages() {
		ArrayList<Message> messageList = new ArrayList<Message>();

		try {
			MapSqlParameterSource params = new MapSqlParameterSource();

			List<Map<String, Object>> rows = namedParameterJdbcTemplate.queryForList(SQL_GET_MESSAGE, params);
			if (rows != null) {
				for (Map<String, Object> row : rows) {
					messageList.add(MessageMapper.mapRow(row));
				}
			}

		} catch (EmptyResultDataAccessException erdae) {
			/* log something */
		}

		return messageList;
	}


	public void insertMessage(Message message) {
		String query = "INSERT INTO messages (id) VALUES (:id)";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("id", Integer.valueOf(message.getId()));
		namedParameterJdbcTemplate.update(query, namedParameters);
	}
	
	/**
	 * @param namedParameterJdbcTemplate the namedParameterJdbcTemplate to set
	 */
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
}