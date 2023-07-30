package com.ensah.services;

import java.util.List;

import com.ensah.bo.Contact;

public interface IContactService {
	
	public void addContact(Contact contact);
	
	public void updateContact(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public void deleteContact(Long id);
	
	public Contact getContactById(Long id);
	public List<Contact> getAllContactsByAlphabeticOrder();
	public List<Contact> getContactsByLastName(String lastName);
	public List<Contact> getContactByPhoneNbr(String ProphoneNbr,String PerphoneNbr);

	public List<Contact> findContactByPhoneticSearch(String lastName);

}
