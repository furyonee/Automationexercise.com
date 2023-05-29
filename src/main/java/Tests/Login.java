package Tests;

import Support.Constans.*;
import Support.Helpers.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class Login {
    static WebDriver driver = DriverInitialization.getDriver();

    Util util = new Util(driver);
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    SignUpPage signUpPage = new SignUpPage(driver);
    NavBar navBar = new NavBar(driver);

    @BeforeClass
    public static void setUp() {
        driver.manage()
                .window()
                .setSize(new Dimension(1366, 720));
    }

    @Test
    public void registerUser() {
        homePage.openHomePage();
        loginPage.openLoginPage();
        loginPage.completeSignUpUserCredentials(EntryPage.USER_NAME, util.generateRandomValue());
        loginPage.clickSignUpButton();
        util.textIsDisplayed("Enter Account Information");
        signUpPage.completeAccountInfo();
        signUpPage.completeAddressInfo();
        signUpPage.finishAccountCreation();
        navBar.userIsLoggedIn();
        navBar.deleteAccount();
    }

    @Test
    public void loginUser() {
        final String USER_EMAIL = util.generateRandomValue();

        homePage.openHomePage();
        loginPage.openLoginPage();
        loginPage.completeSignUpUserCredentials(EntryPage.USER_NAME, USER_EMAIL);
        // Sing Up a new user so independent test data is created (Imagine there's a user creation POST request).
        loginPage.clickSignUpButton();
        signUpPage.completeUserInfo();
        navBar.clickLogoutItem();
        // Finished user creation
        loginPage.openLoginPage();
        loginPage.completeLogInUserCredentials(USER_EMAIL, EntryPage.PASSWORD);
        loginPage.clickLoginButton();
        navBar.userIsLoggedIn();
        navBar.deleteAccount();
    }

    @Test
    public void incorrectCredentialsLogin() {
        homePage.openHomePage();
        loginPage.openLoginPage();
        loginPage.completeLogInUserCredentials(EntryPage.INCORRECT_EMAIL, EntryPage.INCORRECT_PASSWORD);
        loginPage.clickLoginButton();
        util.textIsDisplayed("Your email or password is incorrect!");
    }

    @Test
    public void logOutUser() {
        final String USER_EMAIL = util.generateRandomValue();

        homePage.openHomePage();
        loginPage.openLoginPage();
        loginPage.completeSignUpUserCredentials(EntryPage.USER_NAME, USER_EMAIL);
        // Sing Up a new user so independent test data is created (Imagine there's a user creation POST request).
        loginPage.clickSignUpButton();
        signUpPage.completeUserInfo();
        // Finished user creation
        navBar.clickLogoutItem();
        // Delete user data
        loginPage.completeLogInUserCredentials(USER_EMAIL, EntryPage.PASSWORD);
        loginPage.clickLoginButton();
        navBar.deleteAccount();
    }

    @Test
    public void signUpUserWithExistingEmail() {
        final String USER_EMAIL = util.generateRandomValue();

        homePage.openHomePage();
        loginPage.openLoginPage();
        // Sing Up a new user so independent test data is created (Imagine there's a user creation POST request).
        loginPage.completeSignUpUserCredentials(EntryPage.USER_NAME, USER_EMAIL);
        loginPage.clickSignUpButton();
        signUpPage.completeUserInfo();
        navBar.clickLogoutItem();
        // Finished user creation
        loginPage.completeSignUpUserCredentials(EntryPage.USER_NAME, USER_EMAIL);
        loginPage.clickSignUpButton();
        util.textIsDisplayed("Email Address already exist!");
        // Delete user data
        loginPage.completeLogInUserCredentials(USER_EMAIL, EntryPage.PASSWORD);
        loginPage.clickLoginButton();
        navBar.deleteAccount();
    }
}
