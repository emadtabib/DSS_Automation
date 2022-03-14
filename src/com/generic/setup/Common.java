package com.generic.setup;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.SkipException;
import com.generic.setup.GlobalVariables.browsers;
import com.generic.util.ReportUtil;
import com.generic.util.dataProviderUtils;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Common extends SelTestCase {

	public static String expected = null;
	public static String actual = null;

	public static WebDriver initializeBrowser(String browser) throws Exception {
		getCurrentFunctionName(true);
		WebDriver driverInstance = null;
		try {
			logs.debug(MessageFormat.format(LoggingMsg.BROWSER_NAME, browser));
			if (browser.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().browserVersion(getChroemVersion()).setup();
				
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--ignore-certificate-errors");
				driverInstance = new ChromeDriver(co);
				driverInstance.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driverInstance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			} else if (browser.contains("mobile")) {
				/*
				 * https://cs.chromium.org/chromium/src/chrome/test/chromedriver/chrome/
				 * mobile_device_list.cc iPad Nexus 6 Nexus 5 Galaxy Note 3 Nexus 6P iPhone 8
				 * Plus iPhone 7 Plus Nexus 7 iPhone 7 Nexus 10 iPhone 8 iPhone 6 Nexus 5X
				 * Galaxy Note II iPhone 6 Plus iPhone X Galaxy S5
				 */

				String mobile = browser.split("_")[1];

				Map<String, String> mobileEmulation = new HashMap<String, String>();
				mobileEmulation.put("deviceName", mobile);
				Map<String, Object> chromeOptions = new HashMap<String, Object>();
				chromeOptions.put("mobileEmulation", mobileEmulation);

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--ignore-certificate-errors");

				if (getCONFIG().getProperty("chached_chrome").equalsIgnoreCase("yes")) {
					options.addArguments("user-data-dir=" + System.getProperty("user.home")
							+ "/AppData/Local/Google/Chrome SxS/User Data/");
					options.addArguments("detach=true");
				}

				options.setExperimentalOption("mobileEmulation", mobileEmulation);

				WebDriverManager.chromedriver().browserVersion(getChroemVersion()).setup();
				driverInstance = new ChromeDriver(options);

			} else {
				logs.debug(LoggingMsg.INVALID_BROWSER_ERROR_MSG);
				throw new Exception(LoggingMsg.INVALID_BROWSER_ERROR_MSG);
			}

		} catch (Throwable t) {
			t.printStackTrace();
			SelTestCase.setTestStatus("Fail: " + t.getMessage());
			SelTestCase.setStartTime(ReportUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"));
			ReportUtil.addError(SelTestCase.getTestStatus(), null);
			throw new Exception(t);
		}
		getCurrentFunctionName(false);
		return driverInstance;
	}

	/**
	 * Reads URL from config.properties file
	 * 
	 * @throws Exception
	 *
	 *
	 */
	public static void launchApplication(String Browser, String Env) throws Exception {
		getCurrentFunctionName(true);

		logs.debug(MessageFormat.format(LoggingMsg.TEST_ENVIRONMENT_NAME, Env));


		if (getCONFIG().getProperty("chached_chrome").equalsIgnoreCase("yes")) {
			// TODO: please enable it later with correct url in case Chrome Cached
			logs.debug(LoggingMsg.ENABLE_BLOCK_FOR_FUTURE);
			logs.debug("signing out from all users");
		}

		String url = env.get(Env);
		logs.debug("Navigating to the following brand/ env :" + url);
		SelTestCase.setURL(url);
		// launchProdWCS8StaticLinks(Env, brand);
		getDriver().get(url);

		if (!Browser.contains(browsers.iOS))
			getDriver().manage().window().maximize();

		getCurrentFunctionName(false);
	}


	/**
	 * Explicit wait
	 *
	 *
	 * @param waitTime
	 */
	public static void wait(int waitTime) {

		try {
			logs.debug(MessageFormat.format(LoggingMsg.WAIT_FOR_TIME, waitTime));
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



	/**
	 * Set test case status that will appear in the Automation Report
	 *
	 */
	public static void testPass(String CaseDescription) {
		logCaseDetailds(CaseDescription);
		logs.debug("Test Status: PASS");
		setTestStatus("Pass");

	}

	public static void testSkipped(String CaseDescription) {
		logCaseDetailds(CaseDescription);
		logs.debug("Test Status: Skipped");
		setTestStatus("Skip");
		throw new SkipException("Test Skipped");

	}

	/**
	 * Set test case status that will appear in the Automation Report
	 *
	 *
	 */
	public static void testFail(Throwable t, String CaseDescription, String screenshotName) {
		logCaseDetailds(CaseDescription + "<br><b><font color='red'>Failure Reason: </font></b>"
				+ t.getMessage().replace("\n", "").trim());
		setTestCaseDescription(getTestCaseDescription());
		logs.debug(MessageFormat.format(LoggingMsg.DEBUGGING_TEXT, t.getMessage()));
		t.printStackTrace();

		logs.debug("Test Status: Failed");
		setTestStatus("Fail: " + t.getMessage());
		logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));

		ReportUtil.takeScreenShot(getDriver(), screenshotName);
		Assert.fail(t.getMessage());
	}

	/**
	 * Set test case status that will appear in the Automation Report
	 *
	 *
	 */
	public static void testFail(Throwable t, String screenShotName) {
		logs.debug("Test Status: Failed");
		setTestStatus("Fail: " + t.getMessage());
		setScreenShotName(screenShotName + "_" + counter + ".jpg");
		ReportUtil.addError(getTestStatus(), getScreenShotName());
		logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));
	}

	public static void testFailTemp(List<Exception> t, String screenShotName) {
		String temp = "";
		for (int i = 0; i < t.size(); i++) {

			temp = temp + "Error " + i + 1 + "----" + t.get(i).getMessage();
		}
		setTestStatus("Fail: " + temp);
		setScreenShotName(screenShotName + ".jpg");
		ReportUtil.addError(getTestStatus(), getScreenShotName());
	}

	public static void refreshBrowser() {

		ActionDriver.refreshBrowser();
	}

	public static void killDriverServerIfRunning() throws Exception {
		String line;
		String pidInfo = "";
		Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
		BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		while ((line = input.readLine()) != null) {
			pidInfo += line;
		}
		input.close();
		if (getCONFIG().getProperty("browser").equalsIgnoreCase("chrome")) {
			if (pidInfo.contains("chromedriver.exe")) {
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
				logs.debug(MessageFormat.format(LoggingMsg.KILLING_PROCESS, "chromeDriver.exe"));
			} else {
				logs.debug(
						MessageFormat.format(LoggingMsg.NOT_RUNNING_PROCESS_ERROR_MSG, "chromeDriver.exe", "chrome"));
			}
		}

	}

	public static void captureScreen(String screenShotName) {
		try {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Dimension screenSize = toolkit.getScreenSize();
			Rectangle screenRect = new Rectangle(screenSize);
			Robot robot = new Robot();
			BufferedImage image = robot.createScreenCapture(screenRect);
			ImageIO.write(image, "png", new File(screenShotName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static LinkedHashMap<String, Object> readAddresses() throws Exception {

		LinkedHashMap<String, Object> addresses = new LinkedHashMap<>();
		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(SheetVariables.addresses, 1);

		// data map
		int header = 0;
		int addresscode = 0;
		int firstName = 1;
		int lastName = 2;
		int addressLine = 3;
		int city = 4;
		int state = 5;
		int postal = 6;
		int phone = 7;

		for (int row = 1; row < data.length; row++) {
			LinkedHashMap<String, Object> address = new LinkedHashMap<>();
			address.put((String) data[header][firstName], data[row][firstName]);
			address.put((String) data[header][lastName], data[row][lastName]);
			address.put((String) data[header][addressLine], data[row][addressLine]);
			address.put((String) data[header][city], data[row][city]);
			address.put((String) data[header][state], data[row][state]);
			address.put((String) data[header][postal], data[row][postal]);
			address.put((String) data[header][phone], data[row][phone]);

			addresses.put((String) data[row][addresscode], address);
		}
		logs.debug(Arrays.asList(addresses) + "");
		return addresses;
	}// readAddresses

	public static LinkedHashMap<String, Object> readPaymentcards() throws Exception {

		LinkedHashMap<String, Object> cards = new LinkedHashMap<>();
		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(SheetVariables.cards, 1);

		// data map
		int header = 0;
		int card = 0;
		int number = 1;
		int name = 2;
		int expireYear = 3;
		int expireMonth = 4;
		int CVCC = 5;
//		LinkedHashMap<String, Object> cardOb = new LinkedHashMap<>();
		for (int row = 1; row < data.length; row++) {
			LinkedHashMap<String, Object> cardOb = new LinkedHashMap<>();
			cardOb.put((String) data[header][number], data[row][number]);
			cardOb.put((String) data[header][name], data[row][name]);
			cardOb.put((String) data[header][expireYear], data[row][expireYear]);
			cardOb.put((String) data[header][expireMonth], data[row][expireMonth]);
			cardOb.put((String) data[header][CVCC], data[row][CVCC]);

			cards.put((String) data[row][card], cardOb);
		}
		return cards;
	}// read payments

	public static LinkedHashMap<String, Object> readTestparams(String testSheet, int caseIndex) throws Exception {

		LinkedHashMap<String, Object> tests = new LinkedHashMap<>();
		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(testSheet, 1);

		// data map
		int header = 0;
		for (int row = 1; row < data.length; row++) {
			LinkedHashMap<String, String> params = new LinkedHashMap<>();
			for (int col = 1; col < data[0].length; col++) {
				params.put((String) data[header][col], (String) data[row][col]);
			} // for col
			tests.put(Integer.toString(row), params);
		} // for rows
		return tests;
	}// read test param

	public static LinkedHashMap<String, Object> readUsers() throws Exception {
	
		LinkedHashMap<String, Object> users = new LinkedHashMap<>();

		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(SheetVariables.users, 1);

		// data map
		int header = 0;
		int name = 0;
		int title = 1;
		int userName = 2;
		int firstName = 3;
		int lastName = 4;
		int password = 5;
		int mail = 6;

		for (int row = 1; row < data.length; row++) {
			LinkedHashMap<String, Object> user = new LinkedHashMap<>();
			user.put((String) data[header][name], data[row][name]);
			user.put((String) data[header][title], data[row][title]);
			user.put((String) data[header][userName], data[row][userName]);
			user.put((String) data[header][firstName], data[row][firstName]);
			user.put((String) data[header][lastName], data[row][lastName]);
			user.put((String) data[header][password], data[row][password]);
			user.put((String) data[header][mail], data[row][mail]);

			users.put((String) data[row][name], user);
		}
		logs.debug(Arrays.asList(users) + "");
		return users;
	}// read users
	public static void takeScreenShot2() {
		ReportUtil.takeScreenShot(getDriver(), "common");
	}

	public static String getChroemVersion() throws IOException, InterruptedException {
		getCurrentFunctionName(true);
		
		File file = new File(getCONFIG().getProperty("chromeVersionPath"));
		
		String[] directories = file.list(new FilenameFilter() {
		  @Override
		  public boolean accept(File current, String name) {
		    return new File(current, name).isDirectory();
		  }
		});
		getCurrentFunctionName(false);
		
		logs.debug("Current chrome version is"+ directories[0]);
		return directories[0];

	}

}// class
