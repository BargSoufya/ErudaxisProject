package Pages;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

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

public class AjouterRepasPage {
	
	@FindBy (xpath="//span[contains(text(),'Cantine')]")
	List <WebElement>cantine;
	@FindBy (xpath="/html/body/div[1]/div[1]/div/ul/a[8]/div/div/div/ul/a/li/div/div/div/span")
	List <WebElement> Submenus;
	@FindBy ( xpath="/html/body/div/div[2]/div/div/div/div/div[1]/div[1]/h5")
	WebElement titreGestionCantine;
	@FindBy (id="add")
	WebElement AjouterRepas;
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div/div/div/div[1]")
	WebElement verifgestion;
	@FindBy(xpath = "//h5[contains(text(),'Ajouter')] | //*[contains(@class,'modal') or contains(@class,'dialog')]")
	WebElement form;
	
	
	public AjouterRepasPage() {

	PageFactory.initElements(Config.driver,this);
	}
	

	public void clickOnMenuCantine(String menuTitle) {
	    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));

	    // Attendre que les menus soient visibles
	    wait.until(ExpectedConditions.visibilityOfAllElements(cantine));

	    try {
	        for (WebElement can : cantine) {
	            System.out.println(">>> Menu trouvé : [" + can.getText() + "]");
	            	Config.attente(10);
	            if (can.getText().trim().equalsIgnoreCase(menuTitle)) {
	                ((JavascriptExecutor) Config.driver)
	                        .executeScript("arguments[0].scrollIntoView(true);", can);

	                // Attendre qu'il soit cliquable
	                wait.until(ExpectedConditions.elementToBeClickable(can));

	                // Clic avec Actions
	                Actions act = new Actions(Config.driver);
	                act.moveToElement(can).click().perform();

	                System.out.println(">>> ✅ Menu cliqué : " + menuTitle);
	                return; // stop dès qu'on trouve
	            }
	        
	        
	    
	    // Si aucun menu trouvé
	        throw new RuntimeException("❌ Menu non trouvé : " + menuTitle);
	   }
	
	  } catch (Exception e) {
	       throw new RuntimeException("❌ Erreur lors du clic sur le menu : " + menuTitle, e);
	    }
	
	
	}
	public void ClickOnSousMenu( String SubmenuTitle)  {
	    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));

	    // Attendre que les menus soient visibles
	    wait.until(ExpectedConditions.visibilityOfAllElements(cantine));

	    try {
	        for (WebElement subm: Submenus) {
				 System.out.println(">>> SousMenu trouvé : [" + subm.getText() + "]");
	            	Config.attente(20);
	            if (subm.getText().trim().equalsIgnoreCase(SubmenuTitle)){
						 ((JavascriptExecutor) Config.driver)
	                     .executeScript("arguments[0].scrollIntoView(true);", subm);
			                wait.until(ExpectedConditions.elementToBeClickable(subm));
			                Actions act = new Actions(Config.driver);
			                act.moveToElement(subm).click().perform();
	                System.out.println(">>> ✅ Menu cliqué : " + SubmenuTitle);
	                return; // stop dès qu'on trouve
	            }
	        }

	        // Si aucun menu trouvé
	        throw new RuntimeException("❌ Menu non trouvé : " + SubmenuTitle);

	    } catch (Exception e) {
	        throw new RuntimeException("❌ Erreur lors du clic sur le menu : " + SubmenuTitle, e);
	    }
	}
	
	public void verifierPageGestionCantine(String text) {
		 WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOf(titreGestionCantine));
		    String textActual = titreGestionCantine.getText();
		    Assert.assertEquals(text, textActual);                  // ✅ compare deux String

		}
	
	public void verifierSousMenuVisible(String submenuTitle) {
	    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));

	    submenuTitle = submenuTitle.replace("<", "").replace(">", "").trim();

	    // ✅ Cherche par texte au lieu du XPath absolu
	    List<WebElement> submenus = wait.until(
	    	    ExpectedConditions.visibilityOfAllElementsLocatedBy(
	    	        By.xpath("//*[contains(text(),'" + submenuTitle + "')]")
	    	    )
	    	);

	    System.out.println("Nombre de sous-menus : " + submenus.size());

	    for (WebElement subm : submenus) {
	        System.out.println(">>> Sous-menu trouvé : [" + subm.getText() + "]");

	        if (subm.getText().trim().equalsIgnoreCase(submenuTitle)) {
	            ((JavascriptExecutor) Config.driver)
	                .executeScript("arguments[0].scrollIntoView(true);", subm);
	            wait.until(ExpectedConditions.elementToBeClickable(subm));
	            subm.click();
	            System.out.println("✅ Sous-menu cliqué : " + submenuTitle);
	            return;
	        }
	    }

	    throw new RuntimeException("❌ Sous-menu non trouvé : " + submenuTitle);
	}
	public void ClickOnGestionCantine(String submenuTitle) {
	    if (submenuTitle == "Gestion Cantine ") {
	    	titreGestionCantine.click();
	    }
	}  
	public void VerifGestionCa(String Verif) {
		
		String Actualtext= verifgestion.getText();
		Assert.assertEquals(Verif, Actualtext);
	}
	
	public void ClickOnbtn() {
		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(AjouterRepas));
		AjouterRepas.click();
	}
	
	public void AfficherForm() {
	    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));

	    // ✅ Cherche par texte au lieu du XPath absolu
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//*[contains(text(),'Ajouter un repas') or contains(text(),'Nouveau repas') or contains(text(),'Ajouter')]")
	    ));

	    System.out.println(">>> ✅ Formulaire affiché");
	}
	
	
}
