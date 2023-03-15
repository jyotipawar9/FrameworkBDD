package com.SwagLab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class SwagLabLoginPage extends SeleniumUtility {
	WebDriver driver;

	public SwagLabLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	private WebElement userNameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "login-button")
	private WebElement loginBtn;

	public void enterUserNameAndPassword(String username, String password) {
		typeInput(userNameField, username);
		typeInput(passwordField, password);
	}

	public void clickOnLoginBtn() {
		clickOnElement(loginBtn);
	}

}
