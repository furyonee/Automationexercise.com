package Support.Pages;

import Support.Constans.EntryPage;
import Support.Utils.DriverInitialization;
import Support.Utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends Util {
    public SignUpPage(WebDriver driver) {
        super(driver);
        DriverInitialization.getDriver();
    }

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
    private By continueButton = By.xpath("//a[@data-qa='continue-button'][text()='Continue']");

    public SignUpPage completeAccountInfo() {
        selectRadioButton(maleGender);
        completeField(passwordField, EntryPage.PASSWORD);
        selectValueFromList(daysField, "31");
        selectValueFromList(monthsField, "1");
        selectValueFromList(yearsField, "1900");
        selectCheckbox("Sign up for our newsletter!");
        selectCheckbox("Receive special offers from our partners!");
        return this;
    }

    public SignUpPage completeAddressInfo() {
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
        return this;
    }

    public SignUpPage finishAccountCreation() {
        clickButton("Create Account");
        textIsDisplayed("Account Created!");
        clickContinueButton();
        return this;
    }

    public SignUpPage completeUserInfo() {
        completeAccountInfo();
        completeAddressInfo();
        clickButton("Create Account");
        clickContinueButton();
        return this;
    }
}
