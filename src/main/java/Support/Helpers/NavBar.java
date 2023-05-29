package Support.Helpers;

import Support.Constans.EntryPage;
import Support.Constans.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavBar extends Util {
    private  WebDriver driver;

    public NavBar(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By logoutItem =  By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Logout']");
    private final By deleteAccountItem =  By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Delete Account']");
    private final By signUpItem =  By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Signup / Login']");
    private final By contactUsItem =  By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Contact us']");

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

    public void deleteAccount() throws NoSuchElementException {
        clickDeleteAccountItem();
        textIsDisplayed("Account Deleted!");
        clickButton("continue-button", "Continue");
        textIsNotDisplayed(" Logged in as ");
    }

    public By getSignUpItem() {
        return signUpItem;
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
