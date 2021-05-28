package com.interview.contactmgt.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)

/*@author AmitYadav
 * @date-26 may 2021
 * @created by  AmitYadav
 * @Class ContactInfo
 */	
public class ContactInfo {

	private int contactId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String status;
	private ResponseStatus responseStatus;
	
	
	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "ContactInfo [contactId=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", status=" + status + ", responseStatus="
				+ responseStatus + "]";
	}
	
	
}
