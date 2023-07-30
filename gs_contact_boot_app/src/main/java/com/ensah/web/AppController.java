package com.ensah.web;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.validation.Valid;

import com.ensah.bo.Groupe;
import com.ensah.services.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.ensah.bo.Contact;
import com.ensah.services.IContactService;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {
	
	@Autowired
	private IContactService contactService ;
	@Autowired
	private IGroupService groupService;
	
	@Autowired
	private ServletContext appContext;

	
	@PostConstruct
	public void init() {
		
	}
	
	//show the form
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("contactModel", new Contact());
		model.addAttribute("contactList",contactService.getAllContacts());
		return "contactForm";
	}
	
	//add a contact
	@RequestMapping("/addContact")
	public String process(@Valid @ModelAttribute("contactModel") Contact contact, BindingResult bindingResult,
			ModelMap model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("errorMsg","les données sont invalides." );
		
		}else {
			contactService.addContact(contact);
			model.addAttribute("infoMsg", "Personne ajouté avec succès.");
			addGroupAutomatically(contact);
		}
		return "contactForm";
	}

	/** Ajouter un groupe automatiquement à l'ajout d'un contact, le nom du groupe
	 *  sera le prénom du contact
	 *
	 * @param contact objet de type Contact
	 */
	public void addGroupAutomatically(Contact contact){
		if(groupService.getGroupByName(contact.getLastName()) != null){
			groupService.getGroupByName(contact.getLastName()).addContact(contact);
		}
		else {
			Groupe groupe = new Groupe();
			groupe.setGroupeName(contact.getLastName());
			groupe.addContact(contact);
			groupService.addGroup(groupe);

		}
	}
	
	//show the list of contacts
	@RequestMapping("/manageContacts")
	public String manageContacts(Model model) {
		model.addAttribute("contactList", contactService.getAllContacts());
		return "manageContacts";
	}

	//show the form of update contact
	@RequestMapping(value = "/updateContactForm/{idContact}",method = RequestMethod.GET)
	public String updateContactForm(@PathVariable int idContact, Model model){
		model.addAttribute("contactModel",contactService.getContactById(Long.valueOf((idContact))));
		return  "updateContactForm";
	}

	//update the contact
	@RequestMapping("/updateContact")
	public String updateContact(@Valid @ModelAttribute("contactModel")Contact contact, BindingResult bindingResult,
								ModelMap model){
		if(bindingResult.hasErrors()){
			model.addAttribute("errorMsg","les données sont invalides");
			return "updateContactForm";
		}
		contactService.updateContact(contact);
		model.addAttribute("infoMsg", "Mise à jour effectuer avec success");
		model.addAttribute("contactList", contactService.getAllContacts());
		return "redirect:/manageContacts";
	}

	//"redirect:/managePersons": This approach uses a string value directly as the return statement
	//in the controller method. By prefixing the string with "redirect:", Spring MVC interprets it
	// as a redirect instruction and automatically creates a RedirectView instance with the specified
	// URL (/managePersons). This approach is simpler and more concise.

	//Delete contact
	@RequestMapping(value = "deleteContact/{idContact}",method = RequestMethod.GET)
	public RedirectView delete(@PathVariable int idContact){
		contactService.deleteContact(Long.valueOf(idContact));
		return new RedirectView(appContext.getContextPath()+ "/manageContacts");
	}

	@RequestMapping("/orderContactByLastName")
	public String orderContactByLastName(Model model){
		model.addAttribute("contactList",contactService.getAllContactsByAlphabeticOrder());
		return "manageContacts";
	}

	@PostMapping(value="searchContactByLastName")
	public String searchContactsByLastName(@RequestParam String nameId, Model model){
		//verify if we find the corresponding contact to the giving lasName property
		List<Contact> filteredContact = new ArrayList<>();
		List<Contact> allContacts = contactService.getAllContacts();
		List<Contact> ContactsByLastName = contactService.getContactsByLastName(nameId);
		List<Contact> phoneticSearchContacts = contactService.findContactByPhoneticSearch(nameId);

		if(ContactsByLastName != null){
			model.addAttribute("contactList",ContactsByLastName);
		}
		else {
			for (int i = 0 ;i < allContacts.size() ;i++){
				if (calculateDistance(allContacts.get(i).getLastName(),nameId) <= 3) {
					filteredContact.add(allContacts.get(i));
				}
			}
			if (!filteredContact.isEmpty()){
				model.addAttribute("contactList",filteredContact);
			}
			else {
				if(phoneticSearchContacts != null){
					model.addAttribute("contactList",phoneticSearchContacts);
				}
				else {
					model.addAttribute("contactList",contactService.getAllContacts());
					model.addAttribute("errorMsg", "Aucun contact avec le nom '"+nameId+"' n'est trouvé");
				}

			}
		}
		return "manageContacts";
	}

	@PostMapping(value="searchContactByPhoneNbr")
	public String searchContactsByPhoneNbr(@RequestParam String phoneId, Model model){
		//verify if we find the corresponding contact to the giving PhoneNumber property
		List<Contact> contacts = contactService.getContactByPhoneNbr(phoneId,phoneId);
		if(contacts != null){
			model.addAttribute("contactList",contacts);
		}
		else{
			model.addAttribute("contactList",contactService.getAllContacts());
			model.addAttribute("errorMsg", "Aucun contact avec le numéro telephone '"+phoneId+"' n'est trouvé");
		}
		return "manageContacts";
	}

	//group management
	@RequestMapping("/showGroupForm")
	public String showGroupForm(Model model){
		model.addAttribute("contactList",contactService.getAllContacts());
		model.addAttribute("groupModel", new Groupe());
		model.addAttribute("groupList",groupService.getAllGroups());
		return "groupForm";
	}

	@RequestMapping("/manageGroupes")
	public String manageGroups(Model model) {

		model.addAttribute("groupList", groupService.getAllGroups());
		return "manageGroupes";
	}
	@RequestMapping("/addGroup")
	public String addGroup(@Valid @ModelAttribute("groupModel") Groupe group,
						   BindingResult bindingResult,ModelMap model){
		if(bindingResult.hasErrors()) {
			model.addAttribute("errorMsg","les données sont invalides." );

		}else {
			groupService.addGroup(group);
			model.addAttribute("infoMsg", "Groupe ajouté avec succès.");
		}
		model.addAttribute("contactList",contactService.getAllContacts());
		model.addAttribute("groupList",groupService.getAllGroups());
		return "groupForm";
	}

	@RequestMapping(value = "/deleteGroup/{idGroup}",method = RequestMethod.GET)
	public RedirectView deleteGroup(@PathVariable Long idGroup){
		groupService.deleteGroup(idGroup);
		return new RedirectView(appContext.getContextPath()+"/manageGroupes");
	}

	@PostMapping(value="/searchGroupeByName")
	public String  searchGroupeByName(@RequestParam String nameGroupId, Model model){
		//verify if we find the corresponding group to the giving name property
		Groupe groupe = groupService.getGroupByName(nameGroupId);
		if(groupe!=null){
			List<Groupe> groupes = new ArrayList<>();
			groupes.add(groupe);
			model.addAttribute("groupList",groupes);
		}
		else{
			model.addAttribute("groupList",groupService.getAllGroups());
			model.addAttribute("errorMsg", "Aucun group avec le nom '"+nameGroupId+"' n'est trouvé");
		}
		//redirection important pour initialiser groupModel attribut
		return "manageGroupes";
	}

	//show the form of update group
	@RequestMapping(value = "/updateGroupForm/{idGroup}",method = RequestMethod.GET)
	public String updateGroupForm(@PathVariable int idGroup, Model model){

		model.addAttribute("contactList",contactService.getAllContacts());
		model.addAttribute("groupModel",groupService.getGroupById(Long.valueOf((idGroup))));
		return  "updateGroupForm";
	}

	//update the group
	@RequestMapping("/updateGroup")
	public String updategroup(@Valid @ModelAttribute("groupModel")Groupe groupe, BindingResult bindingResult,
								ModelMap model){
		if(bindingResult.hasErrors()){
			model.addAttribute("errorMsg","les données sont invalides");
			return "updateGroupForm";
		}
		groupService.updateGroup(groupe);
		model.addAttribute("infoMsg", "Mise à jour effectuer avec success");
		model.addAttribute("groupList", groupService.getAllGroups());
		return "redirect:/manageGroupes";
	}


	public static int calculateDistance(String str1, String str2) {
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i <= str1.length(); i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j <= str2.length(); j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int deletion = dp[i - 1][j] + 1;
					int insertion = dp[i][j - 1] + 1;
					int substitution = dp[i - 1][j - 1] + 1;
					dp[i][j] = Math.min(deletion, Math.min(insertion, substitution));
				}
			}
		}

		return dp[str1.length()][str2.length()];
	}

}
