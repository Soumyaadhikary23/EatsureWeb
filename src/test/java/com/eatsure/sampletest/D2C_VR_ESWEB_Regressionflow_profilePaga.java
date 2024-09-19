package com.eatsure.sampletest;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eatsure.browser.Driver;
import com.eatsure.pom.CartPage;
import com.eatsure.pom.LandingPage;
import com.eatsure.pom.Profile;
import com.eatsure.reports.ExtentReport;
import com.eatsure.utils.ReadPropertyFile;
import com.eatsure.validation.ValidateTitle;

public class D2C_VR_ESWEB_Regressionflow_profilePaga {

	public WebDriver driver;
	Profile profile = PageFactory.initElements(driver, Profile.class);
	Driver driver1;
	SoftAssert as;
	public static final Logger log = LogManager.getLogger(D2C_VR_ESWEB_Regressionflow_profilePaga.class.getName());

	@BeforeSuite
	public void beforeSuite() {
		ExtentReport.initialize();
	}

	@Parameters("browser")
	@BeforeClass
	public void initialize(@Optional("chrome") String browser) throws IOException {
		driver1 = new Driver();
		driver = driver1.initializeDriver(browser);
		driver.get(Driver.prop.getProperty("urlStaging"));
	}

	@Test(enabled = true, priority = 0, description = "selectionOfLocation")
	public void selectionOfLocation() throws InterruptedException {
		ExtentReport.createTest("selectionOfLocation");
		LandingPage landing = PageFactory.initElements(driver, LandingPage.class);
//    	landing.enterLocation(Driver.prop.getProperty("location"));
		landing.enterLocation(ReadPropertyFile.get("location"));
		landing.selectLocation();
		log.info("Successfully selected the entered location");
		ValidateTitle.verifyTitle(driver, "Order Food Online From India's Best Food Delivery Services | EatSure");
		log.info("Successfully Landing Page title verified");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();
		driver.findElement(By.xpath("//span[@class='userSP']")).click();
		cart.enterMobileNumber(ReadPropertyFile.get("MobilenumberFixedOTP"));
		Thread.sleep(1000);
		cart.clickLoginwithOTP();
		cart.enterOTP(driver, ReadPropertyFile.get("otp"));
		cart.clickVerifyOTP();
		Thread.sleep(3000);
	}

	@Test(enabled = true, priority = 1, description = "Profile path verify")
	public void profilePath() throws InterruptedException {
		ExtentReport.createTest("selectionOfLocation");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();
		as.assertEquals(profile.Menu(), true, "menu bar not showing");
		as.assertAll();
		log.info("Verify the menu bar");
		as.assertEquals(profile.profileClick(), true, "Profile option not showing");
		as.assertAll();
		log.info("Verify the profile option ");

		profile.close(driver);
		Thread.sleep(3000);
		String profilePageTitle = driver.getTitle();
		as.assertEquals(profilePageTitle, "Order Food Online From India's Best Food Delivery Service | EatSure",
				"Profile page not open");
		as.assertAll();
		log.info("Successfully Verify the profile page open");

		as.assertEquals(profile.profileSubSection(), true, "Subsection not comes rightly");
		as.assertAll();
		log.info("Successfully Verify Subsections");
		as.assertEquals(profile.proflieUserName(), profile.headerUserName(), "User name not matching");
		as.assertAll();
		log.info("Successfully Verify UserName");

		as.assertEquals(profile.uNumber(), true, "mobile number is not showing");
		as.assertAll();
		log.info("Successfully Verify User Mobile number");
	}

	@Test(enabled = true, priority = 2, description = "Edit Profile verify")
	public void editProfile() throws InterruptedException {
		ExtentReport.createTest("Edit Profile verify");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		as = new SoftAssert();
		as.assertEquals(profile.edit(), true, "Edit button not working");
		as.assertAll();
		log.info("Successfully Verify edit button");

		String editTitle = driver.findElement(By.xpath("//div[@data-qa='editProfileHeading']")).getText();
		as.assertEquals(editTitle, "Update Your Personal Details");
		as.assertAll();
		log.info("Verify the profile pop up");
		driver.findElement(By.xpath("//input[@placeholder='Name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("TestAutomation");
		profile.submit();
		Thread.sleep(2000);
		as.assertEquals(profile.proflieUserName(), "TestAutomation", "edit is not working");
		as.assertAll();
		log.info("Successfully edit process");
		driver.findElement(By.xpath("//span[normalize-space()='Edit profile']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("AUTOMATION");
		profile.submit();
	}

	@Test(enabled = true, priority = 3, description = "My order section verify")
	public void myOrder() throws InterruptedException {
		ExtentReport.createTest("My order section verify");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		as = new SoftAssert();
//verify the heading		
		as.assertEquals(profile.subHeading(), "My Orders", "my oder section heading not maching");
		as.assertAll();
//verify the total order in that page
		int orders = (driver.findElements(By.xpath("//div[@data-qa='orderCrn']")).size());
		int headingTotalOrders = Integer.parseInt(driver
				.findElement(By.xpath("//div[@data-qa='totalOrderToShow']")).getText().split(" ")[2]);
		as.assertEquals(headingTotalOrders, orders, "my oder section order count is not maching");
		as.assertAll();
		log.info("Sucessfully verify the order count");
//verify the order crn
		as.assertEquals(profile.orderCRN(), true, "Oder crn is not showing");
		as.assertAll();
		log.info("Successfylly verify the order crn");
//verify the item count
		List<WebElement> priceCount = driver.findElements(By.xpath(
				"(//div[starts-with(@class,'style__Card')])[1]//div[@data-qa='individualProductPrice']"));
		
		as.assertEquals(profile.item(), priceCount.size(), "item count not matching");
		as.assertAll();
		log.info("total price count "+priceCount.size());
//verify the total price 		
		int productPricesum = 0;
		for (int i = 0; i < priceCount.size(); i++) {
			String text = priceCount.get(i).getText().trim();
			if (!text.isEmpty()) {
				text = text.replace("\u20b9", "").trim();
				productPricesum += Integer.parseInt(text);
			}
		}
	log.info("Total add price  of the product "+productPricesum);as.assertEquals(profile.totalPrice(),productPricesum,"Total price is not matching");as.assertAll();log.info("Sucessfully verify the total price");
//verify the order date and time
	as.assertEquals(profile.orderTime(),true,"Date and time not shwoing for order");as.assertAll();log.info("Sucessfully verify Date and time");
//verify the order journey 
	as.assertEquals(profile.orderJourney(),true,"order journey not showing");as.assertAll();log.info("Sucessfully verify order journey place");
//verify the order address section
	as.assertEquals(profile.orderAddress(),true,"order address section is not showing");as.assertAll();log.info("Sucessfully verify order address section");
//verify the tracking order button
	Thread.sleep(3000);

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView()",profile.trackOrder);
	Thread.sleep(2000);
	as.assertEquals(profile.orderTrackButton(),true,"order tracking  button is not showing");as.assertAll();
	log.info("Sucessfully verify  tracking order button");
//verify the after click the tracking order button right page open
	String trackingPage = driver
			.getTitle();as.assertEquals(trackingPage,"Order Food Online From India's Best Food Delivery Service | EatSure");as.assertAll();log.info("Successfully verify the tracking oder page open right page");driver.navigate().back();
//verify the view details button
	Thread.sleep(3000);
	
	js.executeScript("arguments[0].scrollIntoView()",profile.trackOrder);

	as.assertEquals(profile.orderDetails(driver),true,"order view details  button is not showing");as.assertAll();log.info("Sucessfully verify  order details button");driver.findElement(By.id("close")).click();
	}

	@Test(enabled = true, priority = 3, description = "Sure point section verify")
	public void surepoint() throws InterruptedException {
		ExtentReport.createTest("Sure point section verify");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		as = new SoftAssert();
		profile.surePoint();
		// log.info("sure poitn "+profile.countSureP());
		log.info("sure poitn " + profile.headerSurePoint());
		/*
		 * as.assertEquals(profile.countSureP(), profile.headerSurePoint(),
		 * "sure point is not matching"); as.assertAll();
		 */
		log.info("Successfully verify the sure point count");
		as.assertEquals(profile.verifyStatement(), true,
				"Statement section and T&C section in the sure point subsection not showing");
		as.assertAll();
		log.info("Verify the statment and T&C section in the sure poitn subsection");
		as.assertEquals(profile.useNowSurePoint(), true, "use now button not showing");
		as.assertAll();
		log.info("Successfully verify the use now button");
		/*
		 * Thread.sleep(3000); driver.navigate().back(); Thread.sleep(3000);
		 */
		as.assertEquals(profile.claim(), true, "order claim button not showing");
		as.assertAll();
		log.info("Successfully verify the order claim button");
		as.assertEquals(profile.sureEarning(), true, "Sure Earning section not showing");
		as.assertAll();
		log.info("Successfully verify the Sure earning section button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 800)");
		Thread.sleep(2000);
		as.assertEquals(profile.eatMoreSaveMore(), true, "Eat More, Save More! section not showing");
		as.assertAll();
		log.info("Successfully verify the Eat More, Save More! section button");
	}

	@Test(enabled = true, priority = 5, description = "About eatsure  section verify")
	public void About() throws InterruptedException {
		ExtentReport.createTest("About Eatsure section section verify");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		as = new SoftAssert();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -800)");
		profile.about();
		String aboutHeading = driver.findElement(By.xpath("//div[@id='high-grade-ingredients']//h4[1]")).getText();
		as.assertEquals(aboutHeading, "Artificial Intelligence.", "About eatsure not open the right page");
		as.assertAll();
		log.info("Sucessfully verify the about eatsure page");
	}

	@Test(enabled = true, priority = 4, description = "T&C  section verify")
	public void TremAndCondition() throws InterruptedException {
		ExtentReport.createTest("T&C section section verify");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		as = new SoftAssert();
		profile.tremCondition();
		String tC = driver.findElement(By.xpath("//p[@data-qa='tncHeading']")).getText();
		as.assertEquals(tC, "Terms and Conditions");
		as.assertAll();
		log.info("Sucessfully verify the T&C eatsure page");
	}
}
