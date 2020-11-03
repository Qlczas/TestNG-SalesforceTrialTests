package pageobjects.salesforce.maintabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.PageUtils;

public class AccountModal extends PageUtils {

    private static final By MAIN_HEADER = By.xpath("//h2[text()='New Account']");
    private static final By MAIN_CONTENT = By.xpath("//div[@class='actionBody']");

    private static final String INPUT_XPATH = "(//div[@class='actionBody']//span[text()='Account Name']/parent::label/following::div[contains(@class, 'uiInput')]//input)";
    private static final By ACCOUNT_NAME_INPUT = By.xpath(INPUT_XPATH+"[1]");
    private static final By TEST_INPUT = By.xpath(INPUT_XPATH+"[2]");
    private static final By WEBSITE_INPUT = By.xpath(INPUT_XPATH+"[4]");

    private static final By SAVE_BUTTON = By.cssSelector("button[title='Save']");

    public AccountModal(WebDriver webDriver){
        super(webDriver);
        logText("### Starting Step: New Account Creation");
        verifyElementVisible(MAIN_HEADER);
        verifyElementVisible(MAIN_CONTENT);
    }

    public void fillAccountData() {
        logText("### Starting Step: Create new Account ");
        verifyElementVisible(ACCOUNT_NAME_INPUT);
        //TODO add some randomization for new Account info
        addTextToElement(ACCOUNT_NAME_INPUT, "Tester");
        verifyElementVisible(WEBSITE_INPUT);
        waitForPage(3);
        addTextToElement(WEBSITE_INPUT, "www.Test.it");
        addTextToElement(TEST_INPUT, "Initial Test Text");
        waitForPage(3);
        clickElementByJS(SAVE_BUTTON);
    }

    public void editAccountData() {
        logText("### Starting Step: Edit created Account ");
        verifyElementVisible(ACCOUNT_NAME_INPUT);
        verifyElementVisible(WEBSITE_INPUT);
        addTextToElement(WEBSITE_INPUT, "www.Test.pl");
        clickElementByJS(SAVE_BUTTON);
    }
}