package pages;

import common.constans.PaymentInfo;
import org.openqa.selenium.By;

public class PaymentPage extends BasePage {
    private final By payAndConfirmOrderButton = By.cssSelector("[data-qa='pay-button']");
    private final By nameOnCard = By.cssSelector("[data-qa='name-on-card']");
    private final By cardNumber = By.cssSelector("[data-qa='card-number']");
    private final By cvc = By.cssSelector("[data-qa='cvc']");
    private final By expiryMonth = By.cssSelector("[data-qa='expiry-month']");
    private final By expiryYear = By.cssSelector("[data-qa='expiry-year']");

    public PaymentPage fillPaymentDetails() {
        completeField(nameOnCard, PaymentInfo.NAME_ON_CARD);
        completeField(cardNumber, PaymentInfo.CARD_NUMBER);
        completeField(cvc, PaymentInfo.CVC);
        completeField(expiryMonth, PaymentInfo.EXPIRATION_MONTH);
        completeField(expiryYear, PaymentInfo.EXPIRATION_YEAR);
        return this;
    }

    public PaymentPage clickPayAndConfirmOrderButton() {
        click(payAndConfirmOrderButton);
        return this;
    }
}
