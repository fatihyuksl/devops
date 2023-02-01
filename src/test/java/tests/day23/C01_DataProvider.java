package tests.day23;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DataProvider {


    @Test
    public void test01() {
        AmazonPage amazonPage = new AmazonPage();
        //Amazon sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
        //Nutella için arama yapalım
        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        //sonuclarin nutella icerdigini test edelim
        String expectedKelime = "Nutella";
        String actualKelime = amazonPage.aramaSonucuElementi.getText();
        Assert.assertTrue(actualKelime.contains(expectedKelime));
        Driver.closeDriver();
    }


    //@DataProvider site içinde aratmak istediğimiz kelimeleri tek tek
    // (ana sayfaya dönerek yeniden) aratmak için
    //oluşturduğumuz method'dur.
    @DataProvider
    public static Object[][] aranacakKelimeler() {
        return new Object[][]{{"java"},{"selenium"},{"samsung"},{"iphone"}};//-->6-)Ide ile otomatik olusturulur
    }                                                                       //-->aranacak kelimeler array icine
                                                                            // {"..."} kalibi ile eklenir


    @Test(dataProvider = "aranacakKelimeler")//-->1-)  dataProvider eklenir
    public void test02(String kelimeler) {//-->2-) String kelimeler eklenir
        AmazonPage amazonPage = new AmazonPage();
        //Amazon sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
        //java, selenium, samsung ve iphone icin arama yapalim
        amazonPage.aramaKutusu.sendKeys(kelimeler, Keys.ENTER);//-->3-)String olarak kelimeler yazilir
        //sonuclarin aradigimiz kelime icerdigini test edelim
        String actualKelime = amazonPage.aramaSonucuElementi.getText();
        Assert.assertTrue(actualKelime.contains(kelimeler));//-->4-)kelimeler contains'e eklenir

    }

    @Test(dependsOnMethods = "test02")
    public void test03() {
        Driver.closeDriver();
    }
}
