package com.ensah.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensah.bo.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactDao extends JpaRepository<Contact, Long>, CustomizedContactDao {
    List<Contact> getContactsByLastName(String lastName);

    List<Contact> getContactByPersonalPhoneNbrOrProfessionalPhoneNbr(String proPhoneNbr,String PerPhoneNbr);


    /*@Query(value = "SELECT c FROM Contact c WHERE SOUNDEX(c.lastName) = SOUNDEX(:searchTerm)")
    List<Contact> findByPhoneticNom(@Param("searchTerm") String searchTerm);*/
}
