package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

    features = "src/main/resources/Features/",
<<<<<<< HEAD
	tags = "",
   // features = "src/main/resources/Features/AjouterReapsAvecNomVide.feature",
=======
    tags = "",
>>>>>>> 35f8044f97b6dbaee155f9ff90c8a3ddde73f62e
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
