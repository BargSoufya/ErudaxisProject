package Runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/main/resources/Features/AjouterReapsAvecNomVide.feature",
    glue = "StepDef",
    plugin = {
        "pretty",
        "html:target/cucumber/report.html",
        "json:target/cucumber/report.json",         // ✅ Pour Cucumber HTML Report
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"  // ✅ Pour Allure
    }
)
public class TestRunner {
	
}
