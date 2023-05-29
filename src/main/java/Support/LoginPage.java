package Support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage extends Util {
    WebDriver driver;

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
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(navBar.getSignUpItem()))
                .click();
        textIsDisplayed("New User Signup!");
        textIsDisplayed("Login to your account");
    }

    public void clickSignUpButton() {
        clickButton("signup-button", "Signup");
    }

    public void clickLoginButton() {
        clickButton("login-button", "Login");
    }
}