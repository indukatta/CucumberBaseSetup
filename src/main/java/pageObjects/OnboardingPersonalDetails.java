package pageObjects;

import io.appium.java_client.AppiumDriver;
import utils.GuiCommands;
import testData.RandomDataFactory.TestData;


public class OnboardingPersonalDetails extends GuiCommands {

    private TestData testData = new TestData();

    //ownership screen
    private String confirmOwnership = "Yes, I confirm";
    private String unconfirmedOwnership = "No, I cannot confirm";

    //Getting started
    private String aboutBusiness = "About you & your business";

    //Personal Details page locators
    private String personTitle = "personal_details.title";
    private String personFirstName = "personal_details.first_name";
    private String personLastName = "personal_details.last_name";
    private String personNameChangedYes = "personal_details.changed_name_affirmative";
    private String personNameChangedNo = "personal_details.changed_name_negative";
    private String personDOB = "personal_details.dob";
    private String personBusinessAndResidentialEqualYes = "personal_details.ra_affirmative";
    private String personBusinessAndResidentialEqualNo = "personal_details.ra_negative";
    private String personResidentialAddress = "personal_details.address";
    private String personNationality = "personal_details.nationality";
    private String personIdType = "personal_details.id_type";
    private String personIdNumber = "personal_details.id_number";
    private String personDualNationalYes = "personal_details.dn_affirmative";
    private String personDualNationalNo = "personal_details.dn_negative";
    private String personJurisdictionOfTaxReference = "personal_details.utr";
    private String personNationalInsuranceNumber = "personal_details.nino";
    private String personEmail = "personal_details.email";
    private String personConfirmEmail = "personal_details.email_confirmation";

    public OnboardingPersonalDetails(AppiumDriver driver) {
        super(driver);
    }

    //Getters to use for test validation
    public String getConfirmOwnership() {
        return confirmOwnership;
    }

    public String getUnconfirmedOwnership() {
        return unconfirmedOwnership;
    }

    public String getAboutBusiness() {
        return aboutBusiness;
    }

    public String getPersonTitle() {
        return personTitle;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public String getPersonNameChangedYes() {
        return personNameChangedYes;
    }

    public String getPersonNameChangedNo() {
        return personNameChangedNo;
    }

    public String getPersonDOB() {
        return personDOB;
    }

    public String getPersonBusinessAndResidentialEqualYes() {
        return personBusinessAndResidentialEqualYes;
    }

    public String getPersonBusinessAndResidentialEqualNo() {
        return personBusinessAndResidentialEqualNo;
    }

    public String getPersonResidentialAddress() {
        return personResidentialAddress;
    }

    public String getPersonNationality() {
        return personNationality;
    }

    public String getPersonIdType() {
        return personIdType;
    }

    public String getPersonIdNumber() {
        return personIdNumber;
    }

    public String getPersonDualNationalYes() {
        return personDualNationalYes;
    }

    public String getPersonDualNationalNo() {
        return personDualNationalNo;
    }

    public String getPersonJurisdictionOfTaxReference() {
        return personJurisdictionOfTaxReference;
    }

    public String getPersonNationalInsuranceNumber() {
        return personNationalInsuranceNumber;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public String getPersonConfirmEmail() {
        return personConfirmEmail;
    }

    public void onBoard(boolean hasNameChanged, boolean doesResidentialAddressEqualsBusinessAddress, boolean dualNational){

    }

}
