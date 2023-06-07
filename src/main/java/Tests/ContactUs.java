package Tests;

import Support.Utils.*;
import Support.Pages.ContactUsPage;
import Support.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class ContactUs {
    static WebDriver driver = DriverInitialization.getDriver();

    HomePage homePage = new HomePage(driver);
    ContactUsPage contactUsPage = new ContactUsPage(driver);

    @BeforeMethod
    public static void clearCookies() {
        driver
                .manage()
                .deleteAllCookies();
    }

    @Test
    public void completeContactUsForm() {
        homePage.openHomePage();
        contactUsPage
                .openContactUsPage()
                .textIsDisplayed("Get In Touch");
        contactUsPage
                .completeContactUsForm()
                .uploadFile()
                .submitForm()
                .confirmAlert()
                .textIsDisplayed("Success! Your details have been submitted successfully.");
        contactUsPage.clickHomeButton();
    }
}
