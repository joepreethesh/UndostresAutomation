package screens;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.log.Log;
import test.tmp.Base;
import utility.BaseClass;
import utility.ReportGen;
import utility.pageRepository;

import java.io.IOException;

public class RegistrationScreen extends BaseClass {

    public static void enterDataInNumberField() throws IOException {
        try{
            ReportGen.logger.log(LogStatus.PASS, "Entering contact number");
            String contactNumber = BaseClass.getProperty("CONTACT_NUMBER");
            ReportGen.logger.log(LogStatus.INFO, "Entering contact number in text field");
            WebElement nameField = driver.findElement(By.name(pageRepository.contactNumber));
            nameField.sendKeys(contactNumber);
            ReportGen.logger.log(LogStatus.INFO, "Screenshot after entering contact number" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }catch (Exception e){
            ReportGen.logger.log(LogStatus.FAIL, "Error entering contact number in text field");
            ReportGen.logger.log(LogStatus.FAIL, "Screenshot error entering contact number" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }
    }

    public static void selectOperatorField() throws InterruptedException {
        try{
            ReportGen.logger.log(LogStatus.PASS, "Selecting operator");
            WebElement operatorField = driver.findElement(By.name("operator"));
            operatorField.click();
            BaseClass.waitForElementByXpath(30, pageRepository.telcelOption);
            WebElement selectTelicle = driver.findElement(By.xpath(pageRepository.telcelOption));
            selectTelicle.click();
            ReportGen.logger.log(LogStatus.INFO, "Screenshot after selecting operator" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }catch (Exception e){
            ReportGen.logger.log(LogStatus.FAIL, "Error while selecting operator");
            ReportGen.logger.log(LogStatus.FAIL, "Screenshot error on selecting operator" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }

    }

    public static void selectRechargeValue() {
        try{
            ReportGen.logger.log(LogStatus.PASS, "Selecting recharge value");
            WebElement rechargeField = driver.findElement(By.cssSelector(pageRepository.rechargePlan));
            rechargeField.click();
            WebElement sumbitButton = driver.findElement(By.cssSelector(pageRepository.submitButton));
            sumbitButton.click();
            ReportGen.logger.log(LogStatus.INFO, "Screenshot after selecting recharge value" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }catch (Exception e){
            ReportGen.logger.log(LogStatus.FAIL, "Error Selecting recharge value");
            ReportGen.logger.log(LogStatus.FAIL, "Screenshot error selecting recharge value" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }

    }


}
