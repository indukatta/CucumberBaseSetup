package pageObjects.CSM;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GuiCommands;


public class SupportScreen extends GuiCommands {

    public SupportScreen(IOSDriver driver) {

        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"customer_support.start_chat\"])[2]")  //FIXME get unique accessibility id
    private MobileElement startSupportChatButton;

    @iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Support\"])[2")  //FIXME get unique accessibility id
    private MobileElement supportButton;

}
