package Pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.Config;

public class ReinitialiserLesChamps {
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[2]/div[5]/button")
	WebElement Initibt;
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div")
	WebElement NomEtud;
	@FindBy (xpath="/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[2]/div[2]/div/div/input")
	WebElement dateDebut;
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[2]/div[3]/div/div/input")
	WebElement dateFin;

	public  ReinitialiserLesChamps() {
		PageFactory.initElements(Config.driver,this);
	}
	
	public void reinitialisationchamp() throws InterruptedException{
	    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(30));
	    Actions actions = new Actions(Config.driver);
	    
	    // Cliquer sur réinitialiser
	    wait.until(ExpectedConditions.elementToBeClickable(Initibt));
	    actions.moveToElement(Initibt).click().perform();
	    
	    Thread.sleep(9000);
	    
	    String valeurEtudiant = NomEtud.getAttribute("value");
	    String valeurDebut = dateDebut.getAttribute("value");
	    String valeurFin = dateFin.getAttribute("value");
	    
	    java.time.LocalDate today = java.time.LocalDate.now();
	    String dateDuJour = today.toString();
	    
	    System.out.println("Date du jour attendue: " + dateDuJour);
	    System.out.println("Valeur début trouvée: " + valeurDebut);
	    System.out.println("Valeur fin trouvée: " + valeurFin);
	    
	    // Vérification flexible
	    boolean etudiantVide = (valeurEtudiant == null || valeurEtudiant.trim().isEmpty());
	    boolean debutOK = (valeurDebut == null || valeurDebut.isEmpty() || valeurDebut.equals(dateDuJour));
	    boolean finOK = (valeurFin == null || valeurFin.isEmpty() || valeurFin.equals(dateDuJour));
	    
	    Assert.assertTrue("❌ Champ Étudiant non vide", etudiantVide);
	    Assert.assertTrue("❌ Date début invalide (devrait être vide ou " + dateDuJour + ")", debutOK);
	    Assert.assertTrue("❌ Date fin invalide (devrait être vide ou " + dateDuJour + ")", finOK);
	    
	    System.out.println(">>> ✅ Test réussi");
	   Config.driver.quit();
	}
	
}
