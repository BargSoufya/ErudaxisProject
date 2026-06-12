package Helper;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Config {

    public static WebDriver driver;

    // public static void Maximaize() {
    //     ChromeOptions options = new ChromeOptions();

    //     // Always apply these on CI (GitHub Actions has no display)
    //     options.addArguments("--headless=new");
    //     options.addArguments("--no-sandbox");
    //     options.addArguments("--disable-dev-shm-usage");
    //     options.addArguments("--disable-gpu");
    //     options.addArguments("--window-size=1920,1080");
    //     options.addArguments("--remote-allow-origins=*");
    //     options.addArguments("--disable-extensions");
    //     options.addArguments("--disable-software-rasterizer");

    //     driver = new ChromeDriver(options);
    //     driver.manage().window().maximize();
    // }

    public static void Maximize() {
//     ChromeOptions options = new ChromeOptions();
//     options.addArguments("--headless=new");
//     options.addArguments("--no-sandbox");
//     options.addArguments("--disable-dev-shm-usage");
//     options.addArguments("--disable-gpu");
//     options.addArguments("--window-size=1920,1080");
//     options.addArguments("--remote-allow-origins=*");
//     options.addArguments("--disable-extensions");
//     options.addArguments("--disable-software-rasterizer");

//     driver = new ChromeDriver(options);  // ← driver created HERE with all flags
    // ChromeOptions options = new ChromeOptions();
    // options.addArguments("--no-sandbox");
    // options.addArguments("--disable-dev-shm-usage");
    // options.addArguments("--headless=new");
         options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-software-rasterizer");
        driver = new ChromeDriver(options);
                driver.manage().window().maximize();

        
    }

    public static void attente(int s) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(s));
    }
}
