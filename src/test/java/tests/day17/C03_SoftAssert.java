package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_SoftAssert extends TestBaseBeforeMethodAfterMethod {
    @Test
    public void test01() {
        SoftAssert softAssert= new SoftAssert();
        //1-amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2-title in Amazon içerdigini test edin
        String baslik=driver.getTitle();
        softAssert.assertTrue(baslik.contains("Amazon123"),"Girdiginiz kelimeyi icermiyor".toUpperCase());
        //3-arama kutusnun erişilebilir oldugunu test edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"Webelementi erisilemez".toUpperCase());
        //4-arama kutusuna Nuella yazıp aratın
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //5-arama yapıldıgını test edin
        WebElement aramaSonucu=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(aramaSonucu.isDisplayed(),"arama sonuzu goruntulenemedi");
        //6-arama sonucunun Nutella içerdigini test edin
        softAssert.assertTrue(aramaSonucu.getText().contains("Nutella123"),"Arama sonucu Nutella icermiyor".toUpperCase());
        softAssert.assertAll();
        System.out.println("Kod Hatasiz Calisti");
        /*
        SoftAssert baslangic ve bitis satirlari arasindaki tum assertion'lari yapip
        bitis olarak belirtmemiz gereken assertAll() methoduyla test methodumuzdaki
        butun assertion'lari kontrol eder. Failed olan olursa assertion yaptigimiz
        methodun sonuna yazdigimiz mesaji bize konsolda verir.
         */
    }
}
