package com.eatsure.sampletest;

import java.io.IOException;

import com.eatsure.pom.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.eatsure.browser.Driver;
import com.eatsure.pom.LandingPage;
import com.eatsure.pom.LocalityPage;
import com.eatsure.pom.ProductDetailPage;
import com.eatsure.pom.ProductListingPage;
import com.eatsure.pom.BrandRestaurantPage;
import com.eatsure.pom.CartPage;
import com.eatsure.reports.ExtentReport;
import com.eatsure.utils.ReadPropertyFile;
import com.eatsure.validation.ValidateTitle;

public class D2C_VR_ESWEB_RegressionFlow_OrderTrackingPage {
	public static final Logger log = LogManager
			.getLogger(D2C_VR_ESWEB_RegressionFlow_OrderTrackingPage.class.getName());
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
		driver.get(Driver.prop.getProperty("urlStagingES"));
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
		as.assertEquals(locality.verifylLocalityPageOneSingleOrder(), true, "Locality page header mismatch");
		as.assertEquals(locality.verifyLocalityPagHeaderLogo(), true, "Locality page header EatsureLogo mismatch");
		as.assertEquals(locality.verifyLocalityPageEatSurance(), true, "Locality page \"EatSurance\" mismatch");
		as.assertEquals(locality.verifylLocalityPagePopularCuisinesHeadar(driver), true,
				"Locality page Popular Cuisines headar in your area mismatch");
		as.assertEquals(locality.verifylLocalityPagePopularCuisinesContent(), true,
				"Locality page Popular Cuisines content in your area mismatch");
		as.assertEquals(locality.verifylLocalityPageFreeDish(driver), true, "Locality page FreeDish mismatch");
		as.assertEquals(locality.verifylLocalityPageMostLovedCollections(driver), true,
				"Locality page Most Loved Collection mismatch");
		as.assertEquals(locality.verifylLocalityPageRewardPoint(driver), true,
				"Locality page Get Rewarded for eating good mismatch");
		as.assertEquals(locality.verifylLocalityPageCombosFromMutipleRestaurants(driver), true,
				"Locality page Combos from Multiple Restaurants mismatch");
		as.assertAll();

		log.info("Successfully validated Locality Page Content");
	}

//	@Test(enabled = true, priority = 2, description = "verifyAddDynamicComboItemToCartFromHomePage")
//	public void verifyAddDynamicComboItemToCartFromHomePage() {
//		ExtentReport.createTest("verifyAddDynamicComboItemToCartFromHomePage");
//		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
//		as = new SoftAssert();
//		// Add dynamic product to Cart from Home/Locality Page
//		locality.addDynemiComboOftwoProduct(driver);
//		String LocalityPageProductName = locality.getProductNameText();
//		log.info("#LocalityPageProductName  #" + LocalityPageProductName);
//		// Click on "CART" option
//		locality.clickCartOption(driver);
//		CartPage cart = PageFactory.initElements(driver, CartPage.class);
//		String CartPageProductName = cart.getProductNameText();
//		log.info("#CartPageProductName  #" + CartPageProductName);
//		as.assertEquals(CartPageProductName, LocalityPageProductName);
//		as.assertAll();
//		log.info("Successfully Added DynamicComboItem To Cart From HomePage");
//	}
	@Test(enabled = true, priority = 2, description = "selectionOfNormalProductwithCustomizationFromRestaurantPage")
	public void selectionOfNormalProductwithCustomizationFromRestaurantPage() {
		ExtentReport.createTest("selectionOfNormalProductwithCustomizationFromRestaurantPage");
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		brand.addNormalProductcondition(driver,brand.addButton);
		brand.clickContinue(driver);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
//		cart.clickHomeLink(driver);
		log.info("Successfully Added Normal Product with Customization from RestaurantPage to Cart");
	}


	@Test(enabled = true, priority = 3, description = "loginfromCartpage")
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

	@Test(enabled = true, priority = 4, description = "addAddressfromCartPage")
	public void addAddressfromCartPage() throws InterruptedException {
		ExtentReport.createTest("addAddressfromCartPage");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickAddressRadioButton(driver);
		log.info("Successfully Deleted the old address and added the new address on cart page");
	}

	@Test(enabled = true, priority = 5, description = "visibilityOfPaymentPage")
	public void visibilityOfPaymentPage() throws Exception {
		ExtentReport.createTest("visibilityOfPaymentPage");
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		payments.verifyPaymentPageIsDisplayed(driver);
		payments.verifyEditLink(driver);
		log.info("Payments page is displayed");
	}

	@Test(enabled = true, priority = 6, description = "selectionOfPaymentMode")
	public void selectionOfPaymentMode() {
		ExtentReport.createTest("selectionOfPaymentMode");
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		payments.verifyChoosePaymentText(driver);
		payments.clickCODButton(driver);
		payments.verifyCODCard();
		payments.verifyAmount();
		log.info("Selected COD pay mode");
	}

	@Test(enabled = true, priority = 10, description = "proceedToPay")
	public void proceedToPay() {
		ExtentReport.createTest("proceedToPay");
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		payments.clickPayButton(driver);
		log.info("Used COD mode to place an order");
	}

	@Test(enabled = true, priority = 11, description = "trackingOrderPageDeliveryNow")
	public void trackingOrderPageDeliveryNow() throws Exception {
		ExtentReport.createTest("trackingOrderPage");
		TrackingOrderPage tracking = PageFactory.initElements(driver, TrackingOrderPage.class);
		Thread.sleep(1000);
		as.assertEquals(tracking.verifyEsWebLogo(), true, "EsWebLogo Not available on Tracking");
		as.assertEquals(tracking.verifyOrderTrackingText(), true, "OrderTrackingText Not available on Tracking");	
		as.assertEquals(tracking.verifyOrderCrn(), true, "OrderCrnText Not available on Tracking");	
		as.assertEquals(tracking.verifyOrderConfirmedText(), true, "verifyOrderConfirmedText Not available on Tracking");
		as.assertEquals(tracking.verifyCookingInProcessText(), true, "verifyCookingInProcess Text Not available on Tracking");
		as.assertEquals(tracking.verifyCookingInProcessDescription(), true, "verifyCookingInProcessDescription Not available on Tracking");
		as.assertEquals(tracking.verifySureQualityCheckText(), true, "verifySureQualityCheckText Not available on Tracking");
		as.assertEquals(tracking.verifySureQualityCheckDescription(), true, "verifySureQualityCheckDescription Not available on Tracking");
		as.assertEquals(tracking.verifyOutForDeliveryText(), true, "verifyOutForDeliveryText Not available on Tracking");
		as.assertEquals(tracking.verifyOutForDeliveryDescription(), true, "verifyOutForDeliveryDescription Not available on Tracking");
		as.assertEquals(tracking.verifyAppDownloadSection(), true, "verifyAppDownloadSection Not available on Tracking");
		as.assertEquals(tracking.verifyGiveSureSection(), true, "verifyGiveSureSection Not available on Tracking");
		as.assertEquals(tracking.verifySurePointsSection(), true, "verifySurePointsSection Not available on Tracking");
		as.assertEquals(tracking.verifyViewOrderDetailsDeliverNow(), true, "verifySurePointsSection Not available on Tracking");
        tracking.clickViewOrderDetailsLinkDeliverNow(driver);
        as.assertEquals(tracking.verifyViewOrderDetailsOrderCrn(), true, "viewOrderDetailsOrderCrn Not available on Tracking");
        as.assertEquals(tracking.verifyViewOrderDetailsNoOfItemsDisplay(), true, "viewOrderDetailsNoOfItemsDisplay Not available on Tracking");
        as.assertEquals(tracking.verifyViewOrderDetailsAddress(), true, "viewOrderDetailsAddress Not available on Tracking");
        as.assertEquals(tracking.verifyViewOrderDetailsListOfProducts(), true, "viewOrderDetailsListOfProducts Not available on Tracking");
        as.assertEquals(tracking.verifyViewOrderDetailsBillDetails(), true, "viewOrderDetailsBillDetails Not available on Tracking");
        as.assertEquals(tracking.verifyPaidbyText(), true, "PaidbyText Not available on Tracking");
        tracking.clickCloseOrderDetails(driver);
		log.info("Verified Tracking order Page");
	}
	@Test(enabled = true, priority = 11, description = "trackingOrderPageDeliveryLater")
	public void trackingOrderPageDeliveryLater() throws Exception {
		ExtentReport.createTest("trackingOrderPage");
		TrackingOrderPage tracking = PageFactory.initElements(driver, TrackingOrderPage.class);
		Thread.sleep(1000);
		as.assertEquals(tracking.verifyEsWebLogo(), true, "EsWebLogo Not available on Tracking");
		as.assertEquals(tracking.verifyOrderTrackingText(), true, "OrderTrackingText Not available on Tracking");	
		as.assertEquals(tracking.verifyOrderDeliverText(), true, "Order Delivery Text Not available on Tracking");
		as.assertEquals(tracking.verifyOrderDateTimeText(), true, "Order Date Time Text Not available on Tracking");
		as.assertEquals(tracking.verifyViewOrderDetailsButton(), true, "View Order Details Button Not available on Tracking");

		log.info("Verified Tracking order Page");
	}

	@Test(enabled = true, priority = 12, description = "verifyViewOrderLinkDeliveryLater")
	public void viewOrderLinkDeliveryLater() {
		ExtentReport.createTest("verifyViewOrderLink");
		TrackingOrderPage tracking = PageFactory.initElements(driver, TrackingOrderPage.class);
		tracking.clickViewOrderDetailsButton(driver);
		as.assertEquals(tracking.verifyOrderDetailsPopup(), true, "OrderDetailsPopup Not available on tracking");
		as.assertEquals(tracking.verifyViewOrderDetailsOrderCrn(), true,
				"ViewOrderDetailsOrderCrn Not available on tracking");
		as.assertEquals(tracking.verifyViewOrderDetailsNoOfItemsDisplay(), true,
				"ViewOrderDetailsNoOfItemsDisplay Not available on tracking");
		as.assertEquals(tracking.verifyViewOrderDetailsAddress(), true,
				"ViewOrderDetailsAddress Not available on tracking");
		as.assertEquals(tracking.verifyViewOrderDetailsBillDetails(), true,
				"ViewOrderDetailsBillDetails Not available on tracking");
		as.assertEquals(tracking.verifyViewOrderDetailsListOfProducts(), true,
				"ViewOrderDetailsListOfProducts Not available on tracking");
		as.assertEquals(tracking.verifyPaidbyText(), true, "PaidbyText Not available on tracking");
		log.info("Successfully Validated View Order Link");

	}

	@AfterClass
	public void closeDriver() throws Exception {
		driver.quit();
		System.out.println("Browser Closed Successfully");
	}

	@AfterSuite
	public void afterSuite() {
		ExtentReport.extent.flush();
	}
}
