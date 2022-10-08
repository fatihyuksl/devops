package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutomationExercisePage {

    public AutomationExercisePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='View Product']")
    public List<WebElement> tumUrunler;

    @FindBy(xpath = "//*[text()=' Products']")
    public WebElement productsLink;

    @FindBy(xpath = "//*[text()='All Products']")
    public WebElement allProducts;

    @FindBy(xpath = "//*[@id='search_product']")
    public WebElement searhProductTextBox;

    @FindBy(xpath = "//*[@id='submit_search']")
    public WebElement searhButton;
}
