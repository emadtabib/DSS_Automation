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

public class AdminUser_ManageUsers_OrderHistoryValidation extends SelTestCase {

	public static void startTest(String AdminUser,String user) throws Exception {
		try {
			
			//Login
			HomePage.closeSignUpModal();
			HomePage.clickSignIn();
			Login.Login(AdminUser,getCONFIG().getProperty("NewUserPassword") );
			Assert.assertTrue(Login.verifyIfUserLoggedIn(), "User is not logged in Successfully");

			
			Account.NavigteToManageUsers();
			
			Account.verifyManageUsersHeaderIsDisplayed();
			String companyName = Account.getCompanyName();
			Account.getPaginationBarResults();
			
			Account.clickPaginationBarResultsShowAll();
			
			int numOfUsersAvailable = Account.getNumberOfUserinThePage();
			for(int index=0; index < 6 * numOfUsersAvailable; index++) {
				if(index % 6 == 0)
					logs.debug("<font color=#33BEFF> Row Number: (" + ((index/6) + 1)  + ") </font>");
				Account.getUsersTableData(index);
		
			}
			
			int userIndex = Account.getUserIndex(user, numOfUsersAvailable );
			logs.debug("<font color=#f442cb>User index:" + userIndex + "</font>");
		
			Account.clickOrderHistoryForUserIndex(userIndex);
			
            Account.getPaginationBarResultsForOrders();
			int numofordersAvailable = Account.getNumberOfOrdersinThePage();
			logs.debug("<font color=#f442cb>User " + user + " orders: </font>");
			for(int index=0; index < 5 * numofordersAvailable; index++) {
				if(index % 5 == 0)
					logs.debug("<font color=#33BEFF> Row Number: (" + ((index/5) + 1)  + ") </font>");
				Account.getOrdersTableData(index);
		
			}
			
			String orderNumber = getCONFIG().getProperty("orderNumber");
			logs.debug("<font color=#f442cb> Check if the new order number exist in the orders table </font>");
			boolean orderIsDisplayed=false;
			int orderIndex=-1;
			for (int index = 1; index < 5 * numofordersAvailable; index = index + 5) {
				if (Account.getOrdersTableData(index).contains(orderNumber)) {
					logs.debug("<font color=#33BEFF>" + orderNumber + " order is displayed on the orders table </font>");
					orderIsDisplayed=true;
					break;
				}
			}
			if(orderIsDisplayed)
			orderIndex = Account.getOrderIndex(orderNumber,numofordersAvailable );
			else
			{
			Thread.sleep(8000);
			orderIndex = Account.getOrderIndex(orderNumber,numofordersAvailable );
			}
			if (orderIndex != -1)
			{
				String OrderPlacedDateFromOrdersTable = Account.getOrderPlacedDateFromOrdersTable(orderIndex);
				String OrderStatusFromOrdersTable = Account.getOrderStatusFromOrdersTable(orderIndex);
				String OrderChanelFromOrdersTable = Account.getOrderChanelFromOrdersTable(orderIndex);
				String getOrderTotalFromOrdersTable = Account.getOrderTotalFromOrdersTable(orderIndex);
				Account.clickOrderNumberFromOrdersTable(orderNumber);
			
				String getOrderNumberFromOrderDetailsPage = Account.getOrderNumberFromOrderDetailsPage();
				String OrderPlacedDateFromOrderDetailsPage = Account.getOrderPlacedDateFromOrderDetailsPage();
				String OrderStatusFromOrderDetailsPage = Account.getOrderStatusFromOrderDetailsPage(false);
				String OrderChanelFromOrderDetailsPage = Account.getOrderChannelFromOrderDetailsPage();
				String getOrderTotalFromOrderDetailsPage = Account.getOrderTotalFromOrderDetailsPage(false);
			
				sassert().assertEquals(getOrderNumberFromOrderDetailsPage, orderNumber, "<font color=#f442cb>Expected: "
						+ orderNumber + "Actual: " + getOrderNumberFromOrderDetailsPage + "</font>");
				sassert().assertEquals(OrderPlacedDateFromOrderDetailsPage, OrderPlacedDateFromOrdersTable.replace(" 0", " "),
						"<font color=#f442cb>Expected: " + OrderPlacedDateFromOrdersTable.replace(" 0", " ") + "Actual: "
								+ OrderPlacedDateFromOrderDetailsPage + "</font>");
				sassert().assertEquals(OrderChanelFromOrderDetailsPage, OrderChanelFromOrdersTable,
						"<font color=#f442cb>Expected: " + OrderChanelFromOrdersTable + "Actual: "
								+ OrderChanelFromOrderDetailsPage + "</font>");
				sassert().assertEquals(OrderStatusFromOrderDetailsPage.toLowerCase(), OrderStatusFromOrdersTable.toLowerCase(),
						"<font color=#f442cb>Expected: " + OrderStatusFromOrdersTable + "Actual: "
								+ OrderStatusFromOrderDetailsPage + "</font>");
				sassert().assertEquals(getOrderTotalFromOrderDetailsPage, getOrderTotalFromOrdersTable,
						"<font color=#f442cb>Expected: " + getOrderTotalFromOrdersTable + "Actual: "
								+ getOrderTotalFromOrderDetailsPage + "</font>");

				String shippingAddressFromOrderDetailsPage = Account.getShippingAddressFromOrderDetailsPage(false);
				String shippingMethodFromOrderDetailsPage = Account.getShippingMethodFromOrderDetailsPage(false);
				String trackingNumbersFromOrderDetailsPage = Account.getTrackingNumbersFromOrderDetailsPage();
			
				int NumberOfItemsFromOrderDetailsPage = Account.getNumberOfItemsFromOrderDetailsPage();
				String itemImageSrcFromOrderDetailsPage = Account.getItemImageFromOrderDetailsPage(false);
				String itemNameFromOrderDetailsPage = Account.getItemNameFromOrderDetailsPage(false);
				String itemCodeFromOrderDetailsPage = Account.getItemCodeFromOrderDetailsPage(false);
				String getItemStatusFromOrderDetailsPage = Account.getItemDeliveryFromOrderDetailsPage();
				String itemPriceFromOrderDetailsPage = Account.getItemPriceFromOrderDetailsPage();
				String itemQuantityFromOrderDetailsPage = Account.getItemQuantityFromOrderDetailsPage();
				String itemTotalFromOrderDetailsPage = Account.getItemTotalFromOrderDetailsPage(false);
				
				String BillingAddressFromOrderDetailsPage = Account.getBillingAddressFromOrderDetailsPage();
				String PaymentMethodFromOrderDetailsPage = Account.getPaymentMethodFromOrderDetailsPage(false);
				
				String orderSubtotalFromOrderDetailsPage = Account.getOrderSubtotalFromOrderDetailsPage(false);
				String orderDiscountsFromOrderDetailsPage = Account.getOrderDiscountsFromOrderDetailsPage();
				String orderShippingValueFromOrderDetailsPage = Account.getOrderShippingValueFromOrderDetailsPage(false);
				String orderTaxFromOrderDetailsPage = Account.getOrderTaxFromOrderDetailsPage(false);
				String orderTotalFromOrderDetailsPage = Account.getOrderTotalFromOrderDetailsPage(false);
			
				Account.clickReorderButton();
				CheckOut.checkCartHeader();
				String ReordereditemNameFromCart = CheckOut.getItemNameFromCartPage();
				sassert().assertEquals(ReordereditemNameFromCart, itemNameFromOrderDetailsPage,
						"<font color=#f442cb>Expected: " + itemNameFromOrderDetailsPage + "Actual: "
								+ ReordereditemNameFromCart + "</font>");
			
			}
			
			sassert().assertAll();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

}
