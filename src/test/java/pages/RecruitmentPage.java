package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RecruitmentPage extends BasePage {

    // Page Header
    private By recruitmentHeader = By.xpath("//h6[normalize-space()='Recruitment']");

    // Candidate Name Input
    private By candidateSearchInput = By.xpath("//input[@placeholder='Type for hints...']");

    // Search Button
    private By searchButton = By.xpath("//button[@type='submit']");

    public RecruitmentPage(WebDriver driver) {

        super(driver);

        // Ensure Recruitment page is loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(recruitmentHeader));
        wait.until(ExpectedConditions.urlContains("recruitment"));
    }

    public String getHeaderText() {
        return driver.findElement(recruitmentHeader).getText();
    }

    public void searchCandidate(String name) {

        waitForLoading();

        wait.until(ExpectedConditions.visibilityOfElementLocated(candidateSearchInput)).clear();

        driver.findElement(candidateSearchInput).sendKeys(name);

        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

        waitForLoading();
    }
}