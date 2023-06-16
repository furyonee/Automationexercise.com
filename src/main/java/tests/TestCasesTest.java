package tests;

import pages.TestCasesPage;
import org.testng.annotations.Test;

public class TestCasesTest extends BaseTest {
    TestCasesPage testCasesPage = new TestCasesPage();

    @Test
    public void verifyTestCasesPage() {
        testCasesPage.openTestCasesPage();
    }
}
