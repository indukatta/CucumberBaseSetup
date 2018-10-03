package utils;

import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ScreenshotUtils extends GuiCommands {

    public ScreenshotUtils(IOSDriver driver) {
        super(driver);
    }

    /*
     * Read a property from the config.properties file and return the value
     * If value not exist return a 'Value not set or empty' exception
     */
    public void takeScreenshot() {
        String folder;
        DateFormat df;
        folder = "screenshots";
        File file = driver.getScreenshotAs(OutputType.FILE);

        df = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");

        new File(folder).mkdir();

        String file_name = df.format(new Date()) + ".png";

        try {
            FileUtils.copyFile(file, new File(folder + "/" + file_name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

