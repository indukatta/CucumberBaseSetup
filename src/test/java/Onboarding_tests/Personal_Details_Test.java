package Onboarding_tests;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.junit.Before;
import org.junit.Test;
import pageObjects.*;
import utils.Constants;
import utils.ExcelUtils;

import java.util.Date;


public class Personal_Details_Test extends Base_test {

    Onboarding_Your_Business_Details businessDetails;
    Onboarding_Personal_Details details;
    DataFormatter dataFormatter;

    @Before
    public void beforeMethod() throws Exception {
        businessDetails = new Onboarding_Your_Business_Details(driver);
        details = new Onboarding_Personal_Details(driver);

        ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData, "Sheet1");
        dataFormatter = new DataFormatter();
    }

    @Test
    public void confirmPageNavigation(){
        validateTextEquals(businessDetails.setNavigationBarTitle(), "Your Business Details");
        businessDetails.setContinueButton();
        validateTextEquals(details.setNavigationBarTitle(), "Personal details");
    }

    @Test
    public void manualOnboardingHappyPath() {
        businessDetails.setContinueButton();

        String title = ExcelUtils.getCellData(1,1);
        String firstName = ExcelUtils.getCellData(1,2);
        String lastName = ExcelUtils.getCellData(1,3);
        String nameChanged = ExcelUtils.getCellData(1,4);
        Date DOB = ExcelUtils.getCellDataDateValue(1,5);
        String ResAddress = ExcelUtils.getCellData(1,6);
        String Nationality = ExcelUtils.getCellData(1,7);
        String govId = ExcelUtils.getCellData(1,8);
        int govNum = ExcelUtils.getCellDataNumericValue(1,9);
        String dualNationality = ExcelUtils.getCellData(1,10);
        int juristiction = ExcelUtils.getCellDataNumericValue(1,11);
        String insuranceNum = ExcelUtils.getCellData(1,12);
        String emailAddress = ExcelUtils.getCellData(1,13);
        String confirmEmail = ExcelUtils.getCellData(1,14);

        details.setPerson(title,firstName,lastName,nameChanged,DOB,ResAddress,
                Nationality,govId,govNum,dualNationality,juristiction,insuranceNum,emailAddress,confirmEmail);
    }
}
