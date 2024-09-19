package com.eatsure.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.eatsure.utils.ReadPropertyFile;
import com.eatsure.utils.TestUtils;

public class LogStatus {

	private LogStatus() {
		//private to avoid initialization
	}
	public static void pass(String message)
	{
		ExtentManager.getExtTest().log(Status.PASS, message);
		
		//ExtentManager.getExtTest().log
	}

	public static void fail(String message)
	{
		ExtentManager.getExtTest().log(Status.FAIL, message);
	}

	public static void fail(Exception message)
	{
		ExtentManager.getExtTest().log(com.aventstack.extentreports.Status.FAIL, message);
	}

	public static void fail(AssertionError a)
	{
		ExtentManager.getExtTest().log(com.aventstack.extentreports.Status.FAIL, a);
	}

	public static void info(String message)
	{
		ExtentManager.getExtTest().log(com.aventstack.extentreports.Status.INFO, message);
	}

//	public static void error(String message)
//	{
//		ExtentManager_Utkal.getExtTest().log(com.aventstack.extentreports.Status.ERROR, message);
//	}

//	public static void fatal(String message)
//	{
//		ExtentManager_Utkal.getExtTest().log(com.aventstack.extentreports.Status.FATAL, message);
//	}

	public static void skip(String message)
	{
		ExtentManager.getExtTest().log(com.aventstack.extentreports.Status.SKIP, message);
	}

//	public static void unknown(String message)
//	{
//		ExtentManager_Utkal.getExtTest().log(com.aventstack.extentreports.Status.UNKNOWN, message);
//	}

	public static void warning(String message)
	{
		ExtentManager.getExtTest().log(com.aventstack.extentreports.Status.WARNING, message);
	}
	public static void pass(String string, String addScreenCapture) {

		if(ReadPropertyFile.get("PassedStepsScreenshots").equalsIgnoreCase("yes")) {
//			ExtentManager_Utkal.getExtTest().log(com.aventstack.extentreports.Status.PASS, string,ExtentManager_Utkal.getExtTest().addBase64ScreenShot("data:image/png;base64,"+TestUtils.getBase64Image(addScreenCapture)));
			ExtentManager.getExtTest()
			.log(Status.PASS, string,
					MediaEntityBuilder
							.createScreenCaptureFromBase64String(
									"data:image/png;base64," + TestUtils.getBase64Image(addScreenCapture))
							.build());
		}
	}

	public static void fail(String string, String addScreenCapture)
	{

		if(ReadPropertyFile.get("FailedStepsScreenshots").equalsIgnoreCase("yes")) {
//			ExtentManager_Utkal.getExtTest().log(com.aventstack.extentreports.Status.FAIL, string,ExtentManager_Utkal.getExtTest().addBase64ScreenShot("data:image/png;base64,"+TestUtils.getBase64Image(addScreenCapture)));
			ExtentManager.getExtTest()
			.log(Status.FAIL, string,
					MediaEntityBuilder
							.createScreenCaptureFromBase64String(
									"data:image/png;base64," + TestUtils.getBase64Image(addScreenCapture))
							.build());
		}

	}

	public static void skip(String string, String addScreenCapture)
	{
		if(ReadPropertyFile.get("SkippedStepsScreenshots").equalsIgnoreCase("yes")) {
//			ExtentManager_Utkal.getExtTest().log(com.aventstack.extentreports.Status.SKIP, string,ExtentManager_Utkal.getExtTest().addBase64ScreenShot("data:image/png;base64,"+TestUtils.getBase64Image(addScreenCapture)));
			ExtentManager.getExtTest()
			.log(Status.SKIP, string,
					MediaEntityBuilder
							.createScreenCaptureFromBase64String(
									"data:image/png;base64," + TestUtils.getBase64Image(addScreenCapture))
							.build());
		}

	}
}
