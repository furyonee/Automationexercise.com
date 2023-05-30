package Support.Helpers;

import Support.Constans.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Util {
    private WebDriver driver;

    NavBar navBar = new NavBar(driver);

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By signUpNameField = By.xpath("//*[@data-qa='signup-name']");
    private final By signUpEmailField = By.xpath("//*[@data-qa='signup-email']");
    private final By loginEmailField = By.xpath("//*[@data-qa='login-email']");
    private final By loginPasswordField = By.xpath("//*[@data-qa='login-password']");

    public void completeSignUpUserCredentials(String userName, String email) {
        completeField(signUpNameField, userName);
        completeField(signUpEmailField, email + "@user.email");
    }

    public void completeLogInUserCredentials(String email, String password) {
        completeField(loginEmailField, email + "@user.email");
        completeField(loginPasswordField, password);
    }

    public void openLoginPage() {
        waitForElement(navBar.getSignUpItem())
                .click();
        textIsDisplayed("New User Signup!", "Login to your account");
    }

    public void clickSignUpButton() {
        clickButton("signup-button", "Signup");
    }

    public void clickLoginButton() {
        clickButton("login-button", "Login");
    }

    public void deleteAccount() {
        waitForElement(navBar.getDeleteAccountItem())
                .click();
        textIsDisplayed("Account Deleted!");
        clickButton("continue-button", "Continue");
        textIsNotDisplayed(" Logged in as ");
    }

    public void logOutUser() {
        waitForElement(navBar.getLogoutItem())
                .click();
        textIsDisplayed(" Signup / Login");
        textIsNotDisplayed(" Logout");
        checkCurrentUrl(Url.LOGIN_PAGE);
    }
}