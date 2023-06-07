package Tests;

import Support.Utils.DriverInitialization;
import Support.Pages.HomePage;
import Support.Pages.ProductsPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Products {
    static WebDriver driver = DriverInitialization.getDriver();

    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage = new ProductsPage(driver);

    @BeforeMethod
    public static void clearCookies() {
        driver
                .manage()
                .deleteAllCookies();
    }

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
