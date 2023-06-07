package Tests;

import Support.Helpers.DriverInitialization;
import Support.Helpers.HomePage;
import Support.Helpers.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Products {
    static WebDriver driver = DriverInitialization.getDriver();

    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage = new ProductsPage(driver);

    @Test
    public void verifyProductsPageContent() {
        homePage.openHomePage();
        productsPage
                .openProductsPage()
                .productsListIsVisible()
                .viewProduct(1)
                .textIsDisplayed(
                        "Blue Top",
                        "Category: Women > Tops",
                        "Rs. 500",
                        "Availability:",
                        " In Stock",
                        "Brand:",
                        " Polo"
                );
    }

    @Test
    public void searchProduct() {
        final String PRODUCT_NAME = "Blue Top";

        homePage.openHomePage();
        productsPage
                .openProductsPage()
                .searchProduct(PRODUCT_NAME)
                .productIsFound(PRODUCT_NAME);
    }
}
