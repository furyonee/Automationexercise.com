package tests;

import pages.pageElements.Footer;
import pages.pageElements.ModalWindows;
import pages.pageElements.NavBar;
import common.constans.EntryPage;
import common.*;
import pages.*;
import org.testng.annotations.*;

public class CartTest extends BaseTest {
    Footer footer = new Footer();
    ProductsPage productsPage = new ProductsPage();
    LoginPage loginPage = new LoginPage();
    Support support = new Support();
    SignUpPage signUpPage = new SignUpPage();
    NavBar navBar = new NavBar();
    HomePage homePage = new HomePage();
    PaymentPage paymentPage = new PaymentPage();
    DeleteAccountPage deleteAccountPage = new DeleteAccountPage();
    ModalWindows modalWindow = new ModalWindows();
    ViewCartPage viewCartPage = new ViewCartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void verifySubscriptionInCartPage() {
        footer.assertTextIsDisplayed("Subscription");
        footer
                .completeSubscriptionField()
                .clickSubscribeButton()
                .assertTextIsDisplayed("You have been successfully subscribed!");
    }

    @Test
    public void addProducts() {
        final int FIRST_PRODUCT_IN_LIST = 1;
        final int SECOND_PRODUCT_IN_LIST = 2;

        navBar.clickProductsItem();
        productsPage.addToCart(FIRST_PRODUCT_IN_LIST);
        modalWindow.clickContinueShoppingButton();
        productsPage.addToCart(SECOND_PRODUCT_IN_LIST);
        modalWindow.clickViewCartButton();
        viewCartPage
                .assertProductInfo(1, "Blue Top", 500, 1, 500)
                .assertProductInfo(2, "Men Tshirt", 400, 1, 400);
    }

    @Test
    public void verifyCartProductQuantity() {
        homePage
                .viewProduct(3)
                .assertTextIsDisplayed(
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
        modalWindow.clickViewCartButton();
        viewCartPage.assertProductInfo(1, "Sleeveless Dress", 1000, 4, 4000);
    }

    @Test
    public void signUpDuringCheckout() {
        homePage.addToCart(1);
        modalWindow.clickViewCartButton();
        viewCartPage.clickProceedToCheckoutButton();
        modalWindow.clickRegisterLoginButton();
        loginPage
                .completeSignUpUserCredentials(EntryPage.USER_NAME, support.generateRandomValue())
                .clickSignUpButton();
        signUpPage
                .completeAccountInfo()
                .completeAddressInfo()
                .finishAccountCreation();
        navBar.assertTextIsDisplayed(" Logged in as ", EntryPage.USER_NAME);
        navBar.clickCartItem();
        viewCartPage.clickProceedToCheckoutButton();
        checkoutPage
                .assertOrderAddress()
                .leaveComment()
                .clickPlaceOrderButton();
        paymentPage
                .fillPaymentDetails()
                // Imagine it appears after clicking "Pay and Confirm Order"
                .assertTextPartiallyExist("Your order has been placed successfully!");
        paymentPage
                .clickPayAndConfirmOrderButton()
                .assertTextIsDisplayed("Congratulations! Your order has been confirmed!");
        navBar.clickDeleteAccountItem();
        deleteAccountPage.assertAccountIsDeleted();
    }

    @Test
    public void signUpBeforeCheckout() {
        loginPage
                .openLoginPage()
                .completeSignUpUserCredentials(EntryPage.USER_NAME, support.generateRandomValue())
                .clickSignUpButton();
        signUpPage
                .completeAccountInfo()
                .completeAddressInfo()
                .finishAccountCreation()
                .assertTextIsDisplayed(" Logged in as ", EntryPage.USER_NAME);
        homePage.addToCart(1);
        modalWindow.clickContinueShoppingButton();
        navBar.clickCartItem();
        viewCartPage.clickProceedToCheckoutButton();
        checkoutPage
                .assertOrderAddress()
                .leaveComment()
                .clickPlaceOrderButton();
        paymentPage
                .fillPaymentDetails()
                .clickPayAndConfirmOrderButton()
                .assertTextIsDisplayed("Congratulations! Your order has been confirmed!");
        navBar.clickDeleteAccountItem();
        deleteAccountPage.assertAccountIsDeleted();
    }
}
