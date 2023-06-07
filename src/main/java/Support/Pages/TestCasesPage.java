package Support.Pages;

import Support.Utils.DriverInitialization;
import Support.Utils.NavBar;
import Support.Utils.Util;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends Util {
    static WebDriver driver = DriverInitialization.getDriver();

    NavBar navBar = new NavBar(driver);

    public TestCasesPage(WebDriver driver) {
        super(driver);
        DriverInitialization.getDriver();
    }

    public TestCasesPage openTestCasesPage() {
        driver
                .findElement(navBar.getTestCasesItem())
                .click();
        textIsDisplayed("Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:");
        return this;
    }
}
