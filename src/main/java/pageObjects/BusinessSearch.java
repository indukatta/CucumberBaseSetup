package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GuiCommands;

public class BusinessSearch extends GuiCommands {

    private SetUp setup = new SetUp(driver);

    public BusinessSearch(IOSDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(name = "Great, you're ready to get started!")
    private MobileElement coverPageTitle;

    @FindBy (name = "Next")
    private MobileElement nextButton;

    @FindBy(name = "Your Business")
    private MobileElement businessSearchTitle;

    @FindBy(name = "business_search.search_field_title")
    private MobileElement businessSearchBoxTitle;

    @FindBy(name = "search_textfield")
    private MobileElement searchTexfield;

    @FindBy(name = "search exit button")
    private MobileElement searchExitButton;

    @FindBy(name = "We are currently experiencing some technical issues. " +
            "Please log back into Iceberg to continue with your sign up later")//FIXME:get a better error message)
    private MobileElement noBusinessFoundError;

    @FindBy(name = "business_details.beneficial_owner")
    private MobileElement beneficialOwner;

    @FindBy(name = "business_details.name")
    private MobileElement businessName;

    @FindBy(name = "business_details.address")
    private MobileElement businessAddress;

    //ELEMENTS DISPLAYED
    public boolean coverPageTitleDisplayed(){
        return coverPageTitle.isDisplayed();
    }

    public boolean businessSearchTitleDisplayed(){
        return businessSearchTitle.isDisplayed();
    }

    public boolean noBusinessFoundErrorDisplayed(){
        return noBusinessFoundError.isDisplayed();
    }

    //ELEMENTS ENABLED
    public boolean isNextButtonEnabled(){
        return nextButton.isEnabled();
    }

    //WRITE METHODS
    public void writeBusinessTitle(String businessName){
        writeText(businessSearchBoxTitle, businessName);
    }

    //CLICK METHODS
    public void clickNextButton(){
        click(nextButton);
    }

    public void clickBusinessSearchBoxTitle(){
        click(businessSearchBoxTitle);
    }

    public void clickSearchExitButton(){
        click(searchExitButton);
    }

    //CLEAR METHODS
    public void clearBusinessSearch(){
        clearText(businessSearchBoxTitle);
    }

    //CUSTOM METHODS
    public void clickTableCell(String locator){
        clickSpecificIosTableCell(locator);
    }

    public void navigateToBusinessSearch(){
        setup.passThroughSetUp();
        click(nextButton);
    }

    public boolean businessSearchKeyboard(){
        navigateToBusinessSearch();
        clickBusinessSearchBoxTitle();
        return doesKeyboardExist();
    }

    public boolean searchByBusinessName(){
        //CUICE-3979 LOOKUP MY BUSINESS - Search by Business Name
        navigateToBusinessSearch();

        writeBusinessTitle("GLAZE");
        if (IosTableCellCount() == 0){
            return false;
        }
        String countOne = String.valueOf(IosTableCellCount());
        writeBusinessTitle(" LIMITED");

        if (IosTableCellCount() == 0) {
            return false;
        }

        String countTwo = String.valueOf(IosTableCellCount());
        clearText(businessSearchBoxTitle);

        if (countOne != countTwo){
            return true;
        } else {
            return false;
        }
    }

    public boolean searchByRegistrationNumber(){
        navigateToBusinessSearch();
        writeBusinessTitle("054");
        if (IosTableCellCount() == 0){
            return false;
        }
        String countOne = String.valueOf(IosTableCellCount());
        writeBusinessTitle("4");
        new WebDriverWait(driver, 1).until(ExpectedConditions.invisibilityOfElementLocated(By.name("HOUSE CROWD PROJECT O54 LIMITED")));

        if (IosTableCellCount() == 0) {
            return false;
        }

        String countTwo = String.valueOf(IosTableCellCount());
        clearText(businessSearchBoxTitle);
        System.out.println(countOne + " " + countTwo);

        if (!countOne.equals(countTwo)){
            return true;
        } else {
            return false;
        }
    }

    public boolean noBussinessFoundSearchByBusinessName(){
        //CUICE-3981 LOOKUP MY BUSINESS - Search by business name - no business found
        navigateToBusinessSearch();
        writeBusinessTitle("noresults");
        return noBusinessFoundErrorDisplayed();
    }

    public boolean noBussinessFoundErrorSearchByBusinessNumber(){
        navigateToBusinessSearch();
        try {
            //CUICE-3982 LOOKUP MY BUSINESS - Search by company reg number - no business found
            writeBusinessTitle("01234567");
            return noBusinessFoundErrorDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean cancelSearch(){
        navigateToBusinessSearch();
        clickBusinessSearchBoxTitle();
        clickSearchExitButton();
        return businessSearchTitleDisplayed();
    }

    public boolean selectionOfCompanyByBusinessName(){
        //CUICE-3995 - LOOKUP MY BUSINESS - Selection of company
        navigateToBusinessSearch();
        clickBusinessSearchBoxTitle();
        writeBusinessTitle("GLAZE LIMITED");
        clickGenericIostableCell();

        //check results are returned
        boolean owner = readText(beneficialOwner).equalsIgnoreCase("Mr Robert Elwell");

        return owner;
    }

    public boolean selectionOfCompanyByBusinessRegNumber(){
        //CUICE-3995 - LOOKUP MY BUSINESS - Selection of company
        navigateToBusinessSearch();
        clickBusinessSearchBoxTitle();
        writeBusinessTitle("05717355");
        clickGenericIostableCell();

        //check results are returned
        boolean owner = readText(beneficialOwner).equalsIgnoreCase("Mr Robert Elwell");


        return owner;
    }

    public boolean isBusinessInformationDisplayed(){
        navigateToBusinessSearch();
        clickBusinessSearchBoxTitle();
        writeBusinessTitle("GLAZE LIMITED");
        clickGenericIostableCell();
        boolean owner = readText(beneficialOwner).equalsIgnoreCase("Mr Robert Elwell");
        boolean name = readText(businessName).equalsIgnoreCase("Glaze Limited");
        boolean address = readText(businessAddress).equalsIgnoreCase("89 King Street\nMaidstone\nME14 1BG\nUnited Kingdom");

        return owner && name && address;
    }

    public void passThroughBusinessSearch(){
        clickNextButton();
        clickBusinessSearchBoxTitle();
        writeBusinessTitle("05717355");
        clickGenericIostableCell();
    }
}
