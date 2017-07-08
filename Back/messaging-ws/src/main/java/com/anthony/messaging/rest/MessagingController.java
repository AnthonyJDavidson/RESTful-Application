package com.anthony.messaging.rest;

import java.util.ArrayList;

import com.anthony.model.Message;
import com.anthony.service.impl.MessagingServiceImpl;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST endpoint for messaging webservice
 * 
 * @author Anthony
 *
 */
@RestController
public class MessagingController {

	/**
	 * Messaging service for database calls
	 */
	MessagingServiceImpl messageService = new MessagingServiceImpl();

	/**
	 * The logger
	 */
	final static Logger logger = Logger.getLogger(MessagingController.class);
	
	/**
	 * Get all messages
	 * @return
	 */
	@RequestMapping(value = "/messages", method = RequestMethod.GET, headers = "Accept=application/json")
	public ArrayList<Message> getMessages() {
		logger.info("call to endpoint getmessages");
		return messageService.getMessages();
	}

	@RequestMapping(value = "/messages", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addMessage(@RequestBody Message message) {
		messageService.addMessage(message);
	}
}