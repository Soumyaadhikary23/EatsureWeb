package com.eatsure.pom;




import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.eatsure.browser.Driver;

public class ProductListingPage extends BasePage {

	public ProductListingPage(WebDriver driver) {
		// super(driver);
		PageFactory.initElements(driver, this);
	}

	SoftAssert asrt = new SoftAssert();

	// Locator of Dropdown select Item in ProductListing page
	@FindBy(xpath = "//div[@data-qa='plpDrpdownSelectedItem']")
	private WebElement productListingPageDrpdownSelectItem;

	// Locator of first add Button
	// @FindBy(xpath =
	// "(//figure[starts-with(@class,'style__Card-sc')]//div[starts-with(@class,'style__AddToCartContainer-sc')])[1]/button")
	@FindBy(xpath = "(//button[@data-qa='addButton'])[1]")
	public WebElement addButton;

	// Locator of "continue" Button
	@FindBy(xpath = "//button[text()='CONTINUE']")
	private WebElement continueButton;

	// Locator of "VegInActive" filter icon
//	@FindBy(xpath = "//*[@data-qa='filterVegInActive']")
	@FindBy(xpath = "//button[text()='Veg']")
	private WebElement vegInActiveButton;

	// Locator of "NonVegInActive" filter icon
//	@FindBy(xpath = "//*[@data-qa='filterNonVegInActive']")
	@FindBy(xpath = "//button[text()='Non Veg']")
	private WebElement nonvegInActiveButton;

	// Locator of second "Explore All" button
	@FindBy(xpath = "(//button[@data-qa='plpExploreAllCta'])[2]")
	private WebElement plpsecondExploreAllButton;

//	//Locator of "veg" icon
//		//@FindBy(xpath = "(//div[@data-qa='isVeg'])[1]")
//		@FindBy(xpath = "//div[@data-qa='isVeg']")
//		public WebElement vegIcon;
//		
//	//Locator of "Nonveg" icon
//		//@FindBy(xpath = "(//div[@data-qa='isNonVeg'])[1]")
//		@FindBy(xpath = "//div[@data-qa='isNonVeg']")
//		public WebElement nonvegIcon;	
		
	//Locator of "veg" icon
		public static By vegIcon=By.xpath("//div[@data-qa='isVeg']");
		
	//Locator of "Nonveg" icon
		public static By nonVegIcon=By.xpath("//div[@data-qa='isNonVeg']");

		// locator of "category drop-down, sort/filter and veg/non-veg strip"
		@FindBy(xpath = "//div[@id='categoryDropdown']")
		private WebElement cuisinescategoryDropDownStrip;
		
		// Locator of "category drop-down list"
		@FindBy(xpath = "//div[@data-qa='plpDropdown']")
		private WebElement categoryDropDownList;
		
		// Locator of "the Text- Curated list of dishes most loved by our customers"
		@FindBy(xpath = "//div[starts-with(@class,'style__Heading-c6f054-2')]")
		private WebElement curatedListOfDishesTitle;
		
		// Locator of "Sort/Filter button"
		@FindBy(xpath = "//div[starts-with(@class,'FilterSort__FlexContainer-sc')]//div[starts-with(text(),'Sort/Filter')]")
		private WebElement sortFilterButton;
		
		// Locator of "Sort/Filter Apply button"
		@FindBy(xpath = "//div[starts-with(@class,'styles__TabFooter')]//button[@class='apply']")
		public WebElement applySortFilter;
		
		// Locator of "Cuisines slick-slder-category list"
		public static By curatedCuisinesCollectionList = By.xpath("//div[contains(@data-qa,'dishesCardContainer')]");
		//private List<WebElement> ;
		
		//locator of "Cuisines slick-slider-category-name-list"
		public static By curatedCuisinesNameList = By.xpath("//div[@data-qa='dishesCardContainer']//div[@data-qa='categoryName']");
		
		// Locator of "Cusines Page - All section title"
		@FindBy(xpath = "//h3[@data-qa='plpCategoryHeading']")
		private List<WebElement> allCollectionSectionTitle;
		
		// Locator of "Cuisines slik-slider first category"
		@FindBy(xpath = "(//div[starts-with(@class,'style__CardContainer-cnwpzu-0 YvMso')])[1]")
		private WebElement slickSliderFirstCategory;
		
		// Locator of "Cuisines collection page title"
		@FindBy(xpath = "h3[data-qa='plpCategoryHeading']")
		private WebElement cuisinesCollectionTitle;
		
		//Locattor of "Collection side bar list"
		public static By collectionSideBarList = By.xpath("//div[@id='collection-list-sidebar']//ul[@class='scrollSpyContainer']//li");
		//private By getCollectionSideBarList;
		
		//Locator of "CollectionProduct list title Name"
		public static By getCollectionProductSectionTitleList= By.xpath("//h6[contains(@class,'fMDIFO')]");
		//private By getCollectionProductSectionTitleList;
		
		// Locator of "Carousel next arrow button"
		@FindBy(xpath = "(//button[@type='button'][normalize-space()='Next'])[2]")
		private WebElement carouselNextArrow;
		
		// Locator for "Customization window"
		@FindBy(xpath = "//div[@data-qa='resetCustomizationCTA']")
		private WebElement customizationWindow;
		
		// Locator of "Cuisines Page- First section of Cuisines Page"
		@FindBy(xpath = "//section[1]//div//h3")
		private WebElement firstSectionNameOutSide;
		
		// locator of ""Cuisines Page- First section Name inside collection"
		@FindBy(xpath = "//div[starts-with(@class,'style__HeadingWrapper-sc-1sfumq6-3 fPVAVC')]//h3")
		private WebElement firstSectionNameInside;
		
		// Locator of "Cuisines Page- First section Explore All button"
		@FindBy(xpath = "//section[1]//a//button[contains(.,'Explore All')]")
		private WebElement exploreAllButton;
		
		// Locator of "Normal product from cuisines page"
		@FindBy(xpath = "(//figure[@class='style__Card-sc-1xxctwg-0 eSxSJe'])[40]//button")
		private WebElement addNormatItemsFromCuisines;
		
		// Locator of "Increase Normal Product qty from Cuisines"
		@FindBy(xpath = "//div[@data-qa='addQuantity']")
		private WebElement increaseProductQty;
		
		//Locator of "Product Qty"
		@FindBy(xpath = "//div[@data-qa='quantityToShow']")
		private WebElement productQty;
		
		//Locator of Products list
		@FindBy(xpath = "//figure[@data-qa='smallProductCard']")
		List<WebElement> products;
		By productsList = By.xpath("//figure[@data-qa='smallProductCard']");
		
		// Action
		
		
		/**
		 * Description:-This method will return the value of "Drpdown Select Item name" form ProductListing Page
		 * @return
		 * 
		 */
		public String getDrpdownSelectItemName() {
			String ProductListingPageDrpdownName = productListingPageDrpdownSelectItem.getText().toString();
			System.out.println("Drop down name in PLP:- " + ProductListingPageDrpdownName);
			return ProductListingPageDrpdownName;
		}
		
		// Verify Product Listing Page "Drop down Select Category"

	// Verify Product Listing Page "Drop down Select Category"
//		public boolean verifyProductListingPageDrpdownSelectItem() {
//
//			if (productListingPageDrpdownSelectItem.getText().equalsIgnoreCase("Must Try Dishes1")) {
//				return true;
//
//			} else
//				return false;
//		}

	/**
	 * Description:- This method will click on first Item from Product listing page
	 * @author vivek ranjan
	 * @param driver
	 * 
	 */
	public void addFirstItem(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addButton);

	}

	/**
	 * Description: This method will click on "Continue" button under place order
	 * journey
	 *@author vivek ranjan
	 */
	public void clickContinue() {
		continueButton.click();

	}

	/**
	 * Description: This method will click on "vegInActiveButton" button under veg &
	 * Non-Veg filter
	 *@author vivek ranjan
	 */
	public void clickvegInActiveButton() {
		vegInActiveButton.click();
	}

	/**
	 * Description: This method will click on "nonvegInActiveButton" button under
	 * veg & Non-Veg filter
	 * @author vivek ranjan
	 *
	 */
	public void clicknonvegInActiveButton() {
		nonvegInActiveButton.click();
	}
	// Verify "NonVeg" icon not present once select "veg" filter button under "PLP
	// page"

//			public boolean verifyPresenceofVegorNonVegIcon(WebDriver driver) {
//				List<WebElement> vegicons=driver.findElements(By.xpath("//div[@data-qa='isVeg']"));
//				System.out.println("Number of vegIcon "+ vegicons.size());
//				if (vegicons.size()!=0) {
//					return true;
//
//				} else
//					return false;
//			}

	/**
	 * Description: This method will validate the "Veg" or "NonVeg" icon
	 * @author vivek ranjan
	 * @param driver
	 * @param locator
	 * @return
	 */
	public boolean verifyPresenceofVegorNonVegIcon(WebDriver driver, By locator,String type) {
		List<WebElement> icons = driver.findElements(locator);
		log.info("Number of Icon of " + type + icons.size());
		if (icons.size() != 0) {
			return true;

		} else
			return false;
	}
	/**
	 * Description:-This method will click on "secondExploreAll" button
	 * @author vivek ranjan
	 * @param driver
	 */
	public void clicksecondExploreAll(WebDriver driver) {
		BasePage.scrollbar_down(driver);
		clickJavaScript(plpsecondExploreAllButton, driver);
	}
	
			/**
			 * Verify Cuisines Page category Drop-down Strip
			 * @author Lalit
			 * @return
			 */
			public boolean verifyCuisinesCategoryDropDownStrip() {

				if (cuisinescategoryDropDownStrip.isDisplayed()) {
					return true;

				} else
					return false;
			}
			
			/**
			 * Verify Curated list of dishes section title
			 * @author Lalit
			 * @return 
			 */
			public boolean verifylCuisinesPageCuratedListOfDishesTitle() {
				//BasePage.scrollbar_down(driver);
				if (curatedListOfDishesTitle.getText().equalsIgnoreCase("Curated list of dishes most loved by our customers")) {
					return true;

				} else
					return false;
			}
			
			/**
			 * Method to click on Normal Product from Cuisines page
			 * @author Lalit
			 * @param driver
			 */
			public void addNormatItem(WebDriver driver)
			{
				BasePage.waitUntilPageLoad(driver);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				//String[] itemsNeeded= {"Automation Masala Omlette + Latte Love","Lasagne- Veg & Non for 2 - Combo"};
				 // Define the names of the products you want to add to the cart
		        List<WebElement> products = driver.findElements(By.xpath("//div[starts-with(@class,'style__Title-sc-1xxctwg-8 dmwYVP')]"));
		        for (int i=0; i<products.size(); i++) 
		        {
		        	String name = products.get(i).getText().toString();
		        	//System.out.println("product Name is "+ name);
		        	if(name.contains("Automation Masala Omlette + Latte Love")) {
					 WebElement item =  driver.findElements(By.xpath(
					  "(//button[@role='button'][normalize-space()='add'])")).get(i);
					 js.executeScript("arguments[0].click();", item);
					  break;
					  }
				}
		    }
							
			/**
			 * Description: Method to click on Sort/filter button
			 * @author Lalit
			 * @param driver
			 */
			public void clickSortFilterButton(WebDriver driver)
			{
				BasePage.scrollToElement(driver, sortFilterButton);
				sortFilterButton.click();
			}
			
			/**
			 * Method to get all sort/filter choices list and click on given choice
			 * @author Lalit
			 * @param driver
			 */
			public void selectSortingFilterOption(WebDriver driver)
			{
				List<WebElement> sortChoices = driver.findElements(By.xpath("//div[@class='style__Wrapper-sc-1fi10uk-0 jhniOz']//label//p"));

				//System.out.println(sortChoices);
				for (WebElement sortChoice : sortChoices) {
					if (sortChoice.getText().contains("Cost: High to Low")) {
						sortChoice.click();
						log.info("User succesfully clicked on Sorting/Filter choice");
						break;
					}
				}
				
 				
			}
			
			/**
			 * Description : Method to click on "Apply" button for Sorting/Filter
			 * @author Lalit
			 */
			public void clickApplySortingFilter()
			{
				applySortFilter.click();
			}

			/**
			 * Description : Method to click on First Curated Category
			 * @author Lalit
			 * @param driver
			 */
			public void clickOnSlickSliderFirstCaretgory(WebDriver driver)
			{
				//BasePage.scrollToElement(driver, slickSliderFirstCategory);
				BasePage.waitForVisibility(driver, slickSliderFirstCategory);
				slickSliderFirstCategory.click();
				
			}
			
			/**
			 * Method to get the count of Curated category and Section list of those category
			 * @author Lalit
			 * @param driver
			 * @return
			 */
			public boolean verifyCuisinesAllCollectionSectionCount(WebDriver driver)
			{
				int collectionList = driver.findElements(By.xpath("//div[@class='style__CardContainer-cnwpzu-0 YvMso']")).size();
				int sectionList = driver.findElements(By.xpath("(//div[@class='style__HeadingWrapper-sc-1sfumq6-3 fPVAVC'])//h3//span")).size();
				if(collectionList == sectionList)
					return true;
				else
					return false;
				//assertEquals(collectionList, sectionList);
				
			}
			
			
			 public void clickCategoryDropDown()
			 {
				 categoryDropDownList.click();
				 
			 }
			 
			 /**
			  * Method to verify the section name outside in Cuisine page and inside collection page 
			  * @author Lalit
			  * @return
			  */
			 public boolean verifylCollectionByExploreFromCuisinesPage() {
				 String sectionNameOutSide = firstSectionNameOutSide.getText();
				 String sectionNameInside = firstSectionNameInside.getText();
				 
					if (sectionNameInside.equals(sectionNameOutSide)) {
						return true;

					} else
						return false;
				}
			 /** 
			  * Method to click on "Explore All" button from cuisine page section
			  * @author Lalit 
			  * @param driver
			  */
			 public void clickFirstSectionExploreAll(WebDriver driver)
			 {
				 scrollToElement(driver, exploreAllButton);
				 BasePage.clickJavaScript(exploreAllButton, driver);
				 //exploreAllButton.click();
			 }
			 
			 /**
			  * Method to verify the clicked menu title and opened products section title name
			  * @author Lalit
			  * @param driver
			  * @param locator
			  */
			 public void clickOnCollectionFromSideBar(WebDriver driver, By locator)
			 {
				 List<WebElement> sideBarCollectionList = driver.findElements(locator);
				 for(WebElement collection : sideBarCollectionList)
				 {
					 System.out.println(collection);
					 if(collection.getText().contains("Buy 1 get 1 meal"))
					 {	
						 BasePage.scrollbar_down(driver);
						 clickJavaScript(collection, driver);
						 log.info("Succesfully clicked on a collection from Side bar list");
						 break;
					 }
				 }
			 }
			 
			 /**
			  * Description: getting count of collection dishes
			  * @author Lalit
			  * @return 
			  * @param driver
			  * @param locator
			  */
			 public int getCuratedDishesCount(WebDriver driver, By locator)
			 {
				 List<WebElement> list = driver.findElements(curatedCuisinesCollectionList);
				 int numlist = list.size()-1;
				 //System.out.println(size);
				return numlist;
			 }
			 
			 /**
			  * Description: getting count of collection section
			  * @author Lalit
			  * @return
			  */
			 public int getAllCollectionSectionCount()
			 {
				 return allCollectionSectionTitle.size();
			 }
			 
			 /**
			  * Description: method to increase normal product QTY dynamically
			  *@author Lalit  
			  * @param driver
			  */
			 public void clickIncreaseProductQty(WebDriver driver)
			 {
				 int currentQty = Integer.parseInt(productQty.getText());
				 System.out.println("Current Qty :"+currentQty);
				 int neededQty = 3;
				 for(int i =1; i<=neededQty; i++)
				 {					 
					 if(currentQty!=neededQty)
					 {
						 clickJavaScript(increaseProductQty, driver);
						 List<WebElement> customizationWindow = driver.findElements(By.xpath("//div[@data-qa='customizationModalHeader']"));
						 if (!customizationWindow.isEmpty()) 
						 {
			                    // If customization window is present, click on the "Add" button in the customization window
			                    WebElement addInCustomization = customizationWindow.get(0).findElement(By.xpath("//button[@data-qa='addItemButton']"));
			                    addInCustomization.click();
			                    log.info("Customization added!");
			                    int newQty = Integer.parseInt(productQty.getText().toString());
								 currentQty = newQty;
								 System.out.println("Product new Qty is :"+newQty );
			             }			
					 }
					 break;
				 }
				 
				 
			 }
			 
			 /**
			  * Description : Clicking on Curated dish by mentioned dish text
			  * @author Lalit
			  * @param driver
			  */
			 public void clickOnCuratedCetegory(WebDriver driver)
			 {
				 List<WebElement> dishNameList = driver.findElements(curatedCuisinesNameList);
				 for(WebElement dish : dishNameList)
				 {
					 if(dish.getText().contains("Wraps"))
					 {
						 System.out.println(dish);
						 clickJavaScript(dish, driver);
						 log.info("Sucessfully clicked on Curated Dish from slider");
						 break;
					 }
				 }
			 }
			 
			 /**
			  * Description : Add product and check the qty updation on Cart stepper
			  * @author Lalit
			  * @param driver
			  */
			 public void getTheCheckoutStepper(WebDriver driver)
			 {
				 // Wait for the Checkout stepper to be visible
			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			        WebElement checkoutStepper = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fixed-reel")));
			     // Check if the Checkout stepper is visible
			        if (checkoutStepper.isDisplayed()) {
			            // The Checkout stepper is visible, now check if the quantity has updated
			            WebElement oldQty = checkoutStepper.findElement(By.xpath("//div[@class='fixed-reel']//div[@data-qa='totalItemsInCart']"));
			            String oldQuantityText = oldQty.getText();
			            int oldQuantity = Integer.parseInt(oldQuantityText.replaceAll("[\\D]", ""));
			            addProductToCartt(driver); // Add new product
			            WebElement newQuantityText = checkoutStepper.findElement(By.xpath("//div[@class='fixed-reel']//div[@data-qa='totalItemsInCart']"));
			            String newQuantity = newQuantityText.getText();
			            int updatedQuantity = Integer.parseInt(newQuantity.replaceAll("[\\D]", ""));
			            
			            if (updatedQuantity > oldQuantity) {
			                log.info("Quantity has been updated");
			            } else {
			                log.info("Quantity has not been updated");
			            }
			        } else {
			            log.info("Checkout stepper is not visible");
			        }
			        
			 }
			 
			 /**
			  * Description : add product to cart logic 2
			  * @author Lalit
			  * @param driver
			  */
			 public void addProductToCartt(WebDriver driver)
			 {
				 List<WebElement> addButtons = driver.findElements(By.xpath("//button[@data-qa='addButton']"));
				 //int size = addButtons.size();
				 if(addButtons.size()>0)
				 {
			        //System.out.println("Size of list = " + size);
			        clickJavaScript(addButtons.get(2), driver);
			        if(isCustomizationWindowOpen(driver));
			        WebElement radioButton = driver.findElement(By.xpath("(//div[@data-qa='radioButton'])[1]"));
	                if (!radioButton.isSelected()) {
	                    radioButton.click();
	                }
	                // Click on the "Add" button in the customization window
	                WebElement addButton = driver.findElement(By.xpath("//button[@data-qa='addItemButton']"));
	                BasePage.clickJavaScript(addButton, driver);
	                log.info("Hurray! Product added with customization sucessfully");
	            }else {
	                
	                log.info("Product added without customization");
	            }
			}
				 
			 
			 /**
			  * Description : Implement the logic to check if the customization window is open
			  * @author Lalit
			  * @param driver
			  */
			 public boolean isCustomizationWindowOpen(WebDriver driver) {
			        // Implement the logic to check if the customization window is open
			        try {
			            WebElement customizationWindow = driver.findElement(By.xpath("//div[@data-qa='customizationModalHeader']"));
			            return customizationWindow.isDisplayed();
			        } catch (Exception e) {
			            return false;
			        }
			    }		 
			 
			
			 

}			
			

