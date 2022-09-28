package tests.day16;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_Priority extends TestBaseBeforeMethodAfterMethod {
    // Testlerimizi çalıştırırken istediğimiz sıraya göre çalışmasını istersek
    //priority methodunu kullanırız  default olarak priority=0 kabul eder
    @Test(priority = 1)
    public void youtubeTest() {
        driver.get("https://youtube.com");
    }

    @Test(priority = 3)
    public void bestbbuyTest() {
        driver.get("https://bestbuy.com");
    }

    @Test(priority = 2)
    public void amazonTest() {
        driver.get("https://amazon.com");
    }
}
