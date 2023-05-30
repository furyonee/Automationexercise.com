package Support.Helpers;

import Support.Constans.Url;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends Util {
    private WebDriver driver;

    NavBar navBar = new NavBar(driver);

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By productItems = By.xpath("//div[@class='features_items']");
    private final By searchInput = By.xpath("//input[@id='search_product']");
    private final By searchButton = By.xpath("//button[@id='submit_search']");
    private final String productsItem = "//div[@class='features_items']/div[@class='col-sm-4']";
    private final String[] firstProductDetails = {"Blue Top", "Category: Women > Tops", "Rs. 500", "Availability:",
            " In Stock", "Brand:", " Polo"};

    public void openProductsPage() {
        waitForElement(navBar.getProductsItem())
                .click();
        textIsDisplayed("All Products");
    }

    public void productListIsVisible() {
        waitForElement(productItems);
        List<WebElement> elements = driver.findElements(By.xpath(productsItem));
        Assert.isTrue(elements.size() > 0, "The product list is empty");
    }

    public void openProductByOrderNumber(int orderNumber) {
        driver.findElement(By.xpath(String.format("%s[%d]/div/div[@class='choose']", productsItem, orderNumber)))
                        .click();
        checkCurrentUrl(Url.PRODUCT_DETAILS_PAGE + orderNumber);
    }

    public void verifyProductDetailsVisibility() {
        textIsDisplayed(firstProductDetails);
    }

    public void searchProduct() {
        waitForElement(searchInput)
                .sendKeys(firstProductDetails[0]);
        driver.findElement(searchButton)
                .click();

        List<WebElement> elements = driver.findElements(By.xpath(productsItem));
        Assert.isTrue(elements.size() == 1,
                String.format("More than 1 element found by \"%s\" search value", firstProductDetails[0]));
    }
}
