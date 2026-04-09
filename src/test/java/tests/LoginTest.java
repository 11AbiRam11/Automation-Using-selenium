package tests;

import base.BaseClass;
import base.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

import java.io.File;

public class LoginTest extends BaseClass {

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        String path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";
        File file = new File(path);
        
        if (!file.exists()) {
            System.err.println("Warning: TestData.xlsx not found at: " + path + ". Using fallback data for execution.");
            return new Object[][] {
                {"Admin", "admin123", "Valid"},
                {"InvalidUser", "wrongPass", "Invalid"}
            };
        }
        return ExcelUtils.getTestData(path, "LoginData");
    }

    @Test(dataProvider = "loginData")
    public void testDataDrivenLogin(String username, String password, String status) {
        LoginPage loginPage = new LoginPage(driver);

        if (status.equalsIgnoreCase("Valid")) {
            DashboardPage dashboardPage = loginPage.login(username, password);
            Assert.assertEquals(dashboardPage.getHeaderText(), "Dashboard", "Login should have been successful");
        } else {
            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.clickLogin();
            String errorMsg = loginPage.getErrorMessage();
            Assert.assertEquals(errorMsg, "Invalid credentials", "Error message did not match");
        }
    }

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");

        String headerText = dashboardPage.getHeaderText();
        Assert.assertEquals(headerText, "Dashboard", "Login was not successful");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Invalid");
        loginPage.enterPassword("invalid");
        loginPage.clickLogin();
        
        String errorMsg = loginPage.getErrorMessage();
        Assert.assertEquals(errorMsg, "Invalid credentials", "Invalid login should show proper error message");
    }
}