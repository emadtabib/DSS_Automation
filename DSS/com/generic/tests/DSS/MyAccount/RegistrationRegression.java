package com.generic.tests.DSS.MyAccount;

import java.text.MessageFormat;
import java.util.Arrays;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;
import java.util.LinkedHashMap;

import com.generic.page.Registration;
import com.generic.setup.Common;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.setup.SheetVariables;
import com.generic.util.dataProviderUtils;
import com.generic.util.RandomUtilities;
import com.generic.util.SASLogger;

public class RegistrationRegression extends SelTestCase {

	// used sheet in test
	public static final String testDataSheet = SheetVariables.RegistrationSheet;

	private static XmlTest testObject;

	private static ThreadLocal<SASLogger> Testlogs = new ThreadLocal<SASLogger>();
	
	// possible scenarios
	public static final String freshUser = "fresh";
	public static final String emptyData = "empty";

	@BeforeTest
	public static void initialSetUp(XmlTest test) throws Exception {
		Testlogs.set(new SASLogger("Registration_setup"));
		testObject = test;
	}

	@DataProvider(name = "Registration", parallel = true)
	public static Object[][] loadTestData() throws Exception {
		// concurrency maintenance on sheet reading
		getBrowserWait(testObject.getParameter("browserName"));

		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(testDataSheet);
		Testlogs.get().debug(Arrays.deepToString(data).replace("\n", "--"));
		return data;
	}

	@SuppressWarnings("unchecked") // avoid warning from linked hashmap
	@Test(dataProvider = "Registration", priority=2)
	public void registrationRegressionTest(String caseId, String runTest, String desc, String proprties,
			String password, String fieldsValidation) throws Exception {

		Testlogs.set(new SASLogger("registration " + getBrowserName()));
		// Important to add this for logging/reporting
		setTestCaseReportName("Registration Case");
		String CaseDescription = MessageFormat.format(LoggingMsg.REGISTRATIONDESC, testDataSheet + "." + caseId,
				this.getClass().getCanonicalName(), desc, proprties.replace("\n", "<br>- "));
		initReportTime();

		String thankUMsg = (fieldsValidation.split("ThankyouValidation:").length > 2)
				? fieldsValidation.split("ThankyouValidation:")[0].split("\n")[0]
				: "";
		String emailValidation = (fieldsValidation.split("EmailValidation:").length > 2)
				? fieldsValidation.split("EmailValidation:")[0].split("\n")[0]
				: "";
		String firstNameValidation = (fieldsValidation.split("firstNameValidation:").length > 2)
				? fieldsValidation.split("firstNameValidation:")[0].split("\n")[0]
				: "";
		String lastNameValidation = (fieldsValidation.split("lastNameValidation:").length > 2)
				? fieldsValidation.split("lastNameValidation:")[0].split("\n")[0]
				: "";
		String passwordValidation = (fieldsValidation.split("PasswordValidation:").length > 2)
				? fieldsValidation.split("PasswordValidation:")[0].split("\n")[0]
				: "";

		// Prepare registration data
		String email = RandomUtilities.getRandomEmail();

		try {
			// Positive registration case
			if (proprties.contains(freshUser)) {

				String registrationSuccessMsg = Registration.registerFreshUser(email, password);
				sassert().assertTrue(registrationSuccessMsg.toLowerCase().contains(thankUMsg),
						"Regestration Success, validation failed Expected to have in message: " + thankUMsg
								+ " but Actual message is: " + registrationSuccessMsg);
			}

			// Negative registration case
			if (proprties.contains(emptyData)) {

				Registration.goToRegistrationForm();

				// Click save button with empty fields to trigger error messages
				Registration.clickRegisterButton();

				String validationMsg = "";

				// Validating Errors
				
				validationMsg = Registration.getFirstNameErrorInvalid();
				sassert().assertTrue(validationMsg.contains(firstNameValidation),
						"First name validation failed Expected: " + firstNameValidation + " Actual: "
								+ firstNameValidation);

				validationMsg = Registration.getLastNameErrorInvalid();
				sassert().assertTrue(validationMsg.contains(lastNameValidation),
						"Last name validation failed Expected: " + lastNameValidation + " Actual: "
								+ lastNameValidation);

				validationMsg = Registration.getEmailAddressErrorInvalid();
				sassert().assertTrue(validationMsg.contains(emailValidation),
						"Mail validation failed Expected: " + emailValidation + " Actual: " + validationMsg);

				validationMsg = Registration.getPasswordError();
				sassert().assertTrue(validationMsg.contains(passwordValidation),
						"Password validation failed Expected: " + passwordValidation + " Actual: " + validationMsg);
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
