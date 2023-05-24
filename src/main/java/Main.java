import com.beust.ah.A;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    static WebDriver driver = new ChromeDriver();

    static final String BASE_URL = "https://automationexercise.com/";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");

        Util util = new Util();
        Home home = new Home();
        Authorization authorization = new Authorization();

        driver.manage()
                .window()
                .setSize(new Dimension(1366, 720));

        util.openBasePage(BASE_URL);
        util.navItemIsChosen("Home");
        home.pageIsOpened();
        authorization.openAuthenticationPage();
        authorization.signUpUser();

//        driver.quit();

    }
}
