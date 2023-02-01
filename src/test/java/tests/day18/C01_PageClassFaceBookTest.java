package tests.day18;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C01_PageClassFaceBookTest {

//    https://www.facebook.com/ adresine gidin
//    POM’a uygun olarak email, sifre kutularini ve giris yap
//    butonunu locate edin
//    Faker class’ini kullanarak email ve sifre degerlerini
//    yazdirip, giris butonuna basin
//    giris yapilamadigini test edin

    FacebookPage facebookPage= new FacebookPage();
    @Test
    public void test1() {
        Driver.getDriver().get("https://www.facebook.com/");
    }

    @Test(dependsOnMethods = "test1")
    public void test2() {
        facebookPage.emailTextBox.sendKeys("zamanazingo@gmail.com");
        facebookPage.passwordTextBox.sendKeys("123456789", Keys.ENTER);
    }

    @Test(dependsOnMethods = "test2")
    public void test3() {
        Assert.assertTrue(facebookPage.girisYapilamadiMesaji.isDisplayed());
    }
}
