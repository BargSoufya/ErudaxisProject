package StepDef;

import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;

import Helper.Config;
import Pages.AjouterRepasPage;
import Pages.LoginPage;
import Pages.RepasAvecNomVidePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AjouterunRepasAvecNomVideStepDef {
	

	@Given("l'admin est authentifié par l'email {string} et le mot de passe {string}")
	public void l_admin_est_authentifié_avec_l_email_et_le_mot_de_passe(String email, String pwd) {
		Config.driver = new ChromeDriver ();
		Config.Maximize();	
	   String url="https://staging.erudaxis.com/";
	   Config.driver.get(url);
	   LoginPage logp=new LoginPage();
		logp.Connecter(email, pwd);
		
	}
	@Given("l'admin choisit le rôle {string}")
	public void l_admin_choisit_le_rôle(String role) {
		Config.attente(10);
		LoginPage login= new LoginPage();
		   
	    login.ClickonMenu(role);
	}
	@When("l'admin clique sur le menu {string}")
	public void l_admin_est_sur_la_page(String page) {
	    	AjouterRepasPage ajouter=new AjouterRepasPage();
	    	ajouter.clickOnMenuCantine(page);
	    	
	    	  

	}
	
	@Then("le sous-menu {string} s'affiche")
	public void le_sous_menu_s_affiche(String menu) {
		AjouterRepasPage ajouter=new AjouterRepasPage();
		ajouter.verifierSousMenuVisible(menu);
	}
	@When("l'admin clique sur le sous-menu {string}")
	public void l_admin_clique_sur_le_sous_menu(String name) {
		AjouterRepasPage ajouter=new AjouterRepasPage();
		ajouter.ClickOnSousMenu(name);
	}
	@Then("la page {string} s'affiche")
	public void la_page_s_affiche(String page) {
		AjouterRepasPage ajouter=new AjouterRepasPage();
		ajouter.verifierPageGestionCantine(page);
	}
	@When("l admin clique sur le bouton {string}")
	public void l_admin_clique_sur_le_bouton(String buttonName) {
	    switch (buttonName) {
	        case "Ajouter un repas":
	            AjouterRepasPage ajouter = new AjouterRepasPage();
	            ajouter.ClickOnbtn();
	            break;
	        case "Créer le repas":
	            RepasAvecNomVidePage repas = new RepasAvecNomVidePage();
	            repas.ajouterRepas();
	            break;
	        default:
	            throw new IllegalArgumentException("Bouton non reconnu : " + buttonName);
	    }
	}
	@Then("le formulaire d'ajout d'un repas s'affiche")
	public void le_formulaire_d_ajout_d_un_repas_s_affiche() {
		AjouterRepasPage ajouter=new AjouterRepasPage();
		ajouter.AfficherForm();
	}

	
	
	
	@Then("le repas n'apparaît pas dans la liste des repas")
	public void le_repas_n_apparaît_pas_dans_la_liste_des_repas() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("l dmin laisse le champ {string} vide")
	public void l_dmin_laisse_le_champ_vide(String nom) {
		RepasAvecNomVidePage NomVide = new RepasAvecNomVidePage();
		NomVide.nomvide();
	    
	}
	@When("l admin saisit les informations suivantes :")
	public void l_admin_saisit_les_informations_suivantes(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		
	    Map<String, String> data = dataTable.asMap(String.class, String.class);
	    
	    String Categorie = data.get("Catégorie");
	    String Emoji = data.get("Emoji");
	   
	    
	    String Prix = data.get("Prix");
	    String Quantite = data.get("Quantité");
	  
	      // ou null
	    String date= "Date";
	    String nom="";
	    RepasAvecNomVidePage NomVide = new RepasAvecNomVidePage();
	    NomVide.ajouterRepasavecleschamps(
	        nom, 
	        Categorie, 
	        Integer.parseInt(Prix), 
	        Integer.parseInt(Quantite)
	    );
	    NomVide.selectionnerEmoji(data.get("Emoji"));
	    NomVide.selectionnerCatg(data.get("Catégorie"));
	  
	    NomVide.sasirdescription(data.get("Description"));
	    NomVide.selectionnerDate(data.get("Date"));
	}
	
	@When("l admin clique sur le bouton Créer le repas")
	public void l_admin_clique_sur_le_bouton_créer_le_repas() {
		RepasAvecNomVidePage NomVide = new RepasAvecNomVidePage();
		NomVide.ajouterRepas();
	}
// 	@Then("un message d erreur indique que le nom est obligatoire")
// 	public void un_message_d_erreur_indique_que_le_nom_est_obligatoire() {

// 	    RepasAvecNomVidePage repas = new RepasAvecNomVidePage();
// <<<<<<< HEAD
// 	    repas.verifierMessageErreur();
// =======
// 		repas.messgaederreur("Veuillez saisir le nom du repas");
// >>>>>>> 753a6a8fa3ba504a8a77c7c23de88648fed86df4
// 	}
	@Then("un message d erreur indique que le nom est obligatoire")
	public void un_message_d_erreur_indique_que_le_nom_est_obligatoire() {
	    RepasAvecNomVidePage repas = new RepasAvecNomVidePage();
	    repas.messgaederreur("Veuillez saisir le nom du repas");
	}

	@Then("le repas n'apparaît pas dans la liste des repas et quite le formulaire")
	public void le_repas_n_apparaît_pas_dans_la_liste_des_repas_et_quite_le_formulaire() {
		RepasAvecNomVidePage NomVide = new RepasAvecNomVidePage();
		NomVide.annulerlajout();
	}
}







