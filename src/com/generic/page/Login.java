package com.generic.page;


import java.net.URI;
import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.generic.selector.HomePageSelectors;
import com.generic.selector.LoginSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.GlobalVariables;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

public class Login extends SelTestCase {
	
//	public static final String emailAddress = "placer1@gmail.com";
//	public static final String passord = "12341234";

	/**
	 * Fill the login form and click submit button.
	 *
	 * @param email
	 * @param Password
	 * @throws Exception
	 */
	public static void fillLoginFormAndClickSubmit(String email, String Password) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT,
					"Navigating to login page..." + getCONFIG().getProperty("RegistrationPage")));
			getDriver().get(new URI(getDriver().getCurrentUrl()).resolve(getCONFIG().getProperty("RegistrationPage"))
					.toString());

			typeEmailAddress(email);
			typePassword(Password);
			Thread.sleep(2000);
			clickSubmitSignIn();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ " Fill Login form has failed, a selector can't be found by selenium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void typeEmailAddress(String emailAddress) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Type user email: "+ emailAddress);
			getDriver().findElement(By.cssSelector(LoginSelectors.userNameField)).sendKeys(emailAddress);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "userName Field selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void typePassword(String password) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Type password: "+ password);
			getDriver().findElement(By.cssSelector(LoginSelectors.passwordField)).sendKeys(password);
			getCurrentFunctionName(false);
		
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "password Field selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	
	public static void clickSubmitSignIn() throws Exception {
		try {
			getCurrentFunctionName(true);
			getDriver().findElement(By.cssSelector(LoginSelectors.singInButton)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "singIn Button selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static boolean checkUserAccount() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isUserLogedIn = false;		

			// Validate the welcome message if it is exist.
					SelectorUtil.initializeSelectorsAndDoActions(LoginSelectors.welcomeMessage);
					Thread.sleep(1000);
//					if (SelectorUtil.isElementExist(By.cssSelector(LoginSelectors.welcomeMessage.get()));
						isUserLogedIn = true;


			getCurrentFunctionName(false);

			return isUserLogedIn;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + " Welcome message selector can't be found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void Login(LinkedHashMap<String, String> userDetalis) throws Exception {

		typeEmailAddress(userDetalis.get("mail"));
		typePassword(userDetalis.get("password"));
		Thread.sleep(2000);
		clickSubmitSignIn();

	}
	
	public static void Login (String email, String password) throws Exception {
		getCurrentFunctionName(true);
		typeEmailAddress(email);
		typePassword(password);
		clickSubmitSignIn();
		getCurrentFunctionName(false);

	}
	
	public static boolean verifyIfUserLoggedInSuccessfully() {
		try {
			getCurrentFunctionName(true);
			Boolean isDisplyed = true;
			logs.debug("verify If User Logged in Successfully");
			isDisplyed = getDriver().findElement(By.cssSelector(LoginSelectors.AccAlert)).isDisplayed();
			if(isDisplyed)
			logs.debug("Error message is displayed while trying to login in");
			getCurrentFunctionName(false);
			return !isDisplyed;
		} catch (NoSuchElementException e) {
			logs.debug("Logged in Successfully");
			return true;
		}
	}
	
	public static boolean verifyIfUserLoggedIn() {
		try {
			getCurrentFunctionName(true);
			Boolean isDisplyed = true;
			logs.debug("Click on My Account icon");
			getDriver().findElement(By.cssSelector(HomePageSelectors.myAccountIcon)).click();	
			logs.debug("verify If User Logged in Successfully");
			isDisplyed = getDriver().findElement(By.cssSelector(LoginSelectors.userName)).isDisplayed();
			getCurrentFunctionName(false);
			return isDisplyed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "My Account - User name selectors were not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickMyAccountMenu() {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on My Account icon");
			getDriver().findElement(By.cssSelector(HomePageSelectors.myAccountIcon)).click();	
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "My Account - User name selectors were not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

}// End of class

