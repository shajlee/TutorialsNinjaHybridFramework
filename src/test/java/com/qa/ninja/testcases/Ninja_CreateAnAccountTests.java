package com.qa.ninja.testcases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.ninja.base.Ninja_TestBase;
import com.qa.ninja.pages.Ninja_CreateAnAccountPage;

public class Ninja_CreateAnAccountTests extends Ninja_TestBase {
	public Ninja_CreateAnAccountTests() throws Exception {
		super();

	}

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();

	@BeforeTest
	public void setUp() {
		driver = initializeBrowser(prop.getProperty("browserName1"));
		Ninja_CreateAnAccountPage createAnAccountPage = new Ninja_CreateAnAccountPage(driver);
		createAnAccountPage.clickOnMyAccount();
		createAnAccountPage.clickOnRegister();

		// driver.findElement(By.xpath("//span[text()='My Account']")).click();
		// driver.findElement(By.linkText("Register")).click();
	}

	@Test(priority = 2)
	public void verifyRegistrationWithMandotaryFields() {
		Ninja_CreateAnAccountPage createAnAccountPage = new Ninja_CreateAnAccountPage(driver);
		createAnAccountPage.enterFirstName(dataprop.getProperty("firstName"));
		createAnAccountPage.enterLastName(dataprop.getProperty("lastName"));
		createAnAccountPage.enterEmail(dataprop.getProperty("email"));
		createAnAccountPage.enterTelephone(dataprop.getProperty("telepone"));
		createAnAccountPage.Enterpassword(dataprop.getProperty("password"));
		createAnAccountPage.EnterpasswordConfirmation(dataprop.getProperty("password"));
		createAnAccountPage.clickOnPrivacyPolicyAgreement();
		createAnAccountPage.clickOnContinueButton();
		createAnAccountPage.accountCreationMessage();

		// driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstName"));
		// driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastName"));
		// driver.findElement(By.id("input-email")).sendKeys(dataprop.getProperty("email"));
		// driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telepone"));
		// driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("password"));
		// driver.findElement(By.id("input-confirm")).sendKeys(dataprop.getProperty("password"));
		// driver.findElement(By.name("agree")).click();
		// driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		// String accountCreationMessage =
		// driver.findElement(By.cssSelector("div#content h1")).getText();

		softassert.assertTrue(true, createAnAccountPage.accountCreationMessage());
		softassert.assertAll();
	}

	@Test(priority = 3)
	public void verifyRegistrationWithAllFields() {
		Ninja_CreateAnAccountPage createAnAccountPage = new Ninja_CreateAnAccountPage(driver);
		createAnAccountPage.enterFirstName(dataprop.getProperty("firstName"));
		createAnAccountPage.enterLastName(dataprop.getProperty("lastName"));
		createAnAccountPage.enterEmail(dataprop.getProperty("email"));
		createAnAccountPage.enterTelephone(dataprop.getProperty("telepone"));
		createAnAccountPage.Enterpassword(dataprop.getProperty("password"));
		createAnAccountPage.EnterpasswordConfirmation(dataprop.getProperty("password"));

		// driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstName"));
		// driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastName"));
		// driver.findElement(By.id("input-email")).sendKeys(dataprop.getProperty("email"));
		// driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telepone"));
		// driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("password"));
		// driver.findElement(By.id("input-confirm")).sendKeys(dataprop.getProperty("password"));

		List<WebElement> newsLetterRadioButton = createAnAccountPage.radioButton();
		for (int i = 0; i < newsLetterRadioButton.size(); i++) {
			if (newsLetterRadioButton.get(i).getAttribute("value").equalsIgnoreCase("1")) {
				newsLetterRadioButton.get(i).click();
				break;
			}
			createAnAccountPage.clickOnPrivacyPolicyAgreement();
			createAnAccountPage.clickOnContinueButton();

			// driver.findElement(By.name("agree")).click();
			// driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

			createAnAccountPage.accountCreationMessage();

			// String accountCreationMessage =
			// driver.findElement(By.cssSelector("div#content h1")).getText();

			softassert.assertTrue(true, createAnAccountPage.accountCreationMessage());
			softassert.assertAll();

		}
	}

	@Test(priority = 4)
	public void registrationWithExistingEmailId() {
		Ninja_CreateAnAccountPage createAnAccountPage = new Ninja_CreateAnAccountPage(driver);
		createAnAccountPage.enterFirstName(dataprop.getProperty("firstName"));
		createAnAccountPage.enterLastName(dataprop.getProperty("lastName"));
		createAnAccountPage.enterEmail(dataprop.getProperty("email"));
		createAnAccountPage.enterTelephone(dataprop.getProperty("telepone"));
		createAnAccountPage.Enterpassword(dataprop.getProperty("password"));
		createAnAccountPage.EnterpasswordConfirmation(dataprop.getProperty("password"));

		// driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstName"));
		// driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastName"));
		// driver.findElement(By.id("input-email")).sendKeys(dataprop.getProperty("email"));
		// driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telepone"));
		// driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("password"));
		// driver.findElement(By.id("input-confirm")).sendKeys(dataprop.getProperty("password"));

		List<WebElement> newsLetterRadioButton = createAnAccountPage.radioButton();
		for (int i = 0; i < newsLetterRadioButton.size(); i++) {
			if (newsLetterRadioButton.get(i).getAttribute("value").equalsIgnoreCase("1")) {
				newsLetterRadioButton.get(i).click();
				break;
			}

			createAnAccountPage.clickOnPrivacyPolicyAgreement();
			createAnAccountPage.clickOnContinueButton();

			// driver.findElement(By.name("agree")).click();
			// driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

			createAnAccountPage.actualAlertMessage();

			// String actualAlertMessage =
			// driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();

			softassert.assertTrue(true, createAnAccountPage.actualAlertMessage());
			softassert.assertAll();
		}
	}

	@Test(priority = 1)
	public void registrationWithNoDetails() {
		Ninja_CreateAnAccountPage createAnAccountPage = new Ninja_CreateAnAccountPage(driver);
		createAnAccountPage.clickOnContinueButton();
		// driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

		createAnAccountPage.privacyPolicyWarningMessage();

		// String privacyPolicyWarningMessage =
		// driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
		softassert.assertTrue(true, createAnAccountPage.privacyPolicyWarningMessage());
		softassert.assertAll();

		createAnAccountPage.firstNameWarningMessage();
		// WebElement firstNameWarningMessage =
		// driver.findElement(By.cssSelector("input#input-firstname+div"));
		softassert.assertTrue(createAnAccountPage.firstNameWarningMessage());
		softassert.assertAll();

		createAnAccountPage.lastNameWarningMessage();
		// WebElement lastNameWarningMessage =
		// driver.findElement(By.cssSelector("input#input-lastname+div"));
		softassert.assertTrue(createAnAccountPage.lastNameWarningMessage(), "lastNameWarningMessage is not displayed");
		softassert.assertAll();

		createAnAccountPage.emailNameWarningMessage();
		// WebElement emailWarningMessage =
		// driver.findElement(By.cssSelector("input#input-email+div"));
		softassert.assertTrue(createAnAccountPage.emailNameWarningMessage(), "emailWarningMessage is not displayed");
		softassert.assertAll();

		createAnAccountPage.telephoneWarningMessage();
		// WebElement telephoneWarningMessage =
		// driver.findElement(By.cssSelector("input#input-telephone+div"));
		softassert.assertTrue(createAnAccountPage.telephoneWarningMessage(),
				"telephoneWarningMessage is not displayed");
		softassert.assertAll();

		createAnAccountPage.passwordWarningMessage();
		// WebElement passwordWarningMessage =
		// driver.findElement(By.cssSelector("input#input-password+div"));
		softassert.assertTrue(createAnAccountPage.passwordWarningMessage(), "passwordWarningMessage is not displayed");
		softassert.assertAll();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}
