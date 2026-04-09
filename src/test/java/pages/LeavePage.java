package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeavePage extends BasePage {

    // Page Header
    private By leaveHeader = By.xpath("//h6[normalize-space()='Leave']");

    // Search Button (more stable)
    private By searchButton = By.xpath("//button[normalize-space()='Search']");

    public LeavePage(WebDriver driver) {

        super(driver);

        // Ensure Leave page is loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(leaveHeader));
        wait.until(ExpectedConditions.urlContains("leave"));
    }

    public String getHeaderText() {
        return driver.findElement(leaveHeader).getText();
    }

    public void clickSearch() {

        waitForLoading();

        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

        waitForLoading();
    }
}