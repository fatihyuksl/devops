package tests.day18;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigurationProperties {
    @Test
    public void test1() throws InterruptedException {
        //Amazon sayfasına ve facebook sayfasına gidiniz
        String urlamzn = ConfigReader.getProperty("amznUrl");
        String urlFace = ConfigReader.getProperty("faceUrl");

        Driver.getDriver().get(urlamzn);
        Driver.getDriver().get(urlFace);

Thread.sleep(1000);
        Driver.closeDriver();
    }
}
