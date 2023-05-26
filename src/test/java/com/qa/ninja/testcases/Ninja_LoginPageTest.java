package com.qa.ninja.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.ninja.base.Ninja_TestBase;
import com.qa.ninja.pages.Ninja_LoginPage;
import com.qa.ninja.testdata.Ninja_TestData_Supply;
import com.qa.ninja.utilities.Ninja_Utilities;

public class Ninja_LoginPageTest extends Ninja_TestBase {
	public Ninja_LoginPageTest() throws Exception {
		super();

	}

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();

	@BeforeTest
	public void setUp() {
		driver = initializeBrowser(prop.getProperty("browserName1"));
		Ninja_LoginPage loginPage = new Ninja_LoginPage(driver);
		loginPage.clickOnMyAccountLink();
		loginPage.clickOnLoginLink();
		// driver.findElement(By.xpath("//span[text()='My Account']")).click();
		// driver.findElement(By.linkText("Login")).click();
	}

	@Test(priority = 5, dataProvider = "ninjaExcellDataWithDataProvider", dataProviderClass = Ninja_TestData_Supply.class)
	public void loginWithValidCredentials(String email, String password) {
		Ninja_LoginPage loginPage = new Ninja_LoginPage(driver);
		loginPage.enterUserName(email);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
		loginPage.qaFoxLinkIsDisplayedAndEnabled();

		// driver.findElement(By.name("email")).sendKeys(email);
		// driver.findElement(By.name("password")).sendKeys(password);
		// driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		// WebElement qaFoxLink = driver.findElement(By.linkText("Qafox.com"));

		softassert.assertTrue(loginPage.qaFoxLinkIsDisplayedAndEnabled(), "qaFoxLink is not displayed and enabled");
		softassert.assertAll();
	}

	@Test(priority = 1)
	public void loginWithInvalidCredentials() {
		Ninja_LoginPage loginPage = new Ninja_LoginPage(driver);
		loginPage.enterUserName(Ninja_Utilities.generateEmailDateTimeStamp());
		loginPage.enterPassword(Ninja_Utilities.generatePasswordDateTimeStamp());
		loginPage.clickOnLoginButton();
		loginPage.invalidCredentialsWarning();

		// driver.findElement(By.id("input-email")).sendKeys(Ninja_Utilities.generateEmailDateTimeStamp());
		// driver.findElement(By.id("input-password")).sendKeys(Ninja_Utilities.generatePasswordDateTimeStamp());
		// driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		// WebElement invalidCredentialsWarning =
		// driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible"));

		softassert.assertTrue(loginPage.invalidCredentialsWarning(), "invalidCredentialsWarning is not displayed");
		softassert.assertAll();

	}

	@Test(priority = 2)
	public void loginWithValidUsernameInvalidPassword() {
		Ninja_LoginPage loginPage = new Ninja_LoginPage(driver);
		loginPage.enterUserName(dataprop.getProperty("validUserName"));
		loginPage.enterPassword(Ninja_Utilities.generatePasswordDateTimeStamp());
		loginPage.clickOnLoginButton();
		loginPage.invalidPasswordWarning();

		// driver.findElement(By.id("input-email")).sendKeys(dataprop.getProperty("validUserName"));
		// driver.findElement(By.id("input-password")).sendKeys(Ninja_Utilities.generatePasswordDateTimeStamp());
		// driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		// WebElement invalidUsernameWarning =
		// driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible"));

		softassert.assertTrue(loginPage.invalidPasswordWarning(), "invalidUsernameWarning is not displayed");
		softassert.assertAll();
	}

	@Test(priority = 3)
	public void loginWithInvalidUsernameValidPassword() {
		Ninja_LoginPage loginPage = new Ninja_LoginPage(driver);
		loginPage.enterUserName(Ninja_Utilities.generateEmailDateTimeStamp());
		loginPage.enterPassword(dataprop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		loginPage.invalidUsernameWarning();

		// driver.findElement(By.id("input-email")).sendKeys(Ninja_Utilities.generateEmailDateTimeStamp());
		// driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("validPassword"));
		// driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		// WebElement invalidPasswordWarning =
		// driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible"));

		softassert.assertTrue(loginPage.invalidUsernameWarning(), "invalidPasswordWarning is not displayed");
		softassert.assertAll();
	}

	@Test(priority = 4)
	public void loginWithNoCredentials() {
		Ninja_LoginPage loginPage = new Ninja_LoginPage(driver);
		loginPage.clickOnLoginButton();
		loginPage.noCredentialsWarning();

		// driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		// WebElement noCredentialsWarning =
		// driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible"));

		softassert.assertTrue(loginPage.noCredentialsWarning(), "noCredentialsWarning is not displayed");
		softassert.assertAll();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
