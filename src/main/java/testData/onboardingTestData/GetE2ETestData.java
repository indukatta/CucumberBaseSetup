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
            String DOB = ExcelUtils.getCellData(RowNum, 8);
            String residentialAddress = ExcelUtils.getCellData(RowNum, 9);
            String natInsuranceNumber = ExcelUtils.getCellData(RowNum, 10);
            String idNumber = ExcelUtils.getCellData(RowNum, 11);
            String annualTurnover = ExcelUtils.getCellData(RowNum, 12);
            String country = ExcelUtils.getCellData(RowNum, 13);
            String valueOfCashDeposits = ExcelUtils.getCellData(RowNum, 14);
            String totalDeposits = ExcelUtils.getCellData(RowNum, 15);
            String depositorName = ExcelUtils.getCellData(RowNum, 16);
            String amountTransferred = ExcelUtils.getCellData(RowNum, 17);
            String howTheFundsWereGenerated = ExcelUtils.getCellData(RowNum, 18);

            Object objects[] = {mobile, email, company, tradingName, taxResidency, UTR, previousName, DOB, residentialAddress, natInsuranceNumber,
            idNumber, annualTurnover, country, valueOfCashDeposits, totalDeposits, depositorName, amountTransferred, howTheFundsWereGenerated};

            myData.add(objects);
        }
        return myData;
    }
}



















