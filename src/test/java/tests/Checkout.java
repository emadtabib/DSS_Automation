package tests;

import org.testng.annotations.Test;

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
import org.testng.annotations.AfterTest;

public class Checkout {


	@Test
	public void PlaceOrder_RegisteredUser() {
		
		try {
			HomePage.closeSignUpModal();
			HomePage.clickSignIn();
			SignInPage.Login();
			HomePage.SearchAndPickItem("ORNA");
			PDP.clickAddToCartButton();
			PDP.verifyAddToCartLayerIsDisplayed();
			PDP.clickProceedToCheckout();
			CheckoutPage.closeOfferModal();
			CheckoutPage.clickCheckout();
			CheckoutPage.ContinueToShippingMethod();
			CheckoutPage.ContinueToPayment();
			CheckoutPage.typePONumber();
			CheckoutPage.placeOrder();
			CheckoutPage.getSuccessMessage();
			CheckoutPage.getOrderNumber();
			CheckoutPage.getOrderStatus();	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

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
		//driver.quit();

	}

}
