package Helper;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Config {

    public static WebDriver driver;

    // ✅ Crée le driver AVANT de pouvoir le manipuler
    public static void initialiserDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    public static void Maximize() {
        if (driver == null) {
            // ✅ Sécurité : si jamais Maximize est appelé sans init, on initialise
            initialiserDriver();
        }
        driver.manage().window().maximize();
    }

    public static void attente(int s) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(s));
    }
}
