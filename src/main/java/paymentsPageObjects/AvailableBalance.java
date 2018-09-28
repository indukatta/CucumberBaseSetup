package paymentsPageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.NoSuchElementException;
import pageObjects.Login.Login;
import utils.GuiCommands;

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

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Paying someone new\"]")
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

    @iOSFindBy(accessibility = "Delete")
    private MobileElement numPadDel;

    @iOSFindBy(accessibility = ".")
    private MobileElement  decimalDot;

    // Summary page elements

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

    @iOSFindBy(accessibility = "GBP")
    private MobileElement poundSign;

    //Click Methods

    public void clickNext(){ click(nextButton);}

    public void clickContinue() {click(continueButton);}

    public void clickPaymentTab(){click(paymentsTab);}

    public void clickNewPayee() {click(newPaymentButton);}

    public void clickExistingCustomer() {click(existCustomer);}

    public void clickLogin() {click(loginButton);}

    //Custom Methods
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

        writeNumber(payAmount,1200);
        writeText(reference,"The Reference");
        clickContinue();
    }
    public void  navigateToPaymentpage(){

        login.navigateToLogin();
        clickPaymentTab();
        clickNewPayee();
    }

    //Test Methods
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
        navigateToPaymentpage();
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
    public boolean goBackFromSummaryPage (){
        navigateToPaymentpage();
        passThroughPayeeDetails();
        passThroughRefPage();
        click(summaryBB);
        boolean one = payRefTitle.isDisplayed();
        boolean two = payAmount.getText().equals("1,200.00");
        boolean three = reference.getText().equals("The Reference");

        return one && two && three;
    }
    public boolean goBackFromPayeeDetails(){
        navigateToPaymentpage();
        populatePayeeDetails();
        click(payDeteailsBB);
        boolean one = paymentsTitle.isDisplayed();
        clickNewPayee();
        boolean two = payeeName.getText().isEmpty();
        if(two == false) two =true;

        return one && two;
    }
    public boolean goBackFromPaymentsDetailsPage(){
        navigateToPaymentpage();
        passThroughPayeeDetails();
        click(paymentDetailsBB);
        boolean one = payeeName.getText().equals("John doe");
        clearText(payeeName);
        writeText(payeeName,"Test data");
        boolean two = (payeeName.getText().equals("Test data"));

        return one && two;
    }
    public boolean isPaymentInfoKept(){
        navigateToPaymentpage();
        passThroughPayeeDetails();
        populateRefPage();
        click(paymentDetailsBB);
        clickContinue();
        boolean one = payAmount.getText().replaceAll("[^0-9]","").equals("66600");
        boolean two = reference.getText().equals("The end is near");

        return one && two;
    }
    public boolean isAllSummaryDisplayed(){
        navigateToPaymentpage();
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
    public boolean sortCodeValidator(){
        navigateToPaymentpage();
        writeNumber(payeeSortCode,1);
        boolean one = numPadDel.isDisplayed();
        writeNumber(payeeSortCode,234567);
        click(payeeName);
        boolean two = payeeSortCode.getText().equals("12-34-56");

        return one && two;
    }
    public boolean accountNumberValidator(){
        navigateToPaymentpage();
        writeText(payeeName,"Robo Cop");
        writeNumber(payeeSortCode,234567);
        boolean one = false;
        for (int i = 1; i < 10; i++){
            if (continueButton.isEnabled()){
                writeNumber(payeeAccNumber,i);
                 one = payeeAccNumber.getText().equals("12345678");
                 break;
            }
            else {
                writeNumber(payeeAccNumber,i);
            }
        }
        return one;
    }
    public boolean isContinueButtonWorking(){
        navigateToPaymentpage();
        writeText(payeeName,"Monkey D Luffy");
        boolean one = !continueButton.isEnabled();
        writeNumber(payeeSortCode,777777);
        boolean two = !continueButton.isEnabled();
        writeNumber(payeeAccNumber,12345678);
        clickContinue();
        boolean three = psAvailableBalance.isDisplayed();

        return one && two && three;
    }

    public boolean isCurrencyDisplayed(){
        navigateToPaymentpage();
        passThroughPayeeDetails();
        writeNumber(payAmount,1500);
        boolean one = poundSign.isDisplayed();
        writeText(poundSign,"USD");
        boolean two = poundSign.getText().equals("GBP");

        return one && two;
    }

    public boolean isContinuebtnEnabled(){
        navigateToPaymentpage();
        passThroughPayeeDetails();
        writeNumber(payAmount,1234);
        boolean two = !continueButton.isEnabled();
        writeText(reference,"You can do it");
        clickContinue();
        boolean three = summarySortCode.isDisplayed();

        return  two && three;
    }
    public boolean startPaymentJourneyAndEnterPayeeDetails(){
        navigateToPaymentpage();
        boolean one = payeeName.isDisplayed();
        boolean two = payeeSortCode.isDisplayed();
        boolean three = payeeAccNumber.isDisplayed();
        boolean four = continueButton.isDisplayed();

        return one && two && three && four;
    }
    public boolean payeeDetailsNameField() {
        navigateToPaymentpage();
        writeNumber(payeeSortCode, 123456);
        writeNumber(payeeAccNumber, 12345678);
        boolean one = !continueButton.isEnabled();
        writeText(payeeName, "John doe 123456789");
        boolean two = continueButton.isEnabled();
        clearText(payeeName);
        writeText(payeeName, "John does 123456789");
        boolean three = payeeName.getText().equals("John does 12345678");

        return one && two && three;
    }
    public boolean paymentAmountValidator() {
        boolean one;
        boolean two =false ;
        boolean three;
        int count =0;
        String [] correctValues = {"0.01","5000"};
        String [] incorrectValues = {"5000.01","5500","5.234"};

        navigateToPaymentpage();
        passThroughPayeeDetails();
        click(payAmount);
        boolean five = decimalDot.isDisplayed();
        writeText(reference,"Mike check one two");
        for (String val : correctValues){
            writeText(payAmount,val);
            if (continueButton.isEnabled()) count++;
            clearText(payAmount);
        }
        if (count == 2){
            one = true;
            count= 0;
        }
        else {
            one = false;
            count= 0;
        }
        for (String val : incorrectValues){
            writeText(payAmount,val);
            if (!payAmount.getText().equals(val) || !continueButton.isEnabled()) count++;
            clearText(payAmount);
        }
        if (count == 3){
            two = true;
        }
        writeText(payAmount,"3500.1");
        boolean four = payAmount.getText().equals("3500.1");
        click(reference);
        three = payAmount.getText().equals("3,500.10");
        return one && two && three && four && five;
    }
    public boolean isGpbDisplayedInactive (){
        navigateToPaymentpage();
        passThroughPayeeDetails();
        click(reference);
        boolean one;
        try {
            one = !poundSign.isDisplayed();
        }
        catch (NoSuchElementException e) {
            one = true;
        }
        return one;
    }
    public boolean referenceFieldValidator(){
        navigateToPaymentpage();
        passThroughPayeeDetails();
        writeNumber(payAmount,1222);
        writeText(reference,"Abc345 / ., -/..ps");
        boolean one = continueButton.isEnabled();
        clearText(reference);
        boolean two = !continueButton.isEnabled();
        writeText(reference,"This is kinda longer");
        boolean three = !reference.getText().equals("This is kinda longer");
        clearText(reference);
        writeText(reference," ");
        boolean four = !continueButton.isEnabled();
        writeText(reference," Hiya!");
        boolean five = !continueButton.isEnabled();

        return one && two && three && four && five;
    }





}
