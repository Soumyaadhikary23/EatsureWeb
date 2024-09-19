package com.eatsure.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.IOUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eatsure.listener.TestListenerClass;

public class TestUtils {
	/**
	 * Description:-This method allow to take screenshot 
	 * @param testCaseName
	 * @param driver
	 * @return
	 * @throws IOException
	 */

public static String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException {

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


public static String getBase64Image(String screenshotpath) {
	String base64 = null;
	try {
		InputStream is = new FileInputStream(screenshotpath);
		byte[] imageBytes = IOUtils.toByteArray(is);
		base64 = Base64.getEncoder().encodeToString(imageBytes);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return base64;

}

public static String pullScreenshotPath(WebDriver driver,String screenshotpath)  {

		String destination=null;
		if(ReadPropertyFile.get("ScreenshotsRequired").equalsIgnoreCase("yes")) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				if(screenshotpath.equals("")) {

					destination=System.getProperty("user.dir")+"\\screenshots\\" +TestListenerClass.getTestcaseName()+"\\"+ System.currentTimeMillis()+new Random().nextInt(20)+".png";
					
					FileUtils.copyFile(scrFile, new File(destination));
				}
				else {
					destination=screenshotpath+"\\screenshots\\" +TestListenerClass.getTestcaseName().replaceAll(" ","")+"\\"+ System.currentTimeMillis() +new Random().nextInt(20)+".png";
					FileUtils.copyFile(scrFile, new File(destination));
				}

			}
			catch(Exception e) {
				e.printStackTrace();

			}

		}

		return destination;

	}

}
