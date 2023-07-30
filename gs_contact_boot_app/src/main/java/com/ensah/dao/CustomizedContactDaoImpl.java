package com.ensah.dao;

import com.ensah.bo.Contact;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author FZ.ESSABRI
 */
public class CustomizedContactDaoImpl implements CustomizedContactDao {
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Contact> phoneticSearch(String lastName) {
        String str = "SELECT * FROM contact\n" +
                "WHERE SOUNDEX(last_name) = SOUNDEX(:searchName)";
        Query query = entityManager.createNativeQuery(str, Contact.class);
        query.setParameter("searchName",lastName);
        return query.getResultList();
    }
}
