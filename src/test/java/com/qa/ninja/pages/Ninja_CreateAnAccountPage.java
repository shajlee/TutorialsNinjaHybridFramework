package com.qa.ninja.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ninja_CreateAnAccountPage {
	public WebDriver driver;

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountLink;

	@FindBy(linkText = "Register")
	private WebElement RegistrationLink;

	@FindBy(id = "input-firstname")
	private WebElement firstNameTextBox;

	@FindBy(id = "input-lastname")
	private WebElement lastNameTextBox;

	@FindBy(id = "input-email")
	private WebElement emailTextBox;

	@FindBy(id = "input-telephone")
	private WebElement telephoneTextBox;

	@FindBy(id = "input-password")
	private WebElement passwordTextBox;

	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmationTextBox;

	@FindBy(name = "agree")
	private WebElement privacyPolicyAgreement;

	@FindBy(css = "input.btn.btn-primary")
	private WebElement continueButton;

	@FindBy(css = "div#content h1")
	private WebElement accountCreationMessage;

	@FindBy(name = "newsletter")
	private List<WebElement> radioButton;

	@FindBy(css = "div.alert.alert-danger.alert-dismissible")
	private WebElement actualAlertMessage;

	@FindBy(css = "div.alert.alert-danger.alert-dismissible")
	private WebElement privacyPolicyWarningMessage;

	@FindBy(css = "input#input-firstname+div")
	private WebElement firstNameWarningMessage;

	@FindBy(css = "input#input-lastname+div")
	private WebElement lastNameWarningMessage;

	@FindBy(css = "input#input-email+div")
	private WebElement emailWarningMessage;

	@FindBy(css = "input#input-telephone+div")
	private WebElement telephoneWarningMessage;

	@FindBy(css = "input#input-password+div")
	private WebElement passwordWarningMessage;

	public Ninja_CreateAnAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMyAccount() {
		myAccountLink.click();
	}

	public void clickOnRegister() {
		RegistrationLink.click();
	}

	public void enterFirstName(String firstNameText) {
		firstNameTextBox.sendKeys(firstNameText);
	}

	public void enterLastName(String lastNameText) {
		lastNameTextBox.sendKeys(lastNameText);
	}

	public void enterEmail(String emailText) {
		emailTextBox.sendKeys(emailText);
	}

	public void enterTelephone(CharSequence telephoneText) {
		telephoneTextBox.sendKeys(telephoneText);
	}

	public void Enterpassword(CharSequence passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}

	public void EnterpasswordConfirmation(CharSequence passwordText) {
		passwordConfirmationTextBox.sendKeys(passwordText);
	}

	public void clickOnPrivacyPolicyAgreement() {
		privacyPolicyAgreement.click();
	}

	public void clickOnContinueButton() {
		continueButton.click();
	}

	public String accountCreationMessage() {
		String accountMessage = accountCreationMessage.getText();
		return accountMessage;
	}

	public List<WebElement> radioButton() {
		return radioButton;
	}

	public String actualAlertMessage() {
		String alertMessage = actualAlertMessage.getText();
		return alertMessage;
	}

	public String privacyPolicyWarningMessage() {
		String privacyWarmingMessage = privacyPolicyWarningMessage.getText();
		return privacyWarmingMessage;
	}

	public boolean firstNameWarningMessage() {
		boolean displayStatus = firstNameWarningMessage.isDisplayed();
		return displayStatus;
	}

	public boolean lastNameWarningMessage() {
		boolean displayStatus = lastNameWarningMessage.isDisplayed();
		return displayStatus;
	}

	public boolean emailNameWarningMessage() {
		boolean displayStatus = emailWarningMessage.isDisplayed();
		return displayStatus;
	}

	public boolean telephoneWarningMessage() {
		boolean displayStatus = telephoneWarningMessage.isDisplayed();
		return displayStatus;
	}

	public boolean passwordWarningMessage() {
		boolean displayStatus = passwordWarningMessage.isDisplayed();
		return displayStatus;

	}

}
