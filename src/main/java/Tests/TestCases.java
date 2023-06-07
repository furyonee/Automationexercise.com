package Tests;

import Support.Constans.Url;
import Support.Utils.*;
import Support.Pages.HomePage;
import Support.Pages.TestCasesPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases {
    static WebDriver driver = DriverInitialization.getDriver();

    HomePage homePage = new HomePage(driver);
    TestCasesPage testCasesPage = new TestCasesPage(driver);

    @BeforeMethod
    public static void clearCookies() {
        driver
                .manage()
                .deleteAllCookies();
    }

    @Test
    public void verifyTestCasesPage() {
        homePage.openHomePage();
        testCasesPage
                .openTestCasesPage()
                .pageIsOpened(Url.TEST_CASES_PAGE, "Below is the list of test Cases for you to practice the Automation. " +
                        "Click on the scenario for detailed Test Steps:");
    }
}
