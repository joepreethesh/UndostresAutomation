package utility;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import  java.util.TimeZone;

import java.io.File;

import static utility.BaseClass.driver;

public class ReportGen {

    public static ExtentReports report;
    public static ExtentTest logger;

    public static void generateReport(String reportName){
        report = new ExtentReports("Reports/Report_" + "/" +getTimeStamp("local").replace("-", "").replace(":", "") + ".html", true);
        logger = report.startTest("Recharge payment Execution report");
    }

    public static String captureScreenshot(){
        try {
            String dir = System.getProperty("user.dir");
            System.out.println("Directory1" + " " + dir);
            String src_path = dir + "/Reports/Report_/screenshots/";
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(src_path + getTimeStamp("local").replace("-", "").replace(":", "") + ".png"));
            return "screenshots/" + getTimeStamp("local").replace("-", "").replace(":", "") + ".png";

        } catch (Exception e) {

            return "Not able to take screenshot.---" + e.getClass() + "---" + e.getMessage();

        }

    }

    public static String getTimeStamp(String timeZone) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        if (timeZone.toLowerCase().equals("utc")) {
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        } else {
            dateFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
        }
        return dateFormat.format(new Date());
    }

    public static void endTest(){
        report.endTest(logger);
        report.flush();
    }

}
