package Support.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer extends Util{
    public Footer(WebDriver driver) {
        super(driver);
    }

    private final By SUBSCRIPTION_EMAIL_FIELD = By.xpath("//input[@id='susbscribe_email']");
    private final By SUBSCRIBE_BUTTON = By.xpath("//button[@id='subscribe']");

    public Footer scrollToFooter() {
        WebElement footer = driver.findElement(By.xpath("//footer"));

        scrollTo(footer);
        return this;
    }

    public Footer confirmSubscription() {
        final String USER_EMAIL = generateRandomValue();

        completeField(SUBSCRIPTION_EMAIL_FIELD, USER_EMAIL + "@mail.com");
        driver.findElement(SUBSCRIBE_BUTTON)
                .click();
        textIsDisplayed("You have been successfully subscribed!");
        return this;
    }

}
