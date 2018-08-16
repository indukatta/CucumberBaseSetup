package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testData.RandomDataGenerator;
import utils.GuiCommands;

public class SetUp extends GuiCommands {

    private RandomDataGenerator generator = new RandomDataGenerator();

    public SetUp(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(name = "eligibility.confirm_title")
    private MobileElement eligibilityConfirm;

    @FindBy(name = "eligibility.decline_title")
    private MobileElement eligibilityDecline;

    @FindBy(name = "Personal Details")
    private MobileElement phoneNumberTitle;

    @FindBy(name = "phone_number_entry.phone_number_textfield_header")
    private MobileElement phoneNumberTextbox;

    @FindBy(name = "Your e-mail address")
    private MobileElement emailTitle;

    @FindBy(name = "email_entry.textfield_header")
    private MobileElement emailTextbox;

    @FindBy(name = "Next")
    private MobileElement nextButton;

    @FindBy(name = "Continue")
    private MobileElement continueButton;

    //DISPLAYED METHODS
    public boolean phoneNumberTitleDisplayed(){
        return phoneNumberTitle.isDisplayed();
    }

    public boolean emailTitleDisplayed(){
        return emailTitle.isDisplayed();
    }

    public boolean nextButtonEnabled(){
        return nextButton.isEnabled();
    }

    //WRITE METHODS
    public void writePhoneNumber(String number){
        writeText(phoneNumberTextbox, number);
    }

    public void writeEmail(String email){
        writeText(emailTextbox, email);
    }

    //CLICK METHODS
    public void clickConfirm(){
        click(eligibilityConfirm);
    }

    public void clickDecline(){
        click(eligibilityDecline);
    }

    public void clickPhoneNumberTextbox(){
        click(phoneNumberTextbox);
    }

    public void clickEmailTextbox(){
        click(emailTextbox);
    }

    public void clickNext(){
        click(nextButton);
    }

    public void clickContinue(){
        click(continueButton);
    }

    //CLEAR TEXT METHODS
    public void clearPhoneNumber(){
        clearText(phoneNumberTextbox);
    }

    public void clearEmail(){
        clearText(emailTextbox);
    }

    //CUSTOM METHODS
    public boolean isKeyboardDisplayed(){
       return doesKeyboardExist();
    }

    public void passThroughSetUp(){
        clickContinue();
        clickConfirm();
        writePhoneNumber(generator.setPhoneNumber());
        clickNext();
        writeEmail(generator.setEmail("", 0));
        clickNext();
    }
}
