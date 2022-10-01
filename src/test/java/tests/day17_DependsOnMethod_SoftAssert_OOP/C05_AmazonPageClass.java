package tests.day17_DependsOnMethod_SoftAssert_OOP;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C05_AmazonPageClass {
    @Test
    public void test01() {
        AmazonPage amazonPage = new AmazonPage();

        Driver.getDriver().get("https://amazon.com");

        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        System.out.println(amazonPage.aramaSonucuElementi.getText());

        Driver.closeDriver();

    }
}
