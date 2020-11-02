package tests;

import driverfactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.salesforce.LoginPage;

public class BaseTests {

    final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    @BeforeMethod
    public void setupWebDriver() {
        driver.set(DriverFactory.getDriver());

        //driver = DriverFactory.getDriver();
        //Path to driver can be set below or in env variables or in maven properties
        //System.setProperty("webdriver.chrome.driver", driverPath);
        //driver = new ChromeDriver();
        //System.setProperty("webdriver.firefox.marionette", driverPath);
        //driver = new FirefoxDriver();

        LoginPage loginPage = new LoginPage(driver.get());
        loginPage.loginTrialUser();
    }

    @AfterMethod
    public void tearDownTest() {
        driver.get().close();
        driver.get().quit();
    }
}
