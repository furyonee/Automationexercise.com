package Tests;

import Support.Constans.Url;
import Support.Helpers.*;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Cart {
    static WebDriver driver = DriverInitialization.getDriver();

    HomePage homePage = new HomePage(driver);
    Footer footer = new Footer(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    CartPage cartPage = new CartPage(driver);

    @Test
    public void verifySubscriptionInCartPage() {
        homePage.openHomePage();
        footer
                .scrollToFooter()
                .textIsDisplayed("Subscription");
        footer
                .confirmSubscription()
                .textIsDisplayed("You have been successfully subscribed!");
    }

    @Test
    public void addProducts() {
        final int FIRST_PRODUCT_IN_LIST = 1;
        final int SECOND_PRODUCT_IN_LIST = 2;

        homePage.openHomePage();
        productsPage
                .openProductsPage()
                .hoverProduct(FIRST_PRODUCT_IN_LIST)
                .addToCard(FIRST_PRODUCT_IN_LIST)
                .clickButton("Continue Shopping");
        productsPage
                .hoverProduct(SECOND_PRODUCT_IN_LIST)
                .addToCard(SECOND_PRODUCT_IN_LIST);
        cartPage
                .openViewCartPage()
                .verifyProductInfo(1, "Blue Top", 500, 1, 500)
                .verifyProductInfo(2, "Men Tshirt", 400, 1, 400);
    }
}
