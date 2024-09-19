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

import com.eatsure.utils.ReadPropertyFile;

public class LocalityPage extends BasePage {

	public LocalityPage(WebDriver driver) {
		// super(driver);
		PageFactory.initElements(driver, this);
	}

	SoftAssert asrt = new SoftAssert();

	// Locate first Brand/Restaurant logo
	@FindBy(xpath = "//div[starts-with(@class,'style__BrandslideWrap-sc')]/a[1]")
	private WebElement brandIconProduction;

	// Condition_Locate first Brand/Restaurant logo
	//@FindBy(xpath = "//div[starts-with(@class,'style__BrandslideWrap-sc')]/a[3]")
	@FindBy(xpath = "//a[@data-qa='brandIcon'][1]")
	private WebElement brandIconCondition;

	// Locate all Brand/Restaurants logo
	@FindBy(xpath = "[data-qa*='brandIcon'] p")
	List<WebElement> allBrandIcon;

	// Locator of Locality page header eatsure logo
	@FindBy(xpath = "(//div[starts-with(@class,'style__FlexContainer-sc-1fhz567-2 kBskru')])[1]/a/img")
	private WebElement localityPageHeadereatsurelogo;

	// Locator of locality page "Choose From Trusted Restaurants in "One Single
	// Order""
	@FindBy(xpath = "(//p[starts-with(@class,'style__Heading-sc')])[1]/span")
	private WebElement localityPageOneSingleOrder;

	// Locator of Locality page "EatSurance"
	// @FindBy(xpath = "//img[@alt='eatsurance-logo']")
	@FindBy(xpath = "//img[@alt='eatsure']")
	private WebElement localityPageEatSurance;

	// Locator of Locality page "Free Dish"
	@FindBy(xpath = "//p[starts-with(@class,'styles__ContentText-sc')]")
	private WebElement localityPageFreeDish;

	// Locator of Locality page "Popular Cuisines headar in your area"
	@FindBy(xpath = "//h3[normalize-space()='Popular Cuisines in your area']")
	private WebElement localityPagePopularCuisinesHeadar;

	// Locator of Locality page "Popular Cuisines content in your area"
	@FindBy(xpath = "(//div[starts-with(@class,'style__HeadingWrapper-sc')])[1]/div/div/p")
	private WebElement localityPagePopularCuisinesContent;

	// Locator of Locality page "Most Loved Collection"
	@FindBy(xpath = "(//div[starts-with(@class,'style__HeadingWrapper-sc')])[2]/h3")
	private WebElement localityPageMostLovedCollections;

	// Locator of Locality page "Get Rewarded for eating good"
	@FindBy(xpath = "(//div[starts-with(@class,'style__HeadingSection-sc')])/h3")
	private WebElement localityPageRewardPoint;

	// Locator of Locality page "Combos from Multiple Restaurants"
	@FindBy(xpath = "//p[starts-with(@class,'ComboSection__Heading-sc')]")
	private WebElement localityPageCombosFromMutipleRestaurants;

	// Locator of Locality page first "Choose Items" button
	@FindBy(xpath = "(//div[starts-with(@class,'style__CardBottom-sz')]/div)[1]/button")
	private WebElement localityPageChooseItemsButton;

	// Locator of Locality page first product name "Combos from Multiple
	// Restaurants"
	@FindBy(xpath = "(//div[starts-with(@class,'style__Card-sz')]/div[2]/div/div/p)[1]")
	private WebElement localityPageProductName;

	// Locator of Locality page Dynamic combo first product "Radio button"
	@FindBy(xpath = "(//label[starts-with(@class,'style__RadioContainer-sc')])[1]")
	private WebElement localityPageDynamicComboRadioButton;

	// Locator of Locality page Dynamic combo "Add Item" Button
	@FindBy(xpath = "//button[text()='add item']")
	private WebElement addItemButton;

	// Locator of Locality page Dynamic combo "Confirm Combo" Button
	@FindBy(xpath = "//button[text()='confirm combo']")
	public WebElement confirmComboButton;

	// Locator of Locality page CART section
	@FindBy(xpath = "//p[normalize-space()='Cart']")
	private WebElement cartOption;

	// Locator of "Explore Restaurants" button under "Choose From Trusted
	// Restaurants in One Single Order"
	@FindBy(xpath = "//button[normalize-space()='Explore Restaurants']")
	private WebElement exploreRestaurantsButton;

	// Locator of "Explore All Dishes" button under "Popular Cuisines in your area"
	@FindBy(xpath = "//button[normalize-space()='Explore All Dishes']")
	private WebElement exploreAllDishesButton;

	// Locator of "Explore All Collections" button under "Most Loved Collections"
	@FindBy(xpath = "//button[normalize-space()='Explore All Collections']")
	private WebElement exploreAllCollectionsButton;

	// Locator of "Explore All Combos" button under "Combos From Multiple
	// Restaurants"
	@FindBy(xpath = "//button[normalize-space()='Explore All Combos']")
	private WebElement exploreAllCombosButton;

	// Locator of Dynamic combo "select next item" Button
	@FindBy(xpath = "//button[text()='select next item']")
	private WebElement selectNextItemButton;

	// locator for BB restaurant
	@FindBy(xpath = "//a[@data-qa='brandIcon']//img[@alt='Behrouz Biryani']")
	private WebElement bbRestaurant;
	
	// Locator of "See All" button under "D2C website Locality page"
	@FindBy(xpath = "(//button[normalize-space()='See all'])[1]")
	public WebElement seeAllButton;

	// Locator for delivery location
	@FindBy(xpath = "//div[starts-with(@class,'style__LocationMobileLabel')]")
	private WebElement locationGet;

	// @locator for search option
	@FindBy(xpath = "//p[@data-qa='searchOption']")
	private WebElement serachOption;

	// locator for help option
	@FindBy(xpath = "//p[@data-qa='helpOption']")
	private WebElement helpOption;

	// Locator for profile logo
	@FindBy(xpath = "//div[starts-with(@class,'style__ProfileIconWrapper')]")
	private WebElement profileLogo;

	// locator for menu bar
	@FindBy(xpath = "(//div[starts-with(@class,'style__MenuContainers-sc')])[3]")
	private WebElement menuOption;

	// Locator for GPS OPTION
	@FindBy(xpath = "//div[@class='gpsText']")
	private WebElement GPS;

	// locator for display location display
	@FindBy(xpath = "//input[@placeholder='Enter locality or street name']")
	private WebElement locationDisplay;

	// locator for change location()
	@FindBy(xpath = "(//div[starts-with(@class,'LocationListstyle__IconWrap')])[1]")
	private WebElement changeLocation;

	/// location for accept the permission for change location
	@FindBy(xpath = "//button[@data-qa='changeLocationBtnProductInCart']")
	private WebElement changeLocationPermission;

	// loactor to change location name
	@FindBy(xpath = "//div[starts-with(@class,'style__LocationMobileLabel')]")
	private WebElement getLocation2;

	// Locator for BREADCRUMBS
	@FindBy(xpath = "//div[@data-qa='breadcrumbsSection']")
	private WebElement localityBreadcrums;

	// locator for banner
	@FindBy(xpath = "(//div[@class='slick-list'])[1]")
	private WebElement localityBanner;

	// locator for banner scroll
	@FindBy(xpath = "(//button[@class='slick-arrow slick-next'])[1]")
	private WebElement bannerScroll;

	// locator for Explore all Restaurant button
	@FindBy(xpath = "//button[@data-qa='exploreAllRestaurant']")
	private WebElement exploreRestaurant;

	// small logo bar locator
	@FindBy(xpath = "//a[@data-qa='brandIcon']")
	private WebElement smallLogoBar;

	// small logo pointer locator
	@FindBy(xpath = "//div[starts-with(@class,'style__BrandImgActive-sc')]")
	private WebElement smallLogoPointer;

	// locator for large restaurant logo
	@FindBy(xpath = "(//div[@class='slick-track'])[2]")
	private WebElement largeRestaurantLogo;

	// locator for larger logo scroll option
	@FindBy(xpath = "(//button[@class='slick-arrow slick-next'])[2]")
	private WebElement largerLogoScroll;

	// locator for slide scroll symbol
	@FindBy(xpath = "(//ul[@class='slick-dots'])[2]/li[@class='slick-active']")
	private WebElement slideScroll;

	// locator for below restaureant text
	@FindBy(xpath = "//h1[text()='Order Food Online from Trusted Restaurants in ']")
	private WebElement reaturantText;
	
	//locator for loyalty card 
	@FindBy(xpath="//div[@id='__surepass_activated_modal_wrapper__']")
	private WebElement LoyaltyCrad;
	

	// Locator for cuisine scroll
	@FindBy(xpath = "(//button[@class='slick-arrow slick-next'])[3]")
	private WebElement cuisineScroll;

	// locator for collection section Explore all collection button
	@FindBy(xpath = "//button[@data-qa='localityExploreAllCollection']")
	private WebElement collectionButton;

	// locator for sure_earning button
	@FindBy(xpath = "//button[normalize-space()='Sign Up & get    500 SurePoints']")
	private WebElement sureEarningButton;

	// locator for esclusive card
	@FindBy(xpath = "//div[starts-with(@class,'ExclusiveCard__CardWrapper')]")
	private WebElement exclusiveCard;

	// locator for free dish unlock section
	@FindBy(xpath = "//div[starts-with(@class,'styles__CardContainer-sc')]")
	private WebElement freeDishUnlock;

	// locator free dish pop up
	@FindBy(xpath = "//div[starts-with(@class,'style__ModalContainer-sc')]")
	private WebElement fressDishPopup;

	// locator for free dish pop up close button
	@FindBy(xpath = "//div[@id='close']")
	private WebElement closeFreeDish;

	// LOCATOR for scroll_freeDish
	@FindBy(xpath = "(//button[@class='slick-arrow slick-next'])[4]")
	private WebElement freeDishScroll;

	// locator for freedish statement
	@FindBy(xpath = "//div[starts-with(@class,'styles__KnowMoreSection-sc')]")
	private WebElement freeDishStatement;

	// locatpr for freedish know more option
	@FindBy(xpath = "//span[normalize-space()='Know more']")
	private WebElement freeKnowMore;

	// locator for coupon view detials
	@FindBy(xpath = "//button[@data-qa='viewCouponDetailsButton']")
	private WebElement couponDetails;

	// LOACTOR for first coupon card coupon name
	@FindBy(xpath = "//div[@data-qa='couponCode']")
	private WebElement firstCoupon;

	// locator for copy
	@FindBy(xpath = "//div[@data-qa='copyCouponButton']")
	private WebElement couponCopy;

	// locator for collection section arrow
	@FindBy(xpath = "(//span[@data-qa='mostLovedCollectionArrow'])[1]")
	private WebElement collectionArrow;

	// locator for sure savings section
	@FindBy(xpath = "//p[starts-with(@class,'SureSavings__Heading')]")
	private WebElement sureSavings;

	// locator for exclusive section share option
	@FindBy(xpath = "//div[starts-with(@class,'ExclusiveCard__Share')]")
	private WebElement exclusiveShare;

	// locator for eatsure exclusive section
	@FindBy(xpath = "//section[starts-with(@class,'ExclusiveSection__SectionWrapper-sc')]")
	private WebElement exclusiveSection;

	// Locator for exclusive section header
	@FindBy(xpath = "//div[starts-with(@class,'ExclusiveSection__Heading-sc')]")
	private WebElement exclusiveHeader;

	// locator for exclusive section explore menu button
	@FindBy(xpath = "//button[normalize-space()='Explore Menu']")
	private WebElement exclusiveButton;

	// Locator for sure earnings parts
	@FindBy(xpath = "(//div[starts-with(@class,'sc-dkPtyc')])[2]")
	private WebElement sureEarningBox;

	// locator for combo all explore button
	@FindBy(xpath = "//button[normalize-space()='Explore All Combos']")
	private WebElement exploreCombo;

	// locator for slash price for first combo
	@FindBy(xpath = "(//div[starts-with(@class,'style__ComboSlashedPrice')])[1]")
	private WebElement slashPrice;

	// locator for combo orginal price for first combo
	@FindBy(xpath = "(//p[starts-with(@class,'style__OfferPrice')])[1]")
	private WebElement orginalComboPrice;

	// locator for combo choose item button
	@FindBy(xpath = "(//button[@data-qa='chooseItemsButton'])[1]")
	private WebElement choose_item;

	// locator for "EatSure - Food Delivery Locations in"
	@FindBy(xpath = "(//h3[starts-with(@class,'style__HeadingSection-sc')])[1]")
	private WebElement storesName;

	// locator for other city name section
	@FindBy(xpath = "//div[@data-qa='otherDeliverableCitiesSection']")
	private WebElement cityName;

	// locator for footer es logo
	@FindBy(xpath = "(//img[@alt='EatSure'])[2]")
	private WebElement footerESlogo;

	// locator for footer social side section
	@FindBy(xpath = "//div[starts-with(@class,'style__Social')]")
	private WebElement socialLogo;

	// locator for mid footer section "Sure choice of Restaurants"
	@FindBy(xpath = "//h6[normalize-space()='Sure choice of Restaurants']")
	private WebElement sureChoiceFooter;

	// locator for mid footer section "our story"
	@FindBy(xpath = "//h6[normalize-space()='Our Story']")
	private WebElement ourStoryFooter;

	// locator for mid footer section "EatSure Initiatives"
	@FindBy(xpath = "//h6[normalize-space()='EatSure Initiatives']")
	private WebElement initiativesFooter;

	// locator for mid footer section "EatSure App"
	@FindBy(xpath = "//h6[normalize-space()='EatSure App']")
	private WebElement appFooter;

	// locator for mid footer section "Important link"
	@FindBy(xpath = "//h6[normalize-space()='Important Links']")
	private WebElement importantLinkFooter;

	// locator for buttom footer section "secure payment"
	@FindBy(xpath = "//div[starts-with(@class,'style__SecurePayment')]")
	private WebElement securePayment;

	// locator for button footer section "copy right"
	@FindBy(xpath = "//p[@data-qa='copyrightSection']")
	private WebElement copyRight;
	
	//locator for delivery option wrapper 
	@FindBy(xpath="//div[starts-with(@class,'style__SlotButtonsWrapper')]")
	private WebElement deliveryWrapper;
	
	//locator for delivery option
	@FindBy(xpath="//div[starts-with(@class,'style__ChannelTime')]")
	private WebElement delivery;
	
	//locator for 2nd day 
	@FindBy(xpath="(//label[starts-with(@class,'style__RadioContainer-sc')])[2]")
	private WebElement secondDay;
	
	//locator for 1st day
	@FindBy(xpath="(//div[starts-with(@class,'style__DayDetail')])[1]")
	public WebElement firstDaySlot;
	
	//locator for delivery now
	@FindBy(xpath="//div[@id='deliverNow']")
	public WebElement deliveryNow;
	
	//LOcator for select 2nd time slot for 2nd day
	@FindBy(xpath="//label[@for='1']")
	public WebElement secondTimeSlot;
	
	//locator for conform button
	@FindBy(xpath="//button[normalize-space()='Change Date & Time']")
	public WebElement confirmButon;
	
	//locator for select slot 
	@FindBy(xpath="//div[starts-with(@class,'style__ChannelTime')]")
	public WebElement selectDeliverySlotLocality;
	
	

	// Create getter

	public WebElement getLocatityName() {
		return locationGet;
	}

	// verify the serach option
	public WebElement localityPageSearch() {
		return serachOption;
	}

	public WebElement getLocalityPageHeader() {
		return localityPageOneSingleOrder;
	}

	// verfy the help option
	public WebElement help() {
		return helpOption;
	}

	// verify the menu bar
	public boolean Menu() {
		return menuOption.isDisplayed();
	}

	public WebElement cart() {
		return cartOption;
	}

	// VERIFY THE GPS OPTION
	public void clickGPS() {
		GPS.click();
	}

	// verify the location display
	public String verifyLocation(String LocationName1) throws InterruptedException {
		if (locationDisplay.isDisplayed()) {
			locationDisplay.sendKeys(LocationName1);
			changeLocation.click();
			
		} else {
			System.out.println("product in the cart are you sure you change the location");
			changeLocationPermission.click();
			locationDisplay.sendKeys(LocationName1);
			changeLocation.click();
		}
		Thread.sleep(5000);
		return getLocation2.getText();
		
	}
	
	public boolean delivery() {
		if(deliveryWrapper.isDisplayed()) {
			return true;
		}
		return false;
	}

	// verify the profile logo
	public boolean verifyLocalityProfilerLogo() {

		if (profileLogo.isDisplayed()) {
			return true;

		} else
			return false;
	}

	public void clickDelivery()
	{
		try {
		closeFreeDish.click();
		
		locationGet.click();
		}catch(Exception e) {
			locationGet.click();
		}
		
		
	}

	// verify the BREADCRUMBS
	public boolean getBreadcrums() {
		if (localityBreadcrums.isDisplayed()) {
			return true;

		}
		return false;

	}

	// verify the banner
	public boolean getBanner() {
		if (localityBanner.isDisplayed()) {
			return true;
		}
		return false;
	}

	// verify the scroll option for baner
	public boolean scrollBanner() {
		if (bannerScroll.isDisplayed()) {
			bannerScroll.click();
			return true;
		}
		return false;
	}

	public void clickESLogo() {
		localityPageHeadereatsurelogo.click();
	}

	// verify the explore all reataurant button
	public boolean exploreAllRestaurant() {
		if (exploreRestaurant.isDisplayed()) {
			exploreRestaurant.click();
			return true;
		}
		return false;
	}

	// verify the small logo display
	public boolean smallLogo() {
		if (smallLogoBar.isDisplayed()) {
			return true;
		}
		return false;

	}

	// verify the small logo pointer
	public int logoPointer(WebDriver driver) {
		if (smallLogoPointer.isDisplayed()) {
			int pointer_count = driver
					.findElements(By.xpath("//div[@class='style__BrandImgActive-sc-166jg61-9 ikuIVb']")).size();
			return pointer_count;
		}
		return -1;
	}

	// verify the large logo display
	public boolean largeLogo() {
		if (largeRestaurantLogo.isDisplayed()) {
			largerLogoScroll.click();
			slideScroll.isDisplayed();
			return true;
		}
		return false;
	}

	// verify the restaurant below text
	public String restaurantBelowText() {
		if (reaturantText.isDisplayed()) {
			String text = reaturantText.getText();
			return text;

		}
		return "Empty";
	}

	// Verify Locality Page "Choose From Trusted Restaurants in "One Single Order""
	public boolean verifylLocalityPageOneSingleOrder() {
		if (localityPageOneSingleOrder.getText().equalsIgnoreCase("One Single Order")) {
			return true;

		} else
			return false;
	}

	// scroll bar
	public void scrollloyalty(WebDriver driver) {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView();", LoyaltyCrad);

	}
	
	public void scrollCusine(WebDriver driver) {
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("arguments[0].scrollIntoView();", cuisineScroll);
	}
	
	public void scrollBar(WebDriver driver) {
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0, 800)");
	}

	public void scrollSmall(WebDriver driver) {
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0, 300)");
	}

	public void scrollCollectionArrow(WebDriver driver) {
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("arguments[0].scrollIntoView();", collectionButton);

	}

	public void scrollSignupSureButton(WebDriver driver) {
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js5.executeScript("arguments[0].scrollIntoView();", sureEarningButton);

	}

	public void scrollExclusive(WebDriver driver) {
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js5.executeScript("arguments[0].scrollIntoView();", exclusiveCard);

	}

	public void scrollCuisine(WebDriver driver) {
		JavascriptExecutor js6 = (JavascriptExecutor) driver;
		js6.executeScript("arguments[0].scrollIntoView();", cuisineScroll);

	}

	public void knowMoreScroll(WebDriver driver) {
		JavascriptExecutor js6 = (JavascriptExecutor) driver;
		js6.executeScript("arguments[0].scrollIntoView();", freeDishUnlock);

	}

	// verify after click on free dish unlock product pop should open
	public boolean freePopup() throws InterruptedException {
		freeDishUnlock.click();
		Thread.sleep(2000);
		if (fressDishPopup.isDisplayed()) {
			return true;
		}
		return false;

	}

	// for any pop up close
	public void close() {
		closeFreeDish.click();
	}

	// verify the sure savings section display
	public boolean sureSavings() {
		if (sureSavings.isDisplayed()) {
			return true;
		}
		return false;
	}

	// verify the coupon card section
	public boolean couponView() {
		if (couponDetails.isDisplayed()) {
			couponDetails.click();
			return true;
		}
		return false;
	}

	// check coupon name
	public String couponName() {
		if (firstCoupon.isDisplayed()) {
			String coupon_code = firstCoupon.getText();
			return coupon_code;
		}
		return "Empty";

	}

	// verify the copy option is showing in the coupon section
	public String copyOption() {
		if (couponCopy.isDisplayed()) {
			couponCopy.click();
			String copy_text = couponCopy.getText();
			return copy_text;
		}
		return "null";

	}

	// verify the collection card one arrow in their
	public boolean collectionArrowClick() {
		if (collectionArrow.isDisplayed()) {
			return true;
		}
		return false;
	}

	// Verify Locality Page "EatSurance"
	public boolean verifyLocalityPageEatSurance() {

		if (localityPageEatSurance.isDisplayed()) {
			return true;

		} else
			return false;
	}

	// Verify Locality Page "Free Dish"
	public boolean verifylLocalityPageFreeDish(WebDriver driver) {
		BasePage.scrollbar_down(driver);
		if (localityPageFreeDish.getText().equalsIgnoreCase("Free Dish #OnlyOnEatSure!")) {
			return true;

		} else
			return false;
	}

	// Verify Locality Page "Popular Cuisines headar in your area"
	public boolean verifylLocalityPagePopularCuisinesHeadar(WebDriver driver) {
		BasePage.scrollbar_down(driver);
		if (localityPagePopularCuisinesHeadar.getText().equalsIgnoreCase("Popular Cuisines in your area")) {
			return true;

		} else
			return false;
	}

	// Verify Locality Page "Popular Cuisines content in your area"
	public boolean verifylLocalityPagePopularCuisinesContent() {
		if (localityPagePopularCuisinesContent.getText()
				.equalsIgnoreCase("Curated specials from India�s most trusted restaurants")) {
			return true;

		} else
			return false;
	}

	// Verify Locality Page "Most Loved Collection"
	public boolean verifylLocalityPageMostLovedCollections(WebDriver driver) {
		BasePage.scrollbar_down(driver);
		if (localityPageMostLovedCollections.getText().equalsIgnoreCase("Most Loved Collections")) {
			return true;

		} else
			return false;
	}

	// Verify Locality Page "Get Rewarded for eating good"
	public boolean verifylLocalityPageRewardPoint(WebDriver driver) {
		BasePage.scrollbar_down(driver);
		if (localityPageRewardPoint.getText().equalsIgnoreCase("Get rewarded for eating good")) {
			return true;

		} else
			return false;
	}

	// Verify Locality Page "Combos from Multiple Restaurants"
	public boolean verifylLocalityPageCombosFromMutipleRestaurants(WebDriver driver) {
		BasePage.scrollbar_down(driver);
		if (localityPageCombosFromMutipleRestaurants.getText().equalsIgnoreCase("Combos From Multiple Restaurants")) {
			return true;

		} else
			return false;
	}

	// Verify Locality Page "Product name" and Cart page "Product Name"
	public String getProductNameText() {
		String LocalityPageProductName = localityPageProductName.getText().toString();
		return LocalityPageProductName;
	}

//	public boolean verifylLocalityPageProductNamewithCartPageProductName() {
//
//		String LocalityPageProductName = localityPageProductName.getText().toString();
//		System.out.println("Vivek #LocalityPageProductName  #"+LocalityPageProductName);
//		System.out.println("Cart page product name is#  "+cartPageProductName.getText().toString());
//
//		if (cartPageProductName.getText().toString().equalsIgnoreCase(LocalityPageProductName)) {
//			return true;
//
//		} else
//			return false;
//	}
//	
//	// Verify Locality Page header
//		public boolean verifyLocalityPagHeader1(WebElement xyz,String text) {
//
//			if (xyz.getText().equalsIgnoreCase(text)) {
//				return true;
//
//			} else
//				return false;
//		}

	// Verify Locality Page header logo
	public boolean verifyLocalityPagHeaderLogo() {

		if (localityPageHeadereatsurelogo.isDisplayed()) {
			return true;

		} else
			return false;
	}

	public boolean cuisineSectionButton() {
		if (exploreAllDishesButton.isDisplayed()) {
			exploreAllDishesButton.click();
			return true;
		}
		return false;
	}

	// verify the cuisine section scroll option
	public boolean cuScroll() {
		if (cuisineScroll.isDisplayed()) {
			cuisineScroll.click();
			return true;
		}
		return false;
	}

	// verify the free dish section display
	public boolean unlockDishCount() {
		if (freeDishUnlock.isDisplayed()) {
			return true;
		}
		return false;
	}

	// verify the free dish scroll option
	public boolean freeScrolling() {
		if (freeDishScroll.isDisplayed()) {
			freeDishScroll.click();
			return true;
		}
		return false;
	}

	// verify the free dish statement text

	public String freeStatement() {
		if (freeDishStatement.isDisplayed()) {
			String statement = freeDishStatement.getText();
			return statement;
		}
		return "NOT GET THE SATEMENT";

	}

	// verify the free dish section "know more" option
	public boolean knowMoreFree() {
		if (freeKnowMore.isDisplayed()) {
			freeKnowMore.click();
			return true;
		}
		return false;
	}

	// verify the exclusive section display
	public boolean esExclusive() {
		if (exclusiveSection.isDisplayed()) {
			return true;

		}
		return false;
	}

	// verify the exclusive section header details
	public boolean esExclusiveHeader(WebDriver driver) {
		if (exclusiveHeader.isDisplayed()) {

			boolean ESlogo = driver
					.findElement(
							By.xpath("//div[@class='ExclusiveSection__Heading-sc-1sp2gwy-2 lnxSFm']//*[name()='svg']"))
					.isDisplayed();
			boolean esclusive_logo = driver.findElement(By.xpath("//img[@alt='exclusive']")).isDisplayed();
			if (ESlogo == esclusive_logo == true) {

				return true;
			}
		}
		return false;
	}

	// verify the exclusive section card details
	public boolean exclusiveESCard() {

		if (exclusiveCard.isDisplayed()) {
			return true;

		}
		return false;

	}

	// verify the exclusive section "share" option
	public boolean exclusiveShare() {
		if (exclusiveShare.isDisplayed()) {
			exclusiveShare.click();
			return true;
		}
		return false;
	}

	// verify the explore section "all exclusive "button
	public boolean exButton() {
		if (exclusiveButton.isDisplayed()) {

			return true;
		}
		return false;
	}

	// verify the most love collection "explore all collection" button
	public boolean collectionAllButton() {
		if (collectionButton.isDisplayed()) {

			return true;
		}
		return false;
	}

	// verify the sure earning section is display
	public boolean sureEarning() {
		if (sureEarningBox.isDisplayed()) {
			return true;
		}
		return false;

	}

	// verify the sure earning section button is showing
	public boolean sureButton() {
		if (sureEarningButton.isDisplayed()) {
			sureEarningButton.click();
			return true;

		}
		return false;
	}

	// verify the combo explore button
	public boolean comboExloreButton() {
		if (exploreCombo.isDisplayed()) {

			return true;
		}
		return false;
	}

	// verify the combo slash price display
	public boolean comboSlashPrice() {
		if (slashPrice.isDisplayed()) {
			return true;
		}
		return false;
	}

	// Action
	/**
	 * Description: Navigate to Brand page or Product listing page
	 *
	 */
	// Vivek
//	public void navigateToBrand() {
//		brandIcon.click();
//
//	}
//
//	public void navigateToBrand() {
//		brandIcon.click();
//
//	}
//	
//	public void navigateToBrandFirst() {
//		brandIconFirst.click();
//	}

	public void navigateToBrandProduction(WebDriver driver) {
		click(brandIconProduction, driver);

	}

	// Vivek-30-Dec-2022 for dynemically selection of restaurant
	public void navigateToBrandCondition(WebDriver driver) {
		click(brandIconCondition, driver);

	}

	public void addDynemiComboOftwoProduct(WebDriver driver) {

		clickJavaScript(localityPageChooseItemsButton, driver);
		clickJavaScript(localityPageDynamicComboRadioButton, driver);
		clickJavaScript(addItemButton, driver);
		clickJavaScript(localityPageDynamicComboRadioButton, driver);
		clickJavaScript(addItemButton, driver);
		// click(confirmComboButton, driver);
		clickJavaScript(confirmComboButton, driver);

	}

	/**
	 * Description:- This is created to handle add dynamic combo box dynamically on
	 * 19th-Dec-2022
	 * 
	 * @author vivek ranjan
	 * @param driver
	 * @throws InterruptedException
	 */
	public void addDynemiComboOfTwoProductcondition(WebDriver driver) {
		clickJavaScript(localityPageChooseItemsButton, driver);
		clickJavaScript(localityPageDynamicComboRadioButton, driver);
		try {
			addItemButton.isDisplayed();
			clickJavaScript(addItemButton, driver);
			log.info("Custemization window popped up");

		} catch (NoSuchElementException e) {
			clickJavaScript(selectNextItemButton, driver);
			log.info("Custemization window not popped up");
		}
		clickJavaScript(localityPageDynamicComboRadioButton, driver);
		try {
			addItemButton.isDisplayed();
			clickJavaScript(addItemButton, driver);
			clickJavaScript(confirmComboButton, driver);
			log.info("Custemization window popped up");

		} catch (NoSuchElementException e) {
			clickJavaScript(confirmComboButton, driver);
			log.info("Custemization window not popped up");
		}

	}
	
	/**
	 * Description:- This is created to handle add dynamic combo box dynamically on
	 * 28th-Oct-2023
	 * 
	 * @author vivek ranjan
	 * @param driver
	 * @throws InterruptedException
	 */
	public void addDynemiComboOfFourProductcondition(WebDriver driver) {
		clickJavaScript(localityPageChooseItemsButton, driver);
		clickJavaScript(localityPageDynamicComboRadioButton, driver);
		try {
			addItemButton.isDisplayed();
			clickJavaScript(addItemButton, driver);
			log.info("Custemization window popped up");

		} catch (NoSuchElementException e) {
			clickJavaScript(selectNextItemButton, driver);
			log.info("Custemization window not popped up");
		}
		clickJavaScript(localityPageDynamicComboRadioButton, driver);
		try {
			addItemButton.isDisplayed();
			clickJavaScript(addItemButton, driver);
			log.info("Custemization window popped up");

		} catch (NoSuchElementException e) {
			clickJavaScript(selectNextItemButton, driver);
			log.info("Custemization window not popped up");
		}
		clickJavaScript(localityPageDynamicComboRadioButton, driver);
		try {
			addItemButton.isDisplayed();
			clickJavaScript(addItemButton, driver);
			log.info("Custemization window popped up");

		} catch (NoSuchElementException e) {
			clickJavaScript(selectNextItemButton, driver);
			log.info("Custemization window not popped up");
		}
		
		clickJavaScript(localityPageDynamicComboRadioButton, driver);
		try {
			addItemButton.isDisplayed();
			clickJavaScript(addItemButton, driver);
			clickJavaScript(confirmComboButton, driver);
			log.info("Custemization window popped up");

		} catch (NoSuchElementException e) {
			clickJavaScript(confirmComboButton, driver);
			log.info("Custemization window not popped up");
		}

	}

	public void clickCartOption(WebDriver driver) {
		clickJavaScript(cartOption, driver);
		// click(cartOption, driver);

	}

	public void clickExploreAllDishes(WebDriver driver) {
		BasePage.scrollbar_down(driver);
		clickJavaScript(exploreAllDishesButton, driver);

	}

	public void clickExploreAllCollections(WebDriver driver) {
		clickJavaScript(exploreAllCollectionsButton, driver);
	}

	public void clickExploreAllCombos(WebDriver driver) {
		clickJavaScript(exploreAllCombosButton, driver);
	}

	public void navigateTobbBrand(WebDriver driver) {
		click(bbRestaurant, driver);
	}

	// verify the combo orgnal price
	public boolean comboPrice() {
		if (orginalComboPrice.isDisplayed()) {
			return true;
		}
		return false;
	}
	/**
	 * Description:-Click "SeeAll" button for D2C website on locality page
	 * @param driver
	 */
	public void clickSeeAllButton(WebDriver driver) {
		BasePage.scrollbar_down(driver);
		clickJavaScript(seeAllButton, driver);
		}
	
	
	
	/*public void navigateTobbBrand() {
		for (WebElement element : allBrandIcon) {
	        String text = element.getText();
	        if (text.contains("Royal Biryani")) {
	            element.click();
	            break; // exit the loop if found
	        }
	    }*/
	

	// verify the combo section "choose button"
	public boolean comboButton() {
		if (choose_item.isDisplayed()) {
			choose_item.click();
			return true;
		}
		return false;
	}

	// verify the store name section
	public String eatsureStores() {
		if (storesName.isDisplayed()) {

			String storeText = storesName.getText();
			return storeText;

		}
		return "false";
	}

	// verify the city list
	public boolean esDeliveryCity() {
		if (cityName.isDisplayed()) {
			return true;
		}
		return false;
	}

	// verify the footer section ES LOGO
	public boolean F_Eslogo() {
		if (footerESlogo.isDisplayed()) {
			return true;
		}
		return false;
	}

	// Verify the social media logo section
	public boolean s_Logo() {
		if (socialLogo.isDisplayed()) {
			return true;
		}
		return false;
	}

	// verify the mid footer section
	public boolean sureChoice_F_Scetion() {
		if (sureChoiceFooter.isDisplayed()) {
			return true;
		}
		return false;
	}

	public boolean our_Story_F_Scetion() {
		if (ourStoryFooter.isDisplayed()) {
			return true;
		}
		return false;
	}

	public boolean initiative_F_Scetion() {
		if (initiativesFooter.isDisplayed()) {
			return true;
		}
		return false;
	}

	public boolean appLink_F_Scetion() {
		if (appFooter.isDisplayed()) {
			return true;
		}
		return false;
	}

	public boolean importantLink_F_Scetion() {
		if (appFooter.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	// verify the secure payment section
	public boolean securePayment_F_Scetion() {
		if (securePayment.isDisplayed()) {
			return true;
		}
		return false;
	}

	// verify the copy right section
	public String copyRight_F_Scetion() {
		if (copyRight.isDisplayed()) {
			String copy_text = copyRight.getText();
			return copy_text;
		}
		return "don't display";
	}
	
	//select the delivery slot from locality page
	public String dateSlot() throws InterruptedException {
		delivery.click();
		Thread.sleep(3000);
		if(secondDay.isDisplayed()) {
		String	DateSelect=secondDay.getAttribute("for");
			secondDay.click();
			return DateSelect;
			//System.out.println("Selected date is " +DateSelect);
		}
		return ("Second day not showing");
		}
	
	
	public String timeSlot() throws InterruptedException {
		if(secondTimeSlot.isDisplayed()) {
		String	timeSelect=secondDay.getAttribute("name");
		secondTimeSlot.click();
			return timeSelect;
			//System.out.println("Selected date is " +DateSelect);
		}
		return ("Second day 2nd slot not showing");
		}
	
	public void confirm() {
		confirmButon.click();
	}
	
	/*
	 * Description :getting the delivery slot	 
	 */
	public String delievryTime() {
		String delievry=selectDeliverySlotLocality.getText();
		return delievry;
		
	}
	
	/*
	 * Description: delivery slot change
	 */
	public String dilverySlotChange() throws InterruptedException {
		Thread.sleep(3000);
		if(firstDaySlot.isDisplayed()) {
			String	DateSelect=firstDaySlot.getAttribute("name");
			firstDaySlot.click();
				return DateSelect;
				//System.out.println("Selected date is " +DateSelect);
			}
		return "1st day slot are not showing";
			
			}
	}

	
	


	/*
	 * public void navigateTobbBrand() { for (WebElement element : allBrandIcon) {
	 * String text = element.getText(); if (text.contains("Royal Biryani")) {
	 * element.click(); break; // exit the loop if found } }
	 */


//	/**
//	 * Description: get header of Product listing page
//	 *
//	 */
//	public WebElement getHeader() {
//		return driver.findElement(localityPageHeader);
//
//	}

/**
 * Description: Verify all the brands from Brand page or Product listing page
 *
 * @return
 *
 */
//	public void verifyallBrands() {
//		asrt.assertTrue(allBrandIcon.isDisplayed());
//
//		asrt.assertAll();
//
//	}

// *******************************

//	// Locator of LogOut button
//	@FindBy(xpath = "//a[@class='logout']")
//	private WebElement logoutButton;
//
//	// Locator of Menu
//	@FindBy(xpath = "(//div[@class='popup_menu_arrow'])[3]")
//	private WebElement helpLink;
//
//	// Locator of About Actitime
//	@FindBy(xpath = "//a[contains(text(),'About actiTIME')]")
//	private WebElement aboutActitime;
//
//	// Locator of Close Button
//	@FindBy(xpath = "//img[@title='Close']")
//	private WebElement closeButton;
//
//	// Locator of Number of users
//	@FindBy(xpath = "//td[contains(text(),'Number of Users')]")
//	private WebElement numberOfUser;
//
//	public void clickLogout() {
//		logoutButton.click();
//	}
//
//	public void clickHelpMenu() {
//		helpLink.click();
//	}
//

//	public void clickAboutActitime() {
//		aboutActitime.click();
//	}
//
//	public void clickClose() {
//		closeButton.click();
//	}
//
//	// verify Log out Button display
//
//	public void verifyLogout() {
//		asrt.assertTrue(logoutButton.isDisplayed());
//
//		asrt.assertAll();
//
//	}
//
//	public void verifyPOPUP() {
//		asrt.assertTrue(numberOfUser.isDisplayed());
//
//		asrt.assertAll();
//
//	}
//
//	public void verifyCloseButton() {
//		asrt.assertTrue(closeButton.isDisplayed());
//		asrt.assertAll();
//	}
