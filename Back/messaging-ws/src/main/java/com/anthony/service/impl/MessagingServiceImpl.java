package com.anthony.service.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.anthony.model.Message;
import com.anthony.persistence.dao.impl.MessagesJdbcDaoImpl;
import com.anthony.service.MessagingService;

/**
 * Messaging service that deals with calling database
 * 
 * @author Anthony
 */
public class MessagingServiceImpl implements MessagingService {

	/**
	 * The logger
	 */
	final static Logger logger = Logger.getLogger(MessagingServiceImpl.class);

	/**
	 * Messages Database
	 */
	private MessagesJdbcDaoImpl messagesDao = new MessagesJdbcDaoImpl();

	/**
	 * Method adds message to the database
	 * 
	 * @param message Message to save
	 */
	public void addMessage(Message message) {
		messagesDao.insertMessage(message);
	}

	/**
	 * Calls database to get messages
	 * 
	 * @return ArrayList of message objects
	 */
	public ArrayList<Message> getMessages() {
		return messagesDao.getMessages();
	}
}