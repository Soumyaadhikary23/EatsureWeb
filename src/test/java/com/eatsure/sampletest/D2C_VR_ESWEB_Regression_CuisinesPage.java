/**
 * 
 */
package com.eatsure.sampletest;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eatsure.browser.Driver;
import com.eatsure.pom.BasePage;
import com.eatsure.pom.BrandRestaurantPage;
import com.eatsure.pom.LandingPage;
import com.eatsure.pom.LocalityPage;
import com.eatsure.pom.ProductListingPage;
import com.eatsure.reports.ExtentReport;
import com.eatsure.utils.ReadPropertyFile;
import com.eatsure.validation.ValidateTitle;

/**
 * Description : Created test cases for Cuisines Page
 * 
 * @author Lalit
 *
 */
public class D2C_VR_ESWEB_Regression_CuisinesPage extends BasePage {

	public static WebDriver driver;
	Driver driver1;
	SoftAssert as;
	Actions act;
	public static final Logger log = LogManager.getLogger(D2C_VR_ESWEB_Regression_CuisinesPage.class.getName());

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
		LandingPage landing = PageFactory.initElements(driver, LandingPage.class); //
		landing.enterLocation(Driver.prop.getProperty("location"));
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

	@Test(enabled = true, priority = 2, description = "verify Cuisines page content")
	public void verifyCuisinesPageContent() throws InterruptedException {

		ExtentReport.createTest("verify cuisines page content");
		as = new SoftAssert();
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class);

		locality.clickExploreAllDishes(driver);

//		as.assertEquals(locality.verifyCuisinesPagHeaderLogo(), true, "Cuisines page header EatsureLogo mismatch");
		as.assertEquals(locality.verifylLocalityPageOneSingleOrder(), true, "Cuisines page header text mismatch");
		as.assertEquals(plp.verifyCuisinesCategoryDropDownStrip(), true,
				"Cuisines page Category Drop-down Strip missing");
		as.assertEquals(plp.verifylCuisinesPageCuratedListOfDishesTitle(), true,
				"Cuisines page list of Dishes title mismatch");
		as.assertEquals(plp.verifyCuisinesAllCollectionSectionCount(driver), true, "Cuisines sections are missing");
		as.assertAll();
		log.info("Successfully validated Cuisines Page Content");

	}

	@Test(enabled = true, priority = 3, description = "verifying Curated dishes list and collection section list")
	public void verifyingCuratedDishesListAndCollectionSectionlist() {
		ExtentReport.createTest("verifying Curated dishes list and collection section list");
		as = new SoftAssert();
		ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class);
		//plp.clickOnCollectionFromSideBar(driver,ProductListingPage.collectionSideBarList);
		int curatedDishes = plp.getCuratedDishesCount(driver, ProductListingPage.curatedCuisinesCollectionList);
		int collectionSection = plp.getAllCollectionSectionCount();
		System.out.println("curated Dishes :"+curatedDishes);
		System.out.println("collection Section :"+collectionSection);
		as.assertEquals(curatedDishes, collectionSection, "Curated List and Colletion Section is mismatched");

		as.assertAll();
		log.info("Curated List and Colletion Section are matched");
	}

	@Test(enabled = true, priority = 4, description = "Adding Normal Product From Cuisines Page")
	public void verifyAddNormalItem() {
		ExtentReport.createTest("Adding Normal Product From Cuisines Page");
		ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class);
		plp.addNormatItem(driver);
		log.info("Successfully Added Normal Product from Cuisines Page");
	}

	@Test(enabled = true, priority = 5, description = "Increasing Normal Product Qty From Cuisines Page")
	public void verifyIncreaseNormalItemQty() {
		ExtentReport.createTest("Increasing Normal Product Qty From Cuisines Page");
		ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class);
		plp.clickIncreaseProductQty(driver);
		log.info("Successfully Increased Normal Product Qty from Cuisines Page");
	}

	@Test(enabled = true, priority = 6, description = "Adding Static Product with Customization From Cuisines Page")
	public void selectionOfStaticProductwithCustomizationFromCuisniesPage() {
		ExtentReport.createTest("Add Static Product with Customization From Cuisines Page");
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		brand.addFirstItem(driver);
		brand.clickAddItem();
		// brand.clickContinue(driver);
		log.info("Successfully Added Static Product with Customization from Cuisines Page");
	}

	@Test(enabled = true, priority = 7, description = "Adding Dynamic Product with Customization From Cuisines Page")
	public void selectionOfDynamicProductwithCustomizationFromCuisinesPage() {
		ExtentReport.createTest("Add Dynamic Product with Customization From Cuisines Page");
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		brand.addDynemiComboOfTwoProductcondition(driver);
		// brand.clickContinue(driver);
		log.info("Successfully Added Dynamic Product with Customization From Cuisines Page");
	}

	

	@Test(enabled = true, priority = 8, description = "verify Collection by Explore All Button From Cuisines Page")
	public void verifyCollectionByExploreAllFromCuisinesPage() {
		ExtentReport.createTest("verify Collection by Explore All Button From Cuisines Page");
		as = new SoftAssert();
		ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class);
		boolean sectionName = plp.verifylCollectionByExploreFromCuisinesPage();
		//plp.clickFirstSectionExploreAll(driver);
		plp.clickOnCuratedCetegory(driver);
		as.assertEquals(sectionName, true, "Collection Name mismatch");
		as.assertAll();
		log.info("Successfully navigated to a collection by click on Curated Dish");

	}

	@Test(enabled = true, priority = 9, description = "verify Sorting/filter functionality")
	public void verifySortFilterFunctionality() {
		try {
			ExtentReport.createTest("Verify Sorting/Filter functionality");
			as = new SoftAssert();
			ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class);

			// plp.clickOnSlickSliderFirstCaretgory(driver);

			List<WebElement> beforeSortPrice = driver
					.findElements(By.xpath("(//div[@id='plp_collection_3972'])[1]//div//p//div"));
			List<Double> beforeSortPriceList = new ArrayList<>();

			for (WebElement p : beforeSortPrice) {
				beforeSortPriceList.add(Double.valueOf(p.getText().replace("\u20b9", "").toString()));
				// plp.carouselNextArrow.click();
				System.out.println("Before Sorting Prices :" + beforeSortPriceList);
			}

			plp.clickSortFilterButton(driver);
			plp.selectSortingFilterOption(driver);
			plp.clickApplySortingFilter();

			List<WebElement> afterSortPrice = driver
					.findElements(By.xpath("(//div[@id='plp_collection_3972'])[1]//div//p//div"));
			List<Double> afterSortPriceList = new ArrayList<>();

			for (WebElement p : afterSortPrice) {
				afterSortPriceList.add(Double.valueOf(p.getText().replace("\u20b9", "").toString())); //
				System.out.println("After Sorting Prices : " + afterSortPriceList);
			}
			Collections.sort(beforeSortPriceList, Collections.reverseOrder());
			as.assertEquals(beforeSortPriceList, afterSortPriceList);

			as.assertAll();
			log.info("Successfully validated Sorted data");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(enabled = true, priority = 10, description = "verify Cuisines Veg/Non-Veg Filter")
	public void verifyCuisinesVegNonVegFilter() {
		try {
			ExtentReport.createTest("verify Cuisines Veg/Non-Veg Filter");
			as = new SoftAssert();
			ProductListingPage plp = PageFactory.initElements(driver, ProductListingPage.class); 
			plp.clickvegInActiveButton();
			
			// Validate the veg icon
			as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver, ProductListingPage.vegIcon, "Veg :- "), true,
					"Veg Icon mismatch");

			// Click on NonVeg InActive Button 
			plp.clicknonvegInActiveButton();

			as.assertAll();
			log.info("Sucessfully verified Cuisines page veg/non-veg filter");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
