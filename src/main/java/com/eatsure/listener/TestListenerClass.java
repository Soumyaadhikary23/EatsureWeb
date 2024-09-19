package com.eatsure.listener;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.eatsure.reports.ExtentManager;
import com.eatsure.reports.ExtentReport;
import com.eatsure.reports.LogStatus;
import com.eatsure.utils.TestUtils;

/*
 * Listener class which is implementing ITestListener and hence we can use this to dynamically create reports, write logs.
 */
public class TestListenerClass implements ITestListener {

	private static String TestCaseName;

	public static String getTestcaseName() {
		return TestCaseName;
	}

	public static void setTestcaseName(String testcaseName) {
		TestCaseName = testcaseName;
	}

	public void onTestStart(ITestResult result) {
		TestCaseName = result.getMethod().getDescription();
		setTestcaseName(TestCaseName);
		ExtentManager.setExtentTest(ExtentReport.extent.createTest(TestCaseName));
		LogStatus.pass(TestCaseName + " is started successfully");

	}

	public void onTestSuccess(ITestResult result) {
		/*
		 * if((ReadPropertyFile.get("RunMode").equalsIgnoreCase("Remote"))&&
		 * ReadPropertyFile.get("RemoteMode").equalsIgnoreCase("Zalenium")) { Cookie
		 * cookie = new Cookie("zaleniumTestPassed", "true");
		 * DriverManager.getDriver().manage().addCookie(cookie); }
		 */
		LogStatus.pass(result.getMethod().getDescription() + " test case is passed...");
		// ExtentReport.report.endTest(ExtentManager.getExtTest());
	}

	public void onTestFailure(ITestResult result,WebDriver driver) {
		/*
		 * if((ReadPropertyFile.get("RunMode").equalsIgnoreCase("Remote"))&&
		 * ReadPropertyFile.get("RemoteMode").equalsIgnoreCase("Zalenium")) { Cookie
		 * cookie = new Cookie("zaleniumTestPassed", "false");
		 * DriverManager.getDriver().manage().addCookie(cookie); }
		 */
		LogStatus.fail(result.getMethod().getDescription() + " is failed");
		LogStatus.fail(result.getThrowable().toString());
		try {
			LogStatus.fail("Failed", TestUtils.getScreenShotPath("",driver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ExtentReport.report.endTest(ExtentManager.getExtTest());

	}

	public void onTestSkipped(ITestResult result) {

		LogStatus.skip(result.getMethod().getDescription() + " is skipped");
		// ExtentReport.report.endTest(ExtentManager.getExtTest());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// ExtentReport.report.endTest(ExtentManager.getExtTest());
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		//ExtentReport.report.endTest(ExtentManager.getExtTest());

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

	}

}

