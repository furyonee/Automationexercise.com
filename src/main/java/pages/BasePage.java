package pages;

import common.DriverInitialization;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected static WebDriver driver = DriverInitialization.getDriver();

    public BasePage completeField(By field, String value) {
        driver.findElement(field).sendKeys(value);
        return this;
    }

    public BasePage assertProperPageIsOpened(String url, String pageTextElement) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
        assertTextIsDisplayed(pageTextElement);
        return this;
    }

    public BasePage assertTextIsDisplayed(String... text) {
        for (String s : text) {
            WebElement enterAccountInformationText = driver.findElement(By.xpath(String.format(
                    "//*[text()='%s']", s)));
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(enterAccountInformationText));
            Assert.assertTrue(enterAccountInformationText.isDisplayed());
        }
        return this;
    }

    public BasePage assertTextIsNotDisplayed(String text) {
        List<WebElement> elements = driver.findElements(By.xpath(String.format(
                "//*[text()='%s']", text)));
        Assert.assertEquals(elements.size(), 0);
        return this;
    }

    public BasePage assertTextPartiallyExist(String text) {
        driver
                .findElement(By.xpath(String.format("//div[contains(text(), '%s')]", text)))
                .isDisplayed();
        return this;
    }

    public WebElement waitForElement(By element) {
        return new WebDriverWait(driver,
                Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public BasePage confirmAlert() {
        driver
                .switchTo()
                .alert()
                .accept();
        return this;
    }

    public BasePage click(By element) {
        waitForElement(element).click();
        return this;
    }
}
