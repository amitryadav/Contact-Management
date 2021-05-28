package Com.Interview.contactmgt.service;

import java.util.List;

import com.interview.contactmgt.dto.ContactInfo;
import com.interview.contactmgt.dto.ResponseStatus;

/*@author AmitYadav
 * @date-26 may 2021
 * @created by  AmitYadav
 * @Interface ContactService
 */
public interface ContactService {

	ResponseStatus addContact(ContactInfo contactInfo);

	ResponseStatus editContact(ContactInfo contactInfo);

	ResponseStatus deactivateContact(int contactId);

	List<ContactInfo> contactList();

	ContactInfo getContactDetailsById(int contactId);

}
