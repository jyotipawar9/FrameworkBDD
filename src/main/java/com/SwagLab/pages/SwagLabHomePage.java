package com.SwagLab.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.SeleniumUtility;

public class SwagLabHomePage extends SeleniumUtility {
	@FindBy(css = ".app_logo")
	private WebElement applicationLogo;

	public boolean verifyUserIsOnHomePage() {
		try {
			return verifyUIElementDisplayed(applicationLogo);
		} catch (TimeoutException e) {
			return false;
		}
	}
}
