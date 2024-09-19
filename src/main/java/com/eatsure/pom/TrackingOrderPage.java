package com.eatsure.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TrackingOrderPage extends BasePage {

	public WebDriver driver;
	/*************** Web Elements for payment page *************/

	@FindBy(xpath = "//a[@data-qa='headerEatsureLogo']")
	private WebElement eswebLogo;
	@FindBy(xpath = "//div[contains(text(),'Order Tracking')]")
	private WebElement orderTracking;
	
	@FindBy(xpath = "//p[contains(text(),'Order will be delivered By')]")
	private WebElement orderDeliverText;
	@FindBy(xpath = "//p[starts-with(@class,'style__DeliveryDetail')]")
	private WebElement orderDateTimeText;			
	@FindBy(xpath = "//button[@class='Button-sc-3qnwiq-0 mUDIG']")
	private WebElement viewOrderDetailsButton;
	@FindBy(xpath = "//div[@class='desk_details']//p[contains(text(),'Order CRN')]")
	private WebElement orderCrn;
	@FindBy(xpath = "//button[normalize-space()='View Order details']")
	private WebElement viewOrderDetailsLink;
	@FindBy(xpath = "//*[@class='name']")
	private WebElement paidbyText;
	@FindBy(xpath = "//*[@id='order-details-modal']")
	private WebElement orderDetailsPopup;
	@FindBy(xpath = "//div[@class='top']//p")
	private WebElement orderPlacedPopup;
	@FindBy(xpath = "//div[@data-qa='closeWindowPopup']")
	private WebElement closeOrderDetails;
	
	@FindBy(xpath = "//span[@data-qa='viewOrderDetails']")
	private WebElement viewOrderDetailsDeliverNow;
	
	// locator of address Map Polygon
	@FindBy(xpath = "//div[@data-qa='mapContainerDesktop']")
	private WebElement addressMapPolygon;

	// locator of no Of Items
	@FindBy(xpath = "//span[@data-qa='itemQuantitynPrice']")
	private WebElement noOfItems;

	// locator of order Confirmed Text
	@FindBy(xpath = "//div[@data-qa='OrderConfirmedSection']//h4")
	private WebElement orderConfirmedText;

	// locator of order Confirmed Text Description
	@FindBy(xpath = "//div[@data-qa='OrderConfirmedSection']/p")
	private WebElement orderConfirmedDescription;

	// locator of cooking In Process Text
	@FindBy(xpath = "//div[@data-qa='CookinginprocessSection']//h4")
	private WebElement cookingInProcessText;

	// locator of cooking In Process Description
	@FindBy(xpath = "//div[@data-qa='CookinginprocessSection']/p")
	private WebElement cookingInProcessDescription;

	// locator of sure Quality Check Text
	@FindBy(xpath = "//div[@data-qa='SurequalitycheckSection']//h4")
	private WebElement sureQualityCheckText;

	// locator of sure Quality Check Description
	@FindBy(xpath = "//div[@data-qa='SurequalitycheckSection']/p")
	private WebElement sureQualityCheckDescription;

	// locator of out For Delivery Text
	@FindBy(xpath = "//div[@data-qa='OutfordeliverySection']//h4")
	private WebElement outForDeliveryText;

	// locator of out For Delivery Description
	@FindBy(xpath = "//div[@data-qa='OutfordeliverySection']//p")
	private WebElement outForDeliveryDescription;

	// locator of view Order Details Order Crn
	@FindBy(xpath = "//div[@data-qa='orderDetailsCrn']")
	private WebElement viewOrderDetailsOrderCrn;

	// locator of view Order Details No Of Items Display
	@FindBy(xpath = "//div[@data-qa='orderHistoryDetails']")
	private WebElement viewOrderDetailsNoOfItemsDisplay;

	// locator of view Order Details Address
	@FindBy(xpath = "//div[@data-qa='deliveryAddress']")
	private WebElement viewOrderDetailsAddress;

	// locator of view Order Details List Of Products
	@FindBy(xpath = "//div[@data-qa='productListItem']")
	private WebElement viewOrderDetailsListOfProducts;

	// locator of view Order Details Bill Details
	@FindBy(xpath = "//div[@data-qa='billDetailsHeading']")
	private WebElement viewOrderDetailsBillDetails;

	// locator of app Download Section
	@FindBy(xpath = "//div[@data-qa='downloadEsApp']")
	private WebElement appDownloadSection;

	// locator of give Sure Section
	@FindBy(xpath = "//h6[@data-qa='giveSureSection']")
	private WebElement giveSureSection;

	// locator of sure Points Section
	@FindBy(xpath = "//h5[@data-qa='surePointSection']")
	private WebElement surePointsSection;

	// locator of help Section
	@FindBy(xpath = "//p[@data-qa='helpOption']")
	private WebElement helpSection;
	
	//locator for delivery later tracking page statement
	@FindBy(xpath="//p[normalize-space()='Order will be delivered By']")
	private WebElement statement;
	
	//loactor for tracking page crn
	@FindBy(xpath="//p[@data-qa='orderCrn']")
	private WebElement crnTracking;
	
	

	public TrackingOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**************** Methods for payments *******************/

	/**
	 * Description: verifying tracking order page is displayed and order popup modal
	 *
	 * @param driver
	 * @author vivek varma
	 */
	public void verifyTrackingOrderPage(WebDriver driver) {
		BasePage.waitForVisibility(driver, orderPlacedPopup);
		Assert.assertEquals("Your order placed succesfully!", orderPlacedPopup.getText());
		BasePage.wait(3);
		BasePage.waitForVisibility(driver, orderTracking);
		Assert.assertTrue(eswebLogo.isDisplayed());
		Assert.assertEquals("Order Tracking", orderTracking.getText());
		Assert.assertTrue(orderCrn.isDisplayed());

	}

	/**
	 * Description: verifying view order detail link and payment mode in details
	 * popup modal
	 *
	 * @param driver
	 * @author vivek varma
	 */

	public void verifyViewOrderLink(WebDriver driver) {
		BasePage.wait(2);
		Assert.assertTrue(viewOrderDetailsLink.isDisplayed());
		Assert.assertTrue(viewOrderDetailsLink.isEnabled());
		BasePage.clickElement(driver, viewOrderDetailsLink);
		BasePage.wait(2);
		Assert.assertTrue(orderDetailsPopup.isDisplayed());
		BasePage.scrollToElement(driver, paidbyText);
		log.info("payment mode :" + paidbyText.getText());
	}

	/**
	 * Description: Verify Order Deliver Text
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyOrderDeliverText() {

		if (orderDeliverText.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Order Date Time Text
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyOrderDateTimeText() {

		if (orderDateTimeText.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify View Order Details Button
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyViewOrderDetailsButton() {

		if (viewOrderDetailsButton.isDisplayed()) {
			return true;

		} else
			return false;
	}
	/**
	 * Description: Verify View Order Details Link for Deliver Now
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyViewOrderDetailsDeliverNow() {

		if (viewOrderDetailsDeliverNow.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Order Confirmed Text
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyOrderConfirmedText() {

		if (orderConfirmedText.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify cooking In Process Text
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyCookingInProcessText() {

		if (cookingInProcessText.isDisplayed()) {
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
	public boolean verifyCookingInProcessDescription() {

		if (cookingInProcessDescription.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Sure Quality Check Text
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifySureQualityCheckText() {

		if (sureQualityCheckText.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Sure Quality Check Description
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifySureQualityCheckDescription() {

		if (sureQualityCheckDescription.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Out For Delivery Text
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyOutForDeliveryText() {

		if (outForDeliveryText.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Out For Delivery Description
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyOutForDeliveryDescription() {

		if (outForDeliveryDescription.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify View Order Details Order Crn
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyViewOrderDetailsOrderCrn() {

		if (viewOrderDetailsOrderCrn.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify View Order Details NoOfItems Display
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyViewOrderDetailsNoOfItemsDisplay() {

		if (viewOrderDetailsNoOfItemsDisplay.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify View Order Details Address
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyViewOrderDetailsAddress() {

		if (viewOrderDetailsAddress.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify View Order Details List Of Products
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyViewOrderDetailsListOfProducts() {

		if (viewOrderDetailsListOfProducts.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify View Order Details Bill Details
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyViewOrderDetailsBillDetails() {

		if (viewOrderDetailsBillDetails.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify App Download Section
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyAppDownloadSection() {

		if (appDownloadSection.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify give Sure Section
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyGiveSureSection() {

		if (giveSureSection.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Sure Points Section
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
	 * Description: Verify help Section
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyhelpSection() {

		if (helpSection.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify click View Order Details Button
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickViewOrderDetailsButton(WebDriver driver) {
		BasePage.waitForVisibility(driver,viewOrderDetailsButton );
		clickJavaScript(viewOrderDetailsButton, driver);
	}
	/**
	 * Description: Verify click View Order Details Deliver now Link
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickViewOrderDetailsLinkDeliverNow(WebDriver driver) {
		BasePage.waitForVisibility(driver,viewOrderDetailsDeliverNow );
		clickJavaScript(viewOrderDetailsDeliverNow, driver);
	}


	/**
	 * Description: Verify Order Placed Popup
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyOrderPlacedPopup() {

		if (orderPlacedPopup.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Es Web Logo
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyEsWebLogo() {

		if (eswebLogo.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Order Tracking Text
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyOrderTrackingText() {

		if (orderTracking.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Order Crn
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyOrderCrn() {

		if (crnTracking.isDisplayed()) {
			return true;

		} else
			return false;
	}
	
	/**
	 * Description: Verify Order Crn in the order details page 
	 * 
	 * @author Soumya Adhikary
	 * @param driver
	 */
	public boolean verifyOrderCrnOrderDetailsPage() {

		if (viewOrderDetailsOrderCrn.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify View Order Details Link
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyViewOrderDetailsLink() {

		if (viewOrderDetailsLink.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Order Details Popup
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyOrderDetailsPopup() {

		if (orderDetailsPopup.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Paid by Text
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyPaidbyText() {
		Assert.assertTrue(orderDetailsPopup.isDisplayed());
		BasePage.scrollToElement(driver, paidbyText);
		log.info("payment mode :" + paidbyText.getText());

		if (paidbyText.isDisplayed()) {
			return true;

		} else
			return false;
	}
	

	/**
	 * Description: Verify click Close Order Details Popup
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickCloseOrderDetails(WebDriver driver) {
		BasePage.waitForVisibility(driver,closeOrderDetails );
		clickJavaScript(closeOrderDetails, driver);
	}
	
	/**
	 * Description: Verify delivery later statement 
	 * @author Soumya Adhikary
	 * @param driver
	 */
	public boolean statementdeliverylater() {
		if(statement.isDisplayed()) {
			return true;
		}
		return false;
	}
	
}
