package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/main/resources/Features/",
    tags = "",
    glue = "StepDef",
    plugin = {
        "pretty",
        "html:target/cucumber/report.html",
        "json:target/cucumber/report.json",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    }
)
public class TestRunner {
    
}
