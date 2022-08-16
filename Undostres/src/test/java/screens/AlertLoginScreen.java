package screens;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseClass;
import utility.ReportGen;
import utility.pageRepository;

import java.io.IOException;

public class AlertLoginScreen extends BaseClass {
    public static String message = "Recharge failed due to Captcha issue";

    /*
    Entering data in Username and Password fields
    Switching to the Captcha Frame and selecting the checkbox
    Clicking on Submit button
     */
    public static void alertLogin() throws IOException, InterruptedException {
        try{
            ReportGen.logger.log(LogStatus.PASS, "Check alert screen is displayed");
            ReportGen.logger.log(LogStatus.INFO, "Screenshot of alert screen" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
            BaseClass.waitForElementByID(30, "usrname");
            enterUserName();
            enterPassword();

            WebElement login = driver.findElement(By.id(pageRepository.loginButton));
            BaseClass.scrollScreen(login);

            driver.switchTo().frame(0); //frame name changes so using index

            WebElement captchaCheckBox = driver.findElement(By.id(pageRepository.captchaCheckBox));
            captchaCheckBox.click();

            Thread.sleep(8000);
            driver.switchTo().defaultContent();
            Thread.sleep(2000);

            ReportGen.logger.log(LogStatus.PASS, "Clicking on login button");
            WebElement loginButton = driver.findElement(By.id(pageRepository.loginButton));
            loginButton.click();
            ReportGen.logger.log(LogStatus.INFO, "Screenshot after clicking login button" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));

        }catch (Exception e){
            ReportGen.logger.log(LogStatus.FAIL, "Error alert screen is not displayed");
            ReportGen.logger.log(LogStatus.FAIL, "Screenshot of Error alert screen" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }
    }

    public static void enterUserName() throws IOException {
        try{
            ReportGen.logger.log(LogStatus.PASS, "Entering user name");
            String email = BaseClass.getProperty("USER_NAME");
            WebElement userName = driver.findElement(By.id(pageRepository.userName));
            userName.sendKeys(email);
            ReportGen.logger.log(LogStatus.INFO, "Screenshot of entered username" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }catch (Exception e){
            ReportGen.logger.log(LogStatus.FAIL, "Error entering user name");
            ReportGen.logger.log(LogStatus.FAIL, "Screenshot of error entering user name" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }


    }

    public static void enterPassword() throws IOException {
        try{
            ReportGen.logger.log(LogStatus.PASS, "Entering Password");
            String password = BaseClass.getProperty("PASSWORD");
            WebElement pass = driver.findElement(By.id(pageRepository.password));
            pass.sendKeys(password);
            ReportGen.logger.log(LogStatus.INFO, "Screenshot of entered password" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }catch (Exception e){
            ReportGen.logger.log(LogStatus.FAIL, "Error entering password");
            ReportGen.logger.log(LogStatus.FAIL, "Screenshot of error entering password" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));

        }

    }

    public static String confirmationMessage(){
        try{
            ReportGen.logger.log(LogStatus.PASS, "Confirmation message screen");
            WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.className(pageRepository.paymentConfirmationMessage)));
            message = driver.findElement(By.className("confirmation-message")).getText();
            ReportGen.logger.log(LogStatus.INFO, "Screenshot of confirmation message" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }catch (Exception e){
            message = "Payment failed due to Captcha issue";
            ReportGen.logger.log(LogStatus.FAIL, "Error in processing payment");
            ReportGen.logger.log(LogStatus.FAIL, "Screenshot of error confirmation message" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }
        return message;
    }

}
