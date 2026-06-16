package StepDef;

import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;

import Helper.Config;
import Pages.AjouterRepasAvecNomExistantPage;
import Pages.AjouterRepasPage;
import Pages.LoginPage;
import Pages.RepasAvecNomVidePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RepasAvecNomExistantStepDef {

	

@Given("l admin est authentifié par l'email {string} et le mot de passe {string}")
public void l_admin_est_authentifié_par_l_email_et_le_mot_de_passe(String email, String pwd) {
	//Config.driver = new ChromeDriver ();
Config.Maximize();
   String url="https://staging.erudaxis.com/";
   Config.driver.get(url);
   LoginPage logp=new LoginPage();
	logp.Connecter(email, pwd);
}
@Given("l admin choisit le rôle {string}")
public void l_admin_choisit_le_rôle(String role) {
	Config.attente(10);
	LoginPage login= new LoginPage();
    login.ClickonMenu(role);

}
@Then("le sous-menu {string} s affiche")
public void le_sous_menu_s_affiche(String name) {
	AjouterRepasPage ajouter=new AjouterRepasPage();
	ajouter.ClickOnSousMenu(name);
	

}


@When("l admin clique sur le bouton ajouter un repas avec les informations suivantes :")
public void l_admin_clique_sur_le_bouton_ajouter_un_repas_avec_les_informations_suivantes(io.cucumber.datatable.DataTable dataTable) {
    
    Map<String, String> data = dataTable.asMap(String.class, String.class);
    
    String Categorie = data.get("Catégorie");
    String Emoji = data.get("Emoji");
   
    
    String Prix = data.get("Prix");
    String Quantite = data.get("Quantité");
  
      // ou null
    String date= "Date";
    String nom = data.get("Nom du repas");
    
    AjouterRepasAvecNomExistantPage NomExistant = new AjouterRepasAvecNomExistantPage();
    NomExistant.ajouterRepasavecleschamps(
        nom, 
        Categorie, 
        Integer.parseInt(Prix), 
        Integer.parseInt(Quantite)
    );
    NomExistant.selectionnerEmoji(data.get("Emoji"));
    NomExistant.selectionnerCatg(data.get("Catégorie"));
  
    NomExistant.sasirdescription(data.get("Description"));
    NomExistant.selectionnerDate(data.get("Date"));
}

@When("l admin clique sur le bouton Ajouter un repas")
public void l_admin_clique_sur_le_bouton_ajouter_un_repas() {
AjouterRepasPage Ajouter = new AjouterRepasPage();
	Ajouter.ClickOnbtn();
}

@Then("l admin clique sur créer le repas et un message d erreur indique que le nom existe déjà")
public void l_admin_clique_sur_créer_le_repas_et_un_message_d_erreur_indique_que_le_nom_existe_déjà() {
	AjouterRepasAvecNomExistantPage NomExistant = new AjouterRepasAvecNomExistantPage();
	NomExistant.creerUnrepasNomExistant();
}




}
