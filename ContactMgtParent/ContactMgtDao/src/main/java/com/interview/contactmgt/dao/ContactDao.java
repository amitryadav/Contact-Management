package com.interview.contactmgt.dao;

import java.util.List;

import com.interview.contactmgt.exception.DaoException;
import com.interview.contactmgt.model.ContactDetails;

/*@author AmitYadav
 * @date-27 may 2021
 * @created by  AmitYadav
 * @Interface ContactDao
 */
public interface ContactDao extends BaseDao {

	List<ContactDetails> contactList() throws DaoException;

	ContactDetails getContactDetailById(int contactId) throws DaoException;

}
