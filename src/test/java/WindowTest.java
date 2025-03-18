
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.TabWindowPage;
import sharedData.SharedData;

public class WindowTest extends SharedData {

    @Test
    public void testMethod() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnAlertWindowMenu();
        indexPage.clickOnWindowSubMenu();
        TabWindowPage tabWindowPage=new TabWindowPage(getDriver());
        tabWindowPage.interactWithTab();
        tabWindowPage.interactWithWindow();
    }

}
