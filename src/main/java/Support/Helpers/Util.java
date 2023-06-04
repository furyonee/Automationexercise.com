package Support.Helpers;

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
    private WebDriver driver;

    public Util(WebDriver driver) {
        this.driver = driver;
    }

    public void checkCurrentUrl(String url) {
        Assert.isTrue(driver.getCurrentUrl().equals(url), "URL doesn't match the opened page");
    }

    public void pageIsOpened(String url, String pageTextElement) {
        checkCurrentUrl(url);
        textIsDisplayed(pageTextElement);
    }

    public void textIsDisplayed(String ...text) {
        for (String s : text) {
            WebElement enterAccountInformationText = driver.findElement(By.xpath(String.format(
                    "//*[text()='%s']", s)));
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(enterAccountInformationText));
            Assert.isTrue(enterAccountInformationText.isDisplayed(), String.format("\"%s\" text is not found", text));
        }
    }

    public void textIsNotDisplayed(String text) {
        List<WebElement> elements = driver.findElements(By.xpath(String.format(
                "//*[text()='%s']", text)));
        Assert.isTrue(elements.size() == 0, String.format("\"%s\" text exists. Expected: \"Not\" ", text));
    }

    public void completeField(By field, String value) {
        driver.findElement(field)
                .sendKeys(value);
    }

    public void selectRadioButton(By value) {
        driver.findElement(value)
                .click();
    }

    public void selectValueFromList(By field, String value) {
        driver.findElement(field)
                .click();
        driver.findElement(By.xpath(String.format("//option[@value='%s']", value)))
                .click();
    }

    public void selectCheckbox(String value) {
        driver.findElement(By.xpath(String.format("//div[@class='checkbox']/label[text()='%s']", value)))
                .click();
    }

    public void clickButton(String button, String text) {
        driver.findElement(By.xpath(String.format("//*[@data-qa='%s'][text()='%s']", button, text)))
                .click();
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

    public void confirmAlert() {
        driver.switchTo()
                .alert()
                .accept();
    }

    public WebElement waitForElement(By element) {
        return new WebDriverWait(driver,
                Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void scrollTo(WebElement element) {
        new Actions(driver)
                .scrollToElement(element)
                .perform();
    }
}
