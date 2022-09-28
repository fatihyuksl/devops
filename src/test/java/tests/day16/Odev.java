package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class Odev extends TestBaseBeforeMethodAfterMethod {
         /*
         1) Bir class oluşturun: YoutubeAssertions
         2) https://www.youtube.com adresine gidin
         3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
         ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
         ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
         ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
         ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
          */

    @Test
    public void test1() {
        // 2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
        // 3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin

        //  ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        //  ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        //  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        /*

    // 3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    // 1) Bir class oluşturun: YoutubeAssertions
    // 2) https://www.youtube.com adresine gidin

    @Test (priority = 1)
    public void testTittle() {
        // ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    driver.get("https://www.youtube.com");
    String expectedTittle = "YouTube";
    String actualTittle = driver.getTitle();
        Assert.assertEquals(expectedTittle,actualTittle);

    }

    @Test (priority = 2)
    public void imageTest() {
        // ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement youTubeIcon = driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(youTubeIcon.isDisplayed());
    }
    @Test (priority = 3)
    public void SearcboxTest() {
        // ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("(//*[@id='search'])[2]"));
        Assert.assertTrue(searchBox.isEnabled());
    }
    @Test (priority = 4)
    public void wrongTitleTest() {
        // ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String expectedTittle = "youtube";
        String actualTittle = driver.getTitle();
        Assert.assertNotEquals(expectedTittle,actualTittle);
    }
         */

    }
}
