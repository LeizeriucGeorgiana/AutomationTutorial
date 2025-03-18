
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.WebTablePage;
import sharedData.SharedData;

public class WebTablesTest extends SharedData {
    @Test
    public void metodaTest ()
    {
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnElementsMenu();
        indexPage.clickOnWebTableSubMenu();

        // add
        String firstnameValue = "Georgiana";
        String lastNameValue = "Leizeriuc";
        String userEmailValue = "georgiana@gmail.com";
        String ageValue = "33";
        String salaryValue = "20000";
        String departmentValue = "QA";

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.addNewEntry(firstnameValue, lastNameValue,userEmailValue,ageValue,salaryValue,departmentValue,4);


        //edit
        String editSalaryValue = "30000";
        String editDepartmentValue = "Team lead QA";
        String editAgeValue = "34";
        webTablePage.editNewEntry (editSalaryValue,editDepartmentValue,editAgeValue,4);

        //delete
        webTablePage.deleteNewEntry(3);


    }
  }
