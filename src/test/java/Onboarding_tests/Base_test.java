package Onboarding_tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base_test {

    AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("platformVersion", "11.4");
        capabilities.setCapability("deviceName", "iPhone 8");
        capabilities.setCapability("app",
                "/Users/awhitten/Library/Developer/Xcode/DerivedData/" +
                        "Iceberg-dmdimcbnvyefcdajhivuraigymun/Build/Products/Debug-iphonesimulator/Iceberg.app");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    //common validations
    protected void validateTextEquals(String actual, String expected){
        Assert.assertEquals(actual, expected);
    }

    protected void validateIsDisplayed(boolean displayed){
        Assert.assertTrue(displayed);
    }

    protected void validateIsNotDisplayed(boolean displayed){
        Assert.assertFalse(displayed);
    }

    protected void validateEnabled(boolean enabled) {
        Assert.assertTrue(enabled);
    }

    protected void validateNotEmabled(boolean enabled){
        Assert.assertFalse(enabled);
    }

    @After
    public void shutDown(){
        driver.quit();
    }
}
