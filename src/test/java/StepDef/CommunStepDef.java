package StepDef;

import org.openqa.selenium.chrome.ChromeDriver;

import Helper.Config;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;

public class CommunStepDef {
	@Given("l admin est authentifie par  le bon {string} et le bon password {string} And  choisit le role {string}")
	public void l_admin_est_authentifie_par_le_bon_et_le_bon_password_and_choisit_le_role(String email_user, String pwd, String role) {
		 //Config.driver= new ChromeDriver();
		 Config.Maximaize();
		 String url = "https://staging.erudaxis.com/dashboards/default";
		 Config.driver.get(url);
		 LoginPage log= new LoginPage();
		 log.Connecter(email_user,pwd);
		 log.ClickonMenu(role);
	        System.out.println(">>> ✅ Connecté en tant que : " + role);
	     
	        
	      
	       
	        
	
	       

	           
	        		
	        	
  
	
	}
	
	
	

	
	 
}
