package com.easybytes.easyschool.controller;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.easybytes.easyschool.model.Contact;
import com.easybytes.easyschool.service.ContactService;

import ch.qos.logback.classic.Logger;

@Controller
public class ContactController {
	
	private static Logger logger = (Logger) LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/contact")
	public String displayContactPage() {
		
		return "contact.html";
	}
	
	@RequestMapping("/saveMsg")
	public ModelAndView  saveContact(Contact contact) {
			
		contactService.saveContactdtls(contact);
		
		return new ModelAndView("redirect:/contact");
	}
	
	
	
		
	

}
