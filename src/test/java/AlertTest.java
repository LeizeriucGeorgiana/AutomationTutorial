import org.testng.annotations.Test;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;

public class AlertTest extends SharedData {
    @Test
    public void metodaTest()
    {

        // identificare pagina Alerts, Frame & Windows dupa nume
        IndexPage indexPage= new IndexPage(getDriver());//creem un obiect care primeste ca parametrru un driver
        indexPage.clickOnAlertWindowMenu();
        indexPage.clickOnAlertSubMenu();

        AlertPage alertPage= new AlertPage(getDriver());
        alertPage.interactWithAcceptAlert();
        alertPage.interactWithTimerAlert();
        alertPage.interactWithCancelAlert();
        alertPage.interactWithValueAlert("Georgiana");
    }
}
