package tests.day22;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;
public class C01_RaporluTest extends TestBaseRapor {
    /*
    -https://www.bluerentalcars.com/ adresine git
    -login butonuna bas
    -test data user email: customer@bluerentalcars.com ,
    -test data password : 12345 dataları girip login e basın
    -login butonuna tiklayin
    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Pozitif Test","Gecerli kullanici adi ve password ile giris yapildi");
        //-https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Blue Rentacar sitesine gidildi");
        //-login butonuna bas
        // -test data password : 12345 dataları girip login e basın
        //-login butonuna tiklayin
        BrcPage brc = new BrcPage();
        brc.brclogin.click();
        extentTest.info("Login butonuna basildi");
        //-test data user email: customer@bluerentalcars.com ,
        brc.userEmail.sendKeys(ConfigReader.getProperty("userEmailRC"));
        Actions actions= new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("userPassRC")).sendKeys(Keys.ENTER).perform();
        extentTest.info("Dogru kullanici email ve password girildi");
        extentTest.info("2. login butonuna basildi");
        //-Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        //-Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(brc.kullanici.isDisplayed());
        extentTest.pass("Sayfaya basarili bir sekilde girildi");
    }
}
