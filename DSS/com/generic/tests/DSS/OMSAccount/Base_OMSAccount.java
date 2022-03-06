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

	//
	public static final String AdminMail = "AutoAdmin_" +RandomUtilities.getRandomEmail();
	public static final String ApproverMail = "AutoApprover_" +RandomUtilities.getRandomEmail();
	public static final String ReviewerMail = "AutoReviewer_" +RandomUtilities.getRandomEmail();
	public static final String PlacerMail = "AutoPlacer_" + RandomUtilities.getRandomEmail();


	
//	public static final String PlacerMail = "auto_ealr3198@mailinator.com";
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
	@Test(dataProvider = "OMSAccount")
	public void checkOutBaseTest(String caseId, String runTest, String desc, String proprties, String productsNumber,
			String shippingMethod, String payment, String shippingAddress, String billingAddress, String email)
			throws Exception {

		// Important to add this for logging/reporting
		Testlogs.set(new SASLogger("OMSAccount" + getBrowserName()));
		setTestCaseReportName("OMSAccount Case");
		String CaseDescription = MessageFormat.format(LoggingMsg.CHECKOUTDESC, testDataSheet + "." + caseId,
				this.getClass().getCanonicalName(), desc, proprties.replace("\n", "<br>- "), payment, shippingMethod);
		initReportTime();

		LinkedHashMap<String, String> addressDetails = (LinkedHashMap<String, String>) addresses.get(shippingAddress);
		LinkedHashMap<String, String> paymentDetails = (LinkedHashMap<String, String>) paymentCards.get(payment);
		LinkedHashMap<String, String> userdetails = (LinkedHashMap<String, String>) users.get(email);

		int productsCount = Integer.parseInt(productsNumber);

		try {

			if (proprties.contains(Create_Approver_account)) {
				CreateApproverAccount.startTest(ApproverMail, userdetails);
			}

			if (proprties.contains(Login_To_The_Created_Approver_account)) {
				LoginToTheCreatedApproverAccount.startTest( ApproverMail);
			}
			if (proprties.contains(Create_Placer_account)) {
				CreatePlacerAccount.startTest(PlacerMail, ApproverMail, ReviewerMail, userdetails);
			}

			if (proprties.contains(Login_To_The_Created_Placer_account)) {
				LoginToTheCreatedPlacerAccount.startTest(shippingMethod, productsCount, PlacerMail, payment);
			}
			if (proprties.contains(Create_Reviewer_account)) {
				CreateReviewerAccount.startTest(ReviewerMail, userdetails);
			}

			if (proprties.contains(Login_To_The_Created_Reviewer_account)) {
				LoginToTheCreatedReviewerAccount.startTest(ReviewerMail);
			}
			if (proprties.contains(Create_Admin_account)) {
				CreateAdminAccount.startTest(AdminMail, userdetails);
			}

			if (proprties.contains(Login_To_The_Created_Admin_account)) {
				LoginToTheCreatedAdminAccount.startTest(AdminMail);
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
