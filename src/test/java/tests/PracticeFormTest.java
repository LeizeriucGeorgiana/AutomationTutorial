package tests;

import modelObject.PracticeFormModel;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.PracticeFormPage;
import sharedData.SharedData;
import suites.TestSuite;

public class PracticeFormTest extends SharedData {

    @Test (groups =  {TestSuite.REGRESION_SUITE, TestSuite.FORM_SUITE})
    public void metodaTest()
    {
        //Această linie de cod creează un obiect de tip PracticeFormModel și, pe baza căii fișierului JSON furnizate,
        // acesta va citi fișierul JSON și va popula automat toate câmpurile obiectului testData cu valorile din fișierul JSON.
        PracticeFormModel testData= new PracticeFormModel("src/test/resources/testData/PracticeFormData.json");

        IndexPage indexPage= new IndexPage(getDriver());
        indexPage.clickOnFormsMenu();
        indexPage.clickOnFormSubMenu();
        PracticeFormPage practiceFormPage= new PracticeFormPage(getDriver());

        practiceFormPage.populateEntireForm(testData);

        practiceFormPage.validateEntireContent(testData);
    }

}