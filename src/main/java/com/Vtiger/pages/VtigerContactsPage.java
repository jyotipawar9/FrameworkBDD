package com.Vtiger.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.SeleniumUtility;

public class VtigerContactsPage extends SeleniumUtility {
	@FindBy(id = "Contacts_listView_basicAction_LBL_ADD_RECORD")
	private WebElement addContactBtn;

	@FindBy(xpath = "(//span[text()='None'])[1]")
	private WebElement salutationDropDownForContact;

	@FindBy(xpath = "//ul[@class='select2-results']/li[2]")
	private WebElement selectSalutationTypeForContact;

	@FindBy(id = "Contacts_editView_fieldName_firstname")
	private WebElement contactFirstName;

	@FindBy(id = "Contacts_editView_fieldName_lastname")
	private WebElement contactLastName;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtn;

	@FindBy(xpath = "(//a[@title='Contacts'])[last()]")
	private WebElement contactHeaderLink;

	@FindBy(xpath = "//a[text()='Smith']")
	private WebElement newlyCreatedContact;

	@FindBy(xpath = "//tr[td[@data-rawvalue='Smith']]/td[1]//input")
	private WebElement newlyCreatedContactCheckBox;

	@FindBy(id = "Contacts_listView_massAction_LBL_DELETE")
	private WebElement deleteBtn;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement deleteYesBtn;

	public void createContact(String firstName, String lastName) {
		clickOnElement(addContactBtn);
		clickOnElement(salutationDropDownForContact);
		clickOnElement(selectSalutationTypeForContact);
		typeInput(contactFirstName, firstName);
		typeInput(contactLastName, lastName);
		clickOnElement(saveBtn);
	}

	public boolean verifyCreatedContact() {
		clickOnElement(contactHeaderLink);
		return verifyUIElementDisplayed(newlyCreatedContact);
	}

	public void deleteCreatedContact() {
		clickOnElement(newlyCreatedContactCheckBox);
		clickOnElement(deleteBtn);
		clickOnElement(deleteYesBtn);
	}

	public boolean verifyDeletedContact() {
		try {
			return !(verifyUIElementDisplayed(newlyCreatedContact));
		} catch (NoSuchElementException e) {
			return true;
		} catch (TimeoutException e) {
			return true;
		}
	}
}
