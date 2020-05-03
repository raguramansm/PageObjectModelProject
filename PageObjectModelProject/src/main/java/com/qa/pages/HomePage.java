package com.qa.pages;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends TestBase{
	
	public static WebDriverWait wait;
	public static HomePage homePage;
	public static ClpPage clpPage;

	// Initialize Page factory
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Page Factory or Object repository
	@FindBy(xpath="//div[@id='onetrust-close-btn-container']/button")
	WebElement containerButton;
	
	@FindBy(xpath="//a[text()='Sign In']")
	WebElement signInHome;
	
	@FindBy(id="marSigninEmail")
	WebElement username;
	
	@FindBy(id="marSigninPassword")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Sign In']")
	WebElement signInButton;
	
	@FindBy(xpath="//a[@title='clothes']")
	WebElement clothes;	
	
	@FindBy(className = "asc-global-indicator show")
	WebElement visible;
	

	
	// Actions
	public void closeContainer()
	{
		containerButton.click();
	}
	
	public void signIn(String un, String pwd)
	{
		signInHome.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		signInButton.click();
	}
	
	public ClpPage catagoryNav()
	{
		wait = new WebDriverWait(driver, TestUtil.WEB_DRIVER_WAIT);
		boolean invisble = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("asc-global-indicator show")));
		if (invisble) {
			clothes.click();
		}
		return new ClpPage();
	}
	

}
