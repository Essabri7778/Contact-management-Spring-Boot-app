package com.ensah.dao;

import com.ensah.bo.Contact;
import com.ensah.bo.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * @author FZ.ESSABRI
 */
public interface GroupDao extends JpaRepository<Groupe, Long> {
    Groupe getGroupeByGroupeName(String name);
}
