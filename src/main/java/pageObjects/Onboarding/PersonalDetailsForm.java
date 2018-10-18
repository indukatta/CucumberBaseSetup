package pageObjects.Onboarding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.NoSuchElementException;
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

    @iOSFindBy(accessibility = "Incorrect details entered")
    private MobileElement errorMessage;

    @iOSFindBy(accessibility = "search exit button")
    private MobileElement addSearchExitbutton;

    @iOSFindBy(xpath = "//XCUIElementTypeTextField[@name=\"country_search.search_field_title\"]")
    private MobileElement dualCountrySearch;

    @iOSFindBy(xpath = "//XCUIElementTypeTextField[@name=\"personal_details.dual_national\"]")
    private MobileElement dualNationalityTextfield;


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

    public boolean errorMessageDisplayed(){
        naviagateToPersonalDetailsForm();
        scrollDown(personNationalInsuranceNumber);
        writeText(personNationalInsuranceNumber, "HHHHHHHHH");
        scrollDown(personIdType);
        click(personIdType);
        boolean one = errorMessage.isDisplayed();
        clearText(personNationalInsuranceNumber);
        click(personIdType);
        boolean two = false;
        try{
            errorMessage.isDisplayed();
        } catch (NoSuchElementException e){
            two = true;
        }
        return one && two;
    }

    public boolean errorMessageDisappearsWhenValidationPassed(){
        naviagateToPersonalDetailsForm();
        scrollDown(personNationalInsuranceNumber);
        writeText(personNationalInsuranceNumber, "AS1234");
        scrollDown(personIdType);
        click(personIdType);
        boolean one = errorMessage.isDisplayed();
        writeText(personNationalInsuranceNumber, "56D");
        boolean two = false;
        try{
            errorMessage.isDisplayed();
        } catch (NoSuchElementException e){
            two = true;
        }
        return one && two;
    }

    public boolean errorMessageDoesNotShow(){
        naviagateToPersonalDetailsForm();
        scrollDown(personNationalInsuranceNumber);
        click(personNationalInsuranceNumber);
        scrollDown(personIdType);
        click(personIdType);
        boolean one = false;
        try{
            errorMessage.isDisplayed();
        } catch (NoSuchElementException e){
            one = true;
        }
        return one;
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
//        click(personBusinessAndResidentialEqualNo);
//        writeText(addressSearch, address);
//        clickGenericIostableCell();
        click(personBusinessAndResidentialEqualYes);
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

    public boolean dualNationalityValidation(){
        naviagateToPersonalDetailsForm();
        click(personNameChangedNo);
        click(personDOB);
        click(pickerWheelDone);
        click(personBusinessAndResidentialEqualYes);
        writeText(personNationalInsuranceNumber, "JC123456Y");
        click(personIdType);
        click(pickerWheelDone);
        writeText(personIdNumber, "1234567890");
        click(personJurisdictionOfTaxResidency);
        writeText(countrySearch, generator.setCountry());
        clickGenericIostableCell();
        boolean one = !nextButton.isEnabled();
        boolean two;
        try {
             two = !personDualNationalNo.getAttribute("value").equals(1) && !personDualNationalNo.getAttribute("value").equals(1);
        }catch (NullPointerException e){
             two = true;
        }
        click(personDualNationalNo);
        boolean three = nextButton.isEnabled();
        return one && two && three;
    }

    public boolean dualNationalityNo(){
        naviagateToPersonalDetailsForm();
        click(personNameChangedNo);
        click(personDOB);
        click(pickerWheelDone);
        click(personBusinessAndResidentialEqualYes);
        writeText(personNationalInsuranceNumber, "JC123456Y");
        click(personIdType);
        click(pickerWheelDone);
        writeText(personIdNumber, "1234567890");
        click(personJurisdictionOfTaxResidency);
        writeText(countrySearch, generator.setCountry());
        clickGenericIostableCell();
        boolean one = !nextButton.isEnabled();
        click(personDualNationalNo);
        boolean two = nextButton.isEnabled();

        return  one && two;
    }
    public boolean dualNationalityYes(){
        naviagateToPersonalDetailsForm();
        click(personNameChangedNo);
        click(personDOB);
        click(pickerWheelDone);
        click(personBusinessAndResidentialEqualYes);
        writeText(personNationalInsuranceNumber, "JC123456Y");
        click(personIdType);
        click(pickerWheelDone);
        writeText(personIdNumber, "1234567890");
        click(personJurisdictionOfTaxResidency);
        writeText(countrySearch, generator.setCountry());
        clickGenericIostableCell();
        boolean one = !nextButton.isEnabled();
        click(personDualNationalYes);
        boolean two = addSearchExitbutton.isDisplayed();

        return  one && two;
    }
    public boolean nationalitySearch(){
        naviagateToPersonalDetailsForm();
        click(personDualNationalYes);
        writeText(dualCountrySearch,"uni");
        clickGenericIostableCell();
        boolean one = dualNationalityTextfield.getText().equals("Réunion");

        return  one;
    }
    public boolean invalidNationalitySearch(){
        naviagateToPersonalDetailsForm();
        click(personDualNationalYes);
        writeText(dualCountrySearch,"zyt");
        try {
            clickGenericIostableCell();
        }catch (NoSuchElementException e){}

        boolean one = false;
        try{
            dualNationalityTextfield.isDisplayed();
        } catch (NoSuchElementException e){
            one = true;
        }
        click(addSearchExitbutton);
        boolean two = false;
        try{
            dualNationalityTextfield.isDisplayed();
        } catch (NoSuchElementException e){
            two = true;
        }

        return  one && two;
    }
    public boolean cancelDualNationality(){
        naviagateToPersonalDetailsForm();
        click(personDualNationalYes);
        writeText(dualCountrySearch,"uni");
        clickGenericIostableCell();
        click(personDualNationalNo);
        boolean one = false;
        try{
            dualNationalityTextfield.isDisplayed();
        } catch (NoSuchElementException e){
            one = true;
        }

        return one;
    }

    public void clickBackToOwnershipScreen(){
        click(backToOwnershipScreen);
    }

    public void setConfirmOwnershipYes(){
        click(confirmOwnership);
    }

    public boolean isNextButtonEnabled(){
        return nextButton.isEnabled();
    }

    public void personalDetailsMandatoryFields(boolean isNameChanged, String name, boolean setDOB, boolean isHomeAddressSameAsBusinessAddress,
                                        boolean isDualNational, String niNnumber, boolean setPersonalId,String personalIdValue,
                                        boolean setJurisdictionCountry, String country){

        click(confirmOwnership);

        if(isNameChanged){
            click(personNameChangedYes);
            writeText(personPreviousName, name);
        }

        if(setDOB) {
            click(personDOB);
            click(pickerWheelDone);
        }

        if(isHomeAddressSameAsBusinessAddress) {
            click(personBusinessAndResidentialEqualYes);
        }

        if(!isDualNational){
            click(personDualNationalNo);
        }

        writeText(personNationalInsuranceNumber, niNnumber);

        if(setPersonalId){
            click(personIdType);
            click(pickerWheelDone);
            writeText(personIdNumber, personalIdValue);
        }else{
            writeText(personIdNumber, personalIdValue);
        }

        if(setJurisdictionCountry) {
            click(personJurisdictionOfTaxResidency);
            writeText(countrySearch, country);
            clickGenericIostableCell();
        }
    }


}
