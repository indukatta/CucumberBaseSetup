package pageObjects.Login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import utils.GuiCommands;

public class Login extends GuiCommands {
    public Login(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "welcome.existing_customer_button_title")
    private MobileElement existingCustomerButton;

    @iOSFindBy(accessibility = "Set up")
    private MobileElement backArrowUsername;

    @iOSFindBy(accessibility = "login.login_username_textfield_header")
    private MobileElement usernameFieldBox;

    @iOSFindBy(accessibility = "checkbox_button")
    private MobileElement rememberMeCheckbox;

    @iOSFindBy(accessibility = "next_button_default_title")
    private MobileElement usernameNextButton;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Login\"]") //FIXME get unique accessibility id
    private MobileElement backArrowPassword;

    @iOSFindBy(accessibility = "login.login_password_textfield_header")
    private MobileElement passwordFieldBox;

    @iOSFindBy(accessibility = "checkbox_button")
    private MobileElement showPasswordCheckBox;

    @iOSFindBy(accessibility = "login.login_button_title")
    private MobileElement passwordLoginButton;

    @iOSFindBy(accessibility = "Log out")
    private MobileElement logoutButton;

    @iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"Account\"]") //FIXME get unique accessibility id
    private MobileElement accountTitle;

    @iOSFindBy(xpath = "  //XCUIElementTypeStaticText[@name=\"Set up\"]") //FIXME get unique accessibility id
    private MobileElement logoutScreen;

    @iOSFindBy(accessibility = "Entered an incorrect username or password")
    private MobileElement errorMessage;

    //Elements Displayed
    public boolean isaccountTitleDisplayed() {
        return accountTitle.isDisplayed();
    }

    public boolean iserrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public boolean islogoutScreen() {
        return logoutScreen.isDisplayed();
    }

    //Click Methods
    public void clickexistingCustomerButton() {
        click(existingCustomerButton);
    }

    public void clickusernameNextButton() {
        click(usernameNextButton);
    }

    public void clickpasswordFieldBox() {
        click(usernameNextButton);
    }

    public void clickpasswordLoginButton() {
        click(passwordLoginButton);
    }

    public void clicklogoutButton() {
        click(logoutButton);
    }

    public void clickshowPasswordCheckBox() {
        click(logoutButton);
    }

    //Write Method
    public void writeUsername(String username) {
        writeText(usernameFieldBox, username);
    }
    public void writePassword (String password){
        writeText(passwordFieldBox, password);
    }

   // Custom Methods
   public boolean passThroughLogin () {
            clickexistingCustomerButton();
            writeUsername("TESTUSER");
            clickusernameNextButton();
            clickpasswordLoginButton();

            return isaccountTitleDisplayed();
    }

   public boolean incorrectLogin () {
            clickexistingCustomerButton();
            writeUsername("TESTUSE");
            clickusernameNextButton();
            clickpasswordLoginButton();

            return iserrorMessageDisplayed();

   }

   public boolean incorrectPassword () {
            clickexistingCustomerButton();
            writeUsername("TESTUSER");
            clickusernameNextButton();
            clickshowPasswordCheckBox();
            clickpasswordFieldBox();
            writePassword("TESTPASSWOR");
            clickpasswordLoginButton();

            return iserrorMessageDisplayed();
    }

            public boolean logoutTest () {
                passThroughLogin();
                clicklogoutButton();

                return islogoutScreen();

     }

}