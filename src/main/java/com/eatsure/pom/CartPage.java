package com.eatsure.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;


public class CartPage extends BasePage {

	public WebDriver driver;

	public CartPage(WebDriver driver) {
		// super(driver);
		PageFactory.initElements(driver, this);
	}

	SoftAssert asrt = new SoftAssert();

	// Locator of Cart page first product name "Cart summary" section
	@FindBy(css = "[data-qa*='product_name']")
	private WebElement cartPageProductName;

	// Locator of Cart page "Eatsure Logo Icon" link section
	@FindBy(xpath = "//a[@data-qa='headerEatsureLogo']")
	private WebElement cartPageHomeLink;

	// Locator of phone number TextBox
	@FindBy(xpath = "//input[@id='phone_number']")
	private WebElement phoenNumberTextBox;

	// Locator of "Login with OTP" button
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement loginwithOTPButton;

	// Locator of "Verify" OTP button
	@FindBy(xpath = "//button[@role='submit']")
	private WebElement verifyOTPButton;

	// Locator of "Choose delivery Address" section title from Checkout page
	@FindBy(xpath = "(//p[starts-with(@class,'style__StepsHeading-kx4xgq-10 epcJhS')])")
	private WebElement addressSectionTitle;

	// Locator of "Deliver Now" button from checkout page
	@FindBy(xpath = "//button[normalize-space()='Deliver Now']")
	private WebElement deliverNowButton;

	// Locator of "Delivery later" button from checkout page
	@FindBy(xpath = "(//button[starts-with(@class,'Button-sc-3qnwiq-0 bmjZIf')])")
	private WebElement deliveryLaterButton;

	// Locator of "selected address" from cart page
	@FindBy(xpath = "//div[@class='address']")
	private WebElement selectedDeliveryAddress;

	// Locator of "Change Address" button link
	// @FindBy(xpath = "//button[normalize-space()='Change Address']")
	@FindBy(xpath = "//button[normalize-space()='Change']")
	private WebElement changeAddressButton;

	// Locator of "Delete" button link
	@FindBy(xpath = "//button[normalize-space()='Delete']")
	private WebElement deleteButton;

	// Locator of create address edit option
	@FindBy(xpath = "(//button[@class='edit'])[2]")
	private WebElement editAddress;

	// Locator of "address" radio button
	@FindBy(css = "[data-qa*='radioButton']")
	private WebElement addressRadioButton;

	// Locator of "Yes" button
	@FindBy(css = "[data-qa*='changeLocationBtnProductInCart']")
	private WebElement yesButton;

	// Locator of "Add New Address" button
	@FindBy(css = "[data-qa*='addNewAddressCTA']")
	private WebElement addnewAddressButton;

	// Locator of "Confirm Location and Proceed" button
	@FindBy(css = "[data-qa*='confirmLocationBtn']")
	private WebElement confiemLocationandProceedButton;

	// Locator of "home_address" text box
	@FindBy(xpath = "//input[@id='home_address']")
	private WebElement homeAddressTextbox;

	// Locator of "society_name" text box
	@FindBy(xpath = "//input[@id='society_name']")
	private WebElement societyNameTextbox;

	// Locator of "nearest_landmark" text box
	@FindBy(xpath = "//input[@id='nearest_landmark']")
	private WebElement nearestLandmarkTextbox;

	// Locator of "others" button
	@FindBy(xpath = "//li[normalize-space()='Others']")
	private WebElement othersButton;

	// Locator of "other_address_type" text box
	@FindBy(xpath = "//input[@id='other_address_type']")
	private WebElement otherAddressTypeTextbox;

	// Locator of "Save Address Details" button
	@FindBy(xpath = "//button[@id='btn-submit']")
	private WebElement saveAddressDetailsButton;

	// locator of "change" option in address section
	@FindBy(xpath = "//button[text()='Change']")
	private WebElement changeAddress;

	// Locator of "To add extra instruction" button
	@FindBy(xpath = "//input[@data-qa='extraInstructions']")
	private WebElement addextraInstructions;

	// Locator of "To enter extra instruction" button
	@FindBy(css = "[data-qa='extraInstructions']")
	private WebElement enterextraInstructions;

	// Locator of "Add Instructor" button
	// @FindBy(xpath = "//button[normalize-space()='Add Instruction']")
	@FindBy(xpath = "//div[starts-with(@class,'style__OptionalText')]")
	private WebElement addInstructorButton;

	// locator for cart right side table bill details
	@FindBy(xpath = "(//div[starts-with(@class,'style__CartDetails')])[2]")
	private WebElement cartBillDetailsTable;

	// locator for cart page right container
	@FindBy(xpath = "//div[starts-with(@class,'style__RightContainer')]")
	private WebElement rightContainer;

	// Locator of "Explore" button
	@FindBy(xpath = "//button[@data-qa='exploreCoupons']")
	private WebElement exploreButtonCoupon;

	// locator for cart page coupon description
	@FindBy(css = "[data-qa*='couponDescriptionText']")
	private WebElement desCoupon;

	// Locator of "Remove" option in extra Instruction
	@FindBy(xpath = "//input[@data-qa='extraInstructions']/following-sibling::button")
	private WebElement removeOption;

	// Locator of "Select free Dish" button
	@FindBy(xpath = "//button[normalize-space()='Select Dish']")
	private WebElement selectFreeDishButton;

	// Locator of "Checkout Now" button from free dish
	@FindBy(css = "[data-qa*='checkoutNow']")
	private WebElement checkOutnowButton;

	// locator of "Pickup Now" button
	@FindBy(xpath = "//button[normalize-space()='Pickup Now']")
	public WebElement pickupNow;

	// locator to get "pickup" text from checkout
	@FindBy(xpath = "//div[starts-with(@class,'sc-hKwCoD')]//p[normalize-space()='Pickup Address']")
	public WebElement pickupAddressText;

	// locator for header title text
	@FindBy(css = "[data-qa*='pageHeading']")
	private WebElement cart_title;

	// locator for cart page breadcrum
	@FindBy(css = "[data-qa*='breadcrumbsSection']")
	private WebElement cartBreadcrum;

	// locator to verify the login box title
	@FindBy(css = "[data-qa*='authWrapHeading']")
	private WebElement login_title;

	@FindBy(id = "login_subheading")
	private WebElement loginBox_Text;

	@FindBy(css = "[data-qa*='productPrice']")
	private WebElement offerPrice;

	@FindBy(css = "[data-qa='freeDishSectionTitle']")
	private WebElement freePorudct_Herader;

	@FindBy(css = "[data-qa*='changeUserCTA']")
	private WebElement changeUser;

	@FindBy(xpath = "//div[@class='item-locked']")
	private WebElement freeDishStatus;

	@FindBy(xpath = "//button[@data-qa='exploreFreedish']")
	private WebElement freeDishExplore;

	@FindBy(xpath = "(//div[@data-qa='freeProductModalProductName'])[2]")
	private WebElement secondFreeProduct;

	@FindBy(xpath = "//button[@data-qa='checkoutNow']")
	private WebElement checkOutNowButton;

	@FindBy(css = "[data-qa*='freeProductModalHeading']")
	private WebElement freeBoxTitle;

	// selected free product name
	@FindBy(css = "[data-qa*='freeDishProductName']")
	private WebElement selectFreeProduct;

	// locator for coupon section
	@FindBy(xpath = "//div[starts-with(@class,'style__CouponsOnlyWrapper')]")
	private WebElement couponSection;

	// Locator for coupon pop up title
	@FindBy(xpath = "//p[@data-qa='couponModalHeading']")
	private WebElement couponTitle;

	// locator for coupon part in the coupon pop up
	@FindBy(id = "fname")
	private static WebElement couponName;

	// locator for coupon apply
	@FindBy(xpath = "(//button[contains(text(),'Apply')])[2]")
	private static WebElement applyCoupon;

	// Locator for coupon pop up close option
	@FindBy(id = "close")
	private static WebElement couponClose;

	// locator for sure point apply button
	@FindBy(xpath = "//button[text()='Apply']")
	private WebElement surePointButton;

	// locator for product quantity
	@FindBy(xpath = "(//div[@data-qa='quantityToShow'])[1]")
	private WebElement quanityProduct;

	// locator for increase quantity
	@FindBy(xpath = "//div[@data-qa='addQuantity']")
	public WebElement increaseQuanity;

	// locator for edit/add button customization
	@FindBy(css = "[data-qa*='customizeProductCTA']")
	private WebElement editButton;

	// locator for reset customization option
	@FindBy(xpath = "//div[@data-qa='resetCustomizationCTA']")
	private WebElement ResetCutomization;

	// locator for total price on top
	@FindBy(css = "[data-qa*='cartSummaryPriceDetails']")
	private WebElement topTotal;

	// Locator for bill details rows
	@FindBy(css = "[data-qa*='billDetailsSectionItemTotal']")
	private WebElement rowsBillDetails;

	// Locator for grand total
	@FindBy(css = "(//div[@class='amount_actual'])[3]")
	private WebElement grandTotal;

	// locator for last total saving price
	@FindBy(xpath = "//div[@class='savingsValue']")
	private WebElement lastTotalSavings;

	// locator for saving calloutbar
	@FindBy(css = "[data-qa*='savingsCalloutTextDetails']")
	private WebElement savingCallOutBar;
	// locator for saving calloutbar arrow
	@FindBy(xpath = "//div[starts-with(@class,'style__ArrowKeyWrapper')]")
	private WebElement callOutBarArrow;
	// locator for saving price in the callout popup
	@FindBy(xpath = "//div[@class='footer_value']")
	private WebElement callOutSaving;
	// locator for close the callout pop up
	@FindBy(xpath = "//div[@data-qa='closeWindowPopup']")
	private WebElement closeCallOut;

	// locator for deliverylater button
	@FindBy(xpath = "//button[@data-qa='deliverLaterCta']")
	private WebElement laterDelivery;

	// locator for delivery later
	@FindBy(id = "close")
	private WebElement deliveryLaterClose;

	// locator for add item
	@FindBy(css = "[data-qa='addItemButton']")
	private WebElement add;

	// Locator for bill details page bill section price
	@FindBy(css = "[class*='style__BillDetailsSection1'] [data-qa*='billDetailsSectionCurrencyWrapper']")
	List<WebElement> billPriceText;

	// locator for log out button click
	@FindBy(xpath = "//div[@data-qa='logOutButton']")
	private WebElement logOutButton;
	// locator for message bxgx apply
	@FindBy(xpath = "//div[starts-with(@class,'style__BXGXAppliedNudge')]")
	private WebElement msgBxgx;

	// locator for BXGX POP UP Continue to Pay
	@FindBy(xpath = "//button[normalize-space()='Continue to Pay']")
	public static WebElement continuePayButton;

	// locator for delivery slot not available screen
	@FindBy(xpath = "//div[starts-with(@class,'style__NoSlotAvailable')]")
	private WebElement slotEmpty;

	// locator for day slot details
	@FindBy(xpath = "//div[starts-with(@class,'style__DayDetail')]")
	private WebElement dayslot;

	// locator for time slot details
	@FindBy(xpath = "//div[@data-qa='radioButton']")
	private WebElement timeslot;

	// locator for close the coupon pop up
	@FindBy(xpath = "//div[starts-with(@class,'styles__CloseButton')]")
	private static WebElement closeCoupon;

	// locator for select next item for combo
	@FindBy(xpath = "//button[normalize-space()='select next item']")
	private WebElement selectNextitem;

	@FindBy(xpath = "//button[normalize-space()='add item']")
	public WebElement addItemButton;
	
	//locator for bill details 
	@FindBy(xpath="(//div[starts-with(@class,'style__Container')])[2]")
	public WebElement billDetails;
	
	//locator for cart page delivery arrow
	@FindBy(xpath="//div[starts-with(@class,'style__IconContainer')]")
	public WebElement arrow;
	
	//locator for delivery charge
	@FindBy(xpath="//div[contains(text(),'Delivery fees')]")
	public WebElement deliverCharge;
	
	//locator for tax charge
	@FindBy(xpath="//div[contains(text(),'Taxes & Charges')]")
	public WebElement taxCharge;
	
	//locator for basket total 
	@FindBy(xpath="//div[normalize-space()='Basket Total']")
	public WebElement Basket;

	/**
	 * Description:- Get Cart Page "Product name"
	 * 
	 * @return
	 */
	public String getProductNameText() {
		String CartPageProductName = cartPageProductName.getText().toString();
		return CartPageProductName;
	}

	/**
	 * Description:- Click on "HOME" link section
	 * 
	 * @param driver
	 */
	public void clickHomeLink(WebDriver driver) {
		click(cartPageHomeLink, driver);

	}

	/**
	 * Description: Enter mobileNumber
	 *
	 * @param MobileNumber
	 */

	public void enterMobileNumber(String MobileNumber) {
		phoenNumberTextBox.sendKeys(MobileNumber);
	}

	/*
	 * Description : clear the mobile number text box
	 */
	public void clearMobileNumber(WebDriver driver) {
		phoenNumberTextBox.clear();
	}

	/**
	 * Description: Click on "Verify" OTP button
	 */

	public void clickVerifyOTP() {
		verifyOTPButton.click();
	}

	/**
	 * Description: Click on clickLoginwithOTPjs
	 * 
	 * @param driver
	 */
	public void clickLoginwithOTPjs(WebDriver driver) {
		clickJavaScript(loginwithOTPButton, driver);

	}

	/**
	 * Description: Click on LoginWithOTP
	 */

	public void clickLoginwithOTP() {
		loginwithOTPButton.click();
	}

	/**
	 * Description: Enter OTP on cart page
	 * 
	 * @author vivek ranjan
	 * @param otp
	 */
	public void enterOTP(WebDriver driver, String otp) {
		// String otp="1907";
		List<WebElement> le = driver
				.findElements(By.xpath("//div[starts-with(@class,'style__OtpInputWrapper')]/div/input"));
//		for(int j=0;j<otp.length();j++) {
//		char k=otp.charAt(j);
//		System.out.println("splited OTP is"+k);
		for (int i = 1, j = 0; i <= le.size(); i++, j++) {
			char k = otp.charAt(j);
			// otp.toCharArray(j);
			System.out.println("splited OTP is:- " + k);
			String s = Character.toString(k);
			driver.findElement(By.xpath("//div[starts-with(@class,'style__OtpInputWrapper')]/div/input[" + i + "]"))
					.sendKeys(s);
		}
		log.info("Successfully entered the correct OTP");
	}

	/**
	 * Description:- add new Address
	 * 
	 * @author vivek ranjan
	 * @param driver
	 */

	public boolean addnewAddress(WebDriver driver) {
		BasePage.waitForVisibility(driver, addnewAddressButton);
		click(addnewAddressButton, driver);
		BasePage.waitForVisibility(driver, confiemLocationandProceedButton);
		click(confiemLocationandProceedButton, driver);
		BasePage.waitForVisibility(driver, homeAddressTextbox);
		BasePage.sendkeys(homeAddressTextbox, "AutotestHomeAddress", driver);
		BasePage.sendkeys(societyNameTextbox, "AutotestSocietyName", driver);
		BasePage.sendkeys(nearestLandmarkTextbox, "AutotestNearestLandmark", driver);
		click(othersButton, driver);
		BasePage.sendkeys(otherAddressTypeTextbox, "ESWEB", driver);
		click(saveAddressDetailsButton, driver);

		try {
			continuePayButton.click();
		} catch (Exception e) {

		}
		return true;

	}

	/**
	 * Description: Click on Address radio button
	 * 
	 * @author vivek ranjan
	 * @param driver
	 * @throws InterruptedException
	 */
	public void clickAddressRadioButton(WebDriver driver) throws InterruptedException {

		try {
			closeCallOut.click();

		} catch (Exception e) {
			System.out.println("All products are active");

		}
		BasePage.waitForVisibility(driver, addressRadioButton);
		clickJavaScript(addressRadioButton, driver);
		Thread.sleep(2000);
		try {
			continuePayButton.click();
		} catch (Exception e) {

		}

	}

	/**
	 * Description:-Delete the existing address
	 * 
	 * @author vivek ranjan
	 * @param driver
	 */
	public void deleteexistingAddress(WebDriver driver) {
		System.out.println("Vivek Address" + changeAddressButton.isDisplayed());
		if (changeAddressButton.isDisplayed()) {
			click(changeAddressButton, driver);
			click(deleteButton, driver);
			click(yesButton, driver);
			try {
				continuePayButton.click();
			} catch (Exception e) {

			}
		}
	}

	public boolean editexistingAddress(WebDriver driver) throws InterruptedException {
		if (changeAddressButton.isDisplayed()) {
			changeAddressButton.click();
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("window.scrollBy(0, 400)");
			Thread.sleep(3000);
			editAddress.click();
			BasePage.waitForVisibility(driver, confiemLocationandProceedButton);
			click(confiemLocationandProceedButton, driver);
			BasePage.waitForVisibility(driver, homeAddressTextbox);
			otherAddressTypeTextbox.clear();
			BasePage.sendkeys(otherAddressTypeTextbox, "EsWeb", driver);
			click(saveAddressDetailsButton, driver);
			return true;

		}
		return false;

	}

	/*
	 * Description: verify address section display
	 */
	public boolean checkAddress() {
		if (addnewAddressButton.isDisplayed()) {

			return true;
		}
		return false;
	}

	/**
	 * Description:- Add extra instruction
	 * 
	 * @author vivek ranjan
	 * @param driver
	 */
	public void addextraInstruction(WebDriver driver) {
		BasePage.waitForVisibility(driver, addextraInstructions);
//		BasePage.scrollToElement(driver, addInstructorButton, 2);
		clickJavaScript(addextraInstructions, driver);
		// click(addextraInstructions, driver);
		BasePage.waitForVisibility(driver, enterextraInstructions);
		BasePage.sendkeys(enterextraInstructions, "Test Order from Technology team", driver);
		BasePage.waitForVisibility(driver, addInstructorButton);
		clickJavaScript(addInstructorButton, driver);
		// click(addInstructorButton, driver);
	}

	/*
	 * Description : verify the the right instruction added
	 */
	public String verInstruction() {
		String InstructionText = addextraInstructions.getAttribute("value");
		return InstructionText;
	}

	/**
	 * Description: Click on Select Free Dish
	 * 
	 * @author vivek ranjan
	 * @param driver
	 */
	public void clickSelectFreeDishjs(WebDriver driver) {
		BasePage.waitForVisibility(driver, selectFreeDishButton);
		clickJavaScript(selectFreeDishButton, driver);

	}

	/**
	 * Description: Click on "Checkout Now" buttonas part of "Free Dish"
	 * 
	 * @author vivek ranjan
	 * @param driver
	 */
	public void clickCheckoutNowFreeDishjs(WebDriver driver) {
		BasePage.waitForVisibility(driver, checkOutnowButton);
		clickJavaScript(checkOutnowButton, driver);

	}

	/**
	 * Description- clicking on add new address button
	 * 
	 * @author Lalit
	 * @param driver
	 */
	public void clickAddNewAddress(WebDriver driver) {
		BasePage.waitForVisibility(driver, addnewAddressButton);
		click(addnewAddressButton, driver);
	}

	/*
	 * Description: cart page header text
	 * 
	 * @author soumya
	 */
	public String cartHeaderText() {
		String text = cart_title.getText();
		return text;
	}

	/*
	 * Description: product count
	 * 
	 */
	public int product_Count(WebDriver driver) {
		int count = driver.findElements(By.xpath("//div[starts-with(@class,'style__ProductInfo')]")).size();
		return count;

	}

	/*
	 * Description: verify the cart page Breadcrum
	 */
	public boolean cart_bread() {
		if (cartBreadcrum.isDisplayed()) {
			return true;
		}
		return false;
	}

	/*
	 * Description: verify the login box title
	 */
	public String loginTitle() {
		if (login_title.isDisplayed()) {
			String loginText = login_title.getText();
			return loginText;
		}
		return "login title not showing";
	}

	/*
	 * Description: verify login_subheading
	 */
	public String loginSubheading() {
		if (loginBox_Text.isDisplayed()) {
			String subheading = loginBox_Text.getText();
			return subheading;
		}
		return "Subheading not showing";

	}

	/*
	 * Description: checking before number put login submit button should disable
	 */
	public boolean loginButton() {
		if (loginwithOTPButton.isEnabled()) {
			return true;
		}
		return false;
	}

	/*
	 * Description : free product header
	 */
	public String freeHearder() {
		if (freePorudct_Herader.isDisplayed()) {
			String freeHeaderText = freePorudct_Herader.getText();
			return freeHeaderText;
		}
		return null;

	}

	public void scrollChangeUser(WebDriver driver) {
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js5.executeScript("arguments[0].scrollIntoView();", changeUser);

	}

	/*
	 * Description : free dish status check and explore button click
	 */
	public void exploreButton() {

		freeDishExplore.click();

	}

	public String freestatusText() {
		String text = freeDishStatus.getText();
		return text;

	}

	/*
	 * Description: verify the 2nd free product and get product name
	 */
	public String secondProductTextClick() {
		String SecondProductName = secondFreeProduct.getText();
		secondFreeProduct.click();
		return SecondProductName;
	}

	/*
	 * Description:checkot button verify and click
	 */
	public void checkOut() {
		if (checkOutNowButton.isDisplayed()) {
			checkOutNowButton.click();
		}
	}

	/*
	 * Description: select free product name
	 */
	public String selectFreeProductName() {
		String SelectProductName = selectFreeProduct.getText().trim();
		return SelectProductName;
	}

	/*
	 * Descrbtion:verify the free product box title
	 */
	public String freeBoxText() {
		String Text = freeBoxTitle.getText().split(",")[0];
		return Text;

	}

	/*
	 * Description: verify the "Remove" option showing
	 */
	public boolean remove() {
		if (removeOption.isDisplayed()) {
			removeOption.click();
			return true;
		}
		return false;
	}

	/*
	 * Description : get the available coupon from cart page
	 */
	public String cartCouponCount() {
		String countText = desCoupon.getText().split("\\(")[1].split(" ")[0];
		return countText;
	}

	/*
	 * description : click on coupon explore button
	 */
	public void clickExploreCoupon() {
		exploreButtonCoupon.click();
	}

	/*
	 * description: coupon title
	 */
	public String couponTitle() {
		if (couponTitle.isDisplayed()) {
			String couponTitleText = couponTitle.getText();
			return couponTitleText;
		}
		return "Wrong title";
	}

	/*
	 * Description : coupon name coupon name count in the coupon pop up
	 */
	public int couponNameCount() {
		couponName.getText();
		return 0;
	}

	/*
	 * Description : checking the apply coupon code button
	 */
	public static String couponApply() {
		if (applyCoupon.isEnabled()) {
			applyCoupon.click();
			String applyCouponName = couponName.getText();
			log.info("Successfully applied the coupon" );
			return "Successfully applied the coupon ";
		}
		closeCoupon.click();
		log.info("Coupon not applicable" );
		return "Coupon not applicable";
		
	}

	/*
	 * Description: verify the sure point apply button
	 */
	public String applySurePoint() {
		if (surePointButton.isEnabled()) {
			surePointButton.click();
			return "Apply successfull sure point";
		}
		return "Sure point option deisable";
	}
	
	public void increaseone() {
		increaseQuanity.click();
	}

	/*
	 * Description : increase quantity
	 */
	public void increaseQuanity1(WebDriver driver, WebElement element) throws InterruptedException {
		Thread.sleep(2000);
		clickJavaScript(element, driver);
		LocalityPage locality = PageFactory.initElements(driver, LocalityPage.class);
		try {
			addItemButton.isDisplayed();
			clickJavaScript(addItemButton, driver);

		} catch (NoSuchElementException e) {

		}

		try {
			selectNextitem.click();
			locality.confirmComboButton.click();

		} catch (Exception e) {

		}

		try {
			continuePayButton.click();
		} catch (Exception e) {

		}

	}

	/*
	 * Description:count the product quantity
	 */
	public int productQuantity() {
		String quanityText = quanityProduct.getText();
		int quantity = Integer.parseInt(quanityText);
		return quantity;
	}

	public static void continuePayButton() {

		try {
			continuePayButton.click();
		} catch (Exception e) {

		}

	}

	/*
	 * Description : verify the edit button
	 */
	public boolean editCostomization(WebDriver driver) throws InterruptedException {
		if (editButton.isDisplayed()) {
			editButton.click();
			Thread.sleep(2000);
			if (ResetCutomization.isDisplayed()) {
				driver.findElement(By.id("close")).click();
			}
			return true;
		}
		return false;
	}

	/*
	 * Description : get the total price in the cart from top
	 */
	public String totalPriceTop() {
		String totalText = topTotal.getText();
		// int totalTop = Integer.parseInt(totalText.split(" ")[0]);
		return totalText;
	}

	/*
	 * Description : Grand total bill
	 */
	public int finalTotal() {

		String grand_Total = grandTotal.getText().replace("\u20b9", "").toString().trim();
		int total=Integer.parseInt(grand_Total.split("")[0]);
		return total ;
	}

	/*
	 * Description : total saving price
	 */
	public String totalSaving() {
		String savingText = lastTotalSavings.getText();
		return savingText;
	}

	/*
	 * Description: text for saving callout green bar
	 */
	public String savingCallOut() {
		String callOut = savingCallOutBar.getText();
		return callOut;
	}

	/*
	 * Description : arrow for callout bar
	 */
	public void arrowCallOut() {
		callOutBarArrow.click();
	}

	/*
	 * Description: text for saving callout green bar
	 */
	public String calloutPopUpSaving() {
		String callOut2 = callOutSaving.getText();
		return callOut2;
	}

	public void closeCallOut() {
		closeCallOut.click();
	}

	/*
	 * Description : delivery later button verify
	 */
	public boolean delivery() {
		if (laterDelivery.isDisplayed()) {
			laterDelivery.click();
			return true;
		}
		return false;
	}

	/*
	 * Description :Delivery later pop up close
	 */
	public void closeDelivery() {
		deliveryLaterClose.click();
	}

	/*
	 * Description :bill details part verify 
	 * @author: Soumya
	 */
	public boolean bill() {
		if(billDetails.isDisplayed()) {
			return true;
		}
		return false;
	}
	/*
	 * Description :bill details page total bill calculation
	 */
	public int totalBill() {
		int sum = 0;
		for (int i = 0; i < billPriceText.size(); i++) {
			String priceText = billPriceText.get(i).getText().replace("\u20b9", "").trim();
			int price = Integer.parseInt(priceText);
			sum += price;
		}
		return sum;

	}

	/*
	 * Description for scroll right container in cart
	 */
	public void scrollRightContainer(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"document.querySelector(\".style__SummaryContainer-kx4xgq-13.dlNduz.scroll-container\").scrollTop=2000");
	}

	/*
	 * Description verify the coupon section
	 */

	public boolean offerSection() {
		if (couponSection.isDisplayed()) {
			return true;
		}
		return false;
			}
	
	public void clickArrow() {
		arrow.click();
	}
	/*
	 * Description verify the delivery later section;
	 */
	public boolean deliveryslot() {
		if (dayslot.isDisplayed()) {
			timeslot.isSelected();
			return true;
		}
		return false;

	}
	
	/*
	 * Describtion:verify the bill list options
	 */
	public boolean billList() {
		if(Basket.isDisplayed()&& taxCharge.isDisplayed() && deliverCharge.isDisplayed()  ) {
			return true;
			}
		return false;
	}
}
