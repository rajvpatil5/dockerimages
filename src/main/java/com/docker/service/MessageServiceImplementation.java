package com.docker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docker.dao.MessageDAO;
import com.docker.entity.Message;

@Service
public class MessageServiceImplementation implements MessageService{

	@Autowired
	private MessageDAO messageDAO;
	

	public void saveMessage(Message message) {
		messageDAO.save(message);
	}

}
