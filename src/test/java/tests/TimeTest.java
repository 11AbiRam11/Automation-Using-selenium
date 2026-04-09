package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import pages.TimePage;

public class TimeTest extends BaseClass {

    @Test(description = "Verify Time Page header")
    public void testTimePage() {
        LoginPage loginPage = new LoginPage(driver);

        // 1. Professional Login returns the next logical page
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");

        // 2. Navigation is handled centrally from any BasePage child
        TimePage timePage = dashboardPage.goToTime();

        // 3. Precise assertion with trimmed header check
        Assert.assertEquals(timePage.getHeaderText(), "Time", "Failed to navigate to Time page or header mismatch");
    }
}
