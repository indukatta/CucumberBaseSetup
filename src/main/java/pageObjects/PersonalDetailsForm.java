package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testData.RandomDataGenerator;
import utils.GuiCommands;

import java.security.AccessControlContext;

public class PersonalDetailsForm extends GuiCommands {

    RandomDataGenerator generator = new RandomDataGenerator();
    BusinessSearch businessSearch = new BusinessSearch(driver);
    BusinessDetailsForm businessDetailsForm = new BusinessDetailsForm(driver);

    public PersonalDetailsForm(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(name = "Ownership")
    private MobileElement ownerShipTitle;

    @FindBy(name = "ownership_confirmation.accept")
    private MobileElement confirmOwnership;

    @FindBy(name = "ownership_confirmation.decline")
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

    @iOSFindBy(accessibility = "personal_details.previous_name")
    private MobileElement personPreviousName;

    @FindBy (name = "personal_details.dob")
    private MobileElement personDOB;

    @FindBy (name = "personal_details.ra_affirmative")
    private MobileElement personBusinessAndResidentialEqualYes;

    @FindBy(name = "personal_details.ra_negative")
    private MobileElement personBusinessAndResidentialEqualNo;

    @iOSFindBy(accessibility = "address_search.search_field_title")
    private MobileElement addressSearch;

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

    @FindBy (id = "You and your business")
    private MobileElement backToCompanyReview;

    @FindBy (name = "toolbar_done")
    private MobileElement pickerWheelDone;

    @FindBy (name = "country_search.search_field_title")
    private MobileElement countrySearch;

    @FindBy (name = "next_button_default_title")
    private MobileElement nextButton;


    public void naviagateToPersonalDetailsForm(){
        businessDetailsForm.passThroughBusinessDetailsForm();
        click(confirmOwnership);
    }

    public boolean personalDetailsNotEditible(){
        naviagateToPersonalDetailsForm();
        boolean one = !personTitle.isEnabled();
        boolean two = !personFirstName.isEnabled();
        boolean three = !personLastName.isEnabled();
        return one && two && three;
    }

    public boolean personalDetailsDisplayed(){
        naviagateToPersonalDetailsForm();
        boolean one = personTitle.isDisplayed();
        boolean two = personFirstName.isDisplayed();
        boolean three = personLastName.isDisplayed();
        return one && two && three;
    }

    public boolean navigateBackToBusinessSearch(){
        naviagateToPersonalDetailsForm();
        click(backToOwnershipScreen);
        click(backToCompanyReview);
        businessDetailsForm.scrollToTopOfPage();
        boolean one = businessDetailsForm.businessReviewTitleDisplayed();
        businessDetailsForm.clickBackNavigation();
        boolean two = businessSearch.businessSearchTitleDisplayed();
        return one && two;
    }

    public void passThroughPersonalDetailsForm(){
        naviagateToPersonalDetailsForm();
        click(personNameChangedNo);
        click(personDOB);
        click(pickerWheelDone);
        click(personBusinessAndResidentialEqualYes);
        click(personDualNationalNo);
        writeText(personNationalInsuranceNumber, "JC123456Y");
        click(personIdType);
        click(pickerWheelDone);
        writeText(personIdNumber, "1234567890");
        click(personJurisdictionOfTaxResidency);
        writeText(countrySearch, generator.setCountry());
        clickGenericIostableCell();
        click(nextButton);
    }

    public void personalDetailsWitData(String name, String address, String number, String id, String country){
        click(confirmOwnership);
        click(personNameChangedYes);
        writeText(personPreviousName, name);
        click(personDOB);
        click(pickerWheelDone);
        click(personBusinessAndResidentialEqualNo);
        writeText(addressSearch, address);
        clickGenericIostableCell();
        click(personDualNationalNo);
        writeText(personNationalInsuranceNumber, number);
        click(personIdType);
        click(pickerWheelDone);
        writeText(personIdNumber, id);
        click(personJurisdictionOfTaxResidency);
        writeText(countrySearch, country);
        clickGenericIostableCell();
        click(nextButton);
    }
}
