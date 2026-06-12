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
	@FindBy (xpath="/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div/div/div/button[2]")
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
wait = new WebDriverWait(Config.driver, Duration.ofSeconds(90));
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
	public void ClickOnbtnBus() {
		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(AjouterBus_btn));
        AjouterBus_btn.click();
        
	}
	
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
		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(navigation_btn));
        navigation_btn.click();
        
	}
	public void ClickOnbtchauff() {
		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(chauff_btn));
        chauff_btn.click();
        
	}
	public void verifAffichagechaufPage(String text) {
		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOf(verifchauf));
	    String textActual = verifchauf.getText();
	    Assert.assertEquals(text, textActual); 
	}
}
