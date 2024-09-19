package com.eatsure.pom;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eatsure.browser.DriverManager;
import com.eatsure.constant.Constants;
import com.eatsure.reports.LogStatus;

import com.eatsure.utils.TestUtils;

import static org.testng.AssertJUnit.assertNotNull;

//import com.utils.TestUtils;

/**
 * @author vivek ranjan
 *
 */

public class BasePage {

	// public BasePage(WebDriver driver){
	// PageFactory.initElements(driver, this);
	protected BasePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
//		PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);

	}

	public static final Logger log = LogManager.getLogger(BasePage.class.getName());
	public static final int LONG_TIMEOUT = 30;
	public static final int MEDIUM_TIMEOUT = 20;
	public static final int SHORT_TIMEOUT = 10;
	public static JavascriptExecutor js;

	/**
	 * Description:-Explicitly wait for element
	 * @author vivek ranjan
	 * @param element
	 * @param driver
	 */
	private static void explicitlyWait(WebElement element, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * Description:-Explicitly wait for element
	 * @author vivek ranjan
	 * @param element
	 * @param driver
	 */
	public static void explicitlyWaitEnable(WebElement element, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * Description:- Click on element
	 * @author vivek ranjan
	 * @param element
	 * @param driver
	 */
	public static void click(WebElement element, WebDriver driver) {
		explicitlyWait(element, driver);
//		highlightElement(element);
		element.click();
//		System.out.println("Clicking is successful on Vivek"+element);
		LogStatus.pass("Clicking is successfull on " + element);
		LogStatus.pass("Clicking is successfull on ");
		// Vivek
//		log.info("Clicking is successfull on "+ element);
		// We need to enter the path of "screen shot holder" in steard of "null"
		LogStatus.pass("Screenshot below", TestUtils.pullScreenshotPath(driver, ""));

	}

	/**
	 * Description:- Click on any element with JavascriptExecotor if unable to click via simple click
	 * @author vivek ranjan
	 * @param element
	 * @param driver
	 */
	public static void clickJavaScript(WebElement element, WebDriver driver) {
		explicitlyWait(element, driver);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		LogStatus.pass("Clicking is successfull on " + element);
		LogStatus.pass("Clicking is successfull on ");
		// Vivek
//		log.info("Clicking is successfull on "+ element);
		// We need to enter the path of "screen shot holder" in steard of "null"
		LogStatus.pass("Screenshot below", TestUtils.pullScreenshotPath(driver, ""));

	}

	/**
	 * Description:-Click via BY class
	 * @author vivek ranjan
	 * @param by
	 * @param driver
	 */
	public static void click(By by, WebDriver driver) {
		click(driver.findElement(by), driver);
	}

	/**
	 * Description:-Write into "text" boxes
	 * @author vivek ranjan
	 * @param element
	 * @param text
	 * @param driver
	 */
	public static void sendkeys(WebElement element, String text, WebDriver driver) {
		explicitlyWait(element, driver);
//		highlightElement(element);
		element.sendKeys(text);
		// LogStatus.pass(text + " is entered in to the "+ element);
		log.info(text + " is entered in to the " + element);
		// LogStatus.pass(text + " is entered in to the "+ element,
		// TestUtils.pullScreenshotPath(driver,null));

	}

	/**
	 * Description:- Write into "text" boxes with By class
	 * @author vivek ranjan
	 * @param by
	 * @param text
	 * @param driver
	 */
	public static void sendkeys(By by, String text, WebDriver driver) {
		sendkeys(driver.findElement(by), text, driver);
	}

	/**
	 * Description:- Move the focus to element
	 * @author vivek ranjan
	 * @param driver
	 * @param element
	 */
	public static void moveToElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	/**
	 * Description:- Move the focus to element via By class
	 * @author vivek ranjan
	 * @param driver
	 * @param by
	 */
	public static void moveToElement(WebDriver driver, By by) {
		moveToElement(driver, driver.findElement(by));
	}

	/**
	 * Description:-Highlight the element 
	 * @author vivek ranjan
	 * @param driver
	 * @param element
	 */
	private static void highlightElement(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
	}

	/**
	 * Description:- Switch to new Window
	 * @author vivek ranjan
	 * @param driver
	 */
	public static void switchToNewWindow(WebDriver driver) {
		String parentWinHandle = driver.getWindowHandle();
		Set<String> winHandles = driver.getWindowHandles();
		for (String temp : winHandles) {
			if (!temp.equalsIgnoreCase(parentWinHandle)) {
				driver.switchTo().window(temp);
//				LogStatus.pass("Switched to new Window : " +temp);
				log.info("Switched to new Window : " + temp);

			}
		}
	}

	/**
	 * Description:- Selection of element from dropdown via their "Value"
	 * @author vivek ranjan
	 * @param element
	 * @param text
	 */

	public static void selectByValue(WebElement element, String text) {
		new Select(element).selectByValue(text);
//		LogStatus.pass("Selected dropdown " +element + "with value " +text);
		log.info("Selected dropdown " + element + "with value " + text);

	}

	/**
	 * Description:- Selection of element from dropdown via their "text"
	 * @author vivek ranjan
	 * @param element
	 * @param text
	 */
	public static void selectByVisibleText(WebElement element, String text) {
		new Select(element).selectByVisibleText(text);
//		LogStatus.pass("Selected dropdown " +element + "with text " +text);
		log.info("Selected dropdown " + element + "with text " + text);

	}

	/**
	 * Description:- Selection of element from dropdown via their "index"
	 * @author vivek ranjan
	 * @param element
	 * @param index
	 */
	public static void selectByIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
//		LogStatus.pass("Selected dropdown " +element + "with index " +index);
		log.info("Selected dropdown " + element + "with index " + index);
		
		
	}
 /*************************Description:- Below all the Methods added by Vivek Varma ****************************
	
	

	/**
	 * Description:- Hard Wait,Thread.sleep
	 * @author vivek Verma
	 * @param secs
	 */
	public static void wait(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Description:- Click on any element
	 * @author vivek Verma
	 * @param driver
	 * @param element
	 */

	public static void clickElement(WebDriver driver, WebElement element) {
		assertNotNull("Element should not be null for click", element);

		element.click();
	}

	/**
	 * Description:- Explicit wait for any element till it is Visible 
	 * Thi is similar to above method "explicitlyWait"
	 * @author vivek Verma
	 * @param driver
	 * @param element
	 * @param timeoutSecs
	 * @return
	 */
	public static WebElement waitForVisibility(WebDriver driver, WebElement element, int... timeoutSecs) {
		Integer timeout = timeoutSecs.length > 0 ? timeoutSecs[0] : MEDIUM_TIMEOUT;
		try {
			log.info("Inside waitForVisibility try");
			log.info(element);
			log.info(timeout);
			return new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			log.info("Inside waitForVisibility catch");
			return new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
		}
	}

	/**
	 * DESCRIPTION:- ???
	 * @author vivek Verma
	 * @param givenElement
	 * @return
	 */

	public static boolean isDisplayedViaCss(WebElement givenElement) {
		String[] displayValues = { "block", "flex", "inline-block" };
		try {
			if (givenElement != null) {
				System.out.println("Retrieved css display value is :" + givenElement.getCssValue("display"));
				if (givenElement.getCssValue("display").equals("none")) {
					System.out.println("Display value is none");
					return false;
				}
				for (String displayValue : displayValues) {
					System.out.println("Retrieved css display value is :" + givenElement.getCssValue("display"));
					if (givenElement.getCssValue("display").equals(displayValue)) {
						System.out.println("Element display value :" + displayValue);
						return true;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occured in isDisplayedViaCss");
			return false;
		}

		return false;
	}

	/**
	 * Description:- ???
	 * @author vivek Verma
	 * @param givenElement
	 * @return
	 */
	public static boolean isVisibleViaCss(WebElement givenElement) {
		try {
			if (givenElement != null) {
				System.out.println("Element visibilty retrieved is :" + givenElement.getCssValue("visibility"));
				if (givenElement.getCssValue("visibility").equals("hidden")) {
					System.out.println("Given element visibility is hidden");
					return false;
				} else if (givenElement.getCssValue("visibility").equals("visible")) {
					System.out.println("Given element visibility is visible");
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occured in isVisibleViaCss");
			return false;
		}
		return false;
	}

	/**
	 * Description:- To verify Element present or not
	 * @author vivek Verma
	 * @param element
	 * @return
	 */
	public static boolean isElementPresent(WebElement element) {
		if (element != null) {
			return (isDisplayedViaCss(element) || isVisibleViaCss(element));
		}
		return false;
	}

	/**
	 * Description:- To Verify Element Dispaled or not
	 * @author vivek Verma
	 * @param element
	 * @return
	 */
	public static boolean isElementDisplayed(WebElement element) {
		if (element == null)
			return false;
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException | StaleElementReferenceException | TimeoutException | NullPointerException e) {
			return false;
		}
	}
	
	/**
	 * Description:- To verify Element is Clickable or not
	 * @author vivek Verma
	 * @param element
	 * @param driver
	 * @return
	 */
		public static boolean isElementClickable(WebElement element, WebDriver driver) {
			try {
				getWebDriverWait(driver).until(ExpectedConditions.elementToBeClickable(element));
				return true;
			} catch (Exception e) {
				return false;
			}
		}

	/**
	 * Description:- WebDriber wait ?????need to discuss
	 * @author vivek Verma
	 * @param driver
	 * @return
	 */
	public static WebDriverWait getWebDriverWait(WebDriver driver) {
		return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT));
	}


	/**
	 * Description:- Move to Element and click on it
	 * @author vivek Verma
	 * @param driver
	 * @param element
	 */
	public static void moveToElementAndClick(WebDriver driver, WebElement element) {

		Actions dragger = new Actions(driver);
		dragger.moveToElement(element).click().build().perform();
	}

	/**
	 * Description:- Extract numeric value from element
	 * @author vivek Verma
	 * @param element
	 * @return
	 */
	public static String extractNumeric(WebElement element) {

		String str1 = element.getText();
		System.out.println("Text :" + str1);
		String str2 = str1.replaceAll("\\D+", "");
		System.out.print("\nextract Number is : " + str2);

		return "no numeric values present in the string";
	}

	/**
	 * @author vivek Verma
	 * @param driver
	 */
	public static void waitUntilPageLoad(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = driver1 -> (((JavascriptExecutor) driver1)
				.executeScript("return document.readyState").toString().equals("complete")
				&& ((Boolean) ((JavascriptExecutor) driver1).executeScript("return jQuery.active == 0")));
		try {
			Thread.sleep(2000);
			WebDriverWait waitForLoad = new WebDriverWait(driver, Duration.ofSeconds(MEDIUM_TIMEOUT));
			waitForLoad.until(expectation);
		} catch (Throwable error) {
			System.out.println("Timeout waiting for Page Load Request to complete");
			log.info("Timeout waiting for Page Load Request to complete");
		}
	}

	/**
	 * Description:- Scroll to the element
	 * @author vivek Verma
	 * @param driver
	 * @param element
	 * @param timeoutSeconds
	 */
	public static void scrollToElement(WebDriver driver, WebElement element, int... timeoutSeconds) {
		Integer timeout = timeoutSeconds.length > 0 ? timeoutSeconds[0] : SHORT_TIMEOUT;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);;window.scrollBy(0, -120)",
				element);
		try {
			new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
		} catch (StaleElementReferenceException ex) {
			new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
		}
	}
	
	/**
	 * Description:- Scroll up and down to load all elements on the page after implementation of Lazyloading.
	 * @author vivek ranjan
	 * @param driver
	 */
	public static void scrollbar_down(WebDriver driver) {
		//js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0, 1300)");
		//BasePage.wait(3);
		//js.executeScript("window.scrollBy(0, -1300)");
		 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        // Scroll little by little until no more content is loaded
	        long initialHeight;
	        long finalHeight = 0;
	        do {
	            initialHeight = finalHeight;
	            // Scroll down by a fixed amount
	            jsExecutor.executeScript("window.scrollBy(0, 600)");
	            try {
	                Thread.sleep(2000); // Wait for a moment to let the content load
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            // Get the updated height of the page
	            finalHeight = (long) jsExecutor.executeScript("return document.body.scrollHeight");
	        } while (finalHeight > initialHeight);
	        // Scroll back to the top of the page
	        jsExecutor.executeScript("window.scrollTo(0, 0)");
	}
	
}
