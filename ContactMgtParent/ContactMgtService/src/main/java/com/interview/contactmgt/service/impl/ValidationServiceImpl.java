package com.interview.contactmgt.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.interview.contactmgt.dto.ContactInfo;
import com.interview.contactmgt.dto.ResponseStatus;
import com.interview.contactmgt.util.ContactRespoCode;
import com.interview.contactmgt.util.ValidationData;

import Com.Interview.contactmgt.service.ValidationService;

/*@author AmitYadav
 * @date-26 may 2021
 * @created by  AmitYadav
 * @Class ValidationServiceImpl
 */
@Service("ValidationService")
public class ValidationServiceImpl implements ValidationService {

	private static final Logger LOGGER = Logger.getLogger(ValidationServiceImpl.class);

	/*@author AmitYadav
	 * @date-26 may 2021
	 * @created by  AmitYadav
	 * @Method validateData
	 */
	
	public ResponseStatus validateData(ContactInfo contactInfo) {

		LOGGER.info("Inside service layer  in validateData method in ValidationServiceImpl  before validate data "
				+ contactInfo);
		ResponseStatus responseStatus = null;

		ValidationData validationData = new ValidationData();

		if (validationData.validateEmail(contactInfo.getEmail())) {
			responseStatus = new ResponseStatus();
			responseStatus.setResponseCode(ContactRespoCode.C108.getCode() + "");
			responseStatus.setResponseMessage(ContactRespoCode.C108.getValue());
			return responseStatus;
		}
		if (validationData.validateName(contactInfo.getFirstName())) {
			responseStatus = new ResponseStatus();
			responseStatus.setResponseCode(ContactRespoCode.C109.getCode() + "");
			responseStatus.setResponseMessage(ContactRespoCode.C109.getValue());
			return responseStatus;
		}
		if (validationData.validatePhone(contactInfo.getPhoneNumber() + "")) {
			responseStatus = new ResponseStatus();
			responseStatus.setResponseCode(ContactRespoCode.C110.getCode() + "");
			responseStatus.setResponseMessage(ContactRespoCode.C110.getValue());
			return responseStatus;
		}
		if (validationData.validateName(contactInfo.getLastName())) {
			responseStatus = new ResponseStatus();
			responseStatus.setResponseCode(ContactRespoCode.C111.getCode() + "");
			responseStatus.setResponseMessage(ContactRespoCode.C111.getValue());
			return responseStatus;
		}

		return responseStatus;
	}

}
