package Support.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends Util{
    public Header(WebDriver driver) {
        super(driver);
    }

    public Header scrollToHeader() {
        scrollTo(driver.findElement(By.xpath("//header")));
        return this;
    }
}
