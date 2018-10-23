package Onboarding_tests.field_validation_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Onboarding.*;
import testUtils.Base_test;

public class BusinessFormMandatoryFieldChecks extends Base_test {
    private SetUp setUp;
    private BusinessSearch businessSearch;
    private BusinessDetailsForm businessDetailsForm;
    private PersonalDetailsForm personalDetailsForm;

    @BeforeMethod
    public void before(){
        setUp = new SetUp(driver);
        businessSearch = new BusinessSearch(driver);
        businessDetailsForm = new BusinessDetailsForm(driver);
        personalDetailsForm = new PersonalDetailsForm(driver);
    }

    @Test
    public void BusinessFormMandatoryFieldChecks() {

        setUp.passThroughSetUp();
        businessSearch.passThroughBusinessSearch();
        businessDetailsForm.passThroughBusinessDetailsForm();

        //TestCase 1:
        personalDetailsForm.setConfirmOwnershipYes();
        System.out.println("Check 1 : Verify Next button is disabled with no data in the form");
        Assert.assertTrue(!personalDetailsForm.isNextButtonEnabled());


        //TestCase 2 : skip name changed
        System.out.println("Check 2 : Verify Next button is disabled with name changed option skipped");
        personalDetailsForm.personalDetailsMandatoryFields(false,"",true, true,
                false,"JC123456Y",true,"12345678",true,"Poland");
        Assert.assertTrue(!personalDetailsForm.isNextButtonEnabled());
        personalDetailsForm.clickBackToOwnershipScreen();

        //TestCase 3 : set name changed yes, name value to blank
        System.out.println("Check 3 : Verify Next button is disabled with name changed option set to yes and name field set to empty");
        personalDetailsForm.personalDetailsMandatoryFields(true,"",true,true,
                false,"JC123456Y",true,"1234567890",true,"Poland");
        Assert.assertTrue(!personalDetailsForm.isNextButtonEnabled());
        personalDetailsForm.clickBackToOwnershipScreen();


        //Testcase 4 : skip dob
        System.out.println("Check 4 : Verify Next button is disabled with date of birth set to blank");
        personalDetailsForm.personalDetailsMandatoryFields(true,"Test name",false,true,
                false, "JC123456Y",true,"1234567890",true,"Poland");
        Assert.assertTrue(!personalDetailsForm.isNextButtonEnabled());
        personalDetailsForm.clickBackToOwnershipScreen();

        //TestCase 5 : skip address
        System.out.println("Check 5 : Verify Next button is disabled with address option skipped");
        personalDetailsForm.personalDetailsMandatoryFields(true,"Test name",true,false,
                false,"JC123456Y",true,"1234567890",true,"Poland");
        Assert.assertTrue(!personalDetailsForm.isNextButtonEnabled());
        personalDetailsForm.clickBackToOwnershipScreen();


        //Testcase 6 : skip dual nationality
        System.out.println("Check 6 : Verify Next button is disabled with dual nationality option skipped");
        personalDetailsForm.personalDetailsMandatoryFields(true,"Test name",true,true,
                true,"JC123456Y",true,"1234567890",true,"Poland");
        Assert.assertTrue(!personalDetailsForm.isNextButtonEnabled());
        personalDetailsForm.clickBackToOwnershipScreen();

        //Testcase 7 : skip ni number
        System.out.println("Check 7 : Verify Next button is disabled with ni number set to null/empty");
        personalDetailsForm.personalDetailsMandatoryFields(true,"Test name",true,true,
                false,"",true,"1234567890",true,"Poland");
        Assert.assertTrue(!personalDetailsForm.isNextButtonEnabled());
        personalDetailsForm.clickBackToOwnershipScreen();

        //Testcase 8 : skip gov id selection
        System.out.println("Check 8 : Verify Next button is disabled with government id selection skipped");
        personalDetailsForm.personalDetailsMandatoryFields(true,"Test name",true,true,
                false,"JC123456Y",false,"",true,"Poland");
        Assert.assertTrue(!personalDetailsForm.isNextButtonEnabled());
        personalDetailsForm.clickBackToOwnershipScreen();


        //Testcase 9 : skip gov id selection and set id value
        System.out.println("Check 9 : Verify Next button is disabled with government id value set to 1234567");
        personalDetailsForm.personalDetailsMandatoryFields(true,"Test name",true,true,
                false,"JC123456Y",false,"12132434",true,"Poland");
        Assert.assertTrue(!personalDetailsForm.isNextButtonEnabled());
        personalDetailsForm.clickBackToOwnershipScreen();


        //Testcase 10 : skip jurisdiction country
        System.out.println("Check 10 : Verify Next button is disabled country of jurisdiction skipped");
        personalDetailsForm.personalDetailsMandatoryFields(true,"Test name",true,true,
                false,"JC123456Y",true,"1234567890",false,"");
        Assert.assertTrue(!personalDetailsForm.isNextButtonEnabled());
        personalDetailsForm.clickBackToOwnershipScreen();

    }
}
