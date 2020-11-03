package tests;

import org.testng.annotations.Test;
import pageobjects.salesforce.HomePage;
import pageobjects.salesforce.maintabs.AccountsTab;
import pageobjects.salesforce.maintabs.AccountModal;


public class SalesforceTests extends BaseTests {

    @Test(priority = 1, description = "As an admin, I would like to create new User account and verify it was created")
    public void createNewAccountAndVerify() {
        HomePage homePage = new HomePage(driver.get());
        homePage.openGivenHomepageTab("Accounts");

        AccountsTab accountsTab = new AccountsTab(driver.get());
        accountsTab.openCreateNewAccountModal();

        AccountModal accountModal = new AccountModal(driver.get());
        accountModal.fillAccountData();

        accountsTab.verifyAccountCreated();
        accountsTab.openEditAccountModal();

        accountModal.editAccountData();
        accountsTab.verifyAccountEdited();
    }
}
