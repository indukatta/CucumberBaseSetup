package paymentsPageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.NoSuchElementException;
import pageObjects.Login.Login;
import utils.GuiCommands;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

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

    @iOSFindBy (accessibility = "Available balance")
    private MobileElement hsAvailableBalance;

    @iOSFindBy (accessibility = "Payments")
    private MobileElement paymentsTab;

    @iOSFindBy (accessibility = "payments.pay_someone_new_title")
    private MobileElement newPaymentButton;

    @iOSFindBy (accessibility = "payee_details.name_textfield_header")
    private MobileElement payeeName;

    @iOSFindBy (accessibility = "payee_details.sort_code_textfield_header")
    private MobileElement payeeSortCode;

    @iOSFindBy (accessibility = "payee_details.account_number_textfield_header")
    private MobileElement payeeAccNumber;

    @iOSFindBy (accessibility = "payments.continue_button_title")
    private MobileElement continueButton;

    @iOSFindBy (xpath = "//XCUIElementTypeTextField[@name=\"payment_details.amount_textfield_header\"]")
    private MobileElement payAmount;

    @iOSFindBy (accessibility = "payment_details.reference_textfield_header")
    private MobileElement reference;

    @iOSFindBy (accessibility = "Available balance: 1,005.02 GBP")
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

    @iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"Payments\"]")
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

    @iOSFindBy(accessibility = "You have insufficient funds")
    private MobileElement errorMessageFunds;

    @iOSFindBy(accessibility = "Delete")
    private MobileElement deleteKey;

    @iOSFindBy(accessibility = "payment_success.copy_label")
    private MobileElement successMessage;

    @iOSFindBy(accessibility = "payments.done_button_title")
    private MobileElement doneButton;

    @iOSFindBy(accessibility = "payment_confirmation.about_to_pay_label_value")
    private MobileElement sentAmount;

    @iOSFindBy(accessibility = "payment_success.confirmed_label")
    private MobileElement paymentConfrimedTitle;

    @iOSFindBy(accessibility = "ic_green_circle_tick")
    private MobileElement greenTickImage;


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

        writeNumber(payAmount,1000);
        writeText(reference,"The Reference");
        clickContinue();
    }
    public void  navigateToPaymentpage(){

        login.navigateToLogin();
        clickPaymentTab();
        clickNewPayee();
    }
    public void populateValidUser(){
        writeText(payeeName,"valid user");
        writeNumber(payeeSortCode,123456);
        writeNumber(payeeAccNumber,44449999);
        clickContinue();

    }
    public void populateHRCodeRef(String code){
        writeNumber(payAmount,1000);
        writeText(reference,code);
        clickContinue();
    }
    public void navigateToSuccessScreen(){
        navigateToPaymentpage();
        populateValidUser();
        populateHRCodeRef("H47");
        click(makePaymentButton);
    }


    public void pressDelete (int count){

        while (count > 0){
            click(deleteKey);
            count--;
        }



    }

    //Test Methods
    public boolean isAvailBalanceEqual (){
        login.navigateToLogin();
        String check1 = hsAvailableBalance.getText().replaceAll("[^0-9]","");
        System.out.println(check1);
        clickPaymentTab();
        clickNewPayee();
        passThroughPayeeDetails();
        String check2 = psAvailableBalance.getText().replaceAll("[^0-9]","");
        System.out.println(check2);
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
        boolean two = payAmount.getText().equals("1,000.00");
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
        writeNumber(payAmount,123);
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
    public boolean insuficientFundsError(){
        navigateToPaymentpage();
        passThroughPayeeDetails();
        writeNumber(payAmount,2000000);
        writeText(reference,"Testing");
        boolean one = errorMessageFunds.isDisplayed();
        boolean two = !continueButton.isEnabled();

        return one && two;
    }
    public boolean insuficientFundsCorrection(){
        navigateToPaymentpage();
        passThroughPayeeDetails();
        writeNumber(payAmount,2000);
        writeText(reference,"Testing");
        boolean one = errorMessageFunds.isDisplayed();
        boolean two = !continueButton.isEnabled();
        click(payAmount);
        pressDelete(4);
        boolean three = continueButton.isEnabled();
        boolean four;
        try {
            four = !errorMessageFunds.isDisplayed();
        }catch (NoSuchElementException e){
            four = true;
        }
        return one && two && three && four;
    }

    public boolean successPageDisplayed(){
        navigateToSuccessScreen();
        boolean one = doneButton.isDisplayed() && sentAmount.isDisplayed() && paymentConfrimedTitle.isDisplayed();
        boolean two = driver.findElementByAccessibilityId("to valid user").isDisplayed();
        return one && two;
    }
    public boolean disclaimerShown(){
        navigateToSuccessScreen();
        boolean one = paymentConfrimedTitle.isDisplayed() && successMessage.isDisplayed();

        return one;
    }
    public boolean doneButtonValidation()
    {
        navigateToSuccessScreen();
        click(doneButton);
        boolean one = paymentsTitle.isDisplayed();

        return one;
    }

    public boolean sentStatusMessageCheck(){
        HashMap<String,String> brcCodes = new HashMap<>();

        brcCodes.put( "H47", "Your payment has been sent and will be credited to the beneficiary's account immediately," +
                " subject to our normal fraud checks.");
        brcCodes.put("H48", "Your payment has been sent and will usually be credited to the beneficiary's account " +
                "within 2 hours, subject to our normal fraud checks");
        brcCodes.put(  "H50", "Your payment has been sent and will usually be credited to the beneficiary's account " +
                "today, subject to our normal fraud checks.");
        brcCodes.put( "H51", "Your payment has been sent and will usually be credited to the beneficiary's account " +
                "within 2 hours, subject to our normal fraud checks. However, the Credit Card balance will not be " +
                "updated until the next working day");
        brcCodes.put("H54", "Your payment instructions have been received and are being processed.");
        brcCodes.put("H89", "Your payment has been sent and will be credited to the beneficiary's account.");
        brcCodes.put("H41", "Your payment has been accepted however the beneficiary's bankers are unable to confirm " +
                "when the beneficiary will be credited.");
        brcCodes.put("H42", "Your payment has been accepted by the beneficiary's bankers who advise that the beneficiary" +
                " account will be credited today.");
        brcCodes.put("H43", "Your payment has been accepted by the beneficiary's bankers who advise that the " +
                "beneficiary account will be credited by tomorrow.");
        brcCodes.put( "H44","Your payment has been accepted by the beneficiary's bankers who advise that the " +
                "beneficiary account will be credited by the next working day.");
        brcCodes.put("H45", "Your payment has been accepted however the beneficiary's bankers are unable to confirm " +
                "when the beneficiary will be credited.");

        String[] sentBrcCodes = {"H47","H48","H50","H51","H54","H89","H41","H42","H43","H44","H45"};
        int count = 0;
        navigateToPaymentpage();
        for(String code : sentBrcCodes){
            populateValidUser();
            populateHRCodeRef(code);
            click(makePaymentButton);
            String message = successMessage.getText();
            if (message.equals(brcCodes.get(code))){
                count++;
            }
            System.out.println(count);
            click(doneButton);
            click(paymentsTab);
            clickNewPayee();
        }
        System.out.println(count);
        boolean one = count == 11;

        return one;
    }
    }
 /*   h47 Your payment has been sent and will be credited to the beneficiary's account immediately, subject to our normal fraud checks.";
        h48 = "Your payment has been sent and will usually be credited to the beneficiary's account within 2 hours, subject to our normal fraud checks";
        h50 = "Your payment has been sent and will usually be credited to the beneficiary's account today, subject to our normal fraud checks.";
        h51 = "Your payment has been sent and will usually be credited to the beneficiary's account within 2 hours, subject to our normal fraud checks. However, the Credit Card balance will not be updated until the next working day";
        h54 = "Your payment instructions have been received and are being processed.";
        h89 = "Your payment has been sent and will be credited to the beneficiary's account.";
        h41 = "Your payment has been accepted however the beneficiary's bankers are unable to confirm when the beneficiary will be credited.";
        h42 = "Your payment has been accepted by the beneficiary's bankers who advise that the beneficiary account will be credited today.";
        h43 = "Your payment has been accepted by the beneficiary's bankers who advise that the beneficiary account will be credited by tomorrow.";
        h44 = "Your payment has been accepted by the beneficiary's bankers who advise that the beneficiary account will be credited by the next working day.";
        h45 = "Your payment has been accepted however the beneficiary's bankers are unable to confirm when the beneficiary will be credited.";

*/