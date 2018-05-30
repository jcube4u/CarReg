package pages;

import junit.framework.Assert;
import scripts.TestBase;

import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import support.WebDriverHelper;

@Test
@SuppressWarnings("unused")
public class GetVehicleDetailsTest {
	
	protected WebDriver webDriver;
	
	//Vehicle Registration Number Entry
	private static By regNumberEntry = By.xpath("//span[@class='reg-mark']");
	//Vehicle Registration Number Entry
	private static By vehicleMake = By.cssSelector("//body.js-enabled:nth-child(2) form.form:nth-child(2) div.grid-row:nth-child(5) div.column-two-thirds ul.list-summary.margin-bottom-2 li.list-summary-item:nth-child(2) span:nth-child(2) > strong:nth-child(1)");
	//Vehicle Registration Number Entry
	private static By vehicleColour = By.cssSelector("body.js-enabled:nth-child(2) form.form:nth-child(2) div.grid-row:nth-child(5) div.column-two-thirds ul.list-summary.margin-bottom-2 li.list-summary-item:nth-child(3) span:nth-child(2) > strong:nth-child(1)");
	
	@BeforeClass
	public void testInit() {
		
		//Launch firefox browser		
		System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		WebDriverHelper.waitFor(3000);

		//Launch vehicle details page
		WebDriverHelper.navigateToURL("https://vehicleenquiry.service.gov.uk/", webDriver);
	}
	public void elementsExistsOnThePage() throws InterruptedException {
	
		//Enter Vehicle Details		
		GetVehicleDetails.enterRegNumber(webDriver, "VU12WEX");	
		WebDriverHelper.waitFor(1000);	
		
		//Click Continue
		GetVehicleDetails.clickContinue(webDriver);
	
	}
	
	

}
