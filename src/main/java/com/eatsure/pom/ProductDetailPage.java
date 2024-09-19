package com.eatsure.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ProductDetailPage extends BasePage {

	public ProductDetailPage(WebDriver driver) {
		// super(driver);
		PageFactory.initElements(driver, this);
	}

	SoftAssert asrt = new SoftAssert();

	// Locator of ProductDetailPage first add Button
	@FindBy(xpath = "(//button[@data-qa='addButton'])[2]")
	public WebElement addButton;

	// Locator of Normal product name in ProductDetail page
	@FindBy(xpath = "(//div[starts-with(@class,'style__ProdName-sc')])[2]/div/h1")
	private WebElement productDetailPageProductName;

	// Locator of Normal product price in ProductDetail page
	@FindBy(xpath = "//div[@data-qa='productPricePdp']")
	private WebElement productDetailPageProductPrice;

	// Locator of Dynamic product price in ProductDetail page
	@FindBy(xpath = "(//div[starts-with(@class,'style__TextContainer-sc')])[2]/div/div[1]")
	private WebElement productDetailPageDynamicProductPrice;

	// Locator of Product Detail Page Product Image
	@FindBy(xpath = "//div[@data-qa='productImgPdp']")
	private WebElement productDetailPageProductImage;

	// Locator of Product Detail Page Sticky Header
	@FindBy(xpath = "//div[@data-qa='headerContainer']")
	private WebElement productDetailPageStickyHeader;

	// Locator of Product Detail Page Brands Reel
	@FindBy(xpath = "//div[@data-qa='brandReelSlide']")
	private WebElement productDetailPageBrandsReel;

	// Locator of Product Detail Page "Add Item" Button in Customization Screen
	@FindBy(xpath = "//button[@data-qa='addItemButton']")
	private WebElement addItemButton;

	// Locator of Quantity To Show For Add Button
	@FindBy(xpath = "//div[@data-qa='quantityToShow']")
	private WebElement getProductCountOnAddButton;

	// Locator of Quantity To Show On Header Cart
	@FindBy(xpath = "//span[@data-qa='productQuantityInCart']")
	private WebElement getProductCountOnCartHeader;

	// Locator of Customization Screen Modal
	@FindBy(xpath = "//div[@data-qa='customizationModalHeader']")
	private WebElement customizationScreenModal;

	// Locator of Remove Product Quantity
	@FindBy(xpath = "(//div[@data-qa='removeQuantity'])[2]")
	private WebElement removeQuantity;

	// Locator of Adding Product Quantity
	@FindBy(xpath = "(//div[@data-qa='addQuantity'])[2]")
	private WebElement addQuantity;

	// Locator of Product Description
	@FindBy(xpath = "//div[@data-qa='productInfo']")
	private WebElement productDescription;

	// Locator of Brand Logo
	@FindBy(xpath = "//div[@data-qa='brandImage']")
	private WebElement brandLogo;

	// Locator of By Brand Name
	@FindBy(xpath = "//div[@data-qa='brandName']")
	private WebElement brandName;

	// Locator of Brand Serves
	@FindBy(xpath = "//div[@data-qa='productServing']")
	private WebElement brandServes;

	// Locator of Share button
	@FindBy(xpath = "//div[@data-qa='productSharePdp']")
	private WebElement shareButton;

	// Locator of Share button Modal View
	@FindBy(xpath = "//div[@data-qa='shareModalPdp']")
	private WebElement shareButtonModalView;

	// Locator of Share on Whatsapp Option
	@FindBy(xpath = "//div[@data-qa='ShareonWhatsApp']")
	private WebElement shareOnWhatsappOption;

	// Locator of Share on Facebook Option
	@FindBy(xpath = "//div[@data-qa='ShareonFacebook']")
	private WebElement shareOnFacebookOption;

	// Locator of Share on Twitter Option
	@FindBy(xpath = "//div[@data-qa='ShareonTwitter']")
	private WebElement shareOnTwitterOption;

	// Locator of Share via Gmail Option
	@FindBy(xpath = "//div[@data-qa='ShareviaGmail']")
	private WebElement shareViaGmailOption;

	// Locator of Copy Link Card
	@FindBy(xpath = "//p[@data-qa='copyLink']")
	private WebElement copyLinkCard;

	// Locator of Copy Coupon Button
	@FindBy(xpath = "//div[@data-qa='copyButton']")
	private WebElement copyLinkButton;

	// Locator of close Window Popup
	@FindBy(xpath = "//div[@data-qa='closeWindowPopup']")
	private WebElement closeWindowPopup;

	// Locator of Read More Option
	@FindBy(xpath = "//span[starts-with(@class,'style__ReadMore-sc')]")
	private WebElement readMoreOption;

	// Locator of Coupon Card Section
	@FindBy(xpath = "//div[starts-with(@class,'style__CouponCard')]")
	private WebElement couponCardSection;

	// Locator of Sure Points Section
	@FindBy(xpath = "//div[starts-with(@class,'style__SurePoints-sc')]")
	private WebElement surePointsSection;

	// Locator of Know More Link
	@FindBy(xpath = "//p[@data-qa='knowMoreText']")
	private WebElement knowMoreLink;

	// Locator of Know More Modal View
	@FindBy(xpath = "//div[@data-qa='knowMoreModalHeader']")
	private WebElement knowMoreModalView;

	// Locator of Know More Modal View First Brand Name
	@FindBy(xpath = "(//div[@data-qa='knowMoreBrandName'])[1]")
	private WebElement knowMoreModalViewFirstBrandName;

	// Locator of Know More Modal View First Currency Label
	@FindBy(xpath = "(//div[starts-with(@class,'style__SmallText')])[1]")
	private WebElement knowMoreModalViewCurrencyLabel;

	// Locator of Coupon Options Link
	@FindBy(xpath = "//span[starts-with(@class,'style__OfferMore')]")
	private WebElement couponsOptionsLink;

	// Locator of Know More Eatsure Assurance Link
	@FindBy(xpath = "//span[@data-qa='eatsuranceKnowMore']")
	private WebElement knowMoreEatsureAssuranceLink;

	// Locator of Know More Eatsure Assurance Modal View
	@FindBy(xpath = "//div[@data-qa='eatsuranceModalHeader']")
	private WebElement knowMoreEatsureAssuranceModalView;

	// Locator of Know More Eatsure Know More HighGradeIngredients Info
	@FindBy(xpath = "//div[@data-qa='highGradeIngredients']")
	private WebElement knowMoreHighGradeIngredientsInfo;

	// Locator of Best Price Guranteed Section
	@FindBy(xpath = "//div[@data-qa='BestPriceGuranteed']")
	private WebElement bestPriceGuranteedSection;

	// Locator of Artificial Colours Section
	@FindBy(xpath = "//div[@data-qa='0%artificialcoloursorflavors']")
	private WebElement artificialColoursSection;

	// Locator of Medically Certified Staff Section
	@FindBy(xpath = "//div[@data-qa='Medicallycertifiedstaff']")
	private WebElement medicallyCertifiedStaffSection;

	// Locator of Nutritional Value Section
	@FindBy(xpath = "//div[starts-with(@class,'style__EatTextContainer-t')]")
	private WebElement nutritionalValueSection;

	// Locator of Calories Details
	@FindBy(xpath = "(//div[starts-with(@class,'style__NutritionalTextContainer')])[1]")
	private WebElement caloriesDetails;

	// Locator of Carb Details
	@FindBy(xpath = "(//div[starts-with(@class,'style__NutritionalTextContainer')])[2]")
	private WebElement carbDetails;

	// Locator of Protein Details
	@FindBy(xpath = "(//div[starts-with(@class,'style__NutritionalTextContainer')])[3]")
	private WebElement proteinDetails;

	// Locator of Fat Details
	@FindBy(xpath = "(//div[starts-with(@class,'style__NutritionalTextContainer')])[4]")
	private WebElement fatDetails;

	// Locator of Sticky Product Name
	@FindBy(xpath = "(//div[starts-with(@class,'style__ProdName-sc')])[1]//p/h1")
	private WebElement stickyProductName;

	// Locator of Sticky Product Price
	@FindBy(xpath = "//div[starts-with(@class,'style__TextContainer-sc')]//span")
	private WebElement stickyProductPrice;

	// Locator of Sticky Add Button
	@FindBy(xpath = "(//button[@data-qa='addButton'])[1]")
	private WebElement stickyAddButton;

	// Locator of Sticky Remove Product Quantity
	@FindBy(xpath = "(//div[@data-qa='removeQuantity'])[1]")
	private WebElement stickyRemoveQuantity;

	// Locator of Sticky Adding Product Quantity
	@FindBy(xpath = "(//div[@data-qa='addQuantity'])[1]")
	private WebElement stickyAddQuantity;

	// Action
	/**
	 * Description: click on "Add" button
	 * 
	 * @author vivek ranjan
	 * @param driver
	 */
	public void clickAddbutton(WebDriver driver) {

		clickJavaScript(addButton, driver);

	}

	/**
	 * Description:- Get the "Product name" form ProductDetail Page
	 * 
	 * @author vivek ranjan
	 * @return
	 */
	public String getProductNameText() {
		String ProductDetailPageProductName = productDetailPageProductName.getText().toString();
		return ProductDetailPageProductName;
	}

	/**
	 * Description:- Get the "Product price" form ProductDetail Page
	 * 
	 * @author vivek ranjan
	 * @return
	 */
	public String getProductPriceText() {
		String ProductDetailPageProductPrice = productDetailPageProductPrice.getText().toString();
		return ProductDetailPageProductPrice;

	}

	/**
	 * Description:- Get the dynamic "Product price" form ProductDetail Page
	 * 
	 * @author vivek ranjan
	 * @return
	 */
	public String getDynamicProductPriceText() {
		String DynamicProductDetailPageProductPrice = productDetailPageDynamicProductPrice.getText().toString();
		return DynamicProductDetailPageProductPrice;

	}

	/**
	 * Description:- To click browser back button
	 * 
	 * @param driver
	 */
	public static void clickBrowserBackButton(WebDriver driver) {
		driver.navigate().back();
	}

	/**
	 * Description: Verify Product Detail Page Product Image
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyProductDetailPageProductImage() {

		if (productDetailPageProductImage.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Product Detail Page Product Price
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyProductDetailPageProductPrice() {

		if (productDetailPageProductPrice.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Product Detail Page Sticky Header
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyProductDetailPageStickyHeader() {

		if (productDetailPageStickyHeader.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Product Detail Page Brands Reel
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyProductDetailPageBrandsReel() {

		if (productDetailPageBrandsReel.isDisplayed()) {
			return true;

		} else
			return false;

	}

	/**
	 * Description: Verify click Add Button Customisation Screen
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickAddButtonCustScreen(WebDriver driver) {
		BasePage.waitForVisibility(driver, addItemButton);
		clickJavaScript(addItemButton, driver);
	}

	// Get the "Product Count" On Add Button
	public String getProductCountOnAddButton() {
		String ProductCountOnAddButton = getProductCountOnAddButton.getText().toString();
		System.out.println("Product Count On Add Button" + ProductCountOnAddButton);
		return ProductCountOnAddButton;
	}

	// Get the "Product Count" On Cart Header
	public String getProductCountOnCartHeader() {
		String ProductCountOnCartHeader = getProductCountOnCartHeader.getText().toString();
		System.out.println("Product Count On Cart Header " + ProductCountOnCartHeader);
		return ProductCountOnCartHeader;
	}

	/**
	 * Description: Verify Customization Screen Modal
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyCustomizationScreenModal() {

		if (customizationScreenModal.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Product Description
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyProductDescription() {

		if (productDescription.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify click Remove Quantity
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickRemoveQuantity(WebDriver driver) {
		BasePage.waitForVisibility(driver, removeQuantity);
		clickJavaScript(removeQuantity, driver);
	}

	/**
	 * Description: Verify click Add Quantity
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickAddQuantity(WebDriver driver) {
		BasePage.waitForVisibility(driver, addQuantity);
		clickJavaScript(addQuantity, driver);
	}

	/**
	 * Description: Verify sticky Click Remove Quantity
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void stickyClickRemoveQuantity(WebDriver driver) {
		BasePage.waitForVisibility(driver, removeQuantity);
		clickJavaScript(stickyRemoveQuantity, driver);
	}

	/**
	 * Description: Verify sticky Click Add Quantity
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void stickyClickAddQuantity(WebDriver driver) {
		BasePage.waitForVisibility(driver, addQuantity);
		clickJavaScript(stickyAddQuantity, driver);
	}

	/**
	 * Description: Verify Brand Serves
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyBrandServes() {

		if (brandServes.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Brand Logo
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyBrandLogo() {

		if (brandLogo.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Brand Name
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyBrandName() {

		if (brandName.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Share Button
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyShareButton() {

		if (shareButton.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify click on Share Button
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickshareButton(WebDriver driver) {
		BasePage.waitForVisibility(driver, shareButton);
		clickJavaScript(shareButton, driver);
	}

	/**
	 * Description: Verify Share Button Modal View
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyShareButtonModalView() {

		if (shareButtonModalView.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Share On Whatsapp Option
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyShareOnWhatsappOption() {

		if (shareOnWhatsappOption.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Share On Facebook Option
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyShareOnFacebookOption() {

		if (shareOnFacebookOption.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Share On Twitter Option
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyShareOnTwitterOption() {

		if (shareOnTwitterOption.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Share Via Gmail Option
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyShareViaGmailOption() {

		if (shareViaGmailOption.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Copy Link Card
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyCopyLinkCard() {

		if (copyLinkCard.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Copy Coupon Button
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyCopyLinkButton() {

		if (copyLinkButton.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify click Copy Coupon Button
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickCopyLinkButton(WebDriver driver) {
		BasePage.waitForVisibility(driver, copyLinkButton);
		clickJavaScript(copyLinkButton, driver);
	}

	/**
	 * Description: Verify click Close Window Popup
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickCloseWindowPopup(WebDriver driver) {
		BasePage.waitForVisibility(driver, closeWindowPopup);
		clickJavaScript(closeWindowPopup, driver);
	}

	/**
	 * Description: Verify Read More Option
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyReadMoreOption() {

		if (readMoreOption.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify click Read More Option
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickReadMoreOption(WebDriver driver) {
		BasePage.waitForVisibility(driver, readMoreOption);
		clickJavaScript(readMoreOption, driver);
	}

	/**
	 * Description: Verify SurePoints Section
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifySurePointsSection() {

		if (surePointsSection.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Know More Link
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyKnowMoreLink() {

		if (knowMoreLink.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify click Know More Link
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickKnowMoreLink(WebDriver driver) {
		BasePage.waitForVisibility(driver, knowMoreLink);
		clickJavaScript(knowMoreLink, driver);
	}

	/**
	 * Description: Verify Know More Modal View
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyKnowMoreModalView() {

		if (knowMoreModalView.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Know More Modal View First Brand Name
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyKnowMoreModalViewFirstBrandName() {

		if (knowMoreModalViewFirstBrandName.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Know More Modal View Currency Label
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyKnowMoreModalViewCurrencyLabel() {

		if (knowMoreModalViewCurrencyLabel.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Know More Eatsure Assurance Link
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyKnowMoreEatsureAssuranceLink() {

		if (knowMoreEatsureAssuranceLink.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify click Know More Eatsure Assurance Link
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickKnowMoreEatsureAssuranceLink(WebDriver driver) {
		BasePage.waitForVisibility(driver, knowMoreEatsureAssuranceLink);
		clickJavaScript(knowMoreEatsureAssuranceLink, driver);
	}

	/**
	 * Description: Verify Know More Eatsure Assurance Modal View
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyKnowMoreEatsureAssuranceModalView() {

		if (knowMoreEatsureAssuranceModalView.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Know More High Grade Ingredients Info
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyKnowMoreHighGradeIngredientsInfo() {

		if (knowMoreHighGradeIngredientsInfo.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Artificial Colours Section
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyArtificialColoursSection() {

		if (artificialColoursSection.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Best Price Guranteed Section
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyBestPriceGuranteedSection() {

		if (bestPriceGuranteedSection.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Medically Certified Staff Section
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyMedicallyCertifiedStaffSection() {

		if (medicallyCertifiedStaffSection.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Nutritional Value Section
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyNutritionalValueSection() {

		if (nutritionalValueSection.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Calories Details
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyCaloriesDetails() {

		if (caloriesDetails.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Carb Details
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyCarbDetails() {

		if (carbDetails.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Protein Details
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyProteinDetails() {

		if (proteinDetails.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Fat Details
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyFatDetails() {

		if (fatDetails.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Sticky Header
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void verifyStickyHeader(WebDriver driver) {
		BasePage.scrollToElement(driver, nutritionalValueSection, 2);
		Assert.assertTrue(stickyProductName.isDisplayed());
		Assert.assertTrue(stickyProductPrice.isDisplayed());
		BasePage.clickElement(driver, stickyAddButton);
		BasePage.wait(2);
		clickAddbutton(driver);
		clickAddButtonCustScreen(driver);
		stickyClickAddQuantity(driver);
		clickAddbutton(driver);
		clickAddButtonCustScreen(driver);
		stickyClickRemoveQuantity(driver);
		log.info("Successfully Verified Sticky Header");

	}
}
