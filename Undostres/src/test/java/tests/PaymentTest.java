package tests;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.AlertLoginScreen;
import screens.PaymentScreen;
import screens.RegistrationScreen;
import utility.BaseClass;
import utility.ReportGen;

import java.io.IOException;
import java.lang.reflect.Method;

import static utility.ReportGen.endTest;

/*
Use the testng xml file to run the script in different browser
We can view the status of the executed steps in the extent report generated
 */


public class PaymentTest extends BaseClass{
    @Parameters({"browsername"})
    @Test
    public static void test(@Optional("GoogleChrome") String browsername, Method method) throws IOException, InterruptedException {
        String name = method.getName();
        ReportGen.generateReport(name);
        launchBrowser(browsername);
        RegistrationScreen.enterDataInNumberField();
        RegistrationScreen.selectOperatorField();
        RegistrationScreen.selectRechargeValue();
        PaymentScreen.selectTarjetaOption();
        PaymentScreen.selectUsarNuevaTarjeta();
        PaymentScreen.enterCardDetails();
        PaymentScreen.clickSubmit();
        AlertLoginScreen.alertLogin();
        String resMessage = AlertLoginScreen.confirmationMessage();
        System.out.println(resMessage);
        Assert.assertNotEquals(resMessage, "Payment failed due to Captcha issue");
        endTest();
    }
}
