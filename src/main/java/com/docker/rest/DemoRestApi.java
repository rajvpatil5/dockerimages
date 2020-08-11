package com.docker.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docker.dao.MessageDAO;
import com.docker.entity.Message;

@RestController
@RequestMapping("/api")
public class DemoRestApi {

	@Autowired
	private MessageDAO messageDAO;
	
	@GetMapping("/docker")
	public String showApi() {
		return "This is best api ever which will run on docker engine";
	}
	
	@GetMapping("/message")
	public List<Message> showMessage() {
		return messageDAO.findAll();
	}
}
