package screens;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseClass;
import utility.ReportGen;
import utility.pageRepository;

import java.io.IOException;
import java.util.List;

public class PaymentScreen extends BaseClass {

    public static void selectTarjetaOption() throws InterruptedException {
        try{
            ReportGen.logger.log(LogStatus.PASS, "Selecting tarjeta option");
            BaseClass.waitForElementByID(30, pageRepository.tarjetaButton);
            WebElement targeta = driver.findElement(By.id(pageRepository.tarjetaButton));
            targeta.click();
            Thread.sleep(2000);
            ReportGen.logger.log(LogStatus.INFO, "Screenshot after selecting tarjeta option" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));

        }catch (Exception e){
            ReportGen.logger.log(LogStatus.FAIL, "Error selecting tarjeta option");
            ReportGen.logger.log(LogStatus.FAIL, "Screenshot on error selecting tarjeta option" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }

    }

    public static void selectUsarNuevaTarjeta(){
        try{
            ReportGen.logger.log(LogStatus.PASS, "Selecting Usarnueva radio button");
            WebElement UsarNuevaTarjetaOption = driver.findElement(By.className(pageRepository.usarnuevaRadioButton));
            UsarNuevaTarjetaOption.click();
            ReportGen.logger.log(LogStatus.INFO, "Screenshot on selecting Usarnueva radio button" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }catch (Exception e){
            ReportGen.logger.log(LogStatus.FAIL, "Error selecting Usarnueva radio button");
            ReportGen.logger.log(LogStatus.FAIL, "Screenshot on selecting Usarnueva radio button" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }

    }

    public static void enterCardNumber() throws IOException {
        try{
            ReportGen.logger.log(LogStatus.PASS, "Entering card number in text field");
            String cardNumber = BaseClass.getProperty("CARD_NUMBER");
            WebElement cardNo = driver.findElement(By.id(pageRepository.cardNumber));
            cardNo.click();
            cardNo.sendKeys(cardNumber);
            ReportGen.logger.log(LogStatus.INFO, "Screenshot after entering card number" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }catch (Exception e){
            ReportGen.logger.log(LogStatus.FAIL, "Error entering card number");
            ReportGen.logger.log(LogStatus.FAIL, "Screenshot error entering card number " + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));

        }

    }

    public static void enterExpMonth() throws IOException {
        try{
            ReportGen.logger.log(LogStatus.PASS, "Entering Exp month");
            String expMonth = BaseClass.getProperty("EXP_MONTH");
            List<WebElement> elementList = driver.findElements(By.name(pageRepository.expiryMonth));
            WebElement text = elementList.get(1);
            text.sendKeys(expMonth);
            ReportGen.logger.log(LogStatus.INFO, "Screenshot after entering exp month" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }catch (Exception e){
            ReportGen.logger.log(LogStatus.FAIL, "Error entering exp month");
            ReportGen.logger.log(LogStatus.FAIL, "Screenshot error entering exp month" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }

    }

    public static void enterExpYear() throws IOException {
        try{
            ReportGen.logger.log(LogStatus.PASS, "Entering Exp Year");
            String expYear = BaseClass.getProperty("EXP_YEAR");
            List<WebElement> elementList = driver.findElements(By.name(pageRepository.expiryYear));
            WebElement text1 = elementList.get(1);
            text1.sendKeys(expYear);
            ReportGen.logger.log(LogStatus.INFO, "Screenshot after entering Exp Year" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }catch (Exception e){
            ReportGen.logger.log(LogStatus.FAIL, "Error entering exp year");
            ReportGen.logger.log(LogStatus.FAIL, "Screenshot error Entering Exp Year" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));

        }

    }

    public static void enterCvv() throws IOException {
        try{
            ReportGen.logger.log(LogStatus.PASS, "Entering CVV");
            String cvv = BaseClass.getProperty("CVV");
            List<WebElement> elementList = driver.findElements(By.name(pageRepository.cvvNumber));
            WebElement text2 = elementList.get(1);
            text2.sendKeys(cvv);
            ReportGen.logger.log(LogStatus.INFO, "Screenshot after entering CVV" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }catch (Exception e){
            ReportGen.logger.log(LogStatus.FAIL, "Error entering CVV");
            ReportGen.logger.log(LogStatus.FAIL, "Screenshot on error entering CVV" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));

        }

    }

    public static void enterEmail() throws IOException {
        try{
            ReportGen.logger.log(LogStatus.PASS, "Entering Email");
            String email = BaseClass.getProperty("EMAIL");
            List<WebElement> elementList = driver.findElements(By.name(pageRepository.emailAddress));
            WebElement text3 = elementList.get(0);
            text3.sendKeys(email);
            ReportGen.logger.log(LogStatus.INFO, "Screenshot after entering Email" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }catch (Exception e){
            ReportGen.logger.log(LogStatus.FAIL, "Error entering Email");
            ReportGen.logger.log(LogStatus.FAIL, "Screenshot error on entering Email" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));


        }

    }

    public static void enterCardDetails() throws IOException {
        enterCardNumber();
        enterExpMonth();
        enterExpYear();
        enterCvv();
        enterEmail();
    }

    public static void clickSubmit() throws IOException {
        try{
            ReportGen.logger.log(LogStatus.PASS, "Clicking Submit button");
            WebElement paymentButton =  driver.findElement(By.id(pageRepository.paylimitButton));
            paymentButton.click();
            ReportGen.logger.log(LogStatus.INFO, "Screenshot after clicking submit button" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }catch (Exception e){
            ReportGen.logger.log(LogStatus.FAIL, "Error clicking submit button");
            ReportGen.logger.log(LogStatus.FAIL, "Screenshot clicking submit button" + ReportGen.logger.addScreenCapture(ReportGen.captureScreenshot()));
        }
    }
}
