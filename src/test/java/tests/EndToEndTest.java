package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;

public class EndToEndTest extends BaseClass {

    @Test(description = "Verify accessibility of all sidebar modules")
    public void testAllModulesAccessibility() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");

        // Use professional navigation from any page returning its own object
        Assert.assertEquals(dashboardPage.goToAdmin().getHeaderText(), "Admin");
        Assert.assertEquals(dashboardPage.goToPIM().getHeaderText(), "PIM");
        Assert.assertEquals(dashboardPage.goToLeave().getHeaderText(), "Leave");
        Assert.assertEquals(dashboardPage.goToTime().getHeaderText(), "Time");
        Assert.assertEquals(dashboardPage.goToRecruitment().getHeaderText(), "Recruitment");
        // My Info displays 'PIM' header
        Assert.assertEquals(dashboardPage.goToMyInfo().getHeaderText(), "PIM");
        Assert.assertEquals(dashboardPage.goToPerformance().getHeaderText(), "Performance");
        Assert.assertEquals(dashboardPage.goToDirectory().getHeaderText(), "Directory");
        Assert.assertEquals(dashboardPage.goToClaim().getHeaderText(), "Claim");
        Assert.assertEquals(dashboardPage.goToBuzz().getHeaderText(), "Buzz");
    }
}
