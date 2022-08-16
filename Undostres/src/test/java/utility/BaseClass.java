package utility;
//import com.beust.jcommander.Parameter;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v95.indexeddb.model.Key;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.reporters.jq.TestPanel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static String configFileName = "config.properties";
    public static Properties props = new Properties();

    public static void selectBrowser(String browserName){

        switch(browserName){
            case "GoogleChrome":
                initChromeBrowser();
                break;

            case "InternetExplorer":
                initInternetExplorerBrowser();
                break;
        }

    }

    public static void initChromeBrowser(){
        try{
            ReportGen.logger.log(LogStatus.INFO, "Launching Google Chrome Browser");
            String path = System.getProperty("user.dir");   // return project folder path
            String driverpath = path + "\\src\\test\\java\\webDrivers\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverpath);
            driver = new ChromeDriver();
            launchBrowser();
            ReportGen.logger.log(LogStatus.INFO, "Screenshot of web browser launch" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }catch (Exception e){
            ReportGen.logger.log(LogStatus.FAIL, "Error setting up Google Chrome Browser");
            ReportGen.logger.log(LogStatus.INFO, "Screenshot of web browser launch error" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }


    }

    public static void launchBrowser(){
        try{
            driver.get("http://sanbox.undostres.com.mx");
        }catch (Exception e){
            ReportGen.logger.log(LogStatus.FAIL, "Error setting up Google Chrome Browser");
        }

    }

    public static void initInternetExplorerBrowser(){
        ReportGen.logger.log(LogStatus.INFO, "Launching Internet Explorer Browser");
        String path = System.getProperty("user.dir");   // return project folder path
        System.out.println("Path is" + " " + path);

        String driverpath = path + "\\src\\test\\java\\webDrivers\\IEDriverServer.exe";
        System.out.println(driverpath);
        System.setProperty("webdriver.ie.driver", driverpath);
        driver = new InternetExplorerDriver();
        driver.get("http://sanbox.undostres.com.mx");
    }

    public static void launchBrowser(String browsername) {
        selectBrowser(browsername);
    }


    public static String getProperty(String strKey) throws IOException {
        String strValue = null;
        try{
            File file = new File(configFileName);
            if(file.exists()){
                FileInputStream in = new FileInputStream(file);
                props.load(in);
                strValue = props.getProperty(strKey);
                in.close();
            }
            else {
                throw new FileNotFoundException("File not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strValue;
    }

    public static void waitForElementByXpath(int waitTime, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementName)));
    }

    public static void waitForElementByID(int waitTime, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementName)));
    }

    public static void scrollScreen(WebElement scrollToElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", scrollToElement);
    }
}
