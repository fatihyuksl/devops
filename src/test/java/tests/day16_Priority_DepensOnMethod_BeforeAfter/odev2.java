package tests.day16_Priority_DepensOnMethod_BeforeAfter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.TestBase_BeforeClass_AfterClass;

public class odev2 extends TestBase_BeforeClass_AfterClass {
    /*
        1 Yeni bir class olusturun : ScroolInto
    2 hotelmycamp anasayfasina gidin
    3 2 farkli test method’u olusturarak actions classi
    ve Js Executor kullanarak asagidaki oda
    turlerinden ust sira ortadaki odayi tiklayin
    4 istediginiz oda inceleme sayfasi acildigini test
    edin
         */
    @Test(priority = 1)
    public void test1() {
        driver.get("https://hotelmycamp.com");
    }

    @Test
    @Ignore
    public void test2() {
        WebElement oda = driver.findElement(By.xpath("(//*[text()='View Room Details '])[2]"));
        Actions actions= new Actions(driver);
        actions.click(oda).perform();
        oda.click();
    }

    @Test
    public void test3() {
        WebElement oda = driver.findElement(By.xpath("(//*[text()='View Room Details '])[2]"));

        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",oda);
        jse.executeScript("arguments[0].click();",oda);
    }
}
