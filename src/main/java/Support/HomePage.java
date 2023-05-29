package Support;

import Support.Constans.Url;
import org.openqa.selenium.WebDriver;

public class HomePage extends Util{
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get(Url.BASE_URL);
        pageIsOpened(Url.BASE_URL, "Full-Fledged practice website for Automation Engineers");
    }
}
