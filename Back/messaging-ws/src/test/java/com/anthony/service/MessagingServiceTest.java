package com.anthony.service;


import java.util.ArrayList;
import junitx.util.PrivateAccessor;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.anthony.model.Message;
import com.anthony.persistence.dao.MessagesDao;
import com.anthony.service.impl.MessagingServiceImpl;


public class MessagingServiceTest {
	
	// service to test
	private MessagingServiceImpl service;
	
	// mock dao object
	private MessagesDao messagesDao;
	
	@Before
	public void setup() throws Exception {
		service = new MessagingServiceImpl();
		messagesDao = EasyMock.createMock(MessagesDao.class);
		PrivateAccessor.setField(service, "messagesDao", messagesDao);
	}
	
	/** Verifies functionality. */
	@Test
	@Ignore
	public void testGetMessages() {
		
		ArrayList<Message> messagesList = new ArrayList<Message>();
		Message message = new Message();
		messagesList.add(message);
		
		EasyMock.expect(messagesDao.getMessages()).andReturn(
				messagesList);
		EasyMock.replay(messagesDao);

		Assert.assertEquals(1, service.getMessages().size());
	}

}
