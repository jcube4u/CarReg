package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import support.WebDriverHelper;

public class HomePage {	
	
	//Click Start Page
	public static void clickStartPage(WebDriver driver)
	{
		WebDriverHelper.waitFor(1000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.querySelector('.gem-c-button').click();");
	}	
}

