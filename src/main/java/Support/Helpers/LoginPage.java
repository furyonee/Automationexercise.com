package Support.Helpers;

import Support.Constans.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Util {
    static WebDriver driver = DriverInitialization.getDriver();

    NavBar navBar = new NavBar(driver);
    SignUpPage signUpPage = new SignUpPage(driver);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By SIGN_UP_NAME_FIELD = By.xpath("//*[@data-qa='signup-name']");
    private final By SING_UP_EMAIL_FIELD = By.xpath("//*[@data-qa='signup-email']");
    private final By LOGIN_EMAIL_FIELD = By.xpath("//*[@data-qa='login-email']");
    private final By LOGIN_PASSWORD_FIELD = By.xpath("//*[@data-qa='login-password']");

    public LoginPage completeSignUpUserCredentials(String userName, String email) {
        completeField(SIGN_UP_NAME_FIELD, userName);
        completeField(SING_UP_EMAIL_FIELD, email + "@user.email");
        return this;
    }

    public LoginPage completeLogInUserCredentials(String email, String password) {
        completeField(LOGIN_EMAIL_FIELD, email + "@user.email");
        completeField(LOGIN_PASSWORD_FIELD, password);
        return this;
    }

    public LoginPage openLoginPage() {
        waitForElement(navBar.getSignUpItem())
                .click();
        textIsDisplayed("New User Signup!", "Login to your account");
        return this;
    }

    public LoginPage clickSignUpButton() {
        clickButton("Signup");
        return this;
    }

    public LoginPage clickLoginButton() {
        clickButton("Login");
        return this;
    }

    public LoginPage deleteAccount() {
        waitForElement(navBar.getDeleteAccountItem())
                .click();
        textIsDisplayed("Account Deleted!");
        clickContinueButton();
        textIsNotDisplayed(" Logged in as ");
        return this;
    }

    public LoginPage logOutUser() {
        waitForElement(navBar.getLogoutItem())
                .click();
        textIsDisplayed(" Signup / Login");
        textIsNotDisplayed(" Logout");
        checkCurrentUrl(Url.LOGIN_PAGE);
        return this;
    }
}