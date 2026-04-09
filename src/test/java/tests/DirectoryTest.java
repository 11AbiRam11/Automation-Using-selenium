package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import pages.DirectoryPage;

public class DirectoryTest extends BaseClass {

    @Test(description = "Verify Directory Page header")
    public void testDirectoryPage() {
        LoginPage loginPage = new LoginPage(driver);
        
        // 1. Professional Login returns the next logical page
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        
        // 2. Navigation is handled centrally from any BasePage child
        DirectoryPage directoryPage = dashboardPage.goToDirectory();
        
        // 3. Precise assertion with trimmed header check
        Assert.assertEquals(directoryPage.getHeaderText(), "Directory", "Failed to navigate to Directory page or header mismatch");
    }
}
