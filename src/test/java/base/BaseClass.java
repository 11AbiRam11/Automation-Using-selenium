//package base;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.ITestResult;
//import org.testng.annotations.*;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.time.Duration;
//import java.util.Date;
//
//public class BaseClass {
//
//    public WebDriver driver;
//    public WebDriverWait wait;
//
//    @BeforeMethod
//    @Parameters({"browser", "headless"})
//    public void setUp(@Optional("chrome") String browser,
//                      @Optional("false") String headlessStr) {
//
//        boolean headless = Boolean.parseBoolean(headlessStr);
//
//        System.setProperty("webdriver.chrome.silentOutput", "true");
//        java.util.logging.Logger.getLogger("org.openqa.selenium")
//                .setLevel(java.util.logging.Level.OFF);
//
//        if (browser.equalsIgnoreCase("chrome")) {
//
//            WebDriverManager.chromedriver().setup();
//
//            ChromeOptions options = new ChromeOptions();
//
//            if (headless) {
//                options.addArguments("--headless=new");
//                options.addArguments("--disable-gpu");
//                options.addArguments("--no-sandbox");
//                options.addArguments("--disable-dev-shm-usage");
//                options.addArguments("--window-size=1920,1080");
//            }
//
//            driver = new ChromeDriver(options);
//
//        } else if (browser.equalsIgnoreCase("firefox")) {
//
//            WebDriverManager.firefoxdriver().setup();
//
//            FirefoxOptions options = new FirefoxOptions();
//
//            if (headless) {
//                options.addArguments("-headless");
//            }
//
//            driver = new FirefoxDriver(options);
//
//        } else {
//
//            WebDriverManager.edgedriver().setup();
//
//            EdgeOptions options = new EdgeOptions();
//
//            if (headless) {
//                options.addArguments("--headless");
//                options.addArguments("--window-size=1920,1080");
//            }
//
//            driver = new EdgeDriver(options);
//        }
//
//        driver.manage().window().maximize();
//
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
//    }
//
//    @AfterMethod
//    public void tearDown(ITestResult result) {
//
//        if (result.getStatus() == ITestResult.FAILURE) {
//
//            captureScreenshot(result.getName());
//        }
//
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//    public String captureScreenshot(String testName) {
//
//        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss")
//                .format(new Date());
//
//        File src = ((TakesScreenshot) driver)
//                .getScreenshotAs(OutputType.FILE);
//
//        String path = System.getProperty("user.dir")
//                + "/screenshots/"
//                + testName + "_" + timestamp + ".png";
//
//        try {
//
//            File folder = new File(System.getProperty("user.dir") + "/screenshots");
//
//            if (!folder.exists()) {
//                folder.mkdir();
//            }
//
//            FileUtils.copyFile(src, new File(path));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return path;
//    }
//}

package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseClass {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    @Parameters({"browser", "headless"})
    public void setUp(@Optional("chrome") String browser,
                      @Optional("false") String headlessStr) {

        boolean headless = Boolean.parseBoolean(headlessStr);

        System.setProperty("webdriver.chrome.silentOutput", "true");
        java.util.logging.Logger.getLogger("org.openqa.selenium")
                .setLevel(java.util.logging.Level.OFF);

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            if (headless) {
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
            }

            options.addArguments("--disable-notifications");

            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();

            if (headless) {
                options.addArguments("-headless");
                options.addArguments("--width=1920");
                options.addArguments("--height=1080");
            }

            driver = new FirefoxDriver(options);

        } else {

            WebDriverManager.edgedriver().setup();

            EdgeOptions options = new EdgeOptions();

            if (headless) {
                options.addArguments("--headless");
                options.addArguments("--window-size=1920,1080");
            }

            driver = new EdgeDriver(options);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(result.getName());
        }

        if (driver != null) {
            driver.quit();
        }
    }

    public String captureScreenshot(String testName) {

        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date());

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir")
                + "/screenshots/"
                + testName + "_" + timestamp + ".png";

        try {

            File folder = new File(System.getProperty("user.dir") + "/screenshots");

            if (!folder.exists()) {
                folder.mkdir();
            }

            FileUtils.copyFile(src, new File(path));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}