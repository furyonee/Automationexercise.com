package pages;

import pages.pageElements.NavBar;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    NavBar navBar = new NavBar();

    private final By signUpNameField = By.cssSelector("[data-qa='signup-name']");
    private final By signUpEmailField = By.cssSelector("[data-qa='signup-email']");
    private final By loginEmailField = By.cssSelector("[data-qa='login-email']");
    private final By loginPasswordField = By.cssSelector("[data-qa='login-password']");
    private final By signUpButton = By.cssSelector("[data-qa='signup-button']");
    private final By loginButton = By.cssSelector("[data-qa='login-button']");

    public LoginPage completeSignUpUserCredentials(String userName, String email) {
        completeField(signUpNameField, userName);
        completeField(signUpEmailField, email + "@user.email");
        return this;
    }

    public LoginPage completeLogInUserCredentials(String email, String password) {
        completeField(loginEmailField, email + "@user.email");
        completeField(loginPasswordField, password);
        return this;
    }

    public LoginPage openLoginPage() {
        navBar.clickSignUpItem();
        assertTextIsDisplayed("New User Signup!", "Login to your account");
        return this;
    }

    public LoginPage clickSignUpButton() {
        click(signUpButton);
        return this;
    }

    public LoginPage clickLoginButton() {
        click(loginButton);
        return this;
    }

    public LoginPage logOutUser() {
        navBar.clickLogoutItem();
        assertTextIsDisplayed(" Signup / Login");
        assertTextIsNotDisplayed(" Logout");
        return this;
    }
}