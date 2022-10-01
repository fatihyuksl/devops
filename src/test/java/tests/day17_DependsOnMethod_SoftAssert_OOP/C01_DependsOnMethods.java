package tests.day17_DependsOnMethod_SoftAssert_OOP;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C01_DependsOnMethods extends TestBaseBeforeMethodAfterMethod {
    //İKİNCİ KOŞACAK TEST böyle bir site olmadığından test Fail olacaktır, bu test fail oldugundan test02 ve test03
    //dependsOnMethods ile bir birine bağladığımız için Ignore oldu
    @Test
    public void test01() {
        driver.get("https://Wasdfamazon.com");
    }
    @Test(dependsOnMethods = "test01")
    public void test02() {
        driver.get("https://facebook.com");
    }

    @Test(dependsOnMethods = "test02")
    public void test03() {
        driver.get("https://bestbuy.com");
    }

    // İLK KOŞACAK TEST
    @Test(priority = -1)  // ilk olarak bu testin koşması için priority'i -1 yaptık ve ilk bu test koştu
    public void test04() {
        driver.get("https://youtube.com");
    }
}
