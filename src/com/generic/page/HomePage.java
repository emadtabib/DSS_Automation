package com.generic.page;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.generic.selector.HomePageSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

public class HomePage extends SelTestCase {

	public static void closeSignUpModal() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Close Sign Up Modal if displayed");
//			boolean isNotDisplayed;
//			String subStrArr = HomePageSelectors.closeSignUpModal;
//			isNotDisplayed = getDriver().findElement(By.cssSelector(HomePageSelectors.closeSignUpModal)).isDisplayed();
//			logs.debug("Sign Up Modal is displayed : " + !isNotDisplayed);
//			if(!isNotDisplayed)
			getDriver().findElement(By.cssSelector(HomePageSelectors.closeSignUpModal)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "close SignUp Modal selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickSignIn() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on My Account icon");
			getDriver().findElement(By.cssSelector(HomePageSelectors.myAccountIcon)).click();
			getDriver().findElement(By.cssSelector(HomePageSelectors.signinLink)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "myAccount icon selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	
	public static void SearchAndPickItem(String searchTerm) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Search for a given term");
			getDriver().findElement(By.cssSelector(HomePageSelectors.search)).sendKeys(searchTerm);

			List<WebElement> items = new ArrayList<WebElement>();
			items = SelectorUtil.getAllElements(HomePageSelectors.searchSuggestions);
			items.remove(items.size() - 1);

			logs.debug("WebElement List Size = " + items.size());
			Random random = new Random();
			int index = random.nextInt(items.size() - 1);
			items.get(index).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Search icon selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static void Signout() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on My signout link");
			getDriver().findElement(By.className(HomePageSelectors.signout)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "myAccount icon selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

}// End of class