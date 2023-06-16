package pages;

import org.openqa.selenium.By;

public class ViewCartPage extends BasePage {
    private final String root = "//tbody/tr[%d]/td";
    private final String cartDescription = root + "[@class='cart_description']/*/*[text()='%s']";
    private final String cartPrice = root + "[@class='cart_price']/*[text()='Rs. %d']";
    private final String cartQuantity = root + "[@class='cart_quantity']/button[text()='%d']";
    private final String cartTotalPrice = root + "[@class='cart_total']/*[text()='Rs. %d']";
    private final By proceedToCheckOutButton = By.xpath("//*[text()='Proceed To Checkout']");

    public ViewCartPage assertProductInfo(int order, String name, int price, int quantity, int totalPrice) {
        waitForElement(By.xpath(String.format(cartDescription, order, name)));
        waitForElement(By.xpath(String.format(cartPrice, order, price)));
        waitForElement(By.xpath(String.format(cartQuantity, order, quantity)));
        waitForElement(By.xpath(String.format(cartTotalPrice, order, totalPrice)));
        return this;
    }

    public ViewCartPage clickProceedToCheckoutButton() {
        click(proceedToCheckOutButton);
        return this;
    }
}
