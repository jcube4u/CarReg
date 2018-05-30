package config.webdriver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    public static final String FIREFOX = "firefox";
    public static final String CHROME = "chrome";
    public static final String INTERNET_EXPLORER = "ie";
    public static final String SAFARI = "safari";
    public static final String HTML_UNIT = "htmlunit";

    public static WebDriver getInstance(String browserName) {
        WebDriver driver = null;

        if (browserName.equals(FIREFOX)) {
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("network.proxy.type", 1);
            profile.setPreference("network.proxy.http",
                    "proxy-pac.scee.net");
            profile.setPreference("network.proxy.ssl", "proxy-pac.scee.net");
            profile.setPreference("network.proxy.http_port", 3128);
            profile.setPreference("network.proxy.ssl_port", 3128);
            driver = new FirefoxDriver();
        } else if (browserName.equals(INTERNET_EXPLORER)) {
            System.setProperty("webdriver.ie.driver","drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else if (browserName.equals(CHROME)) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver = new ChromeDriver();
        } else if (browserName.equals(SAFARI)) {
            driver = new SafariDriver();
        }else if(browserName.equals(HTML_UNIT)){
            driver = new HtmlUnitDriver(true);
        }

        return driver;
    }

}

