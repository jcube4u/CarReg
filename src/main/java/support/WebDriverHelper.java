package support;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import java.util.Set;


public class WebDriverHelper {


    public static void clickOnContinueOnSSLCertificatePage(WebDriver driver) {
        driver.navigate().to("javascript:document.getElementById('overridelink').click()");
    }

    public static void mouseOverElement(By element,WebDriver driver) {
        Locatable hoverItem = (Locatable) element;
        Mouse mouse = ((HasInputDevices) driver).getMouse();
        mouse.mouseMove(hoverItem.getCoordinates());
        waitFor(1000);
    }

    public static void mouseHoverOver(By element,WebDriver driver) {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(element)).build().perform();
        waitFor(1000);
    }

    public static void mouseHoverOverAndClickElement(final By locator,WebDriver driver){
    	 Actions builder = new Actions(driver);
    	 WebElement element = driver.findElement(locator);
         builder.moveToElement(element).click(element).build().perform();
    }
    
    public static void mouseOverElement2(By element,WebDriver driver) {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(element)).build().perform();
        waitFor(1000);
    }
    
    public static void navigateToURL(String url,WebDriver driver) {
        driver.get(url);
    }

    public static void waitFor(long timer) {
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread sleep exception occurred...", e);
        }
    }

    public static boolean checkWindowIsDisplayed(final String windowTitle,WebDriver driver) {
        final Set<String> wh = driver.getWindowHandles();
        final Object[] windowsHandlers = wh.toArray();
        boolean windowsFound = false;
        for (int i = 0; i < wh.size(); i++) {
            driver.switchTo().window(windowsHandlers[i].toString());
            if (driver.getTitle().toLowerCase().contains(windowTitle.toLowerCase())) {
                windowsFound = true;
                break;
            }
        }
        return windowsFound;
    }

    public static void scrollToElement(final By locator,WebDriver driver){
    	try{
    		WebElement element = driver.findElement(locator);
        	int yaxis=element.getLocation().y;
        	JavascriptExecutor js = (JavascriptExecutor) driver;
        	String jString = "window.scrollTo(0, " + (yaxis-150) + " ); return true";
        	js.executeScript(jString);
    	}catch (NoSuchElementException e) {
       	 
       }
    }
    
    public static boolean isElementDisplayed(final By locator,WebDriver driver) {
        try {
        	  driver.findElement(locator).isDisplayed();
        	  return true;
        } catch (NoSuchElementException e) {
        	 return false;
        }
    }

    public static  List<WebElement> getElements(final By locator,WebDriver driver) {
        try {
            return driver.findElements(locator);
        } catch (NoSuchElementException e) {
            return new ArrayList<WebElement>();
        }
    }
    
    
    public static  boolean isElementPresent(final By locator,WebDriver driver) {
        try {
            return driver.findElement(locator).isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
        
    }
    
    public static  String getText(final By locator,WebDriver driver) {
        final WebElement element = driver.findElement(locator);
        return element.getText();
    }


    public static  void doubleClick(final By locator,WebDriver driver) {
        final WebElement element = driver.findElement(locator);
        new Actions(driver).doubleClick(element).perform();
    }

    public static void clickOnElement(final By locator,WebDriver driver) {
        driver.findElement(locator).click();
    }

    public static  void submit(final By locator,WebDriver driver) {
        driver.findElement(locator).submit();
    }

    public static  String getAttributeValue(final By locator, final String attributeName,WebDriver driver) {
        String attributeValue = "";
        try {
            final WebElement element = driver.findElement(locator);
            attributeValue = element.getAttribute(attributeName);
        } catch (final TimeoutException e) {

        } catch (final NoSuchElementException e) {
        }
        return attributeValue;
    }

    public static  int getElementCount(final By locator,WebDriver driver) {
        int elementCount = 0;
        try {
            elementCount = driver.findElements(locator).size();
        } catch (final TimeoutException e) {

        } catch (final NoSuchElementException e) {
        }
        return elementCount;
    }

    public static  boolean isCheckBoxSelected(final By locator,WebDriver driver) {
        final WebElement element = driver.findElement(locator);
        return element.isSelected();
    }

    public static  void selectValueFromDropdown(final String selectingValue, final By locator,WebDriver driver) {
        final WebElement option = driver.findElement(locator);
        final Select selectOption = new Select(option);
        selectOption.selectByVisibleText(selectingValue);
    }

    public static  List<String> getTextValuesList(final By locator,WebDriver driver) {
        List<String> valuesList = new ArrayList<String>();
        final List<WebElement> elements = driver.findElements(locator);
        for (WebElement element : elements) {
            valuesList.add(element.getText());
        }
        return valuesList;
    }

    public static  boolean checkTextIsContainedInElements(final String checkingText, final By locator,WebDriver driver) {
        boolean isTextContained = false;
        final List<WebElement> optionsList = driver.findElements(locator);
        for (final WebElement option : optionsList) {
            if (!StringUtils.containsIgnoreCase(option.getText(), checkingText)) {
                isTextContained = false;
                break;
            }
            isTextContained = true;
        }
        return isTextContained;
    }

    public static  void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static  void goBack(WebDriver driver) {
        driver.navigate().back();
    }

    public static  void sendKeyboardKey(final Keys key, final By locator,WebDriver driver) {
        driver.findElement(locator).sendKeys(key);
    }

    public static  void setTextInTextbox(final String text, final By locator,WebDriver driver) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public static  void switchToWindow(WebDriver driver) {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public static  void switchToWindow(String windowTitle,WebDriver driver) {
        final Set<String> wh = driver.getWindowHandles();
        final Object[] windowsHandlers = wh.toArray();
        for (int i = 0; i < wh.size(); i++) {
            driver.switchTo().window(windowsHandlers[i].toString());
            if (driver.getTitle().toLowerCase().contains(windowTitle.toLowerCase())) {
                break;
            }
        }
    }

    public static  String getCurrentPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public static  void javaScriptExecute(String javaScriptString,WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(javaScriptString);
    }

    public static  int getImageHeight(final By locator,WebDriver driver) {
        int attributeValue = 0;
        try {
            final WebElement element = driver.findElement(locator);
            attributeValue = element.getSize().getHeight();
        } catch (final TimeoutException e) {

        } catch (final NoSuchElementException e) {
        }
        return attributeValue;

    }

    //Check if Image is display. Best to check using natural width of image
/*
    public static  boolean isImageVisible(final By locator,WebDriver driver) {
        Boolean result = null;
        System.out.println("Test1");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        result = (boolean) js.executeScript("return arguments[0].complete && type of arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", locator);
        System.out.println("Test2");
        return result.booleanValue();
    }*/

    public static  Boolean waitForElementToDisplay(final By element, final int waitTime,WebDriver driver) {
        try {
            return new WebDriverWait(driver, waitTime)
                    .until(new ExpectedCondition<Boolean>() {

                        //@Override
                        public Boolean apply(final WebDriver driver) {
                            return driver.findElement(element).isDisplayed();
                        }
                    });
        } catch (Exception e) {
            return false;
        }
    }

    public static  boolean checkNewWindowOpened(final String windowTitle,WebDriver driver) {
        final Set<String> wh = driver.getWindowHandles();
        final Object[] windowsHandlers = wh.toArray();
        boolean windowsFound = false;
        String mainWindowHandle = driver.getWindowHandles().iterator().next();
        for (int i = 0; i < wh.size(); i++) {
            driver.switchTo().window(windowsHandlers[i].toString());
            if (driver.getTitle().toLowerCase().contains(windowTitle.toLowerCase())) {
                windowsFound = true;
                break;
            }
        }
        driver.switchTo().window(mainWindowHandle);
        return windowsFound;
    }

    public static  String getWindowUrl(final String windowTitle,WebDriver driver) {
        final Set<String> wh = driver.getWindowHandles();
        final Object[] windowsHandlers = wh.toArray();
        String windowUrl = "";
        String mainWindowHandle = driver.getWindowHandles().iterator().next();

        for (int i = 0; i < wh.size(); i++) {
            driver.switchTo().window(windowsHandlers[i].toString());
            if (driver.getTitle().toLowerCase().contains(windowTitle.toLowerCase())) {
                windowUrl = driver.getCurrentUrl();
                break;
            }
        }
        driver.switchTo().window(mainWindowHandle);
        return windowUrl;
    }

    public static  void closeWindow(final String windowTitle,WebDriver driver) {
        final Set<String> wh = driver.getWindowHandles();
        final Object[] windowsHandlers = wh.toArray();
        String mainWindowHandle = driver.getWindowHandles().iterator().next();

        for (int i = 0; i < wh.size(); i++) {
            driver.switchTo().window(windowsHandlers[i].toString());
            if (driver.getTitle().toLowerCase().contains(windowTitle.toLowerCase())) {
                driver.close();
                break;
            }
        }
        driver.switchTo().window(mainWindowHandle);
    }

    public static  String getCurrentWindowTitle(WebDriver driver) {
        final Set<String> wh = driver.getWindowHandles();
        final Object[] windowsHandlers = wh.toArray();
        String mainWindowHandle = driver.getWindowHandles().iterator().next();
        String windowTitle = "";

        for (int i = 0; i < wh.size(); ) {
            driver.switchTo().window(windowsHandlers[i].toString());
            windowTitle = driver.getTitle().toLowerCase();
            break;
        }
        driver.switchTo().window(mainWindowHandle);
        return windowTitle;
    }

    public static  int getNumberOfWindows(WebDriver driver) {
        final Set<String> wh = driver.getWindowHandles();
        return wh.size();
    }
    
    public static String getElementCSSValue(final By locator,String cssAttributeName, WebDriver driver){
    	return driver.findElement(locator).getCssValue(cssAttributeName);
    }
    
    public static void switchToWindowTab(WebDriver driver){
    	List<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    	driver.switchTo().window(tabs.get(1));
    	driver.close();
    	driver.switchTo().window(tabs.get(0));
    	
    }

}
