//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//
//public class BasePage {
//
//    protected WebDriver driver;
//    protected WebDriverWait wait;
//
//    private By loader = By.className("oxd-loading-spinner");
//
//    public BasePage(WebDriver driver) {
//
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }
//
//    protected void waitForLoading() {
//
//        try {
//            wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
//        } catch (Exception ignored) {
//        }
//    }
//
//    protected void waitForUrlContains(String urlPart) {
//        wait.until(ExpectedConditions.urlContains(urlPart));
//    }
//
//    protected void waitForElement(By locator) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }
//
//    protected void click(By locator) {
//        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
//    }
//
//    protected void type(By locator, String text) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
//        driver.findElement(locator).sendKeys(text);
//    }
//}

package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private By loader = By.className("oxd-loading-spinner");

    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ================= WAIT FOR LOADER =================
    protected void waitForLoading() {

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        } catch (Exception ignored) {
        }

        wait.until(d ->
                ((JavascriptExecutor) d)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
    }

    // ================= WAIT URL =================
    protected void waitForUrlContains(String urlPart) {
        wait.until(ExpectedConditions.urlContains(urlPart));
    }

    // ================= WAIT ELEMENT =================
    protected WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // ================= CLICK =================
    protected void click(By locator) {

        waitForLoading();

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );

        scrollToElement(element);

        wait.until(
                ExpectedConditions.elementToBeClickable(element)
        ).click();
    }

    // ================= TYPE =================
    protected void type(By locator, String text) {

        waitForLoading();

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );

        scrollToElement(element);

        element.clear();
        element.sendKeys(text);
    }

    // ================= GET TEXT =================
    protected String getText(By locator) {

        waitForLoading();

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).getText().trim();
    }

    // ================= SCROLL =================
    protected void scrollToElement(WebElement element) {

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        element
                );
    }
}