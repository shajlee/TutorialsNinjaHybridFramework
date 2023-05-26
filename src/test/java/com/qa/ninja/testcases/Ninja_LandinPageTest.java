package com.qa.ninja.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.ninja.base.Ninja_TestBase;

public class Ninja_LandinPageTest extends Ninja_TestBase {
	public Ninja_LandinPageTest() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
@BeforeTest
public void setUp() {
	driver = initializeBrowser(prop.getProperty("browserName1"));
}
@Test(priority=1)
public void pageTitleandpageUrl() {
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	
	String actualPageTitle = prop.getProperty("actualPageTile");
	String expectedPageTitle = driver.getTitle();
	
	String actualPageUrl = prop.getProperty("actualPageUrl");
	String expectedPageUrl = driver.getCurrentUrl();
	
	if(actualPageTitle.equals(expectedPageTitle) && actualPageUrl.equals(expectedPageUrl)) {
		System.out.println("Webpage is functional and valid");
	}else {
		System.out.println("Webpage is non functional and invalid");
}
}	

	

@AfterTest
public void tearDown() {
	driver.quit();

	
	
	

	
	
	
}
	

}
