package pages;

import loggerUtility.LoggerUtility;
import modelObject.PracticeFormModel;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageLocators.PractiecFormLocator;
import java.io.File;
import java.util.List;

public class PracticeFormPage extends BasePage{
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }
    public void populateEntireForm(PracticeFormModel testData){
        elementHelper.fillLocator(PractiecFormLocator.firstNameElement, testData.getFirstNameValue());
        LoggerUtility.infoLog("The user fills First Name with value: " + testData.getFirstNameValue());

        elementHelper.fillLocator(PractiecFormLocator.lastNameElement, testData.getLastNameValue());
        LoggerUtility.infoLog("The user fills Last Name with value: " + testData.getLastNameValue());

        elementHelper.fillLocator(PractiecFormLocator.emailElement, testData.getEmailValue());
        LoggerUtility.infoLog("The user fills Email with value: " + testData.getEmailValue());

        List<WebElement> genderElement = elementHelper.getListElements(PractiecFormLocator.genderLocator);

        switch(testData.getGenderValue()){
            case "Male":
                elementHelper.clickJSLocator(genderElement.get(0));
                break;
            case  "Female":
                elementHelper.clickJSLocator(genderElement.get(1));
                break;
            case "Other":
                elementHelper.clickJSLocator(genderElement.get(2));
                break;
            default:
                System.out.println("Nu exista alte valori");
                break;
        }

        LoggerUtility.infoLog("The user fills Gender with value: " + testData.getGenderValue());

        elementHelper.fillLocator(PractiecFormLocator.mobileElement, testData.getMobileTelefon());
        LoggerUtility.infoLog("The user fills Mobile with value: " + testData.getMobileTelefon());

        for (String subject: testData.getSubjectValues()){
            elementHelper.fillPressLocator(PractiecFormLocator.subjectElement,subject, Keys.ENTER);
            LoggerUtility.infoLog("The user fills Subject with value: " + subject);
        }

        List<WebElement> hobbiesElement = elementHelper.getListElements(PractiecFormLocator.hobbiesLocator);
        for (WebElement hobby:hobbiesElement){
            if (testData.getHobbiesValue().contains(hobby.getText())){
                elementHelper.clickJSLocator(hobby);
                LoggerUtility.infoLog("The user checks Hobbies box: " + hobby.getText());
            }
        }

        File file = new File(testData.getPictureValue());
        elementHelper.fillLocator(PractiecFormLocator.pictureElement, file.getAbsolutePath());
        LoggerUtility.infoLog("The user upload on picture element: " + testData.getPictureValue());

        elementHelper.fillLocator(PractiecFormLocator.adressElement, testData.getAddressValue());
        LoggerUtility.infoLog("The user fill adress element: " + testData.getAddressValue());

        elementHelper.clickJSLocator(PractiecFormLocator.stateElement);
        elementHelper.fillPressLocator(PractiecFormLocator.stateInput, testData.getStateInputValue(), Keys.ENTER);
        LoggerUtility.infoLog("The user fill on State Element: " + testData.getStateInputValue());


        elementHelper.clickJSLocator(PractiecFormLocator.cityInput);
        elementHelper.fillPressLocator(PractiecFormLocator.cityInput, testData.getCityInputValue(), Keys.ENTER);
        LoggerUtility.infoLog("The user fill on City Input: " + testData.getCityInputValue());

        elementHelper.clickJSLocator(PractiecFormLocator.submitButton);
        LoggerUtility.infoLog("The user perform submit button");
    }

    public void validateEntireContent(PracticeFormModel testData){
        elementHelper.validateElementText(PractiecFormLocator.thankYouElement, testData.getExpectedMessage());
        LoggerUtility.infoLog("The user validate the presence of the thank you message");

        List<WebElement> tableContentList = elementHelper.getListElements(PractiecFormLocator.tableContentListLocator);

        elementHelper.validateElementContainsText(tableContentList.get(0),"Student Name");
        elementHelper.validateElementContainsText(tableContentList.get(0), testData.getFirstNameValue() +' '+ testData.getLastNameValue());
        LoggerUtility.infoLog("The user validates First Name" + testData.getFirstNameValue() + " and Last Name" + testData.getLastNameValue());

        elementHelper.validateElementContainsText(tableContentList.get(1),"Student Email");
        elementHelper.validateElementContainsText(tableContentList.get(1), testData.getEmailValue());
        LoggerUtility.infoLog("The user validates Email Value" + testData.getEmailValue());


        elementHelper.validateElementContainsText(tableContentList.get(2),"Gender");
        elementHelper.validateElementContainsText(tableContentList.get(2), testData.getGenderValue());
        LoggerUtility.infoLog("The user validate the Gender Value" + testData.getGenderValue());

        elementHelper.validateElementContainsText(tableContentList.get(3),"Mobile");
        elementHelper.validateElementContainsText(tableContentList.get(3), testData.getMobileTelefon());
        LoggerUtility.infoLog("The user validate the Mobile Telephone Value" + testData.getMobileTelefon());

        elementHelper.validateElementContainsText(tableContentList.get(5),"Subjects");
        String subjectValue = String.join(", ", testData.getSubjectValues());
        elementHelper.validateElementContainsText(tableContentList.get(5),subjectValue);
        LoggerUtility.infoLog("The user validate the Subject Value" + testData.getSubjectValues());

        elementHelper.validateElementContainsText(tableContentList.get(6),"Hobbies");
        String hobbyValue = String.join(", ", testData.getHobbiesValue());
        elementHelper.validateElementContainsText(tableContentList.get(6),hobbyValue);
        LoggerUtility.infoLog("The user validates the Hobbies Value" + testData.getHobbiesValue());

        elementHelper.validateElementContainsText(tableContentList.get(7),"Picture");
        File file = new File(testData.getPictureValue());
        String fileName = file.getName();
        elementHelper.validateElementContainsText(tableContentList.get(7),fileName);
        LoggerUtility.infoLog("The user validates Picture uploaded" + testData.getPictureValue());

        elementHelper.validateElementContainsText(tableContentList.get(8),"Address");
        elementHelper.validateElementContainsText(tableContentList.get(8), testData.getAddressValue());
        LoggerUtility.infoLog("The user validates Address Value" + testData.getAddressValue());

        elementHelper.validateElementContainsText(tableContentList.get(9),"State and City");
        elementHelper.validateElementContainsText(tableContentList.get(9), testData.getStateInputValue()+' '+ testData.getCityInputValue());
        LoggerUtility.infoLog("The user validates State value" + testData.getStateInputValue()+ " and  City Value" + testData.getCityInputValue());
    }
}
