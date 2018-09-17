package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GuiCommands;

public class SupportScreen extends GuiCommands {

    private SetUp setup = new SetUp(driver);

    public Support (IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy (xpath = "(//XCUIElementTypeButton[@name=\"customer_support.start_chat\"])[3]")
    private MobileElement startSupportChatButton;
    
}
