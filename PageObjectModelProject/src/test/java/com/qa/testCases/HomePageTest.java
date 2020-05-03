package com.qa.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ClpPage;
import com.qa.pages.HomePage;

public class HomePageTest extends TestBase {

	HomePage homePage;
	ClpPage clpPage;
	
	public static Logger log = Logger.getLogger(HomePageTest.class);

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		// DOMConfigurator.configure("C:\\Users\\smr\\eclipse-workspace\\"
		//		+ "PageObjectModelProject\\src\\main\\resources\\log4j.xml");
		PropertyConfigurator.configure("C:\\Users\\smr\\eclipse-workspace\\"
				+ "PageObjectModelProject\\src\\main\\resources\\log4j.properties");
		log.info("Launching the browser");
		initialization();
		homePage = new HomePage();
	}

	@Test(priority = 1)
	public void verifyCloseContainerTest() {
		homePage.closeContainer();
		log.info("Contained button is closed");
	}

	@Test(priority = 2)
	public void verifySignInTest() {
		homePage.closeContainer();
		homePage.signIn(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 3)
	public void verifyCatagoryClickTest() {
		homePage.closeContainer();
		homePage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		clpPage = homePage.catagoryNav();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
