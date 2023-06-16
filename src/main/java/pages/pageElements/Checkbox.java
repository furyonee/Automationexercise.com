package pages.pageElements;

import org.openqa.selenium.By;
import pages.BasePage;

public class Checkbox extends BasePage {
    public Checkbox selectCheckbox(String value) {
        click(By.xpath(String.format("//div[@class='checkbox']/label[text()='%s']", value)));
        return this;
    }
}
