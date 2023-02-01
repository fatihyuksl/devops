package tests.Practice.practice05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class P02 extends TestBaseBeforeMethodAfterMethod {

    // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
// 2. JavaScript alertin "CLICK ME!" seçeneğine tıklayın
// 3. Açılır metni alın
// 4. Mesajın "I am an alert box!" olduğunu doğrulayın.
// 5. Açılır pencereyi kabul edin


    @Test
    public void test1() {
// 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

// 2. JavaScript alertin "CLICK ME!" seçeneğine tıklayın
        driver.findElement(By.xpath("(//*[text()='CLICK ME!'])[1]")).click();

// 3. Açılır metni alın

        String acilirMetin = driver.switchTo().alert().getText();
        System.out.println(acilirMetin);

// 4. Mesajın "I am an alert box!" olduğunu doğrulayın.
        Assert.assertTrue(acilirMetin.equals("I am an alert box!"));

// 5. Açılır pencereyi kabul edin
        driver.switchTo().alert().accept();

        driver.quit();
    }

}
