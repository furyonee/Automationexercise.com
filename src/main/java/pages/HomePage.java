package pages;

import common.constans.Url;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    private final String productsItem = "//div[@class='features_items']/div[@class='col-sm-4']";
    private final By productItems = By.className("features_items");

    public HomePage productsListIsVisible() {
        waitForElement(productItems);
        List<WebElement> elements = driver.findElements(By.xpath(productsItem));
        Assert.isTrue(elements.size() > 0, "The product list is empty");
        return this;
    }

    public HomePage openHomePage() {
        driver.get(Url.HOME_PAGE);
        assertProperPageIsOpened(Url.HOME_PAGE, "Full-Fledged practice website for Automation Engineers");
        return this;
    }

    public HomePage addToCart(int orderNumber) {
        click(By.xpath(String.format("//div[@class='productinfo text-center']/*[@data-product-id='%d']", orderNumber)));
        waitForElement(By.className("modal-content"));
        return this;
    }

    public HomePage viewProduct(int orderNumber) {
        click(By.xpath(String.format("%s[%d]/div/div[@class='choose']", productsItem, orderNumber)));
        assertProperPageIsOpened(Url.PRODUCT_DETAILS_PAGE + orderNumber, "Write Your Review");
        return this;
    }
}
