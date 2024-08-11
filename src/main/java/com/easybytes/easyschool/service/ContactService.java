package com.easybytes.easyschool.service;

import org.springframework.stereotype.Service;

import com.easybytes.easyschool.model.Contact;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContactService {


	
public  boolean saveContactdtls( Contact contact) {
	
	
	boolean isSaved = true;
	log.info(contact.toString());
	return isSaved;
	
}


}
