package pages.pageElements;

import org.openqa.selenium.By;
import pages.BasePage;

public class RadioButton extends BasePage {
    public RadioButton selectRadioButton(By value) {
        click(value);
        return this;
    }
}
