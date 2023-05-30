package Support.Helpers;

import org.openqa.selenium.WebDriver;

public class TestCasesPage extends Util{
    private WebDriver driver;

    NavBar navBar = new NavBar(driver);

    public TestCasesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openTestCasesPage() {
        driver.findElement(navBar.getTestCasesItem())
                .click();
        textIsDisplayed("Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:");
    }
}
