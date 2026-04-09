package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import pages.MyInfoPage;

public class MyInfoTest extends BaseClass {

    @Test(description = "Verify My Info Page header")
    public void testMyInfoPage() {
        LoginPage loginPage = new LoginPage(driver);
        
        // 1. Professional Login returns the next logical page
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        
        // 2. Navigation is handled centrally from any BasePage child
        MyInfoPage myInfoPage = dashboardPage.goToMyInfo();
        
        // 3. Precise assertion with trimmed header check - My Info page header is "PIM"
        Assert.assertEquals(myInfoPage.getHeaderText(), "PIM", "Failed to navigate to My Info page or header mismatch");
    }
}
