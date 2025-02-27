package helperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.awt.SystemColor.text;

public class AlertHelper {

    private WebDriver driver;

    public AlertHelper(WebDriver driver) {

        this.driver = driver;
    }
    private void waitForAlert(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));//functie de asteptare
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(){
        waitForAlert();
        Alert alertOk= driver.switchTo().alert();// // Comută către alert
        System.out.println(alertOk.getText()); //obtine textul din alerta
        alertOk.accept(); //dam accept
    }

    public void cancelAlert(){
        waitForAlert();
        Alert alertOkCancel= driver.switchTo().alert();//comuta catre alerta
        System.out.println(alertOkCancel.getText()); //obtinem textul din alerta
        alertOkCancel.dismiss();
    }

    public void fillText(String georgiana){
        waitForAlert();
        Alert alertText = driver.switchTo().alert();
        System.out.println(alertText.getText());//scoaterea mesajului din alerta
        alertText.sendKeys(String.valueOf(text));//trecem valoarea
        alertText.accept();//dam accept
    }
}
