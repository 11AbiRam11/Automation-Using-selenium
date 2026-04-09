package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClaimPage extends BasePage {

    // Page Header
    private By claimHeader = By.xpath("//h6[normalize-space()='Claim']");

    // Employee Name Input
    private By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");

    // Search Button
    private By searchButton = By.xpath("//button[@type='submit']");

    public ClaimPage(WebDriver driver) {

        super(driver);

        // Ensure Claim page is loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(claimHeader));
        wait.until(ExpectedConditions.urlContains("claim"));
    }

    public String getHeaderText() {
        return driver.findElement(claimHeader).getText();
    }

    public void searchClaimByEmployee(String name) {

        waitForLoading();

        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameInput)).clear();

        driver.findElement(employeeNameInput).sendKeys(name);

        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

        waitForLoading();
    }
}