package tests;

import org.testng.annotations.AfterTest;
import pages.pageElements.Footer;
import org.testng.annotations.Test;
import pages.pageElements.NavBar;

public class HomeTest extends BaseTest {
    Footer footer = new Footer();
    NavBar navBar = new NavBar();

    @AfterTest
    public void setUp() {
        navBar.scrollToNavBar();
    }

    @Test
    public void verifySubscriptionBlock() {
        footer.assertTextIsDisplayed("Subscription");
        footer
                .completeSubscriptionField()
                .clickSubscribeButton()
                // For unknown reasons there are troubles returning from the footer
                .assertTextIsDisplayed("You have been successfully subscribed!");
    }
}
