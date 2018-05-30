package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import support.WebDriverHelper;

public class GetVehicleDetails {

	//Vehicle Registration Number 
	private static By regNumberField = By.xpath("//input[@id='Vrm']");
	//Continue Button
	private static By continueButton=By.xpath("//button[@class='button']");
	
	//Enter Vehicle Registration number
	public static void enterRegNumber(WebDriver driver,String registartion)
	{
		WebDriverHelper.setTextInTextbox(registartion, regNumberField, driver);
	}
	
	//Click Continue
	public static void clickContinue(WebDriver driver)
	{
			WebDriverHelper.clickOnElement(continueButton, driver);
	}	
	
	
	
}
