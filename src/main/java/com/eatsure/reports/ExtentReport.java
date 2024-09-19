package com.eatsure.reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.eatsure.utils.ReadPropertyFile;


public class ExtentReport {

	private static final Logger log = LogManager.getLogger(ExtentReport.class);

	public static ExtentReports extent = null;
//	public static ExtentTest logger=null;
	public static String extentreportpath = "";
	public static ExtentSparkReporter sparkReporter;

	// To avoid external initialization
	private ExtentReport() {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy_ hh_mm_ss");
		Date date = new Date();
		String currentDate = formatter.format(date);
		log.debug("currentDate is " + currentDate);
		if (ReadPropertyFile.get("OverrideResults").equalsIgnoreCase("yes")) {
			if (ReadPropertyFile.get("ResultPath").equals("")) {
				extentreportpath = System.getProperty("user.dir")+ "/ExtentReports/Test Report.html";
			} else {
				extentreportpath = ReadPropertyFile.get("ResultPath") + "/ExtentReports/Test Report.html";
			}
		} else {
			if (ReadPropertyFile.get("ResultPath").equals("")) {
				extentreportpath = System.getProperty("user.dir") + "/ExtentReports/Test Report_" + currentDate + ".html";
			} else {
				extentreportpath = ReadPropertyFile.get("ResultPath") + "/ExtentReports/Test Report_" + currentDate
						+ ".html";
			}

		}
		log.debug("extent report path is " + extentreportpath);
		// Create html report and object of extent report
		if (Objects.nonNull(extentreportpath)) {
			sparkReporter = new ExtentSparkReporter(extentreportpath); // For html file generation
			extent = new ExtentReports(); //
			try {
				log.info(System.getProperty("user.dir") + "/src/test/resources/extentreport.xml");
				// final File conf = new File(System.getProperty("user.dir") + "/src/test/resources/extentreport.xml");
				// sparkReporter.loadXMLConfig(conf);
				log.info("extentreport.xml load complete");
				extent.attachReporter(sparkReporter);
				log.info("Extent report initialization complete");
			} catch (Exception e) {
				log.error("Failed to read extentreport.xml");
				e.printStackTrace();
			}
		} else {
			log.error("Extent Report file not created");
		}

		// OLD extent report 3 setting
		// report = new ExtentReports(extentreportpath);
		// extent.loadConfig(new File(Constants.EXTENTCONFIGPATH));

		// will only contain failures
		/*
		 * ExtentSparkReporter sparkFail = new
		 * ExtentSparkReporter("target/SparkFail.html").filter().statusFilter().as(new
		 * Status[] { Status.FAIL }).apply();
		 */
		// spark.config().setTheme(Theme.DARK);
		// spark.config().setDocumentTitle("InternetHerokuApp");

	}
	public static void createTest(String testName) {
		ExtentManager.setExtentTest(extent.createTest(testName));
	}
	
	public static void initialize() {
		ExtentReport report = new ExtentReport();
		log.info("Initialization of extent report complete "+ report);
		
	}

}
