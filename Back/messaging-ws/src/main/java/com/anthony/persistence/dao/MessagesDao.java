package com.anthony.persistence.dao;

import java.util.ArrayList;

import com.anthony.model.Message;

public interface MessagesDao {

	public ArrayList<Message> getMessages();

	public void insertMessage(Message message);
}
