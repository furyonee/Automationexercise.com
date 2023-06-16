package tests;

import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.ProductsPage;
import org.testng.annotations.Test;
import pages.pageElements.NavBar;

public class ProductsTest extends BaseTest {
    ProductsPage productsPage = new ProductsPage();
    NavBar navBar = new NavBar();
    HomePage homePage = new HomePage();

    @BeforeMethod
    public void setUp() {
        navBar.clickProductsItem();
    }

    @Test
    public void verifyProductsPageContent() {
        homePage
                .productsListIsVisible()
                .viewProduct(1)
                .assertTextIsDisplayed(
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
        final String productName = "Blue Top";

        productsPage
                .searchProduct(productName)
                .assertProductIsFound(productName);
    }
}
