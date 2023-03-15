package com.OrangeHrm.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.SeleniumUtility;

public class OrangeHrmLoginPage extends SeleniumUtility {
	
	@FindBy(name = "username")
	private WebElement userNameField;
	
	@FindBy(name = "password")
	private WebElement passwordField;
	
	@FindBy(css = "button[type='submit']")
	private WebElement loginBtn;
	
	public void enterUserNameAndPwd(String userName,String pwd) {
		typeInput(userNameField, userName);
		typeInput(passwordField, pwd);
	}
	
	public void clickOnloginBtn() {
		clickOnElement(loginBtn);
	}
	
	public boolean verifyUserIsOnHomePage(String expectedHomePageUrl) {
		try {
			getCurrentPageUrl(expectedHomePageUrl);
			return true;
		}catch(TimeoutException e) {
			return false;
		}
	}
}
