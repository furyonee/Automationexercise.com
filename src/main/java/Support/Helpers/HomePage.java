package Support.Helpers;

import Support.Constans.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Util {
    private WebDriver driver;

    private final By SUBSCRIPTION_EMAIL_FIELD = By.xpath("//input[@id='susbscribe_email']");
    private final By SUBSCRIBE_BUTTON = By.xpath("//button[@id='subscribe']");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get(Url.HOME_PAGE);
        pageIsOpened(Url.HOME_PAGE, "Full-Fledged practice website for Automation Engineers");
    }

    public void scrollToFooter() {
        WebElement footer = driver.findElement(By.xpath("//footer"));

        scrollTo(footer);
    }

    public void confirmSubscription() {
        final String USER_EMAIL = generateRandomValue();

        completeField(SUBSCRIPTION_EMAIL_FIELD, USER_EMAIL + "@mail.com");
        driver.findElement(SUBSCRIBE_BUTTON)
                .click();
        textIsDisplayed("You have been successfully subscribed!");
    }
}
