package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PIMPage extends BasePage {

    // Page Header
    private By pimHeader = By.xpath("//h6[normalize-space()='PIM']");

    // Search Employee
    private By employeeNameInput =
            By.xpath("//label[normalize-space()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input");

    private By searchButton = By.xpath("//button[@type='submit']");

    // Add Employee
    private By addButton = By.xpath("//button[normalize-space()='Add']");

    private By firstNameInput = By.name("firstName");
    private By lastNameInput = By.name("lastName");

    private By saveButton = By.xpath("//button[@type='submit']");

    public PIMPage(WebDriver driver) {

        super(driver);

        // Ensure PIM page is loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(pimHeader));
        wait.until(ExpectedConditions.urlContains("pim"));
    }

    public String getHeaderText() {
        return driver.findElement(pimHeader).getText();
    }

    public void searchEmployeeByName(String name) {

        waitForLoading();

        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameInput)).clear();

        driver.findElement(employeeNameInput).sendKeys(name);

        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

        waitForLoading();
    }

    public void clickAddEmployee() {

        waitForLoading();

        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
    }

    public void addNewEmployee(String firstName, String lastName) {

        clickAddEmployee();

        driver.findElement(firstNameInput).sendKeys(firstName);

        driver.findElement(lastNameInput).sendKeys(lastName);

        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();

        // Wait until personal details page loads
        wait.until(ExpectedConditions.urlContains("viewPersonalDetails"));
    }
}