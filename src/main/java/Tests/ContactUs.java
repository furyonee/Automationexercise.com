package Tests;

import Support.Helpers.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class ContactUs {
    static WebDriver driver = DriverInitialization.getDriver();

    HomePage homePage = new HomePage(driver);
    Util util = new Util(driver);
    ContactUsPage contactUsPage = new ContactUsPage(driver);

    @Test
    public void completeContactUsForm() {
        homePage.openHomePage();
        contactUsPage.openContactUsPage();
        util.textIsDisplayed("Get In Touch");
        contactUsPage.completeContactUsForm();
        contactUsPage.uploadFile();
        contactUsPage.submitForm();
        util.confirmAlert();
        util.textIsDisplayed("Success! Your details have been submitted successfully.");
        contactUsPage.clickHomeButton();
    }
}
