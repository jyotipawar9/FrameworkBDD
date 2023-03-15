package com.Actitime.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class ActitimeLoginPage extends SeleniumUtility{
	WebDriver driver;
	public ActitimeLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	private WebElement userNameField;
	
	@FindBy(name = "pwd")
	private WebElement passwordField;
	
	@FindBy(id = "loginButton")
	private WebElement loginBtn;
	
	public void enterusernameAndpassword(String userName, String pwd) {
		typeInput(userNameField, userName);
		typeInput(passwordField, pwd);
	}
	
	public void clickOnloginbtn() {
		clickOnElement(loginBtn);
	}
	public boolean verifyUserIsOnHomePage(String expectedTitle) {
		try {
			getCurrentPageTitle(expectedTitle);
			return true;
		}catch(TimeoutException e) {
			return false;
		}
	}

}
