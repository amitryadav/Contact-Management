package com.interview.contactmgt.util;

import java.util.regex.Pattern;

/*@author AmitYadav
 * @date-26 may 2021
 * @created by  AmitYadav
 * @Class ValidationData
 */
public class ValidationData {

	// validate phone number
	public boolean validatePhone(String phone) {
		boolean result = false;

		if (phone == null || phone.equals("") || phone.equals(" "))
			result = true;

		else{
			Pattern pattern2 = Pattern.compile("\\d{10}");
			if (!pattern2.matcher(phone).matches()) {
				result = true;
			}
		}

		return result;
	}

	//validate email
	public boolean validateEmail(String email) {
		boolean result = false;

		if (email == null || email.equals("") || email.equals(" "))
			result = true;

		else {
			final Pattern VALID_EMAIL_ADDRESS_REGEX = 
				    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

			//Pattern pattern2 = Pattern.compile("^(.+)@(.+)$");
			if (!VALID_EMAIL_ADDRESS_REGEX.matcher(email).matches()) {
				result = true;
			}
		}

		return result;
	}
	
	//validate name
	public boolean validateName(String name) {
		boolean result = false;

		if (name == null || name.equals("") || name.equals(" "))
			result = true;

		else {
			Pattern pattern2 = Pattern.compile("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$");
			if (!pattern2.matcher(name).matches()) {
				result = true;
			}
		}

		return result;
	}

}
