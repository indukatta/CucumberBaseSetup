package Onboarding_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.Constants;
import utils.ExcelUtils;

import javax.management.ObjectName;

public class endToEndTests extends Base_test {

    private SetUp setUp;
    private BusinessSearch businessSearch;
    private BusinessDetailsForm businessDetailsForm;
    private PersonalDetailsForm personalDetailsForm;
    private OngoingSourceOfWealth ongoingSourceOfWealth;
    private SourceOfFunds sourceOfFunds;
    private TransactionDetails transactionDetails;

    private int testRow;

    @BeforeMethod
    public void before(){
        setUp = new SetUp(driver);
        businessSearch = new BusinessSearch(driver);
        businessDetailsForm = new BusinessDetailsForm(driver);
        personalDetailsForm = new PersonalDetailsForm(driver);
        ongoingSourceOfWealth = new OngoingSourceOfWealth(driver);
        sourceOfFunds = new SourceOfFunds(driver);
        transactionDetails = new TransactionDetails(driver);
        try {
            ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_E2E_Tests, "Dummy data");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void endToEnd(){
        testRow = 1;
        setUp.setUpWithData(ExcelUtils.getCellData(testRow, 5), ExcelUtils.getCellData(testRow, 4));
        businessSearch.passThroughBusinessSearch();
        businessDetailsForm.businessDetailsFormWithData(ExcelUtils.getCellData(testRow, 11),
                ExcelUtils.getCellData(testRow, 2), ExcelUtils.getCellDataNumericValue(testRow, 9));
        personalDetailsForm.personalDetailsWitData(ExcelUtils.getCellData(testRow, 6),
                ExcelUtils.getCellData(testRow, 7), ExcelUtils.getCellData(testRow, 8),
                ExcelUtils.getCellData(testRow, 10), ExcelUtils.getCellData(testRow, 2));
        ongoingSourceOfWealth.passThroughOngoingSourceOfWealth();
        sourceOfFunds.passThrougSourceOfFunds();
        transactionDetails.passThroughTransactionDetails();
    }
}
