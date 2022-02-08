package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import Selectors.HomePageSelectors;
import Selectors.SignInSelectors;
import setup.common;

public class SignInPage {
	public static final String emailAddress = "placer1@gmail.com";
	public static final String passord = "12341234";
	
	public static void typeEmailAddress() throws Exception {
		try {
			WebDriver driver = common.getDriver();
			driver.findElement(By.cssSelector(SignInSelectors.userNameField)).sendKeys(emailAddress);
		} catch (NoSuchElementException e) {
			System.out.println("userName Field selector was not found by selenuim");
			throw e;
		}
	}
	
	public static void typePassword() throws Exception {
		try {
			WebDriver driver = common.getDriver();
			driver.findElement(By.cssSelector(SignInSelectors.passwordField)).sendKeys(passord);
		
		} catch (NoSuchElementException e) {
			System.out.println("password Field selector was not found by selenuim");
			throw e;
		}

	}
	
	
	public static void clickSubmitSignIn() throws Exception {
		try {
			WebDriver driver = common.getDriver();
			driver.findElement(By.cssSelector(SignInSelectors.singInButton)).click();
		} catch (NoSuchElementException e) {
			System.out.println("singIn Button selector was not found by selenuim");
			throw e;
		}

	}

	public static void Login() throws Exception {

		typeEmailAddress();
		typePassword();
		clickSubmitSignIn();

	}
}
