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

        By alertsManualElement=By.xpath("//h5[text()='Alerts, Frame & Windows']");// identificare pagina Alerts, Frame & Windows dupa nume
        elementHelper.clickJSlocator(alertsManualElement);

        By alertsElement=By.xpath("//span[text()='Alerts']");// identificare pagina Alerte
        elementHelper.clickLocator(alertsElement);//realizare click pe acea pagina

        By alert0kElement = By.id("alertButton");//identificare buton pentru a vedea alerta
        elementHelper.clickLocator((alert0kElement));//click acel buton

        alertHelper.acceptAlert();
        WebElement alertTimeElement = getDriver().findElement(By.id("timerAlertButton")); // identificare buton alerta
        alertTimeElement.click(); //dam click

        alertHelper.acceptAlert();

        By alertOkCancelElement=By.id("confirmButton"); //identificare buton alerta
        elementHelper.clickLocator((alertOkCancelElement));//click

        alertHelper.cancelAlert();

        By alertTextElement= By.id("promtButton");
        elementHelper.clickLocator(alertTextElement);
        alertHelper.fillText("Georgiana");
    }
}
