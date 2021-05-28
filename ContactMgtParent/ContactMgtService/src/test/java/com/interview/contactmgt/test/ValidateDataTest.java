package com.interview.contactmgt.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.interview.contactmgt.dto.ContactInfo;
import com.interview.contactmgt.dto.ResponseStatus;

import Com.Interview.contactmgt.service.ValidationService;

/*@author AmitYadav
 * @date-27 may 2021
 * @created by  AmitYadav
 * @Class ValidateDatatest
 */
@ContextConfiguration(locations = "classpath:applicationServiceContext.xml")
@RunWith(SpringRunner.class)
public class ValidateDataTest {
	
	@Autowired
	private ValidationService validationService;
	
	//test case for valid data
	@Test
	@Ignore
	public void validData()
	{
		ContactInfo contactInfo=new ContactInfo();
		contactInfo.setEmail("ayamityadav00@gmail.com");
		contactInfo.setFirstName("Amit");
		contactInfo.setLastName("yadav");
		contactInfo.setPhoneNumber("9970788305");
		ResponseStatus responseStatus=validationService.validateData(contactInfo);
		
		Assert.assertEquals(null, responseStatus);
		
	}
	
	//test case for empty email
	@Test
	@Ignore
	public void emptyEmail()
	{
		ContactInfo contactInfo=new ContactInfo();
		contactInfo.setEmail("");
		contactInfo.setFirstName("Amit");
		contactInfo.setLastName("yadav");
		contactInfo.setPhoneNumber("9970788305");
		ResponseStatus responseStatus=validationService.validateData(contactInfo);
		
		Assert.assertNotEquals(null, responseStatus);
		
		
	}
	
	//test case for invalid email
	@Test
	@Ignore
	public void invalidEmail()
	{
		ContactInfo contactInfo=new ContactInfo();
		contactInfo.setEmail("abc234gmail.co");
		contactInfo.setFirstName("Amit");
		contactInfo.setLastName("yadav");
		contactInfo.setPhoneNumber("9970788305");
		ResponseStatus responseStatus=validationService.validateData(contactInfo);
		
		Assert.assertNotEquals(null, responseStatus);
		
		
	}
	
	//test case for empty first name
	@Test
	@Ignore
	public void emptyFirstName()
	{
		ContactInfo contactInfo=new ContactInfo();
		contactInfo.setEmail("ayamityadav00@gmail.com");
		contactInfo.setFirstName("");
		contactInfo.setLastName("yadav");
		contactInfo.setPhoneNumber("9970788305");
		ResponseStatus responseStatus=validationService.validateData(contactInfo);
	
		Assert.assertNotEquals(null, responseStatus);
		
		
	}
	
	//test case for invalid first name
	@Test
	@Ignore
	public void invalidFirstName()
	{
		ContactInfo contactInfo=new ContactInfo();
		contactInfo.setEmail("ayamityadav00@gmail.com");
		contactInfo.setFirstName("abc123");
		contactInfo.setLastName("yadav");
		contactInfo.setPhoneNumber("9970788305");
		ResponseStatus responseStatus=validationService.validateData(contactInfo);
		
		Assert.assertNotEquals(null, responseStatus);
		
		
	}
	
	//test case for empty last name
	@Test
	@Ignore
	public void emptyLastName()
	{
		ContactInfo contactInfo=new ContactInfo();
		contactInfo.setEmail("ayamityadav00@gmail.com");
		contactInfo.setFirstName("Amit");
		contactInfo.setLastName("");
		contactInfo.setPhoneNumber("9970788305");
		ResponseStatus responseStatus=validationService.validateData(contactInfo);
		
		Assert.assertNotEquals(null, responseStatus);
		
		
	}
	
	//test case for invalid last name
	@Test
	@Ignore
	public void invalidLastName()
	{
		ContactInfo contactInfo=new ContactInfo();
		contactInfo.setEmail("ayamityadav00@gmail.com");
		contactInfo.setFirstName("Amit");
		contactInfo.setLastName("ya12y");
		contactInfo.setPhoneNumber("9970788305");
		ResponseStatus responseStatus=validationService.validateData(contactInfo);
		
		Assert.assertNotEquals(null, responseStatus);
		
		
	}
	
	//test case for empty phone number
	@Test
	@Ignore
	public void emptyPhoneNumber()
	{
		ContactInfo contactInfo=new ContactInfo();
		contactInfo.setEmail("ayamityadav00@gmail.com");
		contactInfo.setFirstName("Amit");
		contactInfo.setLastName("yadav");
		contactInfo.setPhoneNumber("");
		ResponseStatus responseStatus=validationService.validateData(contactInfo);
		
		Assert.assertNotEquals(null, responseStatus);
		
		
	}
	
	//test case for invalid phone number
	@Test
	@Ignore
	public void invalidPhoneNumber()
	{
		ContactInfo contactInfo=new ContactInfo();
		contactInfo.setEmail("ayamityadav00@gmail.com");
		contactInfo.setFirstName("Amit");
		contactInfo.setLastName("yadav");
		contactInfo.setPhoneNumber("134ab");
		ResponseStatus responseStatus=validationService.validateData(contactInfo);
		
		Assert.assertNotEquals(null, responseStatus);
		
		
	}

}
