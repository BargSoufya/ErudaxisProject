package Pages;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.Config;

public class ModifierUnRepas {

	@FindBy(css="#tabpanel-0 > div.MuiBox-root.css-1hdbc19 > div:nth-child(1) > div.MuiCollapse-root.MuiCollapse-vertical.MuiCollapse-entered.css-c4sutr > div > div > div > div > div > div > div > div.MuiBox-root.css-15bqc0t > button > svg")
	WebElement Menurepas;
	@FindBy(xpath="//ul[@role='menu']//li[normalize-space(text())='Modifier']")
	WebElement modifier_bt;
	@FindBy(xpath="/html/body/div[3]/div[3]/div/div[2]/div/div[1]/div/input")
	WebElement Nomrepas;
	@FindBy(css="body > div.MuiDialog-root.MuiModal-root.css-10pksy > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiDialogContent-root.css-12of8pw > div > div:nth-child(2) > div > div > div")
	WebElement catg;
	@FindBy(xpath="/html/body/div[3]/div[3]/div/div[2]/div/div[3]/div/button/span")
	WebElement emoji;
	@FindBy(css="body > div.MuiDialog-root.MuiModal-root.css-10pksy > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiDialogContent-root.css-12of8pw > div > div:nth-child(4) > div > input")
	WebElement date;
	@FindBy(css="body > div.MuiDialog-root.MuiModal-root.css-10pksy > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiDialogContent-root.css-12of8pw > div > div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-12.css-1uo6sxl > div > textarea:nth-child(1)")
	WebElement description;
	@FindBy(xpath="/html/body/div[3]/div[3]/div/div[2]/div/div[6]/div/input")
	WebElement prix;
	@FindBy(xpath="/html/body/div[3]/div[3]/div/div[2]/div/div[7]/div/input")
	WebElement qte;
	@FindBy(css="body > div.MuiDialog-root.MuiModal-root.css-10pksy > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiDialogActions-root.MuiDialogActions-spacing.css-1vpr2yz > button.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.css-1ljwhj3")
	WebElement modif_bt;
	@FindBy(xpath="/html/body/div[3]/div[3]/div/div[3]/button[1]")
	WebElement anuler_bt;
	
	
	public ModifierUnRepas () {
		PageFactory.initElements(Config.driver,this);
	}
	
// 	public void Menu()  {
		
// 	//Menurepas.click();
// 		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));

// // wait.until(ExpectedConditions.elementToBeClickable(
// //     By.xpath("//div[@role='tabpanel']//button//*[name()='svg']")
// // )).click();
// 		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
//     By.xpath("//div[@role='tabpanel']//button")));
// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
// wait.until(ExpectedConditions.elementToBeClickable(element));
// try {
//     element.click();
// } catch (Exception e) {
//     ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
// }
		
// 	}
	public void Menu()  {
    // WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));

    // WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
    //     By.xpath("//div[@role='tabpanel']//button")));

    // ((JavascriptExecutor) Config.driver).executeScript("arguments[0].scrollIntoView(true);", element); // ✅
    // wait.until(ExpectedConditions.elementToBeClickable(element));

    // try {
    //     element.click();
    // } catch (Exception e) {
    //     ((JavascriptExecutor) Config.driver).executeScript("arguments[0].click();", element); // ✅
    // }

		 // WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));

   //  WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
   //      By.xpath("//div[@role='tabpanel']//button")));

   //  ((JavascriptExecutor) Config.driver).executeScript("arguments[0].scrollIntoView(true);", element);
   //  wait.until(ExpectedConditions.elementToBeClickable(element));

   //  try {
   //      element.click();
   //  } catch (Exception e) {
   //      ((JavascriptExecutor) Config.driver).executeScript("arguments[0].click();", element);
   //  }
    
   //  // ✅ Attendre que le menu popup soit bien ouvert
   //  wait.until(
   //      ExpectedConditions.visibilityOfElementLocated(
   //          By.xpath("//ul[@role='menu']")
   //      )
   //  );
   //  System.out.println("Menu ouvert ✅");
		  //  WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));

    // // Trouver le bouton 3 points (svg inside button)
    // WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
    //     By.xpath("//div[@role='tabpanel']//button[.//*[name()='svg']]")
    // ));

    // ((JavascriptExecutor) Config.driver).executeScript("arguments[0].scrollIntoView(true);", element);
    // Config.attente(1);
    // ((JavascriptExecutor) Config.driver).executeScript("arguments[0].click();", element);

    // // Attendre le menu — essayer les deux rôles possibles
    // wait.until(ExpectedConditions.visibilityOfElementLocated(
    //     By.xpath("//ul[@role='menu'] | //ul[@role='listbox']")
    // ));
    // System.out.println("Menu ouvert ✅");
		WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));
    
    // Scroll to the element first
    WebElement threeDots = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("//button[contains(@class, 'MuiIconButton-root')]//*[local-name()='svg']")
    ));
    
    // Scroll into view
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", threeDots);
    
    // Wait for clickability
    wait.until(ExpectedConditions.elementToBeClickable(threeDots)).click();
}
	
	public void choixModif() {
		// modifier_bt.click();
		 WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(10));
    Actions act = new Actions(Config.driver);
    
    // Attendre que le menu popup soit visible puis cliquer
    WebElement modifierOption = wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath("//ul[@role='menu']//li[normalize-space(text())='Modifier']")
        )
    );
    act.moveToElement(modifierOption).click().perform();
    System.out.println("Option Modifier cliquée ✅");
	}
	
    public void ModifierDate(String date) {
        WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));
        
        // Attendre que le modal soit chargé
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        WebElement dateInput = null;
        
        // Essayer différents sélecteurs
        String[] selectors = {
            "input[type='date']",
            "input[placeholder*='Date']",
            "input[name*='date']",
            "input[id*='date']",
            "//label[contains(text(), 'Date')]/following::input[1]"
        };
        
        for (String selector : selectors) {
            try {
                if (selector.startsWith("//")) {
                    dateInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selector)));
                } else {
                    dateInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
                }
                if (dateInput != null && dateInput.isDisplayed()) {
                    System.out.println("Champ date trouvé avec: " + selector);
                    break;
                }
            } catch (Exception e) {
                // Continuer
            }
        }
        
        if (dateInput == null) {
            throw new RuntimeException("Impossible de trouver le champ date");
        }
        
        dateInput.clear();
        dateInput.sendKeys(date);
        System.out.println("Date modifiée: " + date);
    }
	public void selectionnerCatg(String cat) throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));
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
	    	Thread.sleep(1000);

	    	
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
	    act.moveToElement(Nomrepas).click().perform();
	    Config.attente(1);
	}
	public void modif() {
		modif_bt.click();
	}

	public void sasirdescription ( String text ) {
		description.clear();
		
		Actions act = new Actions (Config.driver);
		
		act.moveToElement(description).click().keyDown(org.openqa.selenium.Keys.CONTROL)
	       .sendKeys("a")
	       .keyUp(org.openqa.selenium.Keys.CONTROL)
	       .sendKeys(org.openqa.selenium.Keys.BACK_SPACE)
	       .sendKeys(text)
	       .perform();

	}
	
	public void ajouterRepasavecleschamps(String Nom,String date1,double price, int quantite) {
		
		Nomrepas.clear();
		Nomrepas.sendKeys(Nom);
		date.sendKeys(date1);
		prix.clear();
		prix.sendKeys(String.valueOf(price));
		qte.clear();
		qte.sendKeys(String.valueOf(quantite));
		
		
		
		
	}
	private void modifierChamp(String nomChamp, String valeur) throws TimeoutException {
	    WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(10));
	    
	    // Construire un XPath dynamique basé sur le nom du champ
	    String xpath = String.format(
	        "//label[contains(text(), '%s')]/following::input[1] | " +
	        "//div[contains(@class, 'field')]//label[contains(text(), '%s')]/following-sibling::div//input | " +
	        "//input[@placeholder='%s'] | " +
	        "//input[@name='%s']",
	        nomChamp, nomChamp, nomChamp, nomChamp.toLowerCase()
	    );
	    
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		element.clear();
		element.sendKeys(valeur);
		System.out.println("Champ '" + nomChamp + "' modifié avec : " + valeur);
	}
	
}
