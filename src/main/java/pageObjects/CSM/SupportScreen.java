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
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @iOSFindBy(accessibility = "customer_support.chat_button_title")
    private MobileElement chatWithUsButton;

    @iOSFindBy(accessibility = "Support")
    private MobileElement supportButton;

    @iOSFindBy(xpath = "//XCUIElementTypeAlert[@name=\"“Iceberg” Would Like to Send You Notifications\"]")
    private MobileElement notificationBox;

    @iOSFindBy(accessibility = "Allow")
    private MobileElement allowNotificationsButton;

    public boolean isSupportButtonDisplayed() {
        return supportButton.isDisplayed();
    }

    // Element Enabled
    public boolean ischatWithUsButtonEnabled() {
        return chatWithUsButton.isEnabled();
    }

    public boolean isSupportButtonEnabled() {
        return supportButton.isEnabled();
    }

    // Clicking Elements
    public void clickchatWithUsButton() {
        click(chatWithUsButton);
    }

    public void clickSupportButton() {
        click(supportButton);
    }
    public void clickallowNotificationsButton() {
        click(allowNotificationsButton);
    }
        // Custom Methods
        public boolean navigateToSupportScreen() {
            login.navigateToLogin();
            clickSupportButton();
            return chatWithUsButton.isDisplayed();
        }
        public void passToMessageScreen () {
            login.navigateToLogin();
            clickSupportButton();
            clickchatWithUsButton();
            clickallowNotificationsButton();

        }

}


