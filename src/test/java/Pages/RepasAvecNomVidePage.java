package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.Config;

public class RepasAvecNomVidePage {

	@FindBy(xpath="/html/body/div[2]/div[3]/div/div[2]/div/div[1]/div/input")
	WebElement NomRepas;
	@FindBy (xpath="/html/body/div[2]/div[3]/div/div[2]/div/div[2]/div/div")
	WebElement Categorie;
	@FindBy(xpath="/html/body/div[2]/div[3]/div/div[2]/div/div[3]/div/button")
	WebElement	Emoji_btn;
	@FindBy (xpath = "/html/body/div[3]/div[3]/div/div[2]/div/div[3]/div/div/button")
	WebElement emoji;
	@FindBy(xpath="/html/body/div[2]/div[3]/div/div[2]/div/div[4]/div/input")
	WebElement DateRepas;	
	@FindBy(xpath="/html/body/div[2]/div[3]/div/div[2]/div/div[5]/div/textarea[1]")
	WebElement Description;
	@FindBy(xpath="/html/body/div[2]/div[3]/div/div[2]/div/div[6]/div/input")
	WebElement Prix;
	@FindBy (xpath="/html/body/div[2]/div[3]/div/div[2]/div/div[7]/div/input")
	WebElement Quantite;
	@FindBy (css="body > div.MuiDialog-root.MuiModal-root.css-10pksy > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiDialogActions-root.MuiDialogActions-spacing.css-1vpr2yz > button.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.css-1ljwhj3")
	WebElement creerRepas;
	@FindBy (css="body > div.MuiDialog-root.MuiModal-root.css-10pksy > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiDialogActions-root.MuiDialogActions-spacing.css-1vpr2yz > button.MuiButtonBase-root.MuiButton-root.MuiButton-outlined.MuiButton-outlinedPrimary.MuiButton-sizeMedium.MuiButton-outlinedSizeMedium.MuiButton-root.MuiButton-outlined.MuiButton-outlinedPrimary.MuiButton-sizeMedium.MuiButton-outlinedSizeMedium.css-9bzdh7")
	WebElement annuler;
	
	
	
	public RepasAvecNomVidePage() {

		PageFactory.initElements(Config.driver,this);
		}
		
	
	public void ajouterRepasavecleschamps(String date,String des,double price, int qte) {
	
		DateRepas.sendKeys(date);
		Description.sendKeys(des);
		Prix.sendKeys(String.valueOf(price));
		Quantite.sendKeys(String.valueOf(qte));
		
		
		
		
	}
	
	public void selectionnerEmoji(String emojiCible) {
	    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(10));
	    Actions act = new Actions(Config.driver);

	    // 1. Un seul clic pour ouvrir la grille
	    act.moveToElement(Emoji_btn).click().perform();

	    // 2. Attendre que les boutons emoji soient visibles
	    wait.until(
	        ExpectedConditions.numberOfElementsToBeMoreThan(
	            By.cssSelector("button.MuiButton-textPrimary"), 0
	        )
	    );

	    // 3. Trouver et cliquer sur l'emoji
	    WebElement emojiBtn = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//button[contains(@class,'MuiButton-textPrimary') " +
	                     "and normalize-space(text())='" + emojiCible + "']")
	        )
	    );
	    act.scrollToElement(emojiBtn).moveToElement(emojiBtn).click().perform();
	    System.out.println("Emoji sélectionné : " + emojiCible);

	    // 4. Attendre que la grille se ferme après sélection
	    wait.until(
	        ExpectedConditions.invisibilityOfElementLocated(
	            By.cssSelector("button.MuiButton-textPrimary")
	        )
	    );
	    System.out.println("Grille emoji fermée ✅");
	}


	public void selectionnerCatg(String cat) {
	    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(10));
	    JavascriptExecutor js = (JavascriptExecutor) Config.driver;
	    Actions act = new Actions(Config.driver);

	    // 1. S'assurer que la grille emoji est bien fermée
	    try {
	        wait.until(
	            ExpectedConditions.invisibilityOfElementLocated(
	                By.cssSelector("button.MuiButton-textPrimary")
	            )
	        );
	    } catch (Exception e) {
	        // Fermer par Escape si toujours ouverte
	        act.sendKeys(org.openqa.selenium.Keys.ESCAPE).perform();
	        
	    }

	    // 2. Fermer le backdrop MUI si présent
	    try {
	        WebElement backdrop = Config.driver.findElement(
	            By.cssSelector(".MuiBackdrop-root")
	        );
	        if (backdrop.isDisplayed()) {
	            backdrop.click();
	            wait.until(
	                ExpectedConditions.invisibilityOfElementLocated(
	                    By.cssSelector(".MuiBackdrop-root")
	                )
	            );
	        }
	    } catch (Exception e) {
	        // Pas de backdrop, on continue
	    }

	    // 3. Cliquer sur le select MUI
	    WebElement select = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.cssSelector(".MuiSelect-select")
	        )
	    );
	    act.scrollToElement(select).moveToElement(select).click().perform();

	    // 4. Attendre que le listbox soit visible
	    wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            By.cssSelector("ul[role='listbox']")
	        )
	    );

	    // 5. Mapper le texte
	    String optionText;
	    switch (cat.toLowerCase().trim()) {
	        case "petit dejeuner":
	        case "petit déjeuner":
	            optionText = "Petit-déjeuner";
	            break;
	        case "gouter matin":
	        case "goûter matin":
	        case "gouter du matin":
	        case "goûter du matin":
	            optionText = "Goûter matin";
	            break;
	        case "dejeuner":
	        case "déjeuner":
	            optionText = "Déjeuner";
	            break;
	        case "gouter l'apres midi":
	        case "gouter l'après midi":
	        case "goûter l'apres midi":
	        case "goûter l'après midi":
	        case "goûter l'après-midi":
	            optionText = "Goûter l'après-midi";
	            break;
	        case "diner":
	        case "dîner":
	            optionText = "Dîner";
	            break;
	        default:
	            throw new IllegalArgumentException("Option inconnue : " + cat);
	    }

	    // 6. Cliquer sur l'option
	    WebElement option = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//ul[@role='listbox']//li[normalize-space(text())='" + optionText + "']")
	        )
	    );
	    js.executeScript("arguments[0].click();", option);
	    System.out.println("Catégorie sélectionnée : " + cat);
	    act.moveToElement(NomRepas).click().perform();
	    Config.attente(1);
	}
	
	public void sasirdescription ( String text ) {
		Description.clear();
		
		Actions act = new Actions (Config.driver);
		
		act.moveToElement(Description).click().keyDown(org.openqa.selenium.Keys.CONTROL)
	       .sendKeys("a")
	       .keyUp(org.openqa.selenium.Keys.CONTROL)
	       .sendKeys(org.openqa.selenium.Keys.BACK_SPACE)
	       .sendKeys(text)
	       .perform();

	}
	public void nomvide () {
		NomRepas.sendKeys("");
		
	}
	
	public void selectionnerDate(String date) {
		 JavascriptExecutor js = (JavascriptExecutor) Config.driver;
		    Actions act = new Actions(Config.driver);

		    // Séparer la date
		    String[] parts = date.split("/");
		    String jour  = parts[0];
		    String mois  = parts[1];
		    String annee = parts[2];

		    // 1. Cliquer sur le champ
		    act.moveToElement(DateRepas).click().perform();
		    Config.attente(1);

		    // 2. Saisir via sendKeys dans l'ordre MM/DD/YYYY
		    
		    DateRepas.sendKeys(jour);
		    DateRepas.sendKeys(mois);
		    DateRepas.sendKeys(annee);

		    // 3. Confirmer avec TAB pour valider dans React
		    DateRepas.sendKeys(org.openqa.selenium.Keys.TAB);
		    Config.attente(1);

		    System.out.println("Date saisie : " + jour + "/" + mois + "/" + annee + " ✅");
	}


	 
	
	
	//	public void ajouterRepas() {
		   // WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));
		  //  Actions act = new Actions(Config.driver);
		    
		 //   wait.until(ExpectedConditions.elementToBeClickable(creerRepas));
		 //   act.moveToElement(creerRepas).click().perform();
	   
	//}
	
	public void ajouterRepas() {
	    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));
	    
	    // Attendre que l'animation du dialog soit terminée
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	        By.cssSelector(".MuiDialog-container[style*='opacity: 0']")
	    ));
	    
	    // Attendre que le bouton soit cliquable
	    wait.until(ExpectedConditions.elementToBeClickable(creerRepas));
	    
	    // Cliquer via JavaScript pour éviter l'interception
	    ((JavascriptExecutor) Config.driver).executeScript("arguments[0].scrollIntoView(true);", creerRepas);
	    ((JavascriptExecutor) Config.driver).executeScript("arguments[0].click();", creerRepas);
	}
	//public void messgaederreur(String text) {
		
	//	Alert alert = Config.driver.switchTo().alert();
	//	String msg= alert.getText();
	//	System.out.println("Echec!veuillez sasir le nom du repas " +msg);
	//	alert.accept();
	//	alert.dismiss();
	//}
	
		public void annulerlajout() {
		    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));
		    Actions act = new Actions(Config.driver);

		    wait.until(ExpectedConditions.elementToBeClickable(annuler));
		    act.moveToElement(annuler).click().perform();
		
		}
		
		public void verifierMessageErreur() {
		    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(10));
		    
		    WebElement messageErreur = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//*[contains(text(),'obligatoire') or contains(text(),'requis') or contains(text(),'required')]")
		    ));
		    
		    System.out.println("Message d'erreur affiché : " + messageErreur.getText());
		    assert messageErreur.isDisplayed() : "Le message d'erreur n'est pas affiché !";
		}

}
