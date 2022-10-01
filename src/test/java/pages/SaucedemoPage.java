package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SaucedemoPage {
    public SaucedemoPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='user-name']")
    public WebElement userNameTextBox;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//*[@id='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@class='product_sort_container']")
    public WebElement ddm;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> fiyatList;
}
