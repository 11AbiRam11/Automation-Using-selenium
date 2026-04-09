package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import pages.PIMPage;

public class PIMTest extends BaseClass {

    @Test(description = "Verify PIM module navigation and employee search")
    public void testPIMSearch() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        
        PIMPage pimPage = dashboardPage.clickPIM();
        Assert.assertEquals(pimPage.getHeaderText(), "PIM", "PIM page header is incorrect");
        
        pimPage.searchEmployeeByName("Admin"); // Use a name that likely exists or generic search
    }

    @Test(description = "Verify adding a new employee in PIM")
    public void testAddNewEmployee() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        
        PIMPage pimPage = dashboardPage.clickPIM();
        pimPage.addNewEmployee("Test", "User");
        
        Assert.assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"), "Employee was not added successfully - did not navigate to personal details");
    }
}
