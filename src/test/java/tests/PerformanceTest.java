package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import pages.PerformancePage;

public class PerformanceTest extends BaseClass {

    @Test(description = "Verify Performance Page header")
    public void testPerformancePage() {
        LoginPage loginPage = new LoginPage(driver);
        
        // 1. Professional Login returns the next logical page
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        
        // 2. Navigation is handled centrally from any BasePage child
        PerformancePage performancePage = dashboardPage.goToPerformance();
        
        // 3. Precise assertion with trimmed header check
        Assert.assertEquals(performancePage.getHeaderText(), "Performance", "Failed to navigate to Performance page or header mismatch");
    }
}
