package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class TestBaseBeforeClassAfterClass {
    // @BeforeClass ve @AfterClass notasyonlarını TestNG de kullanırken JUnit'teki gibi static yapmaya gerek yoktur
    protected  WebDriver driver;

    @BeforeClass
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public  void tearDown(){
        //driver.quit();
    }
}
