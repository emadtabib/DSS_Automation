package com.generic.tests.DSS.checkout;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

import com.generic.page.CheckOut;
import com.generic.page.HomePage;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;

//DSS
public class GuestCheckoutSingleAddress extends SelTestCase {

	public static void startTest(String shippingMethod, int productsCount, LinkedHashMap<String, String> addressDetails,
			LinkedHashMap<String, String> paymentDetails) throws Exception {
		getCurrentFunctionName(true);

		try {
			
			String orderSubtotal = "";
			String EstimatedOrder = "";
			String Tax = "";
			String Shipping = "";
			
			HomePage.closeSignUpModal();
	
			// Add products to cart
			CheckOut.addRandomProductTocart(productsCount);

			CheckOut.closeOfferModal();

			orderSubtotal = CheckOut.getOrderSummaryItems(1);
			EstimatedOrder = CheckOut.getEstimatedTotalInFromOrderSummary(true);
			CheckOut.clickCheckout();

			String NewOrderSubtotal = CheckOut.getOrderSummaryItems(1);
			sassert().assertEquals(NewOrderSubtotal, orderSubtotal, "Actual subtotal in shipping address page is: "
					+ NewOrderSubtotal + "While it is: " + orderSubtotal + " in cart");

			String NewEstimatedOrder = CheckOut.getEstimatedTotalInFromOrderSummary(true);
			sassert().assertEquals(NewEstimatedOrder, EstimatedOrder,
					"Actual Estimated Order in shipping address page is: " + NewEstimatedOrder + "While it is: "
							+ EstimatedOrder + " in cart");

			CheckOut.fillShippingAddressForm(addressDetails);

			NewOrderSubtotal = CheckOut.getOrderSummaryItems(1);
			sassert().assertEquals(NewOrderSubtotal, orderSubtotal, "Actual subtotal in delivery method page is: "
					+ NewOrderSubtotal + "While it is: " + orderSubtotal + " in cart");

			Shipping = CheckOut.getOrderSummaryItems(3);
			Tax = CheckOut.getOrderSummaryItems(5);
			EstimatedOrder = CheckOut.getOrderSummaryItems(7);
			sassert().assertTrue(
					CheckOut.validateEstimatedTotalIsCorrect(NewOrderSubtotal, Shipping, Tax, EstimatedOrder),
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
//			sassert().assertNotEquals(newShipping, Shipping,
//					"Shiiping should be updated becasue we selected a new shipping method");

			String newTax = CheckOut.getOrderSummaryItems(5);
//			sassert().assertNotEquals(newTax, Tax, "Tax should be updated becasue we selected a new shipping method");

			String newEstimatedOrder = CheckOut.getOrderSummaryItems(7);
			sassert().assertTrue(
					CheckOut.validateEstimatedTotalIsCorrect(NewOrderSubtotal, newShipping, newTax, newEstimatedOrder),
					"Estimated total value is not correct in payment page");

			CheckOut.fillPaymentDetails(paymentDetails);
			
			// Check number of products in Payment page
			sassert().assertTrue(CheckOut.getitemsQuantityInCheckoutPges() == productsCount,
					"Some products are missing in Payment page ");
			
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
			EstimatedOrder = CheckOut.getOrderSummaryItems(7);
			
			sassert().assertEquals(orderSubtotal, NewOrderSubtotal, "Order subtotal in order confirmation page is not matching the one on payment page");
			sassert().assertEquals(Shipping, newShipping, "Shipping in order confirmation page is not matching the one on payment page");
			sassert().assertEquals(Tax, newTax, "Tax in order confirmation page is not matching the one on payment page");
			sassert().assertEquals(EstimatedOrder, newEstimatedOrder, "Estimated Order in order confirmation page is not matching the one on payment page");

			sassert().assertAll();
			getCurrentFunctionName(false);

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

}
