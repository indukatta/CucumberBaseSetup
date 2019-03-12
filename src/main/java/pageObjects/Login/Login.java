package pageObjects.Login;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import testData.getUserData.GetUserData;
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

    @iOSFindBy(accessibility = "Allow")
    private MobileElement allowNotification;

    @iOSFindBy(accessibility = "Don’t Allow")
    private MobileElement dontAllowNotification;

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
    public void clickexistingCustomerButton() { click(existingCustomerButton); }

    public void clickallowNotifacation() { click(allowNotification); }

    public void clickdontAllowNotifacation() { click(dontAllowNotification); }

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
    public boolean incorrectLogin() {
        clickexistingCustomerButton();
        writeUsername("TESTUSE");
        clickusernameNextButton();
        clickpasswordLoginButton();
        return iserrorMessageDisplayed();
    }

    public boolean incorrectPassword() {
        clickexistingCustomerButton();
        writeUsername("TESTUSER");
        clickusernameNextButton();
        clickshowPasswordCheckBox();
        clickpasswordFieldBox();
        writePassword("TESTPASSWOR");
        clickpasswordLoginButton();
        return isaccountTitleDisplayed();
    }

    public boolean canUserLogout() {
        successfulLogin();
        clicklogoutButton();
        return islogoutScreenDisplayed();
    }

    public boolean showPasswordCheckBox() {
        clickexistingCustomerButton();
        writeUsername("TESTUSER");
        clickusernameNextButton();
        clickshowPasswordCheckBox();
        return ispasswordFieldBoxDisplayed();
    }

    public boolean navigateToPasswordField() {
        clickexistingCustomerButton();
        writeUsername("TESTUSER");
        clickusernameNextButton();
        clickshowPasswordCheckBox();
        clickpasswordFieldBox();
        return ispasswordFieldBoxDisplayed();
    }

    public boolean navigateToPasswordScreen() {
        clickexistingCustomerButton();
        writeUsername("TESTUSER");
        clickusernameNextButton();
        return ispasswordFieldBoxDisplayed();
    }

    public boolean navigateToUsernameFieldBox() {
        clickexistingCustomerButton();
        clickusernameFieldBox();
        clickusernameNextButton();
        clickpasswordLoginButton();
        return isusernameFieldBoxDiplay();
    }

    public boolean navigateToUsernamePage() {
        clickexistingCustomerButton();
        return isusernameFieldBoxDiplay();
    }

    public boolean logoutTest() {
        successfulLogin();
        clicklogoutButton();
        return iswelcomeTitleDisplayed();
    }

    public void navigateToLogin() {
        clickexistingCustomerButton();
        writeUsername("TESTUSER");
        clickusernameNextButton();
        clickpasswordLoginButton();
        click(allowNotification);
    }

    public void passThroughLogin() {
        clickexistingCustomerButton();
        writeUsername("TESTUSER");
        clickusernameNextButton();
        clickpasswordLoginButton();
        clickallowNotifacation();
    }

    public void loginAsUser(String username, String password) {
        clickexistingCustomerButton();
//        try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        driver.findElement(MobileBy.AccessibilityId("checkbox_button")).click();
//        try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        boolean check = driver.findElement(MobileBy.AccessibilityId("checkbox_button")).isSelected();
//        System.out.println("AAAAAAAAAAA"+check);
        writeUsername(username);
        clickusernameNextButton();
        clearText(passwordFieldBox);
        writePassword(password);
        clickpasswordLoginButton();
//        click(dontAllowNotification);
    }

    public void setLogin(String user){

        switch (user){
            case "FIRST TIME":
                loginAsUser((String) GetUserData.getFirstTimeUser().get("Username"), (String) GetUserData.getFirstTimeUser().get("Password"));
                break;
            case "NO TRANSACTION":
                loginAsUser((String) GetUserData.getNoTransactionUser().get("Username"), (String) GetUserData.getNoTransactionUser().get("Password"));

        }
    }

    public void dontAllowNotificationLogin(){
        navigateToLogin();
        clickdontAllowNotifacation();
    }

}
