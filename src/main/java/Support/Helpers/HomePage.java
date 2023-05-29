package Support.Helpers;

import Support.Constans.Url;
import org.openqa.selenium.WebDriver;

public class HomePage extends Util{
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get(Url.HOME_PAGE);
        pageIsOpened(Url.HOME_PAGE, "Full-Fledged practice website for Automation Engineers");
    }
}
