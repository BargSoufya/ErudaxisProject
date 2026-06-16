package StepDef;

import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;

import Helper.Config;
import Pages.LoginPage;
import Pages.RepasAvecNomVidePage;
import Pages.RepasavecdDatePasse;
import Pages.SynthesePaiement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SynthesePaiementStepDef {


@Given("l admin est authentifie avec {string} et {string} et choisit {string}")
public void l_admin_est_authentifie_avec_et_et_choisit(String email, String pwd, String role) {
	//Config.driver = new ChromeDriver ();
	Config.Maximize();
   String url="https://staging.erudaxis.com/";
   Config.driver.get(url);
   LoginPage logp=new LoginPage();
	logp.Connecter(email, pwd);
	Config.attente(10);   
	logp.ClickonMenu(role);
}
@Then("la page Portail de Gestion des Paiements s affiche")
public void la_page_portail_de_gestion_des_paiements_s_affiche() {
	SynthesePaiement  Syp = new  SynthesePaiement();
	Syp.verifierPageAffichee("Portail de Gestion des Paiements");
}
@When("l admin choisit un etudiant dans la liste {string}")
public void l_admin_choisit_un_etudiant_dans_la_liste(String etudiant) {
	SynthesePaiement  Syp = new  SynthesePaiement();
	Syp.selectionnerEtudiant(etudiant);
}      
@When("l admin choisit la date de debut {string}")
public void l_admin_choisit_la_date_de_debut(String dateD) {
	SynthesePaiement SynP= new SynthesePaiement();
	SynP.selectionnerDateDebut(dateD);
}
@When("l admin choisit la date de fin {string}")
public void l_admin_choisit_la_date_de_fin(String dateF) {
	SynthesePaiement SynP= new SynthesePaiement();
	SynP.selectionnerDateFin(dateF);
}
@When("l admin clique sur le bouton Rechercher et la facture de l etudiant s affiche")
public void l_admin_clique_sur_le_bouton_rechercher_et_la_facture_de_l_etudiant_s_affiche()  {
	SynthesePaiement SynP= new SynthesePaiement();
	SynP.ClickOnRecherche();
}
@When("l admin remplit les champs de recherche suivants :")
public void l_admin_remplit_les_champs_de_recherche_suivants(io.cucumber.datatable.DataTable dataTable) {
	Map<String, String> data = dataTable.asMap(String.class, String.class);

	 String  Étudiant = data.get(" Étudiant");
	    String DateD = data.get("Début");
	   
	    
	    String DateF = data.get("Fin");
	    SynthesePaiement page = new SynthesePaiement();
  
	    Config.attente(10);
	    page.selectionnerEtudiant(data.get("Étudiant"));
	    page.selectionnerDateDebut(data.get("Début"));
	    page.selectionnerDateFin(data.get("Fin"));
	  
	    
}
//@Then("la facture de l etudiant s affiche")
//public void la_facture_de_l_etudiant_s_affiche() {
    // Write code here that turns the phrase above into concrete actions
  //  throw new io.cucumber.java.PendingException();
//}

}
