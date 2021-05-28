package com.interview.contactmgt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.contactmgt.dao.ContactDao;
import com.interview.contactmgt.dto.ContactInfo;
import com.interview.contactmgt.dto.ResponseStatus;
import com.interview.contactmgt.exception.DaoException;
import com.interview.contactmgt.model.ContactDetails;
import com.interview.contactmgt.util.ContactRespoCode;

import Com.Interview.contactmgt.service.ContactService;
import Com.Interview.contactmgt.service.ValidationService;

/*@author AmitYadav
 * @date-26 may 2021
 * @created by  AmitYadav
 * @Class ContactServiceImpl
 */

@Service("ContactService")
public class ContactServiceImpl implements ContactService {

	private static final Logger LOGGER = Logger.getLogger(ContactServiceImpl.class);

	@Autowired
	private ValidationService validationService;

	@Autowired
	private ContactDao contactDao;

	
	/*@author AmitYadav
	 * @date-26 may 2021
	 * @created by  AmitYadav
	 * @Method addContact
	 */
	public ResponseStatus addContact(ContactInfo contactInfo) {

		ResponseStatus responseStatus = null;
		LOGGER.info("Inside service layer  in addContact method before calling validationService " + contactInfo);
		
		//validate data
		responseStatus = validationService.validateData(contactInfo);
		if (responseStatus == null) {
			ContactDetails contactDetails = new ContactDetails();
			contactDetails.setEmail(contactInfo.getEmail());
			contactDetails.setFirstName(contactInfo.getFirstName());
			contactDetails.setLastName(contactInfo.getLastName());
			contactDetails.setPhoneNumber(contactInfo.getPhoneNumber());
			contactDetails.setStatus(ContactRespoCode.C105.getValue());

			try {
				//call save dao operation for saving contact
				contactDao.save(contactDetails);
				responseStatus = new ResponseStatus();
				responseStatus.setResponseCode(ContactRespoCode.C200.getCode() + "");
				responseStatus.setResponseMessage(ContactRespoCode.C200.getValue());

			} catch (DaoException e) {
				LOGGER.error("==>DaoException occur in ContactServiceImpl in addContact method ", e);
				responseStatus = new ResponseStatus();
				responseStatus.setResponseCode(e.getStatus().getResponseCode());
				responseStatus.setResponseMessage(e.getStatus().getResponseMessage());

			} catch (Exception e) {
				LOGGER.error("==>Exception occur in ContactServiceImpl in addContact method ", e);
				responseStatus = new ResponseStatus();
				responseStatus.setResponseCode(ContactRespoCode.C115.getCode() + "");
				responseStatus.setResponseMessage(ContactRespoCode.C115.getValue());

			}

		}
		return responseStatus;
	}

	/*@author AmitYadav
	 * @date-26 may 2021
	 * @created by  AmitYadav
	 * @Method editContact
	 */
	public ResponseStatus editContact(ContactInfo contactInfo) {
		LOGGER.info("Inside service layer  in editContact method before calling validationService " + contactInfo);
		ResponseStatus responseStatus = null;
		try {
			//validate data
			responseStatus = validationService.validateData(contactInfo);
			ContactDetails contactDetails = null;
			if (responseStatus == null) {

				contactDetails = contactDao.getContactDetailById(contactInfo.getContactId());
				if (contactDetails != null) {

					contactDetails.setEmail(contactInfo.getEmail());
					contactDetails.setFirstName(contactInfo.getFirstName());
					contactDetails.setLastName(contactInfo.getLastName());
					contactDetails.setPhoneNumber(contactInfo.getPhoneNumber());
					
					//update dao operation call for updating contact
					contactDao.update(contactDetails);
					responseStatus = new ResponseStatus();
					responseStatus.setResponseCode(ContactRespoCode.C200.getCode() + "");
					responseStatus.setResponseMessage(ContactRespoCode.C101.getValue());

				} else {
					responseStatus = new ResponseStatus();
					responseStatus.setResponseCode(ContactRespoCode.C102.getCode() + "");
					responseStatus.setResponseMessage(ContactRespoCode.C102.getValue());

				}

			}
		} catch (DaoException e) {
			LOGGER.error("==>DaoException occur in ContactServiceImpl in editContact method ", e);
			responseStatus = new ResponseStatus();
			responseStatus.setResponseCode(e.getStatus().getResponseCode());
			responseStatus.setResponseMessage(e.getStatus().getResponseMessage());

		} catch (Exception e) {
			LOGGER.error("==>Exception occur in ContactServiceImpl in editContact method ", e);
			responseStatus = new ResponseStatus();
			responseStatus.setResponseCode(ContactRespoCode.C103.getCode() + "");
			responseStatus.setResponseMessage(ContactRespoCode.C103.getValue());

		}

		return responseStatus;

	}

	/*@author AmitYadav
	 * @date-26 may 2021
	 * @created by  AmitYadav
	 * @Method deactivateContact
	 */
	public ResponseStatus deactivateContact(int contactId) {
		LOGGER.info("Inside service layer  in deactivateContact method " + contactId);
		ResponseStatus responseStatus = new ResponseStatus();
		try {
			//check contact details against contactId  present in db or not
			ContactDetails contactDetails = contactDao.getContactDetailById(contactId);

			if (contactDetails != null) {

				contactDetails.setStatus(ContactRespoCode.C106.getValue());
				//update dao operation call for updating contact
				contactDao.update(contactDetails);
				responseStatus = new ResponseStatus();
				responseStatus.setResponseCode(ContactRespoCode.C200.getCode() + "");
				responseStatus.setResponseMessage(ContactRespoCode.C104.getValue());

			} else {
				responseStatus = new ResponseStatus();
				responseStatus.setResponseCode(ContactRespoCode.C102.getCode() + "");
				responseStatus.setResponseMessage(ContactRespoCode.C102.getValue());

			}

		} catch (Exception e) {
			LOGGER.error("==>Exception occur in ContactServiceImpl in deactivateContact method ", e);
			responseStatus.setResponseCode(ContactRespoCode.C116.getCode() + "");
			responseStatus.setResponseMessage(ContactRespoCode.C116.getValue());

		}
		return responseStatus;
	}
	
	/*@author AmitYadav
	 * @date-26 may 2021
	 * @created by  AmitYadav
	 * @Method contactList
	 */

	public List<ContactInfo> contactList() {
		LOGGER.info("Inside service layer  in contactList method ");
		ContactInfo contactInfo = null;
		List<ContactInfo> contactInfoList = new ArrayList<ContactInfo>();
		try {
			//calling db for getting all contact list
			List<ContactDetails> contactDetails = contactDao.contactList();
			if (contactDetails != null) {
				for (ContactDetails cDetails : contactDetails) {
					//check contact status is active or not
					if (cDetails.getStatus().equalsIgnoreCase(ContactRespoCode.C105.getValue())) {
						contactInfo = new ContactInfo();
						contactInfo.setContactId(cDetails.getContactId());
						contactInfo.setEmail(cDetails.getEmail());
						contactInfo.setFirstName(cDetails.getFirstName());
						contactInfo.setLastName(cDetails.getLastName());
						contactInfo.setPhoneNumber(cDetails.getPhoneNumber());
						contactInfo.setStatus(cDetails.getStatus());
						contactInfoList.add(contactInfo);
					}
				}
			}
		} catch (DaoException e) {
			LOGGER.error("==>DaoException occur in ContactServiceImpl in contactList method ", e);
			ResponseStatus responseStatus = new ResponseStatus();
			contactInfo = new ContactInfo();
			responseStatus.setResponseCode(e.getStatus().getResponseCode());
			responseStatus.setResponseMessage(e.getStatus().getResponseMessage());
			contactInfo.setResponseStatus(responseStatus);
			contactInfoList.add(contactInfo);
		} catch (Exception e) {
			LOGGER.error("==>Exception occur in ContactServiceImpl in contactList method ", e);
			contactInfo = new ContactInfo();
			ResponseStatus responseStatus = new ResponseStatus();
			responseStatus.setResponseCode(ContactRespoCode.C107.getCode() + "");
			responseStatus.setResponseMessage(ContactRespoCode.C107.getValue());
			contactInfo.setResponseStatus(responseStatus);
			contactInfoList.add(contactInfo);
		}
		return contactInfoList;
	}

	/*@author AmitYadav
	 * @date-26 may 2021
	 * @created by  AmitYadav
	 * @Method getContactDetailsById
	 */

	public ContactInfo getContactDetailsById(int contactId) {
		LOGGER.info("Inside service layer  in getContactDetailsById method ");
		ResponseStatus responseStatus = null;
		ContactInfo contactInfo = new ContactInfo();
		try {

			//check contact details against contactId  present in db or not
			ContactDetails contactDetails = contactDao.getContactDetailById(contactId);

			if (contactDetails != null) {
				contactInfo.setContactId(contactDetails.getContactId());
				contactInfo.setEmail(contactDetails.getEmail());
				contactInfo.setFirstName(contactDetails.getFirstName());
				contactInfo.setLastName(contactDetails.getLastName());
				contactInfo.setPhoneNumber(contactDetails.getPhoneNumber());
				contactInfo.setStatus(contactDetails.getStatus());

			} else {
				responseStatus = new ResponseStatus();
				responseStatus.setResponseCode(ContactRespoCode.C102.getCode() + "");
				responseStatus.setResponseMessage(ContactRespoCode.C102.getValue());
				contactInfo.setResponseStatus(responseStatus);

			}

		} catch (Exception e) {
			LOGGER.error("==>Exception occur in ContactServiceImpl in getContactDetailsById method ", e);
			responseStatus = new ResponseStatus();
			responseStatus.setResponseCode(ContactRespoCode.C112.getCode() + "");
			responseStatus.setResponseMessage(ContactRespoCode.C112.getValue());
			contactInfo.setResponseStatus(responseStatus);

		}
		return contactInfo;
	}

}
