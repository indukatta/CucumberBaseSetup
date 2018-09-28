package Onboarding_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Onboarding.*;
import testData.onboardingTestData.GetE2ETestData;
import testUtils.Base_test;
import utils.Constants;
import utils.ExcelUtils;

import java.util.ArrayList;
import java.util.Iterator;

public class endToEndTests extends Base_test {

    private SetUp setUp;
    private BusinessSearch businessSearch;
    private BusinessDetailsForm businessDetailsForm;
    private PersonalDetailsForm personalDetailsForm;
    private OngoingSourceOfWealth ongoingSourceOfWealth;
    private SourceOfFunds sourceOfFunds;
    private TransactionDetails transactionDetails;
    private InitialWealth initialWealth;

    @BeforeMethod
    public void before(){
        setUp = new SetUp(driver);
        businessSearch = new BusinessSearch(driver);
        businessDetailsForm = new BusinessDetailsForm(driver);
        personalDetailsForm = new PersonalDetailsForm(driver);
        ongoingSourceOfWealth = new OngoingSourceOfWealth(driver);
        sourceOfFunds = new SourceOfFunds(driver);
        transactionDetails = new TransactionDetails(driver);
        initialWealth = new InitialWealth(driver);
        try {
            ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_E2E_Tests, "Data");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_E2E_Tests, "InitialWealth");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DataProvider()
    public Iterator<Object[]> getTestData(){
        ArrayList<Object[]> testData = GetE2ETestData.getDataFromExcel();
        return testData.iterator();
    }

    @Test(dataProvider = "getTestData")
    public void onboardingEndToEnd(String mobile, String email, String company, String tradingName, String taxResidency, String UTR, String previousName,
                                   String residentialAddress, String natInsuranceNumber, String idNumber, String annualTurnover,
                       String country, String valueOfCashDeposits, String totalDeposits, String depositorName, String amountTransferred,
                       String howTheFundsWereGenerated){
        setUp.setUpWithData(mobile, email);
        businessSearch.populateBusinessSearch(company);
        businessDetailsForm.populateBusinessDetailsForm(tradingName,taxResidency,UTR);
        personalDetailsForm.personalDetailsWitData(previousName,residentialAddress,natInsuranceNumber,idNumber,country);
        ongoingSourceOfWealth.populateSourceOfWealth(annualTurnover, howTheFundsWereGenerated, country);
        sourceOfFunds.populateSourceOfFunds(valueOfCashDeposits, totalDeposits, depositorName, amountTransferred, howTheFundsWereGenerated);
        transactionDetails.passThroughTransactionDetails();

    }
    @DataProvider()
    public Iterator<Object[]> getInitialWealth(){
        ArrayList<Object[]> testData = GetE2ETestData.getDataFromExcelInitial();
        return testData.iterator();
    }
    @Test(dataProvider = "getInitialWealth")
    public void onboardingAlternateEndToEnd(String mobile, String email, String company, String tradingName, String taxResidency, String UTR, String previousName,
                                   String residentialAddress, String natInsuranceNumber, String idNumber, String annualTurnover,
                                   String country, String valueOfCashDeposits, String totalDeposits, String depositorName, String amountTransferred,
                                   String howTheFundsWereGenerated,String investorName,String initialAmount, String investedAmount,String investorsCountry,String FundsGenerated){
        setUp.setUpWithData(mobile, email);
        businessSearch.populateBusinessSearch(company);
        businessDetailsForm.populateBusinessDetailsForm(tradingName,taxResidency,UTR);
        personalDetailsForm.personalDetailsWitData(previousName,residentialAddress,natInsuranceNumber,idNumber,country);
        ongoingSourceOfWealth.populateSourceOfWealth(annualTurnover, howTheFundsWereGenerated, country);
        initialWealth.populateInitialWealth(investorName,initialAmount,investedAmount);
        sourceOfFunds.populateSourceOfFunds(valueOfCashDeposits, totalDeposits, depositorName, amountTransferred, howTheFundsWereGenerated);
        transactionDetails.passThroughTransactionDetails();

    }
}