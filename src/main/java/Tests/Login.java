package Tests;

import Support.Constans.*;
import Support.Helpers.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class Login {
    static WebDriver driver = DriverInitialization.getDriver();

    Util util = new Util(driver);
    HomePage homePage = new HomePage(driver);
    SignUpPage signUpPage = new SignUpPage(driver);
    NavBar navBar = new NavBar(driver);
    LoginPage loginPage = new LoginPage(driver);

    @BeforeClass
    public static void setUp() {
        driver.manage()
                .window()
                .setSize(new Dimension(1366, 720));
    }

    @Test
    public void registerUser() {
        homePage.openHomePage();
        loginPage.openLoginPage()
                .completeSignUpUserCredentials(EntryPage.USER_NAME, util.generateRandomValue())
                .clickSignUpButton()
                .textIsDisplayed("Enter Account Information");
        signUpPage.completeAccountInfo()
                .completeAddressInfo()
                .finishAccountCreation();
        navBar.userIsLoggedIn();
        loginPage.deleteAccount();
    }

    @Test
    public void loginUser() {
        final String USER_EMAIL = util.generateRandomValue();

        homePage.openHomePage();
        loginPage.openLoginPage()
                .completeSignUpUserCredentials(EntryPage.USER_NAME, USER_EMAIL);
        // Sing Up a new user so independent test data is created (Imagine there's a user creation POST request).
        loginPage.clickSignUpButton();
        signUpPage.completeUserInfo();
        loginPage.logOutUser();
        // Finished user creation
        loginPage.openLoginPage()
                .completeLogInUserCredentials(USER_EMAIL, EntryPage.PASSWORD)
                .clickLoginButton();
        navBar.userIsLoggedIn();
        loginPage.deleteAccount();
    }

    @Test
    public void incorrectCredentialsLogin() {
        homePage.openHomePage();
        loginPage.openLoginPage()
                .completeLogInUserCredentials(EntryPage.INCORRECT_EMAIL, EntryPage.INCORRECT_PASSWORD)
                .clickLoginButton()
                .textIsDisplayed("Your email or password is incorrect!");
    }

    @Test
    public void logOutUser() {
        final String USER_EMAIL = util.generateRandomValue();

        homePage.openHomePage();
        loginPage.openLoginPage()
                .completeSignUpUserCredentials(EntryPage.USER_NAME, USER_EMAIL);
        // Sing Up a new user so independent test data is created (Imagine there's a user creation POST request).
        loginPage.clickSignUpButton();
        signUpPage.completeUserInfo();
        // Finished user creation
        loginPage.logOutUser();
        // Delete user data
        loginPage.completeLogInUserCredentials(USER_EMAIL, EntryPage.PASSWORD)
                .clickLoginButton()
                .deleteAccount();
    }

    @Test
    public void signUpUserWithExistingEmail() {
        final String USER_EMAIL = util.generateRandomValue();

        homePage.openHomePage();
        loginPage.openLoginPage();
        // Sing Up a new user so independent test data is created (Imagine there's a user creation POST request).
        loginPage.completeSignUpUserCredentials(EntryPage.USER_NAME, USER_EMAIL)
                .clickSignUpButton();
        signUpPage.completeUserInfo();
        loginPage.logOutUser();
        // Finished user creation
        loginPage.completeSignUpUserCredentials(EntryPage.USER_NAME, USER_EMAIL)
                .clickSignUpButton()
                .textIsDisplayed("Email Address already exist!");
        // Delete user data
        loginPage.completeLogInUserCredentials(USER_EMAIL, EntryPage.PASSWORD)
                .clickLoginButton()
                .deleteAccount();
    }
}
