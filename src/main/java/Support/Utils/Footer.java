package Support.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Footer extends Util{
    public Footer(WebDriver driver) {
        super(driver);
    }

    private By subscriptionEmailField = By.xpath("//input[@id='susbscribe_email']");
    private By subscribeButton = By.xpath("//button[@id='subscribe']");

    public Footer scrollToFooter() {
        scrollTo(driver.findElement(By.xpath("//footer")));
        return this;
    }

    public Footer confirmSubscription() {
        final String USER_EMAIL = generateRandomValue();

        completeField(subscriptionEmailField, USER_EMAIL + "@mail.com");
        driver
                .findElement(subscribeButton)
                .click();
        textIsDisplayed("You have been successfully subscribed!");
        return this;
    }

}
