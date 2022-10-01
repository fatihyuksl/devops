package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroWebappsecurity {
    public ZeroWebappsecurity() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='signin_button']")
    public WebElement signIn;

    @FindBy(xpath = "//*[@id='user_login']")
    public WebElement userLogin;

    @FindBy(xpath = "//*[@id='user_password']")
    public WebElement userPassword;

}
