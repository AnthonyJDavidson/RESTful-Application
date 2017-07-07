package com.anthony.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.anthony.model.*;
import com.anthony.persistence.dao.impl.MessagesJdbcDaoImpl;

/*
 * It is just a helper class which should be replaced by database implementation.
 * It is not very well written class, it is just used for demonstration.
 */
public class MessagingService {

	static HashMap<Integer, Message> messageIdMap = getMessageIdMap();
	
	private MessagesJdbcDaoImpl messagesJdbcDaoImpl;

	public MessagingService() {
		super();
		messageIdMap = new HashMap<Integer, Message>();
	}

	public ArrayList<Message> getAllMessages() {
		ArrayList<Message> messages = new ArrayList<Message>(messageIdMap.values());
		return messages;
	}

	public Message getMessage(int id) {
		Message message = messageIdMap.get(id);
		return message;
	}

	public Message addMessage(Message message) {
		message.setId(getMaxId() + 1);
		messageIdMap.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0)
			return null;
		messageIdMap.put(message.getId(), message);
		return message;

	}

	public void deleteMessage(int id) {
		messageIdMap.remove(id);
	}

	public static HashMap<Integer, Message> getMessageIdMap() {
		return messageIdMap;
	}

	// Utility method to get max id
	public static int getMaxId() {
		int max = 0;
		for (int id : messageIdMap.keySet()) {
			if (max <= id)
				max = id;

		}
		return max;
	}
	
	public ArrayList<Message> getMessages() {
		return messagesJdbcDaoImpl.getMessages();
	}
}