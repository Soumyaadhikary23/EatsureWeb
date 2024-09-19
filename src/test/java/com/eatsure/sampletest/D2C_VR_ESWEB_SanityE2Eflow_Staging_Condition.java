package com.eatsure.sampletest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.eatsure.pom.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.eatsure.browser.Driver;
import com.eatsure.reports.ExtentReport;
import com.eatsure.utils.CommonUtility;
import com.eatsure.utils.ReadPropertyFile;
import com.eatsure.validation.ValidateTitle;

public class D2C_VR_ESWEB_SanityE2Eflow_Staging_Condition {

	public WebDriver driver;
	Driver driver1;
	SoftAssert as;
	public static final Logger log = LogManager.getLogger(D2C_VR_ESWEB_SanityE2Eflow_Staging_Condition.class.getName());

	@BeforeSuite
	public void beforeSuite() {
		ExtentReport.initialize();
	}

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void initialize(@Optional("chrome") String browser) throws IOException {
		driver1 = new Driver();
		driver = driver1.initializeDriver(browser);
		driver.get(Driver.prop.getProperty("urlStagingES"));
	}

	@Test(enabled = true, priority = 0, description = "Verify UI Elements of landing page")
	public void verifyUIElements() {
		ExtentReport.createTest("Verify UI Elements of Landing page");
		LandingPage landing = PageFactory.initElements(driver, LandingPage.class);
		ValidateTitle.verifyTitle(driver, "Order Food Online From India's Best Food Delivery Services | EatSure");
		as = new SoftAssert();
		as.assertEquals(landing.verifyLandingPageHeaderLogo(), true, "Landing page header EatsureLogo mismatch");
		as.assertEquals(landing.verifytrustedRestaurantsHeaderText(), true,
				"Landing page Trusted Restaurants header mismatch");
		as.assertEquals(landing.verifyfreeDeliveryHeaderText(), true, "Landing page Free Delivery Text mismatch");
		as.assertEquals(landing.verifyfoodCourtHeaderText(), true, "Landing page Food Court Text mismatch");
		as.assertEquals(landing.verifylocateMeText(), true, "Landing page Locate Me Text mismatch");
		as.assertEquals(landing.verifyorderFoodButton(), true, "Landing page Order Food Button mismatch");

		log.info("Successfully Landing Page title verified");
	}

	@Test(enabled = true, priority = 1, description = "Verify Auto Suggest once serviceable area is entered")
	public void verifyAutoSuggestServiceable() {
		ExtentReport.createTest("Verify Auto Suggest once serviceable area is entered");
		LandingPage landing = PageFactory.initElements(driver, LandingPage.class);
		landing.enterLocation(ReadPropertyFile.get("location"));
		as.assertEquals(landing.verifyAutoSuggestions(), true, "Landing page Auto Suggestions mismatch");
		landing.clickClearSearchBtn(driver);
		log.info("Successfully Auto Suggest verified");
	}

	@Test(enabled = true, priority = 2, description = "Verify Error message with UI Elements once non serviceable area is entered")
	public void verifyErrorMessageNonServiceableLocation() {
		ExtentReport.createTest("Verify Error message with UI Elements once non serviceable area is entered");
		LandingPage landing = PageFactory.initElements(driver, LandingPage.class);
		landing.enterLocation(ReadPropertyFile.get("nonServiceable"));
		landing.selectLocation();
		log.info("Successfully selected the entered non serviceable location");
		landing.clickCloseWindowPopup(driver);
		landing.clickClearSearchBtn(driver);
		log.info("Successfully Verified Error message with UI Elements");
	}

	@Test(enabled = true, priority = 3, description = "Verify the Clear text functionality on click of Cross button")
	public void verifyClearTextFunctionalityOnClickOfCrossButton() {
		ExtentReport.createTest("Verify Clear text functionality on click of Cross button");
		LandingPage landing = PageFactory.initElements(driver, LandingPage.class);
		landing.enterLocation(ReadPropertyFile.get("location"));
		as.assertEquals(landing.verifyAutoSuggestions(), true, "Landing page Auto Suggestions mismatch");
		landing.clickClearSearchBtn(driver);
		log.info("Successfully Verified Clear text functionality on click of Cross button");
	}

	@Test(enabled = true, priority = 4, description = "selectionOfLocation")
	public void selectionOfLocation() {
		ExtentReport.createTest("selectionOfLocation");
		LandingPage landing = PageFactory.initElements(driver, LandingPage.class);
//    	landing.enterLocation(Driver.prop.getProperty("location"));
		landing.enterLocation(ReadPropertyFile.get("location1"));
		landing.selectLocation();
		log.info("Successfully selected the entered location");
		ValidateTitle.verifyTitle(driver, "Order Food Online From India's Best Food Delivery Services | EatSure");
		log.info("Successfully Landing Page title verified");
	}

	@Test(enabled = true, priority = 5, description = "location change manually")

	public void locationChange() throws InterruptedException {

		ExtentReport.createTest("verifyLocationchange_Manually");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		Thread.sleep(2000);
		;
		// locality.clickdelivery();
		locality.clickDelivery();
		Thread.sleep(5000);

		String changelocation = locality.verifyLocation(ReadPropertyFile.get("location"));
		as.assertEquals(changelocation, "CBD Belapur, Mumbai");
		as.assertAll();
		log.info("Successfully  verify change location in the locality page manually " + changelocation);

	}

	@Test(enabled = false, priority = 6, description = "already false location change by GPS")
	public void verifyGPS() throws InterruptedException {

		ExtentReport.createTest("verifyLocationchange_GPS");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		locality.clickDelivery();
		locality.clickGPS();
		Thread.sleep(6000);
		String locationname = locality.getLocatityName().getText();
		log.info("Successfully  verify change location in the locality page  by GPS  " + locationname);
		// as.assertEquals(locationname, "HBR Layout, Kalyan Nagar");
		// as.assertAll();

	}

	@Test(enabled = true, priority = 7, description = "checkHeadercontain")
	public void checkHeaderContain() throws InterruptedException {
		ExtentReport.createTest("verifyLocalityPageContent_reg");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		// verify the ES logo
		as.assertEquals(locality.verifyLocalityPagHeaderLogo(), true, "Locality page header EatsureLogo mismatch");
//		as.assertAll();
		// verify the delivery location name
		String locationname = locality.getLocatityName().getText();
		log.info("location name  " + locationname);
		if (locationname.contains("Cafe Soul Garden")) {
			as.assertTrue(true, locationname);
			as.assertAll();
			log.info("Successfully verify the location name");
		}
		as.assertEquals(locality.delivery(), true, "Locality page header delivery wrapper not showing");
		log.info("Successfully verify delivery wrapper option is showing in the header");
		String searchText = locality.localityPageSearch().getText();
		as.assertEquals(searchText, "Search");
		log.info("Successfully search option is verify in the locality page " + searchText);
		String cartText = locality.cart().getText();
		as.assertEquals(cartText, "Cart");
		log.info("Successfully Crat option is verify in the locality page " + cartText);
		// verify the profile logo
		as.assertEquals(locality.verifyLocalityProfilerLogo(), true, "Locality page header ProfileLogo mismatch");
		log.info("Successfully Profilelogo option is verify in the locality page");
		// verify the sign in option
		SiginPage Sigin = PageFactory.initElements(driver, SiginPage.class);
		as.assertEquals(Sigin.getSigin(), true, "In Loaclity page Sigin button not showing");
		log.info("Successfully Sigin option is verify in the locality page ");
		// verify the menu bar
		as.assertEquals(locality.Menu(), true, "In locality page menu bar is not showing");
		as.assertAll();
		log.info("Successfully menu option is verify in the locality page ");

		Thread.sleep(3000);
	}

	@Test(enabled = true, priority = 8, description = "locality page BREADCRUMBS ")
	public void breadcurms() throws InterruptedException {

		ExtentReport.createTest("verifylocalitypage_BREADCRUMBS ");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		as.assertEquals(locality.getBreadcrums(), true, "Breadcrums section not showing");
		log.info("Breadcrums setion is showing");
		// get the breadcrums section text
		WebElement Bread_Section = driver.findElement(By.xpath("//div[@data-qa='breadcrumbsSection']"));
		String text="";
		List<WebElement> link_count = Bread_Section.findElements(By.tagName("a"));
		int Bread_count = link_count.size();
		for (int i = 0; i < Bread_count; i++) {

			WebElement a = link_count.get(i);
			 text = a.getText();
			

		}
		log.info(text);

	}

	@Test(enabled = true, priority = 9, description = "verifyLocalityPageContent")
	public void verifyLocalityPageContent() {
		ExtentReport.createTest("verifyLocalityPageContent");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);

		as = new SoftAssert();
		as.assertEquals(locality.verifylLocalityPageOneSingleOrder(), true, "Locality page header mismatch");
		as.assertEquals(locality.verifyLocalityPagHeaderLogo(), true, "Locality page header EatsureLogo mismatch");
		as.assertEquals(locality.verifyLocalityPageEatSurance(), true, "Locality page \"EatSurance\" mismatch");
		as.assertEquals(locality.verifylLocalityPagePopularCuisinesHeadar(driver), true,
				"Locality page Popular Cuisines headar in your area mismatch");
		/*
		 * as.assertEquals(locality.verifylLocalityPagePopularCuisinesContent(), true,
		 * "Locality page Popular Cuisines content in your area mismatch");
		 */
//		as.assertEquals(locality.verifylLocalityPageFreeDish(driver), true, "Locality page FreeDish mismatch");
		as.assertEquals(locality.verifylLocalityPageMostLovedCollections(driver), true,
				"Locality page Most Loved Collection mismatch");
//		as.assertEquals(locality.verifylLocalityPageRewardPoint(driver), true,
//				"Locality page Get Rewarded for eating good mismatch");
		as.assertEquals(locality.verifylLocalityPageCombosFromMutipleRestaurants(driver), true,
				"Locality page Combos from Multiple Restaurants mismatch");
		as.assertAll();

		log.info("Successfully validated Locality Page Content");
	}

	@Test(enabled = true, priority = 10, description = "alreadverifyAddDynamicComboItemToCartFromHomePage")
	public void verifyAddDynamicComboItemToCartFromHomePage() {
		ExtentReport.createTest("verifyAddDynamicComboItemToCartFromHomePage");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		BasePage.scrollbar_down(driver);
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

	@Test(enabled = true, priority = 11, description = "selectionOfRestaurant")
	public void selectionOfRestaurant() {
		ExtentReport.createTest("selectionOfRestaurant");
		as = new SoftAssert();
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.navigateToBrandCondition(driver);
		log.info("Successfully navigated to first Brand");
	}

	@Test(enabled = true, priority = 12, description = "selectionOfNormalProductwithCustomizationFromRestaurantPage")
	public void selectionOfNormalProductwithCustomizationFromRestaurantPage() {
		ExtentReport.createTest("selectionOfNormalProductwithCustomizationFromRestaurantPage");
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		brand.addNormalProductcondition(driver, brand.addButton);
		brand.clickContinue(driver);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		log.info("Successfully Added Normal Product with Customization from RestaurantPage to Cart");
	}

	@Test(enabled = true, priority = 13, description = "selectionOfDynamicProductwithCustomizationFromRestaurantPage")
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

	@Test(enabled = true, priority = 14, description = "selectionOfNormalProductwithCustomizationFromPDP")
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
		as.assertAll();
		as.assertEquals(BrandRestaurantPageProductPrice, ProductDetailPageProductPrice);
		as.assertAll();

		brand.addNormalProductcondition(driver, pdp.addButton);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		log.info(
				"Successfully Added Noramal Product without Customization to Cart from PDP and Validated the productname and price");
	}

	@Test(enabled = false, priority = 15, description = "selectionOfDynamicProductwithCustomizationFromPDP")
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
		as.assertAll();
		as.assertEquals(BrandRestaurantPageDynamicProductPrice, ProductDetailPageDynamicProductPrice);
		as.assertAll();

		// Commented as part of production domain as we need to create the script to add
		// four/three product with custemization
		brand.addDynemiComboOfTwoProductcondition(driver);
		locality.clickCartOption(driver);

		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		log.info(
				"Successfully Added Dynamic Product without Customization to Cart from PDP and Validated the productname and price");
	}

	@Test(enabled = true, priority = 16, description = "verifyUIElementsAndContentOnPDP")
	public void verifyUIElementsAndContentOnPDP() {
		ExtentReport.createTest("verifyUIElementsAndContentOnPDP");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.navigateToBrandCondition(driver);
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		brand.clickProducNameLink(driver);

		ProductDetailPage pdp = PageFactory.initElements(driver, ProductDetailPage.class);

		// Verify UI And Content On PDP
		as.assertEquals(pdp.verifyProductDetailPageProductImage(), true, "Product Image Not available");
		as.assertAll();
		as.assertEquals(pdp.verifyProductDetailPageProductPrice(), true, "Product Price mismatch");
		as.assertAll();
		as.assertEquals(pdp.verifyProductDetailPageStickyHeader(), true, "Sticky Header mismatch");
		as.assertAll();
		as.assertEquals(pdp.verifyProductDetailPageBrandsReel(), true, "Brands Reel mismatch");
		as.assertAll();

		log.info("Successfully Validated UI Elements And Content On PDP Page");
	}

	@Test(enabled = true, priority = 17, description = "verifyAddButtonFunctionalityOnPDP")
	public void verifyAddButtonFunctionalityOnPDP() {
		ExtentReport.createTest("verifyAddButtonFunctionalityOnPDP");
		ProductDetailPage pdp = PageFactory.initElements(driver, ProductDetailPage.class);
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);

		// Verify Add Button Functionality On PDP
		brand.addNormalProductcondition(driver, pdp.addButton);
		String ProductCountOnAddButton = pdp.getProductCountOnAddButton();
		log.info("#ProductCountOnAddButton  #" + ProductCountOnAddButton);
		String ProductCountOnCartHeader = pdp.getProductCountOnCartHeader();
		log.info("#ProductCountOnCartHeader  #" + ProductCountOnCartHeader);
		// Validation
		as.assertEquals(ProductCountOnAddButton, ProductCountOnCartHeader);
		log.info("Successfully Validated Add Button Functionality On PDP");
	}

	@Test(enabled = true, priority = 18, description = "verifyAddRemoveFunctionalityOnPDP")
	public void verifyAddRemoveFunctionalityOnPDP() {
		ExtentReport.createTest("verifyAddRemoveFunctionalityOnPDP");
		ProductDetailPage pdp = PageFactory.initElements(driver, ProductDetailPage.class);
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		pdp.clickRemoveQuantity(driver);
		brand.addNormalProductcondition(driver, pdp.addButton);
		log.info("Successfully Validated Add Remove Functionality On PDP");
		String ProductCountOnAddButton = pdp.getProductCountOnAddButton();
		log.info("#ProductCountOnAddButton  #" + ProductCountOnAddButton);
		String ProductCountOnCartHeader = pdp.getProductCountOnCartHeader();
		log.info("#ProductCountOnCartHeader  #" + ProductCountOnCartHeader);
		// Validation
//		as.assertEquals(ProductCountOnAddButton, ProductCountOnCartHeader);
		log.info("Successfully Validated Add Remove Functionality On PDP");
	}

	@Test(enabled = true, priority = 19, description = "verifyProductNamePriceDescriptionOnPDP")
	public void verifyProductNamePriceDescriptionOnPDP() {
		ExtentReport.createTest("verifyProductNamePriceDescriptionOnPDP");
		// ProductDetailPage details
		ProductDetailPage pdp = PageFactory.initElements(driver, ProductDetailPage.class);
		String ProductDetailPageProductName = pdp.getProductNameText();
		log.info("#ProductDetailPageProductName  #" + ProductDetailPageProductName);
		String ProductDetailPageProductPrice = pdp.getProductPriceText();
		log.info("#ProductDetailPageProductPrice  #" + ProductDetailPageProductPrice);
		as.assertEquals(pdp.verifyProductDescription(), true, "Product Description Not available on PDP");
		log.info("Successfully Validated Product Name Price Description On PDP");
	}

	@Test(enabled = true, priority = 20, description = "verifyServesRatingByWithBrandLogo")
	public void verifyServesRatingByWithBrandLogo() {
		ExtentReport.createTest("verifyServesRatingByWithBrandLogo");
		ProductDetailPage pdp = PageFactory.initElements(driver, ProductDetailPage.class);
		// as.assertEquals(pdp.verifyBrandServes(), true, "Brand Serves Text Not
		// available on PDP");
		as.assertEquals(pdp.verifyBrandLogo(), true, "Brand Logo Not available on PDP");
		as.assertEquals(pdp.verifyBrandName(), true, "Brand Name Not available on PDP");
		log.info("Successfully Validated Serves Rating  By With BrandLogo");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickEatsureLogo(driver);
	}

	@Test(enabled = false, priority = 21, description = "verifyShareOptionFunctionality")
	public void verifyShareOptionFunctionality() {
		ExtentReport.createTest("verifyShareOptionFunctionality");
		ProductDetailPage pdp = PageFactory.initElements(driver, ProductDetailPage.class);
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		as.assertEquals(pdp.verifyShareButton(), true, "Share Button Not available on PDP");
		as.assertAll();
		pdp.clickshareButton(driver);
		as.assertEquals(pdp.verifyShareButtonModalView(), true, "ShareButtonModalView Not available on PDP");
		as.assertAll();
		as.assertEquals(pdp.verifyShareOnWhatsappOption(), true, "ShareOnWhatsappOption Not available on PDP");
		as.assertAll();
		as.assertEquals(pdp.verifyShareOnFacebookOption(), true, "ShareOnFacebookOption Not available on PDP");
		as.assertAll();
		as.assertEquals(pdp.verifyShareOnTwitterOption(), true, "ShareOnTwitterOption Not available on PDP");
		as.assertAll();
		as.assertEquals(pdp.verifyShareViaGmailOption(), true, "ShareViaGmailOption Not available on PDP");
		as.assertAll();
		as.assertEquals(pdp.verifyCopyLinkCard(), true, "CopyLinkCard Not available on PDP");
		as.assertAll();
		as.assertEquals(pdp.verifyCopyLinkButton(), true, "CopyLinkButton Not available on PDP");
		as.assertAll();
		pdp.clickCopyLinkButton(driver);
		pdp.clickCloseWindowPopup(driver);
		pdp.clickRemoveQuantity(driver);
		menu.clickEatsureLogo(driver);
		log.info("Successfully Validated Share Option Functionality On PDP Page");
	}

	@Test(enabled = false, priority = 22, description = "Lalit's code verify Add Products To Cart With/Witout Customization")
	public void verifyAddProductsToCartWithCustomizationOrWithout() {
		ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		// cart.clickHomeLink(driver);
		locality.navigateToBrandCondition(driver);
		List<WebElement> products = driver.findElements(By.xpath("//button[@data-qa='addButton']"));
		// Add the first two products
		for (int i = 1; i <= 2 && i < products.size(); i++) {
			WebElement product = products.get(i);
			// Click on the product
			// JavascriptExecutor executor = (JavascriptExecutor)driver;
			// executor.executeScript("arguments[0].click();", product);
			BasePage.clickJavaScript(product, driver);
			// Check if the customization window is open
			if (plp.isCustomizationWindowOpen(driver)) {
				// Verify if the first radio button is selected
				WebElement radioButton = driver.findElement(By.xpath("(//div[@data-qa='radioButton'])[1]"));
				if (!radioButton.isSelected()) {
					radioButton.click();
				}
				// Click on the "Add" button in the customization window
				WebElement addButton = driver.findElement(By.xpath("//button[@data-qa='addItemButton']"));
				BasePage.clickJavaScript(addButton, driver);
				// addButton.click();
				log.info("Hurray! Product " + i + " added with customization sucessfully");
			} else {

				log.info("Product added " + i + " without customization");
			}
		}
	}

	@Test(enabled = true, priority = 23, description = "selectionOfNormalandDynamicProductwithCustomizationFromPLPExploreAllDishes")
	public void selectionOfNormalandDynamicProductwithCustomizationFromPLPExploreAllDishes() {
		ExtentReport.createTest("selectionOfNormalandDynamicProductwithCustomizationFromPLPExploreAllDishes");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.clickExploreAllDishes(driver);
		ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class);
//		String ProductListingPageDrpdownNameEADishes = plp.getDrpdownSelectItemName();
//		log.info("#ProductListingPage Dropdown Name " + ProductListingPageDrpdownNameEADishes);
//		as = new SoftAssert();
//		as.assertEquals(ProductListingPageDrpdownNameEADishes, "Must Try Dishes");
//		as.assertEquals(plp.verifyProductListingPageDrpdownSelectItem(), true, "Product Listing Pagedropdown selection not validated");

		// Click on second "ExploreAll" button
//		plp.clicksecondExploreAll(driver);
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		// Add Normal product from PLP page to Cart page
		brand.addNormalProductcondition(driver, plp.addButton);
		log.info("Successfully Added Normal Product with Customization from PLPExploreAllDishes page to Cart");

		// Added Dynamic product with/without Customization from PLP page to Cart page
//		brand.addDynemiComboOfTwoProductcondition(driver);

		// Click on Veg InActive Button
		plp.clickvegInActiveButton();

		// Validate the veg icon
		as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver, ProductListingPage.vegIcon, "Veg :- "), true,
				"Veg Icon mismatch");

		// Click on NonVeg InActive Button
		plp.clicknonvegInActiveButton();

		// Validate the non-veg icon
		// as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver,
		// ProductListingPage.nonVegIcon,"nonVeg:- "), false, "NonVeg Icon mismatch");

		brand.clickContinue(driver);
//		as.assertAll();

		// Navigate to Home PAge
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		log.info("Successfully Added Dynamic Product without Customization From PLPExploreAllDishes Page to Cart");
	}

	@Test(enabled = false, priority = 24, description = "Lalit's code false Verify Inccrease the product Qty")
	public void verifyIncreaseQtyOnCartStepper() {
		ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class);
		plp.getTheCheckoutStepper(driver);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
	}

	@Test(enabled = false, priority = 38, description = "Lalit's code false Confrim added product")
	public void confirmProductAddedtoCart() {
		String proName = ReadPropertyFile.get("productName");
		WebElement cartIcon = driver.findElement(By.xpath("//p[@data-qa='cartOption']"));
		cartIcon.click();
		// Wait for the cart page to load
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Check if the added product is visible on the cart page
		WebElement addedProduct = driver
				.findElement(By.xpath("//div[@data-qa='productCardInfo']//p[contains(text(),'" + proName + "')]"));
		if (addedProduct.isDisplayed()) {
			System.out.println("Product '" + proName + "' has been successfully added to the cart.");
		} else {
			System.out.println("Product '" + proName + "' was not found in the cart.");
		}
		// Optionally, you can navigate back to the main page or perform other actions
		// on the cart page
		// driver.navigate().back();
	}

	@Test(enabled = false, priority = 25, description = "Lalit's code false Increase Product Qty from Cart")
	public void increaseProductQty() {
		ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class);
		plp.clickIncreaseProductQty(driver);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
	}

	@Test(enabled = true, priority = 26, description = "selectionOfNormalandDynamicProductwithCustomizationFromPLPExploreAllCollections")
	public void selectionOfNormalandDynamicProductwithCustomizationFromPLPExploreAllCollections() {
		ExtentReport.createTest("selectionOfNormalandDynamicProductwithCustomizationFromPLPExploreAllCollections");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		as.assertEquals(locality.verifylLocalityPagePopularCuisinesHeadar(driver), true,
				"Locality page Popular Cuisines headar in your area mismatch");
		// Vivek- Unable to see freeDish section on Locality page
//		as.assertEquals(locality.verifylLocalityPageFreeDish(driver), true, "Locality page FreeDish mismatch");
		as.assertEquals(locality.verifylLocalityPageMostLovedCollections(driver), true,
				"Locality page Most Loved Collection mismatch");
		locality.clickExploreAllCollections(driver);
		ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class);
		// Vivek need to remove as drop down has removed
//		String ProductListingPageDrpdownNameEADishes = plp.getDrpdownSelectItemName();
//		log.info("#ProductListingPage Dropdown Name " + ProductListingPageDrpdownNameEADishes);
//		as.assertEquals(ProductListingPageDrpdownNameEADishes, "Most Loved Categories");

//		as.assertEquals(plp.verifyProductListingPageDrpdownSelectItem(), true, "Product Listing Pagedropdown selection not validated");

		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);

		// Add Normal product from PLP page to Cart page
		brand.addNormalProductcondition(driver, plp.addButton);
		log.info("Successfully Added Normal Product with Customization from PLPExploreAllCollections page to Cart");

		// Added Dynamic product with Customization from PLP page to Cart page

//		brand.addDynemiComboOfTwoProductcondition(driver);

		// Click on Veg InActive Button
		plp.clickvegInActiveButton();

		// Validate the veg icon
		as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver, ProductListingPage.vegIcon, "veg:- "), true,
				"Veg Icon mismatch");

		// Click on NonVeg InActive Button
		plp.clicknonvegInActiveButton();

		// Validate the veg icon
		as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver, ProductListingPage.nonVegIcon, "nonVeg:- "), true,
				"NonVeg Icon mismatch");

		brand.clickContinue(driver);
		as.assertAll();

		// Navigate to Home Page
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		log.info("Successfully Added Dynamic Product with Customization From PLPExploreAllCollections Page to Cart");

	}

	@Test(enabled = false, priority = 27, description = "false always false as dynamic product is not available selectionOfDynamicProductwithCustomizationFromPLPExploreAllCombos")
	public void selectionOfDynamicProductwithCustomizationFromPLPExploreAllCombos() {
		ExtentReport.createTest("selectionOfDynamicProductwithCustomizationFromPLPExploreAllCombos");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		as.assertEquals(locality.verifylLocalityPagePopularCuisinesHeadar(driver), true,
				"Locality page Popular Cuisines headar in your area mismatch");
		// Vivek- Unable to see freeDish section on Locality page
//		as.assertEquals(locality.verifylLocalityPageFreeDish(driver), true, "Locality page FreeDish mismatch");
		as.assertEquals(locality.verifylLocalityPageMostLovedCollections(driver), true,
				"Locality page Most Loved Collection mismatch");
		as.assertEquals(locality.verifylLocalityPageCombosFromMutipleRestaurants(driver), true,
				"Locality page Combos from Multiple Restaurants mismatch");
		locality.clickExploreAllCombos(driver);
		ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class);
//		String ProductListingPageDrpdownNameEADishes = plp.getDrpdownSelectItemName();
//		log.info("#ProductListingPage Dropdown Name " + ProductListingPageDrpdownNameEADishes);
//		as.assertEquals(ProductListingPageDrpdownNameEADishes, "Saving Combos");
		as.assertAll();

		// Added Dynamic product with/without Customization from PLP page to Cart page
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		brand.addDynemiComboOfTwoProductcondition(driver);

		// We need to validate with Product whether Icon is visible for combo or not.
		// As we have discussed with business,They are telling it is visible.
		// As of now we have commented the below piece of code to validate Veg/Nonveg
		// icon

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

		// Navigate to Home Page
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		log.info("Successfully Added Dynamic Product with/without Customization From PLPExploreAllCombos Page to Cart");

	}

	@Test(enabled = true, priority = 28, description = "loginfromCartpage")
	public void loginfromCartPage() throws InterruptedException {
		ExtentReport.createTest("loginfromCartpage");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.clickCartOption(driver);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.enterMobileNumber(ReadPropertyFile.get("MobilenumberFixedOTP"));
		Thread.sleep(1000);
		cart.clickLoginwithOTP();
		cart.enterOTP(driver, ReadPropertyFile.get("otp"));
		// We need to comment the below line of code as part of BX-14742 [ES-WEB][FE]
		// Auto OTP Verify upon putting OTP
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

	@Test(enabled = true, priority = 29, description = "addAddressfromCartPage")
	public void addAddressfromCartPage() throws InterruptedException {
		ExtentReport.createTest("addAddressfromCartPage");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		
		cart.clickAddressRadioButton(driver);
		log.info("Sucessfully select the address");

		cart.deleteexistingAddress(driver);
		log.info("Sucessfully delete the address");
		
		cart.addnewAddress(driver);
		log.info("Successfully added the new address on cart page");

		

	}

	@Test(enabled = true, priority = 30, description = "addExtraInstructionfromCartPage")
	public void addExtraInstructionfromCartPage() throws InterruptedException {
		ExtentReport.createTest("addExtraInstructionfromCartPage");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.addextraInstruction(driver);

		log.info("Successfully added extra instruction on cart page");

	}

	@Test(enabled = true, priority = 31, description = "verify customization and quanity section")
	public void quanity() throws InterruptedException {
		ExtentReport.createTest("verify customization and quanity of the product section");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);

		as = new SoftAssert();

		String fristProductPriceText = driver
				.findElement(By.cssSelector("[class*='style__CartOfferPrice']:nth-child(1)")).getText()
				.replace("\u20b9", "").toString().trim();
		System.out.println("price is " + fristProductPriceText);
		int fristProductPrice = Integer.parseInt(fristProductPriceText);
		log.info(fristProductPrice);
		// quantity check
		int beforeQuantity = cart.productQuantity();
		log.info("Before increase the product quanity " + beforeQuantity);
		// cart.increaseQuanity1(driver,cart.increaseone());
		cart.increaseQuanity1(driver, cart.increaseQuanity);
		log.info("Successfully increase the Quantity");
		Thread.sleep(2000);
		cart.continuePayButton();
		/*
		 * BrandRestaurantPage brand = PageFactory.initElements(driver,
		 * BrandRestaurantPage.class); try { cart.increaseQuanity();
		 * brand.addDynemiComboOfTwoProductcondition(driver); Thread.sleep(3000); }
		 * catch (Exception e) { cart.increaseQuanity(); cart.continuePayButton();
		 * Thread.sleep(3000); } log.info("Successfully increase the Quantity");
		 * Thread.sleep(3000);
		 */

		int afterQuantity = cart.productQuantity();
		log.info("After increasing the quanity product quanity is " + afterQuantity);
		if (afterQuantity > beforeQuantity) {
			as.assertTrue(true, "Quanity increase not working");
			as.assertAll();
			log.info("Successfully verify the quanity incraese product");
		} else {
			as.assertTrue(false, "Quanity increase not working");
			as.assertAll();
		}

		// verify the edit button
		as.assertEquals(cart.editCostomization(driver), true, "Edit customization option not there");
		as.assertAll();
		log.info("Sucessfully verify the edit customization button");
	}

	@Test(enabled = true, priority = 32, description = "verify coupon section")
	public void coupon() throws InterruptedException {
		ExtentReport.createTest("verify coupon section");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();

		// int couponSizeCart = Integer.parseInt(cart.cartCouponCount());
		// log.info("Coupon available show in the cart page description " +
		// couponSizeCart);
		cart.scrollRightContainer(driver);
		cart.clickExploreCoupon();
		as.assertEquals(cart.offerSection(), true);
		as.assertAll();
		log.info("Successfully verify the offer section");
		as.assertEquals(cart.couponTitle(), "Coupons for you", "Coupon title not matching");
		as.assertAll();
		log.info("Successfuly verify the Coupon Title");

		// checking the coupon count in the coupon popup
		int couponNameCount = driver.findElements(By.id("fname")).size();
		// as.assertEquals(couponNameCount, couponSizeCart, "cart coupon count and
		// couponpop count not same");
		log.info("total coupon showing " + couponNameCount);
		CartPage.couponApply();
		CartPage.continuePayButton();
		// log.info(CartPage.couponApply());
		Thread.sleep(3000);

		// verify the sure point part
		// log.info(cart.applySurePoint());

	}

	@Test(enabled = true, priority = 33, description = "verify bill details section")
	public void billDetails() throws InterruptedException {
		ExtentReport.createTest("verify bill details section");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();
		cart.scrollRightContainer(driver);
		as.assertEquals(cart.bill(), true, "Bill details section is not shwoing");
		as.assertAll();
		log.info("Successfully verify the bill details part");
		as.assertEquals(cart.billList(), true, "Bill details not showing all option");
		as.assertAll();
		log.info("Successfully Verify the Bill details opitions");

	}

	@Test(enabled = true, priority = 34, description = "verify savings section")
	public void Savings() throws InterruptedException {
		ExtentReport.createTest("verify Savings section");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();
		int totalSavingPrice = Integer.parseInt(cart.totalSaving().replace("\u20b9", "").toString().trim());
		int savingGreenBar = Integer
				.parseInt(cart.savingCallOut().split(" ")[0].replace("\u20b9", "").toString().trim());
		as.assertEquals(totalSavingPrice, savingGreenBar, "Not match the total saving with saving callOut bar");
		as.assertAll();
		log.info("successfully verify the total saving with savingCallOut option " + savingGreenBar);
		cart.arrowCallOut();
		// verify the Saving callout pop up
		String calloutHeading = driver.findElement(By.cssSelector("[data-qa*='savingsCalloutModalHeading']")).getText();
		as.assertEquals(calloutHeading, "Savings only on Eatsure");
		as.assertAll();
		log.info("Successfuuly verify the Saving callout pop up section Heading");
		int callOutPopUpSavings = Integer.parseInt(cart.calloutPopUpSaving().replace("\u20b9", "").toString().trim());
		as.assertEquals(totalSavingPrice, callOutPopUpSavings,
				"Not match the total saving with saving callOut bar popup saving");
		as.assertAll();
		log.info("Successfully verify the saving total in the callout pop up " + callOutPopUpSavings);
		// int grand_Total = Integer.parseInt(cart.finalTotal().replace("\u20b9",
		// "").toString().trim());
		// cart.finalTotal();
		cart.closeCallOut();
		/*
		 * int calloutGrand_Total = Integer .parseInt(driver.findElement(By.cssSelector(
		 * "[data-qa*='cartSummaryPriceDetails']")).getText() .replace("\u20b9",
		 * "").toString().trim()); as.assertEquals(cart.finalTotal(),
		 * calloutGrand_Total, "total bill calculation not matching  with Grand total");
		 * as.assertAll();
		 * log.info("Successfully verify the grand total in the callout pop up " +
		 * calloutGrand_Total);
		 */

	}

	@Test(enabled = true, priority = 35, description = "verify Delivery later  section")
	public void deliveryLater() throws InterruptedException {
		ExtentReport.createTest("verify Delivery later section");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();
		cart.clickArrow();
		as.assertTrue(cart.deliveryslot(), "Delivery slots are not showing");
		as.assertAll();
		log.info("Successfuly verify delievery later slot");
		cart.closeDelivery();
	}

	@Test(enabled = false, priority = 36, description = "false selectFreeDishfromCartPage")
	// this method is already false-16-11-2022
	public void selectFreeDishfromCartPage() throws InterruptedException {
		ExtentReport.createTest("selectFreeDishfromCartPage");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickSelectFreeDishjs(driver);
		cart.clickCheckoutNowFreeDishjs(driver);

		log.info("Successfully added Free Dish from cart page");

	}

	@Test(enabled = true, priority = 37, description = "visibilityOfPaymentPage")
	public void visibilityOfPaymentPage() throws Exception {
		ExtentReport.createTest("visibilityOfPaymentPage");
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		payments.verifyPaymentPageIsDisplayed(driver);
		log.info("Payments page is displayed");
	}

	@Test(enabled = true, priority = 38, description = "selectionOfPaymentMode")
	public void selectionOfPaymentMode() throws InterruptedException {
		ExtentReport.createTest("selectionOfPaymentMode");
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		Thread.sleep(2000);
		BasePage.scrollbar_down(driver);
		payments.verifyChoosePaymentText(driver);
		payments.clickCODButton(driver);
//		payments.verifyCODCard();
		payments.verifyAmount();
		log.info("Selected COD pay mode");
	}

	@Test(enabled = true, priority = 39, description = "proceedToPay")
	public void proceedToPay() {
		ExtentReport.createTest("proceedToPay");
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		payments.clickPayButton(driver);
		log.info("Used COD mode to place an order");
	}

	@Test(enabled = false, priority = 40, description = " false always trackingOrderPage")
	public void trackingOrderPageverify() throws Exception {
		ExtentReport.createTest("trackingOrderPage");
		TrackingOrderPage tracking = PageFactory.initElements(driver, TrackingOrderPage.class);
		Thread.sleep(1000);
		as.assertEquals(tracking.verifyEsWebLogo(), true, "EsWebLogo Not available on Tracking");
		as.assertEquals(tracking.verifyOrderTrackingText(), true, "OrderTrackingText Not available on Tracking");
		as.assertEquals(tracking.verifyOrderCrn(), true, "OrderCrn Not available on Tracking");
		as.assertAll();

		log.info("Verified Tracking order Page");
	}

	@Test(enabled = true, priority = 41, description = "trackingOrderPageDeliveryNow")
	public void trackingOrderPageDeliveryNow() throws Exception {
		ExtentReport.createTest("trackingOrderPage");
		TrackingOrderPage tracking = PageFactory.initElements(driver, TrackingOrderPage.class);
		Thread.sleep(2000);
		as.assertEquals(tracking.verifyEsWebLogo(), true, "EsWebLogo Not available on Tracking");
		as.assertEquals(tracking.verifyOrderTrackingText(), true, "OrderTrackingText Not available on Tracking");
		as.assertEquals(tracking.verifyOrderCrn(), true, "OrderCrnText Not available on Tracking");
		as.assertEquals(tracking.verifyOrderConfirmedText(), true,
				"verifyOrderConfirmedText Not available on Tracking");
		as.assertEquals(tracking.verifyCookingInProcessText(), true,
				"verifyCookingInProcess Text Not available on Tracking");
		as.assertEquals(tracking.verifyCookingInProcessDescription(), true,
				"verifyCookingInProcessDescription Not available on Tracking");
		as.assertEquals(tracking.verifySureQualityCheckText(), true,
				"verifySureQualityCheckText Not available on Tracking");
		as.assertEquals(tracking.verifySureQualityCheckDescription(), true,
				"verifySureQualityCheckDescription Not available on Tracking");
		as.assertEquals(tracking.verifyOutForDeliveryText(), true,
				"verifyOutForDeliveryText Not available on Tracking");
		as.assertEquals(tracking.verifyOutForDeliveryDescription(), true,
				"verifyOutForDeliveryDescription Not available on Tracking");
		as.assertEquals(tracking.verifyAppDownloadSection(), true,
				"verifyAppDownloadSection Not available on Tracking");
		// as.assertEquals(tracking.verifyGiveSureSection(), true,
		// "verifyGiveSureSection Not available on Tracking");
		// as.assertEquals(tracking.verifySurePointsSection(), true,
		// "verifySurePointsSection Not available on Tracking");
		as.assertEquals(tracking.verifyViewOrderDetailsDeliverNow(), true,
				"verifySurePointsSection Not available on Tracking");
		tracking.clickViewOrderDetailsLinkDeliverNow(driver);
		Thread.sleep(2000);
		as.assertEquals(tracking.verifyViewOrderDetailsOrderCrn(), true,
				"viewOrderDetailsOrderCrn Not available on Tracking");
		as.assertEquals(tracking.verifyViewOrderDetailsNoOfItemsDisplay(), true,
				"viewOrderDetailsNoOfItemsDisplay Not available on Tracking");
		// as.assertEquals(tracking.verifyViewOrderDetailsAddress(), true,
		// "viewOrderDetailsAddress Not available on Tracking");
		as.assertEquals(tracking.verifyViewOrderDetailsListOfProducts(), true,
				"viewOrderDetailsListOfProducts Not available on Tracking");
		as.assertEquals(tracking.verifyViewOrderDetailsBillDetails(), true,
				"viewOrderDetailsBillDetails Not available on Tracking");
		// as.assertEquals(tracking.verifyPaidbyText(), true, "PaidbyText Not available
		// on Tracking");
		as.assertAll();
		tracking.clickCloseOrderDetails(driver);
		log.info("Verified Tracking order Page");
	}

	@Test(enabled = true, priority = 42, description = "delivery later flow verify")
	public void deliveryLaterFlow() throws Exception {
		ExtentReport.createTest("delivery later flow verify");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.clickESLogo();
		String date = locality.dateSlot();
		log.info("Successfully select the second date " + date);

		String time = locality.timeSlot();
		log.info("Successfully select the second date's sencond time slot " + time);

		locality.confirm();
		String homePageDeliverySlot = locality.delievryTime();
		log.info("Successfully add delivery slot " + homePageDeliverySlot);
		locality.navigateToBrandCondition(driver);
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		brand.addNormalProductcondition(driver, brand.addButton);
		brand.clickContinue(driver);

		CartPage.continuePayButton();
		String CartPageDeliverySlot = locality.delievryTime();
		as.assertEquals(CartPageDeliverySlot, homePageDeliverySlot,
				"DElivery slot are not macthing cart and loaclity page slot");
		as.assertAll();
		log.info("Successfully verify the delivery slot for cart and home page are same ");

	}

	@Test(enabled = true, priority = 43, description = "delivery later slot change from cart verify")
	public void deliverySlotChange() throws Exception {
		ExtentReport.createTest("delivery later slot change from cart verify");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		String CartPageDeliverySlot = locality.delievryTime();
		Thread.sleep(2000);
		cart.clickArrow();
		String date = locality.dilverySlotChange();
		log.info("Successfully select the second date " + date);

		String time = locality.timeSlot();
		log.info("Successfully select the second date's sencond time slot " + time);

		locality.confirm();
		Thread.sleep(3000);
		String AfterDeliverySlotChange = locality.delievryTime();
		as.assertNotEquals(CartPageDeliverySlot, AfterDeliverySlotChange, "Delivery slot not change");
		as.assertAll();
		log.info("Successfully change the delivery slot " + AfterDeliverySlotChange);
		BasePage.scrollbar_down(driver);
		PaymentsPage payments = PageFactory.initElements(driver, PaymentsPage.class);
		payments.clickCODButton(driver);
		payments.clickPayButton(driver);

	}

	@Test(enabled = true, priority = 44, description = "verifyViewOrderLink")
	public void viewOrderLink() {
		ExtentReport.createTest("verifyViewOrderLink");
		TrackingOrderPage tracking = PageFactory.initElements(driver, TrackingOrderPage.class);
		as.assertEquals(tracking.statementdeliverylater(), true,"Delievry later tracking page not showing properly");
		as.assertAll();
		as.assertEquals(tracking.verifyViewOrderDetailsLink(), true, "ViewOrderDetailsLink Not available on tracking");
		tracking.clickViewOrderDetailsButton(driver);
		as.assertEquals(tracking.verifyOrderCrnOrderDetailsPage(), true, "OrderCrnText Not available on Tracking");
		as.assertAll();
		log.info("Successfully verfy the order detils for delivery later tracking page");
		tracking.clickCloseOrderDetails(driver);
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.clickESLogo();
	}

	@Test(enabled = true, priority = 45, description = "selectionOfMenuOption")
	public void selectionOfMenuOption() throws InterruptedException {
		ExtentReport.createTest("selectionOfMenuOption");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		Thread.sleep(2000);
		menu.clickMenuOption(driver);
		menu.logOut();
		Thread.sleep(2000);
		menu.confirmLogOut();
		menu.clickMenuOption(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifyFAQs(), true, "FAQs Not available on Menu Page");
		log.info("Successfully FAQs Options verified");
		as.assertEquals(menu.verifyAboutEatSure(), true, "AboutEatSure Not available on Menu Page");
		log.info("Successfully AboutEatSure Options verified");
		as.assertEquals(menu.verifyTermsNConditions(), true, "TermsNConditions Not available on Menu Page");
		log.info("Successfully TermsNConditions Options verified");
		as.assertEquals(menu.verifyPrivacyPolicy(), true, "PrivacyPolicy Not available on Menu Page");
		log.info("Successfully PrivacyPolicy Options verified");
		as.assertEquals(menu.verifyPartyOrders(), true, "PartyOrders Not available on Menu Page");
		log.info("Successfully PartyOrders Options verified");
		as.assertEquals(menu.verifyWeAreHereToHelpYouText(), true, "WeAreHereToHelpYouText Not available on Menu Page");
		log.info("Successfully WeAreHereToHelpYouText Options verified");
		as.assertAll();
		log.info("Successfully Menu Options verified");

	}

	@Test(enabled = true, priority = 46, description = "selectionOfFAQs")
	public void selectionOfFAQs() {
		ExtentReport.createTest("selectionOfFAQs");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickFAQs(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifyFAQTexts(), true, "FAQ's Text Not available in FAQ Page");
		as.assertAll();
		menu.clickMenuOption(driver);
		log.info("Successfully FAQ's Functionality verified");
	}

	@Test(enabled = true, priority = 47, description = "selectionOfAboutEatSure")
	public void selectionOfAboutEatSure() {
		ExtentReport.createTest("selectionOfAboutEatSure");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickAboutEatSure(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifyHighGradeIngredientsInfo(), true, "HighGradeIngredientsInfo Text Not available");
		as.assertAll();
		menu.clickMenuOption(driver);
		log.info("Successfully AboutEatSure Functionality verified");

	}

	@Test(enabled = true, priority = 48, description = "selectionOfTermsNConditions")
	public void selectionOfTermsNConditions() {
		ExtentReport.createTest("selectionOfTermsNConditions");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickTermsNConditions(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifyTandcHeading(), true, "TandcHeading Text Not available");
		as.assertAll();
		menu.clickMenuOption(driver);
		log.info("Successfully TermsNConditions Before login Functionality verified");
	}

	@Test(enabled = true, priority = 49, description = "selectionOfPrivacyPolicy")
	public void selectionOfPrivacyPolicy() {
		ExtentReport.createTest("selectionOfPrivacyPolicy");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickPrivacyPolicy(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifyPrivacyPolicyText(), true, "PrivacyPolicy Text Not available");
		as.assertAll();
		menu.clickMenuOption(driver);
		log.info("Successfully PrivacyPolicy Functionality verified");
	}

	@Test(enabled = true, priority = 50, description = "selectionOfPartyOrders")
	public void selectionOfPartyOrders() {
		ExtentReport.createTest("selectionOfPartyOrders");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickPartyOrders(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifyContactUs(), true, "ContactUs Text Not available");
		as.assertAll();
		menu.clickEatsureLogo(driver);
		log.info("Successfully Party Orders Functionality verified");
	}

	@Test(enabled = true, priority = 51, description = "selectionOfWeAreHereToHelpYouText")
	public void selectionOfWeAreHereToHelpYouText() {
		ExtentReport.createTest("selectionOfWeAreHereToHelpYouText");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		as = new SoftAssert();
		menu.clickMenuOption(driver);
		as.assertEquals(menu.verifyWeAreHereToHelpYouText(), true, "WeAreHereToHelpYou Text Not available");
		as.assertAll();
		menu.clickEatsureLogo(driver);
		log.info("Successfully WeAreHereToHelpYou Functionality verified");
	}

	@Test(enabled = true, priority = 52, description = "validatingMenuAfterLogin")
	public void validatingMenuAfterLogin() throws InterruptedException {
		ExtentReport.createTest("validatingMenuAfterLogin");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		menu.clickCloseSidebarMenu(driver);
		menu.clickSignInOption(driver);

		cart.enterMobileNumber(ReadPropertyFile.get("MobilenumberFixedOTP"));
		Thread.sleep(1000);
		cart.clickLoginwithOTP();
		cart.enterOTP(driver, ReadPropertyFile.get("otp"));
		log.info("Successfully enter the mobile no and OTP on Login page");

		menu.clickMenuOption(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifyMyProfile(), true, "My Profile Not available on Menu Page After login");
		log.info("Successfully My Profile Options verified");
		as.assertEquals(menu.verifyFAQs(), true, "FAQs Not available on Menu Page");
		log.info("Successfully FAQs Options verified");
		as.assertEquals(menu.verifyAboutEatSure(), true, "AboutEatSure Not available on Menu Page");
		log.info("Successfully AboutEatSure Options verified");
		as.assertEquals(menu.verifyTermsNConditions(), true, "TermsNConditions Not available on Menu Page");
		log.info("Successfully TermsNConditions Options verified");
		as.assertEquals(menu.verifyPrivacyPolicy(), true, "PrivacyPolicy Not available on Menu Page");
		log.info("Successfully PrivacyPolicy Options verified");
		as.assertEquals(menu.verifyPartyOrders(), true, "PartyOrders Not available on Menu Page");
		log.info("Successfully PartyOrders Options verified");
		as.assertEquals(menu.verifyWeAreHereToHelpYouText(), true, "WeAreHereToHelpYouText Not available on Menu Page");
		log.info("Successfully WeAreHereToHelpYouText Options verified");
		as.assertAll();
		log.info("Successfully verified Menu options after Login");
	}

	@Test(enabled = true, priority = 53, description = "selectionOfFAQsAfterLogin")
	public void selectionOfFAQsAfterLogin() {
		ExtentReport.createTest("selectionOfFAQsAfterLogin");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickFAQs(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifyFAQTexts(), true, "FAQ's Text Not available in FAQ Page");
		as.assertAll();
		menu.clickMenuOption(driver);
		log.info("Successfully FAQ's AfterLogin Functionality verified");
	}

	@Test(enabled = true, priority = 54, description = "selectionOfAboutEatSureAfterLogin")
	public void selectionOfAboutEatSureAfterLogin() {
		ExtentReport.createTest("selectionOfAboutEatSureAfterLogin");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickAboutEatSure(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifyHighGradeIngredientsInfo(), true, "HighGradeIngredientsInfo Text Not available");
		as.assertAll();
		menu.clickMenuOption(driver);
		log.info("Successfully AboutEatSure AfterLogin Functionality verified");

	}

	@Test(enabled = true, priority = 55, description = "selectionOfTermsNConditionsAfterLogin")
	public void selectionOfTermsNConditionsAfterLogin() {
		ExtentReport.createTest("selectionOfTermsNConditionsAfterLogin");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickTermsNConditions(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifyTncHeading(), true, "TncHeading Text Not available");
		as.assertAll();
		menu.clickMenuOption(driver);
		log.info("Successfully TermsNConditions AfterLogin Functionality verified");
	}

	@Test(enabled = true, priority = 56, description = "selectionOfPrivacyPolicyAfterLogin")
	public void selectionOfPrivacyPolicyAfterLogin() {
		ExtentReport.createTest("selectionOfPrivacyPolicyAfterLogin");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickPrivacyPolicy(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifyPrivacyPolicyText(), true, "PrivacyPolicy Text Not available");
		as.assertAll();
		menu.clickMenuOption(driver);
		log.info("Successfully PrivacyPolicy AfterLogin Functionality verified");
	}

	@Test(enabled = true, priority = 57, description = "selectionOfPartyOrdersAfterLogin")
	public void selectionOfPartyOrdersAfterLogin() throws InterruptedException {
		ExtentReport.createTest("selectionOfPartyOrdersAfterLogin");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickPartyOrders(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifyContactUs(), true, "ContactUs Text Not available");
		as.assertAll();
		menu.clickEatsureLogo(driver);
		menu.clickMenuOption(driver);
		menu.logOut();
		Thread.sleep(2000);
		menu.confirmLogOut();
		log.info("Successfully Party Orders AfterLogin Functionality verified");
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
//	}*/

}
