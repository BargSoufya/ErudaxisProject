package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.Config;

public class AjouterChauffeurNomVide {

	@FindBy (css="body > div.MuiDialog-root.MuiModal-root.css-zuei8q > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiBox-root.css-1wcaknn > div > div:nth-child(2) > div > input")
	WebElement NomChauffeur;
	@FindBy( css="body > div.MuiDialog-root.MuiModal-root.css-zuei8q > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiBox-root.css-1wcaknn > div > div:nth-child(1) > div > input")
	WebElement PrenomChauffeur;
	@FindBy (css="body > div.MuiDialog-root.MuiModal-root.css-zuei8q > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiBox-root.css-1wcaknn > div > div:nth-child(3) > div > input")
	WebElement EmailChauff;
	@FindBy(css="body > div.MuiDialog-root.MuiModal-root.css-zuei8q > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiBox-root.css-1wcaknn > div > div:nth-child(4) > div > input")
	WebElement CINChauff;
	@FindBy(css="body > div.MuiDialog-root.MuiModal-root.css-zuei8q > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiBox-root.css-1wcaknn > div > div:nth-child(5) > div > input")
	WebElement TelChauff;
	@FindBy (css="body > div.MuiDialog-root.MuiModal-root.css-zuei8q > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiBox-root.css-1wcaknn > div > div:nth-child(5) > div > div.flag-dropdown > div")
	WebElement CodePaysChauff;
	@FindBy (css="body > div.MuiDialog-root.MuiModal-root.css-zuei8q > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiBox-root.css-1wcaknn > div > div:nth-child(6) > div > input")
	WebElement AdresseChauff;
	@FindBy (css="#react-select-4-input")
	WebElement PaysChauff;
	@FindBy (css="#react-select-5-input")
	WebElement VilleChauff;
	@FindBy ( css="body > div.MuiDialog-root.MuiModal-root.css-zuei8q > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiBox-root.css-1in0jwz > button.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.css-5xrksu")
	WebElement CreerChauff;
	@FindBy (xpath="/html/body/div[3]/div[3]/div/div[3]/button[1]")
	WebElement Annuler;
	
	public AjouterChauffeurNomVide () {
		PageFactory.initElements(Config.driver, this);
	}
	
	
	public void saisirlesChamps(String prenom, String nom, String email, 
            String cin, String phoneNumber, String adresse) {
WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(10));

wait.until(ExpectedConditions.elementToBeClickable(PrenomChauffeur));
PrenomChauffeur.clear();
PrenomChauffeur.sendKeys(prenom);

//NomChauffeur.clear();
//NomChauffeur.sendKeys(nom); // ✅ vide si nom = ""

EmailChauff.clear();
EmailChauff.sendKeys(email);

CINChauff.clear();
CINChauff.sendKeys(cin);

TelChauff.clear();
TelChauff.sendKeys(phoneNumber);

AdresseChauff.clear();
AdresseChauff.sendKeys(adresse);

System.out.println(">>> ✅ Champs saisis");
}

	
	public void NomVide( ) {
		NomChauffeur.sendKeys("");
	}
	public void selectionnerPays(String pays) {
	    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));
	    JavascriptExecutor js = (JavascriptExecutor) Config.driver;

	    // 1. Cliquer sur le dropdown Pays
	    WebElement dropdownPays = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//label[contains(text(),'Pays')]/following-sibling::div | //select[contains(@name,'pays') or contains(@name,'country')]")
	        )
	    );
	    js.executeScript("arguments[0].scrollIntoView(true);", dropdownPays);
	    try { Thread.sleep(500); } catch (Exception e) {}
	    dropdownPays.click();
	    System.out.println(">>> ✅ Dropdown Pays ouvert");

	    try { Thread.sleep(1000); } catch (Exception e) {}

	    // 2. Sélectionner le pays dans la liste
	    WebElement option = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//*[contains(text(),'" + pays + "')]")
	        )
	    );
	    js.executeScript("arguments[0].scrollIntoView(true);", option);
	    try { Thread.sleep(300); } catch (Exception e) {}
	    option.click();
	    System.out.println(">>> ✅ Pays sélectionné : " + pays);
	}
	
	public void selectionnerVille(String ville) {
	    JavascriptExecutor js = (JavascriptExecutor) Config.driver;
	    
	    try {
	        List<WebElement> allInputs = Config.driver.findElements(By.xpath("//input"));
	        WebElement champVille = allInputs.get(7);
	        
	        // Installer un intercepteur avant la sélection
	        js.executeScript(
	            "var input = arguments[0];" +
	            "var desiredValue = arguments[1];" +
	            "input._value = input.value;" +
	            "Object.defineProperty(input, 'value', {" +
	            "    get: function() { return this._value; }," +
	            "    set: function(newVal) {" +
	            "        if(newVal === '' || newVal === null || newVal.indexOf('requise') !== -1) {" +
	            "            console.log('Blocage effacement');" +
	            "            return;" +
	            "        }" +
	            "        this._value = newVal;" +
	            "    }" +
	            "});",
	            champVille, ville
	        );
	        
	        // Sélection normale
	        champVille.click();
	        Thread.sleep(300);
	        champVille.clear();
	        champVille.sendKeys(ville);
	        Thread.sleep(1500);
	        
	        // Sélectionner l'option
	        List<WebElement> options = Config.driver.findElements(By.xpath("//li[contains(text(), '" + ville + "')]"));
	        if (!options.isEmpty()) {
	            options.get(0).click();
	            System.out.println(">>> Option cliquée");
	            Thread.sleep(500);
	        }
	        
	        // Forcer la valeur finale
	        js.executeScript("arguments[0].value = arguments[1];", champVille, ville);
	        
	        Thread.sleep(500);
	        
	        String valeurFinale = champVille.getAttribute("value");
	        System.out.println(">>> Ville finale: '" + valeurFinale + "'");
	        
	    } catch (Exception e) {
	        System.err.println("❌ Erreur: " + e.getMessage());
	    }
	}
	public void clickOncreerbt(){		
		CreerChauff.click();
		}
	public void selectionnerIndicatif() {
	    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));
	    
	    try {
	        WebElement indicatifField = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                By.xpath("//input[@value=''] | //label[contains(text(), 'Flag')]/following-sibling::div//input")
	            )
	        );
	        indicatifField.click();
	        Thread.sleep(500);
	        
	        WebElement franceIndicatif = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                By.xpath("//li[contains(text(), '+33')] | //li[contains(text(), 'France')]")
	            )
	        );
	        franceIndicatif.click();
	        System.out.println(">>> ✅ Indicatif +33 (France) sélectionné");
	        
	    } catch (Exception e) {
	        System.err.println("❌ Erreur indicatif: " + e.getMessage());
	    }
	}
}
