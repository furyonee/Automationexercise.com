package Tests;

import Support.Utils.*;
import Support.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Home {
    static WebDriver driver = DriverInitialization.getDriver();

    HomePage homePage = new HomePage(driver);
    Footer footer = new Footer(driver);
    Header header = new Header(driver);

    @BeforeMethod
    public static void clearCookies() {
        driver
                .manage()
                .deleteAllCookies();
    }

    @Test
    public void verifySubscriptionBlock() {
        homePage.openHomePage();
        footer
                .scrollToFooter()
                .textIsDisplayed("Subscription");
        footer.confirmSubscription();
        header.scrollToHeader();
    }
}
