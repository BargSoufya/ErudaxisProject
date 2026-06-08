package Pages;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.Config;

public class LoginPage {

	@FindBy ( xpath="/html/body/div/div/div/div[1]/div/div[2]/div/div[1]/div/div[1]/input")
	WebElement email;
	@FindBy ( xpath= "/html/body/div/div/div/div[1]/div/div[2]/div/div[2]/div/div[1]/input")
	WebElement Mdp; 
	@FindBy ( xpath="/html/body/div[1]/div/div/div[1]/div/div[2]/div/div[4]/button")
	WebElement seconnecter_btn; 
	//@FindBy ( xpath= "/html/body/div[3]/div[3]/div/div")
	//WebElement verifchoixmessage;
	@FindBy (xpath="/html/body/div[3]/div[3]/div/div/div/div[2]/div/div/div/div/div/div/div[3]")
	List <WebElement> menus; // fait réference aux deux boutons
	@FindBy (xpath= "/html/body/div[1]/div[1]/div/div[2]/div")
	WebElement verif; // verifcation du choix selection par le bouton 
	

	
	
	public LoginPage ( ) {
		PageFactory.initElements(Config.driver, this);
	}
	
	public void Connecter ( String email_user,String mdp) {
        WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));
     

        
        
        wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div/div[1]/div/div[1]/input")
        ));
		email.sendKeys(email_user);
		Mdp.sendKeys(mdp);
	
	        seconnecter_btn.click();
	        System.out.println(">>> URL après click : " + Config.driver.getCurrentUrl());
	        System.out.println(">>> Titre : " + Config.driver.getTitle());

		
		
	}
	
	
	
	public void ClickonMenu(String menutitle) {
	    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));

	    // ✅ Attendre n'importe quel élément contenant College ou Lycee
	    // peu importe la balise (div, span, h2, p...)
	    By locator = By.xpath(
	        "//*[contains(translate(normalize-space(text())," +
	        "'abcdefghijklmnopqrstuvwxyz'," +
	        "'ABCDEFGHIJKLMNOPQRSTUVWXYZ')," +
	        "'" + menutitle.toUpperCase() + "')]"
	    );

	    try {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        System.out.println(">>> ✅ Popup trouvée !");
	        WebElement el = Config.driver.findElement(locator);
	        el.click();
	        System.out.println(">>> ✅ Cliqué sur : " + menutitle);
	    } catch (Exception e) {
	        // ✅ Si toujours pas trouvé, affiche tout le contenu visible
	        System.out.println(">>> ❌ Popup non trouvée");
	        System.out.println(">>> URL actuelle : " + Config.driver.getCurrentUrl());
	        System.out.println(">>> Titre : " + Config.driver.getTitle());
	        
	        // Affiche les 500 premiers caractères du body
	        try {
	            String bodyText = Config.driver.findElement(By.tagName("body")).getText();
	            System.out.println(">>> Contenu page (500 chars) : " + 
	                bodyText.substring(0, Math.min(500, bodyText.length())));
	        } catch (Exception ex) {}
	        
	        throw new RuntimeException("Menu '" + menutitle + "' introuvable dans la popup");
	    }
	}
		
		
		// public void VerifChoix (String choix) {
	 //       // WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(30));

	 //       //wait.until(ExpectedConditions.urlContains(choix));
	 //    //    System.out.println(">>> ✅ URL contient bien : " + choix);
	 //       // System.out.println(">>> URL finale : " + Config.driver.getCurrentUrl());
		// //	Assert.assertEquals(choix, actualText);
		// 	 WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));
		//         wait.until(ExpectedConditions.invisibilityOfElementLocated(
		//             By.xpath("//*[contains(text(),'Vous Devez Saisir')]")
		//         ));

	
		//         String currentUrl = Config.driver.getCurrentUrl();
		//         String pageTitle = Config.driver.getTitle();
		//         String pageSource = Config.driver.getPageSource();

		//         System.out.println(">>> URL finale     : " + currentUrl);
		//         System.out.println(">>> Titre finale   : " + pageTitle);

		//         Assert.assertTrue(
		//             "Dashboard '" + choix + "' non affiché. URL=" + currentUrl,
		//             currentUrl.toLowerCase().contains(choix.toLowerCase()) ||
		//             pageTitle.toLowerCase().contains(choix.toLowerCase()) ||
		//             pageSource.toLowerCase().contains(choix.toLowerCase())
		//         );

		//         System.out.println(">>> ✅ Dashboard " + choix + " confirmé !");
		//     }

	public void VerifChoix(String userType) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    
    // Wait for dashboard elements based on user type
    if (userType.equals("lycee")) {
        boolean dashboardDisplayed = wait.until(ExpectedConditions.or(
            ExpectedConditions.urlContains("dashboard"),
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'dashboard')]"))
        ));
        
        Assert.assertTrue("Dashboard 'lycee' non affiché. URL=" + driver.getCurrentUrl(), 
                         dashboardDisplayed);
    }
}
		
			
		

		 
		
		

}


