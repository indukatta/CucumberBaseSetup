package Onboarding_tests;

import org.junit.Before;
import org.junit.Test;
import pageObjects.Onboarding_Getting_Started;
import pageObjects.Onboarding_Personal_Details;
import pageObjects.Onboarding_Terms_and_Conditions;
import pageObjects.Onboarding_Welcome_screen;


public class Personal_Details_Test extends Base_test {

    Onboarding_Welcome_screen customer;
    Onboarding_Getting_Started gettingStarted;
    Onboarding_Terms_and_Conditions terms;
    Onboarding_Personal_Details details;

    @Before
    public void beforeMethod(){
        customer = new Onboarding_Welcome_screen(driver);
        gettingStarted = new Onboarding_Getting_Started((driver));
        terms = new Onboarding_Terms_and_Conditions(driver);
        details = new Onboarding_Personal_Details(driver);
    }

    @Test
    public void manualOnboardingHappyPath(){
        customer.newCustomer();
        terms.agreeToTermsAndConditions();
        terms.agreeToPrivacyPolicy();
        terms.agreeToEligibility();
        terms.AgreeAndContinue();
        gettingStarted.enterAboutBusiness();
        details.setTitle("Dr.");
        details.setFullName("Joe Bloggs");
        details.setPreviousName("Joseph Bloggs");
        details.setDOB("1", "April", "1993");
        details.setNationality("United Kingdom");
        details.setDualNationality(false);

    }
}
