package com.generic.page;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import com.generic.selector.HomePageSelectors;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

public class HomePage extends SelTestCase {

	public static void closeSignUpModal() throws Exception {
		try {
			System.out.println("Close Sign Up Modal if displayed");
//			boolean isNotDisplayed;
//			String subStrArr = HomePageSelectors.closeSignUpModal;
//			isNotDisplayed = getDriver().findElement(By.cssSelector(HomePageSelectors.closeSignUpModal)).isDisplayed();
//			logs.debug("Sign Up Modal is displayed : " + !isNotDisplayed);
//			if(!isNotDisplayed)
			getDriver().findElement(By.cssSelector(HomePageSelectors.closeSignUpModal)).click();
		} catch (NoSuchElementException e) {
			System.out.println("close SignUp Modal selector was not found by selenuim");
			throw e;
		}
	}
	
	public static void clickSignIn() throws Exception {
		try {
			System.out.println("Click on My Account icon");
			getDriver().findElement(By.cssSelector(HomePageSelectors.myAccountIcon)).click();
			getDriver().findElement(By.cssSelector(HomePageSelectors.signinLink)).click();
		} catch (NoSuchElementException e) {
			System.out.println("myAccount icon selector was not found by selenuim");
			throw e;
		}

	}
	
	
		public static void SearchAndPickItem(String searchTerm) throws Exception {
			try {
				System.out.println("Search for a given term");
				getDriver().findElement(By.cssSelector(HomePageSelectors.search)).sendKeys(searchTerm);
				
				List<WebElement> items = new ArrayList<WebElement>();
				items = SelectorUtil.getAllElements(HomePageSelectors.searchSuggestions);
				items.remove(items.size() - 1);
				
				logs.debug("WebElement List Size = " + items.size());
				Random random = new Random();
				int index = random.nextInt(items.size() - 1);
				items.get(index).click();
				
			} catch (NoSuchElementException e) {
				System.out.println("Search icon selector was not found by selenuim");
				throw e;
			}

		}
		
		//////////////////////////////////
	

}// End of class