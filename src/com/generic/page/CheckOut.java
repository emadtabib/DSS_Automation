package com.generic.page;


import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.generic.selector.CartSelectors;
import com.generic.selector.CheckOutSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

public class CheckOut extends SelTestCase {
	
	public static String getOrderSummaryItems(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			String orderSubtotal = "";
			logs.debug("Get Order Summary Item: " + index);
			orderSubtotal = getDriver().findElements(By.cssSelector(CheckOutSelectors.OrderSubtotal)).get(index)
					.getText();
			logs.debug("<font color=#f442cb>order item(" + index + "): </font><font color=#b86d29>" + orderSubtotal + "</font>");
			getCurrentFunctionName(false);
			return orderSubtotal;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed + "Order Summary Item: " + index
					+ " selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static String getcheckoutTitle() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Checkout Title");
			String checkoutTitle = getDriver().findElement(By.cssSelector(CheckOutSelectors.checkoutTitle)).getText();
			logs.debug("<font color=#f442cb>Get Checkout Title: </font><font color=#b86d29>" + checkoutTitle + "</font>");
			getCurrentFunctionName(false);
			return checkoutTitle;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed + "Checkout Title selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}
	
	public static int checkProductsinStepTwo() throws Exception {
		try {
			getCurrentFunctionName(true);
			int productsNumber = SelectorUtil.getAllElements(CheckOutSelectors.productContainerInCheckout).size();
			
			logs.debug("Found: " + productsNumber + " Products in Shipping Page");
			getCurrentFunctionName(false);
			return productsNumber;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Products container in step two selector was not found by selenium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	
	public static void closeOfferModal() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Close Offer Modal in Cart Page if displayed");
			boolean isNotDisplayed;
			String subStrArr = CheckOutSelectors.closeOfferModal;
			isNotDisplayed = SelectorUtil.isNotDisplayed(subStrArr);
			logs.debug("Close Offer Modal in Cart Page is displayed : " + !isNotDisplayed);
			if (!isNotDisplayed) {
				getDriver().switchTo().frame(2);
				getDriver().findElement(By.cssSelector(CheckOutSelectors.closeOfferModal)).click();
				getDriver().switchTo().parentFrame();
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			System.out.println("Close Offer Modal Button selector was not found by selenuim");
		}

	}
	
	public static void selectDeliveryAddressDropDown(String deliveryAddress) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Select Delivery Address DropDown: </font><font color=#b86d29>" + deliveryAddress + "</font>");
			WebElement deliveryAddressDropDown = getDriver().findElement(By.name(CheckOutSelectors.deliveryAddressDropDown));
			Select select = new Select(deliveryAddressDropDown);
			logs.debug("<font color=#f442cb>select.getOptions():  </font><font color=#b86d29>" + select.getOptions().size() + "</font>");
			logs.debug("<font color=#f442cb>select.getOptions():  </font><font color=#b86d29>" + select.getOptions() + "</font>");
			logs.debug("<font color=#f442cb>select.getOptions():  </font><font color=#b86d29>" + select.getAllSelectedOptions() + "</font>");
			select.selectByValue(deliveryAddress);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Delivery Address DropDown selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static void fillShippingAddressForm(LinkedHashMap<String, String> addressDetalis) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Fill Shipping Address Form");
			typeEmailAddress(getCONFIG().getProperty("GuestEmail"));
			typeFirstName(addressDetalis.get(CheckOut.shippingAddress.keys.firstName));
			typeLastName(addressDetalis.get(CheckOut.shippingAddress.keys.lastName));
			typeAddressLine1(addressDetalis.get(CheckOut.shippingAddress.keys.streetAddress));
			typeCityG(addressDetalis.get(CheckOut.shippingAddress.keys.city));
			selectStateG(addressDetalis.get(CheckOut.shippingAddress.keys.state));
			typeZipCode(addressDetalis.get(CheckOut.shippingAddress.keys.zipcode));
			typePhoneNumber(addressDetalis.get(CheckOut.shippingAddress.keys.phone));
			ContinueToShippingMethod();
			if(!isDesktop())
				Thread.sleep(5000);
			useEnteredAddress();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			System.out.println("Failed to fill the Shipping Address Form");
			throw e;
		}

	}
	
	public static void typeEmailAddress(String emailAddress) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>type email Address: </font><font color=#b86d29>" + emailAddress + "</font>");
			getDriver().findElement(By.id(CheckOutSelectors.emailAddress)).sendKeys(emailAddress);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			System.out.println("emailAddress selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void typeFirstName(String firstName) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Type firstName: </font><font color=#b86d29>" + firstName + "</font>");
			getDriver().findElement(By.id(CheckOutSelectors.firstName)).sendKeys(firstName);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			System.out.println("firstName selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void typeLastName(String surName) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Type Last Name: </font><font color=#b86d29>" + surName + "</font>");
			getDriver().findElement(By.id(CheckOutSelectors.surName)).sendKeys(surName);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			System.out.println("surName selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void typeAddressLine1(String addressLine1) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Type address Line1: </font><font color=#b86d29>" + addressLine1 + "</font>");
			getDriver().findElement(By.id(CheckOutSelectors.addressLine1)).sendKeys(addressLine1);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			System.out.println("addressLine1 selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void typeCityG(String City) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Type City: </font><font color=#b86d29>" + City + "</font>");
			getDriver().findElement(By.id(CheckOutSelectors.addressTownCity)).sendKeys(City);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			System.out.println("addressTownCity selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void selectStateG(String State) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Type State: </font><font color=#b86d29>" + State + "</font>");
			WebElement stateOptions = getDriver().findElement(By.id(CheckOutSelectors.addressRegion));
			Select select = new Select(stateOptions);
			select.selectByVisibleText(State);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			System.out.println("State selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void typeZipCode(String ZipCode) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Type ZipCode: </font><font color=#b86d29>" + ZipCode + "</font>");
			getDriver().findElement(By.id(CheckOutSelectors.postCode)).sendKeys(ZipCode);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			System.out.println("postCode selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void typePhoneNumber(String phoneNumber) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Type phoneNumber: </font><font color=#b86d29>" + phoneNumber + "</font>");
			getDriver().findElement(By.id(CheckOutSelectors.addressPhone)).sendKeys(phoneNumber);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			System.out.println("Phone Number selector was not found by selenuim");
			throw e;
		}

	}
	
	public static void useEnteredAddress() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on Use Entered Address btn ");
			getDriver().findElement(By.cssSelector(CheckOutSelectors.useEnteredAddressbtn)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Use Entered Addressbtn Button selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static void ContinueToShippingMethod() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on continue to shipping method ");
			getDriver().findElement(By.id(CheckOutSelectors.shiipingAddress_continueToShippingMethod.get())).click();
			getCurrentFunctionName(false); 
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Checkout Button selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static Boolean validateEstimatedTotalIsCorrect(String Subtotal, String Shipping, String Tax,
			String estimtedTotal) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("validate Estimated Total Is Correct");
			double orderSubtotal = Double.parseDouble(Subtotal.replace('$', ' ').trim());
			double orderShipping = 0.0;
			if (!Shipping.toLowerCase().contains("free"))
				orderShipping = Double.parseDouble(Shipping.replace('$', ' ').trim());
			double orderTax = 0.0;
			if (!Tax.toLowerCase().contains("free"))
				orderTax = Double.parseDouble(Tax.replace('$', ' ').trim());
			double orderEstimatedTotal = Double.parseDouble(estimtedTotal.replace('$', ' ').trim());
			double ExpectedTotal = orderSubtotal + orderShipping + orderTax;
			logs.debug("Expected Total: " + ExpectedTotal);
			logs.debug("Estimated Total displayed on the page is: " + orderEstimatedTotal);
			DecimalFormat df = new DecimalFormat("####0.00");
			double expected = Double.parseDouble(df.format(ExpectedTotal));
			getCurrentFunctionName(false);
			return expected == orderEstimatedTotal;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Place order Button selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static void selectshippingMethods(String shippingMethod) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Select a shipping Method: </font><font color=#b86d29>" + shippingMethod + "</font>");
			getDriver().findElement(By.xpath("//span[contains(text(),'" + shippingMethod + "')]")).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "select shipping Methods radio button selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static void ContinueToPayment() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click Continue To Payment");
			getDriver().findElement(By.id(CheckOutSelectors.shippingMethod_continueToPayment.get())).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Checkout Button selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static void typeCardholderName(String cardholderName) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("type Cardholder Name: ");
			getDriver().findElement(By.id(CheckOutSelectors.card_nameOnCard)).sendKeys(cardholderName);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "name On Card selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static void typeAccountNumber(String accountNumber) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Type CC number:: </font><font color=#b86d29>" + accountNumber + "</font>");
			getDriver().findElement(By.id(CheckOutSelectors.card_accountNumber)).sendKeys(accountNumber);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "account number selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static void selectExpiryMonth(String ExpiryMonth) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Select Expiry Month: " + ExpiryMonth);
			WebElement ExpiryMonthOptions = getDriver().findElement(By.id(CheckOutSelectors.ExpiryMonth));
			Select select = new Select(ExpiryMonthOptions);
			select.selectByVisibleText(ExpiryMonth);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "ExpiryMonth selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static void selectExpiryYear(String ExpiryYear) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Select Expiry Year: " + ExpiryYear);
			WebElement ExpiryYearOptions = getDriver().findElement(By.id(CheckOutSelectors.ExpiryYear));
			Select select = new Select(ExpiryYearOptions);
			select.selectByVisibleText(ExpiryYear);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "ExpiryYear selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static void typeCVV(String cvv) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("type cvv : " + cvv);
			getDriver().findElement(By.name(CheckOutSelectors.card_cvNumber)).sendKeys(cvv);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed + "cvv selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static void useDeliveryAddress() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click useDeliveryAddress radio Button");
			getDriver().findElement(By.id(CheckOutSelectors.useDeliveryAddress)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "useDeliveryAddress Button selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void fillPaymentDetails(LinkedHashMap<String, String> paymentDetails) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Fill Payment Address Form");
			typeCardholderName(CheckOut.paymentInformation.keys.name);
			typeAccountNumber(paymentDetails.get(CheckOut.paymentInformation.keys.number));
			selectExpiryMonth(paymentDetails.get(CheckOut.paymentInformation.keys.expireMonth));
			selectExpiryYear(paymentDetails.get(CheckOut.paymentInformation.keys.expireYear));
			typeCVV(paymentDetails.get(CheckOut.paymentInformation.keys.CVCC));
			useDeliveryAddress();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed + "Failed to fill the Payment Details form",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void selectSavedPaymentMethod(String payment, String estimatedOrder, Double Placer1ThresholdAmount) throws Exception {
		try {
			getCurrentFunctionName(true);
			@SuppressWarnings("unchecked")
			LinkedHashMap<String, String> paymentDetails = (LinkedHashMap<String, String>) paymentCards.get(payment);
			logs.debug("Select Saved Payment Method");
			double orderEstimatedTotal = Double.parseDouble(estimatedOrder.replace('$', ' ').trim());

			if (orderEstimatedTotal > Placer1ThresholdAmount) {

				logs.debug("<font color=#f442cb> Estimated Order Total is greater than the Placer1 Threshold Amount </font>");
				logs.debug("Type PO Number: ");
				//getDriver().findElement(By.id(CheckOutSelectors.PaymentTypeSelectionNONE)).click();
				typePONumber();
			} else {
				if (payment != "PayPal") {
					getDriver().findElement(By.id(CheckOutSelectors.CCPaymentButton)).click();
					typeCVV(paymentDetails.get(CheckOut.paymentInformation.keys.CVCC));
				} else {
					getDriver().findElement(By.id(CheckOutSelectors.PayPalPaymentButton)).click();

				}
			}

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Saved Payment Method selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void typePONumber() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("type PO Number: 00");
			getDriver().findElement(By.cssSelector(CheckOutSelectors.poNumber)).sendKeys("00");
			getCurrentFunctionName(false);
	} catch (NoSuchElementException e) {
		logs.debug(MessageFormat.format(
				ExceptionMsg.PageFunctionFailed + "PO Number selector was not found by selenuim",
				new Object() {
				}.getClass().getEnclosingMethod().getName()));
		throw e;
	}
	}

	public static void placeOrder() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click Place Order Button");
			if (isMobile())
				getDriver().findElements(By.cssSelector(CheckOutSelectors.placeOrder)).get(1).click();
			else
				getDriver().findElement(By.cssSelector(CheckOutSelectors.placeOrder)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Place order Button selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void closeFeedbackModal() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click No Thanks Button");
			if (!SelectorUtil.isNotDisplayed(CheckOutSelectors.FeedbackModal_NoThanks))
				SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.FeedbackModal_NoThanks);
//			getDriver().findElement(By.cssSelector(CheckOutSelectors.FeedbackModal_NoThanks)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug("feedback modal is not displayed");
		}
	}
	
	public static String getSuccessMessage() throws Exception {
		try {
			getCurrentFunctionName(true);
			String globalMessage = "";
			logs.debug("Get Global Message for Order Confirmation");
			globalMessage = getDriver().findElement(By.cssSelector(CheckOutSelectors.globalMessage)).getText();
			logs.debug("<font color=#f442cb>Place order success message: </font><font color=#b86d29> " + globalMessage + "</font>");
			getCurrentFunctionName(false);
			return globalMessage;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Global message selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static String getOrderNumber() throws Exception {
		try {
			getCurrentFunctionName(true);
			String orderNumber = "";
			logs.debug("Get order number in Order Confirmation oage");
			orderNumber = getDriver().findElements(By.cssSelector(CheckOutSelectors.orderComponents)).get(0).getText();
			logs.debug("<font color=#f442cb>Order Number Is: </font><font color=#b86d29>" + orderNumber + "</font>");
			getCurrentFunctionName(false);
			return orderNumber;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Order number selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static String getOrderStatus() throws Exception {
		try {
			getCurrentFunctionName(true);
			String orderStatus = "";
			logs.debug("Get order status from Order Confirmation page");

			orderStatus = getDriver().findElements(By.cssSelector(CheckOutSelectors.orderComponents)).get(1).getText();
			logs.debug("order status: " + orderStatus);
			getCurrentFunctionName(false);
			return orderStatus;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "order status selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
		
	public static int checkProductsInOrderConfirmationPage() throws Exception {
		try {
			getCurrentFunctionName(true);
			int productsNumber = SelectorUtil.getAllElements(CheckOutSelectors.productContainerInOrderConfirmationPage).size();
			
			logs.debug("Found: " + productsNumber + " Products in Order Confirmation Page");
			getCurrentFunctionName(false);
			return productsNumber;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Products container in Order Confirmation Page selector was not found by selenium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static int getitemsQuantityInCheckoutPges() throws Exception {
		try {
			getCurrentFunctionName(true);
			
			int itemsQty = 0;
			logs.debug("Get items Quantity from checkout pages");
			int numberOfProducts = getDriver().findElements(By.cssSelector(CheckOutSelectors.itemsQuantityInCheckoutPages)).size();
			for (int index = 0; index < numberOfProducts; index++ )
			itemsQty = itemsQty + Integer.parseInt(getDriver().findElements(By.cssSelector(CheckOutSelectors.itemsQuantityInCheckoutPages)).get(index).getText());
			logs.debug("items Quantity:  " + itemsQty);
			getCurrentFunctionName(false);
			return itemsQty;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "items Quantity in checkout pages selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
		
	public static int getitemsQuantityInShippingMethodsPageMobile() throws Exception {
		try {
			getCurrentFunctionName(true);
			int itemsQty = 0;
			logs.debug("Get items Quantity from checkout pages");
			itemsQty = itemsQty + Integer.parseInt(getDriver().findElement(By.cssSelector(CheckOutSelectors.itemsCountInCheckoutPages)).getText().replace("Items", "").trim());
			logs.debug("items Quantity:  " + itemsQty);
			getCurrentFunctionName(false);
			return itemsQty;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "items Quantity in checkout pages selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static int getitemsQuantityInOrderConfirmationPage() throws Exception {
		try {
			getCurrentFunctionName(true);
			int itemsQty = 0;
			logs.debug("Get items Quantity from Order Confirmation page");
			int numberOfProducts = getDriver()
					.findElements(By.cssSelector(CheckOutSelectors.itemQuantityInOrderConfirmationPage)).size();
			for (int index = 0; index < numberOfProducts; index++) {
				String itemsQtyText = getDriver()
						.findElements(By.cssSelector(CheckOutSelectors.itemQuantityInOrderConfirmationPage)).get(index)
						.getText().trim();
				if (itemsQtyText.contains("Qty")) {
					logs.debug("Items uantity text:  " + itemsQty);
					int itemsqty = Integer.parseInt(itemsQtyText.substring(itemsQtyText.indexOf(':') + 1).trim());
					itemsQty = itemsQty + itemsqty;
				} else
					itemsQty = itemsQty + Integer.parseInt(itemsQtyText);
			}
			logs.debug("items Quantity:  " + itemsQty);

			logs.debug("Get product In Stock Count in Order Confirmation page</font>");
			String productInStockCount = getDriver().findElement(By.cssSelector(CartSelectors.productCount)).getText();
			logs.debug("Items In Stock Count: <font color=#f442cb>" + productInStockCount + "</font>");
			int ProductInStockCount = Integer.parseInt(productInStockCount
					.substring(productInStockCount.indexOf('(') + 1, productInStockCount.indexOf(')')));
			logs.debug("In Stock items: <font color=#f442cb>" + ProductInStockCount + "</font>");
			sassert().assertTrue(ProductInStockCount == itemsQty,
					"The Sum of items qty is not matching the total of in stock items");
			getCurrentFunctionName(false);
			return itemsQty;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "items Quantity selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static class shippingAddress {
		public static class keys {
			public static final String countery = "countery";
			public static final String title = "title";
			public static final String email = "email";
			public static final String lastName = "lastName";
			public static final String firstName = "firstName";
			public static final String adddressLine = "adddressLine";
			public static final String city = "city";
			public static final String state = "state";
			public static final String zipcode = "postal";
			public static final String phone = "phone";
			public static final String streetAddress = "adddressLine";
			public static final String suggestedAddress = "suggestedAddress";
		}
	}

	public static class paymentInformation {

		public static class keys {
			public static final String card = "card";
			public static final String name = "name";
			public static final String number = "number";
			public static final String expireYear = "expireYear";
			public static final String expireMonth = "expireMonth";
			public static final String CVCC = "CVCC";

		}
	}

}
