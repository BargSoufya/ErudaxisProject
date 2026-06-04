package StepDef;

import java.util.Map;
import java.util.concurrent.TimeoutException;

import Helper.Config;
import Pages.AjouterRepasAvecNomExistantPage;
import Pages.ModifierUnRepas;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ModifierRepasStepDef {

	ModifierUnRepas modif= new ModifierUnRepas();
	@Then("l admin clique sur les trois points du repas selectionné et  un menu de deux choix s affiche")
	public void l_admin_clique_sur_les_trois_points_du_repas_selectionné_et_un_menu_de_deux_choix_s_affiche()  {
		modif.Menu();;
	}

	@When("l admin clique sur le bouton modifier, le formulaire de modification s affiche")
	public void l_admin_clique_sur_le_bouton_modifier_le_formulaire_de_modification_s_affiche(){
	    modif.choixModif();
	}
	
	@When("l admin modifie les informations suivantes :")
	public void l_admin_modifie_les_informations_suivantes(io.cucumber.datatable.DataTable dataTable) throws TimeoutException {
	   
	    Map<String, String> data = dataTable.asMap(String.class, String.class);
	    
	    String Categorie = data.get("Catégorie");
	    String Emoji = data.get("Emoji");
	   
	    
	    String Prix = data.get("Prix");
	    String Quantite = data.get("Quantité");
	  
	      // ou null
	    String date= "Date";
	    String nom = data.get("Nom du repas");
	    
	    AjouterRepasAvecNomExistantPage modifrepas = new AjouterRepasAvecNomExistantPage();
	    modifrepas.ajouterRepasavecleschamps(
	        nom, 
	        Categorie, 
	        Integer.parseInt(Prix), 
	        Integer.parseInt(Quantite)
	    );
	    ModifierUnRepas modif= new ModifierUnRepas();
	   modifrepas.selectionnerEmoji(data.get("Emoji"));
	    modif.sasirdescription(data.get("Catégorie"));
	    
	   modifrepas.sasirdescription(data.get("Description"));
	   modif.ModifierDate(data.get("Date"));
	   
	}
	
	@Then("l'admin clique sur le bouton modifier le repas")
	public void l_admin_clique_sur_le_bouton_modifier_le_repas() {
	   modif.modif();
	  // Config.driver.quit();
	}


}
