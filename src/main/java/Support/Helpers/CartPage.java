package Support.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.tracing.model.StreamFormat;

public class CartPage extends Util{
    static WebDriver driver = DriverInitialization.getDriver();

    NavBar navBar = new NavBar(driver);

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage openViewCartPage() {
        driver
                .findElement(navBar.getCartItem())
                .click();
        return this;
    }

    public CartPage verifyProductInfo(int order, String name, int price, int quantity, int totalPrice) {
        driver.findElement(By.xpath(String.format(
                "//tbody/tr[@id='product-%d']/td[@class='cart_description']/*/*[text()='%s']", order, name)));
        driver.findElement(By.xpath(String.format(
                "//tbody/tr[@id='product-%d']/td[@class='cart_price']/*[text()='Rs. %d']", order, price)));
        driver.findElement(By.xpath(String.format(
                "//tbody/tr[@id='product-%d']/td[@class='cart_quantity']/button[text()='%d']", order, quantity)));
        driver.findElement(By.xpath(String.format(
                "//tbody/tr[@id='product-%d']/td[@class='cart_total']/*[text()='Rs. %d']", order, totalPrice)));
        return this;
    }
}
