package runner_RerunFailedScenarios;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = {"src/test/resources/features"}, glue = {"stepDefinition"},
			plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failedrerun.txt" }, monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
