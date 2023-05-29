package Tests;

import Support.Constans.Url;
import Support.Helpers.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ContactUs {
    static WebDriver driver = DriverInitialization.getDriver();

    HomePage homePage = new HomePage(driver);
    ContactUsPage contactUsPage = new ContactUsPage(driver);
    NavBar navBar = new NavBar(driver);
    Util util = new Util(driver);

    @Test
    public void completeContactUsForm() {
        homePage.openHomePage();
        navBar.clickContactUsItem();
        util.textIsDisplayed("Get In Touch");
        contactUsPage.completeContactUsForm();
        contactUsPage.uploadFile();
        contactUsPage.submitForm();
        util.confirmAlert();
        util.textIsDisplayed("Success! Your details have been submitted successfully.");
        contactUsPage.clickHomeButton();
        util.pageIsOpened(Url.HOME_PAGE,
                "All QA engineers can use this website for automation practice and API testing either " +
                        "they are at beginner or advance level. This is for everybody to help them brush up their " +
                        "automation skills.");
    }
}
