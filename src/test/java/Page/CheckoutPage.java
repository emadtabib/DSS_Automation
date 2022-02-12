package Page;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Selectors.CheckoutSelectors;
import setup.common;

public class CheckoutPage {
	
	public static String getOrderSummaryItems(int index) throws Exception {
		try {
			String orderSubtotal = "";
			System.out.println("Get Order Summary Item: " + index);
			WebDriver driver = common.getDriver();
			
			orderSubtotal =  driver.findElements(By.cssSelector(CheckoutSelectors.Cart_OrderSubtotal)).get(index).getText();
			System.out.println("order status: " + orderSubtotal);
			return orderSubtotal;
		} catch (NoSuchElementException e) {
			System.out.println("Order Summary Item: " + index + " selector was not found by selenuim");
			throw e;
		}
	
}
	
	public static String getEstimatedTotalInFromOrderSummary() throws Exception {
		try {
			String estimatedTotal = "";
			System.out.println("Get Estimated Total from Cart page");
			WebDriver driver = common.getDriver();
			
			estimatedTotal =  driver.findElements(By.cssSelector(CheckoutSelectors.Cart_OrderSubtotal)).get(3).getText();
			System.out.println("order status: " + estimatedTotal);
			return estimatedTotal;
		} catch (NoSuchElementException e) {
			System.out.println("estimatedTotal selector was not found by selenuim");
			throw e;
		}
	
}

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
	
	public static void fillShippingAddressForm(String Eamil, String firstName, String lastName, String addressLine1, String City, String State, String postCode, String phoneNumber) throws Exception {
		try {
			System.out.println("Fill Shipping Address Form");
			typeEmailAddress(Eamil);
			typeFirstName(firstName);
			typeLastName(lastName);
			typeAddressLine1(addressLine1);
			typeCity(City);
			selectState(State);
			typeZipCode(postCode);
			typePhoneNumber(phoneNumber);
			ContinueToShippingMethod();
			useEnteredAddress();
		} catch (NoSuchElementException e) {
			System.out.println("Failed to fill the Shipping Address Form");
			throw e;
		}

	}
	
	public static void typeEmailAddress(String emailAddress) throws Exception {
		try {
			System.out.println("type email Address " + emailAddress);
			WebDriver driver = common.getDriver();
			driver.findElement(By.id(CheckoutSelectors.emailAddress)).sendKeys(emailAddress);
		} catch (NoSuchElementException e) {
			System.out.println("emailAddress selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void typeFirstName(String firstName) throws Exception {
		try {
			System.out.println("type firstName: " + firstName);
			WebDriver driver = common.getDriver();
			driver.findElement(By.id(CheckoutSelectors.firstName)).sendKeys(firstName);
		} catch (NoSuchElementException e) {
			System.out.println("firstName selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void typeLastName(String surName) throws Exception {
		try {
			System.out.println("type Last Name"+ surName);
			WebDriver driver = common.getDriver();
			driver.findElement(By.id(CheckoutSelectors.surName)).sendKeys(surName);
		} catch (NoSuchElementException e) {
			System.out.println("surName selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void typeAddressLine1(String addressLine1) throws Exception {
		try {
			System.out.println("type address Line1: " + addressLine1);
			WebDriver driver = common.getDriver();
			driver.findElement(By.id(CheckoutSelectors.addressLine1)).sendKeys(addressLine1);
		} catch (NoSuchElementException e) {
			System.out.println("addressLine1 selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void typeCity(String City) throws Exception {
		try {
			System.out.println("type City: " + City);
			WebDriver driver = common.getDriver();
			driver.findElement(By.id(CheckoutSelectors.addressTownCity)).sendKeys(City);
		} catch (NoSuchElementException e) {
			System.out.println("addressTownCity selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void selectState(String State) throws Exception {
		try {
			System.out.println("type state: " + State);
			WebDriver driver = common.getDriver();
			WebElement stateOptions = driver.findElement(By.id(CheckoutSelectors.addressRegion));
			Select select = new Select(stateOptions);
			select.selectByVisibleText(State);
		} catch (NoSuchElementException e) {
			System.out.println("State selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void typeZipCode(String ZipCode) throws Exception {
		try {
			System.out.println("type ZipCode: " + ZipCode);
			WebDriver driver = common.getDriver();
			driver.findElement(By.id(CheckoutSelectors.postCode)).sendKeys(ZipCode);
		} catch (NoSuchElementException e) {
			System.out.println("postCode selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void typePhoneNumber(String phoneNumber) throws Exception {
		try {
			System.out.println("type Phone Number: " + phoneNumber);
			WebDriver driver = common.getDriver();
			driver.findElement(By.id(CheckoutSelectors.addressPhone)).sendKeys(phoneNumber);
		} catch (NoSuchElementException e) {
			System.out.println("Phone Number selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void useEnteredAddress() throws Exception {
		try {
			System.out.println("Click on Use Entered Address btn ");
			WebDriver driver = common.getDriver();
			driver.findElement(By.cssSelector(CheckoutSelectors.useEnteredAddressbtn)).click();
		} catch (NoSuchElementException e) {
			System.out.println("Use Entered Addressbtn Button selector was not found by selenuim");
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
	
	public static Boolean validateEstimatedTotalIsCorrect(String Subtotal, String Shipping, String Tax, String estimtedTotal) throws Exception {
		try {
			System.out.println("validate Estimated Total Is Correct");
			double orderSubtotal = Double.parseDouble(Subtotal.replace('$', ' ').trim());
			double orderShipping = Double.parseDouble(Shipping.replace('$', ' ').trim());
			double orderTax = Double.parseDouble(Tax.replace('$', ' ').trim());
			double orderEstimatedTotal = Double.parseDouble(estimtedTotal.replace('$', ' ').trim());
			double ExpectedTotal = orderSubtotal + orderShipping +orderTax;
			System.out.println("Expected Total: " + ExpectedTotal);
			System.out.println("Estimated Total displayed on the page is: " + orderEstimatedTotal);
			DecimalFormat df = new DecimalFormat("####0.00");
			double expected = Double.parseDouble(df.format(ExpectedTotal));
		
			return expected == orderEstimatedTotal;
		} catch (NoSuchElementException e) {
	
			throw e;
		}
	
}
	
	public static void selectshippingMethods(int index) throws Exception {
		try {
			System.out.println("Select a shipping Method with index: " + index);
			WebDriver driver = common.getDriver();
			driver.findElements(By.cssSelector(CheckoutSelectors.shippingMethods)).get(index).click();
		} catch (NoSuchElementException e) {
			System.out.println("select shipping Methods radio button selector was not found by selenuim");
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
	
	public static void typeCardholderName(String cardholderName) throws Exception {
		try {
			System.out.println("type Cardholder Name: ");
			WebDriver driver = common.getDriver();
			driver.findElement(By.id(CheckoutSelectors.card_nameOnCard)).sendKeys(cardholderName);
		} catch (NoSuchElementException e) {
			System.out.println("name On Card selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void typeAccountNumber(String accountNumber) throws Exception {
		try {
			System.out.println("type account number: " + accountNumber);
			WebDriver driver = common.getDriver();
			driver.findElement(By.id(CheckoutSelectors.card_accountNumber)).sendKeys(accountNumber);
		} catch (NoSuchElementException e) {
			System.out.println("account number selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void selectExpiryMonth(String ExpiryMonth) throws Exception {
		try {
			System.out.println("Select Expiry Month: " + ExpiryMonth);
			WebDriver driver = common.getDriver();
			WebElement ExpiryMonthOptions = driver.findElement(By.id(CheckoutSelectors.ExpiryMonth));
			Select select = new Select(ExpiryMonthOptions);
			select.selectByVisibleText(ExpiryMonth);
		} catch (NoSuchElementException e) {
			System.out.println("ExpiryMonth selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void selectExpiryYear(String ExpiryYear) throws Exception {
		try {
			System.out.println("Select Expiry Year: " + ExpiryYear);
			WebDriver driver = common.getDriver();
			WebElement ExpiryYearOptions = driver.findElement(By.id(CheckoutSelectors.ExpiryYear));
			Select select = new Select(ExpiryYearOptions);
			select.selectByVisibleText(ExpiryYear);
		} catch (NoSuchElementException e) {
			System.out.println("ExpiryYear selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void typeCVV(String cvv) throws Exception {
		try {
			System.out.println("type cvv : " + cvv);
			WebDriver driver = common.getDriver();
			driver.findElement(By.id(CheckoutSelectors.card_cvNumber)).sendKeys(cvv);
		} catch (NoSuchElementException e) {
			System.out.println("cvv selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void useDeliveryAddress() throws Exception {
		try {
			System.out.println("Click useDeliveryAddress radio Button");
			WebDriver driver = common.getDriver();
			driver.findElement(By.id(CheckoutSelectors.useDeliveryAddress)).click();
		} catch (NoSuchElementException e) {
			System.out.println("useDeliveryAddress Button selector was not found by selenuim");
			throw e;
		}
	}
	
	public static void fillPaymentDetails(String cardholderName, String accountNumber, String ExpiryMonth, String ExpiryYear, String cvv) throws Exception {
		try {
			System.out.println("Fill Shipping Address Form");
			typeCardholderName(cardholderName);
			typeAccountNumber(accountNumber);
			selectExpiryMonth(ExpiryMonth);
			selectExpiryYear(ExpiryYear);
			typeCVV(cvv);
			useDeliveryAddress();
		} catch (NoSuchElementException e) {
			System.out.println("Failed to fill the Payment Details form");
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
