package utilities;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
public class ReusableMethods {
    static Faker faker;
    static Actions actions;
    static SoftAssert softAssert;
    static Select select;
    static WebElement ddm;
    //========ScreenShot(Sayfanın resmini alma)=====//
    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }
    //========ScreenShot Web Element(Bir webelementin resmini alma)=====//
    public static String getScreenshotWebElement(String name,WebElement element) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        File source = element.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String wElementSS = System.getProperty("user.dir") + "/target/WElementScreenshots/" + name + date + ".png";
        File finalDestination = new File(wElementSS);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return  wElementSS;
    }
    //========Switching Window(Pencereler arası geçiş)=====//
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }
    //========Hover Over(Elementin üzerinde beklemek)=====//
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }
    //==========Return a list of string given a list of Web Element====////
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }
    //========Returns the Text of the element given an element locator==//
    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }
    //   HARD WAIT WITH THREAD.SLEEP
//   waitFor(5);  => waits for 5 second
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }
    //====== Faker ======//
    public static Faker getFaker() { // getFaker method
        return faker = new Faker();
    }
    //====== Actions ======//
    public static Actions getActions() { //getActions method
        return actions = new Actions(Driver.getDriver());
    }
    //====== Soft Assert ======//
    public static SoftAssert getSoftAssert() { //getSoftAssert method
        return softAssert = new SoftAssert();
    }
    //====== Select ======//
    public static Select select(WebElement ddm){
        return select = new Select(ddm);
    }
    //====== js ======//
    public static void jsclick(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", webElement);
        try {
            webElement.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
            executor.executeScript("arguments[0].click();", webElement);
        }
    }
    public boolean waitForElementToBeClickableBool(WebDriver    driver, By attributeValue, int waitTime) {
        boolean flag = false;
        try{
            new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(attributeValue));
            flag=true;
            return flag;

        }catch(Exception Ex){
            return flag;
        }
    }
    public boolean waitForAlertPresent(WebDriver driver, int waitTime) {
        boolean flag = false;
        new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.alertIsPresent());
        try{
            driver.switchTo().alert();
            return flag = true;
        }catch(Exception Ex){
            return flag;
        }
    }
    /**
     * This method is used to wait for element till visibility of element.
     *
     * @param driver
     * @param attributeValue
     *            - provide locator value of element till it is visible on
     *            application and then click that element.
     * @param waitTime
     *            - provide maximum wait time in seconds for driver
     */
    public boolean waitForElementToBeVisible(WebDriver driver, By attributeValue, int waitTime) {
        boolean flag = false;
        try {
            new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(attributeValue));
            flag=true;
            return flag;
        } catch (Exception Ex) {
            return flag;
        }
    }

    /**
     * @Method:getcurrenttime This method is used to return system time in
     *                        seconds.
     */
    public static int getcurrenttime() {
        long currentDateMS = new Date().getTime();
        int seconds = (int) ((currentDateMS / 1000) % 3600);
        return seconds;
    }
    /**
     * @Method:closeAllOtherWindows - This method is used to close all open
     *                              windows except parent window.
     * @param driver
     * @return
     * @throws InterruptedException
     */
    public static boolean closeAllOtherWindows(WebDriver driver) throws InterruptedException {
        String Parent_Window = driver.getWindowHandle();
        java.util.Set<String> allWindowHandles = driver.getWindowHandles();
        for (String currentWindowHandle : allWindowHandles) {
            if (!currentWindowHandle.equals(Parent_Window)) {
                driver.switchTo().window(currentWindowHandle);
                driver.close();
                Thread.sleep(2000);
            }
        }
        driver.switchTo().window(Parent_Window);
        if (driver.getWindowHandles().size() == 1)
            return true;
        else
            return false;
    }
    /**
     * This method is for simple dropdown selection by visibleText
     *
     * @param driver
     * @param dropDownID-This
     *            is the unique attribute to find an dropdownelement
     * @param dropDownValue-This
     *            is the text to search in dropdown
     */
    public static void dropDownSelectionByText(WebDriver driver, By dropDownID, String dropDownValue) {
        try {
            WebElement element = null;
            new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(dropDownID));
            element = driver.findElement(dropDownID);
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(dropDownValue);
        }
        catch (StaleElementReferenceException ex) {
            System.out.println("Exception while selecting a value from dropdown" + ex.getMessage());
        }
    }
    /**
     * This method is for simple dropdown selection by value
     *
     * @param driver
     * @param dropDownID-This
     *            is the unique attribute to find an dropdownelement
     * @param dropDownValue-This
     *            is the text to search in dropdown
     */
    public static void dropDownSelectionByValue(WebDriver driver, By dropDownID, String dropDownValue) {
        try {
            WebElement element = null;
            new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(dropDownID));
            element = driver.findElement(dropDownID);
            Select dropDown = new Select(element);
            dropDown.selectByValue(dropDownValue);
        }
        catch (StaleElementReferenceException ex) {
            System.out.println("Exception while selecting a value from dropdown" + ex.getMessage());
        }
    }
    /**
     * This method is for simple dropdown selection by index
     *
     * @param driver
     * @param dropDownID-This
     *            is the unique attribute to find an dropdownelement
     * @param dropDownValue-This
     *            is the text to search in dropdown
     */
    public static void dropDownSelectionByIndex(WebDriver driver, By dropDownID, int dropDownValue) {
        try {
            WebElement element = null;
            new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(dropDownID));
            element = driver.findElement(dropDownID);
            Select dropDown = new Select(element);
            dropDown.selectByIndex(dropDownValue);
        }
        catch (StaleElementReferenceException ex) {
            System.out.println("Exception while selecting a value from dropdown" + ex.getMessage());
        }
    }
}