package Support.Utils;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Util {
    static WebDriver driver = DriverInitialization.getDriver();

    public Util(WebDriver driver) {
        Util.driver = driver;
    }

    public Util checkCurrentUrl(String url) {
        Assert.isTrue(driver.getCurrentUrl().equals(url), "URL doesn't match the opened page");
        return this;
    }

    public Util pageIsOpened(String url, String pageTextElement) {
        checkCurrentUrl(url);
        textIsDisplayed(pageTextElement);
        return this;
    }

    public Util textIsDisplayed(String... text) {
        for (String s : text) {
            WebElement enterAccountInformationText = driver.findElement(By.xpath(String.format(
                    "//*[text()='%s']", s)));
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(enterAccountInformationText));
            Assert.isTrue(enterAccountInformationText.isDisplayed(), String.format("\"%s\" text is not found", text));
        }
        return this;
    }

    public Util textIsNotDisplayed(String text) {
        List<WebElement> elements = driver.findElements(By.xpath(String.format(
                "//*[text()='%s']", text)));
        Assert.isTrue(elements.size() == 0, String.format("\"%s\" text exists. Expected: \"Not\" ", text));
        return this;
    }

    public Util containsText(String text) {
        driver.findElement(By.xpath(String.format("//div[contains(text(), '%s')]", text)))
                .isDisplayed();
        return this;
    }


    public Util completeField(By field, String value) {
        driver
                .findElement(field)
                .sendKeys(value);
        return this;
    }

    public Util selectRadioButton(By value) {
        driver
                .findElement(value)
                .click();
        return this;
    }

    public Util selectValueFromList(By field, String value) {
        driver
                .findElement(field)
                .click();
        driver
                .findElement(By.xpath(String.format("//option[@value='%s']", value)))
                .click();
        return this;
    }

    public Util selectCheckbox(String value) {
        driver
                .findElement(By.xpath(String.format("//div[@class='checkbox']/label[text()='%s']", value)))
                .click();
        return this;
    }

    public Util clickButton(String text) {
        waitForElement(By.xpath(String.format("//button[text()='%s']", text)))
                .click();
        return this;
    }

    public String generateRandomValue() {
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

    public Util confirmAlert() {
        driver
                .switchTo()
                .alert()
                .accept();
        return this;
    }

    public WebElement waitForElement(By element) {
        return new WebDriverWait(driver,
                Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public Util scrollTo(WebElement element) {
        new Actions(driver)
                .scrollToElement(element)
                .perform();
        return this;
    }

    public Util clickContinueButton() {
        driver.findElement(By.xpath("//a[@data-qa='continue-button'][text()='Continue']"))
                .click();
        return this;
    }

    public Util addToCardFromList(int orderNumber) {
        driver
                .findElement(By.xpath(String.format("//a[@data-product-id='%d']", orderNumber)))
                .click();
        return this;
    }


}
