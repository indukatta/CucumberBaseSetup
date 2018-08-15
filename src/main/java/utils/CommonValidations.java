package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;

public class CommonValidations extends GuiCommands {

    /**
     * Inherited Constructor
     * @param driver
     */
    public CommonValidations(AppiumDriver driver) {
        super(driver);
    }

    /**
     *
     * @param results
     */
    public void assertResultsReturned(int results){
        Assert.assertTrue(results > 0);
    }

    /**
     *
     * @param actual
     * @param expected
     */
    public void assertEquals(String actual, String expected){
        Assert.assertEquals(actual, expected);
    }

    /**
     *
     * @param place
     * @param comparison
     */
    public void assertNotEqual(String place, String comparison){
        Assert.assertNotEquals(place, comparison);
    }

    /**
     *
     * @param displayed
     */
    public void assertIsDisplayed(String displayed){
        MobileElement element = (MobileElement) driver.findElement(By.name(displayed));
        synchElement(element);
        Assert.assertTrue(element.isDisplayed());
    }

    /**
     *
     * @param displayed
     */
    public void assertIsNotDisplayed(String displayed){
        MobileElement element = (MobileElement) driver.findElement(By.name(displayed));
        synchElement(element);
        Assert.assertFalse(element.isDisplayed());
    }

    /**
     *
     * @param enabled
     */
    public void assertEnabled(String enabled) {
        try {
            MobileElement element = (MobileElement) driver.findElement(By.name(enabled));
            Assert.assertTrue(element.isEnabled());
        }
        catch (ElementNotVisibleException e) {
            //TODO: Sysout(e.getMessage());
        }
    }

    /**
     *
     * @param enabled
     */
    public void assertNotEnabled(String enabled){
        try {
            MobileElement element = (MobileElement) driver.findElement(By.name(enabled));
            Assert.assertFalse(element.isEnabled());
        }
        catch (ElementNotVisibleException e) {
            System.out.println(e.getMessage());
        }
    }

    //VERIFICATIONS

    /**
     *
     * @param results
     * @param testCaseID
     */
    public void verifyNoResultsReturn(int results, String testCaseID){
        try{
            Assert.assertEquals(0, results);
        }
        catch (Throwable failure) {
            System.out.println(testCaseID + " " + "FAILED" + " " + failure.getMessage());
        }
    }

    /**
     *
     * @param actual
     * @param expected
     * @param testCaseID
     */
    public void verifyEquals(String actual, String expected, String testCaseID){
        try {
            Assert.assertEquals(actual, expected);
        }
        catch (Throwable failure) {
            System.out.println(testCaseID + " " + "FAILED" + " " + failure.getMessage());
        }
    }

    /**
     *
     * @param actual
     * @param expected
     * @param testCaseID
     */
    public void verifyEquals(int actual, int expected, String testCaseID){
        try {
            Assert.assertEquals(actual, expected);
        }
        catch (Throwable failure) {
            System.out.println(testCaseID + " " + "FAILED" + " " + failure.getMessage());
        }
    }

    /**
     *
     * @param displayed
     * @param testCaseID
     */
    public void verifyIsDisplayed(String displayed, String testCaseID){
        try {
            MobileElement element = (MobileElement) driver.findElement(By.name(displayed));
            synchElement(element);
            Assert.assertTrue(element.isDisplayed());
        }
        catch (Throwable failure) {
            System.out.println(testCaseID + " " + "FAILED" + " " + failure.getMessage());
        }
    }

    /**
     *
     * @param locator
     * @param testCaseID
     */
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

    /**
     *
     * @param enabled
     * @param testCaseID
     */
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

    /**
     *
     */
    public void verifyKeyboardVisible(){
        try {
            MobileElement element = (MobileElement) driver.findElement(By.className("XCUIElementTypeKeyboard"));
            Assert.assertTrue(element.isEnabled());
        }
        catch (ElementNotVisibleException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param locator
     * @param testCaseID
     */
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

    /**
     *
     * @param locator
     * @param testCaseID
     */
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

    /**
     *
     * @param locator
     * @param testCaseID
     */
    public void verifyTextboxIsEmpty(String locator, String testCaseID){
        try {
            MobileElement element = (MobileElement) driver.findElement(By.name(locator));
            String s = element.getText();
            if (s != null){
                Assert.fail();
            } else {
                Assert.assertTrue(true);
            }
        }
        catch (NullPointerException e){
            Assert.assertTrue(true);
        }
        catch (Throwable failure) {
            System.out.println(testCaseID + " " + "FAILED" + " " + failure.getMessage());
        }
    }
}
