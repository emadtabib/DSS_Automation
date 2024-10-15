package com.generic.page;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.generic.selector.RegistrationSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.RandomUtilities;
import com.generic.util.SelectorUtil;
import com.generic.util.SelectorUtil.commands.actions;

//import bsh.Console;

import java.net.URI;

public class Registration extends SelTestCase {
	public static class keys {
		public static final String password = "password";
		public static final String email = "mail";
	}

	public static class shippingAddress {

		public static class keys {

			public static final String lastName = "lastName";
			public static final String firstName = "firstName";
	
		}
	}
	

	

	
	
	// Smoke
	public static void typeFirstName(String firstName) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "firstname ", firstName));
			

				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.firstName.get(), firstName);
			
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Firstname field selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}


	public static void typeLastName(String lastName) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "lastname ", lastName));
			
		
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.lastName.get(), lastName);
	
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Last naem field selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Smoke
	public static void typeEmailAddress(String address) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "emailAddress ", address));

				String emailText = SelectorUtil.getElement(RegistrationSelectors.emailAddress.get()).getAttribute("value");
				logs.debug("Email field text : " + emailText);
				if(emailText.isEmpty())
					SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.emailAddress.get(), address);
			
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Email field selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Smoke
	public static void typePassword(String password) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "password ", password));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.password.get(), password);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Password field selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Smoke
	public static void typeCompany(String comapnyName) throws Exception {
		try {
			getCurrentFunctionName(true);
		
	
					SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.companyName.get(), comapnyName);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Company field selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Smoke
	public static void clickRegisterButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, "Register btn"));
			SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.registerBtn.get());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Register button selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Smoke
	public static void fillRegistrationForm(String email, String fName, String lName, String password)
			throws Exception {
		try {
			getCurrentFunctionName(true);
			for(int i = 1 ; i < 3 ; i++) {
			Thread.sleep(1500);
			if (!"".equals(email))
				typeEmailAddress(email);
			}
	
			if (!"".equals(fName))
				typeFirstName(fName);

			if (!"".equals(lName))
				typeLastName(lName);
			
			if (!"".equals(password))
				typePassword(password);

			clickRegisterButton();
			Thread.sleep(5000);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	
	public static void clickSaveButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, "Register btn"));
			SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.saveButton.get(),"ForceAction,click");
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Save button selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	private static void typeAddressLine1(String address) throws Exception {
		try {
			getCurrentFunctionName(true);

				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.AddressLine1.get(), address);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Address field selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	
	private static void typeCity(String city) throws Exception {
		try {
			getCurrentFunctionName(true);

				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.city.get(), city);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "City field selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	
	private static void typeState(String state) throws Exception {
		try {
			getCurrentFunctionName(true);

				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.state.get(), state);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "State drop down selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	
	private static void typeZipcode(String zipcode) throws Exception {
		try {
			getCurrentFunctionName(true);

				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.Zipcode.get(), zipcode);
			
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "ZIP Code field selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	
	public static String getFirstNameError() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "First Name Error"));
			SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.firstNameError.get());
			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "First name error msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	
	public static String getLastNameError() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Last Name Error"));
			SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.lastNameError.get());
			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Last name erro msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	//
	public static String getEmailAddressErrorInvalid() throws Exception {
		try {
			getCurrentFunctionName(true);


				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Email Address Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.emailAddressError.get());
			

			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Email address error msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static String getPasswordError() throws Exception {
		try {
			getCurrentFunctionName(true);


				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Email Address Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.passwordRulesError.get());
			

			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Password error msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}


	public static String getFirstNameErrorInvalid() throws Exception {
		try {
			getCurrentFunctionName(true);

	
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "First name Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.firstNameError.get());
			

			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "First name error msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}


	public static String getLastNameErrorInvalid() throws Exception {
		try {
			getCurrentFunctionName(true);

	
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Last name Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.lastNameError.get());
			

			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Last name error msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static String getRegistrationSuccessMessage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "welcome Message check"));


				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.welcomeMessage.get(), "");
			

			getCurrentFunctionName(false);

			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Registration sucess msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	
	public static void goToRegistrationForm() throws Exception {
		try {
			getCurrentFunctionName(true);
//
			logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT,
					"Navigating to registration page..." + getCONFIG().getProperty("RegistrationPage")));
			getDriver().get(new URI(getDriver().getCurrentUrl()).resolve(getCONFIG().getProperty("RegistrationPage"))
					.toString());

			logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Clicking Register Button"));
			SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.registrationButton.get());

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed
							+ "Navigation to registration form has failed, a selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static void goToMyAccountPage() throws Exception {
		try {
			getCurrentFunctionName(true);

					logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Clicking My Account Tab"));
					getDriver().findElements(By.cssSelector(".headernav-trigger.js-headernav-trigger")).get(2).click();


			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed
							+ "Navigation to My account page has failed, a selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	
	public static String registerFreshUser(String email, String password) throws Exception {

		// Prepare registration data
		String firstName = RandomUtilities.getRandomName();
		String lastName = RandomUtilities.getRandomName();

		return registerFreshUser(email, password, firstName, lastName);
	}

	
	@SuppressWarnings("unchecked")
	public static String registerFreshUser(String email, String password, String fname, String lname) throws Exception {

		// click on register new user button
		Registration.goToRegistrationForm();
		// prepare random address details
		LinkedHashMap<String, String> addressDetails = (LinkedHashMap<String, String>) addresses.get("A3");

		// Prepare registration data
		String firstName = fname;
		String lastName = lname;

		// register new user and validate the results
		Registration.fillRegistrationForm(email, firstName, lastName, password);

		Thread.sleep(2000);
		// Success message needs to be updated on excel to (Welcome to your account at )
		String registrationSuccessMsg = Registration.getRegistrationSuccessMessage();
		return registrationSuccessMsg;
	}
	


}
