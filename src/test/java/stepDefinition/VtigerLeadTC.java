package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Vtiger.pages.VTigerLoginPage;
import com.Vtiger.pages.VtigerHomePage;
import com.Vtiger.pages.VtigerLeadsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.SeleniumUtility;
// git practice
public class VtigerLeadTC extends SeleniumUtility{
	WebDriver driver;
	String propFilePath ="./src/main/resources/VtigerData.properties";
	VTigerLoginPage vtLogin;
	VtigerHomePage vtHome;
	VtigerLeadsPage vtLead;
	
	@Given("user is on Vtiger login page")
	public void user_is_on_vtiger_login_page() throws IOException {
		driver = setUp(getPropertyFileData(propFilePath, "browser"), getPropertyFileData(propFilePath, "appUrl"));
		vtLogin = new VTigerLoginPage(driver);
		vtHome = new VtigerHomePage(driver);
		vtLead = PageFactory.initElements(driver, VtigerLeadsPage.class);
	  
	}

	@Given("user login using valid credentials")
	public void user_login_using_valid_credentials() throws IOException {
	   vtLogin.vtigerLogin(getPropertyFileData(propFilePath, "username"), getPropertyFileData(propFilePath, "password"));
	}

	@Given("user navigates to lead page")
	public void user_navigates_to_lead_page() {
	    vtHome.navigateToLeagPage();
	}

	@When("user click on the add leads button")
	public void user_click_on_the_add_leads_button() {
	   vtLead.clickOnAddLeadBtn();
	}

	@When("user enters firstname as {string} and lastname as {string} and click on the save button")
	public void user_enters_firstname_as_and_lastname_as_and_click_on_the_save_button(String firstname, String lastname) {
	    vtLead.createLead(firstname, lastname);
	}

	@Then("verify lead is created with {string}")
	public void verify_lead_is_created_with(String firstname) {
	    Assert.assertTrue(vtLead.verifyCreatedLead());
	    tearDown();
	}

	@When("user click on the select all leads checkbox")
	public void user_click_on_the_select_all_leads_checkbox() {
		vtLead.clickOnSelectAllCheckBox();
	}

	@When("user click on the delete button")
	public void user_click_on_the_delete_button() {
		vtLead.clickDeleteBtn();
	}

	@Then("a delete confirmation pop up will appear")
	public void a_delete_confirmation_pop_up_will_appear() {
		Assert.assertTrue(vtLead.verifyDeletePopup());
	}

	@When("user click on Yes to confirm the deletion")
	public void user_click_on_yes_to_confirm_the_deletion() {
		vtLead.clickOnYesBtn();
	}

	@Then("verify that all the leads are deleted")
	public void verify_that_all_the_leads_are_deleted() {
		Assert.assertTrue(vtLead.verifyLeadIsDeleted());
		tearDown();
	}
}
