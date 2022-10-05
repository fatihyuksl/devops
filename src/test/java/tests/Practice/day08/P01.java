package tests.Practice.day08;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerokuappPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class P01 {
    //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    //Click all the buttons and verify they are all clicked

    HerokuappPage herokuappPage=new HerokuappPage();
    Actions actions=new Actions(Driver.getDriver());

    @Test
    public void test01() throws InterruptedException {
        //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        Driver.getDriver().get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        //Click all the buttons and verify they are all clicked
     /*
     herokuappPage.onBlur.click();
        actions.click(herokuappPage.onClick).click(herokuappPage.onClick).
                contextClick(herokuappPage.onContextMenu).
                doubleClick(herokuappPage.onDoubleClick).perform();

        ReusableMethods.waitFor(2);

        actions.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN).perform();
        ReusableMethods.waitFor(2);

        actions.click(herokuappPage.onFocus).
                click(herokuappPage.onKeyDown)
                .sendKeys(Keys.ENTER).
                click(herokuappPage.onKeyUp).
                sendKeys(Keys.ENTER)
                .perform();
                */

        herokuappPage.onBlur.click();
        herokuappPage.onClick.click();
        herokuappPage.onClick.click();
        actions.contextClick(herokuappPage.onContextMenu).
                doubleClick(herokuappPage.onDoubleClick).
                click(herokuappPage.onFocus).
                click(herokuappPage.onKeyDown)
                .sendKeys(Keys.ENTER).
                click(herokuappPage.onKeyUp).
                sendKeys(Keys.ENTER).
                click(herokuappPage.onKeyPress).
                sendKeys(Keys.ENTER).
                moveToElement(herokuappPage.onMouseOver).
                moveToElement(herokuappPage.onMouseLeave).
                moveToElement(herokuappPage.onMouseOver).
                click(herokuappPage.onMouseDown).perform();
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        List<WebElement> trig = herokuappPage.eventTriggered;
        Assert.assertTrue(trig.size()==11);
    }
}
