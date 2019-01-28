package testUtils;

import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.factory.mobile.driver.AppiumDriverBase.AppType;

import static com.factory.mobile.driver.AppiumDriverManager.setAppiumDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Base_test {

    protected static IOSDriver driver = null;
    String folder;
    DateFormat df;

    ConfigReader config = new ConfigReader();

    
    @BeforeMethod
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", config.getPlatformName());
        capabilities.setCapability("platformVersion", config.getVersion());
        capabilities.setCapability("deviceName", config.getDeviceName());
        capabilities.setCapability("app", config.getAppPath());

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        setAppiumDriver(AppType.IOSAPP, driver);
    }

    @AfterMethod()
    public void takeScreenShot(){
//        folder = "screenshots";
//        File file = driver.getScreenshotAs(OutputType.FILE);
//
//        df = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
//
//        new File(folder).mkdir();
//
//        String file_name = df.format(new Date())+".png";
//
//        try {
//            FileUtils.copyFile(file, new File(folder + "/" + file_name));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        driver.quit();
    }

}
