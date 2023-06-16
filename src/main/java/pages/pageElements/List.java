package pages.pageElements;

import org.openqa.selenium.By;
import pages.BasePage;

public class List extends BasePage {
    private final String listElement = "//option[@value='%s']";

    public List clickListOption(By field) {
        click(field);
        return this;
    }

    public List selectElementFromList(String value) {
        click(By.xpath(String.format(listElement, value)));
        return this;
    }
}
