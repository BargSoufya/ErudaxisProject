package Runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
<<<<<<< HEAD
    features = "src/main/resources/Features/AjouterReapsAvecNomVide.feature",
=======
    features = "src/main/resources/Features/",
	tags = "",
>>>>>>> 753a6a8fa3ba504a8a77c7c23de88648fed86df4
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
