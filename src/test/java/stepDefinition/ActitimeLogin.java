package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Actitime.pages.ActitimeLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.SeleniumUtility;

public class ActitimeLogin extends SeleniumUtility{
	WebDriver driver;
	ActitimeLoginPage actLogin;
	
	@Given("Browser is opened and user is on actitime login page")
	public void browser_is_opened_and_user_is_on_actitime_login_page() {
		driver = setUp("chrome", "https://demo.actitime.com/login.do");
		actLogin = new ActitimeLoginPage(driver);	    
	}

	@When("User enters the username and password")
	public void user_enters_the_username_and_password() {
	   actLogin.enterusernameAndpassword("admin", "manager");
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
	   actLogin.clickOnloginbtn();
//	   Assert.assertTrue(false);//wrong stmt.
	}

	@Then("User will be navigated to home page")
	public void user_will_be_navigated_to_home_page() {
	   Assert.assertTrue(actLogin.verifyUserIsOnHomePage("actiTIME - Enter Time-Track"));
	   tearDown();
	}


}
