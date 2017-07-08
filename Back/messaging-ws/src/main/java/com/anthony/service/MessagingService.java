package com.anthony.service;

import java.util.ArrayList;

import com.anthony.model.Message;

/**
 * Messaging service to deal with getters and setters through the database
 */
public interface MessagingService {

	/**
	 * Method adds message to the database
	 * 
	 * @param message Message to save
	 */
	public void addMessage(Message message);

	/**
	 * Calls database to get messages
	 * 
	 * @return ArrayList of message objects
	 */
	public ArrayList<Message> getMessages();
}