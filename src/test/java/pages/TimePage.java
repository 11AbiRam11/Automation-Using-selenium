package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TimePage extends BasePage {

    // Page Header
    private By timeHeader = By.xpath("//h6[normalize-space()='Time']");

    // Employee name field
    private By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");

    // View button
    private By viewButton = By.xpath("//button[@type='submit']");

    public TimePage(WebDriver driver) {

        super(driver);

        // Ensure Time page is loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(timeHeader));
        wait.until(ExpectedConditions.urlContains("time"));
    }

    public String getHeaderText() {
        return driver.findElement(timeHeader).getText();
    }

    public void viewTimesheet(String name) {

        waitForLoading();

        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameInput)).clear();

        driver.findElement(employeeNameInput).sendKeys(name);

        wait.until(ExpectedConditions.elementToBeClickable(viewButton)).click();

        waitForLoading();
    }
}