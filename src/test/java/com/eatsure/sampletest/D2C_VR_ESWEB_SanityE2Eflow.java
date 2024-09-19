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

public class D2C_VR_ESWEB_SanityE2Eflow {

	public WebDriver driver;
	Driver driver1;
	SoftAssert as;
	public static final Logger log = LogManager.getLogger(D2C_VR_ESWEB_SanityE2Eflow.class.getName());

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
//    	landing.enterLocation(Driver.prop.getProperty("location"));
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

//		 boolean v=CartPageProductName.contains(LocalityPageProductName);
//		 if(v) {
//			 System.out.println("Validated successful");
//		 }else
//		 {
//			 System.out.println("Validation is not successful");
//		 }

		as.assertEquals(CartPageProductName, LocalityPageProductName);
		as.assertAll();
		// locality.navigateToBrandCondition(driver);
//		locality.navigateToBrandCondition();
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
//		locality.navigateToBrandCondition();
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

	@Test(enabled = true, priority = 5, description = "selectionOfDynamicProductwithCustomizationFromRestaurantPage")
	public void selectionOfDynamicProductwithCustomizationFromRestaurantPage() {
		ExtentReport.createTest("selectionOfDynamicProductwithCustomizationFromRestaurantPage");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.navigateToBrandCondition(driver);
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		brand.addDynemiComboOfTwoProductcondition(driver);
		brand.clickContinue(driver);
		log.info("Successfully Added Dynamic Product without Customization From RestaurantPage to Cart");
	}

	@Test(enabled = true, priority = 6, description = "selectionOfNormalProductwithCustomizationFromPDP")
	public void selectionOfNormalProductwithCustomizationFromPDP() {
		ExtentReport.createTest("selectionOfDynamicProductwithCustomizationFromPDP");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		// Vivek--If we will not execute the above steps the we need to comment the
		// below line of code
		cart.clickHomeLink(driver);

		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.navigateToBrandCondition(driver);

		// BrandRestaurantPage details
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		String BrandRestaurantPageProductName = brand.getProductNameText();
		log.info("#BrandPageProductName  #" + BrandRestaurantPageProductName);
		String BrandRestaurantPageProductPrice = brand.getProductPriceText();
		log.info("#BrandPageProductPrice  #" + BrandRestaurantPageProductPrice);

		brand.clickProducNameLink(driver);

		// vivek-- Tried different way
		// brand.clickProducNameLink1(brand.productNameLink1, driver);

		// ProductDetailPage details
		ProductDetailPage pdp = PageFactory.initElements(driver, ProductDetailPage.class);
		String ProductDetailPageProductName = pdp.getProductNameText();
		log.info("#ProductDetailPageProductName  #" + ProductDetailPageProductName);
		String ProductDetailPageProductPrice = pdp.getProductPriceText();
		log.info("#ProductDetailPageProductPrice  #" + ProductDetailPageProductPrice);

		// Validation
		as.assertEquals(BrandRestaurantPageProductName, ProductDetailPageProductName);
		as.assertEquals(BrandRestaurantPageProductPrice, ProductDetailPageProductPrice);
		as.assertAll();

		pdp.clickAddbutton(driver);
		brand.clickAddItem();

//		BasePage base = PageFactory.initElements(driver, BasePage.class);
//		pdp.clickBrowserBackButton(driver);
//		pdp.clickBrowserBackButton(driver);

		log.info("Successfully Added Noramal Product without Customization to Cart from PDP and Validated the productname and price");
	}

	@Test(enabled = false, priority = 7, description = "selectionOfDynamicProductwithCustomizationFromPDP")
	public void selectionOfDynamicProductwithCustomizationFromPDP() {
		ExtentReport.createTest("selectionOfDynamicProductwithCustomizationFromPDP");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);

		// Vivek--If we will not execute the above steps the we need to comment the
		// below line of code
		cart.clickHomeLink(driver);

		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.navigateToBrandCondition(driver);

		// BrandRestaurantPage details
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		String BrandRestaurantPageDynamicProductName = brand.getDynemicProductNameText();
		log.info("#BrandPageDynamicProductName  #" + BrandRestaurantPageDynamicProductName);
		String BrandRestaurantPageDynamicProductPrice = brand.getDynamicProductPriceText();
		log.info("#BrandPageDynamicProductPrice  #" + BrandRestaurantPageDynamicProductPrice);

		brand.clickDynamicProducNameLink(driver);

		// vivek
		// brand.clickProducNameLink1(brand.productNameLink1, driver);

		// ProductDetailPage details
		ProductDetailPage pdp = PageFactory.initElements(driver, ProductDetailPage.class);
		String ProductDetailPageProductName = pdp.getProductNameText();
		log.info("#ProductDetailPageDynamicProductName  #" + ProductDetailPageProductName);
		String ProductDetailPageDynamicProductPrice = pdp.getDynamicProductPriceText();
		log.info("#ProductDetailPageDynamicProductPrice  #" + ProductDetailPageDynamicProductPrice);

		// Validation
		as.assertEquals(BrandRestaurantPageDynamicProductName, ProductDetailPageProductName);
		as.assertEquals(BrandRestaurantPageDynamicProductPrice, ProductDetailPageDynamicProductPrice);
		as.assertAll();

		brand.addDynemiComboOfTwoProductcondition(driver);

		locality.clickCartOption(driver);

//		pdp.clickBrowserBackButton(driver);
		// brand.clickBrowserBackButton(driver);

		log.info(
				"Successfully Added Dynamic Product without Customization to Cart from PDP and Validated the productname and price");
	}

	@Test(enabled = true, priority = 8, description = "selectionOfNormalProductwithCustomizationFromPLPExploreAllDishes")
	public void selectionOfNormalProductwithCustomizationFromPLPExploreAllDishes() {
		ExtentReport.createTest("selectionOfNormalProductwithCustomizationFromPLPExploreAllDishes");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);

		// Vivek--If we will not execute the above steps the we need to comment the
		// below line of code
		cart.clickHomeLink(driver);

		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.clickExploreAllDishes(driver);
		ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class);
		String ProductListingPageDrpdownNameEADishes = plp.getDrpdownSelectItemName();
		log.info("#ProductListingPage Dropdown Name " + ProductListingPageDrpdownNameEADishes);
		as = new SoftAssert();
		as.assertEquals(ProductListingPageDrpdownNameEADishes, "Must Try Dishes");
//		as.assertEquals(plp.verifyProductListingPageDrpdownSelectItem(), true, "Product Listing Pagedropdown selection not validated");
		// Added the normal product
		plp.addFirstItem(driver);

		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);

		brand.clickAddItem();
		// plp.clickContinue();
		log.info("Successfully Added Normal Product with Customization from PLPExploreAllDishes page to Cart");

		// Added Dynamic product without Customization from PLP page to Cart page
		brand.addDynemiComboOfTwoProductcondition(driver);

		// Click on Veg InActive Button
		plp.clickvegInActiveButton();

		// Validate the veg icon
		as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver, ProductListingPage.vegIcon,"Veg :- "), true,
				"Veg Icon mismatch");

		// Click on NonVeg InActive Button
		plp.clicknonvegInActiveButton();

		// Validate the veg icon
		as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver, ProductListingPage.nonVegIcon,"nonVeg :- "), true,
				"NonVeg Icon mismatch");

		brand.clickContinue(driver);

		log.info("Successfully Added Dynamic Product without Customization From PLPExploreAllDishes Page to Cart");

		as.assertAll();

	}

	@Test(enabled = false, priority = 9, description = "selectionOfNormalProductwithCustomizationFromPLPExploreAllCollections")
	public void selectionOfNormalProductwithCustomizationFromPLPExploreAllCollections() {
		ExtentReport.createTest("selectionOfNormalProductwithCustomizationFromPLPExploreAllCollections");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);

		// Vivek--If we will not execute the above steps the we need to comment the
		// below line of code
    	cart.clickHomeLink(driver);

		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.clickExploreAllCollections(driver);
		ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class);
		String ProductListingPageDrpdownNameEADishes = plp.getDrpdownSelectItemName();
		log.info("#ProductListingPage Dropdown Name " + ProductListingPageDrpdownNameEADishes);
		as = new SoftAssert();
		as.assertEquals(ProductListingPageDrpdownNameEADishes, "Most Loved Catagories");
		as.assertAll();
//		as.assertEquals(plp.verifyProductListingPageDrpdownSelectItem(), true, "Product Listing Pagedropdown selection not validated");
		// Added the normal product
		plp.addFirstItem(driver);
		// plp.clickContinue();
		log.info("Successfully Added Normal Product with Customization from PLPExploreAllCollections page to Cart");

		// Added Dynamic product without Customization from PLP page to Cart page
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		brand.addDynemiComboOfTwoProductcondition(driver);

		// Click on Veg InActive Button
		plp.clickvegInActiveButton();

		// Validate the veg icon
		as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver, ProductListingPage.vegIcon,"Veg :- "), true,
				"Veg Icon mismatch");

		// Click on NonVeg InActive Button
		plp.clicknonvegInActiveButton();

		// Validate the veg icon
		as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver, ProductListingPage.nonVegIcon,"nonVeg :- "), true,
				"NonVeg Icon mismatch");

		brand.clickContinue(driver);
		log.info("Successfully Added Dynamic Product without Customization From PLPExploreAllCollections Page to Cart");

	}

	@Test(enabled = false, priority = 10, description = "selectionOfNormalProductwithCustomizationFromPLPExploreAllCombos")
	public void selectionOfNormalProductwithCustomizationFromPLPExploreAllCombos() {
		ExtentReport.createTest("selectionOfNormalProductwithCustomizationFromPLPExploreAllCombos");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);

		// Vivek--If we will not execute the above steps the we need to comment the
		// below line of code
		cart.clickHomeLink(driver);

		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.clickExploreAllCombos(driver);
		ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class);
		String ProductListingPageDrpdownNameEADishes = plp.getDrpdownSelectItemName();
		log.info("#ProductListingPage Dropdown Name " + ProductListingPageDrpdownNameEADishes);
		as = new SoftAssert();
		as.assertEquals(ProductListingPageDrpdownNameEADishes, "Saving Combos");
		as.assertAll();

		// Added Dynamic product without Customization from PLP page to Cart page
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		brand.addDynemiComboOfTwoProductcondition(driver);

		// Click on Veg InActive Button
		plp.clickvegInActiveButton();

		// Validate the veg icon
		as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver, ProductListingPage.vegIcon,"Veg :- "), true,
				"Veg Icon mismatch");

		// Click on NonVeg InActive Button
		plp.clicknonvegInActiveButton();

		// Validate the veg icon
		as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver, ProductListingPage.nonVegIcon,"nonVeg :- "), true,
				"NonVeg Icon mismatch");

		brand.clickContinue(driver);
		log.info("Successfully Added Dynamic Product without Customization From PLPExploreAllCombos Page to Cart");

	}

	@Test(enabled = true, priority = 11, description = "loginfromCartpage")
	public void loginfromCartPage() throws InterruptedException {
		ExtentReport.createTest("loginfromCartpage");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);

		cart.enterMobileNumber(ReadPropertyFile.get("MobilenumberFixedOTP"));
		Thread.sleep(1000);
		cart.clickLoginwithOTP();
		cart.enterOTP(driver, ReadPropertyFile.get("otp"));
		cart.clickVerifyOTP();

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

	@Test(enabled = true, priority = 12, description = "addAddressfromCartPage")
	public void addAddressfromCartPage() throws InterruptedException {
		ExtentReport.createTest("addAddressfromCartPage");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		
		cart.clickAddressRadioButton(driver);

		cart.deleteexistingAddress(driver);

		cart.addnewAddress(driver);

		log.info("Successfully Deleted the old address and added the new address on cart page");

	}

	@Test(enabled = true, priority = 13, description = "addExtraInstructionfromCartPage")
	public void addExtraInstructionfromCartPage() throws InterruptedException {
		ExtentReport.createTest("addExtraInstructionfromCartPage");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.addextraInstruction(driver);
	

		log.info("Successfully added extra instruction on cart page");

	}

	@Test(enabled = false, priority = 14, description = "selectFreeDishfromCartPage")
	//this method is already false-16-11-2022
	public void selectFreeDishfromCartPage() throws InterruptedException {
		ExtentReport.createTest("selectFreeDishfromCartPage");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickSelectFreeDishjs(driver);
		cart.clickCheckoutNowFreeDishjs(driver);
	

		log.info("Successfully added Free Dish from cart page");

	}
	@Test(enabled = true, priority = 15, description = "visibilityOfPaymentPage")
	public void visibilityOfPaymentPage() throws Exception {
		ExtentReport.createTest("visibilityOfPaymentPage");
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		payments.verifyPaymentPageIsDisplayed(driver);
		log.info("Payments page is displayed");
	}

	@Test(enabled = true, priority = 16, description = "selectionOfPaymentMode")
	public void selectionOfPaymentMode() {
		ExtentReport.createTest("selectionOfPaymentMode");
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		payments.verifyChoosePaymentText(driver);
		payments.clickCODButton(driver);
		payments.verifyCODCard();
		payments.verifyAmount();
		log.info("Selected COD pay mode");
	}

	@Test(enabled = true, priority = 17, description = "proceedToPay")
	public void proceedToPay() {
		ExtentReport.createTest("proceedToPay");
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		payments.clickPayButton(driver);
		log.info("Used COD mode to place an order");
	}

	@Test(enabled = true, priority = 18, description = "trackingOrderPage")
	public void trackingOrderPage() throws Exception {
		ExtentReport.createTest("trackingOrderPage");
		TrackingOrderPage tracking = PageFactory.initElements(driver, TrackingOrderPage.class);
		Thread.sleep(1000);
		tracking.verifyTrackingOrderPage(driver);
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
