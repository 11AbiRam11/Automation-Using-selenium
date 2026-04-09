package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import pages.ClaimPage;

public class ClaimTest extends BaseClass {

    @Test(description = "Verify Claim Page header")
    public void testClaimPage() {
        LoginPage loginPage = new LoginPage(driver);
        
        // 1. Professional Login returns the next logical page
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        
        // 2. Navigation is handled centrally from any BasePage child
        ClaimPage claimPage = dashboardPage.goToClaim();
        
        // 3. Precise assertion with trimmed header check
        Assert.assertEquals(claimPage.getHeaderText(), "Claim", "Failed to navigate to Claim page or header mismatch");
    }
}
