package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {
    HomePage homePage = new HomePage();

    private final String productsItem = "//div[@class='features_items']/div[@class='col-sm-4']";
    private final By searchInput = By.id("search_product");
    private final By searchButton = By.id("submit_search");
    private final By quantityField = By.id("quantity");
    private final By addToCardButton = By.xpath("//button[@class='btn btn-default cart']");

    public ProductsPage searchProduct(String productName) {
        completeField(searchInput, productName);
        click(searchButton);
        return this;
    }

    public ProductsPage assertProductIsFound(String productName) {
        List<WebElement> elements = driver.findElements(By.xpath(productsItem));
        Assert.isTrue(elements.size() == 1,
                String.format("More than 1 element found by \"%s\" search value", productName));
        return this;
    }

    public ProductsPage addToCard() {
        click(addToCardButton);
        return this;
    }

    public ProductsPage increaseQuantityTo(int quantity) {
        driver
                .findElement(quantityField)
                .clear();
        completeField(quantityField, String.format("%d", quantity));
        return this;
    }

    public HomePage addToCart(int orderNumber) {
        return homePage.addToCart(orderNumber);
    }
}
