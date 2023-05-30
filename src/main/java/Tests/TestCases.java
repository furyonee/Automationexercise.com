package Tests;

import Support.Constans.Url;
import Support.Helpers.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestCases {
    static WebDriver driver = DriverInitialization.getDriver();

    HomePage homePage = new HomePage(driver);
    NavBar navBar = new NavBar(driver);
    Util util = new Util(driver);

    @Test
    public void verifyTestCasesPage() {
        homePage.openHomePage();
        navBar.clickTestCasesItem();
        util.pageIsOpened(Url.TEST_CASES_PAGE, "Below is the list of test Cases for you to practice the Automation. " +
                "Click on the scenario for detailed Test Steps:");
    }
}
