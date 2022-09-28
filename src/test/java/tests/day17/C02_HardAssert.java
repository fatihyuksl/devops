package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C02_HardAssert extends TestBaseBeforeMethodAfterMethod {
    /*
    // Hard Assertions : JUNit'te öğrendiğimiz assertion ile aynıdır.
     Assert.assertTrue();  Assert.assertFalse();  Assert.assertEquals();
    // Hard Assertions'da herhangi bir assertion failed olursa,
     test method'un çalışmasını durdurur ve kalan kodları yürütmez.(stop execution)

    // Soft Assert : Kullanabilmek için obje oluştururuz,
     oluşturduktan sonra obje ismi ile kullanırız,
      Herhangi bir hata verdiğinde test methodu
    // çalışmaya devam eder, en sonra rapor verir.
       baslangıc  SoftAssert objeadı=new SoftAssert();
        bitis objeadı.assertAll();
     */

    @Test
    public void test01() {
        //1-amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2-title in Amazon içerdigini test edin
        String baslik=driver.getTitle();
        Assert.assertTrue(baslik.contains("Amazon"));
        //3-arama kutusnun erişilebilir oldugunu test edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());
        //4-arama kutusuna Nuella yazıp aratın
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //5-arama yapıldıgını test edin
        WebElement aramaSonucu=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(aramaSonucu.isDisplayed());
        //6-arama sonucunun Nutella içerdigini test edin
        Assert.assertTrue(aramaSonucu.getText().contains("Nutella"));
    }

}
