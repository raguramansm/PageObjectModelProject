package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class ClpPage extends TestBase{
	
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;


	// Initialize Page Factory 
	
	public ClpPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Page Factory or Object Repository
	
	
	/*
	 * @FindBy(xpath="//div[@style='left: 0px; top: 0px; position: absolute;']")
	 * public static WebElement selectProduct;
	 */
	 
	
	// Actions
	
	public PdpPage verifySelectProductTest()
	{
		js.executeScript("window.scrollBy(0,500)");
		
		wait = new WebDriverWait(driver, TestUtil.WEB_DRIVER_WAIT);
		WebElement selectProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='mar-product-item-image-holder'])[1]")));
		selectProduct.click();
		return new PdpPage();
	}
	
	
}
