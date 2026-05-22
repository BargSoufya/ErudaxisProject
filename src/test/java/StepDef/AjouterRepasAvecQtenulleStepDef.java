package StepDef;

import Pages.AjouterRepasAvecquantitenulle;
import io.cucumber.java.en.Then;

public class AjouterRepasAvecQtenulleStepDef {

	AjouterRepasAvecquantitenulle qteNulle= new AjouterRepasAvecquantitenulle();
	@Then("l admin clique sur créer le repas et un message d erreur indique que  la quantité ne doit pas être nulle")
	public void l_admin_clique_sur_créer_le_repas_et_un_message_d_erreur_indique_que_la_quantité_ne_doit_pas_être_nulle() {
		qteNulle.creerUnrepasavecqtenulle();

	}

}
