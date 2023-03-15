package stepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.SwagLab.pages.SwagLabHomePage;
import com.SwagLab.pages.SwagLabLoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.SeleniumUtility;

public class SwagLabLogin extends SeleniumUtility {
	WebDriver driver;
	SwagLabLoginPage swgLogin;
	SwagLabHomePage swgHome;
	String filePath = "./src/main/resources/SwagLabData.properties";
	@Given("user is on SwagLab login page")
	public void user_is_on_swag_lab_login_page() throws IOException {
		swgLogin = new SwagLabLoginPage(driver);
		swgHome = PageFactory.initElements(driver, SwagLabHomePage.class);
		
	}

	@When("user enter username and password")
	public void user_enter_username_and_password(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    List<List<String>> userData = dataTable.asLists(String.class);
	    System.out.println(userData);
	    
	    List<String> firstUser = userData.get(0);
	    System.out.println(firstUser);
	    
	    List<String> secondUser = userData.get(1);
	    System.out.println(secondUser);
	    swgLogin.enterUserNameAndPassword(firstUser.get(0), secondUser.get(1));
	}
	@When("user enter username and password using datatable data")
	public void user_enter_username_and_password_using_datatable_data(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	   List<Map<String,String>> userData = dataTable.asMaps();
	   String firstUserName = userData.get(0).get("username");
	   String firstUserPassword = userData.get(0).get("password");
		System.out.println(firstUserName + " " + firstUserPassword);

		String secondUserName = userData.get(1).get("username");
		String secondUserPassword = userData.get(1).get("password");
		System.out.println(secondUserName + " " + secondUserPassword);

		swgLogin.enterUserNameAndPassword(firstUserName, firstUserPassword);
	   
	}


	@When("click on the login button")
	public void click_on_the_login_button() {
		swgLogin.clickOnLoginBtn();
	}

	@Then("user should logged in successfully for valid user")
	public void user_should_logged_in_successfully_for_valid_user() {
		swgHome.verifyUserIsOnHomePage();
		tearDown();
	}

}
