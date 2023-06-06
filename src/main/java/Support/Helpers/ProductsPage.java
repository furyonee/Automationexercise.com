package Support.Helpers;

import Support.Constans.Url;
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

    private final By productItems = By.xpath("//div[@class='features_items']");
    private final By searchInput = By.xpath("//input[@id='search_product']");
    private final By searchButton = By.xpath("//button[@id='submit_search']");
    private final String productsItem = "//div[@class='features_items']/div[@class='col-sm-4']";
    private final String[] firstProductDetails = {"Blue Top", "Category: Women > Tops", "Rs. 500", "Availability:",
            " In Stock", "Brand:", " Polo"};

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

    public ProductsPage verifyProductDetailsVisibility() {
        textIsDisplayed(firstProductDetails);
        return this;
    }

    public ProductsPage searchProduct() {
        waitForElement(searchInput)
                .sendKeys(firstProductDetails[0]);
        driver
                .findElement(searchButton)
                .click();
        return this;
    }

    public ProductsPage productIsFound() {
        List<WebElement> elements = driver.findElements(By.xpath(productsItem));
        Assert.isTrue(elements.size() == 1,
                String.format("More than 1 element found by \"%s\" search value", firstProductDetails[0]));
        return this;
    }

    public ProductsPage hoverProduct(int productOrder) {
        action
                .moveToElement(findProductByOrderNumber(productOrder))
                .perform();
        return this;
    }

    public ProductsPage addToCard(int orderNumber) {
        driver
                .findElement(By.xpath(String.format("//a[@data-product-id='%d']", orderNumber)))
                .click();
        return this;
    }

    private WebElement findProductByOrderNumber(int orderNumber) {
        return driver.findElement(By.xpath(String.format("%s[%d]", productsItem, orderNumber)));
    }
}
