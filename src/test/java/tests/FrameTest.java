package tests;

import org.testng.annotations.Test;
import pages.FramePage;
import pages.IndexPage;
import sharedData.SharedData;
import suites.TestCaseSuite;
import suites.TestSuite;

public class FrameTest extends SharedData {

    @Test (groups =  {TestSuite.REGRESION_SUITE, TestSuite.ALLERT_FRAME_SUITE, TestCaseSuite.TIKET_123,TestCaseSuite.TC_456,TestCaseSuite.TC_457,TestCaseSuite.TC_458,TestCaseSuite.TC_459})
    public void metodaTest() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnAlertWindowMenu();
        indexPage.clickOnFrameSubMenu();

        FramePage framePage= new FramePage(getDriver());
        framePage.interactFirstIFrame();
        framePage.interactSecondIFrame();
   }
}
