package tests.Practice.practice06;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.SaucedemoPage;
import utilities.ConfigReader;
import utilities.Driver;

public class homework {

        /*
//     * Navigate to  https://www.saucedemo.com/
//     * Enter the username  as standard_user
//     * Enter the password as   secret_sauce
//     * Click on login button
//     * Choose price low to high and verify that PRICE (LOW TO HIGH) is visible
     */

    @Test
    public void test1() {
        Driver.getDriver().get(ConfigReader.getProperty("sauceUrl"));
    }

    @Test(dependsOnMethods = "test1",priority = 1)
    public void test2() {
        SaucedemoPage saucedemoPage= new SaucedemoPage();

        saucedemoPage.userNameTextBox.sendKeys(ConfigReader.getProperty("userNameSauce"));
        saucedemoPage.passwordTextBox.sendKeys(ConfigReader.getProperty("passwordSauce"));

        saucedemoPage.loginButton.click();

        //     * Choose price low to high and verify that PRICE (LOW TO HIGH) is visible

        Select select=new Select(saucedemoPage.ddm);

        select.selectByVisibleText("Price (low to high)");

        System.out.println(saucedemoPage.fiyatList.stream().sorted().toString());
    }
}
