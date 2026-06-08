package StepDef;

import Helper.Config;
import Pages.AjouterUnNouveauBusPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AjouterUnNouveauBusStepDef {

	
	@Given("l'admin est authentifie avec {string} et {string} et choisit {string}")
	public void l_admin_est_authentifie_avec_et_et_choisit(String email, String pwd, String role) {
	    CommunStepDef com=new CommunStepDef();
	    com.l_admin_est_authentifie_par_le_bon_et_le_bon_password_and_choisit_le_role(email, pwd, role);
	    
	}
	@When("l admin clique sur le menu Bus {string}")
	public void l_admin_clique_sur_le_menu_bus(String menu) {
		AjouterUnNouveauBusPage bus= new AjouterUnNouveauBusPage();
		bus.clickOnMenubus(menu);
	}
	@When("l admin clique sur le sous-menu Bus {string}")
	public void l_admin_clique_sur_le_sous_menu_bus(String submenusBus) {
		AjouterUnNouveauBusPage bus= new AjouterUnNouveauBusPage();
		bus.ClickOnSubMenuBus(submenusBus);
	}
	@When("l admin clique sur le bouton Ajouter un bus le formulaire d ajout d un bus s'affiche")
	public void l_admin_clique_sur_le_bouton_ajouter_un_bus_le_formulaire_d_ajout_d_un_bus_s_affiche(){
		AjouterUnNouveauBusPage bus= new AjouterUnNouveauBusPage();
		bus.ClickOnbtnBus();
		
	}


	@Then("la page bus et chauffeurs s affiche {string}")
	public void la_page_bus_et_chauffeurs_s_affiche(String text) {
		AjouterUnNouveauBusPage bus= new AjouterUnNouveauBusPage();
		// bus.verifAffichagePage(text);
		   bus.verifAffichagePage(text);
	}
	@Then("le formulaire d ajout d un bus s'affiche")
public void le_formulaire_d_ajout_d_un_bus_s_affiche() {
		AjouterUnNouveauBusPage bus= new AjouterUnNouveauBusPage();
		bus.verifAffichagePage("Ajouter un bus");
		Config.driver.quit();
	}

	@Then("l admin clique sur le bouton de navigation pour changer vers l interface chauffeur")
	public void l_admin_clique_sur_le_bouton_de_navigation_pour_changer_vers_l_interface_chauffeur()   {
		AjouterUnNouveauBusPage chauff= new AjouterUnNouveauBusPage();
		chauff.ClickOnbtnavigation();
		chauff.verifAffichagechaufPage("Ajouter un Chauffeur");
	}
	@When("l admin clique sur le bouton ajouter un chauffeur le formulaire de chauffeur s affiche")
	public void l_admin_clique_sur_le_bouton_ajouter_un_chauffeur_le_formulaire_de_chauffeur_s_affiche() {
		AjouterUnNouveauBusPage chauff= new AjouterUnNouveauBusPage();
		chauff.ClickOnbtchauff();
	}




}
