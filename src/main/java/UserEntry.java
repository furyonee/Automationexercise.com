import Constans.EntryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserEntry extends Util {
    private WebDriver driver;

    private By signUpNameField = By.xpath("//*[@data-qa='signup-name']");
    private By signUpEmailField = By.xpath("//*[@data-qa='signup-email']");
    private By passwordField = By.xpath("//*[@data-qa='password']");
    private By daysField = By.xpath("//select[@data-qa='days']");
    private By monthsField = By.xpath("//select[@data-qa='months']");
    private By yearsField = By.xpath("//select[@data-qa='years']");
    private By firstNameField = By.xpath("//*[@data-qa='first_name']");
    private By lastNameField = By.xpath("//*[@data-qa='last_name']");
    private By companyField = By.xpath("//*[@data-qa='company']");
    private By addressField = By.xpath("//*[@data-qa='address']");
    private By secondAddressField = By.xpath("//*[@data-qa='address2']");
    private By countryField = By.xpath("//select[@data-qa='country']");
    private By stateField = By.xpath("//*[@data-qa='state']");
    private By cityField = By.xpath("//*[@data-qa='city']");
    private By zipcodeField = By.xpath("//*[@data-qa='zipcode']");
    private By mobileNumberField = By.xpath("//*[@data-qa='mobile_number']");
    private By maleGender = By.xpath("//*[@type='radio'][@id='id_gender1']");

    WebDriverWait wait = new WebDriverWait(Main.driver, Duration.ofSeconds(10));

    public UserEntry(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    void openEntryPage() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[@class='nav navbar-nav']/li/a[text()=' Signup / Login']")))
                .click();
    }

    void clickSignUpButton() {
        driver.findElement(By.xpath("//button[@data-qa='signup-button'][text()='Signup']"))
                .click();
    }

    void completeUserCredentials() {
        completeField(signUpNameField, generateRandomValue());
        completeField(signUpEmailField, EntryPage.USER_EMAIL);
    }

    void completeAccountInfo() {
        selectRadioButton(maleGender);
        completeField(passwordField, EntryPage.PASSWORD);
        selectValueFromList(daysField, "31");
        selectValueFromList(monthsField, "1");
        selectValueFromList(yearsField, "1900");
        selectCheckbox("Sign up for our newsletter!");
        selectCheckbox("Receive special offers from our partners!");
    }

    void completeAddressInfo() {
        completeField(firstNameField, EntryPage.FIRST_NAME);
        completeField(lastNameField, EntryPage.LAST_NAME);
        completeField(companyField, EntryPage.COMPANY);
        completeField(addressField, EntryPage.ADDRESS);
        completeField(secondAddressField, EntryPage.SECOND_ADDRESS);
        selectValueFromList(countryField, "Singapore");
        completeField(stateField, EntryPage.STATE);
        completeField(cityField, EntryPage.CITY);
        completeField(zipcodeField, EntryPage.ZIPCODE);
        completeField(mobileNumberField, EntryPage.MOBILE_PHONE);
    }

    void clickDeleteAccountButton() {
        driver.findElement(By.xpath("//li/a[text()=' Delete Account']"))
                .click();
    }
}