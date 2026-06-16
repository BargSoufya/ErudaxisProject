package Pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.Config;

public class SynthesePaiement {
@FindBy(css="#root > div.MuiDrawer-root.MuiDrawer-docked.css-oqf4fq > div")
WebElement NomEtud;
@FindBy (xpath="/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[2]/div[2]/div/div/input")
WebElement dateDebut;
@FindBy(xpath="/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[2]/div[3]/div/div/input")
WebElement dateFin;
@FindBy(xpath="/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[2]/div[4]/button")
WebElement Rechechebt;


@FindBy(css="#root > div:nth-child(2) > div > div > div > div > div.MuiBox-root.css-7i2kq9 > div > div > h6")
WebElement PortailGE;

public  SynthesePaiement() {
	PageFactory.initElements(Config.driver,this);
}
public void selectionnerEtudiant (String etud) {
// 	WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));
// 	JavascriptExecutor js = (JavascriptExecutor) Config.driver;

// 	// 1. Localiser l'input étudiant (pas le WebElement PageFactory)
// 	By Etud = By.xpath("//input[@type='text']");

// 	// 2. Attendre + cliquer
// 	WebElement input = wait.until(ExpectedConditions.elementToBeClickable(Etud));
// 	input.click();

// 	// 3. Taper pour déclencher la liste
// 	input.sendKeys("Nour");

// 	// 4. Attendre l’option dans la liste dynamique
// 	By optionEtud = By.xpath("//li[contains(@class,'MuiAutocomplete-option') and contains(text(),'Nour')]");

// 	WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionEtud));

// 	// 5. Scroll (optionnel mais safe)
// 	js.executeScript("arguments[0].scrollIntoView(true);", option);

// 	// 6. Cliquer
// 	option.click();
// System.out.println(">>> ✅ Étudiant sélectionné : " + etud);
	WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));
    
    WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.cssSelector("input[placeholder='Sélectionner un étudiant...']")
    ));
    
    // Fermer tout overlay éventuel d'abord
    ((JavascriptExecutor) Config.driver).executeScript("arguments[0].scrollIntoView(true);", input);
    ((JavascriptExecutor) Config.driver).executeScript("arguments[0].click();", input);
    
    input.sendKeys(etud);
    
    // Attendre et cliquer sur la suggestion
    WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//li[contains(@class,'MuiAutocomplete-option') and contains(.,'" + etud + "')]")
    ));
    suggestion.click();
    System.out.println("Étudiant sélectionné : " + etud + " ✅");
}

public void selectionnerDateDebut( String dateD) {
	WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));

    wait.until(ExpectedConditions.elementToBeClickable(dateDebut));
    ((JavascriptExecutor) Config.driver).executeScript(
    	    "arguments[0].value='';", dateDebut
    	);
    dateDebut.sendKeys(dateD);
    
}
    
public void selectionnerDateFin(String dateF) {
	WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));

    wait.until(ExpectedConditions.elementToBeClickable(dateFin));
    ((JavascriptExecutor) Config.driver).executeScript(
    	    "arguments[0].value='';", dateFin);
    dateFin.sendKeys(dateF);
}
  public void ClickOnRecherche() {
    	
	  WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));
	    Actions actions = new Actions(Config.driver);
	    
	    wait.until(ExpectedConditions.elementToBeClickable(Rechechebt));
	    actions.moveToElement(Rechechebt).click().perform();
    }
   

  

  public void verifierPageAffichee(String titrePage) {
	    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(10));

	    // 1. Attendre que la page soit chargée
	    wait.until(webDriver -> ((JavascriptExecutor) webDriver)
	        .executeScript("return document.readyState").equals("complete"));

	    // 2. Vérifier que le titre contient le texte attendu
	    boolean found =
	        Config.driver.getTitle().toLowerCase().contains(titrePage.toLowerCase()) ||
	        Config.driver.getPageSource().toLowerCase().contains(titrePage.toLowerCase());

	    System.out.println(">>> URL     : " + Config.driver.getCurrentUrl());
	    System.out.println(">>> Titre   : " + Config.driver.getTitle());

	    Assert.assertTrue(
	        "❌ Page '" + titrePage + "' non affichée",
	        found
	    );
	    System.out.println(">>> ✅ Page affichée : " + titrePage);
	}
  
  
}
