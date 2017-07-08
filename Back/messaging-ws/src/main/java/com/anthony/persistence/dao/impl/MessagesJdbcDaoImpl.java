package com.anthony.persistence.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;

import com.anthony.model.Message;
import com.anthony.persistence.dao.MessagesDao;
import com.anthony.persistence.mapper.MessageMapper;

/**
 * Dao for messages database
 * @author Anthony
 *
 */
public class MessagesJdbcDaoImpl implements MessagesDao {

	/**
	 * Logger
	 */
	final static Logger logger = Logger.getLogger(MessagesJdbcDaoImpl.class);

	/**
	 * Select query
	 */
	private static final String SELECT_SQL = "SELECT * FROM messagesTable;";

	/**
	 * Insert query with wildcards
	 */
	private static final String INSERT_MESSAGE_SQL = "insert into messagesTable (userId, "
			+ "currencyFrom, currencyTo, amountSell, amountBuy, rate, timePlaced, originatingCountry)"
			+ " values (?,?,?,?,?,?,?,?);";

	/**
	 * Returns all messages in the database
	 * 
	 * @return ArrayList type List of Message objects
	 */
	public ArrayList<Message> getMessages() {

		ArrayList<Message> messageList = new ArrayList<Message>();
		Connection c = null;
		Statement stmt = null;
		try {
			logger.info("Getting all messages from messages db with SQL: " + SELECT_SQL);

			c = createConnection();
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_SQL);
			while (rs.next()) {
				Message message = MessageMapper.mapRow(rs);
				messageList.add(message);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (SQLException e) {
			logger.error("Error Mapping row to message " + e.getMessage());
		} catch (Exception e) {
			logger.error("Error connecting to db with stacktrace: " + e.getMessage());
		}
		return messageList;
	}

	/** 
	 * Insert into database 
	 * 
	 * @param Message message object to place in database
	 * @return void
	 */
	public void insertMessage(Message message) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			logger.info("Attempting insert into messagesTable message: " + message + "+ with message sql: " + INSERT_MESSAGE_SQL);

			c = createConnection();
			ps = c.prepareStatement(INSERT_MESSAGE_SQL);
			ps.setString(1, message.getUserId());
			ps.setString(2, message.getCurrencyFrom());
			ps.setString(3, message.getCurrencyTo());
			ps.setBigDecimal(4, message.getAmountSell());
			ps.setBigDecimal(5, message.getAmountBuy());
			ps.setBigDecimal(6, message.getRate());

			// convert date to timestamp
			Timestamp ts = new Timestamp(message.getTimePlaced().getTime());
			ps.setTimestamp(7, ts);

			ps.setString(8, message.getOriginatingCountry());
			ps.execute();

			logger.info("Insert to database worked");
			c.commit();
			c.close();
		} catch (SQLException e) {
			logger.error("Error Mapping row to message " + e.getMessage());
		} catch (Exception e) {
			logger.error("Error connecting to db with stacktrace: " + e.getMessage());
		}
	}

	/**
	 * Create database connection
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private Connection createConnection() throws ClassNotFoundException, SQLException {
		Connection c;
		Class.forName("org.postgresql.Driver");
		c = DriverManager.getConnection(
				"jdbc:postgresql://messagedb.cenfqu7vhajp.eu-west-1.rds.amazonaws.com:5432/message_db", "messagedb",
				"m3ssagedb");
		c.setAutoCommit(false);
		return c;
	}

	// Forget the wiring with spring context, it's too hard in short amount of
	// time.....

	// /** Named JDBC template. */
	// @Autowired
	// private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	//
	// /** Contact lookup SQL. */
	// final String SQL_GET_MESSAGE = "select * from messages";
	//
	// /**
	// * Returns list of warrants that user can access for given customerNumber
	// *
	// * @param username User of RES
	// * @param customerNumber Customer Number to look up
	// * @return list of warrants for given customerNumber
	// */
	// public ArrayList<Message> getMessages() {
	// ArrayList<Message> messageList = new ArrayList<Message>();
	//
	// try {
	// MapSqlParameterSource params = new MapSqlParameterSource();
	//
	// List<Map<String, Object>> rows =
	// namedParameterJdbcTemplate.queryForList(SQL_GET_MESSAGE, params);
	// if (rows != null) {
	// for (Map<String, Object> row : rows) {
	// messageList.add(MessageMapper.mapRow(row));
	// }
	// }
	//
	// } catch (EmptyResultDataAccessException erdae) {
	// /* log something */
	// }
	//
	// return messageList;
	// }
	//
	//
	// /**
	// * @param namedParameterJdbcTemplate the namedParameterJdbcTemplate to set
	// */
	// public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate
	// namedParameterJdbcTemplate) {
	// this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	// }
}