package com.eatsure.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Profile extends BasePage {

	public void ProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebDriverWait wait;

	SoftAssert asrt = new SoftAssert();

	// Locator for menu bar
	@FindBy(xpath = "//p[@data-qa=\"menuOption\"]")
	private WebElement menuBar;

	// Locator for profile option
	@FindBy(xpath = "//a[normalize-space()='My Profile']")
	private WebElement profile;
	// locator for close menu bar
	@FindBy(xpath = "//button[@data-qa='closeSidebarMenu']")
	private WebElement closeMenu;
	// locator for my order section
	@FindBy(xpath = "//div[@data-qa='myordersNav']")
	public WebElement myOrder;
	// locator for manage address
	@FindBy(xpath = "//div[@data-qa='manageaddressNav']")
	public WebElement manageAddress;
	// locator for sure point section
	@FindBy(xpath = "//div[@data-qa='SurepointsNav']")
	public WebElement surePoint;
	@FindBy(xpath = "//div[@data-qa='abouteatsureNav']")
	public WebElement aboutEatsure;
	@FindBy(xpath = "//div[@data-qa='TermsandConditionsNav']")
	public WebElement t_and_c;
	// locator for profile page user name
	@FindBy(xpath = "//p[@class='user_name']")
	private WebElement p_UserName;
	// LOCATOR for header username
	@FindBy(xpath = "//span[@class='userSP']/a[1]")
	private WebElement h_UserName;
	// locator for profile page user mobile number
	@FindBy(xpath = "//div[@data-qa='userDetails']/div[2]/p[2]")
	private WebElement userNumber;
	// loctaor for edit profile button
	@FindBy(xpath = "//span[normalize-space()='Edit profile']")
	public WebElement editButton;
	// Locator for edit email
	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement editEmail;
	// locator for submit button for edit
	@FindBy(xpath = "//button[@role='submit']")
	private WebElement saveButton;
	// locator for subsection heading
	@FindBy(xpath = "//p[starts-with(@class,'style__PageTitle')]")
	private WebElement heading;
	// locator for order crn
	@FindBy(xpath = "(//div[@data-qa='orderCrn'])[1]")
	private WebElement CRN;
	// locator for order 2nd crn
	@FindBy(xpath = "(//div[@data-qa='orderCrn'])[2]")
	public WebElement secondCRN;
	// locator for one order items count
	@FindBy(xpath = "(//div[@data-qa='orderItemCount'])[1]")
	private WebElement itemCount;
	// locator for one order total price
	@FindBy(xpath = "(//div[@data-qa='orderTotalPrice'])[1]")
	private WebElement price;
	// locator for order date time
	@FindBy(xpath = "(//div[@data-qa='orderTime'])[1]")
	private WebElement dateTime;
	// locator for order journey
	@FindBy(xpath = "(//div[@data-qa='orderJourneySection'])[1]")
	private WebElement trackJourney;
	// locator for order address section
	@FindBy(xpath = "(//div[@data-qa='orderAddressSection'])[1]")
	private WebElement orderAddress;
	// locator for track order section
	@FindBy(xpath = "(//button[@data-qa='trackOrderButton'])[1]")
	public WebElement trackOrder;
	// locator for view details option
	// @FindBy(xpath = "(//div[contains(text(),'View Order Details')])[1]")
	@FindBy(xpath = "(//div[@data-qa='viewDetailsButton'])[1]")
	private WebElement viewDetails;
	// locator for sure point count
	@FindBy(xpath = "//div[starts-with(@class,'style__SurePointBalance-sc')]")
	private WebElement surePoints;
	// locator for header surepoint count
	@FindBy(xpath = "//p[@data-qa='profileOption']//span/a[2]")
	private WebElement headerSurePoint;
	// locator for statement section
	@FindBy(xpath = "//li[normalize-space()='Statement']")
	private WebElement sureStatement;
	// locator for t&c in sure point section
	@FindBy(xpath = "//li[normalize-space()='Terms & Condition']")
	private WebElement tcSure;
	// locator for use now button for sure point
	@FindBy(xpath = " //button[normalize-space()='Use Now']")
	private WebElement useNow;
	// locator for "Enter order id and claim
	@FindBy(xpath = "(//button[@role='button'])[2]")
	private WebElement buttonClaim;
	// locator for box for order crn put
	@FindBy(xpath = "//input[@id='order_crn']")
	private WebElement boxOrder;
	// locator for sure earning section
	@FindBy(xpath = "//div[@data-qa='sureEarningsHeading']")
	private WebElement sureEarning;
	// locator for Eatmore and save more section
	@FindBy(xpath = "//div[@data-qa='saveMoreHeading']")
	private WebElement saveMoreSection;
	// locator for about eatsure section

	/*
	 * Description:click on the menu
	 */
	public boolean Menu() {
		if (menuBar.isDisplayed()) {
			menuBar.click();
			return true;
		}
		return false;

	}

	/*
	 * Description: click on the profile
	 */
	public boolean profileClick() {
		if (profile.isDisplayed()) {
			profile.click();

			return true;
		}
		return false;
	}

	/*
	 * Description : close the menu bar
	 */
	public void close(WebDriver driver) {
		BasePage.waitForVisibility(driver, closeMenu);
		clickJavaScript(closeMenu, driver);
		

	}

	/*
	 * Description : verify the subsection visibility
	 */
	public boolean profileSubSection() {
		if (myOrder.isDisplayed() && manageAddress.isDisplayed() && surePoint.isDisplayed()
				&& aboutEatsure.isDisplayed() && t_and_c.isDisplayed()) {
			return true;
		}
		return false;
	}

	/*
	 * Description : profile page user name
	 */
	public String proflieUserName() {
		String UN = p_UserName.getText();
		return UN;
	}

	/*
	 * Description : profile page header user name
	 */
	public String headerUserName() {
		String h_UN = h_UserName.getText();
		return h_UN;
	}

	/*
	 * Description : get the user mobile number from the profile page
	 */
	public boolean uNumber() {
		if (userNumber.isDisplayed()) {
			String number = userNumber.getText().replace("+91", " ").trim();
			return true;
		}
		return false;

	}

	/*
	 * Description : edit button verify
	 */
	public boolean edit() {
		if (editButton.isDisplayed()) {
			editButton.click();
			return true;
		}
		return false;
	}

	/*
	 * Description : change the email
	 */
	public void changeEmail() {
		editEmail.clear();
		editEmail.sendKeys("testautomation@gmail.com");
	}

	/*
	 * Description : save button verify
	 */
	public void submit() {
		if (saveButton.isDisplayed()) {
			saveButton.click();
		}
	}

	/*
	 * Description : verify the heading
	 */

	public String subHeading() {
		String Heading = heading.getText();
		return Heading;
	}

	/*
	 * Description : verify the crn
	 */
	public boolean orderCRN() {
		if (CRN.isDisplayed()) {
			return true;
		}
		return false;
	}

	/*
	 * Description : verify the order count
	 */
	public int item() {
		if (itemCount.isDisplayed()) {
			int itemCountText = Integer.parseInt(itemCount.getText().split(" ")[0].trim());
			return itemCountText;
		}
		return 0;

	}

	/*
	 * Description : verify total price
	 */
	public int totalPrice() {
		if (price.isDisplayed()) {
			int itemCountText = Integer.parseInt(price.getText().split(" ")[0].replace(",", "").trim());
			return itemCountText;
		}
		return 0;

	}

	/*
	 * Description: verify the date and time
	 */
	public boolean orderTime() {
		if (dateTime.isDisplayed()) {
			return true;
		}
		return false;
	}

	/*
	 * Description: verify order tracking journey
	 */
	public boolean orderJourney() {
		if (trackJourney.isDisplayed()) {
			return true;
		}
		return false;
	}

	/*
	 * Description: verify order address
	 */
	public boolean orderAddress() {
		if (orderAddress.isDisplayed()) {
			return true;
		}
		return false;
	}

	/*
	 * Description: verify track order button
	 */
	public boolean orderTrackButton() {
		if (trackOrder.isDisplayed()) {
			trackOrder.click();
			return true;
		}
		return false;
	}

	/*
	 * Description: verify view details button
	 */
	public boolean orderDetails(WebDriver driver) {
		BasePage.waitForVisibility(driver, viewDetails);
	if(viewDetails.isDisplayed()) {
		viewDetails.click();
			return true;
		}
		return false;
	}

	public void surePoint() {
		surePoint.click();
	}

	/*
	 * Description :get the sure point count from sure point section
	 */
	public int countSureP() {
		int surePoint = Integer.parseInt(surePoints.getText());
		return surePoint;
	}

	/*
	 * Description :get the sure point count from header sure point section
	 */
	public int headerSurePoint() {
		int headerSP = Integer.parseInt(headerSurePoint.getText().split(" ")[0].trim());
		return headerSP;
	}

	/*
	 * Description:verify the statement and t&c section in the sure point subsection
	 */
	public boolean verifyStatement() {
		if (sureStatement.isDisplayed() && tcSure.isDisplayed()) {
			return true;
		}
		return false;
	}

	/*
	 * Description : verify the use now button for sure point
	 */
	public boolean useNowSurePoint() {
		if (useNow.isDisplayed()) {

			return true;
		}
		return false;
	}

	/*
	 * Description : verify the order claim button from sure point
	 */
	public boolean claim() {
		if (buttonClaim.isDisplayed()) {
			buttonClaim.click();
			if (boxOrder.isDisplayed()) {
				return true;
			}
		}
		return false;

	}

	/*
	 * Description : sure earning section verify
	 */
	public boolean sureEarning() {
		if (sureEarning.isDisplayed()) {
			return true;
		}
		return false;
	}

	public boolean eatMoreSaveMore() {
		if (saveMoreSection.isDisplayed()) {
			return true;
		}
		return false;
	}

	public void about() {
		aboutEatsure.click();
	}

	public void tremCondition() {
		t_and_c.click();
	}
}
