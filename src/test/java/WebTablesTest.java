import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.List;

public class WebTablesTest extends SharedData {
    //public WebDriver getDriver ;//definire variabila globala cu conventia getDriver()
    @Test
    //definire metoda
    public void metodaTest ()
    {
        ElementHelper elementHelper= new ElementHelper(getDriver());

        By elementsManuElements=By.xpath("//h5 [text()='Elements']");
        elementHelper.clickJSlocator(elementsManuElements);

        By elementWebTable=By.xpath("//span [text()='Web Tables']");
        elementHelper.clickJSlocator(elementWebTable);

        //identificam o lista de elemente


        By elementsElementLocator=By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
        List<WebElement> elementsElement=elementHelper.getListElements(elementsElementLocator);
        int initialTableSize = elementsElement.size();  //extragem dimensiunea listei
        int expectedTableSize=3;

        Assert.assertEquals(initialTableSize,expectedTableSize,"Dimensiunea initiala a tabelului nu este egala cu cea asteptata "); //compararea valorii initiale cu cea asteptata . In caz ca nu sunt egale, mesajul va fi afisat.

       // identificam un element
        By addElement= By.id("addNewRecordButton"); //este o variabila locala
        //addElement.click(); //se realizeaza actiunea pe element -  click
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
       // ageElement.sendKeys(ageValue);
        elementHelper.fillLocator(ageElement,ageValue);

        By salaryElement=By.id("salary");
        String salaryValue="2200";
        //salaryElement.sendKeys(salaryValue);
        elementHelper.fillLocator(salaryElement,salaryValue);

        By departmentElement=By.id("department");
        String departmentValue="IT";
        elementHelper.fillLocator(departmentElement,departmentValue);

        By submitElement=By.id("submit");
        elementHelper.clickLocator(submitElement);

        //Validam ca avem 4 randuri in tabel

        By addElementLocator= By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
        List<WebElement> addTableElement=elementHelper.getListElements(addElementLocator);

        //List<WebElement> addTableElement=getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']"));// se identifica noua lista dupa ce s-a realizat modificarile
        Assert.assertEquals(addTableElement.size(),4,"Dimensiunea tabelului nu este 4 "); //compararea valorii initiale cu cea asteptata . In caz ca nu sunt egale, mesajul va fi afisat.

        //validam continutul tabelului

        String rowText= addTableElement.get(3).getText();  // rowText= textul de pe randul 4

        //verifica daca o conditie este adevarata (contine randul 4  elementul completat pentru nume?)
        Assert.assertTrue( rowText.contains(firstNameValue));
        Assert.assertTrue( rowText.contains(lastNameValue));
        Assert.assertTrue( rowText.contains(emailValue));
        Assert.assertTrue( rowText.contains(ageValue));
        Assert.assertTrue( rowText.contains(salaryValue));
        Assert.assertTrue( rowText.contains(departmentValue));

        //modificarea campurilor deja completate
        By editElement= By.id("edit-record-4");
        elementHelper.clickLocator(editElement);

        By editSalaryElement = By.id("salary");
        //editSalaryElement.clear();// golim campul pemnmtru a putea completa noile informatii
        elementHelper.clearLocator(editSalaryElement);
        String editSalaryValue= "2500";
        //editSalaryElement.sendKeys(editSalaryValue);
        elementHelper.fillLocator(editSalaryElement,editSalaryValue);

       By editageElement= By.id("age");
        //editageElement.clear();
        elementHelper.clearLocator(editageElement);
        String editageValue= "28";
        //editageElement.sendKeys(editageValue);
        elementHelper.fillLocator(editageElement,editageValue);

        By editdepartmentElement= By.id("department");
        //editdepartmentElement.clear();
        elementHelper.clearLocator(editdepartmentElement);
        String editdepartmentValue= "HR";
        //editdepartmentElement.sendKeys(editdepartmentValue);
        elementHelper.fillLocator(editdepartmentElement,editdepartmentValue);

        By editSubmitElement= By.id("submit");
        elementHelper.clickLocator(editSubmitElement);

        //validam valorile modificate

        List<WebElement> editlTableElement=getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']"));// se identifica noua lista dupa ce s-a realizat modificarile
        Assert.assertEquals(editlTableElement.size(),4,"Dimensiunea tabelului nu este 4 "); //compararea valorii initiale cu cea asteptata . In caz ca nu sunt egale, mesajul va fi afisat.

        //validam continutul tabelului dupa ce am modificat anumite elemente

        String editrowText= editlTableElement.get(3).getText();  // rowText= textul de pe randul 4

        Assert.assertTrue( editrowText.contains(editageValue));
        Assert.assertTrue( editrowText.contains(editSalaryValue));
        Assert.assertTrue( editrowText.contains(editdepartmentValue));

        //stergerea unui element

        WebElement deleteElement= getDriver().findElement(By.id("delete-record-4"));
        deleteElement.click();

        //validam lista dupa stergerea elementului
        List<WebElement> deleteTableElement=getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']"));// se identifica noua lista dupa ce s-a realizat modificarile
        Assert.assertEquals(deleteTableElement.size(),3,"Dimensiunea tabelului nu este 3 "); //compararea valorii initiale cu cea asteptata . In caz ca nu sunt egale, mesajul va fi afisat.

    }
  }
