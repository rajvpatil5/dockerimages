package com.docker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.docker.dao.UsersProfileDao;
import com.docker.entity.Message;
import com.docker.entity.UsersProfile;
import com.docker.service.MessageService;
import com.docker.service.UsersProfileServiceImpl;

@Controller
public class GymController {
	@Autowired
	private MessageService messageService;

	@Autowired
	private UsersProfileServiceImpl usersProfileServiceImpl;

	@Autowired
	private UsersProfileDao usersProfileDao;
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}

	@GetMapping("/registration")
	public String registrationPage(Model theModel) {
		UsersProfile registration = new UsersProfile();
		theModel.addAttribute("regi", registration);
		return "registration";
	}

	@GetMapping("/signin")
	public String signinPage() {
		return "login";
	}

	@GetMapping("/contactus")
	public String showContact(Model theModel) {
		Message message = new Message();
		theModel.addAttribute("message", message);
		return "contact";
	}

	@PostMapping("/sendmessage")
	public String sendMessage(@ModelAttribute("message") Message message) {
		messageService.saveMessage(message);
		return "redirect:/";
	}

	@PostMapping("/register")
	public String rigester(@ModelAttribute("regi") UsersProfile user, Errors errors,
			RedirectAttributes redirectAttributes) {

		if (usersProfileDao.findemailId(user.getEmailId()).isEmpty()) {
			usersProfileServiceImpl.saveUserProfile(user);
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", "Email id is already present!!! Please try another one.");
			return "redirect:/registration";
		}
		return "redirect:/";
	}
}























