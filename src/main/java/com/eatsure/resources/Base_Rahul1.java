package com.eatsure.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.browser.DriverManager;
//import com.constants.Constants;
//import com.reports.LogStatus;
//import com.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Rahul1 {

	public static WebDriver driver;

	public static Properties prop;

	public static WebDriverWait wait;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
//		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"src//main//java//data.properties");
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src//main//java//com//eatsure//resources//data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println("Browser Name is " + browserName);
//		String URL = prop.getProperty("url");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {

		} else if (browserName.equalsIgnoreCase("firefox")) {

		}
		driver.manage().window().maximize();
//		driver.get(URL);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;

	}

	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	/**
	 * Description:-This method allow to click on any element
	 * @param element
	 * @param driver
	 */

	 public synchronized void click(WebElement element, WebDriver driver) {
	        JavascriptExecutor executor = (JavascriptExecutor) driver;
	        executor.executeScript("arguments[0].click();", element);
	    }

	 /*** Description:-This method allow to scroll down
	  *
	  * @param upper
	  * @param lower
	  */
	 public static void scrollDownNumber(WebDriver driver, String upper, String lower)
	 {
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(upper, lower)", "");
	 }




	 /**
	  * Method from Utkal project
	  */

//	 private static void explicitlyWait(WebElement element) {
//			WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Constants.EXPLICITWAIT);
//			wait.until(ExpectedConditions.visibilityOf(element));
//		}
//
//
//		public static void click(WebElement element)  {
//			explicitlyWait(element);
//			highlightElement(element);
//			element.click();
//			LogStatus.pass("Clicking is successfull on "+ element);
//			LogStatus.pass("Screenshot below", TestUtils.pullScreenshotPath());
//
//		}
//
//		public static void click(By by)  {
//			click(DriverManager.getDriver().findElement(by));
//		}
//
//
//		public static void sendkeys(WebElement element, String text)  {
//			explicitlyWait(element);
//			highlightElement(element);
//			element.sendKeys(text);
//			LogStatus.pass(text + " is entered in to the "+ element);
//			LogStatus.pass(text + " is entered in to the "+ element, TestUtils.pullScreenshotPath());
//
//		}
//
//		public static void sendkeys(By by, String text)  {
//			sendkeys(DriverManager.getDriver().findElement(by), text);
//		}
//
//
//		public static void moveToElement(WebElement element) {
//			Actions actions= new Actions(DriverManager.getDriver());
//			actions.moveToElement(element).build().perform();
//		}
//
//		public static void moveToElement(By by) {
//			moveToElement(DriverManager.getDriver().findElement(by));
//		}
//
//		private static void highlightElement(WebElement element) {
//			((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
//		}
//
//
//		public static void switchToNewWindow() {
//			String parentWinHandle = DriverManager.getDriver().getWindowHandle();
//			Set<String> winHandles = DriverManager.getDriver().getWindowHandles();
//			for(String temp:winHandles) {
//				if(!temp.equalsIgnoreCase(parentWinHandle)) {
//					DriverManager.getDriver().switchTo().window(temp);
//					LogStatus.pass("Switched to new Window : " +temp);
//				}
//			}
//		}
//
//		public static void selectByValue(WebElement element,String text) {
//			new Select(element).selectByValue(text);
//			LogStatus.pass("Selected dropdown " +element + "with value " +text);
//		}
//
//		public static void selectByVisibleText(WebElement element,String text) {
//			new Select(element).selectByVisibleText(text);
//			LogStatus.pass("Selected dropdown " +element + "with text " +text);
//		}
//
//		public static void selectByIndex(WebElement element,int index) {
//			new Select(element).selectByIndex(index);
//			LogStatus.pass("Selected dropdown " +element + "with index " +index);
//		}
//
//
//	 /**
//		 * Description:This method allow to wait for elements to become clickable
//		 * @param driver
//		 * @param locatorType
//		 * @param element
//		 */
//		public static void explicitWait(WebDriver driver, String locatorType, String element)
//		{
//		 wait = new WebDriverWait(driver, 30);
//
//			try
//			{
//				switch(locatorType)
//				{
//				case "ID": wait.until(ExpectedConditions.presenceOfElementLocated(By.id(element)));
//						   break;
//
//				case "XPATH": wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
//				   			  break;
//
//				 //default: log.testLoggerInfo("Invalid Locators");
//				}
//			}
//
//			catch(Exception e)
//			{
//				e.printStackTrace();
//			}
//		}

}
