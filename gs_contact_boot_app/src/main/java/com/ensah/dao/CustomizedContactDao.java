package com.ensah.dao;

import com.ensah.bo.Contact;

import java.util.List;

/**
 * @author FZ.ESSABRI
 */
public interface CustomizedContactDao {
    List<Contact> phoneticSearch(String lastName);
}
