package com.eatsure.sampletest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
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
import com.eatsure.pom.ProductDetailPage;
import com.eatsure.reports.ExtentReport;
import com.eatsure.utils.ReadPropertyFile;
import com.eatsure.validation.ValidateTitle;

public class D2C_VR_ESWEB_Regression_cart {

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
		as.assertEquals(locality.verifylLocalityPageRewardPoint(driver), true,
				"Locality page Get Rewarded for eating good mismatch");
		as.assertEquals(locality.verifylLocalityPageCombosFromMutipleRestaurants(driver), true,
				"Locality page Combos from Multiple Restaurants mismatch");
		as.assertAll();

		log.info("Successfully validated Locality Page Content");
	}

	@Test(enabled = true, priority = 2, description = "product added to cart")
	public void product_add() throws InterruptedException {
		ExtentReport.createTest("product added to cart");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();

		// Add dynamic product to Cart from Home/Locality Page
		/*
		 * locality.addDynemiComboOftwoProduct(driver); String LocalityPageProductName =
		 * locality.getProductNameText(); log.info("#LocalityPageProductName  #" +
		 * LocalityPageProductName); // Click on "CART" option
		 * locality.clickCartOption(driver); CartPage cart =
		 * PageFactory.initElements(driver, CartPage.class); String CartPageProductName
		 * = cart.getProductNameText(); log.info("#CartPageProductName  #" +
		 * CartPageProductName); cart.clickHomeLink(driver);
		 */
       //Vivek commented during code merge on 02-Nov-2023
//		locality.navigateToBrand();
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		brand.addFirstItem(driver);
		Thread.sleep(2000);
		// brand.clickAddItem();
		// brand.clickContinue(driver);
		brand.exceptionProductAdd();
		log.info("Successfully Added Normal Product with Customization from RestaurantPage to Cart");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		cart.clickHomeLink(driver);
		//Vivek commented during code merge on 02-Nov-2023
//		locality.navigateToBrandFirst();
		// brand.addDynemiComboOfThreeProduct(driver);
		brand.addFirstItem(driver);
		Thread.sleep(2000);
		brand.exceptionProductAdd();

	}

	@Test(enabled = true, priority = 3, description = "cart header  contain")
	public void cart_header() {
		ExtentReport.createTest("cart header contain");
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		as = new SoftAssert();
		as.assertEquals(locality.verifyLocalityPagHeaderLogo(), true, "es logoo not showing in the cart page");
		as.assertAll();
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();
		as.assertEquals(cart.cartHeaderText(), "Secure Checkout", "es logoo not showing in the cart page");
		as.assertAll();

	}

	@Test(enabled = true, priority = 4, description = "cart page Breadcrum")
	public void cart_Breadcrum() throws InterruptedException {
		ExtentReport.createTest("cart page Breadcrum");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();
		as.assertEquals(cart.cart_bread(), true, "Breadcrums section not showing");
		log.info("Breadcrums setion is showing");
		// breadcrum print
		WebElement Bread_Section = driver.findElement(By.cssSelector("[data-qa*='breadcrumbsSection']"));
		List<WebElement> link_count = Bread_Section.findElements(By.tagName("a"));
		int Bread_count = link_count.size();
		for (int i = 0; i < Bread_count; i++) {

			WebElement a = link_count.get(i);
			String text = a.getText();
			log.info(text);
		}

	}

	@Test(enabled = true, priority = 5, description = "login content part")
	public void loginPart() throws InterruptedException {
		ExtentReport.createTest("login content part");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();
		// verify the login part
		as.assertEquals(cart.loginTitle(), "Login/Sign Up", "login title name not matching");
		as.assertAll();
		log.info("verify the login title " + cart.loginTitle());
		as.assertEquals(cart.loginSubheading(), "To place your order now, log in to your account",
				"login subheading text  not matching");
		as.assertAll();
		log.info("verify the login Subheading");
		// verify login button should disable before the number put
		as.assertEquals(cart.loginButton(), false, "login button not disable ");
		as.assertAll();
		log.info("Verify the login button diable before number put");

	}

	@Test(enabled = true, priority = 6, description = "verify login functionality ")
	public void loginFunction() throws InterruptedException {
		ExtentReport.createTest("verify login functionality");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();
		cart.enterMobileNumber(ReadPropertyFile.get("WrongNumber"));
		Thread.sleep(2000);
		as.assertEquals(cart.loginButton(), false, "login button not disable ");
		as.assertAll();
		cart.clearMobileNumber(driver);
		cart.enterMobileNumber(ReadPropertyFile.get("MobilenumberFixedOTP"));
		Thread.sleep(1000);
		cart.clearMobileNumber(driver);
		as.assertEquals(cart.loginButton(), true, "login button  disable after 10 number put ");
		as.assertAll();
		log.info("Verify after 10 digit number put only login button enable");
		// verify address section should be hide before login
		/*
		 * as.assertEquals(cart.checkAddress(), false,
		 * "Before login address section not hide"); as.assertAll();
		 * log.info("Verify address section hide before login");
		 */
	}

	@Test(enabled = true, priority = 7, description = "verify befoe login  the product count same as after login count")
	public void beforelogin_productcount() throws InterruptedException {
		ExtentReport.createTest("verify befoe login  the product count same as after login count");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();
		// before login product count
		int count_before = driver.findElements(By.cssSelector("[data-qa*='productCardInfo']")).size();
		// verify the product price before login
		String before_price = driver.findElement(By.cssSelector("[data-qa*='productPrice']"))
				.getText();
		// login
		cart.enterMobileNumber(ReadPropertyFile.get("MobilenumberFixedOTP"));
		Thread.sleep(1000);
		cart.clickLoginwithOTP();
		cart.enterOTP(driver, ReadPropertyFile.get("otp"));
		//cart.clickVerifyOTP();
		// after login product count
		int count_after = driver.findElements(By.cssSelector("[data-qa*='productCardInfo']")).size();
		String after_price = driver.findElement(By.cssSelector("[data-qa*='productPrice']"))
				.getText();

		as.assertEquals(count_before, count_after, "after login product is not showing");
		log.info("verify the product count before and after login");
		as.assertEquals(before_price, after_price, "after login product price show different");
		log.info("verify the product price before and after login");

	}

	@Test(enabled = true, priority = 8, description = "verify address section")
	public void addressSection() throws InterruptedException {
		ExtentReport.createTest("verify the address section");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();
		// verify address section should be hide before login
		int extistiingTotalAddress = driver
				.findElements(By.xpath("//div[starts-with(@class,'style__AddressCardWrapper')]")).size();
		log.info("Before add address total existing address count " + extistiingTotalAddress);
		// verify add address option should show after login login
		as.assertEquals(cart.checkAddress(), true, "After login address section not hide");
		as.assertAll();
		log.info("Verify address section show after login");
		// add address
		as.assertEquals(cart.addnewAddress(driver), true, "Add address doesn't works");
		as.assertAll();
		log.info("Verify the Add address");
		/*
		 * int afterTotalAddress = driver.findElements(By.xpath(
		 * "//div[starts-with(@class,'style__AddressCardWrapper')]")).size();
		 * log.info("After add address total existing address count " +
		 * afterTotalAddress);
		 */
		// verify selected address should be add address
		as.assertEquals(driver.findElement(By.cssSelector(".nickNameWrapper")).getText(), "ESWEB");
		as.assertAll();
		log.info("verify the add address is selected");
		// edit address
		as.assertEquals(cart.editexistingAddress(driver), true, "edit address not working");
		as.assertAll();
		log.info("Verify the edit address");
		// verify the edit successfully edit address selected
		as.assertEquals(driver.findElement(By.cssSelector(".nickNameWrapper")).getText(), "EsWeb");
		as.assertAll();
		log.info("Verify the edit address sucessfully selected");
		// verify the delete address functionality
		cart.scrollChangeUser(driver);
		Thread.sleep(2000);
		cart.deleteexistingAddress(driver);
		int afterdelete = driver.findElements(By.cssSelector("[data-qa*='listOfAddress']"))
				.size();
		as.assertEquals(afterdelete, extistiingTotalAddress);
		as.assertAll();
		log.info("verify the delete address " + afterdelete);
		cart.clickAddressRadioButton(driver);

	}

	@Test(enabled = true, priority = 9, description = "verify freeproduct section")
	public void freeProudct() throws InterruptedException {
		ExtentReport.createTest("verify free product section");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"document.querySelector('.style__SummaryContainer-kx4xgq-13.Qyig.scroll-container').scrollTop=400");
		// verify the free product header text
		as.assertEquals(cart.freeHearder(), "You're eligible for a FREE Dish", "free dish header not matching");
		as.assertAll();
		log.info("Verify the free dish header");
		// verify the free dish status
		Thread.sleep(5000);
		as.assertEquals(cart.freestatusText(), "Item Unlocked");
		as.assertAll();
		log.info("verify the freedish part status");
		log.info("free status text" + cart.freestatusText());
		// verify the free dish pop explore button
		cart.exploreButton();
		as.assertEquals(cart.freeBoxText(), "Congratulations", "free product box not opening");
		as.assertAll();
		log.info("Verify the freedish pop up Exlpore button");
		// verify the free product select
		String freeProductName = cart.secondProductTextClick();
		log.info("Selected free product name from free product list " + cart.secondProductTextClick());
		cart.checkOut();
		Thread.sleep(3000);
		log.info("Free product name show in the cart page after select the free product "
				+ cart.selectFreeProductName());
		as.assertEquals(freeProductName, cart.selectFreeProductName(), "Free product select not working properly");
		log.info("Successfully Verify the selection of the freeproduct");
		// after select the free product "Do you want to clam it" button should be
		// select
		//as.assertEquals(driver.findElement(By.xpath("//span[@class='slider round']")).isEnabled(), true,"Do you want clam it button not selected");
		as.assertEquals(
				driver.findElement(By.cssSelector(".unlock-free-dish-title")).getText().trim(),
				"FREE Dish Added!");
		as.assertAll();
		log.info("verify the button selected and title change after select the free product");
	}

	@Test(enabled = true, priority = 10, description = "verify instruction section")
	public void instruction() throws InterruptedException {
		ExtentReport.createTest("verify Extra Instruction section");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();
		cart.addextraInstruction(driver);
		log.info("added exrta instruction" + cart.verInstruction());
		as.assertEquals(cart.verInstruction(), "Test Order from Technology team",
				"Extra instarction not added properly");
		as.assertAll();
		log.info("Sucessfully Verify the Extra Instruction Text");
		as.assertEquals(cart.remove(), true, "Remove option is not showing");
		as.assertAll();
		log.info("Sucessfully verify the remove option");

		as.assertTrue(driver.findElement(By.xpath("//input[@data-qa='extraInstructions']")).getAttribute("placeholder")
				.contains("Write cooking instructions"), "remove doesn't work");
		as.assertAll();
		log.info("Successfully remove the Extra Instruction ");

	}

	@Test(enabled = true, priority = 11, description = "verify coupon section")
	public void coupon() throws InterruptedException {
		ExtentReport.createTest("verify coupon section");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();

		int couponSizeCart = Integer.parseInt(cart.cartCouponCount());
		log.info("Coupon available show in the cart page description " + couponSizeCart);
		cart.clickExploreCoupon();
		as.assertEquals(cart.couponTitle(), "Explore offers for You", "Coupon title not matching");
		as.assertAll();
		log.info("Successfuly verify the Coupon Title");

		// checking the coupon count in the coupon popup
		int couponNameCount = driver.findElements(By.id("fname")).size();
		as.assertEquals(couponNameCount, couponSizeCart, "cart coupon count and couponpop count not same");
		log.info("Sucessfully verify the coupon pop coupon count " + couponNameCount
				+ " same as count available show in the cart " + couponSizeCart);
		log.info(cart.couponApply());

		// verify the sure point part
		log.info(cart.applySurePoint());

	}

	@Test(enabled = true, priority = 12, description = "verify customization section")
	public void customization() throws InterruptedException {
		ExtentReport.createTest("verify customization and quanity of the product section");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);

		as = new SoftAssert();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"document.querySelector('.style__SummaryContainer-kx4xgq-13.Qyig.scroll-container').scrollTop=-400");
		Thread.sleep(3000);
		String fristProductPriceText = driver.findElement(By.cssSelector("[class*='style__CartOfferPrice']:nth-child(1)"))
				.getText().replace("\u20b9", "").toString().trim();
		System.out.println("price is " + fristProductPriceText);
		int fristProductPrice = Integer.parseInt(fristProductPriceText);
		log.info(fristProductPrice);
		// quantity check
		int beforeQuantity = cart.productQuantity();
		log.info("Before increase the product quanity " + beforeQuantity);
		cart.increaseQuanity1(driver, cart.increaseQuanity);
		BrandRestaurantPage brand = PageFactory.initElements(driver, BrandRestaurantPage.class);
		
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

	@Test(enabled = true, priority = 13, description = "verify calculation section")
	public void productPriceCalculation() throws InterruptedException {
		ExtentReport.createTest("verify calculation section");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();
		// ArrayList<Integer> prices = new ArrayList<Integer>();
		List<WebElement> productSlashPriceText = driver.findElements(By
				.cssSelector("[class*='style__CartOfferPrice']"));
		int SlashWithSum = 0;
		for (int i = 0; i < productSlashPriceText.size(); i++) {

			SlashWithSum = SlashWithSum
					+ Integer.parseInt(productSlashPriceText.get(i).getText().replace("\u20b9", "").toString().trim());
		}
		List<WebElement> productSlashPriceOnly = driver
				.findElements(By.cssSelector("[data-qa*='slashedPrice']"));
		int slashOnly = 0;
		for (int i = 0; i < productSlashPriceOnly.size(); i++) {

			slashOnly = slashOnly
					+ Integer.parseInt(productSlashPriceOnly.get(i).getText().replace("\u20b9", "").toString().trim());
		}
		int TotalBillPrice = SlashWithSum - slashOnly;

		log.info("add the prodcut price and get total bill price " + TotalBillPrice);
		String totalPriceTopText = driver.findElement(By.cssSelector("[data-qa*='cartSummaryPriceDetails']")).getText()
				.replace("\u20b9", "").toString().trim();
		int totalPriceTop = Integer
				.parseInt(totalPriceTopText.split(" ")[0].replace("incl", "").replace(",", "").toString().trim());
		as.assertEquals(TotalBillPrice, totalPriceTop, "Total price not matching");
		as.assertAll();
		log.info("Successfully verify the total product price and total top bill price " + totalPriceTop);
	}

	@Test(enabled = true, priority = 14, description = "verify Bill details calculation section")
	public void billCalculation() throws InterruptedException {
		ExtentReport.createTest("verify calculation section");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"document.querySelector('.style__SummaryContainer-kx4xgq-13.Qyig.scroll-container').scrollTop=800");
		Thread.sleep(3000);
		List<WebElement> rowsDetails = driver.findElements(By.xpath("//div[@id='mobile_cart_page_bill_details_section']/div[starts-with(@class,'FlexContainer')]"));
	
		for (WebElement listItem : rowsDetails) {
		    if (listItem.getText().contains("SurePoints")|| listItem.getText().contains("Coupon Savings")) {
		        // Get the price from the sibling element
		    	
		        WebElement priceElement = listItem.findElement(By.cssSelector("[data-qa*='billDetailsSectionCurrencyWrapper']"));
		        String priceText = priceElement.getText().split("₹")[1].trim();
		        int price = Integer.parseInt(priceText.replaceAll("[^0-9-]", ""));
		        System.out.println("The price of discount is: " + price);
		        int totalBill_Price = cart.totalBill() - price;
		        log.info("Total bill price from bill details " + totalBill_Price); 
		        as.assertEquals(totalBill_Price, cart.finalTotal(),"bill calculation not matching with grand total");
		        as.assertAll();
		        log.info("Successfully verify the bill calculation");
		    }
		}
		
		    
	}

	@Test(enabled = true, priority = 15, description = "verify savings section")
	public void Savings() throws InterruptedException {
		ExtentReport.createTest("verify Savings section");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();
		int totalSavingPrice =Integer.parseInt(cart.totalSaving().replace("\u20b9", "").toString().trim());
		int savingGreenBar = Integer.parseInt(cart.savingCallOut().split(" ")[0].replace("\u20b9", "").toString().trim());
		as.assertEquals(totalSavingPrice, savingGreenBar, "Not match the total saving with saving callOut bar");
		as.assertAll();
		log.info("successfully verify the total saving with savingCallOut option");
		cart.arrowCallOut();
		//verify the Saving callout pop up 
		String calloutHeading =  driver.findElement(By.cssSelector("[data-qa*='savingsCalloutModalHeading']")).getText();
		as.assertEquals(calloutHeading, "Savings only on EatSure");
		as.assertAll();
		log.info("Successfuuly verify the Saving callout pop up section Heading");
		int callOutPopUpSavings =Integer.parseInt(cart.calloutPopUpSaving().replace("\u20b9", "").toString().trim());
		as.assertEquals(totalSavingPrice, callOutPopUpSavings, "Not match the total saving with saving callOut bar popup saving");
		as.assertAll();
		log.info("Successfully verify the saving total in the callout pop up");
	//	int grand_Total = Integer.parseInt(cart.finalTotal().replace("\u20b9", "").toString().trim());
		cart.finalTotal();
		int calloutGrand_Total = Integer.parseInt(driver.findElement(By.cssSelector("[data-qa*='billDetailsModalFinalPrice']")).getText()
				.replace("\u20b9", "").toString().trim());
		as.assertEquals(cart.finalTotal(), calloutGrand_Total, "total bill calculation not matching  with Grand total");
		as.assertAll();
		log.info("Successfully verify the grand total in the callout pop up ");
		cart.closeCallOut();
		
		}
	@Test(enabled = true, priority = 16, description = "verify Delivery later  section")
	public void deliveryLater() throws InterruptedException {
		ExtentReport.createTest("verify Delivery later section");
		CartPage cart = PageFactory.initElements(driver, CartPage.class);
		as = new SoftAssert();
		as.assertEquals(cart.delivery(), true, "Delivery later option is not there");
		as.assertAll();
		log.info("verify the delievery later option");
		cart.closeDelivery();
	}
	
	@AfterClass
	public void close() {
		driver.close();
	}
	

}
