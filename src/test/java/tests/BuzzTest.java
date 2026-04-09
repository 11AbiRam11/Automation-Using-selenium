package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import pages.BuzzPage;

public class BuzzTest extends BaseClass {

    @Test(description = "Verify Buzz Page header")
    public void testBuzzPage() {
        LoginPage loginPage = new LoginPage(driver);
        
        // 1. Professional Login returns the next logical page
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        
        // 2. Navigation is handled centrally from any BasePage child
        BuzzPage buzzPage = dashboardPage.goToBuzz();
        
        // 3. Precise assertion with trimmed header check
        Assert.assertEquals(buzzPage.getHeaderText(), "Buzz", "Failed to navigate to Buzz page or header mismatch");
    }
}
