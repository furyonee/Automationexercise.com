package pages;

import common.constans.EntryPage;
import org.openqa.selenium.By;
import pages.pageElements.Checkbox;
import pages.pageElements.List;
import pages.pageElements.RadioButton;

public class SignUpPage extends BasePage {
    RadioButton radioButton = new RadioButton();
    List list = new List();
    Checkbox checkbox = new Checkbox();

    private final By passwordField = By.cssSelector("[data-qa='password']");
    private final By daysField = By.cssSelector("[data-qa='days']");
    private final By monthsField = By.cssSelector("[data-qa='months']");
    private final By yearsField = By.cssSelector("[data-qa='years']");
    private final By firstNameField = By.cssSelector("[data-qa='first_name']");
    private final By lastNameField = By.cssSelector("[data-qa='last_name']");
    private final By companyField = By.cssSelector("[data-qa='company']");
    private final By addressField = By.cssSelector("[data-qa='address']");
    private final By secondAddressField = By.cssSelector("[data-qa='address2']");
    private final By countryField = By.cssSelector("[data-qa='country']");
    private final By stateField = By.cssSelector("[data-qa='state']");
    private final By cityField = By.cssSelector("[data-qa='city']");
    private final By zipcodeField = By.cssSelector("[data-qa='zipcode']");
    private final By mobileNumberField = By.cssSelector("[data-qa='mobile_number']");
    private final By maleGender = By.id("id_gender1");
    private final By createAccountButton = By.cssSelector("[data-qa='create-account']");
    private final By continueButton = By.cssSelector("[data-qa='continue-button']");

    public SignUpPage completeAccountInfo() {
        radioButton.selectRadioButton(maleGender);
        completeField(passwordField, EntryPage.PASSWORD);
        list
                .clickListOption(daysField)
                .selectElementFromList("31")
                .clickListOption(monthsField)
                .selectElementFromList("1")
                .clickListOption(yearsField)
                .selectElementFromList("1900");
        checkbox
                .selectCheckbox("Sign up for our newsletter!")
                .selectCheckbox("Receive special offers from our partners!");
        return this;
    }

    public SignUpPage completeAddressInfo() {
        completeField(firstNameField, EntryPage.FIRST_NAME);
        completeField(lastNameField, EntryPage.LAST_NAME);
        completeField(companyField, EntryPage.COMPANY);
        completeField(addressField, EntryPage.ADDRESS);
        completeField(secondAddressField, EntryPage.SECOND_ADDRESS);
        list
                .clickListOption(countryField)
                .selectElementFromList("Singapore");
        completeField(stateField, EntryPage.STATE);
        completeField(cityField, EntryPage.CITY);
        completeField(zipcodeField, EntryPage.ZIPCODE);
        completeField(mobileNumberField, EntryPage.MOBILE_PHONE);
        return this;
    }

    public SignUpPage finishAccountCreation() {
        click(createAccountButton);
        assertTextIsDisplayed("Account Created!");
        click(continueButton);
        return this;
    }

    public SignUpPage completeFullSignUpInfo() {
        completeAccountInfo();
        completeAddressInfo();
        click(createAccountButton);
        click(continueButton);
        return this;
    }
}
