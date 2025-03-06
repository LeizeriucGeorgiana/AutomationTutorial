import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.List;


public class WebTablesTest extends SharedData {
    @Test
    public void metodaTest ()
    {
        ElementHelper elementHelper= new ElementHelper(getDriver());

        By elementsManu=By.xpath("//h5 [text()='Elements']");
        elementHelper.clickJSlocator(elementsManu);

        By WebTable=By.xpath("//span [text()='Web Tables']");
        elementHelper.clickJSlocator(WebTable);

        //identificam o lista de elemente
        By initialTableElement=By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
        int expectedTableSize=3;

        //compararea valorii initiale cu cea asteptata . In caz ca nu sunt egale, mesajul va fi afisat.
        elementHelper.validateSizeList(initialTableElement,expectedTableSize);

       // identificam un element
        By addElement= By.id("addNewRecordButton"); //este o variabila locala
        elementHelper.clickLocator(addElement);

        //in campul first name se va completa cu string-ul dat
        By firstNameElement= By.id("firstName");
        String firstNameValue="Georgiana";
        elementHelper.fillLocator(firstNameElement,firstNameValue);

        //in caseta lastname se va completa cu string-ul dat
        By lastNameElement= By.id("lastName");
        String lastNameValue="Leizeriuc";
        elementHelper.fillLocator(lastNameElement,lastNameValue);

        By emailElement=By.id("userEmail");
        String emailValue="test@tester.com";
        elementHelper.fillLocator(emailElement,emailValue);

        By ageElement=By.id("age");
        String ageValue="27";
        elementHelper.fillLocator(ageElement,ageValue);

        By salaryElement=By.id("salary");
        String salaryValue="2200";
        elementHelper.fillLocator(salaryElement,salaryValue);

        By departmentElement=By.id("department");
        String departmentValue="IT";
        elementHelper.fillLocator(departmentElement,departmentValue);

        By submitElement=By.id("submit");
        elementHelper.clickLocator(submitElement);

        //Validam ca avem 4 randuri in tabel
        By addTableElement= By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
        elementHelper.validateSizeList(addTableElement,4);

        // se identifica noua lista dupa ce s-a realizat modificarile
        List<WebElement> addTableElementList = getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        String rowText = addTableElementList.get(3).getText();

        //verifica daca o conditie este adevarata (contine randul 4  elementul completat pentru nume?)
        Assert.assertTrue( rowText.contains(firstNameValue));
        Assert.assertTrue( rowText.contains(lastNameValue));
        Assert.assertTrue( rowText.contains(emailValue));
        Assert.assertTrue( rowText.contains(ageValue));
        Assert.assertTrue( rowText.contains(salaryValue));
        Assert.assertTrue( rowText.contains(departmentValue));

        //modificarea campurilor deja completate
        By editElement = By.id("edit-record-4");
        elementHelper.clickLocator(editElement);

        By editSalaryElement = By.id("salary");
        elementHelper.clearLocator(editSalaryElement);
        String editSalaryValue= "2500";
        elementHelper.fillLocator(editSalaryElement,editSalaryValue);

        By editageElement= By.id("age");
        elementHelper.clearLocator(editageElement);
        String editageValue= "28";
        elementHelper.fillLocator(editageElement,editageValue);

        By editdepartmentElement= By.id("department");
        elementHelper.clearLocator(editdepartmentElement);
        String editdepartmentValue= "HR";
        elementHelper.fillLocator(editdepartmentElement,editdepartmentValue);

        By editSubmitElement= By.id("submit");
        elementHelper.clickLocator(editSubmitElement);

        //validam valorile modificate

        List<WebElement> editTableElementList = getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        String editRowText = editTableElementList.get(3).getText();

        Assert.assertTrue( editRowText.contains(editageValue));
        Assert.assertTrue( editRowText.contains(editSalaryValue));
        Assert.assertTrue( editRowText.contains(editdepartmentValue));

        //stergerea unui element

        By deleteElement= By.id("delete-record-4");
        elementHelper.clickLocator(deleteElement);

        //validam lista dupa stergerea elementului
          By deleteTableElement=By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");// se identifica noua lista dupa ce s-a realizat modificarile
          elementHelper.validateSizeList(deleteTableElement,3); //compararea valorii initiale cu cea asteptata . In caz ca nu sunt egale, mesajul va fi afisat.
    }
  }
