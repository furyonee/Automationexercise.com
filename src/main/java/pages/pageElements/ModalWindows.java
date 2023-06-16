package pages.pageElements;

import org.openqa.selenium.By;
import pages.BasePage;

public class ModalWindows extends BasePage {
    private final By continueShoppingButton = By.xpath("//button[text()='Continue Shopping']");
    private final By viewCartButton = By.xpath("//u[text()='View Cart']");
    private final By registerLoginButton = By.xpath("//u[text()='Register / Login']");

    public ModalWindows clickContinueShoppingButton() {
        click(continueShoppingButton);
        return this;
    }

    public ModalWindows clickViewCartButton() {
        click(viewCartButton);
        return this;
    }

    public ModalWindows clickRegisterLoginButton() {
        click(registerLoginButton);
        return this;
    }
}
