package tests.day23;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02 {
    @DataProvider
    public static Object[][] kullanicilar() {
        return new Object[][]{{"akin@gmail.com", "12345"}, {"alkan@gmail.com", "54321"}, {"ali@gmail.com", "5544221"}};
    }

    @Test(dataProvider = "kullanicilar")
    public void test01(String email, String password) {
        //https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //login butonuna bas
        BrcPage brc = new BrcPage();
        brc.brclogin.click();
        //Data provider ile 3 farklı userEmail ve 3 farklı password girelim
        //login butonuna tiklayin
        brc.userEmail.sendKeys(email);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.ENTER)
                .perform();

        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et

    }
}
