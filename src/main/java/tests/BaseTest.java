package tests;

import common.DriverInitialization;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTest {
    public static WebDriver driver = DriverInitialization.getDriver();

    @BeforeClass
    public void setUp() {
        driver
                .manage()
                .window()
                .setSize(new Dimension(1366, 720));
    }

    @BeforeMethod
    public static void clearCookies() {
        driver
                .manage()
                .deleteAllCookies();
        new HomePage()
                .openHomePage();
    }
}
