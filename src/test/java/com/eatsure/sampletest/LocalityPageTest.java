package com.eatsure.sampletest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eatsure.browser.Driver;
import com.eatsure.pom.LandingPage;
import com.eatsure.pom.LocalityPage;
import com.eatsure.utils.DataProviderUtility;

public class LocalityPageTest extends Driver{
	public WebDriver driver;
	SoftAssert as;
	Driver driver1;
//	public static Logger log =LogManager.getLogger(Base_Rahul.class.getName());
	public static Logger log =LogManager.getLogger(LocalityPageTest.class.getName());

	@Parameters("browser")


	@BeforeClass

	public void initialize(@Optional("chrome") String browser) throws IOException
	{
		System.out.println("Enter into before class of LocalityPageTest");
		driver1= new Driver();
		driver = driver1.initializeDriver(browser);
		driver.get(prop.getProperty("url"));
	}

//	@BeforeTest
//	public void initialize() throws IOException
//	{
//		driver = initializeDriver();
//		driver.get(prop.getProperty("url"));
//	}

	@Test(dataProviderClass = DataProviderUtility.class,dataProvider="getData")

	public void localityPageNavigation(String Location,String Mobilenumber,String UserName,String EmailId) throws IOException
	{
		LandingPage landing=PageFactory.initElements(driver, LandingPage.class);
		//call the method

		landing.enterLocation(Location);
		landing.selectLocation();


		  LocalityPage locality=PageFactory.initElements(driver, LocalityPage.class);
		  // locality.verifyallBrands();
		  //String localityPageTitle = driver.getTitle();
		  // System.out.println("Title of page is"+landingPageTitle);

		 as= new SoftAssert();
		 as.assertEquals(locality.verifyLocalityPagHeaderLogo(), true,"Locality page header mismatch");
		 as.assertAll();
		//ValidateTitle validate = new ValidateTitle();
		/*
		 * ValidateTitle validate=PageFactory.initElements(driver, ValidateTitle.class);
		 * validate.verifyTitle(driver, "Order Food Online in Nerul From EatSure");
		 * log.info("Successfully Locality Page title verified");
		 */


//		Assert.assertEquals(localityPageTitle, "Order Food Online in Nerul From EatSure");
//		log.info("Successfully validated Text message");







		}

//	@DataProvider
//	public Object[][] getData() {
//		//Row stands for how many different data types test should run
//		//column stands for how many values per each test
//
//		//Array size is 1 for rown and 4 for column
//
//
////		Object[][] data=new Object[2][4];
//		Object[][] data=new Object[1][4];
//		//0th row
//		data[0][0]="Nerul east";
//		data[0][1]="1111111112";
//		data[0][2]="Ishaani";
//		data[0][3]="ranjan.gvit3@gmail.com";
//
//
//		//1st row
////		data[1][0]="Nerul west";
////		data[1][1]="1111111112";
////		data[1][2]="Ishaani1";
////		data[1][3]="ranjan.gvit@gmail.com";
//		return data;
//	}

	@AfterClass
	public void teardown() {
    driver.close();
	}
//	@AfterTest
//	public void teardown() {
//		driver.close();
//	}

}
