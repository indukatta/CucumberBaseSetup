package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Onboarding_Terms_and_Conditions extends Page {

    @FindBy(name = "Terms & Conditions")
    private MobileElement termsAndConditions;

    @FindBy(name = "Privacy Policy")
    private MobileElement privacyPolicy;

    @FindBy(name = "Eligibility")
    private MobileElement eligibility;

    @FindBy(name = "Agree")
    private MobileElement agree;

    @FindBy(name = "Disagree")
    private MobileElement disagree;

    @FindBy(name = "Continue")
    private MobileElement continueButton;

    public Onboarding_Terms_and_Conditions(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void agreeToTermsAndConditions(){
        click(termsAndConditions);
        click(agree);
    }

    public void agreeToPrivacyPolicy(){
        click(privacyPolicy);
        click(agree);
    }

    public void agreeToEligibility(){
        click(eligibility);
        click(agree);
    }

    public void disagreeTermsAndConditions(){
        click(termsAndConditions);
        click(disagree);
    }

    public void disagreePrivacyPolicy(){
        click(termsAndConditions);
        click(disagree);
    }

    public void disagreeEligibility(){
        click(termsAndConditions);
        click(disagree);
    }

    public void AgreeAndContinue(){
        click(continueButton);
    }
}
