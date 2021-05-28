package com.interview.contactmgt.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.interview.contactmgt.dto.ContactInfo;
import com.interview.contactmgt.dto.ResponseStatus;

import Com.Interview.contactmgt.service.ContactService;

/*@author AmitYadav
 * @date-26 may 2021
 * @created by  AmitYadav
 * @Class ContactMgtRestController
 */
@RestController
public class ContactMgtRestController {
	private static final Logger LOGGER = Logger.getLogger(ContactMgtRestController.class);

	@Autowired
	private ContactService contactService;


	/*@author AmitYadav
	 * @date-26 may 2021
	 * @created by  AmitYadav
	 * @Method contactList
	 */
	@GetMapping(value = "/contactList")
	public List<ContactInfo> contactList() {
		LOGGER.info("Inside rest  layer in contactList method ");
		List<ContactInfo> contactInfos = contactService.contactList();
		LOGGER.info("after getting contactList in rest layer " + contactInfos);

		return contactInfos;
	}

	/*@author AmitYadav
	 * @date-26 may 2021
	 * @created by  AmitYadav
	 * @Method getContactDetails
	 */
	@GetMapping(value = "/viewContact/{contactId}")
	public ContactInfo getContactDetails(@PathVariable int contactId) {
		LOGGER.info("Inside rest  layer in getContactDetails method ");
		ContactInfo contactInfo = contactService.getContactDetailsById(contactId);
		LOGGER.info("after getting contact by id in rest layer " + contactInfo);

		return contactInfo;
	}

	/*@author AmitYadav
	 * @date-26 may 2021
	 * @created by  AmitYadav
	 * @Method contactAdd
	 */
	@PostMapping(value = "/contactAdd")
	public ResponseStatus contactAdd(@RequestBody ContactInfo contactInfo) {
		LOGGER.info("Inside rest layer in contactAdd method " + contactInfo);
		ResponseStatus responseStatus = contactService.addContact(contactInfo);
		LOGGER.info("after adding contact in rest layer " + responseStatus);
		return responseStatus;
	}

	/*@author AmitYadav
	 * @date-26 may 2021
	 * @created by  AmitYadav
	 * @Method contactEdit
	 */
	@PostMapping(value = "/contactEdit")
	public ResponseStatus contactEdit(@RequestBody ContactInfo contactInfo) {
		LOGGER.info("Inside rest layer in editContact method " + contactInfo);
		ResponseStatus responseStatus = contactService.editContact(contactInfo);
		LOGGER.info("after editing contact in rest layer " + responseStatus);
		return responseStatus;

	}
	/*@author AmitYadav
	 * @date-26 may 2021
	 * @created by  AmitYadav
	 * @Method contactDeactivate
	 */
	@GetMapping(value = "/contactDeactivate/{contactId}")
	public ResponseStatus contactDeactivate(@PathVariable int contactId) {
		LOGGER.info("Inside rest layer in contactDeactivate method " + contactId);
		ResponseStatus responseStatus = contactService.deactivateContact(contactId);
		LOGGER.info("after deactivateing contact in rest layer " + responseStatus);

		return responseStatus;
	}

}
