package com.qa.ninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ninja_LandingPage {
	public WebDriver driver;
	
	@FindBy(linkText = "QaFoxLink")
	private WebElement qaFoxLink;
	
	public  Ninja_LandingPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean qaFoxLinkIsDisplayedAndEnabled() {
		boolean displayStatus = qaFoxLink.isDisplayed() & qaFoxLink.isEnabled();
		return displayStatus;
	}

}
