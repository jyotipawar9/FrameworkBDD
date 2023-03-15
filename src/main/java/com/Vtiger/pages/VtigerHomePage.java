package com.Vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class VtigerHomePage extends SeleniumUtility {
	WebDriver driver;

	public VtigerHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "appnavigator")
	private WebElement burgerMenu;

	@FindBy(xpath = "//span[contains(text(),'MARKETING')]")
	private WebElement marketingOption;

	@FindBy(xpath = "//a[@title='Leads']")
	private WebElement leadOption;

	@FindBy(xpath = "//a[@href='index.php?module=Contacts&view=List&app=MARKETING' and @title='Contacts']")
	private WebElement contactOption;

	@FindBy(css = ".company-logo")
	private WebElement companyLogo;

	@FindBy(css = "span[class='fa fa-user']")
	private WebElement profileBtn;

	@FindBy(id = "menubar_item_right_LBL_SIGN_OUT")
	private WebElement singoutBtn;
	
	public void navigateToLeagPage() {
		clickOnElement(burgerMenu);
		clickOnElement(marketingOption);
		clickOnElement(leadOption);
	}
	public void signOut() {
		clickOnElement(companyLogo);
		clickOnElement(profileBtn);
		clickOnElement(singoutBtn);
	}
}
