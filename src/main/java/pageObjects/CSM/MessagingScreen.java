package pageObjects.CSM;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testData.RandomDataGenerator;
import utils.GuiCommands;

public class MessagingScreen extends GuiCommands {

    public MessagingScreen(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSFindBy(accessibility = "Close")
    private MobileElement closeScreenButton;

    @iOSFindBy(accessibility = "Menu")
    private MobileElement menu;

    @iOSFindBy(accessibility = "Now")
    private MobileElement timeOfFirstMessage;

    @iOSFindBy(accessibility = "Send")
    private  MobileElement sendButton;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Write a message\"]")  //FIXME get unique accessibility id
    private MobileElement messagingBox;

}



