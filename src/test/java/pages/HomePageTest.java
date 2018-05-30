package pages;

import junit.framework.Assert;

import java.util.Collections;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
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

import pages.HomePage;
import scripts.TestBase;
import support.WebDriverHelper;

@Test
@SuppressWarnings("unused")
public class HomePageTest  {
	
	protected WebDriver webDriver;
	public String websiteUrl="https://www.gov.uk/get-vehicle-information-from-dvla";
	
	@BeforeClass
	public void testInit() {

		//Launch firefox browser
		System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
		
		//WebDriver driver = new FirefoxDriver();
		WebDriverHelper.waitFor(3000);
		driver.get(websiteUrl);
		WebDriverHelper.waitFor(1000);
		//driver.get("https://vehicleenquiry.service.gov.uk/");
		HomePage.clickStartPage(webDriver);
		
		//Launch Chrome browser
		/*
		 System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
         DesiredCapabilities ChCapabilities = DesiredCapabilities.chrome();
         ChCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
         ChCapabilities.setBrowserName("chrome");
         ChCapabilities.setJavascriptEnabled(true);
         ChCapabilities.setPlatform(Platform.WINDOWS);
         ChromeOptions option = new ChromeOptions();
      //	option.addArguments("user-data-dir="+System.getenv("USERPROFILE")+"/AppData/Local/Google/Chrome/User Data/Default");
         option.addArguments("disable-extensions");
         option.addArguments("no-sandbox");
         option.addArguments("--start-maximized");
         ChCapabilities.setCapability(ChromeOptions.CAPABILITY, option);
		/*
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		WebDriver driver = new ChromeDriver(options);
		//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();*/
		
		// Load the page in the browser
		WebDriverHelper.navigateToURL(websiteUrl, webDriver);
		
		//Launch IE browser
		//System.setProperty("webdriver.ie.driver","drivers/IEDriverServer.exe");
        //WebDriver driver = new InternetExplorerDriver();
        
     // Load the page in the browser
     	//WebDriverHelper.navigateToURL(websiteUrl, webDriver);
	}

	//component should have number of elements 
	public void elementsExistsOnThePage() throws InterruptedException {
	
		/* Click Start Page */
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		HomePage.clickStartPage(webDriver);		
		WebDriverHelper.waitFor(1000);
	
		
		
	}

}
