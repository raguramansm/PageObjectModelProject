package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class PdpPage extends TestBase{
	
	public PdpPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@class='mar-product-sizes nav mar-option-container jst-option-container no-custom-select']")
	public static WebElement selectSize;
	
	@FindBy(id="addToBagButtonWrapper")
	public static WebElement addToBag;
	
	public void selectProductSize()
	{
		//driver.get(driver.getCurrentUrl());
		driver.navigate().refresh();
		selectSize.click();
		Select size = new Select(selectSize);
		size.selectByValue("10");
	}
	
	public void clickAddToBag()
	{
		addToBag.click();
	}
}
