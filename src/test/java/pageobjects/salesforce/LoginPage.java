package pageobjects.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.PageUtils;

public class LoginPage extends PageUtils {

    private static final String TEST_URL = "https://q-corp.my.salesforce.com/";
    private static final String TRIAL_USERNAME = "qlczas-mhqa@force.com";
    private static final String TRIAL_PASSWORD = "Testing12#";

    private static final By LOGIN_BOX_CONTAINER = By.id("content");
    private static final By LOGIN_INPUT = By.id("username");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver webDriver){
        super(webDriver);
        logText("### Starting Step: Given Salesforce Trial Login Page is visible");
        openPage(TEST_URL);
        getUrlAndConfirmIfOpened(TEST_URL);
        verifyElementVisible(LOGIN_BOX_CONTAINER);
        verifyElementVisible(LOGIN_INPUT);
        verifyElementVisible(PASSWORD_INPUT);
        verifyElementVisible(LOGIN_BUTTON);
    }

    public void loginTrialUser() {
        logText("### Starting Step: Login Trial User with username: "+ TRIAL_USERNAME);
        addTextToElement(LOGIN_INPUT, TRIAL_USERNAME);
        addTextToElement(PASSWORD_INPUT, TRIAL_PASSWORD);
        clickElement(LOGIN_BUTTON);
    }
}