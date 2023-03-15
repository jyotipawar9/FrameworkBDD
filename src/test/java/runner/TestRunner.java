package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = {"src/test/resources/features/ActitimeTaskCreation.feature"}, glue = {"stepDefinition"},
			plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, tags = "@Smoke or @Regression", monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
