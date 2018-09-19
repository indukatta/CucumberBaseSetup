package paymentsPageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import utils.GuiCommands;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

public class AvailableBalance extends GuiCommands {

    public AvailableBalance(IOSDriver driver) {
        super(driver);
    }

    @iOSFindBy (accessibility = "welcome.existing_customer_button_title")
    private MobileElement existCustomer;

    @iOSFindBy (accessibility = "login.login_username_textfield_header")
    private MobileElement usernameField;

    @iOSFindBy (accessibility = "next_button_default_title")
    private MobileElement nextButton;

    @iOSFindBy (accessibility = "login.login_password_textfield_header")
    private MobileElement passwordField;

    @iOSFindBy (accessibility = "login.login_button_title")
    private MobileElement loginButton;

    @iOSFindBy (accessibility = "availableBalanceValueLabel")
    private MobileElement hsAvailableBalance;

    @iOSFindBy (accessibility = "Payments")
    private MobileElement paymentsTab;

    @iOSFindBy (accessibility = "payments.make_payment_button_title")
    private MobileElement newPaymentButton;

    @iOSFindBy (accessibility = "payee_details.name_textfield_header")
    private MobileElement payeeName;

    @iOSFindBy (accessibility = "payee_details.sort_code_textfield_header")
    private MobileElement payeeSortCode;

    @iOSFindBy (accessibility = "payee_details.account_number_textfield_header")
    private MobileElement payeeAccNumber;

    @iOSFindBy (accessibility = "payments.continue_button_title")
    private MobileElement continueButton;

    @iOSFindBy (accessibility = "payment_details.amount_textfield_header")
    private MobileElement payAmount;

    @iOSFindBy (accessibility = "payment_details.reference_textfield_header")
    private MobileElement reference;

    @iOSFindBy (accessibility = "56,455.02 GBP")
    private MobileElement psAvailableBalance;

    @iOSFindBy(accessibility = "Payments")
    private MobileElement payDeteailsBB;

    @iOSFindBy(accessibility = "Cancel")
    private MobileElement cancelButton;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Paying someone new\"]")
    private MobileElement payNewPersonBB;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Paying someone new\"]")
    private MobileElement summaryBB;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Paying someone new\"")
    private MobileElement summaryTitle;

    @iOSFindBy(accessibility = "OK")
    private MobileElement okButton;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Payments\"]")
    private MobileElement paymentsTitle;


    //Enabled Methods

    //Click Methods

    public void clickNext(){ click(nextButton);}

    public void clickContinue() {click(continueButton);}

    public void clickPaymentTab(){click(paymentsTab);}

    public void clickNewPayee() {click(newPaymentButton);}

    public void clickExistingCustomer() {click(existCustomer);}

    public void clickLogin() {click(loginButton);}


    //Custom Methods


    public void login(){

        clickExistingCustomer();
        writeText(usernameField,"TESTUSER");
        clickNext();
        clickLogin();
    }

    public boolean isAvailBalanceEqual (){

        login();
        String check1 = hsAvailableBalance.getText().replaceAll("[^0-9]","");
        clickPaymentTab();
        clickNewPayee();
        populatePaymentDetails();
        String check2 = psAvailableBalance.getText().replaceAll("[^0-9]","");

        if ((Integer.parseInt(check1)) == (Integer.parseInt(check2) )){
            return true;
        }
        else { return false;}

    }

    public boolean cancelButtonVerification(){

        login();
        clickPaymentTab();
        clickNewPayee();
        populatePaymentDetails();
        click(cancelButton);
        boolean one = paymentsTitle.isDisplayed();
        clickNewPayee();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String field1 = usernameField.getText();
        System.out.println("field 1 is: "+field1);
        boolean two;

        if (Integer.parseInt(field1) == 0){
             two = true;
        }
        else {
             two = false;
        }

        populatePaymentDetails();
        populateRefPage();
        click(cancelButton);
        boolean three = paymentsTitle.isDisplayed();
        clickNewPayee();
        String field2 = usernameField.getText();
        boolean four;
        if (Integer.parseInt(field2) == 0){
             four = true;
        }
        else {
             four = false;
        }

        return one && two && three && four;
    }

    public void populatePaymentDetails(){

        writeText(payeeName,"John does");
        writeNumber(payeeSortCode,123456);
        writeNumber(payeeAccNumber,12345678);
        clickContinue();

    }
    public void populateRefPage(){

        writeNumber(payAmount,12000);
        writeText(reference,"The Reference");
        clickContinue();
    }





}
