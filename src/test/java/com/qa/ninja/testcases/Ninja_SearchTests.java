package com.qa.ninja.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.ninja.base.Ninja_TestBase;
import com.qa.ninja.pages.Ninja_SearchPage;

public class Ninja_SearchTests extends  Ninja_TestBase {
	public Ninja_SearchTests() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeTest
	public void setUp() {
		driver = initializeBrowser(prop.getProperty("browserName1"));
		
	}
	@Test(priority =1)
	public void searchWithValidProduct() {
		Ninja_SearchPage searchpage = new Ninja_SearchPage(driver);
		searchpage.validProductsearchBox().sendKeys(dataprop.getProperty("validProduct"));
		searchpage.clickOnSearchButton();
		
		//driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("validProduct"));
		//driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		
		WebElement validProduct = searchpage.validProduct();
		softassert.assertTrue(validProduct.isDisplayed(), "validProduct is not displayed");
		softassert.assertAll();
	}
	@Test(priority=2)
	public void searchWithInvalidProduct() {
		Ninja_SearchPage searchpage = new Ninja_SearchPage(driver);
		searchpage.validProductsearchBox().sendKeys(dataprop.getProperty("invalidProduct"));
		searchpage.clickOnSearchButton();
		
		//driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("invalidProduct"));
		//driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		
		WebElement invalidProductMessage = searchpage.invalidProductMessage();
		softassert.assertTrue(invalidProductMessage.isDisplayed());
		softassert.assertAll();
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
		
		
	}

}
