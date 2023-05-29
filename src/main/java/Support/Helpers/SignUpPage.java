package Support.Helpers;

import Support.Constans.EntryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends Util{
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By passwordField = By.xpath("//*[@data-qa='password']");
    private final By daysField = By.xpath("//select[@data-qa='days']");
    private final By monthsField = By.xpath("//select[@data-qa='months']");
    private final By yearsField = By.xpath("//select[@data-qa='years']");
    private final By firstNameField = By.xpath("//*[@data-qa='first_name']");
    private final By lastNameField = By.xpath("//*[@data-qa='last_name']");
    private final By companyField = By.xpath("//*[@data-qa='company']");
    private final By addressField = By.xpath("//*[@data-qa='address']");
    private final By secondAddressField = By.xpath("//*[@data-qa='address2']");
    private final By countryField = By.xpath("//select[@data-qa='country']");
    private final By stateField = By.xpath("//*[@data-qa='state']");
    private final By cityField = By.xpath("//*[@data-qa='city']");
    private final By zipcodeField = By.xpath("//*[@data-qa='zipcode']");
    private final By mobileNumberField = By.xpath("//*[@data-qa='mobile_number']");
    private final By maleGender = By.xpath("//*[@type='radio'][@id='id_gender1']");

    public void completeAccountInfo() {
        selectRadioButton(maleGender);
        completeField(passwordField, EntryPage.PASSWORD);
        selectValueFromList(daysField, "31");
        selectValueFromList(monthsField, "1");
        selectValueFromList(yearsField, "1900");
        selectCheckbox("Sign up for our newsletter!");
        selectCheckbox("Receive special offers from our partners!");
    }

    public void completeAddressInfo() {
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

    public void finishAccountCreation() {
        clickButton("create-account", "Create Account");
        textIsDisplayed("Account Created!");
        clickButton("continue-button", "Continue");
    }

    public void completeUserInfo() {
        completeAccountInfo();
        completeAddressInfo();
        clickButton("create-account", "Create Account");
        clickButton("continue-button", "Continue");
    }
}
