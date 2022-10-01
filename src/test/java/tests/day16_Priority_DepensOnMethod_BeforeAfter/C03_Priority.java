package tests.day16_Priority_DepensOnMethod_BeforeAfter;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_Priority extends TestBaseBeforeMethodAfterMethod {
    /*Testlerimizi çalıştırırken istediğimiz SIRAYA göre çalışmasını istersek
     priority methodunu kullanırız
      Priority kullanmazsak default olarak 0 dır
      */
    @Test (priority = 1)
    public void youtubeTest() {
        driver.get("https://www.youtube.com");
    }
    @Test // Burayı 0 kabul eder
    public void bestbuyTest() {
        driver.get("https://www.bestbuy.com");
    }
    @Test (priority = 2)
    public void amazonTest() {
        driver.get("https://www.amazon.com");
    }
    @Test (priority = -1)
    public void hepsiburadaTest() {
        driver.get("https://www.hepsiburada.com");
    }
}
