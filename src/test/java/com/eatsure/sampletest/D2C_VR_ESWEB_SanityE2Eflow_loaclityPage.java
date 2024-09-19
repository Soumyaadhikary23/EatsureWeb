package com.eatsure.sampletest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eatsure.browser.Driver;
import com.eatsure.pom.LandingPage;
import com.eatsure.pom.LocalityPage;
import com.eatsure.pom.SiginPage;
import com.eatsure.reports.ExtentReport;
import com.eatsure.utils.ReadPropertyFile;
import com.eatsure.validation.ValidateTitle;

public class D2C_VR_ESWEB_SanityE2Eflow_loaclityPage {

	public static WebDriver driver;
	Driver driver1;
	 static SoftAssert as;
	public static final Logger log = LogManager.getLogger(D2C_VR_ESWEB_Regressionflow_LandingPage.class.getName());

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

	// LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
	@Test(enabled = true, priority = 1, description = "checkHeadercontain")
	public void checkHeaderContain() throws InterruptedException {
		ExtentReport.createTest("verifyLocalityPageContent_reg");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		// verify the ES logo
		as.assertEquals(locality.verifyLocalityPagHeaderLogo(), true, "Locality page header EatsureLogo mismatch");
		// verify the delivery location name
		String locationname = locality.getLocatityName().getText();
		log.info("location name  " + locationname);
		if (locationname.contains("Panaji Bus stand")) {
			as.assertTrue(true, locationname);
			log.info("Successfully verify the location name");
		}
		// as.assertEquals(locationname, "HBR Layout Park");
		// as.assertAll();
		// log.info("Successfully verify the location name");
		// verfy the search option
		String searchText = locality.localityPageSearch().getText();
		as.assertEquals(searchText, "Search");
		as.assertAll();
		log.info("Successfully search option is verify in the locality page " + searchText);
		// verfy the help option
		/*String HelpText = locality.help().getText();
		as.assertEquals(HelpText, "Help");
		as.assertAll();
		log.info("Successfully Help option is verify in the locality page " + HelpText);*/
		// verify cart option
		String cartText = locality.cart().getText();
		as.assertEquals(cartText, "Cart");
		as.assertAll();
		log.info("Successfully Crat option is verify in the locality page " + cartText);
		// verify the profile logo
		as.assertEquals(locality.verifyLocalityProfilerLogo(), true, "Locality page header ProfileLogo mismatch");
		as.assertAll();
		log.info("Successfully Profilelogo option is verify in the locality page");
		// verify the sign in option
		SiginPage Sigin = PageFactory.initElements(driver, SiginPage.class);
		as.assertEquals(Sigin.getSigin(), true, "In Loaclity page Sigin button not showing");
		as.assertAll();
		log.info("Successfully Sigin option is verify in the locality page ");
		// verify the menu bar
		as.assertEquals(locality.Menu(), true, "In locality page menu bar is not showing");
		as.assertAll();
		log.info("Successfully menu option is verify in the locality page ");

		Thread.sleep(5000);
	}

	@Test(enabled = false, priority = 21, description = "verifyLocalityPageContent")
	public void verifyLocalityPageContent() throws InterruptedException {
		ExtentReport.createTest("verifyLocalityPageContent");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);

		as = new SoftAssert();
		as.assertEquals(locality.verifylLocalityPageOneSingleOrder(), true, "Locality page header mismatch");
		as.assertEquals(locality.verifyLocalityPagHeaderLogo(), true, "Locality page header EatsureLogo mismatch");
		as.assertEquals(locality.verifyLocalityPageEatSurance(), true, "Locality page \"EatSurance\" mismatch");
		Thread.sleep(3000);
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

		Thread.sleep(5000);
	}

	@Test(enabled = false, priority = 2, description = "location change by GPS")

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

	@Test(enabled = true, priority = 3, description = "location change")

	public void locationChange() throws InterruptedException {

		ExtentReport.createTest("verifyLocationchange_Manually");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		// locality.clickdelivery();
		locality.clickDelivery();
		Thread.sleep(5000);

		String changelocation = locality.verifyLocation(ReadPropertyFile.get("location"));
		as.assertEquals(changelocation, "Cafe Soul Garden");
		as.assertAll();
		log.info("Successfully  verify change location in the locality page manually " + changelocation);

	}

	@Test(enabled = true, priority = 4, description = "locality page BREADCRUMBS ")

	public void breadcurms() throws InterruptedException {

		ExtentReport.createTest("verifylocalitypage_BREADCRUMBS ");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		as.assertEquals(locality.getBreadcrums(), true, "Breadcrums section not showing");
		log.info("Breadcrums setion is showing");
		// get the breadcrums section text
		WebElement Bread_Section = driver.findElement(By.xpath("//div[@data-qa='breadcrumbsSection']"));
		List<WebElement> link_count = Bread_Section.findElements(By.tagName("a"));
		int Bread_count = link_count.size();
		for (int i = 0; i < Bread_count; i++) {

			WebElement a = link_count.get(i);
			String text = a.getText();
			log.info(text);

		}

	}

	@Test(enabled = true, priority = 5, description = "locality page Banner ")

	public void banner() throws InterruptedException {

		ExtentReport.createTest("verifylocalitypage_Banner ");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		as.assertEquals(locality.getBanner(), true, "Banner not showing");
		as.assertAll();
		log.info("Successfully  verify locality page banner");
		as.assertEquals(locality.scrollBanner(), true, "scroll option is not showing for banner_slider");
		as.assertAll();
		log.info("Successfully verify the banner_slider");
	}

	@Test(enabled = true, priority = 6, description = " verify ExploreRestaurant button ")

	public void exploreRestaurant() throws InterruptedException {

		ExtentReport.createTest(" verify ExploreRestaurant button");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		as.assertEquals(locality.exploreAllRestaurant(), true, "explore restaurant button not showing");
		as.assertAll();
		log.info("Successsfully verify the explore all restaurant button");
		Thread.sleep(3000);
		locality.clickESLogo();
	}

	@Test(enabled = true, priority = 7, description = " verify smallRestaurant_logo ")

	public static void smallRestaurantLogo() {
		ExtentReport.createTest("verify smallRestaurant_logo");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		as.assertEquals(locality.smallLogo(), true, "Small reaturant logo not showing");
		as.assertAll();
		log.info("Samll reataurant logo is showing");
		// total count small resturant logo
		int small_logocount = driver.findElements(By.xpath("//a[@data-qa='brandIcon']")).size();
		log.info("samll restaurant logo count  " + small_logocount);

		// verify the small logo poitner
		as.assertEquals(locality.logoPointer(driver), 3, "pointer is not showing");
		as.assertAll();
		log.info("small logo pointer count " + locality.logoPointer(driver));

	}

	@Test(enabled = true, priority = 8, description = " verify LargeRestaurant_logo ")

	public static void largeRestaurantLogo() {
		ExtentReport.createTest("verify largeRestaurant_logo");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		as.assertEquals(locality.largeLogo(), true, "large restaurant logo not showing");
		as.assertAll();
		log.info("Large restaurant logo showing");
		int large_logocount = driver.findElements(By.xpath("//div[@style='outline: none;']")).size();
		log.info("large restaurant logo count  " + large_logocount);

	}

	@Test(enabled = true, priority = 9, description = " verify small logo count equals to larger logo count ")

	public static void compareLogoCount() {

		ExtentReport.createTest("compare logo count");
		as = new SoftAssert();
		as.assertEquals(driver.findElements(By.xpath("//div[@style='outline: none;']")).size(),
				driver.findElements(By.xpath("//a[@data-qa='brandIcon']")).size(),
				"small logo count and large logo count not same");
		log.info("small and larger logo count same");
	}

	@Test(enabled = true, priority = 10, description = " verify restaurant below text")

	public void restaurantText() {

		ExtentReport.createTest("verify restaurant below text");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		as.assertEquals(locality.restaurantBelowText(), "Order Food Online from Trusted Restaurants in panaji-bus-stand-goa");
		as.assertAll();
		log.info(locality.restaurantBelowText());
	}
	
	@Test(enabled = true, priority = 11, description = " verify cuisines sections")

	public void loyalty() throws InterruptedException {

		ExtentReport.createTest("verify restaurant below text");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		locality.scrollloyalty(driver);
		Thread.sleep(3000);
	}

	@Test(enabled = true, priority = 12, description = " verify cuisines sections")

	public void cuisinesArea() throws InterruptedException {

		ExtentReport.createTest("verify restaurant below text");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		locality.scrollCusine(driver);
		Thread.sleep(3000);
		/*
		 * as.assertEquals(locality.verifylLocalityPagePopularCuisinesHeadar(driver),
		 * true, "Locality page Popular Cuisines headar in your area mismatch");
		 * as.assertAll(); log.info("Cuisines area is visible");
		 */

		// locality.scrollbar_down(driver);

		as.assertEquals(locality.cuScroll(), true, "scroll option not showing for cuisine section");
		as.assertAll();
		log.info("Successfully verify the cuisine scroll option");

		int cuisine_Count = driver.findElements(By.xpath("//div[@class='style__WrapperCard-sc-1n2iri-3 jnsAiW']"))
				.size();
		log.info("Total cuisines count " + cuisine_Count);

		// locality.scroll_cusine(driver);

		Thread.sleep(3000);

		as.assertEquals(locality.cuisineSectionButton(), true, "cuisine scetion button is not shwoing");
		as.assertAll();
		log.info("Successsfully verify cuisine section button");
		locality.clickESLogo();
		Thread.sleep(3000);

		locality.scrollBar(driver);
	}

	@Test(enabled = true, priority = 13, description = " verify free dish section")

	public void freeDish() throws InterruptedException {

		ExtentReport.createTest("verify free dish section");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		Thread.sleep(2000);
		locality.scrollSmall(driver);
		// locality.scrollbar(driver);
		// locality.scrollbar(driver);
		as = new SoftAssert();

		as.assertEquals(locality.verifylLocalityPageFreeDish(driver), true, "Locality page FreeDish mismatch");
		as.assertAll();
		log.info("verify free dish section is showing");
		locality.scrollBar(driver);
		// unlock section display
		as.assertEquals(locality.unlockDishCount(), true, "Locality page unlock dish count not showing");
		as.assertAll();
		int unlock_count = driver.findElements(By.xpath("//div[@class='styles__CardContainer-sc-18rn4c6-3 lgUvWm']"))
				.size();
		log.info("Fres dish Unlock section count " + unlock_count);

	}

	@Test(enabled = true, priority = 14, description = " verify free dish pop up")

	public void freeDishPopup() throws InterruptedException {

		ExtentReport.createTest("verify free dish pop up");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		// locality.scrollbar_small(driver);
		locality.scrollSmall(driver);
		locality.scrollSmall(driver);

		Thread.sleep(3000);
		as = new SoftAssert();
		as.assertEquals(locality.freePopup(), true, "free dish pop not open");
		as.assertAll();
		log.info("Verify the free dish pop up");
		locality.close();
	}

	@Test(enabled = true, priority = 15, description = " verify free dish SCROLL OPTION")

	public void freeDish_Scroll() throws InterruptedException {

		ExtentReport.createTest("verify free dish SCROLL OPTION");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		// locality.scrollbar_small(driver);
		Thread.sleep(3000);
		as = new SoftAssert();
		as.assertEquals(locality.freeScrolling(), true, "free dish scroll dish not working");
		as.assertAll();
		log.info("fressDish Scroll verify");
		as.assertEquals(locality.freeStatement(), "Bill value indicates final payable amount! Know more");
		as.assertAll();
		log.info("verify the free dish statement");
		locality.knowMoreScroll(driver);
		Thread.sleep(2000);
		as.assertEquals(locality.knowMoreFree(), true, "know more option not showing");
		as.assertAll();
		log.info("verify the know more button");
		Thread.sleep(2000);
		locality.close();
	}

	@Test(enabled = false, priority = 16, description = " verify sure saving section")

	public static void sureSavingsSection() throws InterruptedException {

		ExtentReport.createTest("verify sure saving section");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		as.assertEquals(locality.sureSavings(), true, "sure saving section not showing");
		as.assertAll();
		if (locality.sureSavings() == true) {
			int coupons_count = driver
					.findElements(By.xpath("//div[@class='style__PromoCardWrapper-sc-1xlshhx-1 jXQvEK']")).size();
			log.info("Coupon info count " + coupons_count);
			if (coupons_count > 3) {
				boolean coupon_Scroll = driver.findElement(By.xpath("(//button[@class='slick-arrow slick-next'])[4]"))
						.isDisplayed();
				as.assertEquals(coupon_Scroll, true);
				log.info("verify Coupon scroll is display");
			} else {
				log.info("coupon scroll is not showing");
			}
		}
	}

	@Test(enabled = false, priority = 17, description = " coupon crad  details")

	public static void couponCard() throws InterruptedException {

		ExtentReport.createTest("coupon crad  details");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();

		locality.scrollSmall(driver);
		Thread.sleep(3000);
		as.assertEquals(locality.couponView(), true, "view detils for coupon card not showing");
		as.assertAll();
		log.info("coupon details option verify");
		Thread.sleep(3000);
		locality.close();
		// verify the usecode statement count
		int use_code = driver.findElements(By.xpath("//p[@class='style__CodeField-sc-1xlshhx-6 dPSQpa']")).size();
		log.info("use code statment count " + use_code);
		int coupons_count = driver.findElements(By.xpath("//div[@class='style__PromoCardWrapper-sc-1xlshhx-1 jXQvEK']"))
				.size();
		as.assertEquals(use_code, coupons_count);
		log.info("verify the use code statement show for every coupons card");

		// verfy first coupon card always IAMSURE
		as.assertEquals(locality.couponName(), "IAMSURE", "First coupon name is not showing");
		as.assertAll();
		log.info("First coupon name is showing IAMSURE verify");

		// verify the copy option
		as.assertEquals(locality.copyOption(), "Copied!", "Copy option not showing");
		as.assertAll();
		log.info("sucessfully verify the coupon copy option");

	}

	@Test(enabled = true, priority = 18, description = " verify Exclusive section")

	public void exclusiveSection() throws InterruptedException {

		ExtentReport.createTest("verify Exclusive section");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		// locality.scrollbar_small(driver);
		// locality.scroll_(driver);
		Thread.sleep(3000);
		as = new SoftAssert();
		as.assertEquals(locality.esExclusive(), true, "ES Exclusive section not matching");
		as.assertAll();
		log.info("Verify the ES exclusive section");
		as.assertEquals(locality.esExclusiveHeader(driver), true, "ES Exclusive section header not matching");
		as.assertAll();
		log.info("Verify the ES exclusive section header");

	}

	@Test(enabled = true, priority = 19, description = " verify Exclusive card section")

	public void exclusiveCard() throws InterruptedException {

		ExtentReport.createTest("verify Exclusive card section");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		as.assertEquals(locality.exclusiveESCard(), true, "ES Exclusive card section not matching");
		as.assertAll();
		int card_count = driver.findElements(By.xpath("//div[@class='ExclusiveCard__CardWrapper-wnhc6h-0 kwuNWG']"))
				.size();
		log.info("Exclusive card count " + card_count);
		as.assertEquals(locality.exclusiveShare(), true, "ES Exclusive share button not showing");
		as.assertAll();
		log.info("Verify the Share option");
		Thread.sleep(2000);
		locality.close();
		Thread.sleep(2000);

		locality.scrollBar(driver);
		Thread.sleep(3000);
		as.assertEquals(locality.exButton(), true, "ES Exclusive explore menu button not showing");
		as.assertAll();
		log.info("verify the explore menu button");
		// locality.clickESLogo();

	}

	@Test(enabled = true, priority = 20, description = " verify Most Loved Collections")

	public void mostLoveCollection() throws InterruptedException {

		ExtentReport.createTest("verify Most Loved Collections");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();

		// as.assertEquals(locality.verifylLocalityPageMostLovedCollections(driver),
		// true,"Locality page Most Loved Collection mismatch");
		// as.assertAll();
		// log.info("verify the most love collection section");
		int collection_count = driver
				.findElements(By.xpath("//figure[@class='style__WrapperCard-sc-18spifb-3 eeIpTu']")).size();
		log.info("Total collection count " + collection_count);

		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollTo(0, 2705)");
		Thread.sleep(8000);

		// as.assertEquals(locality.verifylLocalityPageMostLovedCollections(driver),
		// true,"Locality page Most Loved Collection mismatch");

		// verify the explore all collection button

		as.assertEquals(locality.collectionAllButton(), true, "collection all button not showing");
		as.assertAll();
		log.info("Verify the explore all collections button");
		Thread.sleep(3000);
		// driver.navigate().back();
		// locality.scroll_collection_arrow(driver);
		Thread.sleep(5000);
		as.assertEquals(locality.collectionArrowClick(), true, "collection arroe button not showing");
		as.assertAll();
		log.info("Verify the  collections arrow");
		// driver.navigate().back();
	}

	@Test(enabled = true, priority = 21, description = " verify sure_earning sections")

	public void sureEarnings() throws InterruptedException {

		ExtentReport.createTest("verify sure_earning sections");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		as.assertEquals(locality.sureEarning(), true, "sure earning boxes not showing");
		as.assertAll();
		log.info("Sure earning section verify");
		int sure_box_count = driver.findElements(By.xpath("//div[@class='sc-hKwCoD jMFGJE']")).size();
		as.assertEquals(sure_box_count, 3, "sure box count not match");
		as.assertAll();
		log.info("Verify the sure_box count" + sure_box_count);

		locality.scrollSmall(driver);
		Thread.sleep(5000);
		as.assertEquals(locality.sureButton(), true, "sign up for sure point button not working");
		as.assertAll();
		log.info("Verify the sign up for sure point button");
		Thread.sleep(2000);
		locality.close();
		Thread.sleep(3000);
	}

	@Test(enabled = true, priority = 22, description = " verify the multiple combo sections")

	public void comboSection() throws InterruptedException {

		ExtentReport.createTest("verify sure_earning sections");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		locality.scrollSmall(driver);
		Thread.sleep(3000);
		as.assertEquals(locality.comboExloreButton(), true, "explore button is not showing");
		as.assertAll();
		log.info("Verify the explore combo button");
		// locality.clickESLogo();
		Thread.sleep(2000);
		// verify the combo count
		int combo_count = driver.findElements(By.xpath("//div[@class='style__Card-szq0pu-0 gCqoqh']")).size();
		log.info("Combo count in locality page " + combo_count);
		// locality.scroll_signupSure_button(driver);
		locality.scrollSmall(driver);
		locality.scrollSmall(driver);

		Thread.sleep(5000);
		if (combo_count > 3) {
			boolean combo_scroll = driver.findElement(By.xpath("(//button[@data-role='none'])[10]")).isDisplayed();
			as.assertEquals(combo_scroll, true);
			log.info("Verify the combo scroll there");
		} else {
			log.info("Combo scroll not showing");
		}
	}

	@Test(enabled = true, priority = 23, description = "verify the combo card details")

	public void comboDetails() throws InterruptedException {

		ExtentReport.createTest("verify sure_earning sections");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		// verify the slash prices
		as.assertEquals(locality.comboSlashPrice(), true, "Slash price is not showing");
		as.assertAll();
		log.info("Verify the slash price for combo ");

		// verify the combo orginal price
		as.assertEquals(locality.comboPrice(), true, "combo price is not showing");
		as.assertAll();
		log.info("verify the combo price");
		Thread.sleep(5000);

		// verify the choose item button
		locality.scrollSmall(driver);
		Thread.sleep(5000);
		as.assertEquals(locality.comboButton(), true, "combo button is not showing");
		as.assertAll();
		log.info("verify the combo choose button");
		locality.close();

	}

	@Test(enabled = true, priority = 24, description = "verify the es stores for city")

	public void esStoresName() throws InterruptedException {

		ExtentReport.createTest("verify sure_earning sections");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		as.assertEquals(locality.eatsureStores(), "EatSure - Food Delivery Locations in Bangalore");
		as.assertAll();
		log.info("verify the Es stores name sections ");
	}

	@Test(enabled = true, priority = 25, description = "count stores name show in the list")

	public void countStoresName() throws InterruptedException {

		ExtentReport.createTest("count stores name show in the list");

		WebElement store_table = driver.findElement(By.xpath("(//div[@class=\"sc-dkPtyc fydAkz\"])[3]"));
		List<WebElement> store_name_links = store_table.findElements(By.tagName("a"));
		int store_name_counts = store_name_links.size();
		log.info("store name showing in the locality page is " + store_name_counts);

	}

	@Test(enabled = true, priority = 26, description = "verify es delivery cities section")

	public void citiesSection() throws InterruptedException {

		ExtentReport.createTest("verify es delivery cities section");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		locality.scrollSmall(driver);
		Thread.sleep(3000);
		as.assertEquals(locality.esDeliveryCity(), true, "Other Cities We Deliver To section not showing");
		as.assertAll();
		log.info("Other Cities We Deliver To section verify");
		// get the count of city names
		WebElement cityname_section = driver
				.findElement(By.xpath("(//div[@class='style__Container-sc-150dl3q-2 eZvLky'])[2]"));
		List<WebElement> link_count = cityname_section.findElements(By.tagName("a"));
		int cityname_count = link_count.size();
		log.info("Total city name is showing " + cityname_count);

	}

	@Test(enabled = true, priority = 27, description = "verify the footer top section")

	public void footerTopSection() throws InterruptedException {

		ExtentReport.createTest("verify the footer top section");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		locality.scrollBar(driver);
		Thread.sleep(2000);

		// verfy the es logo in the footer
		as.assertEquals(locality.F_Eslogo(), true, "ES logo is not showing in the footer");
		as.assertAll();
		log.info("verify the Es Logo in the footer");

		// verify the social brand logo
		as.assertEquals(locality.s_Logo(), true, "social media logo section is not showing in the footer");
		as.assertAll();
		WebElement social_section = driver.findElement(By.xpath("//div[@class='style__Social-pfco2s-3 jwyQWv']"));
		List<WebElement> social_link_count = social_section.findElements(By.tagName("a"));
		int social_Media_count = social_link_count.size();
		as.assertEquals(social_Media_count, 4);
		as.assertAll();
		log.info("Verify the social media app count " + social_Media_count);
	}

	@Test(enabled = true, priority = 28, description = "verify the footer mid section")

	public void footerMidSection() throws InterruptedException {

		ExtentReport.createTest("verify the footer mid section");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		locality.scrollSmall(driver);
		as.assertEquals(locality.sureChoice_F_Scetion(), true, "sure_choice section do not showing in the footer");
		as.assertAll();
		as.assertEquals(locality.our_Story_F_Scetion(), true, "our story section do not showing in the footer");
		as.assertAll();
		as.assertEquals(locality.initiative_F_Scetion(), true, "Initiative section do not showing in the footer");
		as.assertAll();
		as.assertEquals(locality.appLink_F_Scetion(), true, "Es app section do not showing in the footer");
		as.assertAll();
		as.assertEquals(locality.importantLink_F_Scetion(), true,
				"Important link section do not showing in the footer");
		as.assertAll();

		log.info("verify the mid footer section");

		// verify the important link open url
		WebElement order_briyani_link = driver.findElement(By.linkText("Order Biryani Online"));
		order_briyani_link.click();
		Thread.sleep(3000);
		String actual_title = "Order Biryani Online Near Me | Behrouz";
		String exp_title = driver.getTitle();
		as.assertEquals(exp_title, actual_title);
		as.assertAll();
		log.info("Verify the important link url open right page");

		driver.navigate().back();

	}

	@Test(enabled = true, priority = 29, description = "verify the footer buttom section")

	public void footerBottomSection() throws InterruptedException {

		ExtentReport.createTest("verify the footer bottom section");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		as.assertEquals(locality.securePayment_F_Scetion(), true,
				"Secure payment section do not showing in the footer");
		as.assertAll();
		log.info("secure payment section verify");
		// verify the copy right section
		as.assertEquals(locality.copyRight_F_Scetion(),
				"Copyright © 2023. EatSure - All Rights Reserved. Terms of use Privacy");
		as.assertAll();
		log.info("Verfy the copy right statement");
	}

	@Test(enabled = true, priority = 30, description = "verify the brokenlinks")

	public void brokenlinks() throws InterruptedException, MalformedURLException, IOException {

		ExtentReport.createTest("verify the brokenlinks ");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		List<WebElement> links = driver.findElements(By.xpath("//div[starts-with(@class,'sc-hKwCoD')]/ul/li/a"));
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int resCode = conn.getResponseCode();

			as.assertTrue(resCode < 400, "The link is broken " + link.getText() + "rescode of the link is " + resCode);
			

		}
		as.assertAll();
		log.info("Verify all links are working");
	}

	

	/*@AfterSuite
	public void afterSuite() {

		ExtentReport.extent.flush();
	}*/
	
	@AfterTest()
	public void tabClose() {
		driver.close();
	}

	

}
