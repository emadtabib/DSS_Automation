package setup;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class common {
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return webDriver.get();
	}

	public static void setDriver(WebDriver driver) {
		webDriver.set(driver);
	}

	@SuppressWarnings("deprecation")
	public static WebDriver initializeBrowser(String browser) throws Exception {

		WebDriver driverInstance = null;
		try {
			System.out.println("Launch browser");
			if (browser.equalsIgnoreCase("chrome")) {

				// TODO To update the path to Dynamic path
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Imad-\\eclipse-workspace\\DSS\\DSS_Automation\\src\\test\\java\\drivers\\chromedriver.exe");
				
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--ignore-certificate-errors");
				co.addArguments("disable-infobars");
				co.addArguments("--disable-extensions");
				co.addArguments(Arrays.asList("--no-sandbox","--ignore-certificate-errors","--homepage=about:blank","--no-first-run"));
		   
				driverInstance = new ChromeDriver(co);
				driverInstance.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driverInstance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driverInstance.manage().window().maximize();

			}
		} catch (Throwable t) {
			t.printStackTrace();
			// SelTestCase.setTestStatus("Fail: " + t.getMessage());
			// SelTestCase.setStartTime(ReportUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"));
			// ReportUtil.addError(SelTestCase.getTestStatus(), null);
			throw new Exception(t);
		}

		return driverInstance;
	}

	public static void launchApplication() throws Exception {

		setDriver(initializeBrowser("chrome"));

		String url = "https://exts1.discountschoolsupply.com/";
		WebDriver driver = getDriver();
		driver.get(url);
	}

}
