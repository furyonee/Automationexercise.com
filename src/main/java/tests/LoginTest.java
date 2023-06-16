package tests;

import pages.DeleteAccountPage;
import pages.pageElements.NavBar;
import common.constans.*;
import common.*;
import pages.LoginPage;
import pages.SignUpPage;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {
    Support support = new Support();
    SignUpPage signUpPage = new SignUpPage();
    NavBar navBar = new NavBar();
    LoginPage loginPage = new LoginPage();
    DeleteAccountPage deleteAccountPage = new DeleteAccountPage();

    @Test
    public void registerUser() {
        loginPage
                .openLoginPage()
                .completeSignUpUserCredentials(EntryPage.USER_NAME, support.generateRandomValue())
                .clickSignUpButton()
                .assertTextIsDisplayed("Enter Account Information");
        signUpPage
                .completeAccountInfo()
                .completeAddressInfo()
                .finishAccountCreation();
        navBar
                .assertUserIsLoggedIn()
                .clickDeleteAccountItem();
        deleteAccountPage.assertAccountIsDeleted();
    }

    @Test
    public void loginUser() {
        final String userEmail = support.generateRandomValue();

        loginPage
                .openLoginPage()
                .completeSignUpUserCredentials(EntryPage.USER_NAME, userEmail)
        // Sing Up a new user so independent test data is created (Imagine there's a user creation POST request).
                .clickSignUpButton();
        signUpPage.completeFullSignUpInfo();
        loginPage
                .logOutUser()
        // Finished user creation
                .openLoginPage()
                .completeLogInUserCredentials(userEmail, EntryPage.PASSWORD)
                .clickLoginButton();
        navBar
                .assertUserIsLoggedIn()
                .clickDeleteAccountItem();
        deleteAccountPage.assertAccountIsDeleted();
    }

    @Test
    public void incorrectCredentialsLogin() {
        loginPage
                .openLoginPage()
                .completeLogInUserCredentials(EntryPage.INCORRECT_EMAIL, EntryPage.INCORRECT_PASSWORD)
                .clickLoginButton()
                .assertTextIsDisplayed("Your email or password is incorrect!");
    }

    @Test
    public void logOutUser() {
        final String USER_EMAIL = support.generateRandomValue();

        loginPage
                .openLoginPage()
                .completeSignUpUserCredentials(EntryPage.USER_NAME, USER_EMAIL)
        // Sing Up a new user so independent test data is created (Imagine there's a user creation POST request).
                .clickSignUpButton();
        signUpPage.completeFullSignUpInfo();
        // Finished user creation
        loginPage
                .logOutUser()
        // Delete user data
                .completeLogInUserCredentials(USER_EMAIL, EntryPage.PASSWORD)
                .clickLoginButton();
        navBar.clickDeleteAccountItem();
        deleteAccountPage.assertAccountIsDeleted();
    }

    @Test
    public void signUpUserWithExistingEmail() {
        final String USER_EMAIL = support.generateRandomValue();

        loginPage.openLoginPage()
        // Sing Up a new user so independent test data is created (Imagine there's a user creation POST request).
                .completeSignUpUserCredentials(EntryPage.USER_NAME, USER_EMAIL)
                .clickSignUpButton();
        signUpPage.completeFullSignUpInfo();
        loginPage
                .logOutUser()
        // Finished user creation
                .completeSignUpUserCredentials(EntryPage.USER_NAME, USER_EMAIL)
                .clickSignUpButton()
                .assertTextIsDisplayed("Email Address already exist!");
        // Delete user data
        loginPage
                .completeLogInUserCredentials(USER_EMAIL, EntryPage.PASSWORD)
                .clickLoginButton();
        navBar.clickDeleteAccountItem();
        deleteAccountPage.assertAccountIsDeleted();
    }
}
