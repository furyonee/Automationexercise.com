package pages;

import org.openqa.selenium.By;

public class DeleteAccountPage extends BasePage {
    private final By continueButton = By.cssSelector("[data-qa='continue-button']");

    public DeleteAccountPage assertAccountIsDeleted() {
        assertTextIsDisplayed("Account Deleted!");
        click(continueButton);
        assertTextIsNotDisplayed(" Logged in as ");
        return this;
    }
}
