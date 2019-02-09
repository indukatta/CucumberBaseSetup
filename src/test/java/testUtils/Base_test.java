package testUtils;

import static com.factory.mobile.driver.AppiumDriverManager.setAppiumMobileDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.ios.IOSDriver;

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
        setAppiumMobileDriver(driver);
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
