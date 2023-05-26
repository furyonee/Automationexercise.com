import Constans.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");

        Util util = new Util(driver);
        UserEntry userEntry = new UserEntry(driver);

        driver.manage()
                .window()
                .setSize(new Dimension(1366, 720));

        // TC-1
//        util.openBasePage(Url.BASE_URL);
//        userEntry.openEntryPage();
//        util.textIsDisplayed("New User Signup!");
//        userEntry.completeSignUpUserCredentials(EntryPage.USER_NAME, util.generateRandomValue());
//        userEntry.clickSignUpButton();
//        util.textIsDisplayed("Enter Account Information");
//        userEntry.completeAccountInfo();
//        userEntry.completeAddressInfo();
//        util.clickButton("create-account", "Create Account");
//        util.textIsDisplayed("Account Created!");
//        util.clickButton("continue-button", "Continue");
//        userEntry.userIsLoggedIn();
//        userEntry.deleteAccount();

        //TC-2
        final String USER_EMAIL = util.generateRandomValue();

        util.openBasePage(Url.BASE_URL);
        userEntry.openEntryPage();
        userEntry.completeSignUpUserCredentials(EntryPage.USER_NAME, USER_EMAIL);
        userEntry.signUpUser();
        util.textIsDisplayed("Login to your account");
        userEntry.completeLogInUserCredentials(USER_EMAIL, EntryPage.PASSWORD);
        util.clickButton("login-button", "Login");
        userEntry.userIsLoggedIn();
        userEntry.deleteAccount();
//        driver.quit();
    }
}
