package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Page.CheckoutPage;
import Page.HomePage;
import Page.PDP;
import Page.SignInPage;
import setup.common;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Checkout {

	String Email = "DSSAuto_no1@mailinator.com";
	String firstName = "Emad";
	String lastName = "Tabib";
	String addressLine1 = "644 Elk Rd Little";
	String City = "Tucson";
	String State = "Arizona";
	String postCode = "85724";
	String phoneNumber = " 5202215776";
	String cardholderName = "auto user";
	String accountNumber = "4012888888881881";
	String ExpiryMonth = "07";
	String ExpiryYear = "26";
	String cvv = "111";
	String orderSubtotal = "";
	String EstimatedOrder = "";
	String Tax = "";
	String Shipping = "";
	
	@Test
	public void PlaceOrder_RegisteredUser() {
		
		try {
			SoftAssert softAssertion= new SoftAssert();
			HomePage.closeSignUpModal();
			HomePage.clickSignIn();
			SignInPage.Login();
			HomePage.SearchAndPickItem("ORNA");
			PDP.clickAddToCartButton();
			PDP.verifyAddToCartLayerIsDisplayed();
			PDP.clickProceedToCheckout();
			CheckoutPage.closeOfferModal();
			orderSubtotal = CheckoutPage.getOrderSummaryItems(1);
			EstimatedOrder = CheckoutPage.getEstimatedTotalInFromOrderSummary();
			CheckoutPage.clickCheckout();
			
			String NewOrderSubtotal = CheckoutPage.getOrderSummaryItems(1);
			softAssertion.assertEquals(NewOrderSubtotal, orderSubtotal, "Actual subtotal in shipping address page is: "
					+ NewOrderSubtotal + "While it is: " + orderSubtotal + " in cart");
			
			String NewEstimatedOrder = CheckoutPage.getEstimatedTotalInFromOrderSummary();
			softAssertion.assertEquals(NewEstimatedOrder, EstimatedOrder, "Actual Estimated Order in shipping address page is: "
							+ NewOrderSubtotal + "While it is: " + orderSubtotal + " in cart");
			
			CheckoutPage.ContinueToShippingMethod();
			
			NewOrderSubtotal = CheckoutPage.getOrderSummaryItems(1);
			softAssertion.assertEquals(NewOrderSubtotal, orderSubtotal, "Actual subtotal in delivery method page is: "
					+ NewOrderSubtotal + "While it is: " + orderSubtotal + " in cart");
		
			Shipping = CheckoutPage.getOrderSummaryItems(3);
			Tax = CheckoutPage.getOrderSummaryItems(5);
			EstimatedOrder = CheckoutPage.getOrderSummaryItems(7);
			softAssertion.assertTrue(
					CheckoutPage.validateEstimatedTotalIsCorrect(NewOrderSubtotal, Shipping, Tax, EstimatedOrder),
					"Estimated total value is not correct in delivery method page");
			
			CheckoutPage.ContinueToPayment();
			
			NewOrderSubtotal = CheckoutPage.getOrderSummaryItems(1);
			softAssertion.assertEquals(NewOrderSubtotal, orderSubtotal, "Actual subtotal in payment page is: "
					+ NewOrderSubtotal + "While it is: " + orderSubtotal + " in cart");
			
			String newShipping = CheckoutPage.getOrderSummaryItems(3);
			softAssertion.assertNotEquals(newShipping, Shipping, "Shiiping should be updated becasue we selected a new shipping method");
		
			String newTax = CheckoutPage.getOrderSummaryItems(5);
			softAssertion.assertNotEquals(newTax, Tax, "Tax should be updated becasue we selected a new shipping method");

			String newEstimatedOrder = CheckoutPage.getOrderSummaryItems(7);
			softAssertion.assertTrue(
					CheckoutPage.validateEstimatedTotalIsCorrect(NewOrderSubtotal, newShipping, newTax, newEstimatedOrder),
					"Estimated total value is not correct in payment page");
			
			CheckoutPage.typePONumber();
			CheckoutPage.placeOrder();
			CheckoutPage.getSuccessMessage();
			CheckoutPage.getOrderNumber();
			CheckoutPage.getOrderStatus();
			NewOrderSubtotal = CheckoutPage.getOrderSummaryItems(1);
			Shipping = CheckoutPage.getOrderSummaryItems(3);
			Tax = CheckoutPage.getOrderSummaryItems(5);
			EstimatedOrder = CheckoutPage.getOrderSummaryItems(7);
			softAssertion.assertAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
//	@Test
//	public void PlaceOrder_GuestUser() {
//		
//		SoftAssert softAssertion= new SoftAssert();
//
//		try {
//			
//			HomePage.closeSignUpModal();
//			HomePage.SearchAndPickItem("ORNA");
//			PDP.clickAddToCartButton();
//			PDP.verifyAddToCartLayerIsDisplayed();
//			PDP.clickProceedToCheckout();
//			CheckoutPage.closeOfferModal();
//			orderSubtotal = CheckoutPage.getOrderSummaryItems(1);
//			EstimatedOrder = CheckoutPage.getEstimatedTotalInFromOrderSummary();
//			CheckoutPage.clickCheckout();
//			
//			String NewOrderSubtotal = CheckoutPage.getOrderSummaryItems(1);
//			softAssertion.assertEquals(NewOrderSubtotal, orderSubtotal, "Actual subtotal in shipping address page is: "
//					+ NewOrderSubtotal + "While it is: " + orderSubtotal + " in cart");
//			
//			String NewEstimatedOrder = CheckoutPage.getEstimatedTotalInFromOrderSummary();
//			softAssertion.assertEquals(NewEstimatedOrder, EstimatedOrder, "Actual Estimated Order in shipping address page is: "
//							+ NewOrderSubtotal + "While it is: " + orderSubtotal + " in cart");
//
//			CheckoutPage.fillShippingAddressForm(Email, firstName, lastName, addressLine1, City, State, postCode,
//					phoneNumber);
//			
//			NewOrderSubtotal = CheckoutPage.getOrderSummaryItems(1);
//			softAssertion.assertEquals(NewOrderSubtotal, orderSubtotal, "Actual subtotal in delivery method page is: "
//					+ NewOrderSubtotal + "While it is: " + orderSubtotal + " in cart");
//		
//			Shipping = CheckoutPage.getOrderSummaryItems(3);
//			Tax = CheckoutPage.getOrderSummaryItems(5);
//			EstimatedOrder = CheckoutPage.getOrderSummaryItems(7);
//			softAssertion.assertTrue(
//					CheckoutPage.validateEstimatedTotalIsCorrect(NewOrderSubtotal, Shipping, Tax, EstimatedOrder),
//					"Estimated total value is not correct in delivery method page");
//		
//			CheckoutPage.selectshippingMethods(2);
//			CheckoutPage.ContinueToPayment();
//			
//			NewOrderSubtotal = CheckoutPage.getOrderSummaryItems(1);
//			softAssertion.assertEquals(NewOrderSubtotal, orderSubtotal, "Actual subtotal in payment page is: "
//					+ NewOrderSubtotal + "While it is: " + orderSubtotal + " in cart");
//			
//			String newShipping = CheckoutPage.getOrderSummaryItems(3);
//			softAssertion.assertNotEquals(newShipping, Shipping, "Shiiping should be updated becasue we selected a new shipping method");
//		
//			String newTax = CheckoutPage.getOrderSummaryItems(5);
//			softAssertion.assertNotEquals(newTax, Tax, "Tax should be updated becasue we selected a new shipping method");
//
//			String newEstimatedOrder = CheckoutPage.getOrderSummaryItems(7);
//			softAssertion.assertTrue(
//					CheckoutPage.validateEstimatedTotalIsCorrect(NewOrderSubtotal, newShipping, newTax, newEstimatedOrder),
//					"Estimated total value is not correct in payment page");
//			
//			CheckoutPage.fillPaymentDetails(cardholderName, accountNumber, ExpiryMonth, ExpiryYear, cvv); 
//			CheckoutPage.placeOrder();
//			CheckoutPage.getSuccessMessage();
//			CheckoutPage.getOrderNumber();
//			CheckoutPage.getOrderStatus();
//			NewOrderSubtotal = CheckoutPage.getOrderSummaryItems(1);
//			Shipping = CheckoutPage.getOrderSummaryItems(3);
//			Tax = CheckoutPage.getOrderSummaryItems(5);
//			EstimatedOrder = CheckoutPage.getOrderSummaryItems(7);
//			softAssertion.assertAll();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Assert.fail(e.getMessage());
//		}
//	}
	
	@BeforeTest
	public void beforeTest() {
		try {
			common.launchApplication();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	public void afterTest() {

		WebDriver driver = common.getDriver();
		driver.quit();

	}

}
