package Pages;

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
import org.openqa.selenium.TimeoutException;


import Helper.Config;

public class AjouterUnNouveauBusPage {

	@FindBy (xpath="//span[contains(text(),'Gestion des Bus')]")
	List <WebElement> GestionBusMenu;
	@FindBy(xpath="/html/body/div[1]/div[1]/div/ul/a[9]/div/div/div/ul[1]/a/li/div/div/div/span")
	List <WebElement> SubMenus;
//@FindBy(css="#root > div:nth-child(2) > div > div > div > div > div.MuiBox-root.css-1mddhvy > h5")
	@FindBy(xpath = "//h5[contains(text(),'Liste des Bus')]")
	WebElement verif;
	@FindBy (xpath="/html/body/div[1]/div[2]/div/div/div/div/div[2]/button")
	WebElement AjouterBus_btn;
	@FindBy (xpath="//button[contains(text(),'Chauffeur') or contains(@aria-label,'Chauffeur')]")
	WebElement navigation_btn;
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div/div/div/div[2]/button")
	WebElement chauff_btn;
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div/div/div/div[2]/button")
	WebElement verifchauf;
	
	
	public  AjouterUnNouveauBusPage() {
		PageFactory.initElements(Config.driver,this);
	}
	
	public void clickOnMenubus(String menuTitle) {
	    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));

	    // Attendre que les menus soient visibles
	    wait.until(ExpectedConditions.visibilityOfAllElements(GestionBusMenu));

	    try {
	        for (WebElement bus : GestionBusMenu) {
	            System.out.println(">>> Menu trouvé : [" + bus.getText() + "]");
	            	Config.attente(10);
	            if (bus.getText().trim().equalsIgnoreCase(menuTitle)) {
	                ((JavascriptExecutor) Config.driver)
	                        .executeScript("arguments[0].scrollIntoView(true);", bus);

	                // Attendre qu'il soit cliquable
	                wait.until(ExpectedConditions.elementToBeClickable(bus));

	                // Clic avec Actions
	                Actions act = new Actions(Config.driver);
	                act.moveToElement(bus).click().perform();

	                System.out.println(">>> ✅ Menu cliqué : " + menuTitle);
	                return; // stop dès qu'on trouve
	            }
	        }

	        // Si aucun menu trouvé
	        throw new RuntimeException("❌ Menu non trouvé : " + menuTitle);

	    } catch (Exception e) {
	        throw new RuntimeException("❌ Erreur lors du clic sur le menu : " + menuTitle, e);
	    }
	}
	
	public void ClickOnSubMenuBus( String subMenuTitle) {
		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));

	    // Attendre que les menus soient visibles
	    wait.until(ExpectedConditions.visibilityOfAllElements(GestionBusMenu));
	  try {
		  for(WebElement subBus:SubMenus) {
			  if (subBus.getText().trim().equalsIgnoreCase(subMenuTitle)) {
				  ((JavascriptExecutor) Config.driver)
                  .executeScript("arguments[0].scrollIntoView(true);", subBus);
				  wait.until(ExpectedConditions.elementToBeClickable(subBus));
				  Actions act= new Actions(Config.driver);
				  act.moveToElement(subBus).click().perform();
			  }
		  }
		  
	  }catch(Exception e) {
		  
	  }
	
	
	}
// 	public void verifAffichagePage(String text) {
// 		//WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));
// 	    // wait.until(ExpectedConditions.visibilityOf(verif));
// 	    // String textActual = verif.getText();
// 	    // Assert.assertEquals(text, textActual); 
// 		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(30));
// System.out.println(Config.driver.getCurrentUrl());
// System.out.println(Config.driver.getTitle());
// wait.until(ExpectedConditions.visibilityOfElementLocated(
//     By.xpath("//h5[contains(normalize-space(),'Liste des Bus')]")
// ));
		
// 	}

	// public void verifAffichagePage(String titreAttendu) {

 //    WebDriverWait wait =
 //            new WebDriverWait(Config.driver, Duration.ofSeconds(30));

 //    System.out.println("URL actuelle : " + Config.driver.getCurrentUrl());
 //    System.out.println("Titre de la page : " + Config.driver.getTitle());

 //    wait.until(ExpectedConditions.presenceOfElementLocated(
 //            By.tagName("body")));

 //    WebElement titre = wait.until(
 //            ExpectedConditions.visibilityOfElementLocated(
 //                    By.xpath("//h5[contains(normalize-space(),'" + titreAttendu + "')]")
 //            )
 //    );

// 	public void verifAffichagePage(String titre) {

//     WebDriverWait wait =
//             new WebDriverWait(Config.driver, Duration.ofSeconds(30));

//     System.out.println("URL : " + Config.driver.getCurrentUrl());
//     System.out.println("Titre : " + Config.driver.getTitle());

//     By locator = By.xpath("//*[contains(normalize-space(),'" + titre + "')]");

//     WebElement element = wait.until(
//             ExpectedConditions.visibilityOfElementLocated(locator)
//     );

//     Assert.assertTrue(element.isDisplayed());
// }
// 	public void verifAffichagePage(String titre) {

//     WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(30));

//     By locator = By.xpath("//*[contains(.,'" + titre + "')]");

//     try {
//     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
//     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Liste des Bus')]")));
// } catch (TimeoutException e) {
//     System.out.println("URL actuelle: " + driver.getCurrentUrl());
//     throw e;
// }
// }

	public void verifAffichagePage(String titre) {

    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(45));

    try {
        // wait.until(ExpectedConditions.visibilityOfElementLocated(
        //     By.xpath("//*[contains(text(),'Liste des Bus')]")));
wait = new WebDriverWait(Config.driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.or(
    	ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//*[contains(translate(text(),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'LISTE DES BUS')]")
    ),
    	ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//*[contains(@class,'MuiTypography') and contains(text(),'Bus')]")
   			 )
		));
    } catch (org.openqa.selenium.TimeoutException e) {
        System.out.println("URL actuelle: " + Config.driver.getCurrentUrl());
        throw e;
    }
}
	// public void ClickOnbtnBus() {
	// 	// WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));
 //  //       wait.until(ExpectedConditions.elementToBeClickable(AjouterBus_btn));
 //  //       AjouterBus_btn.click();
	// 	 WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));
 //    WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(
 //        By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/button")
 //    ));
 //    ((JavascriptExecutor) Config.driver).executeScript("arguments[0].scrollIntoView(true);", btn);
 //    ((JavascriptExecutor) Config.driver).executeScript("arguments[0].click();", btn);
 //    System.out.println("Bouton Bus cliqué ✅");
        
	// }

	public void ClickOnbtnBus() {
    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));

    // ✅ Remplace le XPath absolu par une recherche par texte
    WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("//button[contains(text(),'Ajouter') or contains(text(),'ajouter')]")
    ));

    ((JavascriptExecutor) Config.driver).executeScript("arguments[0].scrollIntoView(true);", btn);
    try { Thread.sleep(500); } catch (Exception e) {}
    ((JavascriptExecutor) Config.driver).executeScript("arguments[0].click();", btn);
    System.out.println("Bouton Bus cliqué ✅");
}Ce qui a été corrigé LigneAvantAprèsBy.xpath(...)/html/body/div[1]/div[2]/div/div/div/div/div[2]/button//button[contains(text(),'Ajouter')...]Si "Ajouter" ne suffit pas — debug pour trouver le vrai texteSi ça échoue encore, remplace temporairement par cette version qui affiche tous les boutons visibles :javapublic void ClickOnbtnBus() {
    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));

    try {
        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//button[contains(text(),'Ajouter') or contains(text(),'ajouter')]")
        ));
        ((JavascriptExecutor) Config.driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        try { Thread.sleep(500); } catch (Exception e) {}
        ((JavascriptExecutor) Config.driver).executeScript("arguments[0].click();", btn);
        System.out.println("Bouton Bus cliqué ✅");
    } catch (Exception e) {
        System.out.println(">>> ❌ Bouton non trouvé. Boutons visibles :");
        Config.driver.findElements(By.tagName("button")).forEach(b -> {
            try {
                if (b.isDisplayed())
                    System.out.println("  >>> [" + b.getText() + "]");
            } catch (Exception ex) {}
        });
        throw e;
    }
}Relance et copie les lignes >>> [...] pour qu'on confirme le texte exact du bouton.
	
	public void verifierSousMenuVisible(String submenuTitle) {
	    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));

	    submenuTitle = submenuTitle.replace("<", "").replace(">", "").trim();

	    List<WebElement> submenus = wait.until(
	        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[1]/div[1]/div/ul/a[9]/div/div/div/ul[1]/a/li/div/div/div/span"))
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
	public void AfficherForm() {
		 WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOf(verif));
	     Config.driver.quit();
	}
	
	public void ClickOnbtnavigation() {
		// WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));
  //   // Le 2ème bouton dans la barre de navigation (index 2)
  //   WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(
  //       By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div/div/div/button[2]")
  //   ));
  //   ((JavascriptExecutor) Config.driver).executeScript("arguments[0].scrollIntoView(true);", btn);
  //   ((JavascriptExecutor) Config.driver).executeScript("arguments[0].click();", btn);
  //   System.out.println("Navigation Chauffeur cliquée ✅");
		  WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));
    
    // Try different possible selectors
    By navigationButton = By.xpath("//button[contains(text(), 'Chauffeur')]");
    By navigationButtonAlt = By.cssSelector("button.navigation-button");
    By navigationButtonAlt2 = By.xpath("//div[@class='navigation']//button[2]");
    
    try {
        wait.until(ExpectedConditions.elementToBeClickable(navigationButton)).click();
    } catch (TimeoutException e) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(navigationButtonAlt)).click();
        } catch (TimeoutException e2) {
            wait.until(ExpectedConditions.elementToBeClickable(navigationButtonAlt2)).click();
        }
    }
        
	}
	public void ClickOnbtchauff() {
		// WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));
  //       wait.until(ExpectedConditions.elementToBeClickable(chauff_btn));
  //       chauff_btn.click();

		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));
    WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/button")
    ));
    ((JavascriptExecutor) Config.driver).executeScript("arguments[0].scrollIntoView(true);", btn);
    ((JavascriptExecutor) Config.driver).executeScript("arguments[0].click();", btn);
    System.out.println("Bouton Chauffeur cliqué ✅");
        
	}
	public void verifAffichagechaufPage(String text) {
		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOf(verifchauf));
	    String textActual = verifchauf.getText();
	    Assert.assertEquals(text, textActual); 
	}
}
