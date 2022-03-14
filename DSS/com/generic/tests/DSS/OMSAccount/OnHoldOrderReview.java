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
			logs.debug("<font color=#f442cb> Check if the new order " + OnHoldOrderNumber +" number exist in the orders table </font>");
			boolean orderIsDisplayed = false;
			int orderIndex = -1;
			Thread.sleep(2000); // Wait until the new order displayed on your order page.
			for (int index = 1; index < 5 * numOfOrdersAvailable; index = index + 5) {
				if (Account.getOrdersTableData(index).contains(OnHoldOrderNumber)) {
					logs.debug(
							"<font color=#33BEFF>" + OnHoldOrderNumber + " order is displayed on the orders table </font>");
//					Assert.assertTrue(Account.getOrdersTableData(index).contains("Click to unlock order"), "Click to unlock order is not displayed for the order");
					orderIsDisplayed = true;
					break;
				}
			}
			if (orderIsDisplayed)
				orderIndex = Account.getOrderIndex(OnHoldOrderNumber, numOfOrdersAvailable);
			else
				Assert.assertTrue(orderIsDisplayed, "The new created order " + OnHoldOrderNumber + " is not displayed on your orders page");
			String OrderPlacedDateFromOrdersTable = Account.getOrderPlacedDateFromOrdersTable(orderIndex);
			String OrderStatusFromOrdersTable = Account.getOHOrderStatusFromOrdersTable(orderIndex);
			String OrderPlacedByFromOrdersTable = Account.getOHOrderPlacedByFromOrdersTable(orderIndex);
			String OrderTotalFromOrdersTable = Account.getOrderTotalFromOrdersTable(orderIndex);
			
			sassert().assertEquals(OrderStatusFromOrdersTable.toLowerCase(), "pending review", "<font color=#f442cb>Expected Status: "
					+ "pening review" + ". Actual: " + OrderStatusFromOrdersTable + "</font>");
			sassert().assertEquals(OrderPlacedByFromOrdersTable, "Placer 1", "<font color=#f442cb>Expected Placed By user: "
					+ "Placer 1" + ". Actual: " + OrderPlacedByFromOrdersTable + "</font>");

			if (Account.getOrdersTableData(orderIndex).contains("unlock")) {
				logs.debug("<font color=#33BEFF>" + OnHoldOrderNumber + " Click to unlock order </font>");
				Account.clickToUnlockOrder(orderIndex);
			}
			Thread.sleep(6000); // Wait until the page reloads.
			Account.clickOrderNumberFromOrdersTable(OnHoldOrderNumber);
			Account.verifyOrderDetailsHeaderIsDisplayed(OnHoldOrderNumber);

			String OrderNumberFromOrderDetailsPage = Account.getOrderNumberFromOrderDetailsPage();
			String OrderPlacedDateFromOrderDetailsPage = Account.getOrderPlacedDateFromOrderDetailsPage();
			String OrderStatusFromOrderDetailsPage = Account.getOrderStatusFromOrderDetailsPage(true);
			String OrderPlacedBylFromOrderDetailsPage = Account.getOrderPlacedByValueFromOrderDetailsPage(true);
			String OrderTotalFromOrderDetailsPage = Account.getOrderTotalFromOrderDetailsPage(true);

			sassert().assertEquals(OrderNumberFromOrderDetailsPage, OnHoldOrderNumber, "<font color=#f442cb>Expected: "
					+ OnHoldOrderNumber + ". Actual: " + OrderNumberFromOrderDetailsPage + "</font>");
			sassert().assertEquals(OrderPlacedDateFromOrderDetailsPage.replace(",", ""), OrderPlacedDateFromOrdersTable.replace(" 0", " ").replace(",", ""),
					"<font color=#f442cb>Expected: " + OrderPlacedDateFromOrdersTable.replace(" 0", " ").replace(",", "") + ". Actual: "
							+ OrderPlacedDateFromOrderDetailsPage.replace(",", "") + "</font>");
			sassert().assertTrue(OrderPlacedByFromOrdersTable.toLowerCase().contains(OrderPlacedBylFromOrderDetailsPage.toLowerCase()),
					"<font color=#f442cb>Expected: " + OrderPlacedBylFromOrderDetailsPage.toLowerCase() + ". Actual: "
							+ OrderPlacedByFromOrdersTable + "</font>");
			sassert().assertEquals(OrderStatusFromOrderDetailsPage.toLowerCase(), OrderStatusFromOrdersTable.toLowerCase(),
					"<font color=#f442cb>Expected: " + OrderStatusFromOrdersTable.toLowerCase() + ". Actual: "
							+ OrderStatusFromOrderDetailsPage.toLowerCase() + "</font>");
			sassert().assertEquals(OrderTotalFromOrderDetailsPage, OrderTotalFromOrdersTable,
					"<font color=#f442cb>Expected: " + OrderTotalFromOrdersTable + ". Actual: "
							+ OrderTotalFromOrderDetailsPage + "</font>");

			Account.getShippingAddressFromOrderDetailsPage(true);
			Account.getShippingMethodFromOrderDetailsPage(true);

		    Account.getNumberOfItemsFromOrderDetailsPage();
			Account.getItemImageFromOrderDetailsPage(true);
			Account.getItemNameFromOrderDetailsPage(true);
			Account.getItemCodeFromOrderDetailsPage(true);
//			String ItemStatusFromOrderDetailsPage = Account.getItemDeliveryFromOrderDetailsPage();
			Account.getItemPriceFromOrderDetailsPage();
			Account.getItemQuantityFromOrderDetailsPage();
			Account.getItemTotalFromOrderDetailsPage(true);

			Account.getPaymentMethodFromOrderDetailsPage(true);

			Account.getohrCommentsFromOrderDetailsPage();
			Account.getohrMessageFromOrderDetailsPage();
			
			Account.getOrderSubtotalFromOrderDetailsPage(true);
			Account.getOrderShippingValueFromOrderDetailsPage(true);
			Account.getOrderTaxFromOrderDetailsPage(true);
			Account.getOrderTotalFromOrderDetailsPage(true);

			Account.clickohrSubmitForApproval();

			String ohrOrderReleasedMessage = Account.getohrOrderReleasedMessage();
			OrderNumberFromOrderDetailsPage = Account.getOrderNumberFromOrderDetailsPage();
			OrderPlacedDateFromOrderDetailsPage = Account.getOrderPlacedDateFromOrderDetailsPage();
			OrderStatusFromOrderDetailsPage = Account.getOrderStatusFromOrderDetailsPage(true);
			OrderPlacedBylFromOrderDetailsPage = Account.getOrderPlacedByValueFromOrderDetailsPage(true);
			OrderTotalFromOrderDetailsPage = Account.getOrderTotalFromOrderDetailsPage(true);
			String OrderReviewerFromOrderDetailsPage = Account.getOrderReviewerFromOrderDetailsPage();
			sassert().assertEquals(OrderStatusFromOrderDetailsPage.toLowerCase(), "pending approval",
					"<font color=#f442cb> Status is not updated correctly. Expected: " + "PENDING APPROVAL" + ". Actual: "
							+ OrderStatusFromOrderDetailsPage.toLowerCase() + "</font>");
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
