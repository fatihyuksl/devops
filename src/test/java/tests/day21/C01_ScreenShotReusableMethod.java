package tests.day21;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenShotReusableMethod {

    @Test
    public void test1() throws IOException {
        //Hepsiburada sayfasina gidiniz
        Driver.getDriver().get("https://www.hepsiburada.com");
        //Ve sayfanin resmini aliniz
        ReusableMethods.getScreenshot("HepsiBurada");
        //Sayfayi kapatiniz
        Driver.closeDriver();
    }

    @Test
    public void testWE() throws IOException {
        Driver.getDriver().get("https://www.hepsiburada.com");
        ReusableMethods.
                getScreenshotWebElement("HepsiBuradaLogo",Driver.getDriver().
                        findElement(By.xpath("//div[@class='sf-OldHeader-FpTYTu4Avgrxt5ZgRSEL']")));
    }

    @Test
    public void test02() throws IOException {
        //Amazon sayfasina gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
        AmazonPage amznPage= new AmazonPage();
        //Nutella aratiniz
        amznPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        //Arama sonuc yazisi webelement resmini aliniz
        ReusableMethods.getScreenshotWebElement("NutellaAramasi",amznPage.aramaSonucuElementi);
    }

}
