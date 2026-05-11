package StepDef;

import java.util.Map;

import Helper.Config;
import Pages.RepasAvecNomVidePage;
import Pages.RepasavecdDatePasse;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RepasavecdDatePasseStepDef {


@When("l admin saisit le champ {string}")

	public void l_admin_saisit_le_champ(String date) {
	    System.out.println("Champ reçu : " + date);
	    // Ne pas appeler selectionnerDate ici
	    
	    RepasAvecNomVidePage NomVide=new RepasAvecNomVidePage();
	    NomVide.ajouterRepasavecleschamps(date, date, 0, 0);
	}
	@Then("un message d erreur sous le champ date")
	public void un_message_d_erreur_sous_le_champ_date() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("un message d erreur sous le champ date s affiche And le repas n'apparaît pas dans la liste des repas et quite le formulaire")
	public void un_message_d_erreur_sous_le_champ_date_s_affiche_and_le_repas_n_apparaît_pas_dans_la_liste_des_repas_et_quite_le_formulaire() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("l admin saisit les informations du repas suivantes :")
	public void l_admin_saisit_les_informations_du_repas_suivantes(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);

		 String Categorie = data.get("Catégorie");
		    String Emoji = data.get("Emoji");
		   
		    
		    String Prix = data.get("Prix");
		    String Quantite = data.get("Quantité");
		  
		      // ou null
		    String date= "Date";
		    String nom="Nom du repas";
	    RepasavecdDatePasse page = new RepasavecdDatePasse();
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
   
		        page.SaisirNom(data.get("Nom du repas"));
	}
	

	@Then("un message d erreur sous le champ date s affiche")
	public void un_message_d_erreur_sous_le_champ_date_s_affiche() {
		 RepasavecdDatePasse page = new RepasavecdDatePasse();
		page.annulerlajout();
	}
	

}
