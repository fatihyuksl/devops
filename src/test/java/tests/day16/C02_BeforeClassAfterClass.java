package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_BeforeClassAfterClass extends TestBaseBeforeClassAfterClass {
    @Test
    public void testamazon() {
        driver.get("https://amazon.com");
    }

    @Test
    public void testbestbuy() {
        driver.get("https://bestbuy.com");
    }

    @Test
    public void testTechproed() {
        driver.get("https://techproeducation.com");
    }
}
