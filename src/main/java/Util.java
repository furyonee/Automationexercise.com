import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;

public class Util {
    public void openBasePage(String url) {
        Main.driver.get(url);
    }

    public void navItemIsChosen(String menuItem) {
        Main.driver.findElement(By.xpath(String.format(
                "//ul[@class='nav navbar-nav']/li/a[text()=' %s'][contains(@style, 'color: orange')]", menuItem
        )));
    }

    public void checkCurrentUrl(String url) {
        Assert.isTrue(
                Main.driver.getCurrentUrl().equals(url),
                "Current URL doesn't match the opened page"
        );
    }

    public void generateRandomValue() {
        // To Do
    }

    public void findText(String attribute, String text) {
        Main.driver.findElement(By.xpath(String.format(
                "//%s[text()='%s']", attribute, text
        ))).isDisplayed();
    }
}
