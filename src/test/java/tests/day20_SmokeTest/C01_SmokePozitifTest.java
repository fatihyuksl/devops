package tests.day20_SmokeTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SmokePozitifTest {

        @Test
        public void pozitifTest() {
                //        Bir Class olustur : PositiveTest
//        2) Bir test method olustur positiveLoginTest()
//        https://www.hotelmycamp.com/ adresine git  login butonuna bas
                Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
                HmcPage hmcPage=new HmcPage();

                hmcPage.login.click();

//        test data username: manager ,  test data password : Manager1!
                hmcPage.userNameTextBox.sendKeys(ConfigReader.getProperty("userName"));
                hmcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("password"), Keys.ENTER);

//        Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
                Assert.assertTrue(hmcPage.girisPassed.isEnabled());
        Driver.closeDriver();

    }
}
