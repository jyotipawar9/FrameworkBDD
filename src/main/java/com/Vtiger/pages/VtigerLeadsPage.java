package com.Vtiger.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import utility.SeleniumUtility;

public class VtigerLeadsPage extends SeleniumUtility {
	@FindBy(id = "Leads_listView_basicAction_LBL_ADD_RECORD")
	private WebElement addLeadBtn;

	@FindBy(xpath = "(//span[text()='None'])[1]")
	private WebElement salutationDropDownForLead;

	@FindBy(xpath = "//ul[@class='select2-results']/li[2]")
	private WebElement selectSalutationTypeForLead;

	@FindBy(id = "Leads_editView_fieldName_firstname")
	private WebElement firstNameField;

	@FindBy(id = "Leads_editView_fieldName_lastname")
	private WebElement lastNameField;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtn;

	@FindBy(xpath = "(//a[@title='Leads'])[2]")
	private WebElement leadHeaderLink;

	@FindAll({ @FindBy(xpath = "//a[text()='Smith']"), @FindBy(xpath = "//a[text()='Jeff']") })
	private WebElement newlyCreatedLeadName;

	@FindBy(xpath = "//a[text()='Smith']")
	private WebElement newlyCreatedLeadName1;

	@FindBy(xpath = "//a[text()='Jeff']")
	private WebElement newlyCreatedLeadName2;

	@FindBy(css = ".listViewEntriesMainCheckBox")
	private WebElement selectAllCheckBox;

	@FindBy(xpath = "//button[@title='Delete']")
	private WebElement deleteBtn;

	@FindBy(xpath = "//div[text()='Are you sure you want to delete the selected Records?']")
	private WebElement deletePopupMsg;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement confirmDeleteBtn;

	@FindBy(css = ".emptyRecordsContent")
	private WebElement emptyRecord;
	
	public void clickOnAddLeadBtn() {
		clickOnElement(addLeadBtn);
	}
	public void createLead(String firstname,String lastname) {
		clickOnElement(salutationDropDownForLead);
		clickOnElement(selectSalutationTypeForLead);
		typeInput(firstNameField, firstname);
		typeInput(lastNameField, lastname);
		clickOnElement(saveBtn);
	}
	public boolean verifyCreatedLead() {
		clickOnElement(leadHeaderLink);
		
		try {
			return verifyUIElementDisplayed(newlyCreatedLeadName);
		}catch(TimeoutException e) {
			return false;
		}
	}
	public void clickOnSelectAllCheckBox() {
		clickOnElement(selectAllCheckBox);
	}
	public void clickDeleteBtn() {
		clickOnElement(deleteBtn);
	}
	public boolean verifyDeletePopup() {
		try {
			return verifyUIElementDisplayed(deletePopupMsg);
		}catch(TimeoutException e) {
			return false;
			
		}
	}
	public void clickOnYesBtn() {
		clickOnElement(confirmDeleteBtn);
	}
	public boolean verifyLeadIsDeleted() {
		try {
			return verifyUIElementDisplayed(emptyRecord);
		}catch(TimeoutException e) {
			return false;
		}
	}

}
