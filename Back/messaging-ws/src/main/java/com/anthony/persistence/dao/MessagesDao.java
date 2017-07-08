package com.anthony.persistence.dao;

import java.util.ArrayList;

import com.anthony.model.Message;

/**
 * Dao for messages database
 * @author Anthony
 *
 */
public interface MessagesDao {

	/**
	 * Returns all messages in the database
	 * 
	 * @return ArrayList type List of Message objects
	 */
	public ArrayList<Message> getMessages();

	/** 
	 * Insert into database 
	 * 
	 * @param Message message object to place in database
	 * @return void
	 */
	public void insertMessage(Message message);
}
