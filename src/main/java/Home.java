import org.openqa.selenium.By;

public class Home {
    Util util = new Util();

    public void pageIsOpened() {
        util.checkCurrentUrl(Main.BASE_URL);
        util.findText("h2","Full-Fledged practice website for Automation Engineers");
        util.findText("p","All QA engineers can use this website for automation practice and " +
                "API testing either they are at beginner or advance level. This is for everybody to help them brush up " +
                "their automation skills.");
    }
}
