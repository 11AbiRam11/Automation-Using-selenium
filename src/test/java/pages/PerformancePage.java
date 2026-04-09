package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PerformancePage extends BasePage {

    // Page Header
    private By performanceHeader = By.xpath("//h6[normalize-space()='Performance']");

    // Employee Name Input
    private By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");

    // Search Button
    private By searchButton = By.xpath("//button[@type='submit']");

    public PerformancePage(WebDriver driver) {

        super(driver);

        // Ensure Performance page is loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(performanceHeader));
        wait.until(ExpectedConditions.urlContains("performance"));
    }

    public String getHeaderText() {
        return driver.findElement(performanceHeader).getText();
    }

    public void searchEmployeePerformance(String name) {

        waitForLoading();

        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameInput)).clear();

        driver.findElement(employeeNameInput).sendKeys(name);

        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

        waitForLoading();
    }
}