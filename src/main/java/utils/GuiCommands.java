package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class GuiCommands {

    protected AppiumDriver driver;

    //Constructor
    public GuiCommands(AppiumDriver driver){
        this.driver = driver;
    }

    protected void synchElement(MobileElement element){
        try {
            new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(element));
            new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (TimeoutException e)
        {
            //TODO: Sysout(e.getMessage());
        }
    }

    //Package private Click Method
    protected void click (String locator) {
        try{
            MobileElement element = (MobileElement) driver.findElement(By.name(locator));
            synchElement(element);
            scrollDown(locator);
            element.click();
        }
        catch (ElementNotVisibleException e) {
            System.out.println(e.getMessage());
        }
        catch (ElementNotSelectableException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch(NoSuchElementException e){

            //TODO: Sysout(e.getMessage());
        }
    }

    /**
     *
     * @param locator
     * @param text
     */
    protected void writeText(String locator, String text) {
        try {
            scrollDown(locator);
            MobileElement element = (MobileElement) driver.findElement(By.name(locator));
            element.sendKeys(text);
        }
        catch (ElementNotVisibleException e) {
            System.out.println("Element not visible");
        }
        catch (ElementNotSelectableException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch(NoSuchElementException e){
            //TODO: Sysout(e.getMessage());
        }
    }

    protected void writeNumber(String locator, int number){
        try {
            scrollDown(locator);
            MobileElement element = (MobileElement) driver.findElement(By.name(locator));
            element.sendKeys(String.valueOf(number));
        }
        catch (ElementNotVisibleException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch (ElementNotSelectableException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch(NoSuchElementException e){
            //TODO: Sysout(e.getMessage());
        }
    }

    protected void clearText(String locator) {

        try {
            scrollDown(locator);
            MobileElement element = (MobileElement) driver.findElement(By.name(locator));
            element.clear();
        }
        catch (ElementNotVisibleException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch (ElementNotSelectableException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch(NoSuchElementException e){
            //TODO: Sysout(e.getMessage());
        }
    }

    //Package private Read Text
    protected String  readText(String locator) {
        try {
            scrollDown(locator);
            MobileElement element = (MobileElement) driver.findElement(By.name(locator));
            return element.getText();
        }
        catch (ElementNotVisibleException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch (ElementNotSelectableException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch(NoSuchElementException e) {
            //TODO: Sysout(e.getMessage());
        }
        return null;
    }

    //Package private Read Attribute
    protected String readAttribute (String locator, String attribute) {
        try {
            scrollDown(locator);
            MobileElement element = (MobileElement) driver.findElement(By.name(locator));
            return element.getAttribute(attribute);
        }
        catch (ElementNotVisibleException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch (ElementNotSelectableException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch(NoSuchElementException e) {
            //TODO: Sysout(e.getMessage());
        }
        return null;
    }

    // Package private DropDown Select
    protected void dropdownSelect (String locator, String selection) {
        try {
            scrollDown(locator);
            MobileElement element = (MobileElement) driver.findElement(By.name(locator));
            new Select(element).selectByVisibleText(selection);
        }
        catch (ElementNotVisibleException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch (ElementNotSelectableException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch(NoSuchElementException e) {
            //TODO: Sysout(e.getMessage());
        }
    }

    // Package private Hover
    protected void hover (String locator) {

        MobileElement element = (MobileElement) driver.findElement(By.name(locator));
        Actions builder = new Actions(driver);
        Action hoverOver = null;

        try {
            // Build action for mouse to move open location. This uses the build() method.
            hoverOver = builder
                    .moveToElement(element)
                    .build();

            hoverOver.perform();
        }
        catch (ElementNotVisibleException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch (ElementNotSelectableException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch(NoSuchElementException e) {
            //TODO: Sysout(e.getMessage());
        }

    }

    // Package private css value
    protected String getCSSValue  (String locator, String propertyName) {
        scrollDown(locator);
        String cssValue = null;
        MobileElement element = (MobileElement) driver.findElement(By.name(locator));

        try {
            cssValue = element.getCssValue( propertyName);
        }
        catch (ElementNotVisibleException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch (ElementNotSelectableException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch(NoSuchElementException e) {
            //TODO: Sysout(e.getMessage());
        }
        return cssValue;
    }

    //Package private scroll
    protected void scrollDown(String locator){
        MobileElement element = (MobileElement) driver.findElement(By.name(locator));
        while (!element.isDisplayed()) {
                TouchAction actions = new TouchAction(driver);
                actions.press(PointOption.point(10, 250))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(10, -5))
                        .perform();
        }
    }

    protected void radioButton(boolean select, String locatorButtonOne, String locatorButtonTwo){
        scrollDown(locatorButtonOne);
        try {
            if (select){
                click(locatorButtonOne);//FIXME: needs accessibility ID
            } else {
                click(locatorButtonTwo);
            }
        }
        catch (ElementNotVisibleException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch (ElementNotSelectableException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch(NoSuchElementException e) {
            //TODO: Sysout(e.getMessage());
        }
    }

    protected void IosDatePickerWheel(HashMap<String, String> map, String locator){
        System.out.println(map.get("year") + " " + map.get("month") + " " + map.get("day"));
        scrollDown(locator);
        click(locator);
        WebElement yearElement = (WebElement) driver.findElements(By.className("XCUIElementTypePickerWheel")).get(2);
        yearElement.sendKeys(map.get("year"));
        WebElement monthElement = (WebElement) driver.findElements(By.className("XCUIElementTypePickerWheel")).get(1);
        monthElement.sendKeys(map.get("month"));
        WebElement dayElement = (WebElement) driver.findElements(By.className("XCUIElementTypePickerWheel")).get(0);
        dayElement.sendKeys(map.get("day"));
    }

    protected void IosPickerWheel(String locator, String choice){
        scrollDown(locator);
        click(locator);
        WebElement element= (WebElement) driver.findElements(By.className("XCUIElementTypePickerWheel")).get(0);
        element.sendKeys(choice);
    }

    protected int IosTableCellCount(){
        List cells = driver.findElements(By.className("XCUIElementTypeCell"));
        return cells.size();
    }
}
