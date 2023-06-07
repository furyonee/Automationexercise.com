package Support.Pages;

import Support.Constans.Url;
import Support.Utils.DriverInitialization;
import Support.Utils.NavBar;
import Support.Utils.Util;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ProductsPage extends Util {
    static WebDriver driver = DriverInitialization.getDriver();

    NavBar navBar = new NavBar(driver);
    Actions action = new Actions(driver);

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private By productItems = By.xpath("//div[@class='features_items']");
    private By searchInput = By.xpath("//input[@id='search_product']");
    private By searchButton = By.xpath("//button[@id='submit_search']");
    private By quantityField = By.xpath("//div[@class='product-information']/span/input[@id='quantity']");
    private String productsItem = "//div[@class='features_items']/div[@class='col-sm-4']";


    public ProductsPage openProductsPage() {
        waitForElement(navBar.getProductsItem())
                .click();
        textIsDisplayed("All Products");
        return this;
    }

    public ProductsPage productsListIsVisible() {
        waitForElement(productItems);
        List<WebElement> elements = driver.findElements(By.xpath(productsItem));
        Assert.isTrue(elements.size() > 0, "The product list is empty");
        return this;
    }

    public ProductsPage viewProduct(int orderNumber) {
        driver
                .findElement(By.xpath(String.format("%s[%d]/div/div[@class='choose']", productsItem, orderNumber)))
                .click();
        checkCurrentUrl(Url.PRODUCT_DETAILS_PAGE + orderNumber);
        return this;
    }

    public ProductsPage searchProduct(String productName) {
        waitForElement(searchInput)
                .sendKeys(productName);
        driver
                .findElement(searchButton)
                .click();
        return this;
    }

    public ProductsPage productIsFound(String productName) {
        List<WebElement> elements = driver.findElements(By.xpath(productsItem));
        Assert.isTrue(elements.size() == 1,
                String.format("More than 1 element found by \"%s\" search value", productName));
        return this;
    }

    public ProductsPage hoverProduct(int productOrder) {
        action
                .moveToElement(findProductByOrderNumber(productOrder))
                .perform();
        return this;
    }

    public ProductsPage addToCard() {
        driver
                .findElement(By.xpath("//button[@class='btn btn-default cart']"))
                .click();
        return this;
    }

    public ProductsPage increaseQuantityTo(int quantity) {
        driver.findElement(quantityField)
                .clear();
        driver.findElement(quantityField)
                .sendKeys(String.format("%d", quantity));
        return this;
    }

    private WebElement findProductByOrderNumber(int orderNumber) {
        return driver.findElement(By.xpath(String.format("%s[%d]", productsItem, orderNumber)));
    }
}
