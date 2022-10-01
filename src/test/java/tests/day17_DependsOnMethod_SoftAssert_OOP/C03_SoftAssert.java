package tests.day17_DependsOnMethod_SoftAssert_OOP;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase_BeforeClass_AfterClass;

public class C03_SoftAssert extends TestBase_BeforeClass_AfterClass {
    @Test
    public void test01() {
        //Açıklama: Assert'te hata oldugunda programın alt satırlarının da calışmasını engeller.
        //      Fakat SoftAssert'te hata verileni atlar alt satrıları'da çalıştırır

        SoftAssert softAssert = new SoftAssert(); // ilk SoftAssert objesi tanımlanır


        //1-amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-title in Amazon içerdigini test edin    //burada contains'i bilerek hatalı girdik softAssert'i test etmek için
        softAssert.assertTrue(driver.getTitle().contains("Amazon123"),"Girdiginiz kelimeyi içermiyor");

        //3-arama kutusnun erişilebilir oldugunu tets edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"We erişilemez");

        //4-arama kutusuna Nuella yazıp aratın
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //5-arama yapıldıgını test edin
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonuc.isDisplayed(),"Sonuc WE görüntülemenemai");

        //6-arama sonucunun Nutella içerdigini test edin    //Bu satırda contains'i bilerek yanlış girdirdik
        softAssert.assertTrue(sonuc.getText().contains("Nutella123"),"Nutella içermiyor");

        softAssert.assertAll();   // en son bu kodun yazılması gerkelidir UNUTMA!!!!
                                  // Eğer girmezsek oluşan hatalrı bana vermez testi PASSED yapar.


        //softassert içerisinde failed test oldugundan dolayı burası çalımazz
        System.out.println("assertionlardan fail olan olursa burası calismaz");  //softassert'lerde fail olursa
                                                                                //assertAll() yaptıktan sonraki
                                                                                //kodlar çalışmaz.


    }
}