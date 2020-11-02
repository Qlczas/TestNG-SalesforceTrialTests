package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageUtils {

   protected final WebDriver driver;

    protected PageUtils(WebDriver webDriver) {
        driver = webDriver;
    }

    protected void openPage(String pageUrl) {
        driver.get(pageUrl);
    }

    protected void logText(String givenTextString) {
        //TODO implement any other logger instead of STDOUT
        System.out.println(givenTextString);
    }

    protected void verifyElementVisible(By elementLocator) {
        findGivenElement(elementLocator);
        logText("# Found Element with locator - "+elementLocator.toString());
    }

    protected void clickElement(By elementLocator) {
        waitUntilElementClickableAndClick(elementLocator);
        logText("# Clicked Element with locator - "+elementLocator.toString());
    }

    protected void scrollToElement(By elementLocator){
        WebElement element = driver.findElement(elementLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitForPage(5);
        logText("# Scrolled Page to Element - " + elementLocator);
    }

    protected void addTextToElement(By elementLocator, String textToSend){
        WebElement element = driver.findElement(elementLocator);
        element.sendKeys(textToSend);
        waitForPage(5);
    }

    protected void getUrlAndConfirmIfOpened(String givenUrl) {
        String currentUrl = driver.getCurrentUrl();
        logText("# Currently opened URL is: " + driver.getCurrentUrl());
        Assert.assertEquals(currentUrl, givenUrl);
    }

    protected void findAllElementsAndClickByGivenValue(By elementLocator, String urlToOpen) {
        List<WebElement> foundElements = driver.findElements(elementLocator);
        for (WebElement link: foundElements) {
            if (link.getAttribute("href").contains(urlToOpen)) {
                link.click();
                logText("# Clicked on element with value - " + urlToOpen);
                break;
            }
            else {
                Assert.fail("#Error - Value not found!");
                break;
            }
        }
    }

    private void findGivenElement(By givenLocator){
        driver.findElement(givenLocator);
    }

    private void waitUntilElementClickableAndClick(By elementLocator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        element.click();
    }

    protected void selectDropdownOption(By elementLocator, String textToSelect) {
        Select dropdown = new Select (driver.findElement(elementLocator));
        dropdown.selectByVisibleText(textToSelect);
        logText("# Selected dropdown value: " + textToSelect);
    }

     private void waitForPage(int timeInSeconds){
        driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
    }
}
