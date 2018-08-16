package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GuiCommands;

public class PersonalDetailsForm extends GuiCommands {


    public PersonalDetailsForm(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(name = "Ownership")
    private MobileElement ownerShipTitle;

    @FindBy(name = "Yes, I confirm")
    private MobileElement confirmOwnership;

    @FindBy(name = "No, I cannot confirm")
    private MobileElement unconfirmedOwnership;

    @FindBy(name = "About you & your business")
    private MobileElement aboutBusiness;

    @FindBy (name = "A bit about you")
    private MobileElement personalDetailsPageTitle;

    @FindBy (name = "personal_details.title")
    private MobileElement personTitle;

    @FindBy (name = "personal_details.first_name")
    private MobileElement personFirstName;

    @FindBy (name = "personal_details.last_name")
    private MobileElement personLastName;

    @FindBy (name = "personal_details.changed_name_affirmative")
    private MobileElement personNameChangedYes;

    @FindBy (name = "personal_details.changed_name_negative")
    private MobileElement personNameChangedNo;

    @FindBy (name = "personal_details.dob")
    private MobileElement personDOB;

    @FindBy (name = "personal_details.ra_affirmative")
    private MobileElement personBusinessAndResidentialEqualYes;

    @FindBy(name = "personal_details.ra_negative")
    private MobileElement personBusinessAndResidentialEqualNo;

    @FindBy(name = "personal_details.address")
    private MobileElement personResidentialAddress;

    @FindBy(name = "personal_details.nationality")
    private MobileElement personNationality;

    @FindBy(name = "personal_details.id_type")
    private MobileElement personIdType;

    @FindBy(name = "personal_details.id_number")
    private MobileElement personIdNumber;

    @FindBy(name = "personal_details.dn_affirmative")
    private MobileElement personDualNationalYes;

    @FindBy(name = "personal_details.dn_negative")
    private MobileElement personDualNationalNo;

    @FindBy(name = "personal_details.tax_jurisdiction")
    private MobileElement personJurisdictionOfTaxResidency;

    @FindBy(name = "personal_details.nino")
    private MobileElement personNationalInsuranceNumber;

    @FindBy(name = "personal_details.email")
    private MobileElement personEmail;

    @FindBy(name = "personal_details.email_confirmation")
    private MobileElement personConfirmEmail;

    @FindBy(name = "Business Details")
    private MobileElement backToOwnershipScreen;

    @FindBy (name = "Back")
    private MobileElement backToCompanyReview;

    @FindBy (name = "Done")
    private MobileElement pickerWheelDone;

    //Steps
    public boolean isOwnershipTitleDisplayed(){
        return ownerShipTitle.isDisplayed();
    }

    public void clickConfirmOwnership(){
        click(confirmOwnership);
    }

    public boolean isPersonalDetailsTitlePageDisplayed(){
        return personalDetailsPageTitle.isDisplayed();
    }

    public boolean isJurisdictionOfTaxResidencyDisplayed(){
        scrollDown(personJurisdictionOfTaxResidency);
        return personJurisdictionOfTaxResidency.isDisplayed();
    }

    public void clickJurisdictionOfTaxResidency(){
        click(personJurisdictionOfTaxResidency);
    }

    public String getPersonJurisdictionOfTaxResidency(){
        return readText(personJurisdictionOfTaxResidency);
    }

    public void confirmOwnership(){
        click(confirmOwnership);
    }

    public void writePersonTitle(String title){
        writeText(personTitle, title);
    }

    public String getPersonTitle(){
        return readText(personTitle);
    }

    public boolean isPersonTitleEnabled(){
        return personTitle.isEnabled();
    }

    public void writePersonFirstName(String firstName){
        writeText(personFirstName, firstName);
    }

    public String getPersonFirstName(){
        return readText(personFirstName);
    }

    public boolean isPersonFirstNameEnabled(){
        return personFirstName.isEnabled();
    }

    public void writePersonLastName(String lastName){
        writeText(personLastName, lastName);
    }

    public String getPersonLastName(){
        return readText(personLastName);
    }

    public boolean isPersonLastNameEnabled(){
        return personLastName.isEnabled();
    }

    public void clickNameChangedYes(){
        click(personNameChangedYes);
    }

    public String getPersonDOB(){
        return readText(personDOB);
    }

    public boolean isPersonDOBEnabled(){
        return personDOB.isEnabled();
    }

    public String getPersonNationality(){
        return readText(personNationality);
    }

    public boolean isPersonNationalityEnabled(){
        return personNationality.isEnabled();
    }

    public void clickBackToBusinessDetails(){
        click(backToCompanyReview);
    }

    public String getPersonIdType(){
        return readText(personIdType);
    }

    public void selectIdType(String choice){
        IosPickerWheel(personIdType, choice);
    }

    public boolean isGovernmentIdTypeDisplayed(){
        scrollDown(personIdType);
        return personIdType.isDisplayed();
    }

    public void pickerWheelDone(){
        click(pickerWheelDone);
    }
}
