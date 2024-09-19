package com.eatsure.browser;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public WebDriver driver;
	// public static WebDriver driver;

	public static Properties prop;

	public static WebDriverWait wait;

	public static final Logger log = LogManager.getLogger(Driver.class.getName());

	public WebDriver initializeDriver(String browserName) throws IOException {
		// System.out.println("Browser Name# "+browserName);
		log.info("Browser Name# " + browserName);
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				// System.getProperty("user.dir") +
				// "/src//main//java//com//eatsure//resources//data.properties");
				System.getProperty("user.dir") + "/src//test//resources//TestRunDetails.properties");

		prop.load(fis);
		// String browserName = prop.getProperty("browser");
		// System.out.println("Browser Name is " + browserName);
//		String URL = prop.getProperty("url");

		if (browserName.contains("chrome")) {
			//SeleniumManager is the replacement of WebDriverManager --Bonigarcia(WDM)
//			WebDriverManager.chromedriver().setup();
			// System.out.println("chrome driver created");
			log.info("chrome driver created");
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("IE")) {

		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();

		} else if (browserName.equalsIgnoreCase("mozilla")) {
			WebDriverManager.firefoxdriver().setup();
		}
		driver.manage().window().maximize();
//		driver.get(URL);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		return driver;

	}

}
