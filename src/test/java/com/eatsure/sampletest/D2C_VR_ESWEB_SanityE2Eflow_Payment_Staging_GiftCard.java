package com.eatsure.sampletest;

import com.eatsure.browser.Driver;
import com.eatsure.pom.*;
import com.eatsure.reports.ExtentReport;
import com.eatsure.utils.ReadPropertyFile;
import com.eatsure.validation.ValidateTitle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class D2C_VR_ESWEB_SanityE2Eflow_Payment_Staging_GiftCard {

	public static final Logger log = LogManager.getLogger(D2C_VR_ESWEB_SanityE2Eflow_Payment_Staging_GiftCard.class.getName());
	public WebDriver driver;
	Driver driver1;
	SoftAssert as;

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
	public void selectionOfLocation() {
		ExtentReport.createTest("selectionOfLocation");
		LandingPage landing = PageFactory.initElements(driver, LandingPage.class);
		landing.enterLocation(ReadPropertyFile.get("location"));
		landing.selectLocation();
		log.info("Successfully selected the entered location");
		ValidateTitle.verifyTitle(driver, "Order Food Online From India's Best Food Delivery Services | EatSure");
		log.info("Successfully Landing Page title verified");
	}

	@Test(enabled = true, priority = 1, description = "verifyLocalityPageContent")
	public void verifyLocalityPageContent() {
		ExtentReport.createTest("verifyLocalityPageContent");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);

		as = new SoftAssert();
		as.assertEquals(locality.verifylLocalityPageOneSingleOrder(), true,
				"Locality page header mismatch");
		as.assertEquals(locality.verifyLocalityPagHeaderLogo(), true,
				"Locality page header EatsureLogo mismatch");
		as.assertEquals(locality.verifyLocalityPageEatSurance(), true,
				"Locality page \"EatSurance\" mismatch");
		as.assertEquals(locality.verifylLocalityPagePopularCuisinesHeadar(driver), true,
				"Locality page Popular Cuisines headar in your area mismatch");
		as.assertEquals(locality.verifylLocalityPagePopularCuisinesContent(), true,
				"Locality page Popular Cuisines content in your area mismatch");
		as.assertEquals(locality.verifylLocalityPageFreeDish(driver), true,
				"Locality page FreeDish mismatch");
		as.assertEquals(locality.verifylLocalityPageMostLovedCollections(driver), true,
				"Locality page Most Loved Collection mismatch");
		as.assertEquals(locality.verifylLocalityPageRewardPoint(driver), true,
				"Locality page Get Rewarded for eating good mismatch");
		as.assertEquals(locality.verifylLocalityPageCombosFromMutipleRestaurants(driver),
				true, "Locality page Combos from Multiple Restaurants mismatch");
		as.assertAll();

		log.info("Successfully validated Locality Page Content");
	}

	@Test(enabled = true, priority = 2, description = "verifyAddDynamicComboItemToCartFromHomePage")
	public void verifyAddDynamicComboItemToCartFromHomePage() {
		ExtentReport.createTest("verifyAddDynamicComboItemToCartFromHomePage");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		// Add dynamic product to Cart from Home/Locality Page
		locality.addDynemiComboOftwoProduct(driver);
		String LocalityPageProductName = locality.getProductNameText();
		log.info("#LocalityPageProductName  #" + LocalityPageProductName);
		// Click on "CART" option
		locality.clickCartOption(driver);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		String CartPageProductName = cart.getProductNameText();
		log.info("#CartPageProductName  #" + CartPageProductName);
		as.assertEquals(CartPageProductName, LocalityPageProductName);
		as.assertAll();
		log.info("Successfully Added DynamicComboItem To Cart From HomePage");
	}

	@Test(enabled = true, priority = 3, description = "selectionOfRestaurant")
	public void selectionOfRestaurant() {
		ExtentReport.createTest("selectionOfRestaurant");
		as = new SoftAssert();
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.navigateToBrandCondition(driver);
		log.info("Successfully navigated to first Brand");
	}

	@Test(enabled = true, priority = 4, description = "selectionOfNormalProductwithCustomizationFromRestaurantPage")
	public void selectionOfNormalProductwithCustomizationFromRestaurantPage() {
		ExtentReport.createTest("selectionOfNormalProductwithCustomizationFromRestaurantPage");
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		brand.addFirstItem(driver);
		brand.clickAddItem();
		brand.clickContinue(driver);
		log.info("Successfully Added Normal Product with Customization from RestaurantPage to Cart");
	}

	@Test(enabled = true, priority = 5, description = "loginfromCartpage")
	public void loginfromCartPage() throws InterruptedException {
		ExtentReport.createTest("loginfromCartpage");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.enterMobileNumber(ReadPropertyFile.get("MobilenumberFixedOTP"));
		Thread.sleep(1000);
		cart.clickLoginwithOTP();
		cart.enterOTP(driver, ReadPropertyFile.get("otp"));
		cart.clickVerifyOTP();
		log.info("Successfully enter the mobile no and OTP on cart page");

	}

	@Test(enabled = true, priority = 6, description = "addAddressfromCartPage")
	public void addAddressfromCartPage() throws InterruptedException {
		ExtentReport.createTest("addAddressfromCartPage");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickAddressRadioButton(driver);
		log.info("Successfully Deleted the old address and added the new address on cart page");
	}

	@Test(enabled = true, priority = 7, description = "visibilityOfPaymentPage")
	public void visibilityOfPaymentPage() throws Exception {
		ExtentReport.createTest("visibilityOfPaymentPage");
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		payments.verifyPaymentPageIsDisplayed(driver);
		log.info("Payments page is displayed");
	}

	@Test(enabled = true, priority = 8, description = "selectionOfPaymentMode")
	public void selectionOfPaymentMode() {
		ExtentReport.createTest("selectionOfPaymentMode");
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		payments.verifyChoosePaymentText(driver);
		payments.clickGCButton(driver);
		payments.verifyGCCard(driver);
		payments.verifyAmount();
		log.info("Selected Gift card pay mode");
	}

	@Test(enabled = true, priority = 9, description = "proceedToPay")
	public void proceedToPay() {
		ExtentReport.createTest("proceedToPay");
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		payments.clickPayButton(driver);
		log.info("Used Gift card mode to place an order");
	}

	@Test(enabled = true, priority = 10, description = "trackingOrderPage")
	public void trackingOrderPage() throws Exception {
		ExtentReport.createTest("trackingOrderPage");
		TrackingOrderPage tracking = PageFactory.initElements(driver, TrackingOrderPage.class);
		Thread.sleep(1000);
		tracking.verifyTrackingOrderPage(driver);
		tracking.verifyViewOrderLink(driver);
		log.info("Verified Tracking order Page");
	}

	@AfterSuite
	public void afterSuite() {
		ExtentReport.extent.flush();
	}

}
