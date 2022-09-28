package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C01_BeforeMethodAfterMethod extends TestBaseBeforeMethodAfterMethod {
    @Test
    public void amazonTesti() {
        driver.get("https://amazon.com");
    }

    @Test
    public void bestbutTesti() {
        driver.get("https://bestbuy.com");
    }

    @Test
    public void techproeducationTesti() {
        driver.get("https://techproeducation.com");
    }
}
