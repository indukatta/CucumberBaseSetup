package paymentsPageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import pageObjects.Login.Login;
import utils.GuiCommands;

import java.util.concurrent.TimeUnit;

public class AvailableBalance extends GuiCommands {

    Login login = new Login(driver);

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

    @iOSFindBy (accessibility = "payment_details.available_balance_label_value")
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

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Paying someone new\"]")
    private MobileElement payDetailsTitle;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Paying someone new\"]")
    private MobileElement payRefTitle;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Paying someone new\"]")
    private MobileElement paymentDetailsBB;

    // Summary page

    @iOSFindBy(accessibility = "payment_confirmation.sort_code_label_value")
    private MobileElement summarySortCode;

    @iOSFindBy(accessibility = "payment_confirmation.account_number_label_value")
    private  MobileElement summaryAccNumber;

    @iOSFindBy(accessibility = "payment_confirmation.reference_label_value")
    private MobileElement summaryReference;

    @iOSFindBy(accessibility = "payment_confirmation.confirm_payment_message")
    private MobileElement disclaimerMessage;

    @iOSFindBy(accessibility = "payment_confirmation.about_to_pay_label_value")
    private MobileElement summaryAmount;

    @iOSFindBy(accessibility = "payment_confirmation.make_payment_button_title")
    private MobileElement makePaymentButton;



    //Click Methods

    public void clickNext(){ click(nextButton);}

    public void clickContinue() {click(continueButton);}

    public void clickPaymentTab(){click(paymentsTab);}

    public void clickNewPayee() {click(newPaymentButton);}

    public void clickExistingCustomer() {click(existCustomer);}

    public void clickLogin() {click(loginButton);}


    //Custom Methods

    public boolean isAvailBalanceEqual (){

        login.navigateToLogin();
        String check1 = hsAvailableBalance.getText().replaceAll("[^0-9]","");
        clickPaymentTab();
        clickNewPayee();
        passThroughPayeeDetails();
        String check2 = psAvailableBalance.getText().replaceAll("[^0-9]","");
        if (check1.equals(check2)){
            return true;
        }
        else { return false;}
    }

    public boolean cancelButtonVerification(){

        login.navigateToLogin();
        clickPaymentTab();
        clickNewPayee();
        passThroughPayeeDetails();
        click(cancelButton);
        boolean one = paymentsTitle.isDisplayed();
        clickNewPayee();
        boolean two = payeeName.getText().isEmpty();
        passThroughPayeeDetails();
        passThroughRefPage();
        click(cancelButton);
        boolean three = paymentsTitle.isDisplayed();
        clickNewPayee();
        boolean four = payeeName.getText().isEmpty();

        return one && two && three && four;
    }

    public void populatePayeeDetails(){

        writeText(payeeName,"Jane doe");
        writeNumber(payeeSortCode,123456);
        writeNumber(payeeAccNumber,12345678);
    }
    public void populateRefPage(){

        writeNumber(payAmount,666);
        writeText(reference,"The end is near");
    }

    public void passThroughPayeeDetails(){

        writeText(payeeName,"John doe");
        writeNumber(payeeSortCode,123456);
        writeNumber(payeeAccNumber,12345678);
        clickContinue();
    }
    public void passThroughRefPage(){

        writeNumber(payAmount,12000);
        writeText(reference,"The Reference");
        clickContinue();
    }


    public boolean goBackFromSummaryPage (){




        login.navigateToLogin();
        clickPaymentTab();
        clickNewPayee();
        passThroughPayeeDetails();
        passThroughRefPage();
        click(summaryBB);
        boolean one = payRefTitle.isDisplayed();
        boolean two = payAmount.getText().equals("1,200.00");
        boolean three = reference.getText().equals("The Reference");

        return one && two && three;
    }

    public boolean goBackFromPayeeDetails(){

        login.navigateToLogin();
        clickPaymentTab();
        clickNewPayee();
        populatePayeeDetails();
        click(payDeteailsBB);
        boolean one = paymentsTitle.isDisplayed();
        clickNewPayee();
        boolean two = payeeName.getText().isEmpty();
        if(two == false) two =true;

        return one && two;
    }

    public boolean goBackFromPaymentsDetailsPage(){

        login.navigateToLogin();
        clickPaymentTab();
        clickNewPayee();
        passThroughPayeeDetails();
        click(paymentDetailsBB);
        boolean one = payeeName.getText().equals("John doe");
        clearText(payeeName);
        writeText(payeeName,"Test data");
        boolean two;
        if (payeeName.getText().equals("John doe")) two = false;
        //driver.findElementById("to john doe");

        else  two = true;

        return one && two;
    }

    public boolean isPaymentInfoKept(){

        login.navigateToLogin();
        clickPaymentTab();
        clickNewPayee();
        passThroughPayeeDetails();
        populateRefPage();
        click(paymentDetailsBB);
        clickContinue();
        boolean one = payAmount.getText().replaceAll("[^0-9]","").equals("66600");
        boolean two = reference.getText().equals("The end is near");

        return one && two;
    }

    public boolean isAllSummaryDisplayed(){
        login.navigateToLogin();
        clickPaymentTab();
        clickNewPayee();
        passThroughPayeeDetails();
        passThroughRefPage();

        boolean one = driver.findElementById("to John doe").isDisplayed();
        boolean two = summaryAccNumber.isDisplayed();
        boolean three = summarySortCode.isDisplayed();
        boolean four = summaryAmount.isDisplayed();
        boolean five = summaryReference.isDisplayed();
        boolean six = disclaimerMessage.isDisplayed();
        boolean seven = makePaymentButton.isDisplayed();

        return one && two && three && four && five && six && seven;
    }









}
