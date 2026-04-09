//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//public class AdminPage extends BasePage {
//
//    // Locators
//    private By usernameSearchInput = By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input");
//    private By searchButton = By.xpath("//button[@type='submit']");
//    private By addButton = By.xpath("//button[normalize-space()='Add']");
//    private By recordsCount = By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span");
//
//    public AdminPage(WebDriver driver) {
//        super(driver);
//    }
//
//    public void searchUserByUsername(String username) {
//        waitForLoading();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameSearchInput)).clear();
//        driver.findElement(usernameSearchInput).sendKeys(username);
//        driver.findElement(searchButton).click();
//        waitForLoading();
//    }
//
//    public String getRecordsFoundText() {
//        waitForLoading();
//        // Wait for the specific text indicating records (e.g., "(1) Record Found" or "No Records Found")
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(recordsCount)).getText();
//    }
//
//    public void clickAddUser() {
//        waitForLoading();
//        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
//    }
//}


package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminPage extends BasePage {

    private By adminHeader = By.xpath("//h6[text()='Admin']");
    private By usernameSearchInput =
            By.xpath("//label[text()='Username']/../following-sibling::div/input");

    private By searchButton = By.xpath("//button[@type='submit']");
    private By addButton = By.xpath("//button[normalize-space()='Add']");
    private By recordsCount =
            By.xpath("//span[contains(text(),'Record')]");

    public AdminPage(WebDriver driver) {

        super(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(adminHeader));
        wait.until(ExpectedConditions.urlContains("admin"));
    }

    public String getHeaderText() {
        return driver.findElement(adminHeader).getText();
    }

    public void searchUserByUsername(String username) {

        waitForLoading();

        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameSearchInput)).clear();
        driver.findElement(usernameSearchInput).sendKeys(username);

        driver.findElement(searchButton).click();

        waitForLoading();
    }

    public String getRecordsFoundText() {

        waitForLoading();

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(recordsCount)
        ).getText();
    }

    public void clickAddUser() {

        waitForLoading();

        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }
}
