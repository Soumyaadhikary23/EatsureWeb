package com.eatsure.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class CartCheckoutPage {

	public CartCheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	 }

	SoftAssert asrt = new SoftAssert();

	// Locator of phone number TextBox
	@FindBy(xpath = "//input[@id='phone_number']")
	private WebElement phoenNumberTextBox;

	//Locator of "Login with OTP" button
	@FindBy(xpath = "//button[text()='Login with OTP']")
	private WebElement loginwithOTPButton;



}
