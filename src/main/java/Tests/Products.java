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
        productsPage.openProductsPage();
        productsPage.productListIsVisible();
        productsPage.openProductByOrderNumber(1);
        productsPage.verifyProductDetailsVisibility();
    }

    @Test
    public void searchProduct() {
        homePage.openHomePage();
        productsPage.openProductsPage();
        productsPage.searchProduct();
    }
}
