package pageObjects.CSM;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Login.Login;
import utils.GuiCommands;


public class SupportScreen extends GuiCommands {

    Login login = new Login(driver);

    public SupportScreen(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"customer_support.start_chat\"])[2]")  //FIXME get unique accessibility id
    private MobileElement startSupportChatButton;

    @iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Support\"])[2")  //FIXME get unique accessibility id
    private MobileElement supportButton;

    //Element Displayed
    public boolean isStartSupportChatButtonDisplayed() {
        return startSupportChatButton.isDisplayed();
    }

    public boolean isSupportButtonDisplayed() {
        return supportButton.isDisplayed();
    }

    // Element Enabled
    public boolean isStartSupportChatButtonEnabled() {
        return startSupportChatButton.isEnabled();
    }

    public boolean isSupportButtonEnabled() {
        return supportButton.isEnabled();
    }

    // Clicking Elements
    public void clickStartSupportChatButton() {
        click(startSupportChatButton);
    }

    public void clickSupportButton() {
        click(supportButton);
    }

    // Custom Methods
    public void navigateToSupportScreen() {
        login.passThroughLogin();   // FIXME create passthroughLogin
        clickSupportButton();
    }

    public void passthroughSupportScreen() {
        navigateToSupportScreen();
        clickStartSupportChatButton();
    }

}
