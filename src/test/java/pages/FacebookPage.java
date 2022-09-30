package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
    public FacebookPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@name=\"login\"]")
    public WebElement login;
    @FindBy(xpath = "//img[@class='_9ay6 img']")
    public WebElement girisYapilamadi;
}