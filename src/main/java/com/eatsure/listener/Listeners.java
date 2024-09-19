package com.eatsure.listener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.eatsure.reports.ExtentManager;
import com.eatsure.reports.ExtentReport;
//import com.eatsure.resources.Base_Rahul;
import com.eatsure.reports.ExtentReporterNG;
import com.eatsure.reports.LogStatus;
import com.eatsure.utils.TestUtils;

//public class Listeners extends TestUtils implements ITestListener{
	public class Listeners implements ITestListener{
	//public class Listeners extends Base_Rahul implements ITestListener{
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	//Utkal
	private static String TestCaseName;

	public static String getTestcaseName() {
		return TestCaseName;
	}

	public static void setTestcaseName(String testcaseName) {
		TestCaseName = testcaseName;
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		//Utkal
		TestCaseName = result.getMethod().getDescription();
		setTestcaseName(TestCaseName);
		ExtentManager.setExtentTest(ExtentReport.extent.createTest(TestCaseName));
		LogStatus.pass(TestCaseName + " is started successfully");


	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		extentTest.get().log(Status.PASS, "Test Passed");
		
		//Utkal
		LogStatus.pass(result.getMethod().getDescription() + " test case is passed...");

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		extentTest.get().fail(result.getThrowable());
		WebDriver driver =null;
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		{

		}
		try {
			extentTest.get().addScreenCaptureFromPath(TestUtils.getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
			//getScreenShotPath(testMethodName,driver);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Utkal
		LogStatus.fail(result.getMethod().getDescription() + " is failed");
		LogStatus.fail(result.getThrowable().toString());
		try {
			LogStatus.fail("Failed", TestUtils.getScreenShotPath("",driver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

		extent.flush();
	}


}
