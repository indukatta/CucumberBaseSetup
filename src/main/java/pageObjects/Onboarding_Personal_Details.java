package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteTouchScreen;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Onboarding_Personal_Details extends Page {

    /**
     * MobileElement Locators
     */
    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"Personal details\"]")
    private MobileElement navigationBarTitle;

    @FindBy(name = "personal_details_title")
    private MobileElement title;

    @FindBy(name = "personal_details_first_name")
    private MobileElement firstName;

    @FindBy(name = "personal_details_last_name")
    private MobileElement lastName;

    @FindBy(xpath = "(//XCUIElementTypeButton[@name=\"personal_details_changed_name_affirmative\"])[1]")
    private MobileElement nameChangedYes;

    @FindBy(xpath = "(//XCUIElementTypeButton[@name=\"personal_details_changed_name_affirmative\"])[2]")
    private MobileElement nameChangedNo;

    @FindBy(name = "personal_details_dob")
    private MobileElement dateOfBirth;

    @FindBy(name = "personal_details_residential_address_affirmative")
    private MobileElement residentialAddressYes;

    @FindBy(name = "personal_details_residential_address_negative")
    private MobileElement residentialAddressNo;

    @FindBy(name = "personal_details_nationality")
    private MobileElement nationality;

    @FindBy(name = "personal_details_id_type")
    private MobileElement governmentIdType;

    @FindBy(name = "personal_details_id_number")
    private MobileElement governmentIdNumber;

    @FindBy(name = "personal_details_dual_national_affirmative")
    private MobileElement dualNationalityYes;

    @FindBy(name = "personal_details_dual_national_negative")
    private MobileElement dualNationalityNo;

    @FindBy(name = "personal_details_utr")
    private MobileElement jurisdictionOfTaxReference;

    @FindBy(name = "personal_details_nino")
    private MobileElement nationalInsuranceNumber;

    @FindBy(name = "personal_details_email")
    private MobileElement emailAddress;

    @FindBy(name = "personal_details_email_confirmation")
    private MobileElement confirmEmailAddress;

    private RemoteTouchScreen touch;

    public Onboarding_Personal_Details(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    //FIX ME NEED ACCESSIBILITY IB
    public String setNavigationBarTitle() {
        String title = navigationBarTitle.getText();
        return title;
    }

    public void setTitle(String titleName) {
        writeText(title, titleName);
    }

    public void setFirstName(String name) {
        writeText(firstName, name);
    }

    public void setLastName(String surname) {
        writeText(lastName, surname);
    }

    public void setNameChangedYes() {
        scrollDown(nameChangedYes);
        click(nameChangedYes);
    }

    public void setNameChangedNo() {
        scrollDown(nameChangedNo);
        click(nameChangedNo);
    }

    public void setDateOfBirth(String day, String month, String year){
        scrollDown(dateOfBirth);
        click(dateOfBirth);
        WebElement yearElement = (WebElement) driver.findElements(By.className("XCUIElementTypePickerWheel")).get(2);
        yearElement.sendKeys(year);
        WebElement monthElement = (WebElement) driver.findElements(By.className("XCUIElementTypePickerWheel")).get(1);
        monthElement.sendKeys(month);
        WebElement dayElement = (WebElement) driver.findElements(By.className("XCUIElementTypePickerWheel")).get(0);
        dayElement.sendKeys(day);
    }

    public void setResidentialAddressYes() {
        scrollDown(residentialAddressYes);
        click(residentialAddressYes);
    }

    public void setResidentialAddressNo() {
        scrollDown(residentialAddressNo);
        click(residentialAddressNo);
    }

    public void setNationality(String nation) {
        scrollDown(nationality);
        click(nationality);
        writeText(nationality, nation);
    }

    public void setGovernmentIdType(String type) {
        scrollDown(governmentIdType);
        click(governmentIdType);
        WebElement element= (WebElement) driver.findElements(By.className("XCUIElementTypePickerWheel")).get(0);
        element.sendKeys(type);
    }

    public void setGovernmentIdNumber(int number) {
        scrollDown(governmentIdNumber);
        writeNumber(governmentIdNumber, number);
    }

    public void setDualNationalityYes() {
        scrollDown(dualNationalityYes);
        click(dualNationalityYes);
    }

    public void setDualNationalityNo() {
        scrollDown(dualNationalityNo);
        click(dualNationalityNo);
    }

    public void setJurisdictionOfTaxReference(int reference) {
        scrollDown(jurisdictionOfTaxReference);
        writeNumber(jurisdictionOfTaxReference, reference);
    }

    public void setNationalInsuranceNumber(String insurance) {
        scrollDown(nationalInsuranceNumber);
        writeText(nationalInsuranceNumber, insurance);
    }

    public void setEmailAddress(String address) {
        scrollDown(emailAddress);
        writeText(emailAddress, address);
    }

    public void setConfirmEmailAddress(String confirmAddress) {
        scrollDown(confirmEmailAddress);
        writeText(confirmEmailAddress, confirmAddress);
    }

    public void setPerson(String titleName, String forename, String surname, String nameChange, Date DOB,
                          String sameResidentialAddress, String nation, String IdType, int IdNumber, String dualCitizen,
                          int reference, String insuranceNumber, String email, String confirmEmail){
        setTitle(titleName);
        setFirstName(forename);
        setLastName(surname);

        if(nameChange.contentEquals("Yes")){
            setNameChangedYes();
        } else {
            setNameChangedNo();
        }

        formatDate(DOB);

        if(sameResidentialAddress.contentEquals("Yes")){
            setResidentialAddressYes();
        } else {
            setResidentialAddressNo();
        }

        setNationality(nation);//need logic applied
        setGovernmentIdType(IdType);//need logic applied
        setGovernmentIdNumber(IdNumber);

        if(dualCitizen.contentEquals("Yes")){
            setDualNationalityYes();
        } else {
            setDualNationalityNo();
        }

        setJurisdictionOfTaxReference(reference);
        setNationalInsuranceNumber(insuranceNumber);
        setEmailAddress(email);
        setConfirmEmailAddress(confirmEmail);
    }

    public void formatDate(Date DOB) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MMMM.yyyy");
        String formatted = dateFormat.format(DOB);
        String[] dateFormatParts = formatted.split("\\.");
        String dd = dateFormatParts[0];
        String month = dateFormatParts[1];
        String year = dateFormatParts[2];
        //if statement to remove the 0 in front of days 1 - 9
        if (dd.startsWith("0")){
            char singleNum = dd.charAt(1);
            String day = Character.toString(singleNum);
            setDateOfBirth(day, month, year);
        } else {
            setDateOfBirth(dd, month, year);
        }
    }



}
