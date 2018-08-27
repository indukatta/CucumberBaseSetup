package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testData.RandomDataGenerator;
import utils.GuiCommands;

public class SetUp extends GuiCommands {

    private RandomDataGenerator generator = new RandomDataGenerator();

    public SetUp(IOSDriver driver) {
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

    @FindBy(name = "welcome.new_customer_button_title")
    private MobileElement startButton;

    @FindBy(name = "Great, you're ready to get started!")
    private MobileElement titleGetStarted;

    @FindBy(name = "We're about to ask you about your")
    private MobileElement landingPageDescriptionOne;

    @FindBy(className = "• Business details\n • Personal details\n • Business Financials")//FIXME get accessibility locator without bullet points
    private MobileElement landingPageDescriptionTwo;

    @FindBy(name = "Be aware that once you confirm your details your information can't be changed")
    private MobileElement landingPageDescriptionThree;

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

    public void clickStart(){
        click(startButton);
    }

    //CLEAR TEXT METHODS
    public void clearPhoneNumber(){
        clearText(phoneNumberTextbox);
    }

    public void clearEmail(){
        clearText(emailTextbox);
    }

    public void navigateToPhoneNumber(){
        clickStart();
        clickConfirm();
    }

    public void navigateToEmail(){
        clickStart();
        clickConfirm();
        writePhoneNumber(generator.setPhoneNumber());
        clickNext();
    }

    public void navigateToLandingPage(){
        clickStart();
        clickConfirm();
        writePhoneNumber(generator.setPhoneNumber());
        clickNext();
        writeEmail(generator.setEmail("", 0));
        clickNext();
    }

    public boolean isPhoneNumberFieldDisplayed(){
        clickStart();
        clickConfirm();
        return phoneNumberTextbox.isDisplayed();
    }

    public boolean isEmailFieldDisplayed(){
        navigateToEmail();
        return emailTextbox.isDisplayed();
    }

    public boolean isPhoneKeyboardDisplayed(){
        clickStart();
        clickConfirm();
        clickPhoneNumberTextbox();
        return doesKeyboardExist();
    }

    public boolean isEmailKeyboardDisplayed(){
        navigateToEmail();
        return doesKeyboardExist();
    }

    public boolean invalidPhoneNumber(){
        clickStart();
        clickConfirm();

        //invalid phone entry
        writePhoneNumber("01234567890");
        boolean noSeven = !nextButtonEnabled();

        clearText(phoneNumberTextbox);
        writePhoneNumber("+441234567890");
        boolean noSevenAfterPrefix = !nextButtonEnabled();

        clearText(phoneNumberTextbox);
        writePhoneNumber("0723456789");
        boolean shortNumber = !nextButtonEnabled();

        clearText(phoneNumberTextbox);
        writePhoneNumber("071345678901");
        boolean longNumber = !nextButtonEnabled();

        return noSeven && noSevenAfterPrefix && shortNumber && longNumber;
    }

    public boolean validPhonenumber(){
        clickStart();
        clickConfirm();
        writePhoneNumber(generator.setPhoneNumber());
        return nextButtonEnabled();
    }

    public boolean invalidEmail(){
        navigateToEmail();
        boolean initialButtonEnabled = !nextButtonEnabled();

        clearEmail();
        writeEmail("random.email");
        boolean noAtSymbol = !nextButtonEnabled();

        clearEmail();
        writeEmail("random@email");
        boolean noDotInTheDomain = !nextButtonEnabled();

        clearEmail();
        writeEmail("random@email.co#");
        boolean specialCharacterInDomain = !nextButtonEnabled();

        clearEmail();
        writeEmail("@email.com");
        boolean nothingBeforeAtSymbol = !nextButtonEnabled();

        clearEmail();
        writeEmail("email@");
        boolean noDomain = !nextButtonEnabled();

        clearEmail();
        writeEmail("email@"+generator.setRandomValue(313, "ALPHANUMERIC")+".com");
        boolean characterLengthLong = !nextButtonEnabled();

        clearEmail();
        writeEmail("e@.c");
        boolean characterLengthShort = !nextButtonEnabled();

        return initialButtonEnabled && noAtSymbol && noDotInTheDomain && specialCharacterInDomain
                && nothingBeforeAtSymbol && noDomain && characterLengthLong && characterLengthShort;
    }

    public boolean validEmail(){
        navigateToEmail();
        clearEmail();
        writeEmail("email1@email.com");
        boolean numberBeforeDomain = nextButtonEnabled();

        clearEmail();
        writeEmail("email@em-ail.com");
        boolean hyphen = nextButtonEnabled();

        clearEmail();
        writeEmail("email$!@email.com");
        boolean specialCharacters = nextButtonEnabled();

        clearEmail();
        writeEmail("email@"+ generator.setRandomValue(312, "ALPHANUMERIC")+".com");
        boolean maxLength = nextButtonEnabled();

        return numberBeforeDomain && hyphen && specialCharacters && maxLength;
    }

    public boolean landingPageDisplayed(){
        navigateToLandingPage();
        return titleGetStarted.isDisplayed();
    }

    public boolean landingPageDescription(){
        navigateToLandingPage();
        boolean one = readText(landingPageDescriptionOne).equalsIgnoreCase("We're about to ask you about your");
       // boolean two = readText(landingPageDescriptionTwo).equalsIgnoreCase("• Business details\n • Personal details\n • Business Financials");
        boolean three = readText(landingPageDescriptionThree).equalsIgnoreCase("Be aware that once you confirm your details your information can't be changed");
        return one && three;
    }

    public void passThroughSetUp(){
        clickStart();
        clickConfirm();
        writePhoneNumber("07123456789");
        clickNext();
        writeEmail(generator.setEmail("", 0));
        clickNext();
    }
}
