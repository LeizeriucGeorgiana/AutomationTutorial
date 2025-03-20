import modelObject.AlertModel;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;

public class AlertTest extends SharedData {
    @Test
    public void metodaTest()
    {
        AlertModel testData= new AlertModel("src/test/resources/testData/AlertData.json");

        // identificare pagina Alerts, Frame & Windows dupa nume
        IndexPage indexPage= new IndexPage(getDriver());//creem un obiect care primeste ca parametrru un driver
        indexPage.clickOnAlertWindowMenu();
        indexPage.clickOnAlertSubMenu();

        AlertPage alertPage= new AlertPage(getDriver());
        alertPage.interactWithAcceptAlert();
        alertPage.interactWithTimerAlert();
        alertPage.interactWithCancelAlert();
        alertPage.interactWithValueAlert(testData);
    }
}
