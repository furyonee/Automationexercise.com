package Support.Helpers;

import Support.Constans.ContactUsValues;
import Support.Constans.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ContactUsPage extends Util {
    static WebDriver driver = DriverInitialization.getDriver();

    NavBar navBar = new NavBar(driver);

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    private By nameField = By.xpath("//div[@id='form-section']//input[@data-qa='name']");
    private By emailField = By.xpath("//div[@id='form-section']//input[@data-qa='email']");
    private By subjectField = By.xpath("//div[@id='form-section']//input[@data-qa='subject']");
    private By messageArea = By.xpath("//div[@id='form-section']//textarea[@data-qa='message']");
    private By fileInput = By.xpath("//input[@type='file']");
    private By submitButton = By.xpath("//input[@data-qa='submit-button']");
    private By homeButton = By.xpath("//a[@class='btn btn-success']");

    public ContactUsPage openContactUsPage() {
        driver
                .findElement(navBar.getContactUsItem())
                .click();
        textIsDisplayed("Get In Touch");
        return this;
    }

    public ContactUsPage completeContactUsForm() {
        completeField(nameField, ContactUsValues.NAME);
        completeField(emailField, ContactUsValues.EMAIL);
        completeField(subjectField, ContactUsValues.SUBJECT);
        completeField(messageArea, ContactUsValues.MESSAGE);
        return this;
    }

    public ContactUsPage uploadFile() {
        File file = new File("src/main/java/Support/Media/chad.jpg");
        try {
            driver
                    .findElement(fileInput)
                    .sendKeys(file.getAbsolutePath());
        } catch (InvalidArgumentException e) {
            System.err.println("It's weird there's no any other way to check if something goes wrong here. So it is.");
        }
        return this;
    }

    public ContactUsPage submitForm() {
        driver
                .findElement(submitButton)
                .click();
        return this;
    }

    public void clickHomeButton() {
        waitForElement(homeButton)
                .click();
        pageIsOpened(Url.HOME_PAGE,
                "All QA engineers can use this website for automation practice and API testing either " +
                        "they are at beginner or advance level. This is for everybody to help them brush up their " +
                        "automation skills.");
    }
}
