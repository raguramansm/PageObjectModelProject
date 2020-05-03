package com.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ClpPage;
import com.qa.pages.HomePage;
import com.qa.pages.PdpPage;

public class ClpPageTest extends TestBase{
	
	ClpPage clpPage;
	HomePage homePage;
	PdpPage pdpPage;
	
	public ClpPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
	}
	
	@Test
	public void verifySelectProduct()
	{
		homePage.closeContainer();
		homePage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		clpPage = homePage.catagoryNav();
		pdpPage = clpPage.verifySelectProductTest();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
