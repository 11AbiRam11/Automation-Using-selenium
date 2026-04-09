package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;

    public static synchronized ExtentReports getReporter() {

        if (extent == null) {

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());

            String reportDir = System.getProperty("user.dir") + "/reports";

            File dir = new File(reportDir);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            String reportPath = reportDir + "/AutomationReport_" + timestamp + ".html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("OrangeHRM Automation Report");
            sparkReporter.config().setReportName("Professional Regression Suite");
            sparkReporter.config().setEncoding("utf-8");

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Automation Lead", "Senior Engineer");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Framework", "Selenium 4 + TestNG + Extent 5");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        }

        return extent;
    }
}