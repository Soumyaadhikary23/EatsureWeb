package com.eatsure.sampletest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eatsure.browser.Driver;
import com.eatsure.pom.BasePage;
import com.eatsure.pom.CartPage;
import com.eatsure.pom.LandingPage;
import com.eatsure.pom.LocalityPage;
import com.eatsure.pom.ProfilePage;
import com.eatsure.reports.ExtentReport;
import com.eatsure.utils.ReadPropertyFile;
import com.eatsure.validation.ValidateTitle;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

public class D2C_VR_ESWEB_Regression_AddressTest extends BasePage {

	public WebDriver driver;
	Driver driver1;
	SoftAssert as;
	public static final Logger log = LogManager.getLogger(D2C_VR_ESWEB_Regression_AddressTest.class.getName());

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
		// locality.navigateToBrand(driver);
//		locality.navigateToBrand();
		log.info("Successfully Added DynamicComboItem To Cart From HomePage");
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
		//Thread.sleep(2000);

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
	
	/*
	 * @Test(enabled = true, priority = 3, description = "loginfromCartpage") public
	 * void verifyAddNewAddress() throws InterruptedException {
	 * ExtentReport.createTest("loginfromCartpage"); CartPage cart =
	 * PageFactory.initElements(driver, CartPage.class); cart.addnewAddress(driver);
	 * log.info("Successfully added the new address on cart page"); }
	 */
	
	@Test(enabled = true, priority = 4, description = "Verify add new address from cart")
	public void verifyAddNewAddressFromCart()
	{
		ExtentReport.createTest("Verify add address flow from checkout page");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		//ProfilePage proPage = PageFactory.initElements(driver, ProfilePage.class);
		
		cart.addnewAddress(driver);
		log.info("Sucessfully added new address from cart");
	}
	
	@Test(enabled = true, priority = 5, description = "Verify delete exisiting address from cart")
	public void verifyDeleteAddressFromCart()
	{
		ExtentReport.createTest("Verify delete existing address from Checkout");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		//ProfilePage proPage = PageFactory.initElements(driver, ProfilePage.class);
		BasePage.wait(10);
		cart.deleteexistingAddress(driver);
		log.info("Successfully deleted address from cart");
	}
	
	@Test(enabled = true, priority = 6, description = "Verify Edit existing address from cart")
	public void verifyEditExistingAddressFromCart()
	{
		ExtentReport.createTest("Verify Edit existing address from cart");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		ProfilePage proPage = PageFactory.initElements(driver, ProfilePage.class);
		
		proPage.editExistingAddress(driver);
		// Find the updated address element
        WebElement updatedAddressTag = driver.findElement(By.xpath("//div[@class='nickNameWrapper']"));
		//String newAddressTag = proPage.addressTag(driver);
		System.out.println("UpdatedAddressTag : "+updatedAddressTag.getText());
		// Assert that the address was updated
        as.assertTrue(updatedAddressTag.isDisplayed(),"not displayed");
		as.assertAll();
		log.info("Successfully Edited the existing address from cart");
	}
	
	@Test(enabled = true, priority = 7, description = "Verify address UI elements")
	public void VerifyAddressScreenElemets()
	{
		ExtentReport.createTest("Verify address UI elements");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		ProfilePage proPage = PageFactory.initElements(driver, ProfilePage.class);
		as = new SoftAssert();
		
		proPage.clickOnProfileName(driver);
		proPage.clickOnManageAddress(driver);
		cart.clickAddNewAddress(driver);
		as.assertEquals(proPage.backArrow(), true, "Back Arrow not displayed ");
		as.assertEquals(proPage.searchLocationBar(), true,"Search bar not displayed");
		as.assertEquals(proPage.zoomInIcon(), true, "Zoom-In Icon not displayed ");
		as.assertEquals(proPage.zoomOutIcon(), true, "Zoom-Out Icon not displayed ");
		as.assertEquals(proPage.yourDeliveryLocation(), true, "Delivery location text mismatch");
		as.assertEquals(proPage.changeBtn(), true, "Changed button not displayed ");
		as.assertEquals(proPage.addressTitle(), true, "Address title not displayed ");
		as.assertEquals(proPage.addressSubText(), true, "Address subtext not displayed ");
		proPage.getCloseAddressPopup().click();
		as.assertAll();
		log.info("Sucessfully verified Address screen Elements");
	}
	
	@Test(enabled = true, priority = 8, description = "Verify add new address from profile")
	public void verifyAddNewAddressFromProfile() throws InterruptedException {
		ExtentReport.createTest("Verify add new address from profile");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		ProfilePage proPage = PageFactory.initElements(driver, ProfilePage.class);
		proPage.clickOnProfileName(driver);
		proPage.clickOnManageAddress(driver);
		//driver.navigate().refresh();
		BasePage.wait(3);
		int addressCountBefore = proPage.getAddressCount(driver);
		cart.addnewAddress(driver);
		BasePage.wait(3);
		driver.navigate().refresh();
		BasePage.wait(3);
		int addressCountAfter = proPage.getAddressCount(driver);
		as.assertNotEquals(addressCountBefore, addressCountAfter,"Address not saved");
		as.assertAll();
		log.info("Successfully added new address from profile");
	}
	
	@Test(enabled = true, priority =9, description = "Verify delete address from Profile")
	public void verifyDeleteAddressFromProfile()
	{
		ExtentReport.createTest("Verify delete address from Profile");
		ProfilePage proPage = PageFactory.initElements(driver, ProfilePage.class);
		proPage.deleteAddress(driver);	
		
	}
	
	@Test(enabled = true, priority =10, description = "Verify edit existing address from Profile")
	public void verifyEditExistingAddressFromProfile()
	{
		ExtentReport.createTest("Verify edit existing address from Profile");
		ProfilePage proPage = PageFactory.initElements(driver, ProfilePage.class);
		proPage.editExistingAddress(driver);	
		BasePage.wait(3);
		// Find the updated address element
        WebElement updatedAddressTag = driver.findElement(By.xpath("//div[contains(text(),'RebelTag')]"));
		//String newAddressTag = proPage.addressTag(driver);
		System.out.println("UpdatedAddressTag : "+updatedAddressTag.getText());
		// Assert that the address was updated
        as.assertTrue(updatedAddressTag.isDisplayed(),"not displayed");
		as.assertAll();
		log.info("Successfully Edited the existing address from profile");
	}
	
	
}
