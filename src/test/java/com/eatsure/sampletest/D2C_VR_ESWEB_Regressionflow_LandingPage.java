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
import com.eatsure.pom.LandingPage;
import com.eatsure.reports.ExtentReport;
import com.eatsure.utils.ReadPropertyFile;
import com.eatsure.validation.ValidateTitle;

public class D2C_VR_ESWEB_Regressionflow_LandingPage {
	public WebDriver driver;
	Driver driver1;
	SoftAssert as;
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

	@Test(enabled = true, priority = 0, description = "Verify UI Elements of Landing page")
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

	@Test(enabled = true, priority = 4, description = "Verify the functionality of location search by GPS ")
	public void verifyLocationSearchGps() {
		ExtentReport.createTest("Verify the functionality of location search by GPS ");
		LandingPage landing = PageFactory.initElements(driver, LandingPage.class);
		landing.clickLocateMeText(driver);
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
