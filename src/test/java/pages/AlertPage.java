package pages;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import modelObject.AlertModel;
import org.openqa.selenium.WebDriver;
import pageLocators.AlertLocators;

public class AlertPage {
    private WebDriver driver;
    private ElementHelper elementHelper;
    private AlertHelper alertHelper;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        elementHelper=new ElementHelper(driver);
        alertHelper= new AlertHelper(driver);
    }

    public void interactWithAcceptAlert(){
       elementHelper .clickJSLocator(AlertLocators.alertOkElement); //dam click
        LoggerUtility.infoLog("The user clicks on the click me alert element ");
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("The user accepted the alert");

    }
    public void interactWithTimerAlert(){
        elementHelper .clickJSLocator(AlertLocators.alertTimerElement); //dam click
        LoggerUtility.infoLog("The user clicks on the 'click me' alert timer element ");
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("The user accepted the alert");
    }

    public void interactWithCancelAlert(){
        elementHelper.clickJSLocator((AlertLocators.alertOkCancelElement));//click
        LoggerUtility.infoLog("The user clicks on the 'click me' alert cancel element ");
        alertHelper.cancelAlert();
        LoggerUtility.infoLog("The user canceled the alert");
    }

    public void interactWithValueAlert(AlertModel testData){
        elementHelper.clickJSLocator(AlertLocators.alertTextElement);
        LoggerUtility.infoLog("The user clicks on the 'click me' alert text element ");
       alertHelper.fillText(testData.getPrompValue());
        LoggerUtility.infoLog("The user fills the name with value :" + testData.getPrompValue());
    }
}
