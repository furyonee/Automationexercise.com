package Tests;

import Support.Helpers.DriverInitialization;
import Support.Helpers.Footer;
import Support.Helpers.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class Home {
    static WebDriver driver = DriverInitialization.getDriver();

    HomePage homePage = new HomePage(driver);
    Footer footer = new Footer(driver);

    @Test
    public void verifySubscriptionBlock() {
        homePage.openHomePage();
        footer.scrollToFooter()
                .textIsDisplayed("Subscription");
        footer.confirmSubscription();
    }
}
