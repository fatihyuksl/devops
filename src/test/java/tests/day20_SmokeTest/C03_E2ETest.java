package tests.day20_SmokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_E2ETest {
    @Test
    public void E2ETest() throws InterruptedException {

//        Tests packagenin altına class olusturun: CreateHotel
//        Bir metod olusturun: createHotel
//        https://www.hotelmycamp.com adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));

        HmcPage hmcPage=new HmcPage();
        hmcPage.login.click();

//        Username textbox ve password metin kutularını locate edin ve asagidaki verileri
//        Username : manager
//        Password  : Manager1!
//                Login butonuna tıklayın.
        Actions actions=new Actions(Driver.getDriver());
        hmcPage.userNameTextBox.sendKeys(ConfigReader.getProperty("userName"));
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password"), Keys.ENTER).perform();



//        Hotel Management/Room reservation menusunden ADD ROOM RESERVATION butonuna tiklayin
        hmcPage.hotelManagement.click();
        Thread.sleep(1000);
        hmcPage.roomReservation.click();
        Thread.sleep(1000);

//        Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
//        Save butonuna tıklayın.
//        “RoomReservation was inserted successfully” textinin göründüğünü test edin.
//        OK butonuna tıklayın.

    }
}
