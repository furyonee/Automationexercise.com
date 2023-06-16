package tests;

import common.constans.Url;
import pages.ContactUsPage;
import org.testng.annotations.*;
import pages.pageElements.NavBar;

public class ContactUsTest extends BaseTest {
    ContactUsPage contactUsPage = new ContactUsPage();
    NavBar navBar = new NavBar();

    @Test
    public void completeContactUsForm() {
        navBar
                .clickContactUsItem()
                .assertTextIsDisplayed("Get In Touch");
        contactUsPage
                .completeContactUsForm()
                .uploadFile()
                .submitForm()
                .confirmAlert()
                .assertTextIsDisplayed("Success! Your details have been submitted successfully.");
        contactUsPage
                .clickHomeButton()
                .assertProperPageIsOpened(Url.HOME_PAGE,
                        "All QA engineers can use this website for automation practice and API testing either " +
                                "they are at beginner or advance level. This is for everybody to help them brush up their " +
                                "automation skills.");
    }
}
