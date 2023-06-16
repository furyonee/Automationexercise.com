package pages;

import common.constans.ContactUsValues;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.testng.Assert;

import java.io.File;

public class ContactUsPage extends BasePage {
    private final By nameField = By.cssSelector("[data-qa='name']");
    private final By emailField = By.cssSelector("[data-qa='email']");
    private final By subjectField = By.cssSelector("[data-qa='subject']");
    private final By messageArea = By.cssSelector("[data-qa='message']");
    private final By fileInput = By.cssSelector("[type='file']");
    private final By submitButton = By.cssSelector("[data-qa='submit-button']");
    private final By homeButton = By.className("btn-success");

    public ContactUsPage completeContactUsForm() {
        completeField(nameField, ContactUsValues.NAME);
        completeField(emailField, ContactUsValues.EMAIL);
        completeField(subjectField, ContactUsValues.SUBJECT);
        completeField(messageArea, ContactUsValues.MESSAGE);
        return this;
    }

    public ContactUsPage uploadFile() {
        File file = new File("src/main/resources/chad.jpg");
        try {
            driver
                    .findElement(fileInput)
                    .sendKeys(file.getAbsolutePath());
        } catch (InvalidArgumentException e) {
            Assert.fail("It's weird there's no any other way to check if something goes wrong here. So it is.");
        }
        return this;
    }

    public ContactUsPage submitForm() {
        click(submitButton);
        return this;
    }

    public ContactUsPage clickHomeButton() {
        click(homeButton);
        return this;
    }
}
