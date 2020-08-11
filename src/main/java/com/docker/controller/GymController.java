package com.docker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.docker.dao.MessageDAO;
import com.docker.entity.Message;
import com.docker.service.MessageService;
@Controller
public class GymController {
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	@GetMapping("/registration")
	public String registrationPage() {
		return "registration";
	}
	@GetMapping("/signin")
	public String signinPage() {
		return "login";
	}
	@GetMapping("/contactus")
	public String showContact(Model theModel) {
		Message message = new Message();
		theModel.addAttribute("message",message);
		return "contact";
	}

	@PostMapping("/sendmessage")
	public String sendMessage(@ModelAttribute("message")Message message) {
		messageService.saveMessage(message);
		return "redirect:/";
	}
}
