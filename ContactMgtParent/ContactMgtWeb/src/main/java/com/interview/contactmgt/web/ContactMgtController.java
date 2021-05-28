package com.interview.contactmgt.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.interview.contactmgt.dto.ContactInfo;
import com.interview.contactmgt.dto.ResponseStatus;

import Com.Interview.contactmgt.service.ContactService;

/*@author AmitYadav
 * @date-26 may 2021
 * @created by  AmitYadav
 * @Class ContactMgtController
 */
@Controller
public class ContactMgtController {

	private static final Logger LOGGER = Logger.getLogger(ContactMgtController.class);

	@Autowired
	private ContactService contactService;

	/*@author AmitYadav
	 * @date-26 may 2021
	 * @created by  AmitYadav
	 * @Method viewcontactList
	 */
	@RequestMapping("/viewcontact")
	public String viewcontactList(Model m) {
		LOGGER.info("Inside  web layer in viewcontactList method ");
		List<ContactInfo> list = contactService.contactList();
		LOGGER.info("after getting contactList in web layer " + list);
		m.addAttribute("list", list);
		return "viewcontact";
	}


	/*@author AmitYadav
	 * @date-26 may 2021
	 * @created by  AmitYadav
	 * @Method showform
	 */
	@RequestMapping("/contactform")
	public String showform(Model m) {
		m.addAttribute("command", new ContactInfo());
		return "contactform";
	}

	/*@author AmitYadav
	 * @date-26 may 2021
	 * @created by  AmitYadav
	 * @Method getContactById
	 */
	@RequestMapping(value = "/editcontact/{id}")
	public String getContactById(@PathVariable int id, Model m) {
		LOGGER.info("Inside  web layer in getContactById method ");
		ContactInfo contactInfo = contactService.getContactDetailsById(id);
		LOGGER.info("after getting contact by id in web layer " + contactInfo);
		m.addAttribute("command", contactInfo);
		return "contacteditform";
	}

	/*@author AmitYadav
	 * @date-26 may 2021
	 * @created by  AmitYadav
	 * @Method contactSave
	 */
	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String contactSave(@ModelAttribute("contactInfo") ContactInfo contactInfo) {
		LOGGER.info("Inside rest or web layer in contactSave method " + contactInfo);
		ResponseStatus responseStatus = contactService.addContact(contactInfo);
		LOGGER.info("after adding contact in web layer " + responseStatus);
		return "redirect:/viewcontact";
	}

	/*@author AmitYadav
	 * @date-26 may 2021
	 * @created by  AmitYadav
	 * @Method editContact
	 */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editContact(@ModelAttribute("contactInfo") ContactInfo contactInfo) {
		LOGGER.info("Inside  web layer in editContact method " + contactInfo);
		ResponseStatus responseStatus = contactService.editContact(contactInfo);
		LOGGER.info("after editing contact in web layer " + responseStatus);
		return "redirect:/viewcontact";

	}
	/*@author AmitYadav
	 * @date-26 may 2021
	 * @created by  AmitYadav
	 * @Method deactivateContact
	 */
	@GetMapping(value = "/deactivateContact/{id}")
	public String deactivateContact(@PathVariable int id) {
		LOGGER.info("Inside  web layer in deactivateContact method " + id);
		ResponseStatus responseStatus = contactService.deactivateContact(id);
		LOGGER.info("after deactivateing contact in web layer " + responseStatus);

		return "redirect:/viewcontact";
	}

	

}
