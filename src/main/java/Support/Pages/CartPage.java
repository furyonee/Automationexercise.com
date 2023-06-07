package Support.Pages;

import Support.Constans.PaymentInfo;
import Support.Constans.Url;
import Support.Utils.DriverInitialization;
import Support.Utils.NavBar;
import Support.Utils.Util;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends Util {
    static WebDriver driver = DriverInitialization.getDriver();

    NavBar navBar = new NavBar(driver);

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By proceedToCheckOutButton = By.xpath("//a[@class='btn btn-default check_out'][text()='Proceed To Checkout']");
    private By entryButton = By.xpath("//u[text()='Register / Login']");
    private By commentField = By.xpath("//textarea[@class='form-control']");
    private By placeOrder = By.xpath("//a[@class='btn btn-default check_out'][text()='Place Order']");
    private By nameOnCard = By.xpath("//input[@data-qa='name-on-card']");
    private By cardNumber = By.xpath("//input[@data-qa='card-number']");
    private By cvc = By.xpath("//input[@data-qa='cvc']");
    private By expiryMonth = By.xpath("//input[@data-qa='expiry-month']");
    private By expiryYear = By.xpath("//input[@data-qa='expiry-year']");
    private String deliveryAddressBox = "//ul[@id='address_delivery']";

    public CartPage openViewCartPage() {
        driver
                .findElement(navBar.getCartItem())
                .click();
        checkCurrentUrl(Url.VIEW_CART_PAGE);
        textIsDisplayed("Shopping Cart");
        return this;
    }

    public CartPage verifyProductInfo(int order, String name, int price, int quantity, int totalPrice) {
        waitForElement(By.xpath(String.format(
                "//tbody/tr[%d]/td[@class='cart_description']/*/*[text()='%s']", order, name)));
        driver.findElement(By.xpath(String.format(
                "//tbody/tr[%d]/td[@class='cart_price']/*[text()='Rs. %d']", order, price)));
        driver.findElement(By.xpath(String.format(
                "//tbody/tr[%d]/td[@class='cart_quantity']/button[text()='%d']", order, quantity)));
        driver.findElement(By.xpath(String.format(
                "//tbody/tr[%d]/td[@class='cart_total']/*[text()='Rs. %d']", order, totalPrice)));
        return this;
    }

    public CartPage clickViewCart() {
        waitForElement(By.xpath("//u[text()='View Cart']"))
                .click();
        return this;
    }

    public CartPage clickProceedToCheckout() {
        driver
                .findElement(proceedToCheckOutButton)
                .click();
        return this;
    }

    public CartPage clickEntryButton() {
        driver
                .findElement(entryButton)
                .click();
        return this;
    }

    public CartPage verifyOrderAddress() {
        getDeliveryAddressInfo(
                "Mr. First Name Last Name",
                "Company",
                "Address",
                "Second Address",
                "City State\n" +
                        "\t\t\t\t\t\t\t\t0987654321",
                "Singapore",
                "+1234567890"
        );
        return this;
    }

    public CartPage leaveComment() {
        driver
                .findElement(commentField)
                .sendKeys("user comment");
        return this;
    }

    public CartPage clickPlaceOrder() {
        driver
                .findElement(placeOrder)
                .click();
        return this;
    }

    public CartPage fillPaymentDetails() {
        completeField(nameOnCard, PaymentInfo.NAME_ON_CARD);
        completeField(cardNumber, PaymentInfo.CARD_NUMBER);
        completeField(cvc, PaymentInfo.CVC);
        completeField(expiryMonth, PaymentInfo.EXPIRATION_MONTH);
        completeField(expiryYear, PaymentInfo.EXPIRATION_YEAR);
        return this;
    }

    private CartPage getDeliveryAddressInfo(String... text) {
        for (String s : text) {
            WebElement deliveryValue = driver.findElement(By.xpath(String.format(deliveryAddressBox + "/li[text()='%s']", s)));
            Assert.isTrue(deliveryValue.isDisplayed(), String.format("\"%s\" text is not found", text));
        }
        return this;
    }
}
