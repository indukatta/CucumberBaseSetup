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

    @iOSFindBy(accessibility = "customer_support.start_chat")  //FIXME get unique accessibility id
    private MobileElement startSupportChatButton;

    @iOSFindBy(accessibility = "Support")
    private MobileElement supportButton;

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
    public boolean navigateToSupportScreen() {
        login.navigateToLogin();
        clickSupportButton();
        return startSupportChatButton.isDisplayed();
    }

//    public void passthroughSupportScreen() {
//        navigateToSupportScreen();
//        clickStartSupportChatButton();
//    }

}
