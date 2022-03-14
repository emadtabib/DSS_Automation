package com.generic.tests.DSS.OMSAccount;

import java.text.MessageFormat;
import java.util.NoSuchElementException;

import org.testng.Assert;

import com.generic.page.Account;
import com.generic.page.CheckOut;
import com.generic.page.HomePage;
import com.generic.page.Login;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;

public class OnHoldOrderReviewer_RejectOrder extends SelTestCase {

	public static void startTest(String placer, String omsUser) throws Exception {
		try {
			int productsCount = 3;
			String orderSubtotal = "";
			String EstimatedOrderTotal = "";
			String Tax = "";
			String Shipping = "";
			String payment = "visa";
			
			HomePage.closeSignUpModal();
			
			HomePage.clickSignIn();
			Login.Login(placer,getCONFIG().getProperty("NewUserPassword") );
			Assert.assertTrue(Login.verifyIfUserLoggedIn(), "User is not logged in Successfully");
			
//			logs.debug("User is logged in successfully?: " + Login.verifyIfUserLoggedInSuccessfully());
			// Add products to cart
			CheckOut.addRandomProductTocart(productsCount);

//			CheckOut.closeOfferModal();

			orderSubtotal = CheckOut.getOrderSummaryItems(1);
			EstimatedOrderTotal = CheckOut.getEstimatedTotalInFromOrderSummary(false);
			CheckOut.clickCheckout();

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
			
			CheckOut.checkProductsInOrderConfirmationPage();
			
			orderSubtotal = CheckOut.getOrderSummaryItems(1);
			Shipping = CheckOut.getOrderSummaryItems(3);
			Tax = CheckOut.getOrderSummaryItems(5);
			EstimatedOrderTotal = CheckOut.getOrderSummaryItems(7);
			String OrderNumber = CheckOut.getOrderNumber();
		
			logs.debug("<font color=#f442cb>Signout from placer account </font>");
			Login.clickMyAccountMenu();
			HomePage.Signout();
			
			logs.debug("<font color=#f442cb>Login to reviewer account </font>");
			HomePage.clickSignIn();
			Login.Login(omsUser,getCONFIG().getProperty("NewUserPassword") );
			Assert.assertTrue(Login.verifyIfUserLoggedIn(), "User is not logged in Successfully");

			
			Account.clickOnHoldOrdersNavLink();
			
			Account.verifyOnHoldOrdersHeaderIsDisplayed();
			String companyName = Account.getCompanyName();
			
            Account.getPaginationBarResultsForOrders();
			int numOfOrdersAvailable = Account.getNumberOfOrdersinThePage();
			logs.debug("<font color=#f442cb>User orders: </font>");
			for(int index=0; index < 5 * numOfOrdersAvailable; index++) {
				if(index % 5 == 0)
					logs.debug("<font color=#33BEFF> Row Number: (" + ((index/5) + 1)  + ") </font>");
				Account.getOrdersTableData(index);
		
			}

//			String OnHoldOrderNumber = getCONFIG().getProperty("OnHoldOrderNumber");
			logs.debug("<font color=#f442cb> Check if the new order " + OrderNumber +" number exist in the orders table </font>");
			boolean orderIsDisplayed = false;
			int orderIndex = -1;
			Thread.sleep(2000); // Wait until the new order displayed on your order page.
			for (int index = 1; index < 5 * numOfOrdersAvailable; index = index + 5) {
				if (Account.getOrdersTableData(index).contains(OrderNumber)) {
					logs.debug(
							"<font color=#33BEFF>" + OrderNumber + " order is displayed on the orders table </font>");
//					Assert.assertTrue(Account.getOrdersTableData(index).contains("Click to unlock order"), "Click to unlock order is not displayed for the order");
					orderIsDisplayed = true;
					break;
				}
			}
			if (orderIsDisplayed)
				orderIndex = Account.getOrderIndex(OrderNumber, numOfOrdersAvailable);
			else
				Assert.assertTrue(orderIsDisplayed, "The new created order " + OrderNumber + " is not displayed on your orders page");
			String OrderStatusFromOrdersTable = Account.getOHOrderStatusFromOrdersTable(orderIndex);
			String OrderPlacedByFromOrdersTable = Account.getOHOrderPlacedByFromOrdersTable(orderIndex);
			String OrderTotalFromOrdersTable = Account.getOrderTotalFromOrdersTable(orderIndex);
			
			sassert().assertEquals(OrderStatusFromOrdersTable.toLowerCase(), "pending review", "<font color=#f442cb>Expected Status: "
					+ "pening review" + ". Actual: " + OrderStatusFromOrdersTable.toLowerCase() + "</font>");
			sassert().assertEquals(OrderPlacedByFromOrdersTable, "Placer 1", "<font color=#f442cb>Expected Placed By user: "
					+ "Placer 1" + ". Actual: " + OrderPlacedByFromOrdersTable + "</font>");

			if (Account.getOrdersTableData(orderIndex).contains("unlock")) {
				logs.debug("<font color=#33BEFF>" + OrderNumber + " Click to unlock order </font>");
				Account.clickToUnlockOrder(orderIndex);
			}
			Thread.sleep(6000); // Wait until the page reloads.
			Account.clickOrderNumberFromOrdersTable(OrderNumber);
			Account.verifyOrderDetailsHeaderIsDisplayed(OrderNumber);

			Account.clickohrRejectOrder();
			Account.typeRejectReason("Auto Test Script");
			Account.clickohrRejectReasonsubmit();

			sassert().assertTrue(Account.verifyOnHoldOrdersHeaderIsDisplayed(),
					"<font color=#f442cb> User is not redirected to the orders page after rejecting the order, review the screenshot for the reason");
			logs.debug("Verify that the order is removed from the reviewer on hold orders");
			for (int index = 1; index < 5 * numOfOrdersAvailable; index = index + 5) {
				if (Account.getOrdersTableData(index).contains(OrderNumber)) {
					Assert.fail("<font color=#33BEFF>The rejected order: " + OrderNumber + " is stil displayed on the orders table </font>");
				}
			}
			
			logs.debug("<font color=#f442cb>Signout from reviewer account </font>");
			Login.clickMyAccountMenu();
			HomePage.Signout();

			logs.debug("<font color=#f442cb>Login to placer account </font>");
			HomePage.clickSignIn();
			Login.Login(placer, getCONFIG().getProperty("NewUserPassword"));
			Assert.assertTrue(Login.verifyIfUserLoggedIn(), "User is not logged in Successfully");

			Account.clickOnHoldOrdersNavLink();
			Account.verifyOnHoldOrdersHeaderIsDisplayed();
			Account.getPaginationBarResultsForOrders();
			numOfOrdersAvailable = Account.getNumberOfOrdersinThePage();
			logs.debug("<font color=#f442cb>User orders: </font>");
			for (int index = 0; index < 5 * numOfOrdersAvailable; index++) {
				if (index % 5 == 0)
					logs.debug("<font color=#33BEFF> Row Number: (" + ((index / 5) + 1) + ") </font>");
				Account.getOrdersTableData(index);

			}

			logs.debug("<font color=#f442cb> Check if the rejected order " + OrderNumber
					+ " number exist in the orders table </font>");
			orderIsDisplayed = false;
			orderIndex = -1;
			Thread.sleep(2000); // Wait until the new order displayed on your order page.
			for (int index = 1; index < 5 * numOfOrdersAvailable; index = index + 5) {
				if (Account.getOrdersTableData(index).contains(OrderNumber)) {
					logs.debug(
							"<font color=#33BEFF>" + OrderNumber + " order is displayed on the orders table </font>");
					orderIsDisplayed = true;
					break;
				}
			}
			if (!orderIsDisplayed)
				Assert.fail("<font color=#33BEFF>The rejected order: " + OrderNumber
						+ " is not displayed on the orders table </font>");
			orderIndex = Account.getOrderIndex(OrderNumber, numOfOrdersAvailable);

			OrderStatusFromOrdersTable = Account.getOHOrderStatusFromOrdersTable(orderIndex);
			sassert().assertTrue(OrderStatusFromOrdersTable.toLowerCase().equals("rejected ohr"), "<font color=#33BEFF>The actual rejected order status is: " + OrderStatusFromOrdersTable);

			sassert().assertAll();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

}
