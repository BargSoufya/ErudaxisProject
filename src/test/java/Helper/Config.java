package Helper;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Config {

    public static WebDriver driver;
    public static void Maximaize() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless=new");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--disable-gpu");
    options.addArguments("--window-size=1920,1080");
    options.addArguments("--remote-allow-origins=*");
    options.addArguments("--disable-extensions");
    options.addArguments("--disable-software-rasterizer");

    driver = new ChromeDriver(options);  // ← driver created HERE with all flags
}

    public static void attente(int s) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(s));
    }

    public static WebElement waitForVisibility(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitAndClick(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void waitForUrlContains(String url, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.urlContains(url));
    }

    public static void jsClick(WebElement el) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    public static WebElement waitAndFind(String text) {
        String xpath;
        if (text.contains("'")) {
            xpath = "//*[contains(text(),\"" + text + "\")]";
        } else {
            xpath = "//*[normalize-space(text())='" + text + "']";
        }
        return new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    // ── Navigate directly to a URL and wait for page to load
    public static void navigateTo(String url) {
        driver.get(url);
        attent(20);
        System.out.println("Navigated to: " + driver.getCurrentUrl());
    }

    // ── Wait for element to be clickable then click (no JS)
    public static void clickElement(WebElement element, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
            .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    // ── Wait for element visibility then get its text
    public static String getTextOf(WebElement element, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
            .until(ExpectedConditions.visibilityOf(element));
        return element.getText().trim();
    }

    // ── Clear a field and type new value
    public static void clearAndType(WebElement element, String text) {
        waitForVisibility(element, 10);
        element.click();
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.clear();
        element.sendKeys(text);
    }
}
