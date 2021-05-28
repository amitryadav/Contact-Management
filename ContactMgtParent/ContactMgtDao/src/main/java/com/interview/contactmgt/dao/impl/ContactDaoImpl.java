package com.interview.contactmgt.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.interview.contactmgt.dao.ContactDao;
import com.interview.contactmgt.dto.ResponseStatus;
import com.interview.contactmgt.exception.DaoException;
import com.interview.contactmgt.model.ContactDetails;
import com.interview.contactmgt.util.ContactRespoCode;


/*@author AmitYadav
 * @date-27 may 2021
 * @created by  AmitYadav
 * @Class ContactDaoImpl
 */
@EnableTransactionManagement
@Repository("ContactDao")
public class ContactDaoImpl extends BaseDaoImpl implements ContactDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger LOGGER = Logger.getLogger(ContactDaoImpl.class);
	

	/*@author AmitYadav
	 * @date-27 may 2021
	 * @created by  AmitYadav
	 * @Method contactList
	 */	
	@Transactional
	public List<ContactDetails> contactList() throws DaoException {
		LOGGER.info("Inside contactList of ContactDaoImpl :");
		List<ContactDetails> contactDetails = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "From ContactDetails";
			Query query = session.createQuery(hql);

			contactDetails = query.list();
		} catch (Exception e) {
			LOGGER.error("==>Exception thrown in ContactDaoImpl in contactList ", e);
			ResponseStatus status = new ResponseStatus();
			status.setResponseCode(ContactRespoCode.C107.getCode()+"");
			status.setResponseMessage(ContactRespoCode.C107.getValue());

			throw new DaoException(status);
		}
		return contactDetails;
	}

	/*@author AmitYadav
	 * @date-27 may 2021
	 * @created by  AmitYadav
	 * @Method getContactDetailById
	 */	

	@Transactional
	public ContactDetails getContactDetailById(int contactId) throws DaoException {
		LOGGER.info("Inside getContactDetailById of ContactDaoImpl :" + contactId);
		ContactDetails contactDetails = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			contactDetails = (ContactDetails) session.createQuery("From ContactDetails where contactId=:contactId")
					.setParameter("contactId", contactId).uniqueResult();
		} catch (Exception e) {

			LOGGER.error("==>Exception thrown in ContactDaoImpl in getContactDetailById mehtod ", e);
			ResponseStatus status = new ResponseStatus();
			status.setResponseCode(ContactRespoCode.C112.getCode()+"");
			status.setResponseMessage(ContactRespoCode.C112.getValue());

			throw new DaoException(status);

		}
		return contactDetails;
	}

}
