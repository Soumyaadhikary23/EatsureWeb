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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eatsure.browser.Driver;
import com.eatsure.pom.BrandRestaurantPage;
import com.eatsure.pom.CartPage;
import com.eatsure.pom.LandingPage;
import com.eatsure.pom.LocalityPage;
import com.eatsure.reports.ExtentReport;
import com.eatsure.utils.ReadPropertyFile;
import com.eatsure.validation.ValidateTitle;

public class D2C_VR_ESWEB_Regressionflow_RestaurantPage {

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

	@Test(enabled = true, priority = 1, description = "Verify redirection to brand page/restaurant page")
	public void verifyBrandPage() throws InterruptedException {
		ExtentReport.createTest("Verify redirection to brand page/restaurant page ");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		BrandRestaurantPage brandPage = PageFactory.initElements(driver, BrandRestaurantPage.class);
		as = new SoftAssert();
		Thread.sleep(3000);
		locality.navigateTobbBrand(driver);
		as.assertEquals(brandPage.verifyFiltersection(), true, "After clicking restaurant page not opening");
		as.assertAll();
		log.info("Successfully verify the redirection locality to restaurant page");
	}

	@Test(enabled = true, priority = 2, description = "locality page BREADCRUMBS ")

	public void breadcurms() throws InterruptedException {

		ExtentReport.createTest("verifylocalitypage_BREADCRUMBS ");
		BrandRestaurantPage brandPage = PageFactory.initElements(driver, BrandRestaurantPage.class);
		as = new SoftAssert();
		as.assertEquals(brandPage.getBreadcrums(), true, "Breadcrums section not showing");
		as.assertAll();
		log.info("Breadcrums setion is showing");
		// get the breadcrums section text
		WebElement Bread_Section = driver.findElement(By.xpath("//div[@data-qa='breadcrumbsSection']"));
		List<WebElement> link_count = Bread_Section.findElements(By.tagName("a"));
		int Bread_count = link_count.size();
		for (int i = 0; i < Bread_count; i++) {

			WebElement a = link_count.get(i);
			String text = a.getText();
			System.out.print(text);

		}
	}

	@Test(enabled = true, priority = 3, description = "Verify banner section ")

	public void bannerSection() throws InterruptedException {

		ExtentReport.createTest("Verify banner section");
		BrandRestaurantPage brandPage = PageFactory.initElements(driver, BrandRestaurantPage.class);
		as = new SoftAssert();
		try {
		as.assertEquals(brandPage.baner(), true, "Baner not shwoing");
		as.assertAll();
		log.info("Verify the Old baner is showing");
		as.assertEquals(brandPage.offer(), true, "Offer section is not showing in old baner");
		as.assertAll();
		log.info("Successfully Offer section is verify");
		as.assertEquals(brandPage.share(), true, "Share option not showing");
		as.assertAll();
		log.info("Successfully share option is verify");
		log.info("Successfully verify the old baner");
		}catch(Exception e) {
			as.assertEquals(brandPage.newBaner(), true,"baner not shwoing");
			as.assertAll();
			log.info("Successfully verify the new baner");
		}
	}

	@Test(enabled = true, priority = 4, description = "Verify filter option ")
	public void filter() throws InterruptedException {
		ExtentReport.createTest("Verify filter section");
		BrandRestaurantPage brandPage = PageFactory.initElements(driver, BrandRestaurantPage.class);
		as = new SoftAssert();
		as.assertEquals(brandPage.filter(driver), true, "filter option not showing");
		as.assertAll();
		log.info("Successfully verify the filter section");
		// verify the veg filter
		as.assertEquals(brandPage.vegFilter(), 0, "veg filter not working");
		as.assertAll();
		log.info("Successfully verify veg filter");
		Thread.sleep(2000);
		brandPage.bothFilter();
	}

	@Test(enabled = true, priority = 5, description = "Verify sort option ")
	public void sort() throws InterruptedException {
		ExtentReport.createTest("Verify sort section");
		BrandRestaurantPage brandPage = PageFactory.initElements(driver, BrandRestaurantPage.class);
		as = new SoftAssert();
		as.assertEquals(brandPage.sortOption(), 4, "sort items not showing all");
		as.assertAll();
		brandPage.sortOptionApply();
		brandPage.productPrice();
		as.assertEquals(brandPage.isSorted(brandPage.price), true);
		as.assertAll();
		log.info("Successfully verify the sort option");
	}

	

	@Test(enabled = true, priority = 6, description = "Verify productDetails option ")
	public void productDetails() throws InterruptedException {
		ExtentReport.createTest("Verify productDetails section");
		BrandRestaurantPage brandPage = PageFactory.initElements(driver, BrandRestaurantPage.class);
		as = new SoftAssert();
		as.assertEquals(brandPage.productCard(driver), true, "Product card miss some element");
		as.assertAll();
		log.info("Successfully verfy the product card's product name,description,filter icon,rating and serve");
		as.assertEquals(brandPage.addButton(driver), true, "Add button is not showing");
		as.assertAll();
		log.info("Successfully verify the add button");

	}
	
	@Test(enabled = true, priority = 7, description = "Verify sideColelction option ")
	public void sideColelction() throws InterruptedException {
		ExtentReport.createTest("Verify sideColelction section");
		BrandRestaurantPage brandPage = PageFactory.initElements(driver, BrandRestaurantPage.class);
		as = new SoftAssert();
		as.assertEquals(brandPage.collectionClick(), brandPage.collectionName(),
				"after click on collection ,name is not matching");
		as.assertAll();
		log.info("side collection select option is working");
		as.assertEquals(brandPage.collectionProductCount(), brandPage.priceCount(),
				"Product count not matching with side collection number");
		as.assertAll();
		log.info("Successfully Verify the product count");
	}

	@Test(enabled = true, priority = 8, description = "Verify customization option ")
	public void customization() throws InterruptedException {
		ExtentReport.createTest("Verify customization section");
		BrandRestaurantPage brandPage = PageFactory.initElements(driver, BrandRestaurantPage.class);
		as = new SoftAssert();
		brandPage.customizationSelected();
		
	}
	
	@Test(enabled = true, priority = 9, description = "Verify quanity incrase/descrese button option ")
	public void quantity() throws InterruptedException {
		ExtentReport.createTest("Verify quanity incrase/descrese button section");
		BrandRestaurantPage brandPage = PageFactory.initElements(driver, BrandRestaurantPage.class);
		as = new SoftAssert();
		as.assertEquals(brandPage.quantityOption(), true, "after add the product Quanity incraese/decrease option not showing");
		as.assertAll();
		log.info("Successfylly verify the Quanity incraese/decrease option");
		as.assertEquals(brandPage.quantityShow(), 1, "not showing the right quantity");
		as.assertAll();
		log.info("Successfylly verify the quantity show count");
		
	}
	
	@Test(enabled = true, priority = 10, description = "Verify combo option ")
	public void combo() throws InterruptedException {
		ExtentReport.createTest("Verify combo section");
		BrandRestaurantPage brandPage = PageFactory.initElements(driver, BrandRestaurantPage.class);
		as = new SoftAssert();
		brandPage.chooseItem(driver);
		Thread.sleep(2000);
		brandPage.chooseItemClick(driver);
		log.info(brandPage.chooseItemClick(driver));
		//as.assertEquals(brandPage.chooseItemClick(driver), brandPage.setComboName(), "Combo name not matching");
		//as.assertAll();
		//log.info("Successfully verify the combo name");
		int price=brandPage.setComboPrice();
		Thread.sleep(2000);
		brandPage.comboClose(driver);
		as.assertEquals(price, brandPage.comboListPrice());
		as.assertAll();
		log.info("Successfully verify the combo price");
		
		brandPage.addDynemiComboOfTwoProductcondition(driver);
		as.assertEquals(brandPage.quantityOption(), true, "after add the product Quanity incraese/decrease option not showing");
		as.assertAll();
		log.info("Successfylly verify the Quanity incraese/decrease option");
		as.assertEquals(brandPage.quantityShow(), 1, "not showing the right quantity");
		as.assertAll();
		log.info("Successfylly verify the quantity show count");
		log.info("Successfully added the combo");
		
		
	}
	
	@Test(enabled = true, priority = 11, description = "Verify containerBar option ")
	public  static void containerBar() throws InterruptedException {
		ExtentReport.createTest("Verify containerBar section");
		BrandRestaurantPage brandPage = PageFactory.initElements(driver, BrandRestaurantPage.class);
		as = new SoftAssert();
		Thread.sleep(3000);
		int addProductCount=brandPage.orderCountContainer();
		brandPage.arrowClick();
		log.info(addProductCount);
		log.info(brandPage.containProductCount());
		as.assertEquals(addProductCount, brandPage.containProductCount(), "added product in the container doesn't match");
		as.assertAll();
		log.info("Successfully verify the product count int the container card");
		as.assertEquals(brandPage.containerHeader(), "Your Orders", "Header not matchinhg");
		as.assertAll();
		log.info("Successfully verify the container card Header");
		int beforeloginPrice=brandPage.totalPriceBeforeLogin();
		log.info("before login total price "+beforeloginPrice);
		brandPage.containerClose();
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();
		brandPage.login(driver);
		cart.enterMobileNumber(ReadPropertyFile.get("MobilenumberFixedOTP"));
		Thread.sleep(1000);
		cart.clickLoginwithOTP();
		cart.enterOTP(driver, ReadPropertyFile.get("otp"));
		Thread.sleep(3000);
		log.info(brandPage.totalprice());
		as.assertEquals(brandPage.totalprice(), beforeloginPrice, "after login and before login amount not matching");
		as.assertAll();
		log.info("Successfully verify the total price" );
	}
	
	@AfterClass
	public void close() {
		driver.close();
	}
	
	
	
	

}
