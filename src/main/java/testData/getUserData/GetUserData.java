package testData.getUserData;

import utils.Constants;
import utils.ExcelUtils;

import java.util.HashMap;

public class GetUserData {

    public static HashMap getFirstTimeUser(){
        try {
            ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_User_Data, "Users");
        } catch (Exception e) {
            e.printStackTrace();
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("Username", ExcelUtils.getCellData(2,2));
        map.put("Password", ExcelUtils.getCellData(2,3));

        return map;
    }
}
