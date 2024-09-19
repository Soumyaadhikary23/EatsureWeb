package com.eatsure.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class LandingPage extends BasePage{

//	public LandingPage(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}

	public LandingPage(WebDriver driver) {
		//super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	// Create object of SoftAssert
	SoftAssert asrt = new SoftAssert();

	public WebDriverWait wait;

	// Landing URL
	private String URL = "https://staging9-web.eatsure.com/";

	// Locator of location TextBox
	@FindBy(xpath = "//input[@data-qa='locationTextBox']")
	private WebElement locationTextBox;

	// Locator of Location Selection
	@FindBy(xpath = "//ul[@data-qa='autoSuggestions']/li[1]")
	private WebElement locationSelection;

	// Locator of EatSure logo
	@FindBy(xpath = "//img[@data-qa='eatsureIcon']")
	private WebElement eatsureIcon;

	// Locator of Trusted Restaurants Header Text
	@FindBy(xpath = "//h1[@data-qa='trustedRestaurantsHeaderText']")
	private WebElement trustedRestaurantsHeaderText;

	// Locator of Free Delivery Header Text
	@FindBy(xpath = "//p[@data-qa='freeDeliveryHeaderText']")
	private WebElement freeDeliveryHeaderText;

	// Locator of Food Court Header Text
	@FindBy(xpath = "//div[@data-qa='foodCourtHeaderText']")
	private WebElement foodCourtHeaderText;

	// Locator of Locate me Text
	@FindBy(xpath = "//span[@data-qa='locateMeText']")
	private WebElement locateMeText;

	// Locator of Order Food Button
	@FindBy(xpath = "//button[@data-qa='orderFoodButton']")
	private WebElement orderFoodButton;

	// Locator of Auto Suggestion
	@FindBy(xpath = "//ul[@data-qa='autoSuggestions']")
	private WebElement autoSuggestions;

	// Locator of Clear Search Button
	@FindBy(xpath = "//div[@data-qa='clearButton']")
	private WebElement clearButton;

	// Locator of Change Location Button
	@FindBy(xpath = "//button[@data-qa='changeLocationButton']")
	private WebElement changeLocationButton;

	// Locator of Get Notified Option
	@FindBy(xpath = "//button[@data-qa='getNotifiedButton']")
	private WebElement getNotifiedButton;

	// Locator of Not Serviceable Error Heading
	@FindBy(xpath = "//div[@data-qa='notServiceableErrorHeading']")
	private WebElement notServiceableErrorHeading;

	// Locator of Get Notified Window Popup
	@FindBy(xpath = "//div[@data-qa='getNotifiedWindowPopup']")
	private WebElement getNotifiedWindowPopup;

	// Locator of Get Notified Text inside Window popup
	@FindBy(xpath = "//div[@data-qa='getNotifiedTextInsidePopup']")
	private WebElement getNotifiedTextInsidePopup;

	// Locator of Your Location Text
	@FindBy(xpath = "//span[@data-qa='yourLocationText']")
	private WebElement yourLocationText;

	// Locator of Enter your number Text
	@FindBy(xpath = "//span[@data-qa='enterYourNumberText']")
	private WebElement enterYourNumberText;

	// Locator of Get Notified disabled button
	@FindBy(xpath = "//button[@data-qa='getNotifiedDisabledButton']")
	private WebElement getNotifiedDisabledButton;

	// Locator of Close Icon of Window popup
	@FindBy(xpath = "//div[@data-qa='closeWindowPopup']")
	private WebElement closeWindowPopup;

	// Locator of Order Food Button Error Appears
	@FindBy(xpath = "//div[@data-qa='errAppearsOrderFoodButton']")
	private WebElement errAppearsOrderFoodButton;

	// Action
	/**
	 * Description: Enter your location
	 *
	 * @param LocationName
	 */

	public void enterLocation(String LocationName) {
		locationTextBox.sendKeys(LocationName);
	}

	/**
	 * Description: Select the location
	 *
	 */
	public void selectLocation() {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("locationSelection"))).click();
		locationSelection.click();

	}

	/**
	 * Description: Verify Landing Page header logo
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public boolean verifyLandingPageHeaderLogo() {

		if (eatsureIcon.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:Verify Landing Page Trusted Restaurants Header Text
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public boolean verifytrustedRestaurantsHeaderText() {

		if (trustedRestaurantsHeaderText.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:Verify Landing Page Free Delivery Header Text
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public boolean verifyfreeDeliveryHeaderText() {

		if (freeDeliveryHeaderText.getText().equalsIgnoreCase(
				"Sign up for Sure Squad - our loyalty program and get exclusive benefits like free dish and free delivery!")) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:Verify Landing Page Food Court Header Text
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public boolean verifyfoodCourtHeaderText() {

		if (foodCourtHeaderText.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:Verify Landing Page Locate Me Text
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public boolean verifylocateMeText() {

		if (locateMeText.getText().equalsIgnoreCase("Locate Me")) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:Verify Landing Page Order Food Button
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public boolean verifyorderFoodButton() {

		if (orderFoodButton.getText().equalsIgnoreCase("Order Food")) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:Verify Landing Page Auto Suggestions
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public boolean verifyAutoSuggestions() {

		if (autoSuggestions.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:Click on Clear Search Button
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public void clickClearSearchBtn(WebDriver driver) {
		BasePage.waitForVisibility(driver, clearButton);
		clickJavaScript(clearButton, driver);
	}

	/**
	 * Description:Verify Landing Page Not Serviceable Error Heading
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public boolean verifyNotServiceableErrorHeading() {

		if (notServiceableErrorHeading.getText().equalsIgnoreCase("Currently not serviceable at Pali")) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:Verify Change Location Button Display
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public boolean verifyChangeLocationButton() {

		if (changeLocationButton.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:Verify Landing Page Get Notified Button Display
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public boolean verifyGetNotifiedButton() {

		if (getNotifiedButton.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:Verify Landing Page Click on Change Location Button
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public void clickChangeLocationBtn(WebDriver driver) {
		BasePage.waitForVisibility(driver, changeLocationButton);
		clickJavaScript(changeLocationButton, driver);
	}

	/**
	 * Description:Verify Landing Page Click on Get Notified Button
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public void clickGetNotifiedBtn(WebDriver driver) {
		BasePage.waitForVisibility(driver, getNotifiedButton);
		clickJavaScript(getNotifiedButton, driver);
	}

	/**
	 * Description:Verify Landing Page Get Notified Window Popup
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public boolean verifyGetNotifiedWindowPopup() {

		if (getNotifiedWindowPopup.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:Verify Landing Page Get Notified Text Inside Popup
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public boolean verifyGetNotifiedTextInsidePopup() {

		if (getNotifiedTextInsidePopup.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:Verify Landing Page Your Location Text
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public boolean verifyYourLocationText() {

		if (yourLocationText.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:Verify Landing Page Enter Your Number Text
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public boolean verifyEnterYourNumberText() {

		if (enterYourNumberText.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:Verify Landing Page Get Notified Disabled Button
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public boolean verifyGetNotifiedDisabledButton() {

		if (getNotifiedDisabledButton.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:Verify Landing Page click Close Window Popup
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public void clickCloseWindowPopup(WebDriver driver) {
		BasePage.waitForVisibility(driver, closeWindowPopup);
		clickJavaScript(closeWindowPopup, driver);
	}

	/**
	 * Description:Verify Landing Page click Order Food Button
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public void clickOrderFoodButton(WebDriver driver) {
		BasePage.waitForVisibility(driver, orderFoodButton);
		clickJavaScript(orderFoodButton, driver);
	}

	/**
	 * Description:Verify Landing Page Error Appears Order Food Button
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public boolean verifyErrAppearsOrderFoodButton() {

		if (errAppearsOrderFoodButton.getText().equalsIgnoreCase("Please enter your location")) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:Verify Landing Page click LocateMe Text
	 * 
	 * @author Pankaj Gokhale
	 * @return
	 */
	public void clickLocateMeText(WebDriver driver) {
		BasePage.waitForVisibility(driver, locateMeText);
		clickJavaScript(locateMeText, driver);
	}

}
