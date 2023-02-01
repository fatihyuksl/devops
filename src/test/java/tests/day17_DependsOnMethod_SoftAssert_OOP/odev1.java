package tests.day17_DependsOnMethod_SoftAssert_OOP;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.ZeroWebappsecurity;
import utilities.Driver;

public class odev1 {
//    Yeni bir Class Olusturun : C03_SoftAssert
//“http://zero.webappsecurity.com/” Adresine gidin
//    Sign in butonuna basin
//    Login kutusuna “username” yazin
//    Password kutusuna “password” yazin
//    Sign in tusuna basin
//    Online banking menusu icinde Pay Bills sayfasina gidin
//“Purchase Foreign Currency” tusuna basin
//“Currency” drop down menusunden Eurozone’u secin
//    soft assert kullanarak "Eurozone (Euro)" secildigini test edin

//    soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
//    "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
//    "China  (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
//    "Hong Kong  (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
//    "New Zealand  (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

    ZeroWebappsecurity zeroWebappsecurity = new ZeroWebappsecurity();
    @Test
    public void test1() {
        Driver.getDriver().get("http://zero.webappsecurity.com/");

        //    Sign in butonuna basin
        zeroWebappsecurity.signIn.click();
    }

    @Test(dependsOnMethods = "test1")
    public void test2() {
        zeroWebappsecurity.userLogin.sendKeys("username");
        zeroWebappsecurity.userPassword.sendKeys("password", Keys.ENTER);
        Driver.getDriver().navigate().forward();
    }
}
