package com.eatsure.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
static ExtentReports extent;

	public static ExtentReports getReportObject()
	{

		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("EatSure WEB QA Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setEncoding("utf-8");
		reporter.config().setTheme(Theme.STANDARD);
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Vivek Ranjan");
		return extent;

	}

}
