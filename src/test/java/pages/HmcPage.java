package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HmcPage {
    public HmcPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement login;

    @FindBy(xpath = "//*[@id='UserName']")
    public WebElement userNameTextBox;

    @FindBy(xpath = "//*[@id='Password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//*[@class='username username-hide-on-mobile']")
    public WebElement girisPassed;

    @FindBy(xpath = "//*[text()='Try again please']")
    public WebElement girisYapilamadi;

    @FindBy(xpath = "//*[text()='Hotel Management']")
    public WebElement hotelManagement;

    @FindBy (xpath = "//*[@href='/admin/RoomReservationAdmin']")
    public WebElement roomReservation;
    @FindBy(xpath = "//*[text()='Add Room Reservation ']")
    public WebElement addRoom;

    @FindBy(xpath = "//*[@id='IDUser']")
    public WebElement idUser;

    @FindBy(css = ".bootbox-body")
    public WebElement roomReservationText;
    @FindBy(xpath = "//*[text()='OK']")
    public WebElement okButton;




}
