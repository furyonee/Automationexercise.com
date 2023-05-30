package Support.Helpers;

import Support.Constans.EntryPage;
import Support.Constans.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavBar extends Util {
    static WebDriver driver = DriverInitialization.getDriver();

    public NavBar(WebDriver driver) {
        super(driver);
    }

    private final By logoutItem = By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Logout']");
    private final By deleteAccountItem = By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Delete Account']");
    private final By signUpItem = By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Signup / Login']");
    private final By contactUsItem = By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Contact us']");
    private final By testCasesItem = By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Test Cases']");

    public void clickLogoutItem() {
        driver.findElement(logoutItem)
                .click();
        textIsDisplayed(" Signup / Login");
        textIsNotDisplayed(" Logout");
        checkCurrentUrl(Url.LOGIN_PAGE);
    }

    public void userIsLoggedIn() {
        textIsDisplayed(" Logged in as ");
        textIsDisplayed(EntryPage.USER_NAME);
    }

    public void deleteAccount() {
        clickDeleteAccountItem();
        textIsDisplayed("Account Deleted!");
        clickButton("continue-button", "Continue");
        textIsNotDisplayed(" Logged in as ");
    }

    public void clickSignUpItem() {
        waitForElement(signUpItem)
                .click();
        checkCurrentUrl(Url.LOGIN_PAGE);
    }

    public void clickTestCasesItem() {
        waitForElement(testCasesItem)
                .click();
    }

    public void clickContactUsItem() {
        waitForElement(contactUsItem)
                .click();
    }

    private void clickDeleteAccountItem() {
        driver.findElement(deleteAccountItem)
                .click();
    }
}
