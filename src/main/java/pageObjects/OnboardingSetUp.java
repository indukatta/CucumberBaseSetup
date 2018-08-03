package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.testng.asserts.SoftAssert;
import testData.RandomDataFactory.TestData;
import utils.CommonValidations;
import utils.GuiCommands;

public class OnboardingSetUp extends GuiCommands {

    //Locators
    private String start = "Start";
    private String eligibilityConfirm = "eligibility.confirm_title";
    private String eligibilityDecline = "eligibility.decline_title";
    private String phoneNumberTitle = "Personal Details";
    private String phoneNumberTextbox = "phone_number_entry.phone_number_textfield_header";
    private String emailTitle = "Your e-mail address";
    private String emailTextbox = "email_entry.textfield_header";
    private String nextButton = "Next";
    private String continueButton = "Continue";

    public OnboardingSetUp(AppiumDriver driver) {
        super(driver);
    }

    private TestData testData = new TestData();
    private CommonValidations validate = new CommonValidations(this.driver);
    SoftAssert softAssert = new SoftAssert();

    //Getters to use for test validation
    public String getStart() {
        return start;
    }

    public String getEligibilityConfirm() {
        return eligibilityConfirm;
    }

    public String getEligibilityDecline() {
        return eligibilityDecline;
    }

    public String getPhoneNumberTextbox() {
        return phoneNumberTextbox;
    }

    public String getEmailTextbox() {
        return emailTextbox;
    }

    public String getNextButton() {
        return nextButton;
    }

    public String getContinueButton() {
        return continueButton;
    }

    public void onBoard(){
        click(continueButton);
        click(eligibilityConfirm);
        validatePhoneNumber();
        validateEmail();
    }

    public void validatePhoneNumber(){
        validate.assertIsDisplayed(phoneNumberTitle);
        validate.assertNotEnabled(nextButton);
        //no leading 07
        writeText(phoneNumberTextbox, "01234567890");
        validate.assertNotEnabled(nextButton);
        clearText(phoneNumberTextbox);
        //no leading +447
        writeText(phoneNumberTextbox, "+441234567890");
        validate.verifyNotEnabled(nextButton, "CUICE-1234");
        clearText(phoneNumberTextbox);
        //not enough numbers
        writeText(phoneNumberTextbox, "0723456789");
        validate.assertNotEnabled(nextButton);
        clearText(phoneNumberTextbox);
        //too many numbers
        writeText(phoneNumberTextbox, "071345678901");
        validate.assertNotEnabled(nextButton);
        clearText(phoneNumberTextbox);
        //valid entry
        writeText(phoneNumberTextbox, testData.setPhoneNumber());
        validate.assertEnabled(nextButton);
        click(nextButton);
    }

    public void validateEmail(){
        //CUICE-4343 Display Email Address Field
        validate.assertIsDisplayed(emailTitle);
        validate.assertNotEnabled(nextButton);
        //CUICE-xxxx Email Keyboard is displayed
        click(emailTextbox);
        validate.verifyKeyboardVisible();
        //CUICE-4346 Email Address validation - negative
        writeText(emailTextbox, testData.setIncorrectEmail());
        validate.assertNotEnabled(nextButton);
        clearText(emailTextbox);
        //CUICE-4345 Email Address validation - positive
        writeText(emailTextbox, testData.setEmail());
        validate.assertEnabled(nextButton);
        click(nextButton);
    }
}
