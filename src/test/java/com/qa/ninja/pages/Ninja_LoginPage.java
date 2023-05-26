package com.qa.ninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ninja_LoginPage {
	public WebDriver driver;
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountLink;
	
	@FindBy(linkText = "Login")
	private WebElement loginLink;
	
	@FindBy(name = "email")
	private WebElement usernameTextBox;
	
	@FindBy(name = "password")
	private WebElement passwordTextBox;
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement loginButton;
	
	@FindBy(linkText = "Qafox.com")
	private WebElement qaFoxLink;
	
	@FindBy(css = "div.alert.alert-danger.alert-dismissible")
	private WebElement invalidCredentialsWarning;
	
	@FindBy(css = "div.alert.alert-danger.alert-dismissible")
	private WebElement invalidUsernameWarning;
	
	@FindBy(css = "div.alert.alert-danger.alert-dismissible")
	private WebElement invalidPasswordWarning;
	
	@FindBy(css = "div.alert.alert-danger.alert-dismissible")
	private WebElement noCredentialsWarning;
	
	public Ninja_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnMyAccountLink() {
		myAccountLink.click();
	}
	public void clickOnLoginLink() {
		loginLink.click();
	}
	public void enterUserName(String userNameText) {
		usernameTextBox.sendKeys(userNameText);
	}
	public void enterPassword(CharSequence passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}
	public boolean qaFoxLinkIsDisplayedAndEnabled() {
		boolean displayStatus = qaFoxLink.isDisplayed() && qaFoxLink.isEnabled();
		return displayStatus;
	}
	public boolean invalidCredentialsWarning() {
		boolean displayStatus = invalidCredentialsWarning.isDisplayed();
		return displayStatus;
	}
	public boolean invalidUsernameWarning() {
		boolean displayStatus = invalidUsernameWarning.isDisplayed();
		return displayStatus;
	}
	public boolean invalidPasswordWarning() {
		boolean displayStatus = invalidPasswordWarning.isDisplayed();
		return displayStatus;
	}
	public boolean noCredentialsWarning() {
		boolean displayStatus = noCredentialsWarning.isDisplayed();
		return displayStatus;
				
	}
		
	
	
	

}

