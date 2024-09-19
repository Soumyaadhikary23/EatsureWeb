package com.eatsure.sampletest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eatsure.browser.Driver;
import com.eatsure.pom.CartPage;
import com.eatsure.pom.LandingPage;
import com.eatsure.pom.MenuPage;
import com.eatsure.reports.ExtentReport;
import com.eatsure.utils.ReadPropertyFile;
import com.eatsure.validation.ValidateTitle;

public class D2C_VR_ESWEB_RegressionFlow_MenuPage {

	public static final Logger log = LogManager.getLogger(D2C_VR_ESWEB_RegressionFlow_MenuPage.class.getName());
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

	@Test(enabled = true, priority = 1, description = "selectionOfMenuOption")
	public void selectionOfMenuOption() {
		ExtentReport.createTest("selectionOfMenuOption");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickMenuOption(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifyFAQs(), true, "FAQs Not available on Menu Page");
		as.assertAll();
		log.info("Successfully FAQs Options verified");
		as.assertEquals(menu.verifyAboutEatSure(), true, "AboutEatSure Not available on Menu Page");
		as.assertAll();
		log.info("Successfully AboutEatSure Options verified");
		as.assertEquals(menu.verifyTermsNConditions(), true, "TermsNConditions Not available on Menu Page");
		as.assertAll();
		log.info("Successfully TermsNConditions Options verified");
		as.assertEquals(menu.verifyPrivacyPolicy(), true, "PrivacyPolicy Not available on Menu Page");
		as.assertAll();
		log.info("Successfully PrivacyPolicy Options verified");
		as.assertEquals(menu.verifyPartyOrders(), true, "PartyOrders Not available on Menu Page");
		as.assertAll();
		log.info("Successfully PartyOrders Options verified");
		as.assertEquals(menu.verifyWeAreHereToHelpYouText(), true, "WeAreHereToHelpYouText Not available on Menu Page");
		as.assertAll();
		log.info("Successfully WeAreHereToHelpYouText Options verified");
		log.info("Successfully Menu Options verified");

	}

	@Test(enabled = false, priority = 2, description = "selectionOfHelpAndSupport")
	public void selectionOfHelpAndSupport() {
		ExtentReport.createTest("selectionOfHelpAndSupport");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickHelpNSupport(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifyCloseWindowPopupLoginScreen(), true,
				"Login Popup Not available after click on Help N support");
		as.assertAll();
		menu.clickCloseWindowPopupLoginScreen(driver);
		log.info("Successfully Help and Support Functionality verified");
	}

	@Test(enabled = false, priority = 3, description = "selectionOfSurePointsFAQs")
	public void selectionOfSurePointsFAQs() {
		ExtentReport.createTest("selectionOfSurePointsFAQs");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickSurePointsFAQs(driver);
		menu.clickCloseSidebarMenu(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifySurePointsFAQsText(), true,
				"Sure Point FAQ's Text Not available in Sure Point FAQ Page");
		as.assertAll();
		menu.clickMenuOption(driver);
		log.info("Successfully Sure Point FAQ's Functionality verified");

	}

	@Test(enabled = true, priority = 2, description = "selectionOfFAQs")
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

	@Test(enabled = true, priority = 3, description = "selectionOfAboutEatSure")
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

	@Test(enabled = true, priority = 4, description = "selectionOfTermsNConditions")
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

	@Test(enabled = true, priority = 5, description = "selectionOfPrivacyPolicy")
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

	@Test(enabled = true, priority = 6, description = "selectionOfPartyOrders")
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

	@Test(enabled = true, priority = 7, description = "selectionOfWeAreHereToHelpYouText")
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

	@Test(enabled = true, priority = 8, description = "validatingMenuAfterLogin")
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
		as.assertAll();
		log.info("Successfully My Profile Options verified");
		as.assertEquals(menu.verifyFAQs(), true, "FAQs Not available on Menu Page");
		as.assertAll();
		log.info("Successfully FAQs Options verified");
		as.assertEquals(menu.verifyAboutEatSure(), true, "AboutEatSure Not available on Menu Page");
		as.assertAll();
		log.info("Successfully AboutEatSure Options verified");
		as.assertEquals(menu.verifyTermsNConditions(), true, "TermsNConditions Not available on Menu Page");
		as.assertAll();
		log.info("Successfully TermsNConditions Options verified");
		as.assertEquals(menu.verifyPrivacyPolicy(), true, "PrivacyPolicy Not available on Menu Page");
		as.assertAll();
		log.info("Successfully PrivacyPolicy Options verified");
		as.assertEquals(menu.verifyPartyOrders(), true, "PartyOrders Not available on Menu Page");
		as.assertAll();
		log.info("Successfully PartyOrders Options verified");
		as.assertEquals(menu.verifyWeAreHereToHelpYouText(), true, "WeAreHereToHelpYouText Not available on Menu Page");
		as.assertAll();
		log.info("Successfully WeAreHereToHelpYouText Options verified");
		log.info("Successfully verified Menu options after Login");
	}

	@Test(enabled = false, priority = 9, description = "selectionOfMyProfileAfterLogin")
	public void selectionOfMyProfileAfterLogin() {
		ExtentReport.createTest("selectionOfMyProfileAfterLogin");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickMyProfile(driver);
		menu.clickCloseSidebarMenu(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifyMyOrdersNavigationText(), true,
				"My Orders Navigation Not available after click on My Profile");
		as.assertAll();
		log.info("Successfully My Profile AfterLogin Functionality verified");
	}

	@Test(enabled = false, priority = 10, description = "selectionOfHelpAndSupportAfterLogin")
	public void selectionOfHelpAndSupportAfterLogin() {
		ExtentReport.createTest("selectionOfHelpAndSupportAfterLogin");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickMenuOption(driver);
		menu.clickHelpNSupport(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifyHelpAndSupportHeaderText(), true,
				"Help And Support Header Text Not available after click on Help N support");
		driver.navigate().back();
		as.assertAll();
		log.info("Successfully Help and Support After Login Functionality verified");
	}

	@Test(enabled = false, priority = 11, description = "selectionOfSurePointsAfterLogin")
	public void selectionOfSurePointsAfterLogin() {
		ExtentReport.createTest("selectionOfSurePointsAfterLogin");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickMenuOption(driver);
		menu.clickSurePoints(driver);
		menu.clickCloseSidebarMenu(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifySurePointsBalance(), true,
				"Sure Point Balance Text Not available in Sure Point Page");
		as.assertAll();
		log.info("Successfully Sure Point After Login Functionality verified");

	}

	@Test(enabled = false, priority = 12, description = "selectionOfSurePointsFAQsAfterLogin")
	public void selectionOfSurePointsFAQsAfterLogin() {
		ExtentReport.createTest("selectionOfSurePointsFAQsAfterLogin");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickMenuOption(driver);
		menu.clickSurePointsFAQs(driver);
		menu.clickCloseSidebarMenu(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifySurePointsFAQsText(), true,
				"Sure Point FAQ's Text Not available in Sure Point FAQ Page");
		as.assertAll();
		menu.clickMenuOption(driver);
		log.info("Successfully Sure Point FAQ's AfterLogin Functionality verified");

	}

	@Test(enabled = true, priority = 13, description = "selectionOfFAQsAfterLogin")
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

	@Test(enabled = true, priority = 14, description = "selectionOfAboutEatSureAfterLogin")
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

	@Test(enabled = true, priority = 15, description = "selectionOfTermsNConditionsAfterLogin")
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

	@Test(enabled = true, priority = 16, description = "selectionOfPrivacyPolicyAfterLogin")
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

	@Test(enabled = true, priority = 17, description = "selectionOfPartyOrdersAfterLogin")
	public void selectionOfPartyOrdersAfterLogin() {
		ExtentReport.createTest("selectionOfPartyOrdersAfterLogin");
		MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
		menu.clickPartyOrders(driver);
		as = new SoftAssert();
		as.assertEquals(menu.verifyContactUs(), true, "ContactUs Text Not available");
		as.assertAll();
		menu.clickEatsureLogo(driver);
		menu.clickMenuOption(driver);
		menu.logOut();
		menu.confirmLogOut();
		log.info("Successfully Party Orders AfterLogin Functionality verified");
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
