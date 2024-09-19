package com.eatsure.sampletest;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.eatsure.browser.Driver;
import com.eatsure.pom.LandingPage;
import com.eatsure.pom.LocalityPage;
import com.eatsure.pom.BrandRestaurantPage;
import com.eatsure.pom.SiginPage;
import com.eatsure.utils.DataProviderUtility;
import com.eatsure.validation.ValidateTitle;
//import com.eatsure.resources.Base_Rahul;

public class HomePageTest  {
	//public class HomePageTest extends Driver {
	public WebDriver driver;
	Driver driver1;
//	public static Logger log =LogManager.getLogger(Base_Rahul.class.getName());
	public static Logger log =LogManager.getLogger(HomePageTest.class.getName());

@Parameters("browser")


	@BeforeClass


	public void initialize(@Optional("chrome") String browser) throws IOException
	{
	System.out.println("Eneter into before class of HomePageTest");
	driver1= new Driver();
		driver = driver1.initializeDriver(browser);
		driver.get(Driver.prop.getProperty("url"));
	}

	/*
	 * @BeforeTest public void initialize() throws IOException { driver =
	 * initializeDriver(); log.info("Driver is initialized");
	 * driver.get(prop.getProperty("url")); log.info("Navigated to Landing Page"); }
	 */
	@Test(dataProviderClass = DataProviderUtility.class,dataProvider = "getData")

	public void homePageNavigation(String Location, String Mobilenumber, String UserName, String EmailId)
			throws IOException, InterruptedException {


		LandingPage landing = PageFactory.initElements(driver, LandingPage.class);
		// call the method
		//landing.verifyEatSureLogo();
		landing.enterLocation(Location);
		landing.selectLocation();
		log.info("Successfully selected the entered location");
		/*
		 * String landingPageTitle = driver.getTitle(); //
		 * System.out.println("Title of page is"+landingPageTitle);
		 * Assert.assertEquals(landingPageTitle,
		 * "Food Delivery Near Me, Order Food Online, Food Court | EatSure");
		 */
        //ValidateTitle validate = new ValidateTitle();
        //ValidateTitle validate=PageFactory.initElements(driver, ValidateTitle.class);
        ValidateTitle.verifyTitle(driver, "Order Food Online From India's Best Food Delivery Services | EatSure");
        log.info("Successfully Landing Page title verified");


		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
//		locality.navigateToBrand();
		locality.navigateToBrandCondition(driver);
		log.info("Successfully navigated to first Brand");

		BrandRestaurantPage localproductListing = PageFactory.initElements(driver, BrandRestaurantPage.class);
		localproductListing.addFirstItem(driver);

		localproductListing.clickAddItem();

		localproductListing.clickContinue(driver);
		log.info("Successfully Added first Item to Cart");

		SiginPage sigin = PageFactory.initElements(driver, SiginPage.class);
//		sigin.clickSigin();
		sigin.enterMobileNumber(Mobilenumber);
		log.info("Successfully entered the static Mobile Number");
		Thread.sleep(1000);
		sigin.clickLoginwithOTP();
//		sigin.enterUserName(UserName);
//		sigin.enterEmailAddress(EmailId);
//		sigin.clickSignmeUp();
		String otp="1907";
		List<WebElement> le=driver.findElements(By.xpath("//div[starts-with(@class,'style__OtpInputWrapper')]/div/input"));
//		for(int j=0;j<otp.length();j++) {
//			char k=otp.charAt(j);
//			System.out.println("splited OTP is"+k);
		for(int i=1,j=0;i<=le.size();i++,j++) {
			char k=otp.charAt(j);
			//otp.toCharArray(j);
			System.out.println("splited OTP is"+k);
			String s = Character.toString(k);

			driver.findElement(By.xpath("//div[starts-with(@class,'style__OtpInputWrapper')]/div/input["+i+"]")).sendKeys(s);
		}

		driver.findElement(By.xpath("//button[@role='submit']")).click();
		log.info("Successfully entered the correct OTP");
//		}
//		CommonUtility comm = new CommonUtility();
//		String otp = comm.otp_api_call("https://api-staging9.faasos.io/v1/get_otp_by_phone_number/7220022001.json");
//
//		System.out.println("OTP Is" + otp);

	}

	/*
	 * @DataProvider public Object[][] getData() { // Row stands for how many
	 * different data types test should run // column stands for how many values per
	 * each test
	 *
	 * // Array size is 1 for rown and 4 for column
	 *
	 * // Object[][] data=new Object[2][4]; Object[][] data = new Object[1][4]; //
	 * 0th row data[0][0] = "Nerul east"; data[0][1] = "7220022001"; data[0][2] =
	 * "Ishaani"; data[0][3] = "ranjan.gvit3@gmail.com";
	 *
	 * // 1st row // data[1][0]="Nerul west"; // data[1][1]="1111111112"; //
	 * data[1][2]="Ishaani1"; // data[1][3]="ranjan.gvit@gmail.com"; return data; }
	 */


//	@AfterClass
//	public void teardown() {
//    driver.close();
//	}

	/*
	 * @AfterTest public void tearDown() { driver.close(); }
	 */
}
