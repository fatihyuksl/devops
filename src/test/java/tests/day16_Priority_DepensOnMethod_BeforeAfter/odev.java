package tests.day16_Priority_DepensOnMethod_BeforeAfter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase_BeforeClass_AfterClass;

public class odev extends TestBase_BeforeClass_AfterClass {
//    1) Bir class oluşturun: YoutubeAssertions
//2) https://www.youtube.com adresine gidin
//3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
//○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
//○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
//○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
// ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin


    @Test (priority = 1)
    public void test1() {
        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");

    }

    @Test(priority = 2)
    public void titleTest() {
        //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin

        Assert.assertTrue(driver.getTitle().equals("YouTube"));
    }

    @Test(priority = 3)
    public void imageTest() {
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement icon = driver.findElement(By.xpath("(//*[@id='logo'])[2]"));
        Assert.assertTrue(icon.isDisplayed());
    }

    @Test(priority = 4)
    public void searchBox() {
        WebElement searchBox = driver.findElement(By.xpath("(//*[@id='search'])[3]"));
        Assert.assertTrue(searchBox.isDisplayed());
    }

    @Test(priority = 5)
    public void wrongTitleTest() {
        // ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        Assert.assertNotEquals(driver.getTitle(),"youtube");
    }
}
