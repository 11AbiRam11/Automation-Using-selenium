package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BuzzPage extends BasePage {

    // Page Header
    private By buzzHeader = By.xpath("//h6[normalize-space()='Buzz']");

    // Post Input
    private By postInput = By.xpath("//textarea[contains(@class,'oxd-buzz-post-input')]");

    // Post Button
    private By postButton = By.xpath("//button[@type='submit']");

    public BuzzPage(WebDriver driver) {

        super(driver);

        // Ensure Buzz page is loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(buzzHeader));
        wait.until(ExpectedConditions.urlContains("buzz"));
    }

    public String getHeaderText() {
        return driver.findElement(buzzHeader).getText();
    }

    public void createPost(String message) {

        waitForLoading();

        wait.until(ExpectedConditions.visibilityOfElementLocated(postInput)).clear();

        driver.findElement(postInput).sendKeys(message);

        wait.until(ExpectedConditions.elementToBeClickable(postButton)).click();

        waitForLoading();
    }
}