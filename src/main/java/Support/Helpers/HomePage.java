package Support.Helpers;

import Support.Constans.Url;
import org.openqa.selenium.WebDriver;

public class HomePage extends Util {
    static WebDriver driver = DriverInitialization.getDriver();

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openHomePage() {
        driver.get(Url.HOME_PAGE);
        pageIsOpened(Url.HOME_PAGE, "Full-Fledged practice website for Automation Engineers");
        return this;
    }
}
