package Support.Helpers;

import Support.Constans.ContactUsValues;
import Support.Constans.Url;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class ContactUsPage extends Util {
    private WebDriver driver;

    NavBar navBar = new NavBar(driver);

    public ContactUsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By nameField = By.xpath("//div[@id='form-section']//input[@data-qa='name']");
    private final By emailField = By.xpath("//div[@id='form-section']//input[@data-qa='email']");
    private final By subjectField = By.xpath("//div[@id='form-section']//input[@data-qa='subject']");
    private final By messageArea = By.xpath("//div[@id='form-section']//textarea[@data-qa='message']");
    private final By fileInput = By.xpath("//input[@type='file']");
    private final By submitButton = By.xpath("//input[@data-qa='submit-button']");
    private final By homeButton = By.xpath("//a[@class='btn btn-success']");

    public void openContactUsPage() {
        driver.findElement(navBar.getContactUsItem())
                .click();
        textIsDisplayed("Get In Touch");
    }

    public void completeContactUsForm() {
        completeField(nameField, ContactUsValues.NAME);
        completeField(emailField, ContactUsValues.EMAIL);
        completeField(subjectField, ContactUsValues.SUBJECT);
        completeField(messageArea, ContactUsValues.MESSAGE);
    }

    public void uploadFile() {
        File file = new File("src/main/java/Support/Media/chad.jpg");
        try {
            driver.findElement(fileInput)
                    .sendKeys(file.getAbsolutePath());
        } catch (InvalidArgumentException e) {
            System.err.println("It's weird there's no any other way to check if something goes wrong here. So it is.");
        }
    }

    public void submitForm() {
        driver.findElement(submitButton)
                .click();
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
