import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// text
public class Authorization {
    Util util = new Util();

    // Найти синоним
    public void openAuthenticationPage() {
        Main.driver.findElement(By.xpath(
                        "//ul[@class='nav navbar-nav']/li/a[text()=' Signup / Login']"
                ))
                .click();
        util.navItemIsChosen("Signup / Login");
    }

    public void signUpUser() {
        Main.driver.findElement(By.xpath("//input[@data-qa='signup-name']"))
                .sendKeys("Name");
        Main.driver.findElement(By.xpath("//input[@data-qa='signup-email']"))
                .sendKeys("email@gmail.com");
        Main.driver.findElement(By.xpath("//button[@data-qa='signup-button']"))
                .click();
        util.findText("b", "Enter Account Information");
        selectGender();
        enterName();
        emailFieldIsDisable();
        enterPassword();
        enterBirthdate();
        subscribeNewsletters();
    }

    private void selectGender() {
        int randomValue = (int) (Math.random() * 2 + 1);
        String randomGender = String.format("//label[@for='id_gender%d']/div[@class='radio']", randomValue);
        System.out.println("Random: " + randomValue);
        Main.driver.findElement(By.xpath(randomGender))
                .click();
    }

    // random + @value='Name' поменять
    private void enterName() {
        Main.driver.findElement(By.xpath("//input[@data-qa='name'][@value='Name']"))
                .sendKeys(" + value");
    }

    private void emailFieldIsDisable() {
        Main.driver.findElement(By.xpath("//input[@data-qa='email'][@disabled='disabled'][@value='email@gmail.com']"));
    }

    // random
    private void enterPassword() {
        Main.driver.findElement(By.xpath("//input[@data-qa='password']"))
                .sendKeys("12345678");
        Main.driver.findElement(By.xpath("//input[@data-qa='password'][@value='']"));
    }

    private void enterBirthdate() {
        Main.driver.findElement(By.xpath("//select[@data-qa='days']"))
                .click();
        Main.driver.findElement(By.xpath("//option[@value='31']"))
                .click();

        Main.driver.findElement(By.xpath("//select[@data-qa='months']"))
                .click();
        Main.driver.findElement(By.xpath("//option[@value='1']"))
                .click();

        Main.driver.findElement(By.xpath("//select[@data-qa='years']"))
                .click();
        Main.driver.findElement(By.xpath("//option[@value='1900']"))
                .click();
    }

    private void subscribeNewsletters() {
        Main.driver.findElement(By.xpath("//div[@class='checkbox']/label[@for='newsletter'][text()='Sign up for our newsletter!']"))
                .click();
    }
}
