package tests.day16_Priority_DepensOnMethod_BeforeAfter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase_BeforeClass_AfterClass;

public class C04_DependsBulutluOz extends TestBase_BeforeClass_AfterClass {
    @Test
    public void test1() {
        //amazon ana sayfasına git
        driver.get("https://amazon.com");
    }
    @Test(dependsOnMethods = "test1",priority = -1) //priority -1 olup ilk bu çalışması gerekirken dependsOnMethods tan dolayı ilk test1'i çalıştırır
    public void test2() {
        //nutella aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
    }

    @Test(dependsOnMethods = "test2")//test2 çalışmazsa bu test(test3) çalışmasın demektir
    public void test3() {
        //sonuc yazısının amazon içerdigini test edelim
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertFalse(sonuc.getText().contains("amazon"));
    }
}
