package StepDef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v128.page.Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.Config;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDef {

	// @Given("admin est sur la page d authentification")
	// public void admin_est_sur_la_page_d_authentification() {
	// 	Config.driver = new ChromeDriver ();
	// 	Config.Maximaize();
	// 	String url ="https://staging.erudaxis.com/";
	// 	Config.driver.get(url);
		
	// }

	@Given("admin est sur la page d authentification")
public void admin_est_sur_la_page_d_authentification() {
    // // Add headless mode for CI/CD environments
    // ChromeOptions options = new ChromeOptions();
    // options.addArguments("--headless=new");
    // options.addArguments("--no-sandbox");
    // options.addArguments("--disable-dev-shm-usage");
    // options.addArguments("--disable-gpu");
    
    // Config.driver = new ChromeDriver(options);
    Config.Maximaize();
    String url = "https://staging.erudaxis.com/";
    Config.driver.get(url);
}
	
	@When("admin remplit le champ email {string} et  mdp {string}")
	public void admin_remplit_le_champ_email_et_mdp(String email, String mdp) {
	    LoginPage login= new LoginPage();
	    Config.attente(10);
	    login.Connecter(email,mdp);
	    System.out.println(">>> URL après Connecter() : " + Config.driver.getCurrentUrl());
        System.out.println(">>> Titre après Connecter() : " + Config.driver.getTitle());
		
	}
	@Then("admin click on {string}")
	public void admin_click_on(String role) {
	    LoginPage login= new LoginPage();
	   
	    login.ClickonMenu(role);

	}
	@Then("la page menu est affiché {string}")
	public void la_page_menu_est_affiché(String verif) throws Exception {
	    LoginPage login= new LoginPage();

	    login.VerifChoix(verif);

	}
	
}
	

