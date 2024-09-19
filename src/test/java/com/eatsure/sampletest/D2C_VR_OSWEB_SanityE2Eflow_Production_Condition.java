package com.eatsure.sampletest;

import java.io.IOException;
import java.util.List;

import com.eatsure.pom.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.eatsure.browser.Driver;
import com.eatsure.pom.LandingPage;
import com.eatsure.pom.LocalityPage;
import com.eatsure.pom.ProductDetailPage;
import com.eatsure.pom.ProductListingPage;
import com.eatsure.pom.SiginPage;
import com.eatsure.pom.BasePage;
import com.eatsure.pom.BrandRestaurantPage;
import com.eatsure.pom.CartPage;
import com.eatsure.reports.ExtentReport;
import com.eatsure.utils.CommonUtility;
import com.eatsure.utils.ReadPropertyFile;
import com.eatsure.validation.ValidateTitle;

public class D2C_VR_OSWEB_SanityE2Eflow_Production_Condition {

	public WebDriver driver;
	Driver driver1;
	SoftAssert as;
	public static final Logger log = LogManager.getLogger(D2C_VR_OSWEB_SanityE2Eflow_Production_Condition.class.getName());

	@BeforeSuite
	public void beforeSuite() {
		ExtentReport.initialize();
	}

	@Parameters("browser")
	@BeforeClass
	public void initialize(@Optional("chrome") String browser) throws IOException {
		driver1 = new Driver();
		driver = driver1.initializeDriver(browser);
		driver.get(Driver.prop.getProperty("urlProductionOS"));
	}

	@Test(enabled = true, priority = 0, description = "selectionOfLocation")
	public void selectionOfLocation() {
		ExtentReport.createTest("selectionOfLocation");
		LandingPage landing = PageFactory.initElements(driver, LandingPage.class);
//    	landing.enterLocation(Driver.prop.getProperty("location"));
		landing.enterLocation(ReadPropertyFile.get("productionLocation"));
		landing.selectLocation();
		log.info("Successfully selected the entered location");
//		ValidateTitle.verifyTitle(driver, "Order Pizzas Online from Oven Story Pizza");
		ValidateTitle.verifyTitle(driver, "Order Pizza Near Me | Oven Story Pizza");
		log.info("Successfully Landing Page title verified");
	}	
	
	@Test(enabled = true, priority = 1, description = "selectionOfNormalProductwithCustomizationFromLocalityPage")
	public void selectionOfNormalProductwithCustomizationFromRestaurantPage() {
		ExtentReport.createTest("selectionOfNormalProductwithCustomizationFromLocalityPage");
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		brand.addNormalProductcondition(driver,brand.addButton);
		brand.clickContinue(driver);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		log.info("Successfully Added Normal Product with Customization from LocalityPage to Cart");
	}

	@Test(enabled = true, priority = 2, description = "selectionOfNormalProductwithCustomizationFromRestaurantPage")
	public void selectionOfDynamicProductwithCustomizationFromRestaurantPage() {
		ExtentReport.createTest("selectionOfNormalProductwithCustomizationFromRestaurantPage");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.clickSeeAllButton(driver);
		
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
//		brand.addDynemiComboOfTwoProductcondition(driver);
		brand.addNormalProductcondition(driver,brand.addButton);
		brand.clickContinue(driver);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		log.info("Successfully Added Normal Product without Customization From RestaurantPage to Cart");
	}

	@Test(enabled = true, priority = 3, description = "selectionOfNormalProductwithCustomizationFromPDP")
	public void selectionOfNormalProductwithCustomizationFromPDP() {
		ExtentReport.createTest("selectionOfNormalProductwithCustomizationFromPDP");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.clickSeeAllButton(driver);
		
		as = new SoftAssert();
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		String BrandRestaurantPageProductName = brand.getProductNameText().trim();
		log.info("ProductName under BrandPage  #" + BrandRestaurantPageProductName);
		String BrandRestaurantPageProductPrice = brand.getProductPriceText();
		log.info("#ProductPrice under BrandPage  #" + BrandRestaurantPageProductPrice);

		brand.clickProducNameLink(driver);
        // ProductDetailPage details
		ProductDetailPage pdp = PageFactory.initElements(driver, ProductDetailPage.class);
		String ProductDetailPageProductName = pdp.getProductNameText();
		log.info("#ProductName under PDPage  #" + ProductDetailPageProductName);
		String ProductDetailPageProductPrice = pdp.getProductPriceText();
		log.info("#ProductPrice under PDPage  #" + ProductDetailPageProductPrice);

		// Validation
		as.assertEquals(BrandRestaurantPageProductName, ProductDetailPageProductName);
		as.assertEquals(BrandRestaurantPageProductPrice, ProductDetailPageProductPrice);
		as.assertAll();

		brand.addNormalProductcondition(driver,pdp.addButton);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		log.info("Successfully Added Noramal Product without Customization to Cart from PDP and Validated the productname and price");
	}

	@Test(enabled = false, priority = 4, description = "selectionOfDynamicProductwithCustomizationFromPDP")
	public void selectionOfDynamicProductwithCustomizationFromPDP() {
		ExtentReport.createTest("selectionOfDynamicProductwithCustomizationFromPDP");
		as = new SoftAssert();

		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		// BrandRestaurantPage details
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		String BrandRestaurantPageDynamicProductName = brand.getDynemicProductNameText();
		log.info("DynamicProductName under BrandPage #" + BrandRestaurantPageDynamicProductName);
		String BrandRestaurantPageDynamicProductPrice = brand.getDynamicProductPriceText();
		log.info("DynamicProductPrice under BrandPage #" + BrandRestaurantPageDynamicProductPrice);

		brand.clickDynamicProducNameLink(driver);

		// ProductDetailPage details
		ProductDetailPage pdp = PageFactory.initElements(driver, ProductDetailPage.class);
		String ProductDetailPageProductName = pdp.getProductNameText();
		log.info("DynamicProductName under PDPage #" + ProductDetailPageProductName);
		String ProductDetailPageDynamicProductPrice = pdp.getDynamicProductPriceText();
		log.info("DynamicProductPrice under PDPage #" + ProductDetailPageDynamicProductPrice);

		// Validation
		as.assertEquals(BrandRestaurantPageDynamicProductName, ProductDetailPageProductName);
		as.assertEquals(BrandRestaurantPageDynamicProductPrice, ProductDetailPageDynamicProductPrice);
		as.assertAll();

		// Commented as part of production domain as we need to create the script to add
		// four/three product with custemization
		brand.addDynemiComboOfTwoProductcondition(driver);
		locality.clickCartOption(driver);
		
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		log.info("Successfully Added Dynamic Product without Customization to Cart from PDP and Validated the productname and price");
	}

	@Test(enabled = true, priority = 5, description = "loginfromCartpage")
	public void loginfromCartPage() throws InterruptedException {
		ExtentReport.createTest("loginfromCartpage");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.clickCartOption(driver);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.enterMobileNumber(ReadPropertyFile.get("MobilenumberFixedOTP"));
		Thread.sleep(1000);
		cart.clickLoginwithOTP();
		cart.enterOTP(driver, ReadPropertyFile.get("otp"));
		//We need to comment the below line of code as part of BX-14742 [ES-WEB][FE] Auto OTP Verify upon putting OTP
//		cart.clickVerifyOTP();

//		cart.enterMobileNumber(ReadPropertyFile.get("Mobilenumber"));
//		Thread.sleep(1000);
//		cart.clickLoginwithOTP();
//		CommonUtility comm = new CommonUtility();
//		String otp = comm.otp_api_call("https://api-staging25.faasos.io/v1/get_otp_by_phone_number/1111111112.json");
//		System.out.println("OTP Is" + otp);
//		cart.enterOTP(driver, otp);
//		cart.clickVerifyOTP();

		log.info("Successfully enter the mobile no and OTP on cart page");

	}

	@Test(enabled = true, priority = 6, description = "addAddressfromCartPage")
	public void addAddressfromCartPage() throws InterruptedException {
		ExtentReport.createTest("addAddressfromCartPage");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickAddressRadioButton(driver);

		cart.deleteexistingAddress(driver);

		cart.addnewAddress(driver);

		log.info("Successfully Deleted the old address and added the new address on cart page");

	}

	@Test(enabled = true, priority = 7, description = "addExtraInstructionfromCartPage")
	public void addExtraInstructionfromCartPage() throws InterruptedException {
		ExtentReport.createTest("addExtraInstructionfromCartPage");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.addextraInstruction(driver);

		log.info("Successfully added extra instruction on cart page");

	}

	@Test(enabled = false, priority = 8, description = "selectFreeDishfromCartPage")
	// this method is already false-16-11-2022
	public void selectFreeDishfromCartPage() throws InterruptedException {
		ExtentReport.createTest("selectFreeDishfromCartPage");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickSelectFreeDishjs(driver);
		cart.clickCheckoutNowFreeDishjs(driver);

		log.info("Successfully added Free Dish from cart page");

	}

	@Test(enabled = true, priority = 9, description = "visibilityOfPaymentPage")
	public void visibilityOfPaymentPage() throws Exception {
		ExtentReport.createTest("visibilityOfPaymentPage");
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		payments.verifyPaymentPageIsDisplayed(driver);
		log.info("Payments page is displayed");
	}

	@Test(enabled = true, priority = 10, description = "selectionOfPaymentMode")
	public void selectionOfPaymentMode() {
		ExtentReport.createTest("selectionOfPaymentMode");
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		payments.verifyChoosePaymentText(driver);
//		payments.clickCODButtonPROD(driver);
		payments.clickCODButtonforBBPROD(driver);
//		payments.verifyCODCard();
		payments.verifyAmount();
		log.info("Selected COD pay mode");
	}

	@Test(enabled = false, priority = 11, description = "proceedToPay")
	public void proceedToPay() {
		ExtentReport.createTest("proceedToPay");
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		payments.clickPayButton(driver);
		log.info("Used COD mode to place an order");
	}

	@Test(enabled = false, priority = 12, description = "trackingOrderPage")
	public void trackingOrderPage() throws Exception {
		ExtentReport.createTest("trackingOrderPage");
		TrackingOrderPage tracking = PageFactory.initElements(driver, TrackingOrderPage.class);
		Thread.sleep(1000);
		// We need to fix the below validation-element locator is not correct
//		tracking.verifyTrackingOrderPage(driver);
		tracking.verifyViewOrderLink(driver);
		log.info("Verified Tracking order Page");

	}

//	@AfterClass
//	public void closeDriver() throws Exception {
//		driver.quit();
//		System.out.println("Browser Closed Successfully");
//	}

	@AfterSuite
	public void afterSuite() {

		ExtentReport.extent.flush();
	}
//    @AfterClass
//	public void teardown() {
//    driver.close();
//	}

}
