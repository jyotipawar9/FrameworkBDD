package com.Vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class VTigerLoginPage extends SeleniumUtility {
		
	WebDriver driver;
	
	public VTigerLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}

	@FindBy(id="username")
	private WebElement usernameField;
	
	@FindBy(name="password")
	private WebElement passwordField;
	
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement signInBtn;
	
	public void vtigerLogin(String username,String password) {
		typeInput(usernameField, username);
		typeInput(passwordField, password);
		clickOnElement(signInBtn);
	}
}
