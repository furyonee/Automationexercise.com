package Support;

import Support.Constans.EntryPage;
import Support.Constans.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class NavBar extends Util {
    WebDriver driver;

    public NavBar(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By logoutItem =  By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Logout']");
    private final By deleteAccountItem =  By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Delete Account']");
    private final By signUpItem =  By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Signup / Login']");

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

    private void clickDeleteAccountItem() {
        driver.findElement(deleteAccountItem)
                .click();
    }
}
