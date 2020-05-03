package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.TestUtil;
import com.qa.util.WebEventListener;

public class TestBase {
	
	// Global variable, so that I can use it across this class and child classes
	public static Properties prop;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase() {
			
			try {
				// Access the config file from the given location
				FileInputStream fis = new FileInputStream("C:\\Users\\smr\\eclipse-workspace\\"
						+ "PageObjectModelProject\\src\\test\\resources\\config\\config.properties");
				prop = new Properties();
				prop.load(fis); // Load the property file
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			} 
		} 
	
	public void initialization()
	{
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//wait = new WebDriverWait(driver, TestUtil.WEB_DRIVER_WAIT);

		
		driver.get(prop.getProperty("url"));
		
	}
	
		

}
