package pages;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
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
        alertHelper.acceptAlert();

    }
    public void interactWithTimerAlert(){
        elementHelper .clickJSLocator(AlertLocators.alertTimerElement); //dam click
        alertHelper.acceptAlert();
    }

    public void interactWithCancelAlert(){
        elementHelper.clickLocator((AlertLocators.alertOkCancelElement));//click
        alertHelper.cancelAlert();
    }

    public void interactWithValueAlert(String value){
        elementHelper.clickLocator(AlertLocators.alertTextElement);
       alertHelper.fillText(value);
    }
}
