package pageobjects.salesforce.maintabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.PageUtils;

public class AccountsTab extends PageUtils {

    private static final String TEST_URL = "https://q-corp.lightning.force.com/lightning/o/Account/list?filterName=Recent";
    private static final By MAIN_HEADER = By.id("oneHeader");
    private static final By MAIN_CONTENT = By.id("sfdc-splitview-content");
    private static final By ACCOUNTS_BREADCRUMB = By.cssSelector("div[class*='forceBreadCrumbItem'][contains(text(),'Accounts')]");
    private static final By NEW_BUTTON = By.cssSelector("a[title='New']");

    private static final By NEW_ACCOUNT_MODAl = By.cssSelector("div[class^='modal-body']");

    public AccountsTab(WebDriver webDriver){
        super(webDriver);
        logText("### Starting Step: Accounts tab is visible");
        getUrlAndConfirmIfOpened(TEST_URL);
        verifyElementVisible(MAIN_HEADER);
        verifyElementVisible(MAIN_CONTENT);
        verifyElementVisible(ACCOUNTS_BREADCRUMB);
    }

    public void createNewUser() {
        logText("### Starting Step: Create new Account ");
        clickElement(NEW_BUTTON);
        verifyElementVisible(NEW_ACCOUNT_MODAl);
    }
}