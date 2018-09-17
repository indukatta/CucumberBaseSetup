package pageObjects.Login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GuiCommands;

public class Login extends GuiCommands{

    public Login (IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSFindBy(accessibility = "welcome.existing_customer_button_title")
    private MobileElement alreadyRegisteredButton;

    @iOSFindBy (accessibility = "Set up")
    private MobileElement usernameScreenBackArrow;

    @iOSFindBy (accessibility = "Username")
    private MobileElement usernameBox;

    @iOSFindBy (accessibility = "login.login_username.remember_me")
    private MobileElement rememberCheckBox;

    @iOSFindBy (accessibility = "next_button_default_title")
    private MobileElement loginNextButton;

    @iOSFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Login\"]")  //FIXME get unique accessibility id
    private MobileElement loginTitle;

    @iOSFindBy (xpath = "//XCUIElementTypeButton[@name=\"Login\"]")  //FIXME get unique accessibility id
    private MobileElement passwordScreenBackArrow;

    @iOSFindBy (xpath = "//XCUIElementTypeApplication[@name=\"Iceberg\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/" +
            "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeSecureTextField")   //FIXME get unique accessibility id
    private MobileElement passwordBox;

    @iOSFindBy (accessibility = "checkbox_button")
    private MobileElement showPasswordCheckboxButton;

    @iOSFindBy (accessibility = "login.login_button_title")
    private MobileElement actualLoginButton;

    @iOSFindBy (xpath = "(//XCUIElementTypeButton[@name=\"Log out\"])[1]")  //FIXME get unique accessibility id
    private MobileElement logoutButton;

    @iOSFindBy (xpath = "(//XCUIElementTypeOther[@name=\"Account\"])[1]")  //FIXME get unique accessibility id
    private MobileElement accountTitle;

    @iOSFindBy (xpath = "(//XCUIElementTypeStaticText[@name=\"ledgerBalanceValueLabel\"])[2]")  //FIXME get unique accessibility id
    private MobileElement balanceAmount;

    @iOSFindBy (xpath = "(//XCUIElementTypeButton[@name=\"Overview\"])[1]")  //FIXME get unique accessibility id
    private MobileElement overviewButton;

    @iOSFindBy (xpath = "(//XCUIElementTypeButton[@name=\"Accounts\"])[1]")  //FIXME get unique accessibility id
    private MobileElement accountsButton;

    @iOSFindBy (xpath = "(//XCUIElementTypeButton[@name=\"Payments\"])[1]")  //FIXME get unique accessibility id
    private MobileElement paymentsButton;

    @iOSFindBy (xpath = "(//XCUIElementTypeButton[@name=\"Support\"])[1]")  //FIXME get unique accessibility id
    private MobileElement supportButton;

    @iOSFindBy (xpath = "(//XCUIElementTypeButton[@name=\"More\"])[1]")  //FIXME get unique accessibility id
    private MobileElement moreButton;

}


