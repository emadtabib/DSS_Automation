package com.generic.tests.DSS.OMSAccount;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

import org.testng.Assert;

import com.generic.page.Account;
import com.generic.page.HomePage;
import com.generic.page.Login;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;

public class LoginToTheCreatedAdminAccount extends SelTestCase {

	public static void startTest(String shippingMethod, int productsCount, String AdminMail,
			String PlacerMail, LinkedHashMap<String, String> userDetalis) throws Exception {
		try {
			
			//Login
//			Account.NavigteToMailinatorServer(AdminMail.split("@")[0].trim());
//			Account.clickShowTheMessage();
//			Account.clickHereToResetYourPassword();
//			
//			Account.verifyResetPasswordPageIsDisplayed();
//			Account.typeResetPassword_password(getCONFIG().getProperty("NewUserPassword"));
//			Account.typeResetPassword_confirmPassword(getCONFIG().getProperty("NewUserPassword"));
//			Account.submit_ResetPassword();
//			Assert.assertFalse(Account.getGlobalAlert().contains("invalid"), "<font color=#f442cb>Failed to Reset the password.</font>");
//			
//			logs.debug("Login to the created account: " + AdminMail );
//			HomePage.clickSignIn();
//			Login.Login(AdminMail,getCONFIG().getProperty("NewUserPassword") );
//			Assert.assertTrue(Login.verifyIfUserLoggedIn(), "User is not logged in Successfully");
			
			//Admin Validations
			
			// To Delete
			HomePage.closeSignUpModal();
			HomePage.clickSignIn();
			Login.Login(userDetalis);
			PlacerMail="placer1@gmail.com";
			//
			
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
			
			int userIndex = Account.getUserIndex(PlacerMail, numOfUsersAvailable );
			logs.debug("<font color=#f442cb>User index:" + userIndex + "</font>");
//			Account.getUserNameData(userIndex);
//			Account.NavigteToOrdersForUser(PlacerMail);
		
			Account.clickOrderHistoryForUserIndex(userIndex);
			
            Account.getPaginationBarResultsForOrders();
			int numofUsersAvailable = Account.getNumberOfOrdersinThePage();
			logs.debug("<font color=#f442cb>User " + PlacerMail + " orders: </font>");
			for(int index=0; index < 5 * numofUsersAvailable; index++) {
				if(index % 5 == 0)
					logs.debug("<font color=#33BEFF> Row Number: (" + ((index/5) + 1)  + ") </font>");
				Account.getUsersTableData(index);
		
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
