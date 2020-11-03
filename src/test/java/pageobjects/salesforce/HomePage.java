package pageobjects.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.PageUtils;

public class HomePage extends PageUtils {

    private static final String TEST_URL = "https://q-corp.lightning.force.com/one/one.app";
    private static final String ACCOUNTS_URL = "https://q-corp.lightning.force.com/lightning/o/Account/list?filterName=Recent";
    private static final By MAIN_HEADER = By.id("oneHeader");
    private static final By MAIN_CONTAINER = By.cssSelector("div[class='slds-no-print oneAppNavContainer']");

    public HomePage(WebDriver webDriver){
        super(webDriver);
        logText("### Starting Step: Given Salesforce Trial Page is visible");
        //TODO make below more stable, add TryCatch or fluent Wait
        //getUrlAndConfirmIfOpened(TEST_URL);
        verifyElementVisible(MAIN_HEADER);
    }

    public void openGivenHomepageTab(String tabName) {
        logText("### Starting Step: Open tab with name: "+ tabName);
        By currentTabSelector = By.xpath("//a[@title='"+tabName+"']");
        verifyElementVisible(MAIN_CONTAINER);
        verifyElementVisible(currentTabSelector);
        clickElementByJS(currentTabSelector);
    }
}