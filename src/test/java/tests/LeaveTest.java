package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import pages.LeavePage;

public class LeaveTest extends BaseClass {

    @Test(description = "Verify Leave Page header")
    public void testLeavePage() {
        LoginPage loginPage = new LoginPage(driver);
        
        // 1. Professional Login returns the next logical page
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        
        // 2. Navigation is handled centrally from any BasePage child
        LeavePage leavePage = dashboardPage.goToLeave();
        
        // 3. Precise assertion with trimmed header check
        Assert.assertEquals(leavePage.getHeaderText(), "Leave", "Failed to navigate to Leave page or header mismatch");
    }
}
