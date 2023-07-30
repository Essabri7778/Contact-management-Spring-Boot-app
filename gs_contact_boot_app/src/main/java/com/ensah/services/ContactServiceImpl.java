package com.ensah.services;

import java.util.List;

import javax.transaction.Transactional;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ensah.bo.Contact;
import com.ensah.dao.ContactDao;

@Service
@Transactional
public class ContactServiceImpl implements IContactService {
	
	private ContactDao contactDao;
	
	@Autowired
	public ContactServiceImpl(ContactDao cDao) {
		contactDao = cDao;
	}

	@Override
	public void addContact(Contact cContact) {
		contactDao.save(cContact);
	}

	@Override
	public void updateContact(Contact cContact) {
		contactDao.save(cContact);
	}

	@Override
	public List<Contact> getAllContacts() {
		
		return contactDao.findAll();
	}

	@Override
	public void deleteContact(Long id) {
		contactDao.deleteById(id);
		
	}

	@Override
	public Contact getContactById(Long id) {
		return contactDao.findById(id).get();
	}
	@Override
	public List<Contact> getAllContactsByAlphabeticOrder() {
		Sort sort = Sort.by(Sort.Order.asc("lastName").ignoreCase());
		return contactDao.findAll(sort);
	}

	@Override
	public List<Contact> getContactsByLastName(String lastName) {
		List<Contact> l = contactDao.getContactsByLastName(lastName);
		return (l != null && !l.isEmpty()) ? l : null;
	}

	@Override
	public List<Contact> getContactByPhoneNbr(String ProPhoneNbr,String PersPhoneNbr) {
		List<Contact> l = contactDao.getContactByPersonalPhoneNbrOrProfessionalPhoneNbr(ProPhoneNbr,PersPhoneNbr);
		return (l != null && !l.isEmpty()) ? l : null;
	}

	@Override
	public List<Contact> findContactByPhoneticSearch(String lastName) {
		List<Contact> l = contactDao.phoneticSearch(lastName);
		return (l != null && !l.isEmpty()) ? l : null;
	}



}
