package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import pages.AdminPage;

public class AdminTest extends BaseClass {

    @Test(description = "Verify Admin Page header and search functionality")
    public void testAdminSearchUser() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        
        AdminPage adminPage = dashboardPage.clickAdmin();
        Assert.assertEquals(adminPage.getHeaderText(), "Admin", "Admin page header is incorrect");
        
        adminPage.searchUserByUsername("Admin");
        String resultText = adminPage.getRecordsFoundText();
        Assert.assertTrue(resultText.contains("Record Found") || resultText.contains("Records Found"), "No records found for Admin user");
    }

    @Test(description = "Verify navigation to Add User screen")
    public void testNavigateToAddUser() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        
        AdminPage adminPage = dashboardPage.clickAdmin();
        adminPage.clickAddUser();
        
        Assert.assertTrue(driver.getPageSource().contains("Add User"), "Did not navigate to Add User page");
    }
}
