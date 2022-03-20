package com.generic.page;


import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;

import com.generic.selector.CartSelectors;
import com.generic.selector.HomePageSelectors;
import com.generic.selector.LoginSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;

public class Login extends SelTestCase {
	
//	public static final String emailAddress = "placer1@gmail.com";
//	public static final String passord = "12341234";
	
	public static boolean verifyLoginHeaderIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Verify Login page is opened</font>");
			boolean isDisplayed = getDriver().findElement(By.className(LoginSelectors.loginPageHeadline)).isDisplayed();
			logs.debug("Login page is opened");
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "login page header selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void typeEmailAddress(String email) throws Exception {
		try {
			getCurrentFunctionName(true);
			String chrome_email = email.split(",")[0];
			String iPad_email = email.split(",")[1];
			String mobile_email = email.split(",")[2];
			LinkedHashMap<String, String> userdetails_chrome = (LinkedHashMap<String, String>) users.get(chrome_email);
			LinkedHashMap<String, String> userdetails_iPad = (LinkedHashMap<String, String>) users.get(iPad_email);
			LinkedHashMap<String, String> userdetails_mobile = (LinkedHashMap<String, String>) users.get(mobile_email);
			String mail = userdetails_chrome.get("mail");
			if (isiPad())
				mail = userdetails_iPad.get("mail");
			if (isMobile())
				mail = userdetails_mobile.get("mail");
			logs.debug("Type user email: " + mail);
			getDriver().findElement(By.cssSelector(LoginSelectors.userNameField)).sendKeys(mail);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "userName Field selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void typePassword(String email) throws Exception {
		try {
			getCurrentFunctionName(true);
			String chrome_email = email.split(",")[0];
			String iPad_email = email.split(",")[1];
			String mobile_email = email.split(",")[2];
			LinkedHashMap<String, String> userdetails_chrome = (LinkedHashMap<String, String>) users.get(chrome_email);
			LinkedHashMap<String, String> userdetails_iPad = (LinkedHashMap<String, String>) users.get(iPad_email);
			LinkedHashMap<String, String> userdetails_mobile = (LinkedHashMap<String, String>) users.get(mobile_email);
			String password = userdetails_chrome.get("password");
			if (isiPad())
				password = userdetails_iPad.get("password");
			if (isMobile())
				password = userdetails_mobile.get("password");
			
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
	
	public static void typeEmailAddress1(String emailAddress) throws Exception {
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
	
	public static void typePassword1(String password) throws Exception {
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
	
	public static void Login (String email) throws Exception {
		getCurrentFunctionName(true);
		typeEmailAddress(email);
		typePassword(email);
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
	
	public static boolean verifyIfUserLoggedIn() throws Exception {
		try {
			getCurrentFunctionName(true);
			Boolean isDisplyed = true;
			logs.debug("Click on My Account icon");
			if (isMobile()) {
				getDriver().findElement(By.cssSelector(HomePageSelectors.navMenu)).click();
				Thread.sleep(2500);
			} else
				getDriver().findElement(By.cssSelector(HomePageSelectors.myAccountIcon)).click();
			logs.debug("verify If User Logged in Successfully");
			isDisplyed = getDriver().findElement(By.cssSelector(LoginSelectors.userName.get())).isDisplayed();
			if (isMobile())
				getDriver().findElement(By.cssSelector(HomePageSelectors.closeNavMenu)).click();
			getCurrentFunctionName(false);
			return isDisplyed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "My Account - User name selectors were not found by selenuim",
					new Object() {
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
					ExceptionMsg.PageFunctionFailed + "My Account - User name selectors were not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

}// End of class
