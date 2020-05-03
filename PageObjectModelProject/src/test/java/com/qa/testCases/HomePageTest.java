package com.qa.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.base.TestBase;
import com.qa.pages.ClpPage;
import com.qa.pages.HomePage;

public class HomePageTest extends TestBase {

	HomePage homePage;
	ClpPage clpPage;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	public static Logger log = Logger.getLogger(HomePageTest.class);

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		// specify location of the report
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReport.html");

		htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		htmlReporter.config().setReportName("Functional Testing"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// Passing General information
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "smr");
		DOMConfigurator.configure("./src/main/resources/log4j.xml");
		// PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		log.info("Launching the browser");
		// test.log(Status.PASS, "Browser is launched");
		initialization();
		homePage = new HomePage();
	}

	@Test(priority = 1)
	public void verifyCloseContainerTest() {
		homePage.closeContainer();
		// log.info("Contained button is closed");
		test.log(Status.PASS, "Contained button is closed");
	}

	@Test(priority = 2)
	public void verifySignInTest() {
		homePage.closeContainer();
		// test.log(Status.PASS, "Contained button is closed");
		homePage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		// test.log(Status.PASS, "Sign in success");
	}

	@Test(priority = 3)
	public void verifyCatagoryClickTest() {
		homePage.closeContainer();
		// test.log(Status.INFO, "Contained button is closed");
		homePage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		// test.log(Status.INFO, "Sign in success");
		clpPage = homePage.catagoryNav();
		// test.log(Status.PASS, "Clicked on the catogory link");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		extent.flush();
		// test.log(Status.INFO, "Test completed, Browser is closed");
	}
}
