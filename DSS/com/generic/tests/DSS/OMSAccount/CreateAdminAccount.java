package com.generic.tests.DSS.OMSAccount;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

import com.generic.page.Account;
import com.generic.page.HomePage;
import com.generic.page.Login;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.RandomUtilities;

//DSS
public class CreateAdminAccount extends SelTestCase {

	public static void startTest(String AdminMail, LinkedHashMap<String, String> userdetails) throws Exception {
		getCurrentFunctionName(true);

		try {
			

			String firstName = RandomUtilities.getRandomName();
			String lastName = RandomUtilities.getRandomName();
			String phoneNumber = RandomUtilities.getRandomPhone();
			String CenterName = "Auto";
			String UserRule = "Admin";
			
			HomePage.closeSignUpModal();
			
			HomePage.clickSignIn();
			Login.Login(userdetails);
	
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

			Account.clickAddNewUser();
			Account.verifyAddNewUserPageIsOpened();
			String companyNameInAddNewUserPage = Account.getCompanyNameInAddNewUserPage();
			sassert().assertEquals(companyNameInAddNewUserPage, companyName, "Company Name In Add New User Page is : "
					+ companyNameInAddNewUserPage + "Expected Company name is: " + companyName);

			Account.SelectGroup_CenterName(getCONFIG().getProperty("Group_CenterName"));
			
			Account.typeFirstName(firstName);
			Account.typeLastName(lastName);
			Account.typeEmailAddress(AdminMail);
			Account.typePhoneNumber(phoneNumber);
			Account.typeCenterName(CenterName);
			
			Account.selectUserRule(UserRule);
			
			Thread.sleep(1000);
			Account.selectallowedPaymentMethodsPAYPAL();
			Account.selectallowedPaymentMethodsCC();
			
//			Account.selectAllowedChangeToShippingAddress();
//			Account.selectAllowedChangeToBillingAddress();
			
			Account.typeOrderApprovalThreshold(getCONFIG().getProperty("OrderApprovalThreshold"));
			Account.submit_AddNewUser();
		
			Account.verifyManageUsersHeaderIsDisplayed();
			Account.getPaginationBarResults();
			Account.clickPaginationBarResultsShowAll();

			int newNumOfUsersAvailable = Account.getNumberOfUserinThePage();
			sassert().assertNotEquals(newNumOfUsersAvailable, numOfUsersAvailable, "Account is not added successfully, user count is not updated");
			
			logs.debug("<font color=#f442cb> Check if the new email exist in the users table </font>");
			for (int index = 3; index < 6 * newNumOfUsersAvailable; index = index + 6) {
				if (Account.getUsersTableData(index).contains(AdminMail)) {
					logs.debug("<font color=#33BEFF>" + AdminMail + " User Added Successfully </font>");
					break;
				}
			}
			
			int userIndex = Account.getUserIndex(AdminMail, newNumOfUsersAvailable );
			logs.debug("<font color=#f442cb>User index:" + userIndex + "</font>");
			sassert().assertAll();
			getCurrentFunctionName(false);

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

}
