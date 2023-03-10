package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBaseBeforeMethodAfterMethod {// obje oluşturulmasını engellemek için abstract yaptık

    protected WebDriver driver;
 //   protected Actions;
    protected String tarih;

    @BeforeMethod(groups = "gp1")
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    //    actions = new Actions(driver);

        LocalDateTime date = LocalDateTime.now(); // PrintScreen yaptıgımızda tarih saati fotonun ismi yapmak için olusturduk
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        tarih = date.format(formater);
    }
    @AfterMethod(groups = "gp1")
    public void tearDown(){
        driver.close();
    }
}
