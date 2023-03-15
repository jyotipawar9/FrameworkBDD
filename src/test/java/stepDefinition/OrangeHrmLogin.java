package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.OrangeHrm.pages.OrangeHrmLoginPage;
import com.fasterxml.jackson.databind.Module.SetupContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.SeleniumUtility;

public class OrangeHrmLogin extends SeleniumUtility {
	WebDriver driver;
	OrangeHrmLoginPage orgLogin;
	
	@Given("user opens thr {string} browser and OrangeHrm application using {string}")
	public void user_opens_thr_browser_and_orange_hrm_application_using(String browser, String appUrl) {
	    driver = setUp(browser,appUrl);
	    orgLogin = PageFactory.initElements(driver, OrangeHrmLoginPage.class);
	}

	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String userName, String pwd) {
	    orgLogin.enterUserNameAndPwd(userName, pwd);
	}

	@When("user click on Login button")
	public void user_click_on_login_button() {
	    orgLogin.clickOnloginBtn();
	}

	@Then("user should navigate to home page having url as {string}")
	public void user_should_navigate_to_home_page_havind_url_as(String expectedHomePageUrl) {
	   Assert.assertTrue(orgLogin.verifyUserIsOnHomePage(expectedHomePageUrl));
	   tearDown();
	}

}
