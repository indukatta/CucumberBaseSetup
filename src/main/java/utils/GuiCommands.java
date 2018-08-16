package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class GuiCommands {

    public AppiumDriver driver;

    //Constructor
    public GuiCommands(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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
    public void click (MobileElement element) {
        try{
            synchElement(element);
            scrollDown(element);
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
     * @param element
     * @param text
     */
    public void writeText(MobileElement element, String text) {
        try {
            scrollDown(element);

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

    public void writeNumber(MobileElement element, int number){
        try {
            scrollDown(element);
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

    public void clearText(MobileElement element) {

        try {
            scrollDown(element);
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
    public String readText(MobileElement element) {
        try {
            synchElement(element);
            scrollDown(element);
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
    public String readAttribute (MobileElement element, String attribute) {
        try {
            scrollDown(element);
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
    public void dropdownSelect (MobileElement element, String selection) {
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
    public void hover (String locator) {

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
    public String getCSSValue  (MobileElement element, String propertyName) {
        scrollDown(element);
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
    public void scrollDown(MobileElement element){
        while (!element.isDisplayed()) {
                TouchAction actions = new TouchAction(driver);
                actions.press(PointOption.point(10, 250))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(10, -5))
                        .perform();
        }
    }

    public void scrollUp(MobileElement element){
        while (!element.isDisplayed()) {
            TouchAction actions = new TouchAction(driver);
            actions.press(PointOption.point(10, 100))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(10, 250))
                    .perform();
        }
    }

    public void radioButton(boolean select, MobileElement locatorButtonOne, MobileElement locatorButtonTwo){
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

    public void IosDatePickerWheel(HashMap<String, String> map, MobileElement element){
        System.out.println(map.get("year") + " " + map.get("month") + " " + map.get("day"));
        scrollDown(element);
        click(element);
        WebElement yearElement = (WebElement) driver.findElements(By.className("XCUIElementTypePickerWheel")).get(2);
        yearElement.sendKeys(map.get("year"));
        WebElement monthElement = (WebElement) driver.findElements(By.className("XCUIElementTypePickerWheel")).get(1);
        monthElement.sendKeys(map.get("month"));
        WebElement dayElement = (WebElement) driver.findElements(By.className("XCUIElementTypePickerWheel")).get(0);
        dayElement.sendKeys(map.get("day"));
    }

    public void IosPickerWheel(MobileElement element, String choice){
        scrollDown(element);
        click(element);
        WebElement wheel = (WebElement) driver.findElements(By.className("XCUIElementTypePickerWheel")).get(0);
        wheel.sendKeys(choice);
    }

    public int IosTableCellCount(){
        List cells = driver.findElements(By.className("XCUIElementTypeCell"));
        return cells.size();
    }

    public void clickSpecificIosTableCell(String locator){
        try {
            MobileElement element = (MobileElement) driver.findElement(By.name(locator));
            element.click();
        }
        catch (ElementNotVisibleException e) {
            //TODO: Sysout(e.getMessage());
        }
    }

    public void clickGenericIostableCell(){
        driver.findElement(By.className("XCUIElementTypeCell")).click();
    }

    public int CheckboxSelected(MobileElement element) {
        try {
            int value;
            String s = element.getAttribute("value");
            if (s != null) {
                value = 1;
            } else {
                value = 0;
            }
            return value;
        } catch (ElementNotVisibleException e) {
            System.out.println(e.getMessage());
        }
        return 2;
    }

    public boolean doesKeyboardExist(){
        try {
            MobileElement element = (MobileElement) driver.findElement(By.className("XCUIElementTypeKeyboard"));
            return true;
        }
        catch (ElementNotVisibleException e) {
            return false;
        }
    }
}
