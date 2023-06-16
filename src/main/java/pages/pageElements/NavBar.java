package pages.pageElements;

import common.constans.EntryPage;
import common.constans.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

public class NavBar extends BasePage {
    private final String root = "//ul[@class='nav navbar-nav']/li/a";
    private final By logoutItem = By.xpath(root + "[text()=' Logout']");
    private final By deleteAccountItem = By.xpath(root + "[text()=' Delete Account']");
    private final By signUpItem = By.xpath(root + "[text()=' Signup / Login']");
    private final By contactUsItem = By.xpath(root + "[text()=' Contact us']");
    private final By testCasesItem = By.xpath(root + "[text()=' Test Cases']");
    private final By productsItem = By.xpath(root + "[text()=' Products']");
    private final By cartItem = By.xpath(root + "[text()=' Cart']");

    public NavBar assertUserIsLoggedIn() {
        assertTextIsDisplayed(" Logged in as ", EntryPage.USER_NAME);
        return this;
    }

    public NavBar clickDeleteAccountItem() {
        click(deleteAccountItem);
        assertProperPageIsOpened(Url.DELETE_ACCOUNT_PAGE, "Your account has been permanently deleted!");
        return this;
    }

    public NavBar clickContactUsItem() {
        click(contactUsItem);
        assertProperPageIsOpened(Url.CONTACT_US_PAGE, "Get In Touch");
        return this;
    }

    public NavBar clickProductsItem() {
        click(productsItem);
        assertProperPageIsOpened(Url.PRODUCTS_PAGE, "All Products");
        return this;
    }

    public NavBar clickCartItem() {
        click(cartItem);
        assertProperPageIsOpened(Url.VIEW_CART_PAGE, "Shopping Cart");
        return this;
    }

    public NavBar clickLogoutItem() {
        click(logoutItem);
        return this;
    }

    public NavBar clickSignUpItem() {
        click(signUpItem);
        assertProperPageIsOpened(Url.LOGIN_PAGE, "Login to your account");
        return this;
    }

    public NavBar clickTestCasesItem() {
        click(testCasesItem);
        assertProperPageIsOpened(Url.TEST_CASES_PAGE, "Below is the list of test Cases for you to practice" +
                " the Automation. Click on the scenario for detailed Test Steps:");
        return this;
    }

    public NavBar scrollToNavBar() {
        new Actions(driver)
                .scrollToElement(driver.findElement(By.className("navbar-nav")))
                .perform();
        return this;
    }
}
