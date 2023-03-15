package runner_ToGetFailedSceneario;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = {"src/test/resources/features"}, glue = {"stepDefinition"},
			plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true, tags="@Smoke")
public class TestRunner extends AbstractTestNGCucumberTests {

}
