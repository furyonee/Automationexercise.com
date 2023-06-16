package pages;

import pages.pageElements.NavBar;

public class TestCasesPage extends BasePage {
    NavBar navBar = new NavBar();

    public TestCasesPage openTestCasesPage() {
        navBar.clickTestCasesItem();
        return this;
    }
}
