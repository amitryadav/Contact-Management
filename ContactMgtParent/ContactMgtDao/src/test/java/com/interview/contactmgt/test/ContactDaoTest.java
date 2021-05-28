package com.interview.contactmgt.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.interview.contactmgt.dao.ContactDao;
import com.interview.contactmgt.exception.DaoException;
import com.interview.contactmgt.model.ContactDetails;
import com.interview.contactmgt.util.ContactRespoCode;

/*@author AmitYadav
 * @date-27 may 2021
 * @created by  AmitYadav
 * @Class ContactDaoTest
 */

@ContextConfiguration(locations = "classpath:applicationDaoContext.xml")
@RunWith(SpringRunner.class)
public class ContactDaoTest {

	@Autowired
	private ContactDao contactDao;

	private static final Logger LOGGER = Logger.getLogger(ContactDaoTest.class);

	//test case for save contact
	@Test
	@Ignore
	public void saveContact() {
		ContactDetails contactDetails = new ContactDetails();
		contactDetails.setEmail("ayamityadav00@gmail.com");
		contactDetails.setFirstName("Amit");
		contactDetails.setLastName("Yadav");
		contactDetails.setPhoneNumber("9970788305");
		contactDetails.setStatus(ContactRespoCode.C105.getValue());
		boolean result = false;
		try {
			result = contactDao.save(contactDetails);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		Assert.assertEquals(true, result);
	}

	//test case for update contact
	@Test
	@Ignore
	public void updateContact() {
		ContactDetails contactDetails = new ContactDetails();
		contactDetails.setEmail("ayamityadav00@gmail.com");
		contactDetails.setFirstName("Amit");
		contactDetails.setLastName("Yadav");
		contactDetails.setPhoneNumber("9970788305");
		contactDetails.setStatus(ContactRespoCode.C105.getValue());
		contactDetails.setContactId(1);
		boolean result = false;
		try {
			result = contactDao.update(contactDetails);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		Assert.assertEquals(true, result);
	}

	//test case for get contact list
	@Test
	@Ignore
	public void getContactList() {
		List<ContactDetails> contactDetails = null;
		try {
			contactDetails = contactDao.contactList();

		} catch (Exception e) {

			LOGGER.error(e);
		}

		Assert.assertNotEquals(null, contactDetails);

	}

	//test case for get contact details by contactId
	@Test
	@Ignore
	public void getContactDetailsById() {
		ContactDetails contactDetails = null;
		try {
			contactDetails = contactDao.getContactDetailById(1);
		} catch (DaoException e) {
			LOGGER.error(e);
		}
		Assert.assertNotEquals(null, contactDetails);

	}

	//test case for save contact fail
	@Test
	@Ignore
	public void saveFailContact() {
		ContactDetails contactDetails = new ContactDetails();
		contactDetails.setEmail("ayamityadav00@gmail.com");
		contactDetails.setFirstName("Amit");
		contactDetails.setLastName("Yadav");

		boolean result = false;
		try {
			result = contactDao.save(contactDetails);
		} catch (Exception e) {
			LOGGER.error(e);

		}
		Assert.assertNotEquals(true, result);
	}

	//test case for update contact fail
	@Test
	@Ignore
	public void updateFailContact() {
		ContactDetails contactDetails = new ContactDetails();
		contactDetails.setEmail("ayamityadav00@gmail.com");
		contactDetails.setFirstName("Amit");
		contactDetails.setLastName("Yadav");
		contactDetails.setPhoneNumber("9970788305");

		boolean result = false;
		try {
			result = contactDao.update(contactDetails);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		Assert.assertNotEquals(true, result);
	}
	
	//test case for get contact details by contactId fail
	@Test
	@Ignore
	public void getContactDetailsByIdFail() {
		ContactDetails contactDetails = null;
		try {
			contactDetails = contactDao.getContactDetailById(10000);
		} catch (DaoException e) {
			LOGGER.error(e);
			
		}
		Assert.assertEquals(null, contactDetails);

	}

}
