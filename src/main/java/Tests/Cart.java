package Tests;

import Support.Constans.EntryPage;
import Support.Utils.*;
import Support.Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class Cart {
    static WebDriver driver = DriverInitialization.getDriver();

    HomePage homePage = new HomePage(driver);
    Footer footer = new Footer(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    CartPage cartPage = new CartPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    Util util = new Util(driver);
    SignUpPage signUpPage = new SignUpPage(driver);
    NavBar navBar = new NavBar(driver);

    @BeforeMethod
    public static void clearCookies() {
        driver
                .manage()
                .deleteAllCookies();
    }

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
                .addToCardFromList(FIRST_PRODUCT_IN_LIST)
                .clickButton("Continue Shopping");
        productsPage
                .hoverProduct(SECOND_PRODUCT_IN_LIST)
                .addToCardFromList(SECOND_PRODUCT_IN_LIST);
        cartPage
                .openViewCartPage()
                .verifyProductInfo(1, "Blue Top", 500, 1, 500)
                .verifyProductInfo(2, "Men Tshirt", 400, 1, 400);
    }

    @Test
    public void verifyCartProductQuantity() {
        homePage.openHomePage();
        productsPage
                .viewProduct(3)
                .textIsDisplayed(
                        "Sleeveless Dress",
                        "Category: Women > Dress",
                        "Rs. 1000",
                        "Availability:",
                        " In Stock",
                        "Brand:",
                        " Madame"
                );
        productsPage
                .increaseQuantityTo(4)
                .addToCard();
        cartPage
                .clickViewCart()
                .verifyProductInfo(1, "Sleeveless Dress", 1000, 4, 4000);
    }

    @Test
    public void signUpDuringCheckout() {
        homePage.openHomePage()
                .addToCardFromList(1);
        cartPage
                .clickViewCart()
                .clickProceedToCheckout()
                .clickEntryButton();
        loginPage
                .completeSignUpUserCredentials(EntryPage.USER_NAME, util.generateRandomValue())
                .clickSignUpButton();
        signUpPage
                .completeAccountInfo()
                .completeAddressInfo()
                .finishAccountCreation()
                .textIsDisplayed(" Logged in as ", EntryPage.USER_NAME);
        cartPage
                .openViewCartPage()
                .clickProceedToCheckout()
                .verifyOrderAddress()
                .leaveComment()
                .clickPlaceOrder()
                .fillPaymentDetails()
                // Imagine it appears after clicking "Pay and Confirm Order"
                .containsText("Your order has been placed successfully!")
                .clickButton("Pay and Confirm Order")
                .textIsDisplayed("Congratulations! Your order has been confirmed!");
        navBar.deleteAccount();
    }

    @Test
    public void signUpBeforeCheckout() {
        homePage.openHomePage();
        loginPage
                .openLoginPage()
                .completeSignUpUserCredentials(EntryPage.USER_NAME, util.generateRandomValue())
                .clickSignUpButton();
        signUpPage
                .completeAccountInfo()
                .completeAddressInfo()
                .finishAccountCreation()
                .textIsDisplayed(" Logged in as ", EntryPage.USER_NAME)
                .addToCardFromList(1);
        cartPage
                .openViewCartPage()
                .clickProceedToCheckout()
                .verifyOrderAddress()
                .leaveComment()
                .clickPlaceOrder()
                .fillPaymentDetails()
                .clickButton("Pay and Confirm Order")
                .textIsDisplayed("Congratulations! Your order has been confirmed!");
        navBar.deleteAccount();
    }
}
