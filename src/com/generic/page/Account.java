package com.generic.page;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.generic.selector.AccountSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;

public class Account extends SelTestCase {
	
	public static void NavigteToOrderManagementService() {
		getCurrentFunctionName(true);
		getDriver().get(getURL() + getCONFIG().getProperty("OrderManagementServiceURL"));
		getCurrentFunctionName(false);
	}
	
	public static void NavigteToManageUsers() {
		getCurrentFunctionName(true);
		getDriver().get(getURL() + getCONFIG().getProperty("manageUsersURL"));
		getCurrentFunctionName(false);
	}


	public static String getCompanyName() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Company Name");
			String companyName = getDriver().findElement(By.className(AccountSelectors.companyName)).getText();
			logs.debug("Company Name: " + companyName);
			getCurrentFunctionName(false);
			return companyName;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "companyName selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean verifyManageUsersHeaderIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("verify Manag eUsers Header Is Displayed");
			boolean isDisplayed = getDriver().findElement(By.partialLinkText(AccountSelectors.ManageUsersHeader)).isDisplayed();
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "ManageUsersHeader selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickPaginationBarResultsShowAll() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on Pagination Bar Results ShowAll");
			getDriver().findElement(By.className(AccountSelectors.paginationBarResultsShowAll)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Pagination Bar Results ShowAll selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getPaginationBarResults() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get pagination Bar Results");
			String paginationBarResults = getDriver().findElement(By.className(AccountSelectors.paginationBarResults)).getText();
			logs.debug("<font color=#f442cb>Pagination Bar Results: </font><font color=#b86d29>" + paginationBarResults + "</font>");
			String maxNum = paginationBarResults.split("-")[1].split(" ")[0];
			logs.debug("Number of rows in the page: " + maxNum);
			int maxNumber = Integer.parseInt(maxNum);
			String TotalNumber = paginationBarResults.split("of")[1].split("Users")[0];
			logs.debug("TotalNumber of rows in the page: " + TotalNumber);
			getCurrentFunctionName(false);
			return paginationBarResults;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "pagination Bar Results selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getPaginationBarResultsForOrders() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get pagination Bar Results");
			String paginationBarResults = getDriver().findElement(By.className(AccountSelectors.paginationBarResults)).getText();
			logs.debug("<font color=#f442cb>Pagination Bar Results: </font><font color=#b86d29>" + paginationBarResults + "</font>");
			if (paginationBarResults.contains("of")) {
				String maxNum = paginationBarResults.split("- ")[1].split(" ")[0];
				logs.debug("Number of orders in the page: " + maxNum);
				int maxNumber = Integer.parseInt(maxNum);
//				String TotalNumber = paginationBarResults.split("of")[1].split("Orders")[0];
//				logs.debug("Total Number of orders in the page: " + TotalNumber);		
			}
	
			getCurrentFunctionName(false);
			return paginationBarResults;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "pagination Bar Results selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static int getNumberOfUserinThePage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Number of rows in the page");
			String paginationBarResults = getDriver().findElement(By.className(AccountSelectors.paginationBarResults)).getText();
			String maxNum = paginationBarResults.split("-")[1].split(" ")[0];
			logs.debug("<font color=#f442cb>Number of rows in the page: </font><font color=#b86d29>" + maxNum + "</font>");
			int maxNumber = Integer.parseInt(maxNum);
			getCurrentFunctionName(false);
			return maxNumber;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "pagination Bar Results selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static int getNumberOfOrdersinThePage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Number of orders in the page");
			String paginationBarResults = getDriver().findElement(By.className(AccountSelectors.paginationBarResults)).getText();
			String maxNum = null;
			if(paginationBarResults.contains("of"))
			maxNum = paginationBarResults.split("- ")[1].split(" ")[0];
			else
				maxNum = paginationBarResults.split(" ")[0];	
			logs.debug("<font color=#f442cb>Number of orders in the page: </font><font color=#b86d29>" + maxNum + "</font>");
			int maxNumber = Integer.parseInt(maxNum);
			getCurrentFunctionName(false);
			return maxNumber;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "pagination Bar Results selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickEditSelectedUserProfiles() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on Edit Selected User Profiles");
			getDriver().findElement(By.cssSelector(AccountSelectors.editSelectedUserProfiles)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Edit Selected User Profiles selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickAddNewUser() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on Add New User");
			getDriver().findElement(By.id(AccountSelectors.addNewUser)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add New User selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getUsersTableData(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Users Table Data for index( <font color=#f442cb>" + index + ") </font>");
			String UsersTable = getDriver().findElements(By.cssSelector(AccountSelectors.usersTable)).get(index)
					.getText();
			logs.debug("<font color=#f442cb>Users Table Data for index(" + index + "): </font><font color=#b86d29>"
					+ UsersTable + "</font>");
			getCurrentFunctionName(false);
			return UsersTable;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Users Table selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static int getUserIndex(String user, int numberOfUsers) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get User index: <font color=#f442cb>" + user + ") </font>");
			int index = 3;
			for (index = 3; index < 6 * numberOfUsers; index = index + 6) {
				if (Account.getUsersTableData(index).contains(user)) {
					logs.debug("<font color=#33BEFF>User index:" + index + "</font>");
					break;
				}
			}
			getCurrentFunctionName(false);
			return index;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Users Table selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void verifyAddNewUserPageIsOpened() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Verify Add New User Page Is Opened");
			String header = getDriver().findElement(By.className(AccountSelectors.AddNewUserHeader)).getText();
			logs.debug("Add New User Header: " + header );
			sassert().assertTrue(header.contains(header), "Actual header is :" + header );
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Users Table selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getCompanyNameInAddNewUserPage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Company Name In Add New User Page");
			String companyName = getDriver().findElement(By.className(AccountSelectors.companyName)).getText();
			logs.debug("Company Name In Add New User Page: " + companyName);
			getCurrentFunctionName(false);
			return companyName;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "company Name In Add New User Page selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void SelectGroup_CenterName(String Group_CenterName) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Group / Center Name: </font><font color=#b86d29>" + Group_CenterName + "</font>");
			WebElement stateOptions = getDriver().findElement(By.id(AccountSelectors.SelectGroup_CenterName));
			Select select = new Select(stateOptions);
			select.selectByVisibleText(Group_CenterName);
			getCurrentFunctionName(false);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Group / Center Name selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static void typeFirstName(String firstName) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Type firstName: </font><font color=#b86d29>" + firstName + "</font>");
			getDriver().findElement(By.id(AccountSelectors.userFirstName)).sendKeys(firstName);
			getCurrentFunctionName(false);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "firstName selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static void typeLastName(String surName) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Type Last Name: </font><font color=#b86d29>" + surName + "</font>");
			getDriver().findElement(By.id(AccountSelectors.userLastName)).sendKeys(surName);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Last name selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static void typeEmailAddress(String emailAddress) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>type email Address: </font><font color=#b86d29>" + emailAddress + "</font>");
			getDriver().findElement(By.id(AccountSelectors.userEmail)).sendKeys(emailAddress);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "emailAddress selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static void typePhoneNumber(String phoneNumber) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Type phoneNumber: </font><font color=#b86d29>" + phoneNumber + "</font>");
			getDriver().findElement(By.id(AccountSelectors.userPhone)).sendKeys(phoneNumber);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Phone Number selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static void typeCenterName(String userCenterName) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Type Center Name: </font><font color=#b86d29>" + userCenterName + "</font>");
			getDriver().findElement(By.id(AccountSelectors.userCenterName)).sendKeys(userCenterName);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Center Name selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	
	public static void selectUserRule(String UserRule) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Select User Rule: </font><font color=#b86d29>" + UserRule + "</font>");
			String selector = null;
			if (UserRule == "Placer")
				selector = AccountSelectors.placergroup;
			else if (UserRule == "Reviewer")
				selector = AccountSelectors.reviewergroup;
			else if (UserRule == "Approver")
				selector = AccountSelectors.approvergroup;
			else if (UserRule == "admin")
				selector = AccountSelectors.admingroup;

			getDriver().findElement(By.id(selector)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "User Rule selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static void selectOrderReviewer(String OrderReviewer) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Select Order Reviewer: </font><font color=#b86d29>" + OrderReviewer
					+ "</font>");

			getDriver().findElement(By.cssSelector(AccountSelectors.reviewersSelection)).click();
			Thread.sleep(3000);
			
			WebElement element = getDriver().findElement(By.id(OrderReviewer));
			Actions actions = new Actions(getDriver());
			actions.moveToElement(element).click().perform();
	//		getDriver().findElement(By.id(OrderReviewer)).click();
			
			Thread.sleep(1000);
			getDriver().findElement(By.cssSelector(AccountSelectors.SaveSelection_reviewers)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Select Order Reviewer selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void selectOrderApprovers(String OrderApprovers) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Select Order Approvers: </font><font color=#b86d29>" + OrderApprovers
					+ "</font>");

			getDriver().findElement(By.partialLinkText(AccountSelectors.selectApprovers)).click();
			Thread.sleep(3000);
			
			WebElement element = getDriver().findElement(By.id(OrderApprovers));
			Actions actions = new Actions(getDriver());
			actions.moveToElement(element).click().perform();
			
//			getDriver().findElement(By.id(OrderApprovers)).click();
			Thread.sleep(1000);
			getDriver().findElement(By.cssSelector(AccountSelectors.SaveSelection_approvers)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Select Order Approvers selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	
	public static void selectallowedPaymentMethodsPAYPAL() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Select allowed Payment Methods PAYPAL");

			WebElement Webelement = getDriver().findElement(By.id(AccountSelectors.allowedPaymentMethodsPAYPAL));
			Actions actions = new Actions(getDriver());
			actions.moveToElement(Webelement).click().perform();
			
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "allowed Payment Methods PAYPAL selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void selectallowedPaymentMethodsCC() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Select allowed Payment Methods CC");

			WebElement Webelement = getDriver().findElement(By.id(AccountSelectors.allowedPaymentMethodsCREDITCARD));
			Actions actions = new Actions(getDriver());
			actions.moveToElement(Webelement).click().perform();
			
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "allowed Payment Methods CC selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	
	public static void selectAllowedChangeToShippingAddress() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Select Yes Allow Change to Shipping Address?");

			getDriver().findElement(By.id(AccountSelectors.allowChangeToShippingAddress_Yes)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + " Allow Change to Shipping Address? selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void selectAllowedChangeToBillingAddress() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Select Yes Allow Change to Billing Address?");

			getDriver().findElement(By.id(AccountSelectors.allowChangeToBillingAddress_Yes)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + " Allow Change to Billing Address? selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void typeOrderApprovalThreshold(String OrderApprovalThreshold) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Type Order Approval Threshold: </font><font color=#b86d29>" + OrderApprovalThreshold + "</font>");
//			getDriver().findElement(By.name(AccountSelectors.OrderApprovalThreshold)).clear();
//			getDriver().findElement(By.name(AccountSelectors.OrderApprovalThreshold)).sendKeys(OrderApprovalThreshold);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Order Approval Threshold selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void submit_AddNewUser() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on Submit - Add New User Approval Threshold");
			getDriver().findElement(By.cssSelector(AccountSelectors.submit_AddNewUser)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + " Submit (Add New User) selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void NavigteToMailinatorServer(String email) {
		getCurrentFunctionName(true);
		getDriver().get("https://www.mailinator.com/v4/public/inboxes.jsp?to=" + email);
		getCurrentFunctionName(false);
	}
	
	public static void clickShowTheMessage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on show The Message");
			getDriver().findElement(By.cssSelector(AccountSelectors.showTheMessage)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Show The Message selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickHereToResetYourPassword() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click Here To Reset Your Password");
			getDriver().switchTo().frame("html_msg_body");
			
			
			String url = getDriver().findElement(By.partialLinkText(AccountSelectors.clickHereToResetYourPassword)).getAttribute("href");
			getDriver().get(url);
			String CurrentURL = getDriver().getCurrentUrl();
			logs.debug("CurrentURL: " + CurrentURL);
			String newURL = CurrentURL.replaceFirst("s1", getCONFIG().getProperty("Env"));
			logs.debug("newURL: " + newURL);
			getDriver().get(newURL);
			getDriver().switchTo().parentFrame();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Click Here To Reset Your Password selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean verifyResetPasswordPageIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("verify Reset Password Header Is Displayed");
			boolean isDisplayed = getDriver().findElement(By.cssSelector(AccountSelectors.ResetPasswordHeader)).isDisplayed();
			String ResetPasswordHeader = getDriver().findElement(By.cssSelector(AccountSelectors.ResetPasswordHeader)).getText();
			logs.debug("Reset Password Header is: " + ResetPasswordHeader);
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Reset Password Header selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void typeResetPassword_password(String password) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Type Reset Password: password: </font><font color=#b86d29>" + password + "</font>");
			getDriver().findElement(By.id(AccountSelectors.ResetPassword_password)).sendKeys(password);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Reset Password: password selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void typeResetPassword_confirmPassword(String confirmPassword) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("<font color=#f442cb>Type Reset Password: confirmPassword: </font><font color=#b86d29>" + confirmPassword + "</font>");
			getDriver().findElement(By.id(AccountSelectors.ResetPassword_ConfirmPassword)).sendKeys(confirmPassword);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Reset Password: confirmPassword: selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void submit_ResetPassword() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on Submit - Reset Password");
			getDriver().findElement(By.cssSelector(AccountSelectors.ResetPassword_Submit)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + " Submit (Reset Password) selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getGlobalAlert() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get the Global Alert");
			String GlobalAlert = getDriver().findElement(By.cssSelector(AccountSelectors.GlobalAlert)).getText();
			logs.debug("Global Alert: " + GlobalAlert);
			getCurrentFunctionName(false);
			return GlobalAlert;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Reset Password Header selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void NavigteToEditPrfileForUser(String email) {
		getCurrentFunctionName(true);
		logs.debug("Navigte To Edit Prfile For User: " + email);
		getDriver().get(getURL() + "/your-company/organization-management/manage-users/edit?user=" + email);
		getCurrentFunctionName(false);
	}
	
	public static void NavigteToOrdersForUser(String email) {
		getCurrentFunctionName(true);
		logs.debug("Navigte To Orders History For User: " + email);
		getDriver().get(getURL() + "/your-company/organization-management/manage-users/getOrders?user=" + email);
		getCurrentFunctionName(false);
	}
	
	public static int clickOrderHistoryForUserIndex(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			int newIndex = index/6;
			logs.debug("click Order History For User Index: <font color=#f442cb>" + newIndex + ") </font>");
			
			getDriver().findElements(By.partialLinkText(AccountSelectors.OrderHistory)).get(newIndex).click();
			getCurrentFunctionName(false);
			return index;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Users Table selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getUserNameData(int userIndex) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get User Name Data for index( <font color=#f442cb>" + userIndex + ") </font>");
			int userNameIndex = userIndex-2;
			String UserData = getDriver().findElements(By.cssSelector(AccountSelectors.usersTable)).get(userNameIndex)
					.getText();
			logs.debug("<font color=#f442cb>User Name Data for index(" + userNameIndex + "): </font><font color=#b86d29>"
					+ UserData + "</font>");
			getCurrentFunctionName(false);
			return UserData;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "User Name selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	

	public static void writeOrderNumberToConfigFile(String Property, String orderNumber) {
		try {
			getCurrentFunctionName(true);
			logs.debug("Write Order Number To Config File property");
			getCONFIG().setProperty(Property, orderNumber);
			FileOutputStream outPropFile;

			try {
				outPropFile = new FileOutputStream(
						System.getProperty("user.dir") + "/src/com/generic/config/config.properties");
				getCONFIG().store(outPropFile, "");
				outPropFile.close();
			} catch (IOException ioe) {
				logs.debug("I/O Exception.");
				System.exit(0);
			}

			logs.debug("order saved " + getCONFIG().getProperty(Property));
			getCurrentFunctionName(false);
		} catch (Throwable e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed + e.getMessage(), new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOrdersTableData(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Orders Table Data for index( <font color=#f442cb>" + index + ") </font>");
			String UsersTable = getDriver().findElements(By.cssSelector(AccountSelectors.usersTable)).get(index)
					.getText();
			logs.debug("<font color=#f442cb>Orders Table Data for index(" + index + "): </font><font color=#b86d29>"
					+ UsersTable + "</font>");
			getCurrentFunctionName(false);
			return UsersTable;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Orders Table selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static int getOrderIndex(String order, int numberOfOrders) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get User index: <font color=#f442cb>" + order + ") </font>");
			int orderindex = -1;
			for (int index = 1; index < 5 * numberOfOrders; index = index + 5) {
				if (Account.getOrdersTableData(index).contains(order)) {
					logs.debug("<font color=#33BEFF> Order index:" + index/5 + "</font>");
					orderindex=index;
					break;
				}
			}
			getCurrentFunctionName(false);
			return orderindex;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Orders Table selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOrderPlacedDateFromOrdersTable(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Placed Date for order in index( <font color=#f442cb>" + index/5 + ") </font>");
			String OrderPlacedDate = getDriver().findElements(By.cssSelector(AccountSelectors.usersTable)).get(index-1)
					.getText();
			
			logs.debug("Order Placed Date: <font color=#f442cb>" + OrderPlacedDate + "</font>");
			getCurrentFunctionName(false);
			return OrderPlacedDate;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Orders Table selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickOrderNumberFromOrdersTable(String orderNumber) throws Exception {
		try {
			getCurrentFunctionName(true);
//			logs.debug("Click on order Number for order in index( <font color=#f442cb>" + index/5 + ") </font>");
//			getDriver().findElements(By.cssSelector(AccountSelectors.usersTable)).get(index)
//					.click();
			logs.debug("Click on order Number: <font color=#f442cb>" + orderNumber + " </font>");

			getDriver().findElement(By.partialLinkText(orderNumber)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Orders Table selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOrderStatusFromOrdersTable(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Status for order in index( <font color=#f442cb>" + index/5 + ") </font>");
			String OrderStatus = getDriver().findElements(By.cssSelector(AccountSelectors.usersTable)).get(index+1)
					.getText();
			
			logs.debug("Order Status: <font color=#f442cb>" + OrderStatus + "</font>");
			getCurrentFunctionName(false);
			return OrderStatus;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Orders Table selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOrderPlacerFromOrdersTable(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Placer for order in index( <font color=#f442cb>" + index/5 + " )</font>");
			String OrderChannel = getDriver().findElements(By.cssSelector(AccountSelectors.usersTable)).get(index+2)
					.getText();
			
			logs.debug("Order Placer: <font color=#f442cb>" + OrderChannel + "</font>");
			getCurrentFunctionName(false);
			return OrderChannel;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Orders Table selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOrderChanelFromOrdersTable(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Chanel for order in index( <font color=#f442cb>" + index/5 + ") </font>");
			String OrderChannel = getDriver().findElements(By.cssSelector(AccountSelectors.usersTable)).get(index+2)
					.getText();
			
			logs.debug("Order Channel: <font color=#f442cb>" + OrderChannel + "</font>");
			getCurrentFunctionName(false);
			return OrderChannel;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Orders Table selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOrderTotalFromOrdersTable(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Total for order in index( <font color=#f442cb>" + index/5 + ") </font>");
			String OrderTotal = getDriver().findElements(By.cssSelector(AccountSelectors.usersTable)).get(index+3)
					.getText();
			
			logs.debug("Order Total: <font color=#f442cb>" + OrderTotal + "</font>");
			getCurrentFunctionName(false);
			return OrderTotal;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Orders Table selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOHOrderStatusFromOrdersTable(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Status for order in index( <font color=#f442cb>" + index/5 + ") </font>");
			String OrderStatus = getDriver().findElements(By.cssSelector(AccountSelectors.usersTable)).get(index+2)
					.getText();
			
			logs.debug("Order Status: <font color=#f442cb>" + OrderStatus + "</font>");
			getCurrentFunctionName(false);
			return OrderStatus;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Orders Table selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOHOrderPlacedByFromOrdersTable(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order PlacedBy for order in index( <font color=#f442cb>" + index/5 + " )</font>");
			String OrderStatus = getDriver().findElements(By.cssSelector(AccountSelectors.usersTable)).get(index+1)
					.getText();
			
			logs.debug("Order PlacedBy: <font color=#f442cb>" + OrderStatus + "</font>");
			getCurrentFunctionName(false);
			return OrderStatus;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Orders Table selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOrderNumberFromOrderDetailsPage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Number From Order Details Page </font>");
			String OrderNumber = getDriver().findElements(By.className(AccountSelectors.orderDetailsTableValues)).get(0).getText();
			logs.debug("Order Number: <font color=#f442cb>" + OrderNumber + "</font>");
			getCurrentFunctionName(false);
			return OrderNumber;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Orders Table From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOrderPlacedDateFromOrderDetailsPage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Placed Date From Order Details Page </font>");
			String OrderNumber = getDriver().findElements(By.className(AccountSelectors.orderDetailsTableValues)).get(1).getText();
			logs.debug("Order Placed Date: <font color=#f442cb>" + OrderNumber + "</font>");
			getCurrentFunctionName(false);
			return OrderNumber;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Orders Table From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOrderStatusFromOrderDetailsPage(boolean isOHR) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Staus From Order Details Page </font>");
			String OrderStatus = null;
			if (isOHR)
				OrderStatus = getDriver().findElements(By.className(AccountSelectors.orderDetailsTableValues)).get(3)
						.getText();
			else
				OrderStatus = getDriver().findElements(By.className(AccountSelectors.orderDetailsTableValues)).get(2)
						.getText();

			logs.debug("Order Status: <font color=#f442cb>" + OrderStatus + "</font>");
			getCurrentFunctionName(false);
			return OrderStatus;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Orders Table From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOrderPlacedByValueFromOrderDetailsPage(boolean isOHR) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Placed By Value From Order Details Page </font>");
			String OrderPlacedBy = null;
			if (isOHR)
				OrderPlacedBy = getDriver().findElements(By.className(AccountSelectors.orderDetailsTableValues)).get(4)
						.getText();
			else
				OrderPlacedBy = getDriver().findElements(By.className(AccountSelectors.orderDetailsTableValues)).get(3)
						.getText();

			logs.debug("Order Placed By: <font color=#f442cb>" + OrderPlacedBy + "</font>");
			getCurrentFunctionName(false);
			return OrderPlacedBy;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Orders Table From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOrderTotalFromOrderDetailsPage(boolean isOHR) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Total From Order Details Page </font>");
			String OrderTotal = null;
			if (isOHR)
				OrderTotal = getDriver().findElements(By.className(AccountSelectors.orderDetailsTableValues)).get(2)
						.getText();
			else
				OrderTotal = getDriver().findElements(By.className(AccountSelectors.orderDetailsTableValues)).get(5)
						.getText();

			logs.debug("Order Total: <font color=#f442cb>" + OrderTotal + "</font>");
			getCurrentFunctionName(false);
			return OrderTotal;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Orders Table From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOrderChannelFromOrderDetailsPage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Channel From Order Details Page </font>");
			String OrderChannel = getDriver().findElements(By.className(AccountSelectors.orderDetailsTableValues)).get(4)
						.getText();

			logs.debug("Order Channel: <font color=#f442cb>" + OrderChannel + "</font>");
			getCurrentFunctionName(false);
			return OrderChannel;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Orders Table From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOrderReviewerFromOrderDetailsPage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Reviewer From Order Details Page </font>");
			String OrderReviewer = getDriver().findElements(By.className(AccountSelectors.orderDetailsTableValues)).get(5).getText();
			logs.debug("Order Reviewer: <font color=#f442cb>" + OrderReviewer + "</font>");
			getCurrentFunctionName(false);
			return OrderReviewer;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Orders Table From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getShippingAddressFromOrderDetailsPage(boolean ohr) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Shipping Address From Order Details Page </font>");
			String shippingData = null;
			if (ohr)
				shippingData = getDriver().findElement(By.cssSelector(AccountSelectors.ohrEditShippAddress)).getText();
			else
				shippingData = getDriver().findElements(By.cssSelector(AccountSelectors.shippingData)).get(0).getText();
			logs.debug("Shipping Address: <font color=#f442cb>" + shippingData + "</font>");
			getCurrentFunctionName(false);
			return shippingData;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed
							+ "Shipping Table From Order Details Page selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getShippingMethodFromOrderDetailsPage(boolean ohr) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Shipping Method From Order Details Page </font>");
			String shippingData = null;
			if (ohr)
				shippingData = getDriver().findElements(By.cssSelector(AccountSelectors.ohrShippingData)).get(1).getText();
			else
				shippingData = getDriver().findElements(By.cssSelector(AccountSelectors.shippingData)).get(1).getText();

			logs.debug("Shipping Method: <font color=#f442cb>" + shippingData + "</font>");
			getCurrentFunctionName(false);
			return shippingData;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Shipping Table From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getTrackingNumbersFromOrderDetailsPage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Tracking Numbers From Order Details Page </font>");
			String shippingData = getDriver().findElements(By.cssSelector(AccountSelectors.shippingData)).get(2)
						.getText();

			logs.debug("Tracking Numbers: <font color=#f442cb>" + shippingData + "</font>");
			getCurrentFunctionName(false);
			return shippingData;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Shipping Table From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static int getNumberOfItemsFromOrderDetailsPage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Number Of Items From Order Details Page </font>");
			int NumberOfItems = getDriver().findElements(By.className(AccountSelectors.ListItems)).size();

			logs.debug("Number Of Items: <font color=#f442cb>" + NumberOfItems + "</font>");
			getCurrentFunctionName(false);
			return NumberOfItems;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "List items selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getItemImageFromOrderDetailsPage(boolean isohr) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get item Image From Order Details Page </font>");
			String itemImagesrc = null;
			String itemImagealt = null;
			if(isohr) {
				itemImagesrc = getDriver().findElements(By.cssSelector(AccountSelectors.ohritemImage)).get(0).getAttribute("src");
				itemImagealt = getDriver().findElements(By.cssSelector(AccountSelectors.ohritemImage)).get(0).getAttribute("alt");
			}
			else 
			{
				itemImagesrc = getDriver().findElements(By.cssSelector(AccountSelectors.itemImage)).get(0).getAttribute("src");
				itemImagealt = getDriver().findElements(By.cssSelector(AccountSelectors.itemImage)).get(0).getAttribute("alt");		
			}
			logs.debug("item Image src: <font color=#f442cb>" + itemImagesrc + "</font>");
			logs.debug("item Image alt: <font color=#f442cb>" + itemImagealt + "</font>");
			getCurrentFunctionName(false);
			return itemImagesrc;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "item Image From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getItemCodeFromOrderDetailsPage(boolean isohr) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get item code From Order Details Page </font>");
			String itemCode = null;
			if (isohr)
				itemCode = getDriver().findElements(By.cssSelector(AccountSelectors.ohritemCode)).get(0).getText();
			else
				itemCode = getDriver().findElements(By.cssSelector(AccountSelectors.itemCode)).get(0).getText();
			logs.debug("item code: <font color=#f442cb>" + itemCode + "</font>");
			getCurrentFunctionName(false);
			return itemCode;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "item code From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getItemDeliveryFromOrderDetailsPage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get item Status From Order Details Page </font>");
			String itemDelivery = getDriver().findElements(By.cssSelector(AccountSelectors.itemDelivery)).get(0).getText();
			logs.debug("item Status: <font color=#f442cb>" + itemDelivery + "</font>");
			getCurrentFunctionName(false);
			return itemDelivery;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "item Delivery From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getItemPriceFromOrderDetailsPage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get item price From Order Details Page </font>");
			String itemPrice = getDriver().findElements(By.cssSelector(AccountSelectors.itemPrice)).get(0).getText();
			logs.debug("item price: <font color=#f442cb>" + itemPrice + "</font>");
			getCurrentFunctionName(false);
			return itemPrice;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "item price From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getItemQuantityFromOrderDetailsPage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get item Quantity From Order Details Page </font>");
			String itemQuantity = getDriver().findElements(By.cssSelector(AccountSelectors.itemQuantity)).get(0).getText();
			logs.debug("item Quantity: <font color=#f442cb>" + itemQuantity + "</font>");
			getCurrentFunctionName(false);
			return itemQuantity;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "item Quantity From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getItemNameFromOrderDetailsPage(boolean isohr) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get item name From Order Details Page </font>");
			String itemName = null;
			if (isohr)
				itemName =  getDriver().findElements(By.cssSelector(AccountSelectors.ohritemName)).get(0).getText();
			else
				itemName =  getDriver().findElements(By.cssSelector(AccountSelectors.itemName)).get(0).getText();
			logs.debug("item name: <font color=#f442cb>" + itemName + "</font>");
			getCurrentFunctionName(false);
			return itemName;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "item name From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getItemTotalFromOrderDetailsPage(boolean isohr) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get item subtotal From Order Details Page </font>");
			String itemTotal = null;
			if (isohr)
				itemTotal = getDriver().findElements(By.cssSelector(AccountSelectors.ohritemTotal)).get(0).getText();
			else
				itemTotal = getDriver().findElements(By.cssSelector(AccountSelectors.itemTotal)).get(0).getText();

			logs.debug("item Subtotal: <font color=#f442cb>" + itemTotal + "</font>");
			getCurrentFunctionName(false);
			return itemTotal;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "item total From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getBillingAddressFromOrderDetailsPage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Billing Address From Order Details Page </font>");
			String billingAddress =getDriver().findElement(By.cssSelector(AccountSelectors.billingAddress)).getText();
			
			logs.debug("Billing Address: <font color=#f442cb>" + billingAddress + "</font>");
			getCurrentFunctionName(false);
			return billingAddress;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Billing Address From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getPaymentMethodFromOrderDetailsPage(boolean ohr) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Payment Method From Order Details Page </font>");
			String paymentMethod = null;
			if (ohr)
				paymentMethod = getDriver().findElement(By.cssSelector(AccountSelectors.ohrBillingSection)).getText();
			else
				paymentMethod = getDriver().findElement(By.cssSelector(AccountSelectors.paymentMethod)).getText();
			logs.debug("Payment Method: <font color=#f442cb>" + paymentMethod + "</font>");
			getCurrentFunctionName(false);
			return paymentMethod;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed
							+ "Payment Method From Order Details Page selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOrderSubtotalFromOrderDetailsPage(boolean ohr) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Subtotal From Order Details Page </font>");
			String OrderSubtotal = null;
			if (ohr)
				OrderSubtotal = getDriver()
						.findElements(By.cssSelector(AccountSelectors.ohrOrderSummaryFromOrderDetailsPage)).get(1)
						.getText();
			else
				OrderSubtotal = getDriver()
						.findElements(By.cssSelector(AccountSelectors.OrderSummaryFromOrderDetailsPage)).get(0)
						.getText();
			logs.debug("Order Subtotal: <font color=#f442cb>" + OrderSubtotal + "</font>");
			getCurrentFunctionName(false);
			return OrderSubtotal;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed
							+ "Order Subtotal From Order Details Page selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOrderDiscountsFromOrderDetailsPage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Discounts From Order Details Page </font>");
			String Discounts = getDriver().findElements(By.cssSelector(AccountSelectors.OrderSummaryFromOrderDetailsPage)).get(1).getText();
			logs.debug("Order Discounts: <font color=#f442cb>" + Discounts + "</font>");
			getCurrentFunctionName(false);
			return Discounts;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Order Discounts From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOrderShippingValueFromOrderDetailsPage(boolean ohr) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Shipping Value From Order Details Page </font>");
			String OrderShippingValue = null;
			if (ohr)
				OrderShippingValue = getDriver()
						.findElements(By.cssSelector(AccountSelectors.ohrOrderSummaryFromOrderDetailsPage)).get(3)
						.getText();
			else
				OrderShippingValue = getDriver()
						.findElements(By.cssSelector(AccountSelectors.OrderSummaryFromOrderDetailsPage)).get(2)
						.getText();
			logs.debug("Order Shipping Value: <font color=#f442cb>" + OrderShippingValue + "</font>");
			getCurrentFunctionName(false);
			return OrderShippingValue;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed
							+ "Order Shipping Value From Order Details Page selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOrderTaxFromOrderDetailsPage(boolean ohr) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Tax From Order Details Page </font>");
			String OrderTax = null;
			if (ohr)
				OrderTax = getDriver()
						.findElements(By.cssSelector(AccountSelectors.ohrOrderSummaryFromOrderDetailsPage)).get(5)
						.getText();
			else
				OrderTax = getDriver()
						.findElements(By.cssSelector(AccountSelectors.OrderSummaryFromOrderDetailsPage)).get(3)
						.getText();
			
			logs.debug("Order Tax: <font color=#f442cb>" + OrderTax + "</font>");
			getCurrentFunctionName(false);
			return OrderTax;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Order Tax From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getOrderSummaryOrderTotalFromOrderDetailsPage(boolean ohr) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Total From Order Details Page </font>");
			String OrderTotal = null;
			if (ohr)
				OrderTotal = getDriver()
						.findElements(By.cssSelector(AccountSelectors.ohrOrderSummaryFromOrderDetailsPage)).get(7)
						.getText();
			else
				OrderTotal = getDriver()
						.findElements(By.cssSelector(AccountSelectors.OrderSummaryFromOrderDetailsPage)).get(4)
						.getText();
			logs.debug("Order Total: <font color=#f442cb>" + OrderTotal + "</font>");
			getCurrentFunctionName(false);
			return OrderTotal;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Order Total From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickReorderButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click Reorder Button </font>");
			getDriver().findElements(By.id(AccountSelectors.reorderButton)).get(0).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Reorder Button selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickOnHoldOrdersNavLink() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click On Hold Orders Link from My account Flyout </font>");
			getDriver().findElement(By.cssSelector(AccountSelectors.OnHoldOrdersFromMyAccountFlyout)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "On Hold Orders Link from My account Flyout selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickYourOrdersNavLink() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click Your Orders Link from My account Flyout </font>");
			getDriver().findElement(By.cssSelector(AccountSelectors.YourOrdersFromMyAccountFlyout)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Your Orders Link from My account Flyout selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean verifyYourOrdersHeaderIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("verify Your Orders Header Is Displayed");
			boolean isDisplayed = getDriver().findElement(By.partialLinkText(AccountSelectors.YourOrdersHeader)).isDisplayed();
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Your Orders Header selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean verifyOnHoldOrdersHeaderIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("verify On Hold Orders Header Is Displayed");
			boolean isDisplayed = getDriver().findElement(By.partialLinkText(AccountSelectors.OnHoldOrdersHeader)).isDisplayed();
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "On Hold Orders Header selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickToUnlockOrder(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click to unlock order </font>");
			getDriver().findElements(By.partialLinkText(AccountSelectors.ClickToUnlockOrder)).get(index/5).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Click to unlock order Link selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean verifyOrderDetailsHeaderIsDisplayed(String onHoldOrderNumber) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("verify On Hold Order Details Header Is Displayed");
			boolean isDisplayed = getDriver().findElement(By.cssSelector(AccountSelectors.OnHoldOrderDetailsHeader)).isDisplayed();
			String header = getDriver().findElement(By.cssSelector(AccountSelectors.OnHoldOrderDetailsHeader)).getText();
			logs.debug("On Hold Order Details Header: <font color=#f442cb>" + header + "</font>");
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "On Hold Order Details Header selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getohrCommentsFromOrderDetailsPage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get Order Discounts From Order Details Page </font>");
			String ohrCommentsDisplay = getDriver().findElement(By.cssSelector(AccountSelectors.ohrCommentsDisplay)).getText();
			logs.debug("ohr Comments: <font color=#f442cb>" + ohrCommentsDisplay + "</font>");
			getCurrentFunctionName(false);
			return ohrCommentsDisplay;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "ohr Comments From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getohrMessageFromOrderDetailsPage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get ohr Message From Order Details Page </font>");
			String ohrMessage = getDriver().findElement(By.className(AccountSelectors.ohrMessage)).getText();
			logs.debug("ohr Message: <font color=#f442cb>" + ohrMessage + "</font>");
			getCurrentFunctionName(false);
			return ohrMessage;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "ohr Message From Order Details Page selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickohrSubmitForApproval() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click ohr Submit For Approval Button </font>");
			getDriver().findElements(By.partialLinkText(AccountSelectors.ohrSubmitForApproval)).get(0).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "ohr Submit For Approval Button selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	
	public static void clickohrRejectOrder() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click ohr Reject Order Button </font>");
			getDriver().findElements(By.partialLinkText(AccountSelectors.ohrRejectOrder)).get(0).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "ohr Reject Order Button selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void typeRejectReason(String reason) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Type ohr Reject reason: </font>"+ reason);
			getDriver().findElement(By.id(AccountSelectors.rejectcomments)).sendKeys(reason);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Reject reason text selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickohrRejectReasonsubmit() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click Submit for Reject reason </font>");
			getDriver().findElement(By.id(AccountSelectors.rejectreasonsubmit)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Submit button for reject reason selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getohrOrderReleasedMessage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get order Released Message </font>");
			String orderReleased = getDriver().findElement(By.cssSelector(AccountSelectors.orderReleased)).getText();
			logs.debug("order Released Message: <font color=#f442cb>" + orderReleased + "</font>");
			getCurrentFunctionName(false);
			return orderReleased;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "order Released Message selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean verifyContinueShoppingButtonIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("verify Continue Shopping Button Is Displayed");
			boolean isDisplayed = getDriver().findElement(By.partialLinkText(AccountSelectors.ContinueShopping)).isDisplayed();
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "ContinueShopping selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickohrSubmitForRelease() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click ohr Submit For Release Button </font>");
			getDriver().findElements(By.partialLinkText(AccountSelectors.ohrSubmitForRelease)).get(0).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "ohr Submit For Release Button selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getohrOrderApprovedMessage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get order Approved Message </font>");
			String orderApproved = getDriver().findElement(By.cssSelector(AccountSelectors.orderApproved)).getText();
			logs.debug("order Approved Message: <font color=#f442cb>" + orderApproved + "</font>");
			getCurrentFunctionName(false);
			return orderApproved;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "order Approved Message selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickohrEditPayment() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click ohr Edit Payment Button </font>");
			getDriver().findElement(By.id(AccountSelectors.ohrEditPayment)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "ohr Edit Payment Button selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getselectedPaymentMethodId() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Validate a selected Payment Method is displayed</font>");
			String selectedPaymentMethodId = getDriver().findElement(By.id(AccountSelectors.selectedPaymentMethodId)).getAttribute("value");
			logs.debug("selected Payment Method is displayed with ID: <font color=#f442cb>" + selectedPaymentMethodId + "</font>");
			getCurrentFunctionName(false);
			return selectedPaymentMethodId;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "selected Payment Method Id selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getselectedBillingAddress() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Validate selected Billing Address is displayed </font>");
			String selectedBillingAddress = getDriver().findElement(By.id(AccountSelectors.selectedBillingAddress)).getText();
			logs.debug("selected Billing Address: <font color=#f442cb>" + selectedBillingAddress + "</font>");
			getCurrentFunctionName(false);
			return selectedBillingAddress;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "selected Billing Address selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void typeCreditCVV(String cvv) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Type Credit CVV: </font>" + cvv);
			getDriver().findElement(By.id(AccountSelectors.creditCVV)).sendKeys(cvv);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "selected Billing Address selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickSaveAndContinue() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click ohr Save And Continue Button </font>");
			getDriver().findElement(By.cssSelector(AccountSelectors.SaveAndContinue)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "ohr Save&Continue selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickohrEditCard() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click ohr Edit Card Button </font>");
			getDriver().findElement(By.cssSelector(AccountSelectors.editCard)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "ohr Edit Card Button selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickohrAddCard() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click ohr Add Card Button </font>");
			getDriver().findElement(By.cssSelector(AccountSelectors.addCard)).click();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "ohr add Card Button selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getCompletedCreditCardNumber() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Validate completed credit card is displayed </font>");
			String completedCreditCard = getDriver().findElement(By.cssSelector(AccountSelectors.completedCreditCard)).getText();
			logs.debug("completed credit card number: <font color=#f442cb>" + completedCreditCard + "</font>");
			getCurrentFunctionName(false);
			return completedCreditCard;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "completed credit card selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static String getCompletedCreditCardBilling() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Validate completed credit card billing address is displayed </font>");
			String completedCreditCardBilling = getDriver().findElement(By.cssSelector(AccountSelectors.completedCreditCardBilling)).getText();
			logs.debug("completed credit card billing address: <font color=#f442cb>" + completedCreditCardBilling + "</font>");
			getCurrentFunctionName(false);
			return completedCreditCardBilling;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "completed credit card billing address selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	
	
}
