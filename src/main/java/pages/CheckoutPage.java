package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
    private final By placeOrder = By.xpath("//*[text()='Place Order']");
    private final By commentField = By.className("form-control");
    private final String deliveryAddressBox = "//ul[@id='address_delivery']";

    public CheckoutPage assertOrderAddress() {
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

    public CheckoutPage leaveComment() {
        completeField(commentField, "user comment");
        return this;
    }

    public CheckoutPage clickPlaceOrderButton() {
        click(placeOrder);
        return this;
    }

    private CheckoutPage getDeliveryAddressInfo(String... text) {
        for (String s : text) {
            WebElement deliveryValue = driver.findElement(By.xpath(String.format(deliveryAddressBox + "/li[text()='%s']", s)));
            Assert.isTrue(deliveryValue.isDisplayed(), String.format("\"%s\" text is not found", text));
        }
        return this;
    }
}
