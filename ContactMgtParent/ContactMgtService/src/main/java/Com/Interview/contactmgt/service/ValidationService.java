package Com.Interview.contactmgt.service;

import com.interview.contactmgt.dto.ContactInfo;
import com.interview.contactmgt.dto.ResponseStatus;

/*@author AmitYadav
 * @date-26 may 2021
 * @created by  AmitYadav
 * @Interface ValidationService
 */
public interface ValidationService {
	
	ResponseStatus validateData(ContactInfo contactInfo);

}
