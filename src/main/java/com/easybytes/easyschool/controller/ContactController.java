package com.easybytes.easyschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.easybytes.easyschool.model.Contact;
import com.easybytes.easyschool.service.ContactService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping("/contact")
	public String displayContactPage(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact.html";
	}

	@RequestMapping("/saveMsg")
	public String saveContact(@Valid @ModelAttribute("contact") Contact contact,Errors error) {

		if(error.hasErrors()) {
			log.info("Error caught "+error);
			return "contact.html";
		}
		contactService.saveContactdtls(contact);

		return "redirect:/contact";
	}

}
