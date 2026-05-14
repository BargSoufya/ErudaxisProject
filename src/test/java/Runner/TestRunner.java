package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



	@RunWith(Cucumber.class)
	@CucumberOptions(
			features ="src\\main\\resources\\Features\\RepasAvecDatepasse.feature",
			glue= "StepDef",
			plugin = {"pretty",
					  "html:target/cucumber/report.html",
					 "json:target/cucumber/report.json",
					  "json:target/allure-results/allure.json"
					 }
			
			
			)
	public class TestRunner {
}
