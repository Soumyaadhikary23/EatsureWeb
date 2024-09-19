package com.eatsure.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage{
	
	public ProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// Locator of "Account Holder Name" form header
	@FindBy(xpath = "//p[@data-qa='profileOption']//a[1]")
	private WebElement profileName;
	
	public static By profileSideBarMenuList = By.xpath("//div[starts-with(@class,'style__NavigationItems-sc-1u7lkkd-8 heYjOe')]//div[starts-with(@class,'style__NavWrapper-gfw0ku')]");
	//private WebElement ;
	
	// Locator of "List of address" from Profile Page
	public static By getAddressList = By.xpath("//div[@data-qa='listOfAddress']");
	
	// Locator of "Address tag list" from Manage address
	public static By addressTagList = By.xpath("//div[@data-qa='addressType']");
	
	// locator of "delete address" button from profile page
	@FindBy(xpath = "//div[@class='actions']//button[@class='delete']")
	private WebElement deleteAddress;
	
	// locator of "delete address confirm popup" text from profile
	@FindBy(xpath = "//h5[@data-qa='addressConfirmationHeading']")
	private WebElement deleteAddressConfirmPopup;
	
	// locator of "Yes" button from delete address popup
	@FindBy(xpath = "//button[@data-qa='changeLocationBtnProductInCart']")
	private WebElement deleteAddressYesButton;
	
	// locator for list of "Edit address" button form profile
	public static By editAddressButtonList = By.xpath("//div[@class='actions']//button[@class='edit']");
	
	// locator of "Edit" link from profile
	@FindBy(xpath = "//button[@class='edit']")
	public WebElement editAddressButton;
	
	// locator of "Confirm locatoin and proceed" button from address screen
	@FindBy(xpath = "//button[@data-qa='confirmLocationBtn']")
	public WebElement confirmAndProceed;
	
	// locator to get the last address's text <p>
	@FindBy(xpath = "(//p)[last()]")
	public WebElement lastAddressText;
	
	// locator to get the existing "Home Address - Building/House/Flat no" value from edit address screen
	@FindBy(xpath = "//input[@id='home_address']")
	public WebElement homeAddressValue;
	
	// locator to get the existing "Apartment Rod" from edit screen
	@FindBy(xpath = "//input[@id='society_name']")
	public WebElement apartmentValue;
	
	// locator to get the "How to reach" from edit screen
	@FindBy(xpath = "//input[@id='nearest_landmark']")
	public WebElement howToReachValue;
	
	// locator to get address Tag value from Edit screen
	@FindBy(xpath = "//input[@id='other_address_type']")
	public WebElement addressTagValue;
	
	// locator of "Sace address details" button
	@FindBy(xpath = "//button[text()='Save Address Details']")
	public WebElement saveAddressDetailsBtn;
	
	// locator of "Map control-Zoom-in/Zoom out and GPS icon"
	@FindBy(xpath = "//div[@class='map-control']//a[@class='map-zoom-in']")
	public WebElement mapZoomIn;
	
	//locator of "Map control-Zoom Out"
	@FindBy(xpath = "//div[@class='map-control']//a[@class='map-zoom-out']")
	public WebElement mapZoomOut;
	
	// locator of "Map control-Gps"
	@FindBy(xpath = "//div[@class='map-control']//a[@id='geo_location']")
	public WebElement mapGps;
	
	//locator of "Change" button in address screen
	@FindBy(xpath = "//button[contains(text(),'Change')]")
	public WebElement changeBtn;
	
	// locator of "your delivery location" text from address screen
	@FindBy(xpath = "//label[@data-qa='deliveryLocationPinText']")
	public WebElement yourDeliveryLocationText;
	
	// locator of "address title" text
	@FindBy(xpath = "//div[@class='container']//h6")
	public WebElement addressTitleOnMapScreen;
	
	// locator of "Address sub text" from address map Screen
	@FindBy(xpath = "//div[@class='container']//p")
	public WebElement addressSubTextOnMapScreen;
	
	// locator of "Search location bar" from Address map screen
	@FindBy(xpath = "//div[@class='actions-top-map']//input[@placeholder='Search Location']")
	public WebElement searchLocationBar;
	
	// locator of "Back" arrow button from address map screen
	@FindBy(xpath = "//div[@class='actions-top-map']//span")
	public WebElement backArrow;
	
	// locator of "Map canvas" 
	@FindBy(xpath = "//div[@id='address-map-canvas']")
	public WebElement addressMapCanvas;
	
	// locator of "Cross" button to close address Popup
	@FindBy(xpath = "//div[@id='close']")
	public WebElement closeAddressPopup;
	
	// locator to get the text of enabling GPS permission from Address screen
	@FindBy(xpath = "//p[contains(text(),'Please enable device location for faster and hassl')]")
	public WebElement gpsPermissionText;
	
	// locator to get error msg "Store is out of delivery area, Please select nearby location to that store or change your location"
	@FindBy(xpath = "//p[@class='error']")
	public WebElement notServivableErrorMsg;
	
	// locator of "enable" GPS button from Address
	@FindBy(xpath = "//button[normalize-space()='Enable']")
	public WebElement enableGPSBtn;
	
	// locator to get the screen title "Enter your Delivery Location" from Address
	@FindBy(xpath = "//div[@data-qa='locationSearchHeading']")
	public WebElement titleOfDeliveryLocation;
	
	// locator to get the "Back" Arrow "<-" from address screen
	@FindBy(xpath = "//div[@class='head']//button[@type='button']")
	public WebElement backArrowFromAddressScreen;
	
	
	
	
	/**
	 * Description: Closing Address POPup by clicking "X" button
	 * @author Lalit
	 * @return
	 */
	public WebElement getCloseAddressPopup()
	{
		return closeAddressPopup;
	}
	
	/**
	 * Description: Clicking on profile menu
	 * @author Lalit
	 * @param driver
	 */
	public void clickOnProfileName(WebDriver driver)
	{
		
		click(profileName, driver);
		BasePage.wait(2);
	}
	
	/**
	 * Description: Clicking on Manage Address from Menu list
	 * @author Lalit
	 * @param driver
	 */
	public void clickOnManageAddress(WebDriver driver)
	{
		BasePage.wait(5);
		List<WebElement> profileSideMenuList = driver.findElements(profileSideBarMenuList);
		for(WebElement menuName : profileSideMenuList)
		{
			System.out.println("Menu name :"+menuName.getText());
			if(menuName.getText().contains("Manage Address")) 
			{
			  BasePage.clickElement(driver, menuName);	
			  //click(menuName, driver);
			  log.info("Successfully clicked on Mangae Address from Profile");
			  break;
			}
			 
		}
		
	}
	
	/**
	 * Description: Checking MapZoomIn button is displayed
	 * @author Lalit 
	 * @return
	 */
	public boolean zoomInIcon()
	{
		if(mapZoomIn.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Description: Checking MapZoomOut button is displayed
	 * @author Lalit 
	 * @return
	 */
	public boolean zoomOutIcon()
	{
		if(mapZoomOut.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Description: Checking GPS button is displayed
	 * @author Lalit 
	 * @return
	 */
	public boolean gpsIcon()
	{
		if(mapGps.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Description: Checking Change button is displayed
	 * @author Lalit 
	 * @return
	 */
	public boolean changeBtn()
	{
		if(changeBtn.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Description: Checking your delivery loaction text is displayed
	 * @author Lalit 
	 * @return
	 */
	public boolean yourDeliveryLocation()
	{
		System.out.println(yourDeliveryLocationText.getText());
		if(yourDeliveryLocationText.getText().trim().equalsIgnoreCase("your delivery location"))
		{
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Description: Checking Address title is displayed
	 * @author Lalit 
	 * @return
	 */
	public boolean addressTitle()
	{
		if(addressTitleOnMapScreen.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Description: Checking Address subtext is displayed
	 * @author Lalit 
	 * @return
	 */
	public boolean addressSubText()
	{
		if(addressSubTextOnMapScreen.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Description: Checking search LoactionBar is displayed
	 * @author Lalit 
	 * @return
	 */
	public boolean searchLocationBar()
	{
		if(searchLocationBar.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Description: Checking BackArrow button is displayed
	 * @author Lalit 
	 * @return
	 */
	public boolean backArrow()
	{
		if(backArrow.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}	
		
	/**
	 * Description: getting saved address count
	 * @author Lalit 
	 * @return
	 */
	public int getAddressCount(WebDriver driver)
	{
		int addressCount = driver.findElements(getAddressList).size();
		return addressCount;
	}
	
	/**
	 * Description: Delete existing address
	 * @author Lalit 
	 * @return
	 */
	public void deleteAddress(WebDriver driver)
	{
		int addressListBefore = driver.findElements(getAddressList).size();
		System.out.println("Address count before :"+addressListBefore);
		clickElement(driver, deleteAddress);
		clickElement(driver, deleteAddressYesButton);
		BasePage.waitUntilPageLoad(driver);
		int addressListAfter = driver.findElements(getAddressList).size();
		System.out.println("Address count after :"+addressListAfter);
		if(addressListBefore==addressListAfter)
		{
			log.info("Address not deleted");
		}
		else {
			log.info("Address deleted sucessfully");
		}
		
	}
	
	/**
	 * Description: getting the list of address Tags
	 * @author Lalit 
	 * @return
	 */
	public String addressTag(WebDriver driver)
	{
		List<WebElement> oldAddressTagList= driver.findElements(addressTagList);
		WebElement lastAddressTagText = oldAddressTagList.get(oldAddressTagList.size() - 1);
		String lastAddressTag = lastAddressTagText.getText();
		return lastAddressTag;
		
	}
	
	/**
	 * Description: Edit existing address
	 * @author Lalit 
	 * @return
	 */
	public void editExistingAddress(WebDriver driver)
	{
		 //WebElement homeAddress = homeAddressValue;
		 
		 //String lastAddress = lastAddressText.getText().replaceAll(",", " ").toString();
		 //System.out.println("last address is : "+ lastAddress);
		 BasePage.wait(2);
		 List<WebElement> savedAddressesList = driver.findElements(editAddressButtonList);
		 WebElement lastAddressEdit = savedAddressesList.get(0);
		 //WebElement lastAddressEdit = savedAddressesList.get(savedAddressesList.size() - 1);
		 BasePage.wait(3);
		 //BasePage.isElementClickable(lastAddressEdit, driver);
		 //BasePage.scrollToElement(driver, lastAddressEdit);
		 BasePage.moveToElementAndClick(driver, lastAddressEdit);
		 //lastAddressEdit.click();
		 BasePage.waitForVisibility(driver, confirmAndProceed);
		 confirmAndProceed.click();
		 homeAddressValue.clear();
		 homeAddressValue.sendKeys("Building123");
		 apartmentValue.clear();
		 apartmentValue.sendKeys("ApartmentRebel");
		 howToReachValue.clear();
		 howToReachValue.sendKeys("RebelRoad");
		 addressTagValue.clear();
		 addressTagValue.sendKeys("RebelTag");
		 
		 saveAddressDetailsBtn.click();
	}
}
