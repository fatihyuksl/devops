package tests.day21;

import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class HomeWork {

    //Hepsiburada sayfasına gidiniz
    //Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım
    //Her linkten sonra o sayfaya gittimizi test edelim ve o sayfanız resmini alalım
    //Sayfayı kapatalım


    @Test
    public void test01() {
        //Hepsiburada sayfasına gidiniz
        Driver.getDriver().get("https://www.hepsiburada.com");
        //Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım

        //Her linkten sonra o sayfaya gittimizi test edelim ve o sayfanız resmini alalım
        //Sayfayı kapatalım

    }
}
