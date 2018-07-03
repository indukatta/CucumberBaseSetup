package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Page {

    public AppiumDriver driver;

    //Constructor
    public Page(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void synchElement(MobileElement element){
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
    void click (MobileElement element) {
        try{
            synchElement(element);
            element.click();
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

    //Package private Write Text
    void writeText(MobileElement element, String text) {
        try {
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

    void writeNumber(MobileElement element, int number){
        try {
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

    //Package private Read Text
    String readText(MobileElement element) {
        try {
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
    String readAttribute (MobileElement element, String attribute) {

        try {
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
    void dropdownSelect (MobileElement element, String selection) {

        try {
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
    void hover (MobileElement element) {

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
    String getCSSValue  (MobileElement element, String propertyName) {

        String cssValue = null;

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
    void scrollDown(MobileElement element) {

        try {
            while (!element.isDisplayed()) {
                TouchAction actions = new TouchAction(driver);
                actions.press(PointOption.point(10,250))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(10,-5))
                        .perform();
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
}
