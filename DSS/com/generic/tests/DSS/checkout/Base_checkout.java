package com.generic.tests.DSS.checkout;

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
import com.generic.tests.DSS.checkout.GuestCheckoutSingleAddress;
import com.generic.tests.DSS.checkout.RegisteredCheckoutSingleAddress;
import com.generic.util.dataProviderUtils;
import com.generic.util.SASLogger;

public class Base_checkout extends SelTestCase {

	// user types
	public static final String guestUser = "fresh user";
	public static final String registeredUser = "registered user";

	// used sheet in test
	public static final String testDataSheet = SheetVariables.checkoutSheet;

	private static XmlTest testObject;

	private static ThreadLocal<SASLogger> Testlogs = new ThreadLocal<SASLogger>();

	@BeforeTest
	public static void initialSetUp(XmlTest test) throws Exception {
		Testlogs.set(new SASLogger("checkout_setup"));
		testObject = test;
	}

	@DataProvider(name = "Orders", parallel = true)
	public static Object[][] loadTestData() throws Exception {
		// concurrency maintenance on sheet reading
		getBrowserWait(testObject.getParameter("browserName"));

		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(testDataSheet);
		Testlogs.get().debug(Arrays.deepToString(data).replace("\n", "--"));
		return data;
	}

	@SuppressWarnings("unchecked") // avoid warning from linked hashmap
	@Test(dataProvider = "Orders", priority=1)
	public void checkOutBaseTest(String caseId, String runTest, String desc, String proprties, String productsNumber,
			String shippingMethod, String payment, String shippingAddress, String billingAddress, String email)
			throws Exception {

		// Important to add this for logging/reporting
		Testlogs.set(new SASLogger("checkout_" + getBrowserName()));
		setTestCaseReportName("Checkout Case");
		String CaseDescription = MessageFormat.format(LoggingMsg.CHECKOUTDESC, testDataSheet + "." + caseId,
				this.getClass().getCanonicalName(), desc, proprties.replace("\n", "<br>- "), payment, shippingMethod);
		initReportTime();

		LinkedHashMap<String, String> addressDetails = (LinkedHashMap<String, String>) addresses.get(shippingAddress);
		LinkedHashMap<String, String> paymentDetails = (LinkedHashMap<String, String>) paymentCards.get(payment);
		LinkedHashMap<String, String> userdetails = (LinkedHashMap<String, String>) users.get(email);

		int productsCount = Integer.parseInt(productsNumber);

		try {

			if (proprties.contains("Guest Cart")) {
				Guest_CartRegression.startTest();
			}
			
			if (proprties.contains("Registered Cart")) {
				Registered_CartRegression.startTest(email);
			}
			
			// Guest user with single address
			if (proprties.contains(guestUser)) {
				GuestCheckoutSingleAddress.startTest(shippingMethod, productsCount, addressDetails, paymentDetails);
			}

			// Registered user with single addresses
			if (proprties.contains(registeredUser)) {
				RegisteredCheckoutSingleAddress.startTest(shippingMethod, productsCount, addressDetails, payment, email);
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
