package com.generic.tests.DSS.checkout;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

import org.testng.Assert;

import com.generic.page.Account;
import com.generic.page.Cart;
import com.generic.page.CheckOut;
import com.generic.page.HomePage;
import com.generic.page.Login;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;

public class RegisteredCheckoutSingleAddress extends SelTestCase {

	public static void startTest(String shippingMethod, int productsCount, LinkedHashMap<String, String> addressDetails,
			String payment, LinkedHashMap<String, String> userDetalis) throws Exception {
		try {

			String orderSubtotal = "";
			String EstimatedOrderTotal = "";
			String Tax = "";
			String Shipping = "";
			
			HomePage.closeSignUpModal();
	
			HomePage.clickSignIn();
			Login.Login(userDetalis);
			Assert.assertTrue(Login.verifyIfUserLoggedIn(), "User is not logged in Successfully");
			
//			logs.debug("User is logged in successfully?: " + Login.verifyIfUserLoggedInSuccessfully());
			// Add products to cart
			Cart.addRandomProductTocart(productsCount);

//			CheckOut.closeOfferModal();

			orderSubtotal = CheckOut.getOrderSummaryItems(1);
			EstimatedOrderTotal = Cart.getEstimatedTotalInFromOrderSummary(false);
			Cart.clickCheckout();

			String NewOrderSubtotal = CheckOut.getOrderSummaryItems(1);
			sassert().assertEquals(NewOrderSubtotal, orderSubtotal, "Actual subtotal in shipping address page is: "
					+ NewOrderSubtotal + "While it is: " + orderSubtotal + " in cart");

			CheckOut.ContinueToShippingMethod();

			NewOrderSubtotal = CheckOut.getOrderSummaryItems(1);
			sassert().assertEquals(NewOrderSubtotal, orderSubtotal, "Actual subtotal in delivery method page is: "
					+ NewOrderSubtotal + "While it is: " + orderSubtotal + " in cart");

			Shipping = CheckOut.getOrderSummaryItems(3);
			Tax = CheckOut.getOrderSummaryItems(5);
			EstimatedOrderTotal = CheckOut.getOrderSummaryItems(7);
			sassert().assertTrue(
					CheckOut.validateEstimatedTotalIsCorrect(NewOrderSubtotal, Shipping, Tax, EstimatedOrderTotal),
					"Estimated total value is not correct in delivery method page");

			// Check number of products in delivery method page
			sassert().assertTrue(CheckOut.getitemsQuantityInCheckoutPges() == productsCount,
					"Some products are missing in delivery method page ");
			
//			CheckOut.selectshippingMethods(shippingMethod);
			CheckOut.ContinueToPayment();

			NewOrderSubtotal = CheckOut.getOrderSummaryItems(1);
			sassert().assertEquals(NewOrderSubtotal, orderSubtotal, "Actual subtotal in payment page is: "
					+ NewOrderSubtotal + "While it is: " + orderSubtotal + " in cart");

			String newShipping = CheckOut.getOrderSummaryItems(3);
			String newTax = CheckOut.getOrderSummaryItems(5);
			String newEstimatedOrder = CheckOut.getOrderSummaryItems(7);
			sassert().assertTrue(
					CheckOut.validateEstimatedTotalIsCorrect(NewOrderSubtotal, newShipping, newTax, newEstimatedOrder),
					"Estimated total value is not correct in payment page");
			
			// Check number of products in Payment page
			sassert().assertTrue(CheckOut.getitemsQuantityInCheckoutPges() == productsCount,
					"Some Qty are missing in Payment page ");
			
			Double Placer1ThresholdAmount = Double.parseDouble(getCONFIG().getProperty("Placer1ThresholdAmount"));
			CheckOut.selectSavedPaymentMethod(payment, newEstimatedOrder, Placer1ThresholdAmount);
			CheckOut.placeOrder();
			CheckOut.closeFeedbackModal();
			CheckOut.getSuccessMessage();
			CheckOut.getOrderNumber();
			CheckOut.getOrderStatus();
			
			// Check number of products in order confirmation page
			CheckOut.checkProductsInOrderConfirmationPage();
//			sassert().assertTrue(CheckOut.checkProductsInOrderConfirmationPage() == productsCount,
//					"Some products are missing in order confirmation page ");
			sassert().assertTrue(CheckOut.getitemsQuantityInOrderConfirmationPage() == productsCount,
					"Some Qty are missing in order confirmation page ");
			
			orderSubtotal = CheckOut.getOrderSummaryItems(1);
			Shipping = CheckOut.getOrderSummaryItems(3);
			Tax = CheckOut.getOrderSummaryItems(5);
			EstimatedOrderTotal = CheckOut.getOrderSummaryItems(7);
			
			sassert().assertEquals(orderSubtotal, NewOrderSubtotal, "Order subtotal in order confirmation page is not matching the one on payment page");
			sassert().assertEquals(Shipping, newShipping, "Shipping in order confirmation page is not matching the one on payment page");
			sassert().assertEquals(Tax, newTax, "Tax in order confirmation page is not matching the one on payment page");
			sassert().assertEquals(EstimatedOrderTotal, newEstimatedOrder, "Estimated Order in order confirmation page is not matching the one on payment page");
			
			double orderEstimatedTotal = Double.parseDouble(EstimatedOrderTotal.replace('$', ' ').trim());
			if (orderEstimatedTotal < Placer1ThresholdAmount)
				Account.writeOrderNumberToConfigFile("orderNumber", CheckOut.getOrderNumber());
			else
				Account.writeOrderNumberToConfigFile("OnHoldOrderNumber", CheckOut.getOrderNumber());
			sassert().assertAll();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

}
