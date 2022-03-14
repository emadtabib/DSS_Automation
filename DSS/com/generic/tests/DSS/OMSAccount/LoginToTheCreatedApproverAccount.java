package com.generic.tests.DSS.OMSAccount;

import java.text.MessageFormat;
import java.util.NoSuchElementException;

import org.testng.Assert;

import com.generic.page.Account;
import com.generic.page.HomePage;
import com.generic.page.Login;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;

public class LoginToTheCreatedApproverAccount extends SelTestCase {

	public static void startTest(String ApproverMail) throws Exception {
		try {
			
//			Account.NavigteToMailinatorServer("posrt915971");
			Account.NavigteToMailinatorServer(ApproverMail.split("@")[0].trim());
			Account.clickShowTheMessage();
			Account.clickHereToResetYourPassword();
			
			Account.verifyResetPasswordPageIsDisplayed();
			Account.typeResetPassword_password(getCONFIG().getProperty("NewUserPassword"));
			Account.typeResetPassword_confirmPassword(getCONFIG().getProperty("NewUserPassword"));
			Account.submit_ResetPassword();
			Assert.assertFalse(Account.getGlobalAlert().contains("invalid"), "<font color=#f442cb>Failed to Reset the password.</font>");
			
			logs.debug("Login to the created account: " + ApproverMail );
			HomePage.clickSignIn();
			Login.Login(ApproverMail,getCONFIG().getProperty("NewUserPassword") );
			Assert.assertTrue(Login.verifyIfUserLoggedIn(), "User is not logged in Successfully");
			sassert().assertAll();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

}
