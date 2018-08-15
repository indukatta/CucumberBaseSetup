package testData;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import utils.Constants;
import utils.ExcelUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class RandomDataGenerator {

    //faker defaulted to British data
    private static Faker faker = new Faker(new Locale("en-GB"));
    private String title;
    private String firstName;
    private String lastName;
    private HashMap<String, String> DOB;
    private String nationality;
    private String idType;
    private String idNumber;
    private String taxNumber;
    private String natInsuranceNumber;
    private String email;
    private String incorrectEmail;
    private String phoneNumber;
    private String randomValue;

    public String setTitle() {
        String title = faker.name().prefix();
        return this.title = title;
    }

    public String setFirstName() {
        String firstName = faker.name().firstName();
        return this.firstName = firstName;
    }

    public String setLastName() {
        String lastName = faker.name().lastName();
        return this.lastName = lastName;
    }

    public HashMap<String, String> setDOB() {
        Date DOB = faker.date().birthday(18, 100);
        HashMap<String, String> map = new HashMap<String, String>();

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
            map.put("day", day);
            map.put("month", month);
            map.put("year", year);
            return this.DOB = map;
        } else {
            map.put("day", dd);
            map.put("month", month);
            map.put("year", year);
            return this.DOB = map;
        }
    }

    public String setNationality() {
        return this.nationality = "United Kingdom";
    }

    public String setIdType() {
        return this.idType = "Drivers License";
    }

    public String setIdNumber() {
        String idNumber = faker.idNumber().valid();
        return this.idNumber = idNumber;
    }

    public String setTaxNumber() {
        String taxNumber = faker.idNumber().valid();
        return this.taxNumber = taxNumber;
    }

    public String setNatInsuranceNumber() {
        String natInsuranceNumber = faker.idNumber().valid();
        return this.natInsuranceNumber = natInsuranceNumber;
    }

    public String setEmail() {
        String email = "email1@email.com";
        return this.email = email;
    }

    public String setIncorrectEmail() {
        String incorrectEmail = "";
        Random rand = new Random();
        int value = rand.nextInt(6);
        switch (value){
            case 0: incorrectEmail = "random.email";
            break;
            case 1: incorrectEmail = "random@email";
            break;
            case 2: incorrectEmail = "random@email.c";
            break;
            case 3: incorrectEmail = "random@email.co1";
            break;
            case 4: incorrectEmail = "random@email.co£";
            break;
            case 5: incorrectEmail = "email$!@email.com";
        }
        return this.incorrectEmail = incorrectEmail;
    }

    public String setPhoneNumber(){
        Random rand = new Random();
        int value = rand.nextInt(2);
        String phoneNumber = faker.phoneNumber().cellPhone();
        String convert = phoneNumber.replaceAll("[^0-9]", "");
        if (value == 0){
            return this.phoneNumber = convert;
        } else {
            String areaCode = convert.substring(1);
            return this.phoneNumber = "+44" + areaCode;
        }
    }

    public String setRandomValue(int count, String type){

        String s;

        switch (type){
            case "Numeric": s = randomNumeric(count);
            break;
            default: s = randomAlphanumeric(count);
            break;
        }

        return this.randomValue = s;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public HashMap<String, String> getDOB(){
        return DOB;
    }

    public String getNationality() {
        return nationality;
    }

    public String getIdType() {
        return idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public String getNatInsuranceNumber() {
        return natInsuranceNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getIncorrectEmail() {
        return incorrectEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRandomValue() {
        return randomValue;
    }

    /**
     * Method which returns random country selected from excel data file
     * @return jurisdiction country
     */
    public String setCountry() {
        String country = "";
        try {
            ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_CountriesList, "Countries");
            int Min = 1;
            int Max = 243;
            int row = Min + (int)(Math.random() * ((Max - Min) + 1));
            country = ExcelUtils.getCellData(row, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }
}
