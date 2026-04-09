package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;

public class DashboardTest extends BaseClass {

    @Test(description = "Verify Dashboard Page header and widgets")
    public void testDashboardOverview() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");

        Assert.assertEquals(dashboardPage.getHeaderText(), "Dashboard", "Dashboard header mismatch");
        
        // Check for at least one side menu
        Assert.assertTrue(dashboardPage.getSideMenuCount() > 0, "No side menu items found");
    }

    @Test(description = "Verify accessibility of all modules from Dashboard")
    public void testAllModulesAccessibility() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");

        // Verify some major modules are accessible
        Assert.assertNotNull(dashboardPage.clickAdmin());
        dashboardPage.clickDashboard();
        
        Assert.assertNotNull(dashboardPage.clickPIM());
        dashboardPage.clickDashboard();
        
        Assert.assertNotNull(dashboardPage.clickLeave());
        dashboardPage.clickDashboard();
    }
}
