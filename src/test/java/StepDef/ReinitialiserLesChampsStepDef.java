package StepDef;

import Pages.ReinitialiserLesChamps;
import io.cucumber.java.en.Then;

public class ReinitialiserLesChampsStepDef {

	

@Then("l admin reinitialise les champs en cliquant sur le bouton réinitialiser")
public void l_admin_reinitialise_les_champs_en_cliquant_sur_le_bouton_réinitialiser() throws InterruptedException {
	ReinitialiserLesChamps reinti= new ReinitialiserLesChamps();
	reinti.reinitialisationchamp();
}
}
