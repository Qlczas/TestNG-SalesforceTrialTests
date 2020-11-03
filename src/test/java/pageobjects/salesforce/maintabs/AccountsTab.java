package pageobjects.salesforce.maintabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.PageUtils;

public class AccountsTab extends PageUtils {

    private static final By MAIN_HEADER = By.id("oneHeader");
    private static final By MAIN_CONTENT = By.id("sfdc-splitview-content");
    private static final By NEW_BUTTON = By.cssSelector("a[title='New']");
    private static final By EDIT_BUTTON = By.xpath("//button[@name='Edit']");

    private static final By MODAL_BODY = By.cssSelector("div[class^='modal-body']");
    private static final By NEW_ACCOUNT_NAME = By.xpath("//span[@class='custom-truncate uiOutputText'][text()='Tester']");
    private static final By NEW_ACCOUNT_WEBSITE = By.xpath("//a[text()='www.Test.it']");
    private static final By EDITED_ACCOUNT_WEBSITE = By.xpath("//a[text()='www.Test.pl']");

    public AccountsTab(WebDriver webDriver){
        super(webDriver);
        logText("### Starting Step: Accounts tab is visible");
        verifyElementVisible(MAIN_HEADER);
        verifyElementVisible(MAIN_CONTENT);
    }

    public void openCreateNewAccountModal() {
        logText("### Starting Step: New Account modal is visible");
        clickElement(NEW_BUTTON);
        verifyElementVisible(MODAL_BODY);
    }

    public void openEditAccountModal() {
        logText("### Starting Step: Edit Account modal is visible");
        clickElementByJS(EDIT_BUTTON);
        verifyElementVisible(MODAL_BODY);
    }

    //TODO Make parametrized if needed to create more accounts
    public void verifyAccountCreated() {
        logText("### Starting Step: Verify New Account was created");
        verifyElementVisible(NEW_ACCOUNT_NAME);
        verifyElementVisible(NEW_ACCOUNT_WEBSITE);
    }

    public void verifyAccountEdited() {
        logText("### Starting Step: Verify Account was edited");
        verifyElementVisible(NEW_ACCOUNT_NAME);
        verifyElementVisible(EDITED_ACCOUNT_WEBSITE);
    }
}