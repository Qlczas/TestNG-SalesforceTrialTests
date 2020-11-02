package pageobjects.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.PageUtils;

public class HomePage extends PageUtils {

    private static final String TEST_URL = "https://q-corp.lightning.force.com/lightning/page/home";
    private static final By MAIN_HEADER = By.id("oneHeader");

    public HomePage(WebDriver webDriver){
        super(webDriver);
        logText("### Starting Step: Given Salesforce Trial Page is visible");
        getUrlAndConfirmIfOpened(TEST_URL);
        verifyElementVisible(MAIN_HEADER);
    }

    public void openGivenHomepageTab(String tabName) {
        logText("### Starting Step: Open tab with name: "+ tabName);
        By tabSelector = By.cssSelector("a[title='"+tabName+"']");
        verifyElementVisible(tabSelector);
        clickElement(tabSelector);
    }
}