package com.docker.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.docker.dao.UsersProfileDao;
import com.docker.entity.Message;
import com.docker.entity.UsersProfile;
import com.docker.service.MessageService;
import com.docker.service.UserProfileService;
import com.docker.service.UsersProfileServiceImpl;

@Controller
public class GymController {
	@Autowired
	private MessageService messageService;

	@Autowired
	private UsersProfileServiceImpl usersProfileServiceImpl;

	@Autowired
	private UsersProfileDao usersProfileDao;

	@Autowired
	private UserProfileService userProfileService;

	@GetMapping("/")
	public String homePage(@ModelAttribute("user") UsersProfile user, Model theModel) {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String email = loggedInUser.getName();
		List<UsersProfile> findbyEmailId = userProfileService.findbyEmailId(email);
		theModel.addAttribute("user", findbyEmailId);
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
			redirectAttributes.addFlashAttribute("errorMessage",
					"Email id is already present!!! Please try another one.");
			return "redirect:/registration";
		}
		return "redirect:/";
	}

	@GetMapping("/profile")
	public String getProfile(@ModelAttribute("user") UsersProfile user, Model theModel) {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String email = loggedInUser.getName();
		List<UsersProfile> userProfile = userProfileService.findbyEmailId(email);
		theModel.addAttribute("profiles", userProfile);
		return "profile";
	}

	@GetMapping("/updatecustomer")
	public String updateCustomer(@RequestParam(value = "id", required = false)Integer id, Model theModel) {	
		UsersProfile findById = usersProfileServiceImpl.findById(id);
		theModel.addAttribute("regi", findById);
		return "registration";
	}
	
}



























