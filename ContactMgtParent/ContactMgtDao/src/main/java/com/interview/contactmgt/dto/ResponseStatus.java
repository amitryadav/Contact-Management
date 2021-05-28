package com.interview.contactmgt.dto;

/*@author AmitYadav
 * @date-26 may 2021
 * @created by  AmitYadav
 * @Class ResponseStatus
 */	
public class ResponseStatus {
	
	private String responseCode;
	private String responseMessage;
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	@Override
	public String toString() {
		return "ResponseStatus [responseCode=" + responseCode + ", responseMessage=" + responseMessage + "]";
	}
	
	

}
