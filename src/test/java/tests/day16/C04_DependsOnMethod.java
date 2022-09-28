package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C04_DependsOnMethod extends TestBaseBeforeMethodAfterMethod {
    @Test
    public void test1() {
        //Amazon anasayfasina gidelim
        driver.get("https://amazon.com");

    }

    @Test(dependsOnMethods = "test1")
    public void test2() {
        //Nutella aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
    }

    @Test(dependsOnMethods = "test2")
    public void test3() {
        //Sonuc yazisinin amazon icerdigini test edelim
       String sonucYazisi= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertFalse(sonucYazisi.contains("amazon"));

    }
}
