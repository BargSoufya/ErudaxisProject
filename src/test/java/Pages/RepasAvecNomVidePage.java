package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
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

public class RepasAvecNomVidePage {

	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/div/div[1]/div/input")
    WebElement NomRepas;
    
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/div/div[2]/div/div")
    WebElement Categorie;
    
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/div/div[3]/div/button")
    WebElement Emoji_btn;
    
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div[2]/div/div[3]/div/div/button")
    WebElement emoji;
    
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/div/div[4]/div/input")
    WebElement DateRepas;
    
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/div/div[5]/div/textarea[1]")
    WebElement Description;
    
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/div/div[6]/div/input")
    WebElement Prix;
    
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/div/div[7]/div/input")
    WebElement Quantite;
    
    @FindBy(css = "body > div.MuiDialog-root.MuiModal-root.css-10pksy > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiDialogActions-root.MuiDialogActions-spacing.css-1vpr2yz > button.MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.css-1ljwhj3")
    WebElement creerRepas;
    
    @FindBy(css = "body > div.MuiDialog-root.MuiModal-root.css-10pksy > div.MuiDialog-container.MuiDialog-scrollPaper.css-16u656j > div > div.MuiDialogActions-root.MuiDialogActions-spacing.css-1vpr2yz > button.MuiButtonBase-root.MuiButton-root.MuiButton-outlined.MuiButton-outlinedPrimary.MuiButton-sizeMedium.MuiButton-outlinedSizeMedium.MuiButton-root.MuiButton-outlined.MuiButton-outlinedPrimary.MuiButton-sizeMedium.MuiButton-outlinedSizeMedium.css-9bzdh7")
    WebElement annuler;
    
    private WebDriverWait wait;

    public RepasAvecNomVidePage() {
        PageFactory.initElements(Config.driver, this);
        this.wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));
    }

    /**
     * Remplit les champs du formulaire (hors nom et catégorie)
     */
    public void ajouterRepasAvecLesChamps(String date, String description, double prix, int quantite) {
        try {
            DateRepas.clear();
            Description.clear();
            Prix.clear();
            Quantite.clear();
            
            DateRepas.sendKeys(date);
            Description.sendKeys(description);
            Prix.sendKeys(String.valueOf(prix));
            Quantite.sendKeys(String.valueOf(quantite));
            
            System.out.println("✅ Champs remplis avec succès");
        } catch (Exception e) {
            System.err.println("❌ Erreur lors du remplissage des champs : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Sélectionne un emoji dans la grille
     */
    public void selectionnerEmoji(String emojiCible) {
        try {
            Actions act = new Actions(Config.driver);

            act.moveToElement(Emoji_btn).click().perform();
            System.out.println("🔄 Grille d'emojis ouverte");

            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.cssSelector("button.MuiButton-textPrimary"), 0));

            WebElement emojiBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@class,'MuiButton-textPrimary') and normalize-space(text())='" + emojiCible + "']")));
            
            act.scrollToElement(emojiBtn).moveToElement(emojiBtn).click().perform();
            System.out.println("✅ Emoji sélectionné : " + emojiCible);

            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector("button.MuiButton-textPrimary")));
            System.out.println("✅ Grille emoji fermée");

        } catch (Exception e) {
            System.err.println("❌ Erreur lors de la sélection de l'emoji : " + e.getMessage());
            throw e;
        }
    }

    /**
     * Sélectionne une catégorie dans le menu déroulant
     */
    public void selectionnerCategorie(String categorie) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Config.driver;
            Actions act = new Actions(Config.driver);

            try {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.cssSelector("button.MuiButton-textPrimary")));
            } catch (Exception e) {
                act.sendKeys(Keys.ESCAPE).perform();
                Config.attente(1);
            }

            try {
                WebElement backdrop = Config.driver.findElement(By.cssSelector(".MuiBackdrop-root"));
                if (backdrop.isDisplayed()) {
                    backdrop.click();
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".MuiBackdrop-root")));
                }
            } catch (Exception e) {
                // Pas de backdrop, on continue
            }

            WebElement select = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".MuiSelect-select")));
            act.scrollToElement(select).moveToElement(select).click().perform();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[role='listbox']")));

            String optionText = mapCategorie(categorie);

            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[@role='listbox']//li[normalize-space(text())='" + optionText + "']")));
            js.executeScript("arguments[0].click();", option);
            System.out.println("✅ Catégorie sélectionnée : " + categorie);

            act.moveToElement(NomRepas).click().perform();
            Config.attente(1);

        } catch (Exception e) {
            System.err.println("❌ Erreur lors de la sélection de la catégorie : " + e.getMessage());
            throw e;
        }
    }

    private String mapCategorie(String categorie) {
        switch (categorie.toLowerCase().trim()) {
            case "petit dejeuner":
            case "petit déjeuner":
                return "Petit-déjeuner";
            case "gouter matin":
            case "goûter matin":
            case "gouter du matin":
            case "goûter du matin":
                return "Goûter matin";
            case "dejeuner":
            case "déjeuner":
                return "Déjeuner";
            case "gouter l'apres midi":
            case "gouter l'après midi":
            case "goûter l'apres midi":
            case "goûter l'après midi":
            case "goûter l'après-midi":
                return "Goûter l'après-midi";
            case "diner":
            case "dîner":
                return "Dîner";
            default:
                throw new IllegalArgumentException("Catégorie inconnue : " + categorie);
        }
    }

    public void saisirDescription(String texte) {
        try {
            Description.clear();
            Actions act = new Actions(Config.driver);
            act.moveToElement(Description)
               .click()
               .keyDown(Keys.CONTROL)
               .sendKeys("a")
               .keyUp(Keys.CONTROL)
               .sendKeys(Keys.BACK_SPACE)
               .sendKeys(texte)
               .perform();
            System.out.println("✅ Description saisie : " + texte);
        } catch (Exception e) {
            System.err.println("❌ Erreur lors de la saisie de la description : " + e.getMessage());
            throw e;
        }
    }

    public void laisserNomVide() {
        try {
            NomRepas.clear();
            System.out.println("✅ Champ nom laissé vide");
        } catch (Exception e) {
            System.err.println("❌ Erreur lors du vidage du champ nom : " + e.getMessage());
            throw e;
        }
    }

    public void selectionnerDate(String date) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Config.driver;
            Actions act = new Actions(Config.driver);

            String[] parts = date.split("/");
            String jour = parts[0];
            String mois = parts[1];
            String annee = parts[2];

            act.moveToElement(DateRepas).click().perform();
            Config.attente(1);

            DateRepas.sendKeys(jour);
            DateRepas.sendKeys(mois);
            DateRepas.sendKeys(annee);

            DateRepas.sendKeys(Keys.TAB);
            Config.attente(1);

            System.out.println("✅ Date saisie : " + jour + "/" + mois + "/" + annee);

        } catch (Exception e) {
            System.err.println("❌ Erreur lors de la saisie de la date : " + e.getMessage());
            throw e;
        }
    }

    public void ajouterRepas() {
        try {
            try {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.cssSelector(".MuiDialog-container[style*='opacity: 0']")));
            } catch (Exception e) {
                // Pas d'animation, on continue
            }

            wait.until(ExpectedConditions.elementToBeClickable(creerRepas));

            JavascriptExecutor js = (JavascriptExecutor) Config.driver;
            js.executeScript("arguments[0].scrollIntoView(true);", creerRepas);
            js.executeScript("arguments[0].click();", creerRepas);
            
            System.out.println("✅ Bouton 'Créer le repas' cliqué");
        } catch (Exception e) {
            System.err.println("❌ Erreur lors du clic sur 'Créer le repas' : " + e.getMessage());
            throw e;
        }
    }

    public void annulerLajout() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(annuler));
            
            JavascriptExecutor js = (JavascriptExecutor) Config.driver;
            js.executeScript("arguments[0].scrollIntoView(true);", annuler);
            js.executeScript("arguments[0].click();", annuler);
            
            System.out.println("✅ Bouton 'Annuler' cliqué");
        } catch (Exception e) {
            System.err.println("❌ Erreur lors du clic sur 'Annuler' : " + e.getMessage());
            throw e;
        }
    }

    public void verifierMessageErreur() {
        try {
            WebElement messageErreur = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'obligatoire') or contains(text(),'requis') or contains(text(),'required') or contains(text(),'obligatory')]")));
            
            String message = messageErreur.getText();
            System.out.println("✅ Message d'erreur affiché : " + message);
            
            if (!messageErreur.isDisplayed()) {
                throw new AssertionError("Le message d'erreur n'est pas affiché !");
            }
        } catch (Exception e) {
            System.err.println("❌ Erreur lors de la vérification du message d'erreur : " + e.getMessage());
            throw e;
        }
    }

    public void verifierMessageErreurSpecifique(String texteAttendu) {
        try {
            WebElement messageErreur = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class,'error') or contains(@class,'Error') or contains(@class,'Mui-error') and contains(text(),'" + texteAttendu + "')]")));
            
            String message = messageErreur.getText();
            System.out.println("✅ Message d'erreur spécifique affiché : " + message);
            
            if (!message.contains(texteAttendu)) {
                throw new AssertionError("Le message d'erreur ne contient pas le texte attendu : " + texteAttendu);
            }
        } catch (Exception e) {
            System.err.println("❌ Erreur lors de la vérification du message d'erreur : " + e.getMessage());
            throw e;
        }
    }
}
