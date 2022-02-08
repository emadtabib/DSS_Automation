package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import Selectors.HomePageSelectors;
import setup.common;

public class HomePage {

	public static void closeSignUpModal() throws Exception {
		try {
			System.out.println("Close Sign Up Modal");
			WebDriver driver = common.getDriver();
			driver.findElement(By.cssSelector(HomePageSelectors.closeSignUpModal)).click();
		} catch (NoSuchElementException e) {
			System.out.println("close SignUp Modal selector was not found by selenuim");
			throw e;
		}
	}
	
	public static void clickSignIn() throws Exception {
		try {
			System.out.println("Click on My Account icon");
			WebDriver driver = common.getDriver();
			driver.findElement(By.cssSelector(HomePageSelectors.myAccountIcon)).click();
			driver.findElement(By.cssSelector(HomePageSelectors.signinLink)).click();
		} catch (NoSuchElementException e) {
			System.out.println("myAccount icon selector was not found by selenuim");
			throw e;
		}

	}
	
	
		public static void SearchAndPickItem(String searchTerm) throws Exception {
			try {
				System.out.println("Search for a given term");
				WebDriver driver = common.getDriver();
				driver.findElement(By.cssSelector(HomePageSelectors.search)).sendKeys(searchTerm);
				driver.findElement(By.cssSelector(HomePageSelectors.searchSuggestions)).click();
			} catch (NoSuchElementException e) {
				System.out.println("Search icon selector was not found by selenuim");
				throw e;
			}

		}
	
}
