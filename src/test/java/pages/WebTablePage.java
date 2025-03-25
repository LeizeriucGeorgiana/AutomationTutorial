package pages;

import loggerUtility.LoggerUtility;
import modelObject.WebTableModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.WebTableLocators;

import java.util.List;

public class WebTablePage extends BasePage {

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    public void addNewEntry(WebTableModel testData) {
        elementHelper.validateSizeList(WebTableLocators.initialTableElementLocator, testData.getNewTableSize() - 1);
        int actualSize= testData.getNewTableSize()-1;
        LoggerUtility.infoLog("The modified values have been validated: " +actualSize);
        elementHelper.clickLocator(WebTableLocators.addElement);

        elementHelper.fillLocator(WebTableLocators.firstNameElement, testData.getFirstnameValue());
        LoggerUtility.infoLog("The user fills First Name with value: " + testData.getFirstnameValue());

        elementHelper.fillLocator(WebTableLocators.lastNameElement, testData.getLastNameValue());
        LoggerUtility.infoLog("The user fills Last Name with value: " + testData.getLastNameValue());

        elementHelper.fillLocator(WebTableLocators.userEmailElement, testData.getUserEmailValue());
        LoggerUtility.infoLog("The user fills email adress with value: " + testData.getUserEmailValue());

        elementHelper.fillLocator(WebTableLocators.ageElement, testData.getAgeValue());
        LoggerUtility.infoLog("The user fills age with value: " + testData.getAgeValue());

        elementHelper.fillLocator(WebTableLocators.salaryElement, testData.getSalaryValue());
        LoggerUtility.infoLog("The user fills salary  with value: " + testData.getSalaryValue());

        elementHelper.fillLocator(WebTableLocators.departmentElement, testData.getDepartmentValue());
        LoggerUtility.infoLog("The user fills departament with value: " + testData.getDepartmentValue());

        elementHelper.clickLocator(WebTableLocators.submitElement);
        LoggerUtility.infoLog("The user perform submit button");

        //validăm că avem 4 rânduri în tabel
        elementHelper.validateSizeList(WebTableLocators.addTableElementLocator, testData.getNewTableSize());
        LoggerUtility.infoLog("The user validates the size of the current list: " + testData.getNewTableSize());

        //validăm conținutul tabelului
        List<WebElement> addTableElementList = driver.findElements(WebTableLocators.addTableElementLocator);
        String rowText = addTableElementList.get(testData.getNewTableSize() - 1).getText();
        Assert.assertTrue(rowText.contains(testData.getFirstnameValue()));
        LoggerUtility.infoLog("The user validates the contents of the table for first name  : " + testData.getFirstnameValue());
        Assert.assertTrue(rowText.contains(testData.getLastNameValue()));
        LoggerUtility.infoLog("The user validates the contents of the table for last name  : " + testData.getLastNameValue());
        Assert.assertTrue(rowText.contains(testData.getUserEmailValue()));
        LoggerUtility.infoLog("The user validates the contents of the table for email adress  : " + testData.getUserEmailValue());
        Assert.assertTrue(rowText.contains(testData.getDepartmentValue()));
        LoggerUtility.infoLog("The user validates the contents of the table for department  : " + testData.getDepartmentValue());
        Assert.assertTrue(rowText.contains(testData.getSalaryValue()));
        LoggerUtility.infoLog("The user validates the contents of the table for salary  : " + testData.getSalaryValue());
        Assert.assertTrue(rowText.contains(testData.getAgeValue()));
        LoggerUtility.infoLog("The user validates the contents of the table for age  : " + testData.getAgeValue());
    }

    public void editNewEntry(WebTableModel testData) {
        elementHelper.clickJSLocator(WebTableLocators.editElement);

        elementHelper.clearAndFillLocator(WebTableLocators.editSalaryElement, testData.getEditSalaryValue());
        LoggerUtility.infoLog("The user validates the contents of the table for new salary  : " + testData.getEditSalaryValue());
        elementHelper.clearAndFillLocator(WebTableLocators.editDepartmentElement, testData.getEditDepartmentValue());
        LoggerUtility.infoLog("The user validates the contents of the table for new department  : " + testData.getEditDepartmentValue());
        elementHelper.clearAndFillLocator(WebTableLocators.editAgeElement, testData.getEditAgeValue());
        LoggerUtility.infoLog("The user validates the contents of the table for new age  : " + testData.getEditAgeValue());
        elementHelper.clickLocator(WebTableLocators.editSubmitElement);
        LoggerUtility.infoLog("The user perform submit button after editing.");

        //validăm valorile modificate
        elementHelper.validateSizeList(WebTableLocators.editTableElementLocator, testData.getNewTableSize());
        LoggerUtility.infoLog("The modified values have been validated: " + testData.getNewTableSize());

        //validăm conținutul tabelului
        List<WebElement> editTableElementList = driver.findElements(WebTableLocators.editTableElementLocator);
        LoggerUtility.infoLog("The elements have been identified");
        String editRowText = editTableElementList.get(testData.getNewTableSize() - 1).getText();
        Assert.assertTrue(editRowText.contains(testData.getEditDepartmentValue()));
        LoggerUtility.infoLog("The user validates the contents of the table for new department  : " + testData.getEditDepartmentValue());
        Assert.assertTrue(editRowText.contains(testData.getEditSalaryValue()));
        LoggerUtility.infoLog("The user validates the contents of the table for new salary  : " + testData.getEditSalaryValue());
        Assert.assertTrue(editRowText.contains(testData.getEditAgeValue()));
        LoggerUtility.infoLog("The user validates the contents of the table for new age  : " + testData.getEditAgeValue());
    }

    public void deleteNewEntry(WebTableModel testData) {
        elementHelper.clickJSLocator(WebTableLocators.deleteElement);
        elementHelper.validateSizeList(WebTableLocators.deleteTableElementLocator, testData.getActualTableSize());
        LoggerUtility.infoLog("The user delete the new entry element: " + testData.getActualTableSize());
    }
}