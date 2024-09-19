package com.eatsure.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class SiginPage {

	public SiginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	SoftAssert asrt = new SoftAssert();

	// Locator of Signin Button
	@FindBy(xpath = "//span[@class='userSP']")
	private WebElement signinButton;

	// Locator of phone number TextBox
	@FindBy(xpath = "//input[@id='phone_number']")
	private WebElement phoenNumberTextBox;

	// Locator of "Login with OTP" button
	@FindBy(xpath = "//button[text()='Login with OTP']")
	private WebElement loginwithOTPButton;

	// Locator of User Name TextBox
	@FindBy(xpath = "//input[@placeholder='Full Name']")
	private WebElement userNameTextBox;

	// Locator of Email Address TextBox
	@FindBy(xpath = "//input[@placeholder='Email Address']")
	private WebElement emailAddressTextBox;

	// Locator of SignMeUp button
	@FindBy(xpath = "//button[text()='Sign Me Up']")
	private WebElement signmeupButton;

	// Locator of Edit mobile number button
	@FindBy(xpath = "//span[@id='edit_mobile_number']")
	private WebElement editmobileNumberButton;

	// Locator of Resend OTP button
	@FindBy(xpath = "//span[@id='resend_otp']")
	private WebElement resendOTPButton;

	// Locator of OTP input
	@FindBy(xpath = "//span[@id='resend_otp']")
	private WebElement otpInput;

	// Action
	/**
	 * Description: Click on signin button
	 * @author vivek ranjan
	 */

	public boolean getSigin() {
	return signinButton.isDisplayed();
		
	}
	public void clickSigin() {
		signinButton.click();
	}


	/**
	 * Description: Click on LoginWithOTP
	 * @author vivek ranjan
	 */

	public void clickLoginwithOTP() {
		loginwithOTPButton.click();
	}


	/**
	 * Description: Click on signmeup Button
	 * @author vivek ranjan
	 */

	public void clickSignmeUp() {
		signmeupButton.click();
	}

	/**
	 * Description: Enter mobileNumber
	 *@author vivek ranjan
	 * @param MobileNumber
	 */

	public void enterMobileNumber(String MobileNumber) {
		phoenNumberTextBox.sendKeys(MobileNumber);
	}

	/**
	 * Description: Enter userName
	 * @author vivek ranjan
	 * @param UserName
	 */

	public void enterUserName(String UserName) {
		userNameTextBox.sendKeys(UserName);
	}

	/**
	 * Description: Enter email Address
	 *@author vivek ranjan
	 * @param EmailAddress
	 */

	public void enterEmailAddress(String EmailAddress) {
		emailAddressTextBox.sendKeys(EmailAddress);
	}





}
