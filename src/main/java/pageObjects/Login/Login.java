package pageObjects.Login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import utils.GuiCommands;

public class Login extends GuiCommands {
    public Login(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy(accessibility = "welcome.title")
    private MobileElement welcomeTitle;

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

    public boolean islogoutScreenDisplayed() {
        return logoutScreen.isDisplayed();
    }

    public boolean iswelcomeTitleDisplayed() {
        return welcomeTitle.isDisplayed();
    }

    public boolean ispasswordFieldBoxDisplayed() {
        return passwordFieldBox.isDisplayed();
    }


    public boolean isusernameFieldBoxDiplay() {
        return usernameFieldBox.isDisplayed();
    }


    //Click Methods
    public void clickexistingCustomerButton() {
        click(existingCustomerButton);
    }

    public void clickusernameNextButton() {
        click(usernameNextButton);
    }

    public void clickpasswordLoginButton() {
        click(passwordLoginButton);
    }

    public void clicklogoutButton() {
        click(logoutButton);
    }

    public void clickshowPasswordCheckBox() {
        click(showPasswordCheckBox);
    }

    public void clickpasswordFieldBox() {
        click(passwordFieldBox);
    }

    public void clickusernameFieldBox() {
        click(usernameFieldBox);
    }

    //Write Method
    public void writeUsername(String username) {
        writeText(usernameFieldBox, username);
    }

    public void writePassword(String password) {
        writeText(passwordFieldBox, password);
    }


    public boolean successfulLogin() {
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
        return isaccountTitleDisplayed();
    }

    public boolean canUserLogout () {
        successfulLogin();
        clicklogoutButton();
        return islogoutScreenDisplayed();
    }

    public boolean showPasswordCheckBox () {
        clickexistingCustomerButton();
        writeUsername("TESTUSER");
        clickusernameNextButton();
        clickshowPasswordCheckBox();
        return ispasswordFieldBoxDisplayed();
    }

    public boolean navigateToPasswordField () {
        clickexistingCustomerButton();
        writeUsername("TESTUSER");
        clickusernameNextButton();
        clickshowPasswordCheckBox();
        clickpasswordFieldBox();
        return ispasswordFieldBoxDisplayed();
    }

    public boolean navigateToPasswordScreen () {
        clickexistingCustomerButton();
        writeUsername("TESTUSER");
        clickusernameNextButton();
        return ispasswordFieldBoxDisplayed();
    }

    public boolean navigateToUsernameFieldBox () {
        clickexistingCustomerButton();
        clickusernameFieldBox();
        clickusernameNextButton();
        clickpasswordLoginButton();
        return isusernameFieldBoxDiplay();
    }

    public boolean navigateToUsernamePage () {
        clickexistingCustomerButton();
        return isusernameFieldBoxDiplay();
    }

    public boolean logoutTest () {
        successfulLogin();
        clicklogoutButton();
        return iswelcomeTitleDisplayed();
    }

    public void navigateToLogin () {
        clickexistingCustomerButton();
        writeUsername("TESTUSER");
        clickusernameNextButton();
        clickpasswordLoginButton();
    }

    public void passThroughLogin() {
        clickexistingCustomerButton();
        writeUsername("TESTUSER");
        clickusernameNextButton();
        clickpasswordLoginButton();
    }

    public void loginAsUser(String username, String password){
        clickexistingCustomerButton();
        writeUsername(username);
        clickusernameNextButton();
        clearText(passwordFieldBox);
        writePassword(password);
        clickpasswordLoginButton();
    }
}
