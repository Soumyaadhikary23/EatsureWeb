package com.eatsure.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class MenuPage extends BasePage {
	public MenuPage(WebDriver driver) {
		// super(driver);
		PageFactory.initElements(driver, this);
	}

	SoftAssert asrt = new SoftAssert();

	// Locator of Menu Option
	@FindBy(xpath = "//p[@data-qa='menuOption']")
	public WebElement menuOption;

	// Locator of Help & Support
	@FindBy(xpath = "//a[normalize-space()='Help & Support']")
	public WebElement helpNSupport;

	// Locator of closeWindowPopupLoginScreen
	@FindBy(xpath = "//div[@data-qa='closeWindowPopup']")
	public WebElement closeWindowPopupLoginScreen;

	// Locator of My Profile
	@FindBy(xpath = "//a[normalize-space()='My Profile']")
	public WebElement myProfile;

	// Locator of SurePoints FAQs
	@FindBy(xpath = "//a[@data-qa='linkToSurePointsFAQ']")
	public WebElement surePointsFAQs;

	// Locator of close Side bar Menu
	@FindBy(xpath = "//button[@data-qa='closeSidebarMenu']")
	public WebElement closeSidebarMenu;

	// Locator of Sure Points FAQs Text
	@FindBy(xpath = "//div[@class='style__Heading-vsmj7n-2 knJFLt']")
	public WebElement surePointsFAQsText;

	// Locator of FAQs
	@FindBy(xpath = "//a[@data-qa='linkToFAQ']")
	public WebElement fAQs;

	// Locator of FAQ Text
	@FindBy(xpath = "//div[@data-qa='faqHeadingText']")
	public WebElement fAQTexts;

	// Locator of About EatSure
	@FindBy(xpath = "//a[normalize-space()='About EatSure']")
	public WebElement aboutEatSure;

	// Locator of high GradeIngredients Info
	@FindBy(xpath = "//div[@data-qa='highGradeIngredients']")
	public WebElement highGradeIngredientsInfo;

	// Locator of Terms & Conditions
	@FindBy(xpath = "//a[@data-qa='linkToTermsConditions']")
	public WebElement termsNConditions;

	// Locator of tncHeading
	@FindBy(xpath = "//p[@data-qa='tncHeading']")
	public WebElement tncHeading;

	// Locator of tandcHeading
	@FindBy(xpath = "//p[@data-qa='tandcHeading']")
	public WebElement tandcHeading;

	// Locator of Privacy Policy
	@FindBy(xpath = "//a[normalize-space()='Privacy Policy']")
	public WebElement privacyPolicy;

	// Locator of Privacy Policy Text
	@FindBy(xpath = "//p[@data-qa='privacyPolicyHeadingText']")
	public WebElement privacyPolicyText;

	// Locator of Party Orders
	@FindBy(xpath = "//a[@data-qa='linkToPartyOrders']")
	public WebElement partyOrders;

	// Locator of Contact us
	@FindBy(xpath = "//button[@data-qa='corporateOrderContactUsButton']")
	public WebElement contactUs;

	// Locator of Eatsure Logo
	@FindBy(xpath = "//a[@data-qa='headerEatsureLogo']")
	public WebElement eatsureLogo;

	// Locator of Here To Help You Text
	@FindBy(xpath = "//div[@data-qa='contactUsSection']")
	public WebElement weAreHereToHelpYouText;

	// Locator of SignInOption
	@FindBy(xpath = "//span[@class='userSP']")
	public WebElement signInOption;

	// Locator of SurePoints
	@FindBy(xpath = "//a[normalize-space()='SurePoints']")
	public WebElement surePoints;

	// Locator of SurePoints Balance
	@FindBy(xpath = "//div[@data-qa='surePointsInfoHeadingText']")
	public WebElement surePointsBalance;

	// Locator of Help and Support Header Text
	@FindBy(xpath = "//div[@class='headerTitleWrapper']")
	public WebElement helpAndSupportHeaderText;

	// Locator of My Orders Navigation Text
	@FindBy(xpath = "//div[@data-qa='MyOrdersNav']")
	public WebElement myOrdersNavigationText;

	// locator for log out button click
	@FindBy(xpath = "//div[@data-qa='logOutButton']")
	private WebElement logOutButton;

	// locator for Confirm log out Yes button click
	@FindBy(xpath = "(//button[starts-with(@class,'Button')])[1]")
	private WebElement confirmLogOutButton;

	// Action
	/**
	 * Description: click on menu Option
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickMenuOption(WebDriver driver) {

		clickJavaScript(menuOption, driver);

	}

	/**
	 * Description: click on Sign In Option
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickSignInOption(WebDriver driver) {

		clickJavaScript(signInOption, driver);

	}

	/**
	 * Description: Verify MY Orders Navigation Text
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyMyOrdersNavigationText() {

		if (myOrdersNavigationText.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify help N Support
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyHelpNSupport() {

		if (helpNSupport.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Help And Support Header Text
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyHelpAndSupportHeaderText() {

		if (helpAndSupportHeaderText.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: click on helpNSupport
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickHelpNSupport(WebDriver driver) {

		clickJavaScript(helpNSupport, driver);

	}

	/**
	 * Description: Verify Close Window Popup Login Screen
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyCloseWindowPopupLoginScreen() {

		if (closeWindowPopupLoginScreen.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: click on Close Window Popup LoginScreen
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickCloseWindowPopupLoginScreen(WebDriver driver) {

		clickJavaScript(closeWindowPopupLoginScreen, driver);

	}

	/**
	 * Description: Verify My Profile
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyMyProfile() {

		if (myProfile.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: click on My Profile
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickMyProfile(WebDriver driver) {

		clickJavaScript(myProfile, driver);

	}

	/**
	 * Description: Verify SurePointsFAQs
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifySurePointsFAQs() {

		if (surePointsFAQs.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: click on Sure Points FAQs
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickSurePointsFAQs(WebDriver driver) {

		clickJavaScript(surePointsFAQs, driver);

	}

	/**
	 * Description: Verify SurePoints
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifySurePoints() {

		if (surePoints.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: click on Sure Points
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickSurePoints(WebDriver driver) {

		clickJavaScript(surePoints, driver);

	}

	/**
	 * Description: Verify Close Sidebar Menu
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyCloseSidebarMenu() {

		if (closeSidebarMenu.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: click on Close Sidebar Menu
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickCloseSidebarMenu(WebDriver driver) {

		clickJavaScript(closeSidebarMenu, driver);

	}

	/**
	 * Description: Verify Sure PointsFAQsText
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifySurePointsFAQsText() {

		if (surePointsFAQsText.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Sure Points Balance
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifySurePointsBalance() {

		if (surePointsBalance.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify FAQs
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyFAQs() {

		if (fAQs.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: click on FAQs
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickFAQs(WebDriver driver) {

		clickJavaScript(fAQs, driver);

	}

	/**
	 * Description: Verify FAQ Texts
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyFAQTexts() {

		if (fAQTexts.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify About EatSure
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyAboutEatSure() {

		if (aboutEatSure.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: click on About EatSure
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickAboutEatSure(WebDriver driver) {

		clickJavaScript(aboutEatSure, driver);

	}

	/**
	 * Description: Verify High GradeIngredients Info
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyHighGradeIngredientsInfo() {

		if (highGradeIngredientsInfo.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Terms N Conditions
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyTermsNConditions() {

		if (termsNConditions.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: click on TermsNConditions
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickTermsNConditions(WebDriver driver) {

		clickJavaScript(termsNConditions, driver);

	}

	/**
	 * Description: Verify Tnc Heading
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyTncHeading() {

		if (tncHeading.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Tandc Heading
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyTandcHeading() {

		if (tandcHeading.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Privacy Policy
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyPrivacyPolicy() {

		if (privacyPolicy.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: click on Privacy Policy
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickPrivacyPolicy(WebDriver driver) {

		clickJavaScript(privacyPolicy, driver);

	}

	/**
	 * Description: Verify Privacy Policy Text
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyPrivacyPolicyText() {

		if (privacyPolicyText.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Party Orders
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyPartyOrders() {

		if (partyOrders.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: click on Party Orders
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickPartyOrders(WebDriver driver) {

		clickJavaScript(partyOrders, driver);

	}

	/**
	 * Description: Verify Contact Us
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyContactUs() {

		if (contactUs.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify EatsureLogo
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyEatsureLogo() {

		if (eatsureLogo.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: click on Eatsure Logo
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void clickEatsureLogo(WebDriver driver) {

		clickJavaScript(eatsureLogo, driver);

	}

	/**
	 * Description: Verify We Are Here To Help You Text
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public boolean verifyWeAreHereToHelpYouText() {

		if (weAreHereToHelpYouText.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:logout button verify and click
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void logOut() {
		if (logOutButton.isDisplayed()) {
			logOutButton.click();
		}
	}

	/**
	 * Description:Confirm logout Yes button click
	 * 
	 * @author Pankaj Gokhale
	 * @param driver
	 */
	public void confirmLogOut() {
		if (confirmLogOutButton.isDisplayed()) {
			confirmLogOutButton.click();
		}
	}

}
