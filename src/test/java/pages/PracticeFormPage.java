package pages;

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
        elementHelper.fillLocator(PractiecFormLocator.firstNameElement, testData.getFirstNameValue());//

        elementHelper.fillLocator(PractiecFormLocator.lastNameElement, testData.getLastNameValue());

        elementHelper.fillLocator(PractiecFormLocator.emailElement, testData.getEmailValue());

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

        elementHelper.fillLocator(PractiecFormLocator.mobileElement, testData.getMobileTelefon());

        for (String subject: testData.getSubjectValues()){
            elementHelper.fillPressLocator(PractiecFormLocator.subjectElement,subject, Keys.ENTER);
        }

        List<WebElement> hobbiesElement = elementHelper.getListElements(PractiecFormLocator.hobbiesLocator);
        for (WebElement hobby:hobbiesElement){
            if (testData.getHobbiesValue().contains(hobby.getText())){
                elementHelper.clickJSLocator(hobby);
            }
        }

        File file = new File(testData.getPictureValue());
        elementHelper.fillLocator(PractiecFormLocator.pictureElement, file.getAbsolutePath());

        elementHelper.fillLocator(PractiecFormLocator.adressElement, testData.getAddressValue());

        elementHelper.clickJSLocator(PractiecFormLocator.stateElement);

        elementHelper.fillPressLocator(PractiecFormLocator.stateInput, testData.getStateInputValue(), Keys.ENTER);

        elementHelper.clickJSLocator(PractiecFormLocator.cityInput);

        elementHelper.fillPressLocator(PractiecFormLocator.cityInput, testData.getCityInputValue(), Keys.ENTER);

        elementHelper.clickJSLocator(PractiecFormLocator.submitButton);
    }

    public void validateEntireContent(PracticeFormModel testData){
        elementHelper.validateElementText(PractiecFormLocator.thankYouElement, testData.getExpectedMessage());

        List<WebElement> tableContentList = elementHelper.getListElements(PractiecFormLocator.tableContentListLocator);

        elementHelper.validateElementContainsText(tableContentList.get(0),"Student Name");
        elementHelper.validateElementContainsText(tableContentList.get(0), testData.getFirstNameValue() +' '+ testData.getLastNameValue());

        elementHelper.validateElementContainsText(tableContentList.get(1),"Student Email");
        elementHelper.validateElementContainsText(tableContentList.get(1), testData.getEmailValue());

        elementHelper.validateElementContainsText(tableContentList.get(2),"Gender");
        elementHelper.validateElementContainsText(tableContentList.get(2), testData.getGenderValue());

        elementHelper.validateElementContainsText(tableContentList.get(3),"Mobile");
        elementHelper.validateElementContainsText(tableContentList.get(3), testData.getMobileTelefon());

        elementHelper.validateElementContainsText(tableContentList.get(5),"Subjects");
        String subjectValue = String.join(", ", testData.getSubjectValues());
        elementHelper.validateElementContainsText(tableContentList.get(5),subjectValue);

        elementHelper.validateElementContainsText(tableContentList.get(6),"Hobbies");
        String hobbyValue = String.join(", ", testData.getHobbiesValue());
        elementHelper.validateElementContainsText(tableContentList.get(6),hobbyValue);

        elementHelper.validateElementContainsText(tableContentList.get(7),"Picture");
        File file = new File(testData.getPictureValue());
        String fileName = file.getName();
        elementHelper.validateElementContainsText(tableContentList.get(7),fileName);

        elementHelper.validateElementContainsText(tableContentList.get(8),"Address");
        elementHelper.validateElementContainsText(tableContentList.get(8), testData.getAddressValue());

        elementHelper.validateElementContainsText(tableContentList.get(9),"State and City");
        elementHelper.validateElementContainsText(tableContentList.get(9), testData.getStateInputValue()+' '+ testData.getCityInputValue());
    }
}
