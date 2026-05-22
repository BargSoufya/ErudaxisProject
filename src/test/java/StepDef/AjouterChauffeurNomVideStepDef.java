package StepDef;

import java.util.Map;

import Pages.AjouterChauffeurNomVide;
import io.cucumber.java.en.Then;

public class AjouterChauffeurNomVideStepDef {

	AjouterChauffeurNomVide chauff= new AjouterChauffeurNomVide();
	
	@Then("l admin  laisse le champ {string} vide")
	public void l_admin_laisse_le_champ_vide(String string) {
	   chauff.NomVide();
	}
	@Then("l admin sasit le reste des infortmations :")
	public void l_admin_sasit_le_reste_des_infortmations(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
	
		String prenom       = data.get("Prénom");
	    String nom          = data.get("Nom");
	    String email        = data.get("Email");
	    String cin          = data.get("CIN");
	    String phoneNumber  = data.get("Numéro de téléphone");
	    String adresse      = data.get("Adresse");
	    String pays         = data.get("Pays");
	    String ville        = data.get("Ville");

	    chauff.saisirlesChamps(prenom, "",email, cin, phoneNumber, adresse);
	    chauff.selectionnerPays(pays);	
	    chauff.selectionnerVille(ville);
	
	}



}
