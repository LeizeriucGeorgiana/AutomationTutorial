package tests;

import org.testng.annotations.Test;
import pages.IndexPage;
import pages.TabWindowPage;
import sharedData.SharedData;
import suites.TestSuite;

public class WindowTest extends SharedData {

    @Test (groups =  {TestSuite.REGRESION_SUITE, TestSuite.ALLERT_FRAME_SUITE})
    public void testMethod() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnAlertWindowMenu();
        indexPage.clickOnWindowSubMenu();
        TabWindowPage tabWindowPage=new TabWindowPage(getDriver());
        tabWindowPage.interactWithTab();
        tabWindowPage.interactWithWindow();
    }

}
