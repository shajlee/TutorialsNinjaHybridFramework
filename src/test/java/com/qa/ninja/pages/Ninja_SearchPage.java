package com.qa.ninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ninja_SearchPage {
	public WebDriver driver;
	
	@FindBy(name = "search")
	private WebElement validProductsearchBox;
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	@FindBy(linkText = "MacBook")
	private WebElement validProduct;
	
	@FindBy(css = "input#button-search+h2+p")
	private WebElement invalidProductMessage;
	
	public  Ninja_SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement validProductsearchBox() {
		return validProductsearchBox;
	}
	public void clickOnSearchButton() {
		searchButton.click();
	}
	public WebElement validProduct() {
		return validProduct;
	}
	public WebElement invalidProductMessage() {
		return invalidProductMessage;
		
		
	}
	
	

}
