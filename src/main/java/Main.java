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

        util.openBasePage(Url.BASE_URL);
        util.pageIsOpened(Url.BASE_URL, "Full-Fledged practice website for Automation Engineers");
        userEntry.openEntryPage();
        util.textIsDisplayed("New User Signup!");
        userEntry.completeUserCredentials();
        userEntry.clickSignUpButton();
        util.textIsDisplayed("Enter Account Information");
        userEntry.completeAccountInfo();
        userEntry.completeAddressInfo();
        util.clickButton("create-account", "Create Account");
        util.textIsDisplayed("Account Created!");
        util.clickButton("continue-button", "Continue");
        util.textIsDisplayed(" Logged in as ", util.generateRandomValue());
        userEntry.clickDeleteAccountButton();
        util.textIsDisplayed("Account Deleted!");
        util.clickButton("continue-button", "Continue");

        driver.quit();
    }
}
