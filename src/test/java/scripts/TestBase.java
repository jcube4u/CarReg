package scripts;

import util.PropertyLoader;
import config.webdriver.WebDriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by sinu on 28/05/2018.
 */
public class TestBase {
	private static final String SCREENSHOT_FOLDER = "target/screenshots/";
	private static final String SCREENSHOT_FORMAT = ".png";

	protected WebDriver webDriver;
	protected String websiteUrl;
	protected String browser;

	@BeforeClass
	public void init() {
		websiteUrl = PropertyLoader.loadProperty("environment.url");
		browser = PropertyLoader.loadProperty("browser.name");
		webDriver = WebDriverFactory.getInstance(browser);
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}

	@AfterMethod
	public void setScreenshot(ITestResult result) {
		if (!result.isSuccess()) {
			try {
				WebDriver returned = new Augmenter().augment(webDriver);
				if (returned != null) {
					File f = ((TakesScreenshot) returned)
							.getScreenshotAs(OutputType.FILE);
					try {
						FileUtils.copyFile(f, new File(SCREENSHOT_FOLDER
								+ result.getName() + SCREENSHOT_FORMAT));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (ScreenshotException se) {
				se.printStackTrace();
			}
		}
	}
}
