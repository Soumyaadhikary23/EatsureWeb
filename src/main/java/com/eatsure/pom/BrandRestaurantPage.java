package com.eatsure.pom;


import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class BrandRestaurantPage extends BasePage {

	public BrandRestaurantPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	SoftAssert asrt = new SoftAssert();

	// Locator of first add Button
	@FindBy(xpath = "(//button[@data-qa='addButton'])[1]")
	public WebElement addButton;

	// Locator of second normal product name of BrandRestaurant page
//	@FindBy(xpath = "(//div[@data-qa='productName'])[4]")
	@FindBy(xpath = "(//button[@data-qa='addButton']/ancestor::div[@class='style__CardBottom-sc-1xxctwg-10 eZDLLd'])[1]/preceding-sibling::figcaption/div[@data-qa='productName']")
	
	private WebElement brandRestaurantPageProductName;

	// Locator of second normal product price of BrandRestaurant page
//	@FindBy(xpath = "(//span[@data-qa='totalPrice'])[2]")
//	@FindBy(xpath = "(//figure[@data-qa='smallProductCard'])[4]//*[@data-qa='productPricePlp' or @data-qa='totalPrice']")
	@FindBy(xpath = "(//button[@data-qa='addButton']/ancestor::div[@class='style__CardBottom-sc-1xxctwg-10 eZDLLd'])[1]/div//*[@data-qa='productPricePlp' or @data-qa='totalPrice']")
	private WebElement brandRestaurantPageNormalProductPrice;

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// Utkal
	// Locator of second normal product name
	@FindBy(xpath = "(//div[@data-qa='productName'])[3]")
	private WebElement normalproductNameLink;

	// Locator of second product name
	public By productNameLink1 = By.xpath("(//div[@data-qa='productName'])[3]");
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// Locator of first choose Items Button
	@FindBy(xpath = "(//button[@data-qa='chooseItemsButton'])[1]")
	private WebElement chooseItemsButton;

	// Locator of first choose Items Button
	@FindBy(xpath = "(//button[@data-qa='chooseItemsButton'])[1]")
	private WebElement chooseItemsButtonCondition;

	// Locator of "Increase Normal Product qty from Cuisines"
	@FindBy(xpath = "//div[@data-qa='addQuantity']")
	private WebElement increaseProductQty;

	// Locator of "Add Item" Button
	@FindBy(xpath = "//button[normalize-space()='add item']")
	public WebElement addItemButton;
	
	//locator for select next item button
	@FindBy(xpath="//button[@data-qa='addItemButton']")
	public WebElement selectNextItem;

	// Locator of "continue" Button
//	@FindBy(xpath = "//button[text()='CONTINUE']")
	@FindBy(xpath = "//button[@data-qa='ContinueButton']")
	private WebElement continueButton;

	// Locator of Brand Restaurant page first "Choose Items" button
	@FindBy(xpath = "(//button[@data-qa='chooseItemsButton'])[1]")
	private WebElement brandPageChooseItemsButton;

	// Vivek in progress
	// Locator of second dynamic product name of BrandRestaurant page
	@FindBy(xpath = "(//p[@data-qa='comboName'])[3]")
	private WebElement brandRestaurantPageDynamicProductNameLink;

	// Locator of second dynamic product price of BrandRestaurant page
	@FindBy(xpath = "(//div[@data-qa='offerPrice'])[3]")
	private WebElement brandRestaurantPageDynamicProductPrice;

	// Locator of first product name "Combos from Multiple Restaurants"
	@FindBy(xpath = "data-qa*='comboName']")
	private WebElement localityPageProductName;

	// Locator of Dynamic combo first product "Radio button"
	@FindBy(xpath = "(//label[starts-with(@class,'style__RadioContainer-sc')])[1]")
	private WebElement localityPageDynamicComboRadioButton;

	// Locator of Dynamic combo "Confirm Combo" Button
	@FindBy(xpath = "//button[text()='confirm combo']")
	private WebElement confirmComboButton;
	// Locator of Dynamic combo "select next item" Button
	@FindBy(css = "[data-qa*='addItemButton']")
	private WebElement selectNextItemButton;
	// Locator of CART section
	@FindBy(xpath = "//p[normalize-space()='Cart']")
	private WebElement cartOption;

	// locator for filter part
	@FindBy(id = "brandPageDesktop")
	private WebElement filterBox;

	// Locator for BREADCRUMBS
	@FindBy(xpath = "//div[@data-qa='breadcrumbsSection']")
	private WebElement restaurantBreadcrums;

	// locator for old Baner
	@FindBy(css = "[data-qa*='brandSingleBanner']")
	private WebElement oldBaner;

	// locator for baner brand image for old baner
	@FindBy(css = "[data-qa*='brandImage']")
	private WebElement banerBrandImage;

	// locator for baner brand name for old baner
	@FindBy(css = "[data-qa*='brandName']")
	private WebElement banerBrandName;

	// locator for baner Applicable offer section for old baner
	@FindBy(css = "[data-qa*='offerSection']")
	private WebElement applicableOffer;

	// locator for suepoint offer in the baner section
	@FindBy(css = "[data-qa*='surePointsText']")
	private WebElement surePointOffer;

	// locator for know more
	@FindBy(css = "[data-qa*='knowMoreButton']")
	private WebElement knowmore;

	// locator for share option
	@FindBy(css = "[data-qa*='shareButto']")
	private WebElement shareButton;

	// locator for share section title
	@FindBy(xpath = "//div[starts-with(@class,'style__ModalTitle')]")
	private WebElement shareTitle;

	// locator for icons
	@FindBy(xpath = "//div[starts-with(@class,'style__ShareIconContainer')]")
	List<WebElement> icons;

	// locator for copylink box
	@FindBy(css = "p[data-qa='copyLink']")
	private WebElement linkBox;

	// locator for copy option
	@FindBy(xpath = "//div[@data-qa='copyCouponButton']")
	private WebElement copy;

	// locator for share pop up close
	@FindBy(css = "#close")
	private WebElement shareClose;

	// locator for filter part
	@FindBy(xpath = "//div[@data-qa='vegNonVegFilter']")
	private WebElement filterOption;

	// locator for both filter  non selected option
	@FindBy(css = "[data-qa*='filterBothInActive']")
	public  WebElement nonbothFilter;

	@FindBy(css = "[data-qa*='filterBothActive']")
	public  WebElement bothFilter;
	// locator for both filter option
	@FindBy(css = "[data-qa*='filterNonVegInActive']")
	private WebElement nonVegFilter;

	// locator for both filter option
	@FindBy(css = "[data-qa*='filterVegInActive']")
	private WebElement vegFilter;

	// locator for non-veg icons
	@FindBy(css = "[data-qa*='isNonVeg']")
	List<WebElement> nonVegIcon;

	// locator for first non-veg icon
	@FindBy(css = "[data-qa*='isNonVeg']")
	private WebElement firstNonVegIcon;

	// locator for first veg icon
	@FindBy(css = "[data-qa*='isVeg']")
	private WebElement firstVegIcon;

	// locator for sort option
	@FindBy(css = "[data-qa*='sortFilterModalCTA']")
	private WebElement sort;

	// locator for sort items
	@FindBy(css = "[data-qa*='sortListItem']")
	List<WebElement> sortItems;

	// locator for sort items
	@FindBy(css = "[data-qa*='sortListItem']")
	private WebElement sortItem;

	// locator for apply button
	@FindBy(css = ".apply")
	private WebElement apply;

	// locator for 2nd collection products prices
	@FindBy(xpath = "(//div[starts-with(@class,'style__MenuWrapper')])[2]//span[@class='price-label']")
	List<WebElement> prodcutPrice;

	// locator for 2nd collection
	@FindBy(xpath = "//div[@id='collection-list-sidebar']//li[2]")
	private WebElement secondColection;

	@FindBy(xpath = "(//h6[@data-qa='collectionName'])[2]")
	private WebElement secondColectionName;

	// locator for first product card
	@FindBy(css = "[data-qa*='comboCard']")
	private WebElement fristProductCrad;

	@FindBy(css = "[data-qa*='productInfo']")
	private WebElement description;

	@FindBy(css = "[class*='DisplayRating__RatingTag']")
	private WebElement rateingTag;

	@FindBy(css = "[data-qa*='serveValue']")
	private WebElement serveTag;

	// locator first product price
	@FindBy(xpath = "(//span[@class='price-label'])[1]")
	private WebElement fristProductPrice;

	// locator for check box first customization
	@FindBy(css = "[data-qa*='customizationGroupCheckBoxButton']")
	private WebElement firstCheckBox;

	// loctor for addon count and price
	@FindBy(css = "[class*='style__AddOnStyle']")
	private WebElement addON;

	// locator for customization select product name
	@FindBy(css = "[class*='Checkbox__CheckboxText']")
	private WebElement customizationProductName;

	// locator for add item product name
	@FindBy(css = "[class*='style__AddedItemsBar']")
	private WebElement addOnProduct;

	// locator for first sub heading title
	@FindBy(css = "[class*='style__SectionHeading']")
	private WebElement firtSubHeading;

	// locator for reset customization button
	@FindBy(css = "[data-qa='resetCustomizationCTA']")
	private WebElement resetCustomization;

	// locator for new banner
	@FindBy(css = "[data-qa*='esCosolidationPromotionalBanner']")
	private WebElement newBaner;

	// locator quantity decrease option
	@FindBy(xpath = "//div[@data-qa='removeQuantity']")
	private WebElement decreaseQuantity;

	// locator quantity increase option
	@FindBy(xpath = "//div[@data-qa='addQuantity']")
	private WebElement increaseQuantity;

	// locator quantity show option
	@FindBy(xpath = "//div[@data-qa='quantityToShow']")
	private WebElement quantityShow;

	// locator for combo name
	@FindBy(css = "[data-qa*='comboName']")
	private WebElement comboName;

	// locator for combo name in the set pop up
	@FindBy(css = "[class*='style__ProductName']")
	private WebElement comboNameInSet;

	// locator for combo price in the set
	@FindBy(xpath = "(//span[starts-with(@class,'style__Price')])[1]")
	private WebElement comboPriceInSet;

	// locator for combo set close
	@FindBy(xpath = "//div[@id='close']")
	private WebElement close;

	//@FindBy(xpath = "//a[@id='combo_undefined']//div[starts-with(@class,'style__OfferPrice')]")
	@FindBy(xpath="(//div[@data-qa='offerPrice'])[1]")
	private WebElement comboPrice;

	// locator for Your oder statement
	@FindBy(css = "[data-qa*='totalItemsInCart']")
	private WebElement orderContainerStatement;
	
	//locator for first combo card
	@FindBy(css="[data-qa*='comboCard']")
	private WebElement comboCard;
	
	//locator for container up arrow
	@FindBy(css=".upArrow g")
	private WebElement upArrow;
	
	//locator for product count in the container card 
	@FindBy(css="[data-qa*='cartProductInfo']")
	List<WebElement> containCardProductCount;
	
	//locator for container card header
	@FindBy(css="[data-qa*='cartSummaryHeading']")
	private WebElement containerCardHeader;
	
	@FindBy(css="[class*='style__CartOfferPrice']")
	List<WebElement> totalContainerPriceCount;
	
	@FindBy(css="[data-qa*='offerPriceToShow']")
	List<WebElement> totalSlashPriceCount;
	
	//locator for container close
	@FindBy(css="#close")
	private WebElement containerClose;
	
	//locator for sign in option'
	@FindBy(css="[data-qa*='profileOption']")
	private WebElement SignIn;
	
	//locator for container total value
	@FindBy(css="[class*='style__ListValue']")
	private WebElement totalPrice;
	

	//

	// Action
	/**
	 * Description: click on first Item from Product listing page
	 * 
	 * @author vivek ranjan
	 * @param driver
	 */
	public void addFirstItem(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addButton);

	}

	/**
	 * Description: click on "AddItem" button in static combo box
	 *
	 */
	public void clickAddItem() {
		addItemButton.click();

	}

	/**
	 * Description: click on "Continue" button under place order journey
	 * 
	 * @author vivek ranjan
	 * @param driver
	 */
	public void clickContinue(WebDriver driver) {
		click(continueButton, driver);
		// If simple click willnot work then will implement the below clickJavaScript
		// method
		// clickJavaScript(continueButton, driver);
		// continueButton.click();

	}
	
	public void exceptionProductAdd() {
		try
		{
			addItemButton.click();
			Thread.sleep(2000);
			continueButton.click();
		}catch(Exception e) {
			continueButton.click();
		}
	
		
	}

	/**
	 * Description:- This is created to handle add Normal product combo box
	 * dynamically on 19th-Dec-2022
	 * 
	 * @author vivek ranjan
	 * @param driver
	 */
	public void addNormalProductcondition(WebDriver driver, WebElement element) {
		clickJavaScript(element, driver);
		try {
			addItemButton.isDisplayed();
			clickJavaScript(addItemButton, driver);
			log.info("Static combo added ");

		} catch (NoSuchElementException e) {

			log.info("Noramal Item added ");
		}
	}

	/**
	 * Description:- This is created to handle add dynamic combo box dynamically on
	 * 19th-Dec-2022
	 * @author vivek ranjan
	 * @param driver
	 * @throws InterruptedException
	 */
//	public void addDynemiComboOfTwoProductcondition(WebDriver driver) throws InterruptedException {
	public void addDynemiComboOfTwoProductcondition(WebDriver driver){
		clickJavaScript(chooseItemsButtonCondition, driver);
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
	 * 08th-Nov-2023
	 * 
	 * @author vivek ranjan
	 * @param driver
	 * @throws InterruptedException
	 */
	public void addDynemiComboOfFourProductcondition(WebDriver driver) {
		clickJavaScript(chooseItemsButtonCondition, driver);
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

	/**
	 * Description:-This method is created to click on product name
	 *
	 * @author vivek ranjan
	 * @param driver
	 */
	public void clickProducNameLink(WebDriver driver) {

		clickJavaScript(brandRestaurantPageProductName, driver);

	}

	/**
	 * Description:-This method is created to click on Dynamic product name
	 *
	 * @author vivek ranjan
	 * @param driver
	 */
	public void clickDynamicProducNameLink(WebDriver driver) {

		clickJavaScript(brandRestaurantPageDynamicProductNameLink, driver);

	}

	// utkal

	public void clickProducNameLink1(By locator, WebDriver driver) {

		clickJavaScript(driver.findElement(locator), driver);

	}

	// Get the normal "Product name" form BrandRestaurant Page
	/**
	 * Description:-It will return the product name
	 * 
	 * @author vivek ranjan
	 * @return
	 */
	public String getProductNameText() {
		String BrandRestaurantPageProductName = brandRestaurantPageProductName.getText().toString();
		return BrandRestaurantPageProductName;
	}

	/**
	 * Description:-It will return the normal "Product price" form BrandRestaurant
	 * Page
	 * 
	 * @author vivek ranjan
	 * @return
	 */
	public String getProductPriceText() {
		String BrandRestaurantPageProductPrice = brandRestaurantPageNormalProductPrice.getText().toString();
		return BrandRestaurantPageProductPrice;
	}

	/**
	 * Description:-It will return the dynamic "Product name" form BrandRestaurant
	 * Page
	 * 
	 * @author vivek ranjan
	 * @return
	 */
	public String getDynemicProductNameText() {
		String BrandRestaurantPageDynamicProductName = brandRestaurantPageDynamicProductNameLink.getText().toString();
		return BrandRestaurantPageDynamicProductName;
	}

	/**
	 * Description:-It will return the Dynamic "Product price" form BrandRestaurant
	 * Page
	 * 
	 * @author vivek ranjan
	 * @return
	 */
	public String getDynamicProductPriceText() {
		String BrandRestaurantPageDynamicProductPrice = brandRestaurantPageDynamicProductPrice.getText().toString();
		return BrandRestaurantPageDynamicProductPrice;
	}

	// To click browser back button
	/**
	 * Description:-It will click browser back button
	 * 
	 * @author vivek ranjan
	 * @return
	 */
	public static void clickBrowserBackButton(WebDriver driver) {
		driver.navigate().back();
	}

	/*
	 * Description: verify the filter part
	 */
	public boolean verifyFiltersection() {
		if (filterBox.isDisplayed()) {
			return true;
		}
		return false;
	}

	// verify the BREADCRUMBS
	public boolean getBreadcrums() {
		if (restaurantBreadcrums.isDisplayed()) {
			return true;

		}
		return false;

	}

	// verify the baner
	public boolean baner() {

		if (oldBaner.isDisplayed()) {
			banerBrandImage.isDisplayed();
			banerBrandName.isDisplayed();
			return true;
		}
		return false;
	}

	// verify the offer option in the baner
	public boolean offer() {
		if (applicableOffer.isDisplayed()) {
			surePointOffer.isDisplayed();
			knowmore.isDisplayed();
			return true;
		}
		return false;
	}

	// verify the share option
	public boolean share() {
		if (shareButton.isDisplayed()) {
			SoftAssert as = new SoftAssert();
			shareButton.click();
			as.assertEquals(shareTitle.getText(), "If you love this, share it with those you love",
					"share pop up title showing wrong");
			as.assertAll();
			as.assertEquals(icons.size(), 4, "Socil media icon count not showing right");
			as.assertAll();
			log.info("copy box URL is " + linkBox.getText());
			copy.isDisplayed();
			assert copy.isEnabled() : "Copy button not clickable";
			shareClose.click();
			return true;
		}
		return false;
	}

	// verify the filter
	public boolean filter(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 800)");
		if (filterOption.isDisplayed()) {
			bothFilter.isSelected();
			return true;
		}
		return false;
	}
	// verify the veg filter

	public int vegFilter() {
		vegFilter.click();
		return nonVegIcon.size();
	}

	// verify the sort option
	public int sortOption() throws InterruptedException {
		if (sort.isDisplayed()) {
			Thread.sleep(3000);
			sort.click();
			return sortItems.size();

		}
		return 0;
	}

	// verify the Cost: Low to High sort
	public void sortOptionApply() {
		sortItem.click();
		apply.click();

	}

//verify the sort 
	public int[] price;

	public void productPrice() {
		price = new int[prodcutPrice.size()];

		for (int i = 0; i < prodcutPrice.size(); i++) {
			price[i] = Integer.parseInt(prodcutPrice.get(i).getText().replace("\u20b9", "").toString().trim());
			log.info(price[i]);

		}
		isSorted(price);

	}

	public boolean isSorted(int[] price) {
		// TODO Auto-generated method stub
		for (int i = 0; i < price.length; i++)
			for (int j = i + 1; j < price.length; j++)
				if (price[j] < price[i])
					return false;
		return true;
	}

	// verify the 2nd collection
	public String collectionClick() {
		if (secondColection.isDisplayed()) {
			secondColection.click();
			secondColection.isSelected();
			String listCollectionName = secondColection.getText();
			return listCollectionName;

		}
		return "Not selected";
	}

	//
	public String collectionName() {
		if (secondColectionName.isDisplayed()) {
			String collectionName = secondColection.getText();
			return collectionName;
		}
		return "Collection not showing";
	}

	// verify the 2nd collection product count
	public int collectionProductCount() {
		// int
		// productCount=Integer.parseInt(secondColection.getText().split("\\(|\\)")[2].toString().trim());
		String[] parts = secondColection.getText().split("\\(|\\)");
		int productCount = Integer.parseInt(parts[parts.length - 1]);
		return productCount;
	}

	public int priceCount() {
		int priceCount = prodcutPrice.size();
		return priceCount;
	}

	// verify the product details
	public boolean productCard(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 800)");
		Thread.sleep(2000);
		if (fristProductCrad.isDisplayed()) {
			System.out.println("Second product name " + brandRestaurantPageProductName.getText());
			if (firstVegIcon.isDisplayed()) {
				System.out.println("filter icon is showing");
			}
			description.isDisplayed();
			rateingTag.isDisplayed();
			serveTag.isDisplayed();
			return true;
		}
		return false;
	}

	// verify the add button
	public boolean addButton(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", firtSubHeading);
		Thread.sleep(2000);
		if (addButton.isDisplayed()) {

			return true;
		}
		return false;
	}

	// verify the product price
	public int price() {
		if (fristProductPrice.isDisplayed()) {
			int firstProductPrice = Integer
					.parseInt(fristProductPrice.getText().replace("\u20b9", "").toString().trim());
			return firstProductPrice;
		}
		return 0;

	}

	// verify the product added
	public boolean verifyContinue() {
		if (continueButton.isDisplayed()) {
			return true;
		}
		return false;
	}

//verify the select customization	
	public void customizationSelected() {

		SoftAssert as = new SoftAssert();
		addButton.click();
		try {
			addItemButton.isDisplayed();
			firstCheckBox.click();
			Thread.sleep(2000);
			/*
			 * as.assertTrue(firstCheckBox.isSelected(),
			 * "customization not showing/not selected"); as.assertAll();
			 * log.info("verify the cusmization selected");
			 */
			int costomizationAddCount = Integer.parseInt(addON.getText().split(" ")[0].trim());
			as.assertEquals(customizationCount(), 1, "Customization addon count not matching");
			as.assertAll();
			log.info("Successfully added customization");
			String customizationProduct = customizationProductName.getText();
			as.assertEquals(customizationAddProductName(), addONProductName(),
					"Add on product name is not same as customization product name");
			as.assertAll();
			log.info("Verify Successfully addon product name");
			resetCustomization.click();
			as.assertFalse(firstCheckBox.isSelected(), "Reset customization not working");
			as.assertAll();
			log.info("verify the Reset cusmization");
			addItemButton.click();
			as.assertEquals(verifyContinue(), true, "product not added");
			as.assertAll();
			log.info("Succcessfully added the product");

		} catch (Exception e) {

			log.info("Normal product this is");

		}
	}

//verify the select customization count
	public int customizationCount() {
		int costomizationAddCount = Integer.parseInt(addON.getText().split(" ")[0].trim());
		return costomizationAddCount;
	}

	public String customizationAddProductName() {
		String customizationProduct = customizationProductName.getText();
		return customizationProduct;
	}

	public String addONProductName() {

		String addONProduct = addOnProduct.getText();
		return addONProduct;

	}

	// verify the new baner
	public boolean newBaner() {
		if (newBaner.isDisplayed()) {
			return true;
		}
		return false;
	}

	// verify the quantity option
	public boolean quantityOption() {
		if (decreaseQuantity.isDisplayed() && increaseQuantity.isDisplayed()) {
			return true;
		}
		return false;
	}

	// verify the quantity count show
	public int quantityShow() {
		quantityShow.isDisplayed();
		int countshow = Integer.parseInt(quantityShow.getText().trim());
		return countshow;
	}

	// verify the combo chooseItem button
	public void chooseItem(WebDriver driver) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", comboCard);
		} catch (Exception e) {
			log.info("In this brand don't have any combo");
		}

	}

	// Verify the combo name in the list
	public String chooseItemClick(WebDriver driver) {
		String listComboName = comboName.getText();
		clickJavaScript(chooseItemsButtonCondition, driver);
		return listComboName;
	}

	// verify the combo name in the set section
	public String setComboName() {
		String setComboName = comboNameInSet.getText();
		return setComboName;
	}

	// verify the combo price in the set
	public int setComboPrice() {
		String PriceCombo = comboPriceInSet.getText().replace("\u20b9", "").toString().trim();
		int setPriceCombo =Integer.parseInt(PriceCombo);
		return setPriceCombo;

	}

	public void comboClose(WebDriver driver) {
		Actions actions = new Actions(driver);
		// Double-click on the element
		actions.doubleClick(close).perform();
	}

	public int comboListPrice() {
		String comboPriceString = comboPrice.getText().replace("\u20b9", "").toString().trim();
		int comboListPrice =Integer.parseInt(comboPriceString);
		return comboListPrice;

	}

	public int orderCountContainer() {
		String[] parts=orderContainerStatement.getText().split("\\(|\\)");
		int productCountContainer = Integer.parseInt(parts[parts.length - 1]);
		return productCountContainer;
	}
	
	public void arrowClick() throws InterruptedException {
		Thread.sleep(2000);
		upArrow.click();
	}
	
	public int containProductCount() {
		int count=containCardProductCount.size();
		return count;
		
	}
	
	public String containerHeader() {
		return containerCardHeader.getText();
	}
	
	public int totalPriceBeforeLogin() {
		int TotalPriceSum=0;
		int totalSlashPriceSum=0;
		for(int i=0;i<totalContainerPriceCount.size();i++) {
			TotalPriceSum=TotalPriceSum+Integer.parseInt(totalContainerPriceCount.get(i).getText().replace("\u20b9", "").toString().trim());
		}
		for(int i=0;i<totalSlashPriceCount.size();i++) {
			totalSlashPriceSum=totalSlashPriceSum+Integer.parseInt(totalSlashPriceCount.get(i).getText().replace("\u20b9", "").toString().trim());
		}
		int TotalPrice=TotalPriceSum-totalSlashPriceSum;
		return TotalPrice;
		}
	
	//container close
	public void containerClose() {
		containerClose.click();
	}
	
	//sign in from restaurant page
	public void login(WebDriver driver) throws InterruptedException {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(3000);
		SignIn.click();
	}
	
	//verify the total price after login
	public int totalprice() {
		int CartTotal=Integer.parseInt(totalPrice.getText().split("[^\\d]+")[1].trim());
		return CartTotal;
	}
	
	public void bothFilter() {
		nonbothFilter.click();
	}
	
}
