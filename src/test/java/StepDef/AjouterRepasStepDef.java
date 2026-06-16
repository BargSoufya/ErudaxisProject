package StepDef;

import org.openqa.selenium.chrome.ChromeDriver;

import Helper.Config;
import Pages.AjouterRepasPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AjouterRepasStepDef {
	
	 AjouterRepasPage ajout= new AjouterRepasPage ();
	 
	@Given("l admin est  redirige vers la page du tableau de bord")
	public void l_admin_est_redirige_vers_la_page_du_tableau_de_bord() {
		Config.driver = new ChromeDriver ();
		Config.Maximize();	
	   String url="https://staging.erudaxis.com/";
	   Config.driver.get(url);
	   Config.driver.quit();
	}

	@When("l admin clique sur le menu {string}")
	public void l_admin_clique_sur_le_menu(String menu) {
	   
	    ajout.clickOnMenuCantine(menu);
	    
	    
	}
	@Then("le sousmenu {string} s affiche")
	public void le_sousmenu_s_affiche(String cantine) {
	   ajout.verifierSousMenuVisible(cantine);
	    
	}
	@When("l admin clique sur le sous-menu {string}")
	public void l_admin_clique_sur_le_sous_menu1(String submenu) {
	    AjouterRepasPage ajout= new AjouterRepasPage ();
	    	ajout.ClickOnSousMenu(submenu);
	}
	@Then("la page {string} s affiche")
	public void la_page_s_affiche( String titre) {
		AjouterRepasPage ajout= new AjouterRepasPage ();
	    ajout.verifierPageGestionCantine(titre);
	}
	@When("l admin clique sur le bouton ajouter un repas")
	public void l_admin_clique_sur_le_bouton_ajouter_un_repas() {
		AjouterRepasPage ajout= new AjouterRepasPage ();
	    ajout.ClickOnbtn();
	}
	
	@Then("le formulaire d ajout dun repas s affiche")
	public void nd_le_formulaire_contient_les_champs_suivants(io.cucumber.datatable.DataTable form) {
		AjouterRepasPage ajout= new AjouterRepasPage ();
	    ajout.AfficherForm();
	}

	@Then("le sousmenu Gestion Cantine s affiche")
	//public void le_sousmenu_gestion_cantine_s_affiche() {
	//   ajout.verifierSousMenuVisible();
	//}
	@Then("la page Gestion de la Cantine s affiche")
	public void la_page_gestion_de_la_cantine_s_affiche() {
	    ajout.VerifGestionCa(null);
	}
	
	
	@Then("le formulaire d ajout dun repas s  affiche")
	public void le_formulaire_d_ajout_dun_repas_s_affiche() {
	    ajout.AfficherForm();
	    Config.driver.quit();
	}
	
	
	
}

		


