package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@name='email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//*[@type='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//*[@class='_9ay7']")
    public WebElement girisYapilamadiMesaji;




}
