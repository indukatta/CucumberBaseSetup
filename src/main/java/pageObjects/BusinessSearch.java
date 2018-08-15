package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GuiCommands;

public class BusinessSearch extends GuiCommands {

    public BusinessSearch(AppiumDriver driver) {
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
        clickIosTableCell(locator);
    }

    public void passThroughBusinessSearch(){
        clickNextButton();
        clickBusinessSearchBoxTitle();
        writeBusinessTitle("06587021");
        clickIosTableCell("THE GREAT BRITISH SAUSAGE COMPANY LTD");
    }
}
