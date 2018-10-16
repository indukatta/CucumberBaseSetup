package testData.onboardingTestData;

import utils.Constants;
import utils.ExcelUtils;

import java.util.ArrayList;
import java.util.Date;

public class GetE2ETestData {

    public static ArrayList<Object[]> getDataFromExcel() {

        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        try {
            ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_E2E_Tests, "Data");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int RowNum = 1; RowNum < ExcelUtils.getRowCount(); RowNum ++){
            String mobile = ExcelUtils.getCellData(RowNum, 1);
            String email = ExcelUtils.getCellData(RowNum, 2);
            String company = ExcelUtils.getCellData(RowNum, 3);
            String tradingName = ExcelUtils.getCellData(RowNum, 4);
            String taxResidency = ExcelUtils.getCellData(RowNum, 5);
            String UTR = ExcelUtils.getCellData(RowNum, 6);
            String previousName = ExcelUtils.getCellData(RowNum, 7);
            String residentialAddress = ExcelUtils.getCellData(RowNum, 8);
            String natInsuranceNumber = ExcelUtils.getCellData(RowNum, 9);
            String idNumber = ExcelUtils.getCellData(RowNum, 10);
            String annualTurnover = ExcelUtils.getCellData(RowNum, 11);
            String country = ExcelUtils.getCellData(RowNum, 12);
            String valueOfCashDeposits = ExcelUtils.getCellData(RowNum, 13);
            String totalDeposits = ExcelUtils.getCellData(RowNum, 14);
            String depositorName = ExcelUtils.getCellData(RowNum, 15);
            String amountTransferred = ExcelUtils.getCellData(RowNum, 16);
            String howTheFundsWereGenerated = ExcelUtils.getCellData(RowNum, 17);

            Object objects[] = {mobile, email, company, tradingName, taxResidency, UTR, previousName, residentialAddress, natInsuranceNumber,
                    idNumber, annualTurnover, country, valueOfCashDeposits, totalDeposits, depositorName, amountTransferred, howTheFundsWereGenerated,};

            myData.add(objects);
        }
        return myData;
    }
    public static ArrayList<Object[]> getDataFromExcelInitial() {

        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        try {
            ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_E2E_Tests, "InitialWealth");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int RowNum = 1; RowNum < ExcelUtils.getRowCount(); RowNum ++){
            String mobile = ExcelUtils.getCellData(RowNum, 1);
            String email = ExcelUtils.getCellData(RowNum, 2);
            String company = ExcelUtils.getCellData(RowNum, 3);
            String tradingName = ExcelUtils.getCellData(RowNum, 4);
            String taxResidency = ExcelUtils.getCellData(RowNum, 5);
            String UTR = ExcelUtils.getCellData(RowNum, 6);
            String previousName = ExcelUtils.getCellData(RowNum, 7);
            String residentialAddress = ExcelUtils.getCellData(RowNum, 8);
            String natInsuranceNumber = ExcelUtils.getCellData(RowNum, 9);
            String idNumber = ExcelUtils.getCellData(RowNum, 10);
            String annualTurnover = ExcelUtils.getCellData(RowNum, 11);
            String country = ExcelUtils.getCellData(RowNum, 12);
            String valueOfCashDeposits = ExcelUtils.getCellData(RowNum, 13);
            String totalDeposits = ExcelUtils.getCellData(RowNum, 14);
            String depositorName = ExcelUtils.getCellData(RowNum, 15);
            String amountTransferred = ExcelUtils.getCellData(RowNum, 16);
            String howTheFundsWereGenerated = ExcelUtils.getCellData(RowNum, 17);
            String investorName = ExcelUtils.getCellData(RowNum, 18);
            String initialAmount = ExcelUtils.getCellData(RowNum, 19);
            String investedAmount = ExcelUtils.getCellData(RowNum, 20);
            String investorsCountry = ExcelUtils.getCellData(RowNum, 21);
            String FundsGenerated = ExcelUtils.getCellData(RowNum, 22);

            Object objects[] = {mobile, email, company, tradingName, taxResidency, UTR, previousName, residentialAddress, natInsuranceNumber,
                    idNumber, annualTurnover, country, valueOfCashDeposits, totalDeposits, depositorName, amountTransferred, howTheFundsWereGenerated,
                    investorName,initialAmount,investedAmount,investorsCountry,FundsGenerated};

            myData.add(objects);
        }
        return myData;
    }
}



















