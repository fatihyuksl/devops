package tests.day17_DependsOnMethod_SoftAssert_OOP;

import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverIlkTest {
    @Test
    public void test01() {
        Driver.getDriver().get("https://amazon.com");
            Driver.closeDriver();

        Driver.getDriver().get("https://bestbuy.com");
        Driver.getDriver().get("https://hepsiburada.com");

        //Driver.closeDriver();
        Driver.quitDriver();
    }
}
