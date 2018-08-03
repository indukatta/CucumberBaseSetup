package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;

public class CommonValidations extends GuiCommands {

    public CommonValidations(AppiumDriver driver) {
        super(driver);
    }

    //common validations
    public void assertResultsReturned(int results){
        Assert.assertTrue(results > 0);
    }

    public void assertEquals(String actual, String expected){
        Assert.assertEquals(actual, expected);
    }

    public void verifyEquals(String actual, String expected){
        try {
            Assert.assertEquals(actual, expected);
        }
        catch (Throwable failure) {
            System.out.println("FAILED" + " " + failure.getMessage());
        }
    }

    public void assertNotEqual(String place, String comparison){
        Assert.assertNotEquals(place, comparison);
    }

    public void assertIsDisplayed(String displayed){
        MobileElement element = (MobileElement) driver.findElement(By.name(displayed));
        synchElement(element);
        Assert.assertTrue(element.isDisplayed());
    }

    public void verifyIsDisplayed(String displayed){
        try {
            MobileElement element = (MobileElement) driver.findElement(By.name(displayed));
            synchElement(element);
            Assert.assertTrue(element.isDisplayed());
        }
        catch (Throwable failure) {
            System.out.println("FAILED" + " " + failure.getMessage());
        }
    }

    public void assertIsNotDisplayed(String displayed){
        MobileElement element = (MobileElement) driver.findElement(By.name(displayed));
        synchElement(element);
        Assert.assertFalse(element.isDisplayed());
    }

    public void assertEnabled(String enabled) {
        try {
            MobileElement element = (MobileElement) driver.findElement(By.name(enabled));
            Assert.assertTrue(element.isEnabled());
        }
        catch (ElementNotVisibleException e) {
            //TODO: Sysout(e.getMessage());
        }
    }

    public void verifyEnabled(String locator, String testCaseID) {
        try {
            MobileElement element = (MobileElement) driver.findElement(By.name(locator));
            Assert.assertTrue(element.isEnabled());
        }
        catch (ElementNotVisibleException e) {
            //TODO: Sysout(e.getMessage());
        }
        catch (Throwable failure) {
            System.out.println(testCaseID + " " + "FAILED" + " " + failure.getMessage());
        }
    }

    public void assertNotEnabled(String enabled){
        try {
            MobileElement element = (MobileElement) driver.findElement(By.name(enabled));
            Assert.assertFalse(element.isEnabled());
        }
        catch (ElementNotVisibleException e) {
            System.out.println(e.getMessage());
        }
    }

    public void verifyNotEnabled(String enabled, String testCaseID){
        try {
            MobileElement element = (MobileElement) driver.findElement(By.name(enabled));
            Assert.assertFalse(element.isEnabled());
        }
        catch (ElementNotVisibleException e) {
            System.out.println(e.getMessage());
        }
        catch (Throwable failure) {
            System.out.println(testCaseID + " " + "FAILED" + " " + failure.getMessage());
        }
    }

    public void verifyKeyboardVisible(){
        try {
            MobileElement element = (MobileElement) driver.findElement(By.className("XCUIElementTypeKeyboard"));
            Assert.assertTrue(element.isEnabled());
        }
        catch (ElementNotVisibleException e) {
            System.out.println(e.getMessage());
        }
    }

    public void verifyCheckboxIsNotSelected(String locator, String testCaseID){
        try {
            int value;
            MobileElement element = (MobileElement) driver.findElement(By.name(locator));
            String s = element.getAttribute("value");
            if (s != null){
                value = 1;
            } else {
                value = 0;
            }
            Assert.assertEquals(value, 0);
        }
        catch (ElementNotVisibleException e) {
            System.out.println(e.getMessage());
        }
        catch (Throwable failure) {
            System.out.println(testCaseID + " " + "FAILED" + " " + failure.getMessage());
        }
    }

    public void verifyCheckboxIsSelected(String locator, String testCaseID){
        try {
            int value;
            MobileElement element = (MobileElement) driver.findElement(By.name(locator));
            String s = element.getAttribute("value");
            if (s != null){
                value = 1;
            } else {
                value = 0;
            }
            Assert.assertEquals(value, 1);
        }
        catch (ElementNotVisibleException e) {
            System.out.println(e.getMessage());
        }
        catch (Throwable failure) {
            System.out.println(testCaseID + " " + "FAILED" + " " + failure.getMessage());
        }
    }
}
