package com.generic.tests.DSS.OMSAccount;

import java.text.MessageFormat;
import java.util.NoSuchElementException;

import org.testng.Assert;

import com.generic.page.Account;
import com.generic.page.HomePage;
import com.generic.page.Login;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;

public class OnHoldOrderReview extends SelTestCase {

	public static void startTest(String omsUser) throws Exception {
		try {
			
			//Login
			HomePage.closeSignUpModal();
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

			String OnHoldOrderNumber = getCONFIG().getProperty("OnHoldOrderNumber");
			logs.debug("<font color=#f442cb> Check if the new order number exist in the orders table </font>");
			boolean orderIsDisplayed = false;
			int orderIndex = -1;
			Thread.sleep(2000); // Wait until the new order displayed on your order page.
			for (int index = 1; index < 5 * numOfOrdersAvailable; index = index + 5) {
				if (Account.getOrdersTableData(index).contains(OnHoldOrderNumber)) {
					logs.debug(
							"<font color=#33BEFF>" + OnHoldOrderNumber + " order is displayed on the orders table </font>");
					Assert.assertTrue(OnHoldOrderNumber.contains("Click to unlock order"), "Click to unlock order is not displayed for the order");
					orderIsDisplayed = true;
					break;
				}
			}
			if (orderIsDisplayed)
				orderIndex = Account.getOrderIndex(OnHoldOrderNumber, numOfOrdersAvailable);
			else
				Assert.assertTrue(orderIsDisplayed, "The new created order is not displayed on your orders page");
			String OrderPlacedDateFromOrdersTable = Account.getOrderPlacedDateFromOrdersTable(orderIndex);
			String OrderStatusFromOrdersTable = Account.getOHOrderStatusFromOrdersTable(orderIndex);
			String OrderPlacedByFromOrdersTable = Account.getOHOrderPlacedByFromOrdersTable(orderIndex);
			String OrderTotalFromOrdersTable = Account.getOrderTotalFromOrdersTable(orderIndex);
			
			
			Account.clickToUnlockOrder(orderIndex);
			Thread.sleep(6000); // Wait until the page reloads.
			Account.clickOrderNumberFromOrdersTable(OnHoldOrderNumber);
			Account.verifyOrderDetailsHeaderIsDisplayed(OnHoldOrderNumber);
			
			String OrderNumberFromOrderDetailsPage = Account.getOrderNumberFromOrderDetailsPage();
			String OrderPlacedDateFromOrderDetailsPage = Account.getOrderPlacedDateFromOrderDetailsPage();
			String OrderStatusFromOrderDetailsPage = Account.getOrderStatusFromOrderDetailsPage(true);
			String OrderPlacedBylFromOrderDetailsPage = Account.getOrderPlacedByValueFromOrderDetailsPage(true);
			String OrderTotalFromOrderDetailsPage = Account.getOrderTotalFromOrderDetailsPage(true);

			sassert().assertEquals(OrderNumberFromOrderDetailsPage, OnHoldOrderNumber, "<font color=#f442cb>Expected: "
					+ OnHoldOrderNumber + "Actual: " + OrderNumberFromOrderDetailsPage + "</font>");
			sassert().assertEquals(OrderPlacedDateFromOrderDetailsPage, OrderPlacedDateFromOrdersTable,
					"<font color=#f442cb>Expected: " + OrderPlacedDateFromOrdersTable + "Actual: "
							+ OrderPlacedDateFromOrderDetailsPage + "</font>");
			sassert().assertEquals(OrderPlacedBylFromOrderDetailsPage, OrderPlacedByFromOrdersTable,
					"<font color=#f442cb>Expected: " + OrderPlacedByFromOrdersTable + "Actual: "
							+ OrderPlacedBylFromOrderDetailsPage + "</font>");
			sassert().assertEquals(OrderStatusFromOrderDetailsPage, OrderStatusFromOrdersTable,
					"<font color=#f442cb>Expected: " + OrderStatusFromOrdersTable + "Actual: "
							+ OrderStatusFromOrderDetailsPage + "</font>");
			sassert().assertEquals(OrderTotalFromOrderDetailsPage, OrderTotalFromOrdersTable,
					"<font color=#f442cb>Expected: " + OrderTotalFromOrdersTable + "Actual: "
							+ OrderTotalFromOrderDetailsPage + "</font>");

			String shippingAddressFromOrderDetailsPage = Account.getShippingAddressFromOrderDetailsPage(true);
			String shippingMethodFromOrderDetailsPage = Account.getShippingMethodFromOrderDetailsPage(true);

			int NumberOfItemsFromOrderDetailsPage = Account.getNumberOfItemsFromOrderDetailsPage();
			String itemImageSrcFromOrderDetailsPage = Account.getItemImageFromOrderDetailsPage();
			String itemNameFromOrderDetailsPage = Account.getItemNameFromOrderDetailsPage();
			String itemCodeFromOrderDetailsPage = Account.getItemCodeFromOrderDetailsPage();
			String ItemStatusFromOrderDetailsPage = Account.getItemDeliveryFromOrderDetailsPage();
			String itemPriceFromOrderDetailsPage = Account.getItemPriceFromOrderDetailsPage();
			String itemQuantityFromOrderDetailsPage = Account.getItemQuantityFromOrderDetailsPage();
			String itemTotalFromOrderDetailsPage = Account.getItemTotalFromOrderDetailsPage();

			String PaymentMethodFromOrderDetailsPage = Account.getPaymentMethodFromOrderDetailsPage(true);

			String ohrCommentsFromOrderDetailsPage = Account.getohrCommentsFromOrderDetailsPage();
			String ohrMessageFromOrderDetailsPage = Account.getohrMessageFromOrderDetailsPage();
			
			String orderSubtotalFromOrderDetailsPage = Account.getOrderSubtotalFromOrderDetailsPage(true);
			String orderShippingValueFromOrderDetailsPage = Account.getOrderShippingValueFromOrderDetailsPage(true);
			String orderTaxFromOrderDetailsPage = Account.getOrderTaxFromOrderDetailsPage(true);
			String orderTotalFromOrderDetailsPage = Account.getOrderTotalFromOrderDetailsPage(true);

			Account.clickohrSubmitForApproval();

			String ohrOrderReleasedMessage = Account.getohrOrderReleasedMessage();
			OrderNumberFromOrderDetailsPage = Account.getOrderNumberFromOrderDetailsPage();
			OrderPlacedDateFromOrderDetailsPage = Account.getOrderPlacedDateFromOrderDetailsPage();
			OrderStatusFromOrderDetailsPage = Account.getOrderStatusFromOrderDetailsPage(true);
			OrderPlacedBylFromOrderDetailsPage = Account.getOrderPlacedByValueFromOrderDetailsPage(true);
			OrderTotalFromOrderDetailsPage = Account.getOrderTotalFromOrderDetailsPage(true);
			String OrderReviewerFromOrderDetailsPage = Account.getOrderReviewerFromOrderDetailsPage();
			sassert().assertEquals(OrderReviewerFromOrderDetailsPage, "PENDING APPROVAL",
					"<font color=#f442cb> Status is not updated correctly. Expected: " + "PENDING APPROVAL" + "Actual: "
							+ OrderReviewerFromOrderDetailsPage + "</font>");
			sassert().assertTrue(Account.verifyContinueShoppingButtonIsDisplayed(),
					"<font color=#f442cb> Continue Button is not Displayed</font>");
			sassert().assertAll();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

}
