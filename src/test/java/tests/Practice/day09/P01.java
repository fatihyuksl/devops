package tests.Practice.day09;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class P01 {

    // 1. Tarayıcıyı başlat
// 2. 'http://automationexercise.com' url'sine gidin
// 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
// 4. 'Ürünler' butonuna tıklayın
// 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
// 6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
// 7. 'ARANAN ÜRÜNLER'in görünür olduğunu tek tek doğrulayın
// 8. Aramayla ilgili ürünün ("blue top") görünür olduğunu doğrulayın


    @Test
    public void searchProductPage() {
        // 2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));

        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        String actualHomeUrl="https://automationexercise.com/";
        String expectedHomeUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualHomeUrl,expectedHomeUrl);

        // 4. 'Ürünler' butonuna tıklayın
        AutomationExercisePage automationExercisePage=new AutomationExercisePage();
        automationExercisePage.productsLink.click();

        // 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
        Assert.assertTrue(automationExercisePage.allProducts.isDisplayed()); //1. kontrol

        String productPageUrl=Driver.getDriver().getCurrentUrl();             //2. kontrol
        String expectedUrl="https://automationexercise.com/products";
        Assert.assertEquals(productPageUrl,expectedUrl);

        // 6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
        automationExercisePage.searhProductTextBox.sendKeys("blue", Keys.TAB,Keys.ENTER);

//      7. 'ARANAN ÜRÜNLER'in görünür olduğunu tek tek doğrulayın
        //  Assert.assertTrue(Driver.getDriver().getPageSource().contains("blue top"));

        //ürünlerin hepsini liste attık
        List<WebElement> productList = Driver.getDriver().findElements(By.xpath("//div[@class='productinfo text-center']//p"));
        System.out.println(productList.size());

        //ürünleri görünürlüğünü tek tek kontrol için yazılan for loop
        for (int i = 0; i < productList.size(); i++) {
            System.out.println("Toplam ürün sayisi = "+productList.get(i).getText());
            String product=productList.get(i).getText().toLowerCase();
            Assert.assertTrue(product.contains("blue"));
            // Assert.assertTrue((product.contains("tshirt"))||(product.contains("t-shirt"))||(product.contains("t-shirts"))||(product.contains("t shirt")));
        }
    }
}
