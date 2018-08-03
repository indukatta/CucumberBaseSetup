package Onboarding_tests;

import org.apache.poi.ss.usermodel.DataFormatter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.Constants;
import utils.ExcelUtils;


public class Personal_Details_Test extends Base_test{

    private OnboardingPersonalDetails details;
    private DataFormatter dataFormatter;
    private OnboardingSetUp newCustomer;
    private OnboardingBusinessDetails businessDetails;


    @BeforeMethod
    public void beforeMethod() throws Exception {
        details = new OnboardingPersonalDetails(driver);
        newCustomer = new OnboardingSetUp(driver);
        businessDetails = new OnboardingBusinessDetails(driver);

        ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData, "Sheet1");
        dataFormatter = new DataFormatter();
    }

    @Test
    public void placeholder(){
        newCustomer.onBoard();
        businessDetails.onBoard(true);

    }

}
