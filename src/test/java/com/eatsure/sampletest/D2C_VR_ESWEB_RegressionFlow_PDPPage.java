package com.eatsure.sampletest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eatsure.browser.Driver;
import com.eatsure.pom.BasePage;
import com.eatsure.pom.BrandRestaurantPage;
import com.eatsure.pom.CartPage;
import com.eatsure.pom.LandingPage;
import com.eatsure.pom.LocalityPage;
import com.eatsure.pom.MenuPage;
import com.eatsure.pom.ProductDetailPage;
import com.eatsure.reports.ExtentReport;
import com.eatsure.utils.ReadPropertyFile;
import com.eatsure.validation.ValidateTitle;

public class D2C_VR_ESWEB_RegressionFlow_PDPPage {
	public WebDriver driver;
	Driver driver1;
	SoftAssert as;
	public static final Logger log = LogManager.getLogger(D2C_VR_ESWEB_RegressionFlow_PDPPage.class.getName());

	@BeforeSuite
	public void beforeSuite() {
		ExtentReport.initialize();
	}

	@Parameters("browser")
	@BeforeClass
	public void initialize(@Optional("chrome") String browser) throws IOException {
		driver1 = new Driver();
		driver = driver1.initializeDriver(browser);
		driver.get(Driver.prop.getProperty("urlProductionES"));
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
		as.assertAll();

		log.info("Successfully validated Locality Page Content");
	}

	@Test(enabled = true, priority = 2, description = "selectionOfNormalProductwithCustomizationFromPDP")
	public void verificationOfNormalProductFromPDPPage() {
		ExtentReport.createTest("selectionOfNormalProductwithCustomizationFromPDP");

		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		locality.navigateToBrandCondition(driver);

		// BrandRestaurantPage details
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		String BrandRestaurantPageProductName = brand.getProductNameText();
		log.info("#BrandPageProductName  #" + BrandRestaurantPageProductName);
		String BrandRestaurantPageProductPrice = brand.getProductPriceText();
		log.info("#BrandPageProductPrice  #" + BrandRestaurantPageProductPrice);

		brand.clickProducNameLink(driver);

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
		log.info(
				"Successfully Verifified NormalProduct From PDP Page and validated the productname and price");
	}

	@Test(enabled = true, priority = 3, description = "verifyUIElementsAndContentOnPDP")
	public void verifyUIElementsAndContentOnPDP() {
		ExtentReport.createTest("verifyUIElementsAndContentOnPDP");
		ProductDetailPage pdp = PageFactory.initElements(driver, ProductDetailPage.class);

		// Verify UI And Content On PDP
		as.assertEquals(pdp.verifyProductDetailPageProductImage(), true, "Product Image Not available");
		as.assertEquals(pdp.verifyProductDetailPageProductPrice(), true, "Product Price mismatch");
		as.assertEquals(pdp.verifyProductDetailPageStickyHeader(), true, "Sticky Header mismatch");
		as.assertEquals(pdp.verifyProductDetailPageBrandsReel(), true, "Brands Reel mismatch");

		log.info("Successfully Validated UI Elements And Content On PDP Page");
	}

	@Test(enabled = true, priority = 4, description = "verifyAddButtonFunctionalityOnPDP")
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

	@Test(enabled = true, priority = 5, description = "verifyAddRemoveFunctionalityOnPDP")
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
		as.assertEquals(ProductCountOnAddButton, ProductCountOnCartHeader);
		log.info("Successfully Validated Add Remove Functionality On PDP");
	}

	@Test(enabled = true, priority = 6, description = "verifyProductNamePriceDescriptionOnPDP")
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

	@Test(enabled = true, priority = 7, description = "verifyServesRatingByWithBrandLogo")
	public void verifyServesRatingByWithBrandLogo() {
		ExtentReport.createTest("verifyServesRatingByWithBrandLogo");
		ProductDetailPage pdp = PageFactory.initElements(driver, ProductDetailPage.class);
		as.assertEquals(pdp.verifyBrandServes(), true, "Brand Serves Text Not available on PDP");
		as.assertEquals(pdp.verifyBrandLogo(), true, "Brand Logo Not available on PDP");
		as.assertEquals(pdp.verifyBrandName(), true, "Brand Name Not available on PDP");
		log.info("Successfully Validated Serves Rating  By With BrandLogo");
	}

	@Test(enabled = true, priority = 8, description = "verifyShareOptionFunctionality")
	public void verifyShareOptionFunctionality() {
		ExtentReport.createTest("verifyShareOptionFunctionality");
		ProductDetailPage pdp = PageFactory.initElements(driver, ProductDetailPage.class);
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		as.assertEquals(pdp.verifyShareButton(), true, "Share Button Not available on PDP");
		pdp.clickshareButton(driver);
		as.assertEquals(pdp.verifyShareButtonModalView(), true, "ShareButtonModalView Not available on PDP");
		as.assertEquals(pdp.verifyShareOnWhatsappOption(), true, "ShareOnWhatsappOption Not available on PDP");
		as.assertEquals(pdp.verifyShareOnFacebookOption(), true, "ShareOnFacebookOption Not available on PDP");
		as.assertEquals(pdp.verifyShareOnTwitterOption(), true, "ShareOnTwitterOption Not available on PDP");
		as.assertEquals(pdp.verifyShareViaGmailOption(), true, "ShareViaGmailOption Not available on PDP");
		as.assertEquals(pdp.verifyCopyLinkCard(), true, "CopyLinkCard Not available on PDP");
		as.assertEquals(pdp.verifyCopyLinkButton(), true, "CopyLinkButton Not available on PDP");
		pdp.clickCopyLinkButton(driver);
		pdp.clickCloseWindowPopup(driver);
		pdp.clickRemoveQuantity(driver);
		menu.clickEatsureLogo(driver);
		log.info("Successfully Validated Share Option Functionality On PDP Page");
	}

	@Test(enabled = false, priority = 9, description = "verifyCouponSurePointsInfoSection")
	public void verifyCouponSurePointsInfoSection() {
		ExtentReport.createTest("verifyCouponSurePointsInfoSection");

		ProductDetailPage pdp = PageFactory.initElements(driver, ProductDetailPage.class);
		as.assertEquals(pdp.verifySurePointsSection(), true, "Sure Points Section Not available on PDP");
		pdp.clickReadMoreOption(driver);
		log.info("Successfully Validated Coupon Sure Points Info Section On PDP Page");
	}

	@Test(enabled = false, priority = 10, description = "verifyKnowMoreOptionWithSurePointsInfo")
	public void verifyKnowMoreOptionWithSurePointsInfo() {
		ExtentReport.createTest("verifyKnowMoreOptionWithSurePointsInfo");

		ProductDetailPage pdp = PageFactory.initElements(driver, ProductDetailPage.class);
		as.assertEquals(pdp.verifyKnowMoreLink(), true, "Know More Link Not available on PDP");
		pdp.clickKnowMoreLink(driver);
		as.assertEquals(pdp.verifyKnowMoreModalView(), true, "Know More Modal View Not available on PDP");
		as.assertEquals(pdp.verifyKnowMoreModalViewFirstBrandName(), true,
				"KnowMoreModalViewFirstBrandName Not available on PDP");
		as.assertEquals(pdp.verifyKnowMoreModalViewCurrencyLabel(), true,
				"KnowMoreModalViewCurrencyLabel Not available on PDP");
		pdp.clickCloseWindowPopup(driver);
		log.info("Successfully Validated Know More Option With Sure Points Info");
	}

	@Test(enabled = false, priority = 11, description = "verifyKnowMoreEatsureAssuranceInfo")
	public void verifyKnowMoreEatsureAssuranceInfo() {
		ExtentReport.createTest("verifyKnowMoreEatsureAssuranceInfo");

		ProductDetailPage pdp = PageFactory.initElements(driver, ProductDetailPage.class);
		as.assertEquals(pdp.verifyKnowMoreEatsureAssuranceLink(), true,
				"Know More EatsureAssurance Link Not available on PDP");
		pdp.clickKnowMoreEatsureAssuranceLink(driver);
		as.assertEquals(pdp.verifyKnowMoreEatsureAssuranceModalView(), true,
				"Know More EatsureAssurance Modal View Not available on PDP");
		as.assertEquals(pdp.verifyKnowMoreHighGradeIngredientsInfo(), true,
				"Know More HighGradeIngredients Info Not available on PDP");
		pdp.clickCloseWindowPopup(driver);
		log.info("Successfully Validated Know More Eatsure Assurance Info");
	}

	@Test(enabled = false, priority = 12, description = "verifyBestPriceGuranteedSection")
	public void verifyBestPriceGuranteedSection() {
		ExtentReport.createTest("verifyBestPriceGuranteedSection");
		ProductDetailPage pdp = PageFactory.initElements(driver, ProductDetailPage.class);
		as.assertEquals(pdp.verifyBestPriceGuranteedSection(), true,
				"Best Price Guranteed Section Not available on PDP");
		as.assertEquals(pdp.verifyArtificialColoursSection(), true, "Artificial Colours Section Not available on PDP");
		as.assertEquals(pdp.verifyMedicallyCertifiedStaffSection(), true,
				"Medically Certified Staff Section Not available on PDP");
		log.info("Successfully Validated Best Price Guranteed Section");
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