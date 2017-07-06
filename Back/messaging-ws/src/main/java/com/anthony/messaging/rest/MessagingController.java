package com.anthony.messaging.rest;

import java.util.ArrayList;

import com.anthony.model.Message;
import com.anthony.service.MessagingService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagingController {

	MessagingService messageService = new MessagingService();

	@RequestMapping(value = "/messages", method = RequestMethod.GET, headers = "Accept=application/json")
	public ArrayList<Message> getMessages() {
		ArrayList<Message> listOfMessages = messageService.getAllMessages();
		return listOfMessages;
	}

	@RequestMapping(value = "/message/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Message getMessageById(@PathVariable Integer id) {
		return messageService.getMessage(id);
	}

	@RequestMapping(value = "/messages", method = RequestMethod.POST, headers = "Accept=application/json")
	public Message addMessage(@RequestBody Message message) {
		return messageService.addMessage(message);
	}

	@RequestMapping(value = "/messages", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Message updateMessage(@RequestBody Message message) {
		return messageService.updateMessage(message);

	}

	@RequestMapping(value = "/message/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteMessage(@PathVariable("id") Integer id) {
		messageService.deleteMessage(id);

	}
}