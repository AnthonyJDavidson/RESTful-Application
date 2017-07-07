package com.anthony.persistence.dao;

import java.util.List;

import com.anthony.model.Message;

public interface MessagesDao {

	public List<Message> getMessages();

	public void insertMessage(Message message);
}
