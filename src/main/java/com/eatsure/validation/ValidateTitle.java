package com.eatsure.validation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ValidateTitle {
	public static void verifyTitle(WebDriver driver,String TitleName)
	{

	String title=driver.getTitle();

	Assert.assertEquals(title, TitleName);
//	Assert.assertTrue(title.contains(TitleName));
	System.out.println("Page title verified");
	}

}
