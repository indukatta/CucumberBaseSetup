package pageObjects.Onboarding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testData.RandomDataGenerator;
import utils.GuiCommands;


public class PersonalDetailsForm extends GuiCommands {

    RandomDataGenerator generator = new RandomDataGenerator();
    BusinessSearch businessSearch = new BusinessSearch(driver);
    BusinessDetailsForm businessDetailsForm = new BusinessDetailsForm(driver);
    SetUp setUp = new SetUp(driver);

    public PersonalDetailsForm(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSFindBy(accessibility = "Ownership")
    private MobileElement ownerShipTitle;

    @iOSFindBy(accessibility = "ownership_confirmation.accept")
    private MobileElement confirmOwnership;

    @iOSFindBy(accessibility = "ownership_confirmation.decline")
    private MobileElement unconfirmedOwnership;

    @iOSFindBy(accessibility = "About you & your business")
    private MobileElement aboutBusiness;

    @iOSFindBy (accessibility = "A bit about you")
    private MobileElement personalDetailsPageTitle;

    @iOSFindBy (accessibility = "personal_details.title")
    private MobileElement personTitle;

    @iOSFindBy (accessibility = "personal_details.first_name")
    private MobileElement personFirstName;

    @iOSFindBy (accessibility = "personal_details.last_name")
    private MobileElement personLastName;

    @iOSFindBy (accessibility = "personal_details.changed_name_affirmative")
    private MobileElement personNameChangedYes;

    @iOSFindBy (accessibility = "personal_details.changed_name_negative")
    private MobileElement personNameChangedNo;

    @iOSFindBy(accessibility = "personal_details.previous_name")
    private MobileElement personPreviousName;

    @iOSFindBy (accessibility = "personal_details.dob")
    private MobileElement personDOB;

    @iOSFindBy (accessibility = "personal_details.ra_affirmative")
    private MobileElement personBusinessAndResidentialEqualYes;

    @iOSFindBy(accessibility = "personal_details.ra_negative")
    private MobileElement personBusinessAndResidentialEqualNo;

    @iOSFindBy(accessibility = "address_search.search_field_title")
    private MobileElement addressSearch;

    @iOSFindBy(accessibility = "personal_details.address")
    private MobileElement personResidentialAddress;

    @iOSFindBy(accessibility = "personal_details.nationality")
    private MobileElement personNationality;

    @iOSFindBy(accessibility = "personal_details.id_type")
    private MobileElement personIdType;

    @iOSFindBy(accessibility = "personal_details.id_number")
    private MobileElement personIdNumber;

    @iOSFindBy(accessibility = "personal_details.dn_affirmative")
    private MobileElement personDualNationalYes;

    @iOSFindBy(accessibility = "personal_details.dn_negative")
    private MobileElement personDualNationalNo;

    @iOSFindBy(accessibility = "personal_details.tax_jurisdiction")
    private MobileElement personJurisdictionOfTaxResidency;

    @iOSFindBy(accessibility = "personal_details.nino")
    private MobileElement personNationalInsuranceNumber;

    @iOSFindBy(accessibility = "personal_details.email")
    private MobileElement personEmail;

    @iOSFindBy(accessibility = "personal_details.email_confirmation")
    private MobileElement personConfirmEmail;

    @iOSFindBy(accessibility = "Business Details")
    private MobileElement backToOwnershipScreen;

    @iOSFindBy (accessibility = "You and your business")
    private MobileElement backToCompanyReview;

    @iOSFindBy (accessibility = "toolbar_done")
    private MobileElement pickerWheelDone;

    @iOSFindBy (accessibility = "country_search.search_field_title")
    private MobileElement countrySearch;

    @iOSFindBy (accessibility = "next_button_default_title")
    private MobileElement nextButton;


    public void naviagateToPersonalDetailsForm(){
        setUp.passThroughSetUp();
        businessSearch.passThroughBusinessSearch();
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
        click(confirmOwnership);
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
