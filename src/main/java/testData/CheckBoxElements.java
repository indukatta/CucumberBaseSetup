package testData;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.FindBy;
import utils.GuiCommands;

import java.util.Random;

public class CheckBoxElements extends GuiCommands {


    public CheckBoxElements(IOSDriver driver) {
        super(driver);
    }

    @FindBy (name = "Active Wealth/Investments")
    private MobileElement activeWealth;

    @FindBy(name = "Business Ownership")
    private MobileElement businessOwnership;

    @FindBy(name = "External Investment")
    private MobileElement externalInvestment;

    @FindBy(name = "Income - Business Income")
    private MobileElement businessIncome;

    @FindBy(name = "Income - Salary")
    private MobileElement incomeSalary;

    @FindBy(name = "Inheritance")
    private MobileElement inheritance;

    @FindBy(name = "Invesment by Ultimate Beneficial Owner/Partner")
    private MobileElement ultimateOwner;

    @FindBy(name = "Intragroup Financing")
    private MobileElement intragroupFinancing;

    @FindBy(name = "Loan - Business")
    private MobileElement businessLoan;

    @FindBy(name = "Lottery Gaming Win")
    private MobileElement lottery;

    @FindBy(name = "Lump sum - Redundancy Payment")
    private MobileElement lumpSum;

    @FindBy(name = "Pension")
    private MobileElement pension;

    @FindBy(name = "Real Estate Development/Investments")
    private MobileElement realEstate;

    @FindBy(name = "Sale of Asssets or Property")
    private MobileElement saleOfAssests;

    @FindBy(name = "Gift")
    private MobileElement gift;

    @FindBy(name = "Other")
    private MobileElement other;

    @FindBy(xpath = "//XCUIElementTypeApplication[@name=\"Iceberg\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable")
    private MobileElement checkBoxTable;

    MobileElement [] cbElements = {activeWealth,businessOwnership,gift,externalInvestment,businessIncome,incomeSalary,
            inheritance,ultimateOwner,intragroupFinancing,businessLoan,lottery,lumpSum,pension,
            realEstate,saleOfAssests};

    public void clickAllCheckboxElements(){

        for (MobileElement e : cbElements){

            click(e);
            scrollDown(checkBoxTable);
            ;
        }
    }

    public void clickRandomElement(){
        Random rand = new Random();

        int value = rand.nextInt(15);

        click(cbElements[value]);
    }

}
