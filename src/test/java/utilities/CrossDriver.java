package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class CrossDriver {

    private CrossDriver() {

    }

    static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        //Eger browser'a bir deger atanmamissa properties dosyasindaki  browser calissin
        browser = browser == null ? ConfigReader.getProperty("browser") : browser;


        //Testlerimizi xml file'dan farkli browserlar ile calistirabilmek icin
        // getDriver() methoduna parametre atmamiz gerekir

        if (driver == null) {                                  //driver'i bir kere calistirir(browser 1 kere açılır)
            switch (browser) {
                //CrossBrowser icin bizim gönderdigimiz browser uzerinden calismasi icin
                //buraya parametre olarak girdigimiz degeri yazdik

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup(); //hiç birşey çalışmazsa chrome calışsın
                    driver = new ChromeDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null; //kapandıktan sonra driveri tekrar açılmasında problem olmaması için null yaptık
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
