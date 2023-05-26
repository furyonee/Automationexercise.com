import Constans.Url;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random;

public class Util {
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(Main.driver, Duration.ofSeconds(5));

    public Util(WebDriver driver) {
        this.driver = driver;
    }

    void openBasePage(String url) {
        driver.get(url);
        pageIsOpened(Url.BASE_URL, "Full-Fledged practice website for Automation Engineers");
    }

    void navItemIsChosen(String menuItem) {
        driver.findElement(By.xpath(String.format(
                "//ul[@class='nav navbar-nav']/li/a[text()=' %s'][contains(@style, 'color: orange')]", menuItem
        )));
    }

    void checkCurrentUrl(String url) {
        Assert.isTrue(driver.getCurrentUrl().equals(url), "Current URL doesn't match the opened page");
    }

    void pageIsOpened(String url, String pageTextElement) {
        checkCurrentUrl(url);
        textIsDisplayed(pageTextElement);
        textIsDisplayed("Full-Fledged practice website for Automation Engineers");
    }

    void textIsDisplayed(String text) {
        WebElement enterAccountInformationText = driver.findElement(By.xpath(String.format(
                "//*[text()='%s']", text)));
        wait.until(ExpectedConditions.visibilityOf(enterAccountInformationText));
        Assert.isTrue(enterAccountInformationText.isDisplayed(), String.format("\"%s\" text is not found", text));
    }

    void completeField(By field, String value) {
        driver.findElement(field)
                .sendKeys(value);
    }

    void selectRadioButton(By value) {
        driver.findElement(value)
                .click();
    }

    void selectValueFromList(By field, String value) {
        driver.findElement(field)
                .click();
        driver.findElement(By.xpath(String.format("//option[@value='%s']", value)))
                .click();
    }

    void selectCheckbox(String value) {
        driver.findElement(By.xpath(String.format("//div[@class='checkbox']/label[text()='%s']", value)))
                .click();
    }

    void clickButton(String button, String text) {
        driver.findElement(By.xpath(String.format("//*[@data-qa='%s'][text()='%s']", button, text)))
                .click();
    }

    void clickNavElement(String el) {
        driver.findElement(By.xpath(String.format("//li/a[text()='%s']", el)))
                .click();
    }

    String generateRandomValue() {
        String dict = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int length = 8;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(dict.length());
            char randomChar = dict.charAt(index);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }
}
