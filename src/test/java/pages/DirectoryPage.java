package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DirectoryPage extends BasePage {

    // Page Header
    private By directoryHeader = By.xpath("//h6[normalize-space()='Directory']");

    // Employee Name Input
    private By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");

    // Search Button
    private By searchButton = By.xpath("//button[@type='submit']");

    public DirectoryPage(WebDriver driver) {

        super(driver);

        // Ensure Directory page is loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(directoryHeader));
        wait.until(ExpectedConditions.urlContains("directory"));
    }

    public String getHeaderText() {
        return driver.findElement(directoryHeader).getText();
    }

    public void searchEmployee(String name) {

        waitForLoading();

        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameInput)).clear();

        driver.findElement(employeeNameInput).sendKeys(name);

        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

        waitForLoading();
    }
}