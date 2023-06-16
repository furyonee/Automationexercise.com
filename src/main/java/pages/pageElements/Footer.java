package pages.pageElements;

import common.Support;
import org.openqa.selenium.By;
import pages.BasePage;


public class Footer extends BasePage {
    Support support = new Support();

    private final By subscriptionEmailField = By.id("susbscribe_email");
    private final By subscribeButton = By.id("subscribe");

    public Footer completeSubscriptionField() {
        final String userEmail = support.generateRandomValue();
        completeField(subscriptionEmailField, userEmail + "@mail.com");
        return this;
    }

    public Footer clickSubscribeButton() {
        click(subscribeButton);
        return this;
    }
}
