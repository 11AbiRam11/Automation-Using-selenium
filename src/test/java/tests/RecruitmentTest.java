package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import pages.RecruitmentPage;

public class RecruitmentTest extends BaseClass {

    @Test(description = "Verify Recruitment Page header")
    public void testRecruitmentPage() {
        LoginPage loginPage = new LoginPage(driver);
        
        // 1. Professional Login returns the next logical page
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        
        // 2. Navigation is handled centrally from any BasePage child
        RecruitmentPage recruitmentPage = dashboardPage.goToRecruitment();
        
        // 3. Precise assertion with trimmed header check
        Assert.assertEquals(recruitmentPage.getHeaderText(), "Recruitment", "Failed to navigate to Recruitment page or header mismatch");
    }
}
