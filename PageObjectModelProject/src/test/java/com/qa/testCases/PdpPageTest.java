package com.qa.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ClpPage;
import com.qa.pages.HomePage;
import com.qa.pages.PdpPage;

public class PdpPageTest extends TestBase {

	ClpPage clpPage;
	HomePage homePage;
	PdpPage pdpPage;

	public PdpPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
	}

	@Test(priority = 1)
	public void verifySelectSizeTest() {
		homePage.closeContainer();
		homePage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		clpPage = homePage.catagoryNav();
		pdpPage = clpPage.verifySelectProductTest();
		pdpPage.selectProductSize();
	}

	@Test(priority = 2)
	public void verifyAddToBagTest() {
		homePage.closeContainer();
		homePage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		clpPage = homePage.catagoryNav();
		pdpPage = clpPage.verifySelectProductTest();
		pdpPage.selectProductSize();
		pdpPage.clickAddToBag();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
