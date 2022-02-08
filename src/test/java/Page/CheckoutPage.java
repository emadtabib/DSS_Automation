package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Selectors.CheckoutSelectors;
import setup.common;

public class CheckoutPage {

	public static void clickCheckout() throws Exception {
		try {
			System.out.println("Click Checkout in Cart Page");
			WebDriver driver = common.getDriver();
			driver.findElement(By.cssSelector(CheckoutSelectors.checkoutButton)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Checkout Button selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void closeOfferModal() throws Exception {
		try {
			System.out.println("Close Offer Modal in Cart Page");
			WebDriver driver = common.getDriver();
			driver.switchTo().frame(2);
			driver.findElement(By.cssSelector(CheckoutSelectors.closeOfferModal)).click();
			driver.switchTo().parentFrame();
		} catch (NoSuchElementException e) {
			System.out.println("Close Offer Modal Button selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void ContinueToShippingMethod() throws Exception {
		try {
			System.out.println("Click on continue to shipping method ");
			WebDriver driver = common.getDriver();
			driver.findElement(By.cssSelector(CheckoutSelectors.shiipingAddress_continueToShippingMethod)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Checkout Button selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void ContinueToPayment() throws Exception {
		try {
			System.out.println("Click Checkout in Cart Page");
			WebDriver driver = common.getDriver();
			driver.findElement(By.cssSelector(CheckoutSelectors.shippingMethod_continueToPayment)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Checkout Button selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void typePONumber() throws Exception {
		try {
			System.out.println("type PO Number: 00");
			WebDriver driver = common.getDriver();
			driver.findElement(By.cssSelector(CheckoutSelectors.poNumber)).sendKeys("00");
		} catch (NoSuchElementException e) {
			System.out.println("PO Number selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void placeOrder() throws Exception {
		try {
			System.out.println("Click Place Order Button");
			WebDriver driver = common.getDriver();
			driver.findElement(By.cssSelector(CheckoutSelectors.placeOrder)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Place order Button selector was not found by selenuim");
			throw e;
		}
	}

		public static String getSuccessMessage() throws Exception {
			try {
				String globalMessage = "";
				System.out.println("Get Global Message for Order Confirmation");
				WebDriver driver = common.getDriver();
				
				globalMessage =  driver.findElement(By.cssSelector(CheckoutSelectors.globalMessage)).getText();
				System.out.println("Place order success message: " + globalMessage);
				return globalMessage;
			} catch (NoSuchElementException e) {
				System.out.println("Global message selector was not found by selenuim");
				throw e;
			}
		
	}
	
		public static String getOrderNumber() throws Exception {
			try {
				String orderNumber = "";
				System.out.println("Get order number in Order Confirmation oage");
				WebDriver driver = common.getDriver();
				orderNumber =  driver.findElements(By.cssSelector(CheckoutSelectors.orderComponents)).get(0).getText();
				System.out.println("Order Number Is: " + orderNumber);
				return orderNumber;
			} catch (NoSuchElementException e) {
				System.out.println("Order number selector was not found by selenuim");
				throw e;
			}
		
	}
		
		public static String getOrderStatus() throws Exception {
			try {
				String orderStatus = "";
				System.out.println("Get order status from Order Confirmation page");
				WebDriver driver = common.getDriver();
				
				orderStatus =  driver.findElement(By.cssSelector(CheckoutSelectors.globalMessage)).getText();
				System.out.println("order status: " + orderStatus);
				return orderStatus;
			} catch (NoSuchElementException e) {
				System.out.println("order status selector was not found by selenuim");
				throw e;
			}
		
	}
			
	
		
}
