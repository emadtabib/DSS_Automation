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
			logs.debug("Get Company Name");
			String companyName = getDriver().findElement(By.className(AccountSelectors.companyName)).getText();
			logs.debug("Company Name: " + companyName);
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
			logs.debug("verify Manag eUsers Header Is Displayed");
			boolean isDisplayed = getDriver().findElement(By.partialLinkText(AccountSelectors.ManageUsersHeader)).isDisplayed();
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
			logs.debug("Click on Pagination Bar Results ShowAll");
			getDriver().findElement(By.className(AccountSelectors.paginationBarResultsShowAll)).click();
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
			logs.debug("Get pagination Bar Results");
			String paginationBarResults = getDriver().findElement(By.className(AccountSelectors.paginationBarResults)).getText();
			logs.debug("<font color=#f442cb>Pagination Bar Results: </font><font color=#b86d29>" + paginationBarResults + "</font>");
			String maxNum = paginationBarResults.split("-")[1].split(" ")[0];
			logs.debug("Number of rows in the page: " + maxNum);
			int maxNumber = Integer.parseInt(maxNum);
			String TotalNumber = paginationBarResults.split("of")[1].split("Users")[0];
			logs.debug("TotalNumber of rows in the page: " + TotalNumber);
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
			logs.debug("Get pagination Bar Results");
			String paginationBarResults = getDriver().findElement(By.className(AccountSelectors.paginationBarResults)).getText();
			logs.debug("<font color=#f442cb>Pagination Bar Results: </font><font color=#b86d29>" + paginationBarResults + "</font>");
			String maxNum = paginationBarResults.split("- ")[1].split(" ")[0];
			logs.debug("Number of orders in the page: " + maxNum);
			int maxNumber = Integer.parseInt(maxNum);
			String TotalNumber = paginationBarResults.split("of")[1].split("Orders")[0];
			logs.debug("Total Number of orders in the page: " + TotalNumber);
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
			logs.debug("Get Number of rows in the page");
			String paginationBarResults = getDriver().findElement(By.className(AccountSelectors.paginationBarResults)).getText();
			String maxNum = paginationBarResults.split("-")[1].split(" ")[0];
			logs.debug("<font color=#f442cb>Number of rows in the page: </font><font color=#b86d29>" + maxNum + "</font>");
			int maxNumber = Integer.parseInt(maxNum);
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
			logs.debug("Get Number of orders in the page");
			String paginationBarResults = getDriver().findElement(By.className(AccountSelectors.paginationBarResults)).getText();
			String maxNum = paginationBarResults.split("- ")[1].split(" ")[0];
			logs.debug("<font color=#f442cb>Number of orders in the page: </font><font color=#b86d29>" + maxNum + "</font>");
			int maxNumber = Integer.parseInt(maxNum);
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
			logs.debug("Click on Edit Selected User Profiles");
			getDriver().findElement(By.cssSelector(AccountSelectors.editSelectedUserProfiles)).click();
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
			logs.debug("Click on Add New User");
			getDriver().findElement(By.id(AccountSelectors.addNewUser)).click();
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
			logs.debug("Get Users Table Data for index( <font color=#f442cb>" + index + ") </font>");
			String UsersTable = getDriver().findElements(By.cssSelector(AccountSelectors.usersTable)).get(index)
					.getText();
			logs.debug("<font color=#f442cb>Users Table Data for index(" + index + "): </font><font color=#b86d29>"
					+ UsersTable + "</font>");
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
			logs.debug("Get User index: <font color=#f442cb>" + user + ") </font>");
			int index = 3;
			for (index = 3; index < 6 * numberOfUsers; index = index + 6) {
				if (Account.getUsersTableData(index).contains(user)) {
					logs.debug("<font color=#33BEFF>User index:" + index + "</font>");
					break;
				}
			}
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
			logs.debug("Verify Add New User Page Is Opened");
			String header = getDriver().findElement(By.className(AccountSelectors.AddNewUserHeader)).getText();
			logs.debug("Add New User Header: " + header );
			sassert().assertTrue(header.contains(header), "Actual header is :" + header );
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
			logs.debug("Get Company Name In Add New User Page");
			String companyName = getDriver().findElement(By.className(AccountSelectors.companyName)).getText();
			logs.debug("Company Name In Add New User Page: " + companyName);
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
			getDriver().findElement(By.name(AccountSelectors.OrderApprovalThreshold)).clear();
			getDriver().findElement(By.name(AccountSelectors.OrderApprovalThreshold)).sendKeys(OrderApprovalThreshold);
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
			logs.debug("Click on show The Message");
			getDriver().findElement(By.cssSelector(AccountSelectors.showTheMessage)).click();
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
			logs.debug("verify Reset Password Header Is Displayed");
			boolean isDisplayed = getDriver().findElement(By.cssSelector(AccountSelectors.ResetPasswordHeader)).isDisplayed();
			String ResetPasswordHeader = getDriver().findElement(By.cssSelector(AccountSelectors.ResetPasswordHeader)).getText();
			logs.debug("Reset Password Header is: " + ResetPasswordHeader);
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
			logs.debug("Get the Global Alert");
			String GlobalAlert = getDriver().findElement(By.cssSelector(AccountSelectors.GlobalAlert)).getText();
			logs.debug("Global Alert: " + GlobalAlert);
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
			int newIndex = index/6;
			logs.debug("click Order History For User Index: <font color=#f442cb>" + newIndex + ") </font>");
			
			getDriver().findElements(By.partialLinkText(AccountSelectors.OrderHistory)).get(newIndex).click();
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
			logs.debug("Get User Name Data for index( <font color=#f442cb>" + userIndex + ") </font>");
			int userNameIndex = userIndex-2;
			String UserData = getDriver().findElements(By.cssSelector(AccountSelectors.usersTable)).get(userNameIndex)
					.getText();
			logs.debug("<font color=#f442cb>User Name Data for index(" + userNameIndex + "): </font><font color=#b86d29>"
					+ UserData + "</font>");
			return UserData;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "User Name selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	  @SuppressWarnings("unused")
	public static String writeOrderNumberToFile(String orderNumber) {
	        try {
	            logs.debug("Write Order Number To File");
	         
	            	getCONFIG().setProperty("orderNumber", orderNumber);
	
	            FileOutputStream outPropFile;

	            try {
	                outPropFile = new FileOutputStream(System.getProperty("user.dir")
	                                + "/src/com/generic/config/config.properties");
	                getCONFIG().store(outPropFile, "");
	                outPropFile.close();
	            } catch (IOException ioe) {
	                logs.debug("I/O Exception.");
	                System.exit(0);
	            }
	            	
	            	logs.debug("order saved " + getCONFIG().getProperty("orderNumber"));
	
	            return "Pass";
	        } catch (Throwable t) {
	            t.printStackTrace();
	            return "Fail: " + t.getMessage();
	        }
	    }
	
	
	
	
	
	
}
