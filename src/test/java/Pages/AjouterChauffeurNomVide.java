package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.Config;

public class AjouterChauffeurNomVide {

	@FindBy (css="body > div.MuiDialog-root.MuiModal-root.css-zuei8q > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiBox-root.css-1wcaknn > div > div:nth-child(2) > div > input")
	WebElement NomChauffeur;
	@FindBy( xpath="/html/body/div[3]/div[3]/div/div[2]/div/div[2]/div/input")
	WebElement PrenomChauffeur;
	@FindBy (xpath="/html/body/div[3]/div[3]/div/div[2]/div/div[3]/div/input")
	WebElement EmailChauff;
	@FindBy(xpath="/html/body/div[3]/div[3]/div/div[2]/div/div[4]/div/input")
	WebElement CINChauff;
	@FindBy(xpath="/html/body/div[3]/div[3]/div/div[2]/div/div[5]/div/input")
	WebElement TelChauff;
	@FindBy (xpath="/html/body/div[3]/div[3]/div/div[2]/div/div[5]/div/div[2]/div")
	WebElement CodePaysChauff;
	@FindBy (xpath="/html/body/div[3]/div[3]/div/div[2]/div/div[6]/div/input")
	WebElement AdresseChauff;
	@FindBy (xpath=" /html/body/div[3]/div[3]/div/div[2]/div/div[7]/div/div/div[1]/div[2]/input")
	WebElement PaysChauff;
	@FindBy (xpath="/html/body/div[3]/div[3]/div/div[2]/div/div[8]/div/div/div[1]/div[2]/input")
	WebElement VilleChauff;
	@FindBy ( xpath="/html/body/div[3]/div[3]/div/div[3]/button[2]")
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

NomChauffeur.clear();
NomChauffeur.sendKeys(nom); // ✅ vide si nom = ""

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
	
	public void selectionnerVille(String Ville) {
	    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));
	    JavascriptExecutor js = (JavascriptExecutor) Config.driver;

	    // 1. Cliquer sur le dropdown Pays
	    WebElement dropdownPays = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//label[contains(text(),'Ville')]/following-sibling::div | //select[contains(@name,'Ville') or contains(@name,'town')]")
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
	            By.xpath("//*[contains(text(),'" + Ville + "')]")
	        )
	    );
	    js.executeScript("arguments[0].scrollIntoView(true);", option);
	    try { Thread.sleep(300); } catch (Exception e) {}
	    option.click();
	    System.out.println(">>> ✅ Pays sélectionné : " + Ville);
	}
}
