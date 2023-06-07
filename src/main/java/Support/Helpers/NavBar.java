package Support.Helpers;

import Support.Constans.EntryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavBar extends Util {
    public NavBar(WebDriver driver) {
        super(driver);
    }

    private By logoutItem = By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Logout']");
    private By deleteAccountItem = By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Delete Account']");
    private By signUpItem = By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Signup / Login']");
    private By contactUsItem = By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Contact us']");
    private By testCasesItem = By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Test Cases']");
    private By productsItem = By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Products']");
    private By cartItem = By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Cart']");

    public void userIsLoggedIn() {
        textIsDisplayed(" Logged in as ", EntryPage.USER_NAME);
    }

    public By getLogoutItem() {
        return logoutItem;
    }

    public By getSignUpItem() {
        return signUpItem;
    }

    public By getTestCasesItem() {
        return testCasesItem;
    }

    public By getContactUsItem() {
        return contactUsItem;
    }

    public By getProductsItem() {
        return productsItem;
    }

    public By getDeleteAccountItem() {
        return deleteAccountItem;
    }

    public By getCartItem() {
        return cartItem;
    }
}
