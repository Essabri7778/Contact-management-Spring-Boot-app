package com.ensah.bo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author FZ.ESSABRI
 */
@Entity
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGroupe;
    @NotBlank(message = "this field is required")
    private String groupeName;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_groupe")
    private List<Contact> contacts = new ArrayList<Contact>();


    public void addContact(Contact contact){contacts.add(contact);}
    public void removeContact(Contact contact){contacts.remove(contact);}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Groupe)) return false;
        Groupe groupe = (Groupe) o;
        return idGroupe != null && idGroupe.equals(groupe.getIdGroupe());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public Long getIdGroupe() {
        return idGroupe;
    }

    @Override
    public String toString() {
        return "Groupe{" +
                "idGroupe=" + idGroupe +
                ", groupeName='" + groupeName + '\'' +
                ", contacts=" + contacts +
                '}';
    }

    public void setIdGroupe(Long idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getGroupeName() {
        return groupeName;
    }

    public void setGroupeName(String groupeName) {
        this.groupeName = groupeName;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
