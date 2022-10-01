package tests.day16_Priority_DepensOnMethod_BeforeAfter;

import org.testng.annotations.Test;
import utilities.TestBase_BeforeClass_AfterClass;

public class C02_BeforeClassAfterClass extends TestBase_BeforeClass_AfterClass {

    @Test
    public void testamazonTesti() {
        driver.get("https://amazon.com");
    }
    @Test
    public void bestuyTesti() {
        driver.get("https://bestbuy.com");
    }
    @Test
    public void techproeducation() {
        driver.get("https://techproeducation.com");
    }
}
