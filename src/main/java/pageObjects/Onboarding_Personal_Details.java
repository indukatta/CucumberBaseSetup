package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Onboarding_Personal_Details extends Page {

    /**
     * MobileElement Locators
     */
    //Input Fields
    @FindBy(name = "Input - Full Legal Name")
    private MobileElement inputFullName;

    @FindBy(name = "Input - Previous Legal Name")
    private MobileElement inputPreviousName;

    //Drop Down Menus
    @FindBy(name = "Select - Title")
    private MobileElement clickSelectTitle;

    @FindBy(className = "XCUIElementTypePickerWheel")
    private MobileElement selectTitle;

    @FindBy(name = "Select - Date of Birth")
    private MobileElement selectDOB;

    @FindBy(name = "Select - Nationality")
    private MobileElement selectNationality;

    //Checkbox
    @FindBy(name = "Switch - Are you dual nationality/citizenship")
    private MobileElement switchDualNationality;

    //Button
    @FindBy(name = "Next")
    private MobileElement nextButton;


    public Onboarding_Personal_Details(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    //Onboarding Form Page One
    public void setTitle(String title){
        click(clickSelectTitle);
        selectTitle.sendKeys(title);
        //FIX need to navigate and select titles
    }

    public void setFullName(String Name){
        writeText(inputFullName, Name);
        driver.hideKeyboard();
    }

    public void setPreviousName(String Name){
        writeText(inputPreviousName, Name);
        driver.hideKeyboard();
    }

    public void setDOB(String day, String month, String year){
        click(selectDOB);
        WebElement monthElement = (WebElement) driver.findElements(By.className("XCUIElementTypePickerWheel")).get(0);
        monthElement.sendKeys(month);
        WebElement dayElement = (WebElement) driver.findElements(By.className("XCUIElementTypePickerWheel")).get(1);
        dayElement.sendKeys(day);
        WebElement yearElement = (WebElement) driver.findElements(By.className("XCUIElementTypePickerWheel")).get(2);
        yearElement.sendKeys(year);
        //FIX needs logic for British/American date structure and for date set.
    }

    public void setNationality(String nationality){
        click(selectNationality);
        //FIX need to work out how to navigate and select nationality dropdown
    }

    public void setDualNationality(boolean dualNationality){
        click(switchDualNationality);
    }

    public void next(){
        click(nextButton);
    }

    public void setPerson(String title, String name, String previousName, String DOB, String nationality, boolean dualCitizen){
        setTitle(title);
        setFullName(name);
        setPreviousName(previousName);

        String[] dateFormatParts = DOB.split("/");
        String dd = dateFormatParts[0];
        String month = dateFormatParts[1];
        String year = dateFormatParts[2];
        //if statement to remove the 0 in front of dates 1 - 9
        if (dd.contains("0")){
            char singleNum = dd.charAt(1);
            String day = dd.toString();
            setDOB(day, month, year);
        } else {
            setDOB(dd, month, year);
        }

        setNationality(nationality);
        setDualNationality(dualCitizen);
    }
}
