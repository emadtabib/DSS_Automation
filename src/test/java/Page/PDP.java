package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import Selectors.PDPSelectors;
import setup.common;

public class PDP {

	public static void clickAddToCartButton() throws Exception {
		try {
			System.out.println("Click Add To Cart Button ");
			WebDriver driver = common.getDriver();
			driver.findElement(By.cssSelector(PDPSelectors.addToCartButton)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Add To Cart Button selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void verifyAddToCartLayerIsDisplayed() throws Exception {
		try {
			System.out.println("Verify Add To Cart Layer Is Displayed");
			WebDriver driver = common.getDriver();
			driver.findElement(By.cssSelector(PDPSelectors.addToCartLayer)).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Add To Cart Layer selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void clickProceedToCheckout() throws Exception {
		try {
			System.out.println("Click Proceed To Checkout");
			WebDriver driver = common.getDriver();
			driver.findElement(By.cssSelector(PDPSelectors.proceedToCheckout)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Proceed To Checkout Button selector was not found by selenuim");
			throw e;
		}

	}
}
