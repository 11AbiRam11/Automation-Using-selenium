package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyInfoPage extends BasePage {

    // Page Header
    private By myInfoHeader = By.xpath("//h6[normalize-space()='PIM']");

    // Personal Details Fields
    private By firstNameInput = By.name("firstName");
    private By lastNameInput = By.name("lastName");

    // Save Button
    private By saveButton = By.xpath("//button[@type='submit']");

    public MyInfoPage(WebDriver driver) {

        super(driver);

        // Ensure My Info page is loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
        wait.until(ExpectedConditions.urlContains("viewPersonalDetails"));
    }

    public String getHeaderText() {
        return driver.findElement(firstNameInput).getAttribute("value");
    }

    public void updateName(String firstName, String lastName) {

        waitForLoading();

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput)).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);

        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);

        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();

        waitForLoading();
    }
}