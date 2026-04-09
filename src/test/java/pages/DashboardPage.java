package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class DashboardPage extends BasePage {

    // ================= HEADER =================
    private By dashboardHeader = By.xpath("//h6[normalize-space()='Dashboard']");

    // ================= SIDE MENU =================
    private By sideMenuLinks = By.xpath("//ul[@class='oxd-main-menu']/li");

    // ================= WIDGETS =================
    private By widgetTitles = By.xpath("//h6");

    // ================= MENU =================
    private By adminMenu = By.xpath("//span[normalize-space()='Admin']");
    private By pimMenu = By.xpath("//span[normalize-space()='PIM']");
    private By leaveMenu = By.xpath("//span[normalize-space()='Leave']");
    private By timeMenu = By.xpath("//span[normalize-space()='Time']");
    private By recruitmentMenu = By.xpath("//span[normalize-space()='Recruitment']");
    private By myInfoMenu = By.xpath("//span[normalize-space()='My Info']");
    private By performanceMenu = By.xpath("//span[normalize-space()='Performance']");
    private By directoryMenu = By.xpath("//span[normalize-space()='Directory']");
    private By claimMenu = By.xpath("//span[normalize-space()='Claim']");
    private By buzzMenu = By.xpath("//span[normalize-space()='Buzz']");
    private By dashboardMenu = By.xpath("//span[normalize-space()='Dashboard']");

    // ================= CONSTRUCTOR =================
    public DashboardPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));
        wait.until(ExpectedConditions.urlContains("dashboard"));
    }

    // ================= HEADER =================
    public String getHeaderText() {
        waitForLoading();
        return driver.findElement(dashboardHeader).getText().trim();
    }

    // ================= SIDE MENU =================
    public int getSideMenuCount() {
        waitForLoading();
        List<WebElement> menus = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(sideMenuLinks)
        );
        return menus.size();
    }

    // ================= WIDGET CHECK =================
    public boolean isWidgetDisplayed(String widgetName) {

        waitForLoading();

        List<WebElement> widgets = driver.findElements(widgetTitles);

        for (WebElement widget : widgets) {
            if (widget.getText().trim().equalsIgnoreCase(widgetName)) {
                return true;
            }
        }

        return false;
    }

    // ================= NAVIGATION =================

    public DashboardPage goToDashboard() {
        waitForLoading();
        click(dashboardMenu);
        return this;
    }

    public AdminPage goToAdmin() {
        waitForLoading();
        click(adminMenu);
        return new AdminPage(driver);
    }

    public PIMPage goToPIM() {
        waitForLoading();
        click(pimMenu);
        return new PIMPage(driver);
    }

    public LeavePage goToLeave() {
        waitForLoading();
        click(leaveMenu);
        return new LeavePage(driver);
    }

    public TimePage goToTime() {
        waitForLoading();
        click(timeMenu);
        return new TimePage(driver);
    }

    public RecruitmentPage goToRecruitment() {
        waitForLoading();
        click(recruitmentMenu);
        return new RecruitmentPage(driver);
    }

    public MyInfoPage goToMyInfo() {
        waitForLoading();
        click(myInfoMenu);
        return new MyInfoPage(driver);
    }

    public PerformancePage goToPerformance() {
        waitForLoading();
        click(performanceMenu);
        return new PerformancePage(driver);
    }

    public DirectoryPage goToDirectory() {
        waitForLoading();
        click(directoryMenu);
        return new DirectoryPage(driver);
    }

    public ClaimPage goToClaim() {
        waitForLoading();
        click(claimMenu);
        return new ClaimPage(driver);
    }

    public BuzzPage goToBuzz() {
        waitForLoading();
        click(buzzMenu);
        return new BuzzPage(driver);
    }

    // ================= ALIASES =================

    public DashboardPage clickDashboard() { return goToDashboard(); }
    public AdminPage clickAdmin() { return goToAdmin(); }
    public PIMPage clickPIM() { return goToPIM(); }
    public LeavePage clickLeave() { return goToLeave(); }
    public TimePage clickTime() { return goToTime(); }
    public RecruitmentPage clickRecruitment() { return goToRecruitment(); }
    public MyInfoPage clickMyInfo() { return goToMyInfo(); }
    public PerformancePage clickPerformance() { return goToPerformance(); }
    public DirectoryPage clickDirectory() { return goToDirectory(); }
    public ClaimPage clickClaim() { return goToClaim(); }
    public BuzzPage clickBuzz() { return goToBuzz(); }
}