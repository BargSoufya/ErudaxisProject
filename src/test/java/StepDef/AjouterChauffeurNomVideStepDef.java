package StepDef;

import java.util.Map;

import Pages.AjouterChauffeurNomVide;
import io.cucumber.java.en.Then;

public class AjouterChauffeurNomVideStepDef {

	AjouterChauffeurNomVide chauff= new AjouterChauffeurNomVide();
	
	@Then("l admin  laisse le champ Nom {string}")
	public void l_admin_laisse_le_champ_nom(String string) {
	   chauff.NomVide();
	}
	@Then("l admin sasit le reste des infortmations :")
	public void l_admin_sasit_le_reste_des_infortmations(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
	
		String prenom       = data.get("Prénom");
	    String nom          = "";
	    String email        = data.get("Email");
	    String cin          = data.get("CIN");
	    String phoneNumber  = data.get("Numéro de Téléphone");
	    String adresse      = data.get("Adresse");
	    String pays         = data.get("Pays");
	    String ville        = data.get("Ville");
	   

	 //   chauff.saisirlesChamps(prenom, "",email, cin, phoneNumber, adresse);
	    chauff.saisirlesChamps(prenom, "", email, cin, phoneNumber, adresse);

	    chauff.selectionnerPays(pays);	
	    chauff.selectionnerVille("Paris");
	    chauff.selectionnerIndicatif();
	    
	   
	    
	
	}
	@Then("l 'admin clique sur le bouton creer le chauffeur")
	public void l_admin_clique_sur_le_bouton_creer_le_chauffeur() {
		chauff.clickOncreerbt();
	}




}
