package com.ensah.bo;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author FZ.ESSABRI
 */
@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContact;
	
	@NotBlank(message = "This field is required")
	private String firstName;
	
	@NotBlank(message = "This field is required")
	private String lastName;
	
	@Email(message = "Enter a valide email")
	@NotBlank(message = "This field is required")
	private String personalEmail;
	
	@Email(message = "Enter a valide email")
	@NotBlank(message = "This field is required")
	private String professionalEmail;
	
	@NotBlank(message = "This field is required")
	private String address;
	
	@NotBlank(message = "This field is required")
	private String gender;
	
	//regex pattern for morocco phone number
	@Pattern(regexp = "^(06|07)\\d{8}$",message = "Invalide phone number")
	@NotBlank(message = "This field is required")
	private String personalPhoneNbr;

	@Pattern(regexp = "^(06|07)\\d{8}$",message = "Invalide phone number")
	@NotBlank(message = "This field is required")
	private String professionalPhoneNbr;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Contact)) return false;
		Contact contact = (Contact) o;
		return idContact!=null && idContact.equals(contact.getIdContact());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	public Contact() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Contact [idContact=" + idContact + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", personalEmail=" + personalEmail + ", professionalEmail=" + professionalEmail + ", address="
				+ address + ", gender=" + gender + ", personalPhoneNbr=" + personalPhoneNbr
				+ ", professionalPhoneNbr=" + professionalPhoneNbr + "]";
	}

	public Long getIdContact() {
		return idContact;
	}

	public void setIdContact(Long idContact) {
		this.idContact = idContact;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getProfessionalEmail() {
		return professionalEmail;
	}

	public void setProfessionalEmail(String professionalEmail) {
		this.professionalEmail = professionalEmail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPersonalPhoneNbr() {
		return personalPhoneNbr;
	}

	public void setPersonalPhoneNbr(String personalPhoneNor) {
		this.personalPhoneNbr = personalPhoneNor;
	}

	public String getProfessionalPhoneNbr() {
		return professionalPhoneNbr;
	}

	public void setProfessionalPhoneNbr(String professionalPhoneNbr) {
		this.professionalPhoneNbr = professionalPhoneNbr;
	}



}
