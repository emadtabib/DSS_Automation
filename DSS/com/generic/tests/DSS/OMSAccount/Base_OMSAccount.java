package com.generic.tests.DSS.OMSAccount;

import java.text.MessageFormat;
import java.util.Arrays;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;
import java.util.LinkedHashMap;
import com.generic.setup.Common;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.setup.SheetVariables;
import com.generic.util.dataProviderUtils;
import com.generic.util.RandomUtilities;
import com.generic.util.SASLogger;

public class Base_OMSAccount extends SelTestCase {

	// user types
	public static final String Create_Approver_account  = "Create an Approver account";
	public static final String Login_To_The_Created_Approver_account  = "Login to the created Approver account";
	public static final String Create_Reviewer_account  = "Create a Reviewer account";
	public static final String Login_To_The_Created_Reviewer_account  = "Login to the created Reviewer account";
	public static final String Create_Placer_account  = "Create a Placer account";
	public static final String Login_To_The_Created_Placer_account  = "Login to the created placer account";
	public static final String Create_Admin_account  = "Create an Admin account";
	public static final String Login_To_The_Created_Admin_account  = "Login to the created Admin account";
	public static final String Order_History_Validation_From_Manage_Users = "Order History Validation From Manage Users";
	public static final String Admin_user_Normal_Order_Validation = "Admin user: Normal Order Validation";
	public static final String Reviewer_user_Normal_Order_Validation = "Reviewer user: Normal Order Validation";
	public static final String On_Hold_Order_Review_Submit_for_approval = "On Hold Order Review - Submit for approval";
	public static final String On_Hold_Order_Approve_Submit_for_release = "On Hold Order Approve - Submit for release";
	public static final String On_Hold_Order_Reviewer_Reject_Order = "On Hold Order Review - Reject Order";
	public static final String On_Hold_Order_Approver_Reject_Order = "On Hold Order Approve - Reject Order";
	
	//
	public static final String Create_AdminMail = "AutoAdmin_" +RandomUtilities.getRandomEmail();
	public static final String Create_ApproverMail = "AutoApprover_" +RandomUtilities.getRandomEmail();
	public static final String Create_ReviewerMail = "AutoReviewer_" +RandomUtilities.getRandomEmail();
	public static final String Create_PlacerMail = "AutoPlacer_" + RandomUtilities.getRandomEmail();


	public static final String AdminMail = "admin@mailinator.com";
	public static final String ApproverMail = "approver11@gmail.com";
	public static final String ReviewerMail = "reviewer1@gmail.com";
	public static final String PlacerMail = "placer1@gmail.com";

	// used sheet in test
	public static final String testDataSheet = SheetVariables.OMSAccountSheet;

	private static XmlTest testObject;

	private static ThreadLocal<SASLogger> Testlogs = new ThreadLocal<SASLogger>();

	@BeforeTest
	public static void initialSetUp(XmlTest test) throws Exception {
		Testlogs.set(new SASLogger("OMSAccount_setup"));
		testObject = test;
	}

	@DataProvider(name = "OMSAccount", parallel = true)
	public static Object[][] loadTestData() throws Exception {
		// concurrency maintenance on sheet reading
		getBrowserWait(testObject.getParameter("browserName"));

		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(testDataSheet);
		Testlogs.get().debug(Arrays.deepToString(data).replace("\n", "--"));
		return data;
	}

	@SuppressWarnings("unchecked") // avoid warning from linked hashmap
	@Test(dataProvider = "OMSAccount", priority=2)
	public void checkOutBaseTest(String caseId, String runTest, String desc, String proprties, String productsNumber,
			String shippingMethod, String payment, String email)
			throws Exception {

		// Important to add this for logging/reporting
		Testlogs.set(new SASLogger("OMSAccount" + getBrowserName()));
		setTestCaseReportName("OMSAccount Case");
		String CaseDescription = MessageFormat.format(LoggingMsg.CHECKOUTDESC, testDataSheet + "." + caseId,
				this.getClass().getCanonicalName(), desc, proprties.replace("\n", "<br>- "), payment, shippingMethod);
		initReportTime();

		LinkedHashMap<String, String> userdetails = (LinkedHashMap<String, String>) users.get(email);

		

		try {

			if (proprties.contains(Create_Approver_account)) {
				CreateApproverAccount.startTest(Create_ApproverMail, userdetails);
			}

			if (proprties.contains(Login_To_The_Created_Approver_account)) {
				LoginToTheCreatedApproverAccount.startTest(Create_ApproverMail);
			}
			if (proprties.contains(Create_Placer_account)) {
				CreatePlacerAccount.startTest(Create_PlacerMail, ApproverMail, ReviewerMail, userdetails);
			}

			if (proprties.contains(Login_To_The_Created_Placer_account)) {
				int productsCount = Integer.parseInt(productsNumber);
				LoginToTheCreatedPlacerAccount.startTest(shippingMethod, productsCount, Create_PlacerMail, payment);
			}
			if (proprties.contains(Create_Reviewer_account)) {
				CreateReviewerAccount.startTest(Create_ReviewerMail, userdetails);
			}

			if (proprties.contains(Login_To_The_Created_Reviewer_account)) {
				LoginToTheCreatedReviewerAccount.startTest(Create_ReviewerMail);
			}
			if (proprties.contains(Create_Admin_account)) {
				CreateAdminAccount.startTest(Create_AdminMail, userdetails);
			}

			if (proprties.contains(Login_To_The_Created_Admin_account)) {
				LoginToTheCreatedAdminAccount.startTest(Create_AdminMail);
			}
			if (proprties.contains(Order_History_Validation_From_Manage_Users)) {
				AdminUser_ManageUsers_OrderHistoryValidation.startTest(AdminMail, PlacerMail);
			}
			if (proprties.contains(Admin_user_Normal_Order_Validation)) {
				NormalOrderValidation.startTest(AdminMail);
			}
			if (proprties.contains(Reviewer_user_Normal_Order_Validation)) {
				NormalOrderValidation.startTest(ReviewerMail);
			}
			if (proprties.contains(On_Hold_Order_Review_Submit_for_approval)) {
				OnHoldOrderReview.startTest(ReviewerMail);
			}
			if (proprties.contains(On_Hold_Order_Approve_Submit_for_release)) {
				OnHoldOrderApprover.startTest(ApproverMail);
			}
			if (proprties.contains(On_Hold_Order_Reviewer_Reject_Order)) {
				OnHoldOrderReviewer_RejectOrder.startTest(PlacerMail, ReviewerMail);
			}
			if (proprties.contains(On_Hold_Order_Approver_Reject_Order)) {
				OnHoldOrderApprover_RejectOrder.startTest(PlacerMail, ReviewerMail,ApproverMail);
			}
			sassert().assertAll();

			Common.testPass(CaseDescription);
		} catch (Throwable t) {
			if ((getTestStatus() != null) && getTestStatus().equalsIgnoreCase("skip")) {
				throw new SkipException("Skipping this exception");
			} else {
				Common.testFail(t, CaseDescription, testDataSheet + "_" + caseId);
			}

		} // catch
	}// test
}
