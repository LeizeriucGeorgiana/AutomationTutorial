import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;

public class AlertTest extends SharedData {
    @Test
    public void metodaTest()
    {

        AlertHelper alertHelper= new AlertHelper(getDriver());
        ElementHelper elementHelper=new ElementHelper((getDriver()));
        //JavascriptExecutor js = (JavascriptExecutor)getDriver();

        By alertsManualElement=By.xpath("//h5[text()='Alerts, Frame & Windows']");// identificare pagina Alerts, Frame & Windows dupa nume
        //js.executeScript("arguments[0].click();", alertsManualElement ); // click pe acea pagina
        elementHelper.clickJSlocator(alertsManualElement);

        By alertsElement=By.xpath("//span[text()='Alerts']");// identificare pagina Alerte
       // js.executeScript("arguments[0].click();", alertsElement );//realizare click pe acea pagina
        elementHelper.clickLocator(alertsElement);

       // WebElement alert0kElement = getDriver().findElement(By.id("alertButton"));//identificare buton pentru a vedea alerta
        By alert0kElement = By.id("alertButton");//identificare buton pentru a vedea alerta
         //alert0kElement.click();//click acel buton
        elementHelper.clickLocator((alert0kElement));

        //Alert alertOk= getDriver().switchTo().alert();// // Comută către alert
        //System.out.println(alertOk.getText()); //obtine textul din alerta
       // alertOk.accept(); //dam accept

        alertHelper.acceptAlert();

        WebElement alertTimeElement = getDriver().findElement(By.id("timerAlertButton")); // identificare buton alerta
        alertTimeElement.click(); //dam click

        //WebDriverWait wait= new WebDriverWait(getDriver(),Duration.ofSeconds(10));//functie de asteptare
        //wait.until(ExpectedConditions.alertIsPresent()); // este folosită în Selenium pentru a aștepta până când o alertă devine prezentă pe pagina web

        //Alert alertTimer= getDriver().switchTo().alert(); // Comută către alert
        // System.out.println(alertTimer.getText()); //obtine textul din alerta
        //alertTimer.accept(); //dam accept
        alertHelper.acceptAlert();

        //WebElement alertOkCancelElement=getDriver().findElement(By.id("confirmButton")); //identificare buton alerta
        //alertOkCancelElement.click();//click

        By alertOkCancelElement=By.id("confirmButton"); //identificare buton alerta
        elementHelper.clickLocator((alertOkCancelElement));

        // Alert alertOkCancel= getDriver().switchTo().alert();//comuta catre alerta
        //System.out.println(alertOkCancel.getText()); //obtinem textul din alerta
        //alertOkCancel.dismiss();
        alertHelper.cancelAlert();

        //WebElement alertTextElement= getDriver().findElement(By.id("promtButton"));
        //alertTextElement.click();

        By alertTextElement= By.id("promtButton");
        elementHelper.clickLocator(alertTextElement);


      //  Alert alertText = getDriver().switchTo().alert();
       // System.out.println(alertText.getText());//scoaterea mesajului din alerta
       // String alertValue="Georgiana";// adaugam ms in alerta
       // alertText.sendKeys(alertValue);//trecem valoarea
        //alertText.accept();//dam accept

        alertHelper.fillText("Georgiana");
    }
}
