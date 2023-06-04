package Tests;

import Support.Helpers.DriverInitialization;
import Support.Helpers.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class Home {
    static WebDriver driver = DriverInitialization.getDriver();

    HomePage homePage = new HomePage(driver);

    @Test
    public void verifySubscriptionBlock() {
        homePage.openHomePage();
        homePage.scrollToFooter();
        homePage.textIsDisplayed("Subscription");
        homePage.confirmSubscription();
    }
}
