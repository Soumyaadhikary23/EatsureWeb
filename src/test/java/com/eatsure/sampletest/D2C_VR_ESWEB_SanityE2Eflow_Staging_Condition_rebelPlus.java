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

public class D2C_VR_ESWEB_SanityE2Eflow_Staging_Condition_rebelPlus {

	public WebDriver driver;
	Driver driver1;
	SoftAssert as;
	public static final Logger log = LogManager.getLogger(D2C_VR_ESWEB_SanityE2Eflow_Staging_Condition_rebelPlus.class.getName());

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

	@Test(enabled = false, priority = 1, description = "verifyLocalityPageContent")
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
//		Currently "Get Rewarded for eating good" on "Locality Page" is disabled-09-Aug-2023
//		as.assertEquals(locality.verifylLocalityPageRewardPoint(driver), true,
//				"Locality page Get Rewarded for eating good mismatch");
		as.assertEquals(locality.verifylLocalityPageCombosFromMutipleRestaurants(driver), true,
				"Locality page Combos from Multiple Restaurants mismatch");
		as.assertAll();

		log.info("Successfully validated Locality Page Content");
	}

	@Test(enabled = false, priority = 2, description = "verifyAddDynamicComboItemToCartFromHomePage")
	public void verifyAddDynamicComboItemToCartFromHomePage() {
		ExtentReport.createTest("verifyAddDynamicComboItemToCartFromHomePage");

		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		// Add dynamic product to Cart from Home/Locality Page
		String LocalityPageProductName = locality.getProductNameText();
		log.info("#LocalityPageProductName  #" + LocalityPageProductName);
		locality.addDynemiComboOfTwoProductcondition(driver);
		// Click on "CART" option
		locality.clickCartOption(driver);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		String CartPageProductName = cart.getProductNameText();
		log.info("#CartPageProductName  #" + CartPageProductName);
		as.assertEquals(CartPageProductName, LocalityPageProductName);
		as.assertAll();
		cart.clickHomeLink(driver);
		log.info("Successfully Added DynamicComboItem To Cart From HomePage");
	}

	@Test(enabled = false, priority = 3, description = "selectionOfRestaurant")
	public void selectionOfRestaurant() {
		ExtentReport.createTest("selectionOfRestaurant");
		as = new SoftAssert();
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.navigateToBrandCondition(driver);
		log.info("Successfully navigated to first Brand");
	}

	@Test(enabled = false, priority = 4, description = "selectionOfNormalProductwithCustomizationFromRestaurantPage")
	public void selectionOfNormalProductwithCustomizationFromRestaurantPage() {
		ExtentReport.createTest("selectionOfNormalProductwithCustomizationFromRestaurantPage");
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		brand.addNormalProductcondition(driver,brand.addButton);
		brand.clickContinue(driver);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		log.info("Successfully Added Normal Product with Customization from RestaurantPage to Cart");
	}

	@Test(enabled = false, priority = 5, description = "selectionOfDynamicProductwithCustomizationFromRestaurantPage")
	public void selectionOfDynamicProductwithCustomizationFromRestaurantPage() {
		ExtentReport.createTest("selectionOfDynamicProductwithCustomizationFromRestaurantPage");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.navigateToBrandCondition(driver);
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		brand.addDynemiComboOfTwoProductcondition(driver);
		brand.clickContinue(driver);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		log.info("Successfully Added Dynamic Product without Customization From RestaurantPage to Cart");
	}

	@Test(enabled = false, priority = 6, description = "selectionOfNormalProductwithCustomizationFromPDP")
	public void selectionOfNormalProductwithCustomizationFromPDP() {
		ExtentReport.createTest("selectionOfDynamicProductwithCustomizationFromPDP");
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

		brand.addNormalProductcondition(driver,pdp.addButton);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		log.info("Successfully Added Noramal Product without Customization to Cart from PDP and Validated the productname and price");
	}

	@Test(enabled = false, priority = 7, description = "selectionOfDynamicProductwithCustomizationFromPDP")
	public void selectionOfDynamicProductwithCustomizationFromPDP() {
		ExtentReport.createTest("selectionOfDynamicProductwithCustomizationFromPDP");
		

		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.navigateToBrandCondition(driver);

		// BrandRestaurantPage details
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		String BrandRestaurantPageDynamicProductName = brand.getDynemicProductNameText();
		log.info("#BrandPageDynamicProductName  #" + BrandRestaurantPageDynamicProductName);
		String BrandRestaurantPageDynamicProductPrice = brand.getDynamicProductPriceText();
		log.info("#BrandPageDynamicProductPrice  #" + BrandRestaurantPageDynamicProductPrice);

		brand.clickDynamicProducNameLink(driver);

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

		// Commented as part of production domain as we need to create the script to add
		// four/three product with custemization
		brand.addDynemiComboOfTwoProductcondition(driver);
		locality.clickCartOption(driver);
		
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		log.info("Successfully Added Dynamic Product without Customization to Cart from PDP and Validated the productname and price");
	}

	@Test(enabled = false, priority = 8, description = "selectionOfNormalandDynamicProductwithCustomizationFromPLPExploreAllDishes")
	public void selectionOfNormalandDynamicProductwithCustomizationFromPLPExploreAllDishes() {
		ExtentReport.createTest("selectionOfNormalandDynamicProductwithCustomizationFromPLPExploreAllDishes");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.clickExploreAllDishes(driver);
		ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class);
		String ProductListingPageDrpdownNameEADishes = plp.getDrpdownSelectItemName();
		log.info("#ProductListingPage Dropdown Name " + ProductListingPageDrpdownNameEADishes);
		as = new SoftAssert();
		as.assertEquals(ProductListingPageDrpdownNameEADishes, "Must Try Dishes");
//		as.assertEquals(plp.verifyProductListingPageDrpdownSelectItem(), true, "Product Listing Pagedropdown selection not validated");
		
        //Click on second "ExploreAll" button
		plp.clicksecondExploreAll(driver);
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		//Add Normal product from PLP page to Cart page
		brand.addNormalProductcondition(driver,plp.addButton);
		log.info("Successfully Added Normal Product with Customization from PLPExploreAllDishes page to Cart");

		// Added Dynamic product with/without Customization from PLP page to Cart page
		//Rebel+ As data is not available in PLP page so commenting the below line
		//brand.addDynemiComboOfTwoProductcondition(driver);

		// Click on Veg InActive Button
		plp.clickvegInActiveButton();

		// Validate the veg icon
		as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver, ProductListingPage.vegIcon, "Veg :- "), true,
				"Veg Icon mismatch");

		// Click on NonVeg InActive Button
		plp.clicknonvegInActiveButton();

		// Validate the non-veg icon
		//as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver, ProductListingPage.nonVegIcon,"nonVeg:- "), false,           "NonVeg Icon mismatch");

		brand.clickContinue(driver);
		as.assertAll();
		
		//Navigate to Home PAge
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		log.info("Successfully Added Dynamic Product without Customization From PLPExploreAllDishes Page to Cart");
		}

	@Test(enabled = false, priority = 9, description = "selectionOfNormalandDynamicProductwithCustomizationFromPLPExploreAllCollections")
	public void selectionOfNormalandDynamicProductwithCustomizationFromPLPExploreAllCollections() {
		ExtentReport.createTest("selectionOfNormalandDynamicProductwithCustomizationFromPLPExploreAllCollections");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		as.assertEquals(locality.verifylLocalityPagePopularCuisinesHeadar(driver), true,
				"Locality page Popular Cuisines headar in your area mismatch");
		as.assertEquals(locality.verifylLocalityPageFreeDish(driver), true, "Locality page FreeDish mismatch");
		as.assertEquals(locality.verifylLocalityPageMostLovedCollections(driver), true,
				"Locality page Most Loved Collection mismatch");
		locality.clickExploreAllCollections(driver);
		ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class);
		String ProductListingPageDrpdownNameEADishes = plp.getDrpdownSelectItemName();
		log.info("#ProductListingPage Dropdown Name " + ProductListingPageDrpdownNameEADishes);
		as.assertEquals(ProductListingPageDrpdownNameEADishes, "Most Loved Categories");
		
//		as.assertEquals(plp.verifyProductListingPageDrpdownSelectItem(), true, "Product Listing Pagedropdown selection not validated");
		
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		
		//Add Normal product from PLP page to Cart page
		brand.addNormalProductcondition(driver,plp.addButton);
		log.info("Successfully Added Normal Product with Customization from PLPExploreAllCollections page to Cart");

		// Added Dynamic product with Customization from PLP page to Cart page
		//Rebel+ As data is not available in PLP page so commenting the below line
		//brand.addDynemiComboOfTwoProductcondition(driver);

		//Rebel+ As data is not available in PLP page so commenting the below line
		// Click on Veg InActive Button
		//plp.clickvegInActiveButton();

		// Validate the veg icon
		//Rebel+ As data is not available in PLP page so commenting the below line
	    // as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver, ProductListingPage.vegIcon,"veg:- "), true,
		//		"Veg Icon mismatch");

		// Click on NonVeg InActive Button
		//Rebel+ As data is not available in PLP page so commenting the below line
		//plp.clicknonvegInActiveButton();

		// Validate the veg icon
		//Rebel+ As data is not available in PLP page so commenting the below line
		//as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver, ProductListingPage.nonVegIcon,"nonVeg:- "), true,
				//"NonVeg Icon mismatch");

		brand.clickContinue(driver);
		as.assertAll();
		
		//Navigate to Home Page
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		log.info("Successfully Added Dynamic Product with Customization From PLPExploreAllCollections Page to Cart");

	}

	@Test(enabled = false, priority = 10, description = "selectionOfDynamicProductwithCustomizationFromPLPExploreAllCombos")
	public void selectionOfDynamicProductwithCustomizationFromPLPExploreAllCombos() {
		ExtentReport.createTest("selectionOfDynamicProductwithCustomizationFromPLPExploreAllCombos");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		as.assertEquals(locality.verifylLocalityPagePopularCuisinesHeadar(driver), true,
				"Locality page Popular Cuisines headar in your area mismatch");
		as.assertEquals(locality.verifylLocalityPageFreeDish(driver), true, "Locality page FreeDish mismatch");
		as.assertEquals(locality.verifylLocalityPageMostLovedCollections(driver), true,
				"Locality page Most Loved Collection mismatch");
		as.assertEquals(locality.verifylLocalityPageCombosFromMutipleRestaurants(driver), true,
				"Locality page Combos from Multiple Restaurants mismatch");
		locality.clickExploreAllCombos(driver);
		ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class);
		String ProductListingPageDrpdownNameEADishes = plp.getDrpdownSelectItemName();
		log.info("#ProductListingPage Dropdown Name " + ProductListingPageDrpdownNameEADishes);
		as.assertEquals(ProductListingPageDrpdownNameEADishes, "Saving Combos");
		as.assertAll();

		// Added Dynamic product with/without Customization from PLP page to Cart page
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		brand.addDynemiComboOfTwoProductcondition(driver);
		
		//We need to validate with Product whether Icon is visible for combo or not.
		//As we have discussed with business,They are telling it is visible.
		//As of now we have commented the below piece of code to validate Veg/Nonveg icon

//		// Click on Veg InActive Button
//		plp.clickvegInActiveButton();
//
//		// Validate the veg icon
//		as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver, ProductListingPage.vegIcon,"Veg :- "), true,
//				"Veg Icon mismatch");
//
//		// Click on NonVeg InActive Button
//		plp.clicknonvegInActiveButton();
//
//		// Validate the veg icon
//		as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver, ProductListingPage.nonVegIcon,"nonVeg :- "), true,
//				"NonVeg Icon mismatch");
		
		brand.clickContinue(driver);
		
		//Navigate to Home Page
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		log.info("Successfully Added Dynamic Product with/without Customization From PLPExploreAllCombos Page to Cart");

	}

	@Test(enabled = false, priority = 11, description = "loginfromCartpage")
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

	@Test(enabled = false, priority = 12, description = "addAddressfromCartPage")
	public void addAddressfromCartPage() throws InterruptedException {
		ExtentReport.createTest("addAddressfromCartPage");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickAddressRadioButton(driver);

		cart.deleteexistingAddress(driver);

		cart.addnewAddress(driver);

		log.info("Successfully Deleted the old address and added the new address on cart page");

	}

	@Test(enabled = false, priority = 13, description = "addExtraInstructionfromCartPage")
	public void addExtraInstructionfromCartPage() throws InterruptedException {
		ExtentReport.createTest("addExtraInstructionfromCartPage");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.addextraInstruction(driver);

		log.info("Successfully added extra instruction on cart page");

	}

	@Test(enabled = false, priority = 14, description = "selectFreeDishfromCartPage")
	// this method is already false-16-11-2022
	public void selectFreeDishfromCartPage() throws InterruptedException {
		ExtentReport.createTest("selectFreeDishfromCartPage");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickSelectFreeDishjs(driver);
		cart.clickCheckoutNowFreeDishjs(driver);

		log.info("Successfully added Free Dish from cart page");

	}

	@Test(enabled = false, priority = 15, description = "visibilityOfPaymentPage")
	public void visibilityOfPaymentPage() throws Exception {
		ExtentReport.createTest("visibilityOfPaymentPage");
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		payments.verifyPaymentPageIsDisplayed(driver);
		log.info("Payments page is displayed");
	}

	@Test(enabled = false, priority = 16, description = "selectionOfPaymentMode")
	public void selectionOfPaymentMode() {
		ExtentReport.createTest("selectionOfPaymentMode");
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		payments.verifyChoosePaymentText(driver);
		payments.clickCODButton(driver);
		payments.verifyCODCard();
		payments.verifyAmount();
		log.info("Selected COD pay mode");
	}

	@Test(enabled = false, priority = 17, description = "proceedToPay")
	public void proceedToPay() {
		ExtentReport.createTest("proceedToPay");
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		payments.clickPayButton(driver);
		log.info("Used COD mode to place an order");
	}

	@Test(enabled = false, priority = 18, description = "trackingOrderPage")
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
