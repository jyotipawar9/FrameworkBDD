package runner_Skip_Scenario;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = {"src/test/resources/features"}, glue = {"stepDefinition"},
			plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true, tags = "@Regression")
public class TestRunner extends AbstractTestNGCucumberTests {

}
