package com.generic.tests.DSS.OMSAccount;

import java.text.MessageFormat;
import java.util.NoSuchElementException;

import org.testng.Assert;

import com.generic.page.Account;
import com.generic.page.Cart;
import com.generic.page.CheckOut;
import com.generic.page.HomePage;
import com.generic.page.Login;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;

public class NormalOrderValidation extends SelTestCase {

	public static void startTest(String omsUser) throws Exception {
		try {
			
			//Login
			HomePage.closeSignUpModal();
			HomePage.clickSignIn();
			Login.Login(omsUser,getCONFIG().getProperty("NewUserPassword") );
			Assert.assertTrue(Login.verifyIfUserLoggedIn(), "User is not logged in Successfully");
			
			Account.clickYourOrdersNavLink();
			
			Account.verifyYourOrdersHeaderIsDisplayed();
			String companyName = Account.getCompanyName();
			
            Account.getPaginationBarResultsForOrders();
			int numOfOrdersAvailable = Account.getNumberOfOrdersinThePage();
			logs.debug("<font color=#f442cb>User orders: </font>");
			for(int index=0; index < 5 * numOfOrdersAvailable; index++) {
				if(index % 5 == 0)
					logs.debug("<font color=#33BEFF> Row Number: (" + ((index/5) + 1)  + ") </font>");
				Account.getOrdersTableData(index);
		
			}

			String orderNumber = getCONFIG().getProperty("orderNumber");
			logs.debug("<font color=#f442cb> Check if the new order number exist in the orders table </font>");
			boolean orderIsDisplayed = false;
			int orderIndex = -1;
			Thread.sleep(10000); // Wait until the new order displayed on your order page.
			for (int index = 1; index < 5 * numOfOrdersAvailable; index = index + 5) {
				if (Account.getOrdersTableData(index).contains(orderNumber)) {
					logs.debug(
							"<font color=#33BEFF>" + orderNumber + " order is displayed on the orders table </font>");
					orderIsDisplayed = true;
					break;
				}
			}
			if (orderIsDisplayed)
				orderIndex = Account.getOrderIndex(orderNumber, numOfOrdersAvailable);
			else
				Assert.assertTrue(orderIsDisplayed, "The new created order is not displayed on your orders page");
			String OrderPlacedDateFromOrdersTable = Account.getOrderPlacedDateFromOrdersTable(orderIndex);
			String OrderStatusFromOrdersTable = Account.getOrderStatusFromOrdersTable(orderIndex);
			String OrderPlacerFromOrdersTable = Account.getOrderPlacerFromOrdersTable(orderIndex);
			String OrderTotalFromOrdersTable = Account.getOrderTotalFromOrdersTable(orderIndex);
			Account.clickOrderNumberFromOrdersTable(orderNumber);
			Account.verifyOrderDetailsHeaderIsDisplayed(orderNumber);
			
			String OrderNumberFromOrderDetailsPage = Account.getOrderNumberFromOrderDetailsPage();
			String OrderPlacedDateFromOrderDetailsPage = Account.getOrderPlacedDateFromOrderDetailsPage();
			String OrderStatusFromOrderDetailsPage = Account.getOrderStatusFromOrderDetailsPage(false);
			String OrderChanelFromOrderDetailsPage = Account.getOrderChannelFromOrderDetailsPage();
			String OrderTotalFromOrderDetailsPage = Account.getOrderTotalFromOrderDetailsPage(false);
			String OrderPlacedByValueFromOrderDetailsPage = Account.getOrderPlacedByValueFromOrderDetailsPage(false);
			 
			sassert().assertEquals(OrderNumberFromOrderDetailsPage, orderNumber, "<font color=#f442cb>Expected: "
					+ orderNumber + ". Actual: " + OrderNumberFromOrderDetailsPage + "</font>");
			sassert().assertEquals(OrderPlacedDateFromOrderDetailsPage, OrderPlacedDateFromOrdersTable.replace(" 0", " "),
					"<font color=#f442cb>Expected: " + OrderPlacedDateFromOrdersTable.replace(" 0", " ") + ". Actual: "
							+ OrderPlacedDateFromOrderDetailsPage + "</font>");
//			sassert().assertTrue(OrderPlacerFromOrdersTable.startsWith(OrderPlacedByValueFromOrderDetailsPage.toLowerCase()),
//					"<font color=#f442cb>Expected: " + OrderPlacerFromOrdersTable + ". Actual: "
//							+ OrderPlacedByValueFromOrderDetailsPage.toLowerCase() + "</font>");
			sassert().assertEquals(OrderStatusFromOrderDetailsPage.toLowerCase(), OrderStatusFromOrdersTable.toLowerCase(),
					"<font color=#f442cb>Expected: " + OrderStatusFromOrdersTable + ". Actual: "
							+ OrderStatusFromOrderDetailsPage + "</font>");
			sassert().assertEquals(OrderTotalFromOrderDetailsPage, OrderTotalFromOrdersTable,
					"<font color=#f442cb>Expected: " + OrderTotalFromOrdersTable + ". Actual: "
							+ OrderTotalFromOrderDetailsPage + "</font>");

			String shippingAddressFromOrderDetailsPage = Account.getShippingAddressFromOrderDetailsPage(false);
			String shippingMethodFromOrderDetailsPage = Account.getShippingMethodFromOrderDetailsPage(false);
			String trackingNumbersFromOrderDetailsPage = Account.getTrackingNumbersFromOrderDetailsPage();

			int NumberOfItemsFromOrderDetailsPage = Account.getNumberOfItemsFromOrderDetailsPage();
			String itemImageSrcFromOrderDetailsPage = Account.getItemImageFromOrderDetailsPage(false);
			String itemNameFromOrderDetailsPage = Account.getItemNameFromOrderDetailsPage(false);
			String itemCodeFromOrderDetailsPage = Account.getItemCodeFromOrderDetailsPage(false);
			String ItemStatusFromOrderDetailsPage = Account.getItemDeliveryFromOrderDetailsPage();
			String itemPriceFromOrderDetailsPage = Account.getItemPriceFromOrderDetailsPage();
			String itemQuantityFromOrderDetailsPage = Account.getItemQuantityFromOrderDetailsPage();
			String itemTotalFromOrderDetailsPage = Account.getItemTotalFromOrderDetailsPage(false);

			String BillingAddressFromOrderDetailsPage = Account.getBillingAddressFromOrderDetailsPage();
			String PaymentMethodFromOrderDetailsPage = Account.getPaymentMethodFromOrderDetailsPage(false);

			String orderSubtotalFromOrderDetailsPage = Account.getOrderSubtotalFromOrderDetailsPage(false);
			String orderDiscountsFromOrderDetailsPage = Account.getOrderDiscountsFromOrderDetailsPage();
			String orderShippingValueFromOrderDetailsPage = Account.getOrderShippingValueFromOrderDetailsPage(false);
			String orderTaxFromOrderDetailsPage = Account.getOrderTaxFromOrderDetailsPage(false);
			String orderTotalFromOrderDetailsPage = Account.getOrderSummaryOrderTotalFromOrderDetailsPage(false);

			Account.clickReorderButton();
			Cart.checkCartHeader();
			String ReordereditemNameFromCart = Cart.getItemNameFromCartPage(0);
			sassert().assertEquals(ReordereditemNameFromCart, itemNameFromOrderDetailsPage,
					"<font color=#f442cb>Expected: " + itemNameFromOrderDetailsPage + ". Actual: "
							+ ReordereditemNameFromCart + "</font>");

			sassert().assertAll();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

}
