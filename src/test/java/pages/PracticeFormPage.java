package pages;

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

    public void populateEntireForm(String firstNameValue,String lastNameValue,String emailValue,
                                   String genderValue,String mobileTelefon,List<String> subjectValues,List<String> hobbyValues,
                                   String pictureValue,String addressValue,String stateInputValue,String cityInputValue){
        elementHelper.fillLocator(PractiecFormLocator.firstNameElement,firstNameValue);

        elementHelper.fillLocator(PractiecFormLocator.lastNameElement,lastNameValue);

        elementHelper.fillLocator(PractiecFormLocator.emailElement,emailValue);

        List<WebElement> genderElement = elementHelper.getListElements(PractiecFormLocator.genderLocator);
        switch(genderValue){
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

        elementHelper.fillLocator(PractiecFormLocator.mobileElement,mobileTelefon);

        for (String subject:subjectValues){
            elementHelper.fillPressLocator(PractiecFormLocator.subjectElement,subject, Keys.ENTER);
        }

        List<WebElement> hobbiesElement = elementHelper.getListElements(PractiecFormLocator.hobbiesLocator);
        for (WebElement hobby:hobbiesElement){
            if (hobbyValues.contains(hobby.getText())){
                elementHelper.clickJSLocator(hobby);
            }
        }

        File file = new File(pictureValue);
        elementHelper.fillLocator(PractiecFormLocator.pictureElement, file.getAbsolutePath());

        elementHelper.fillLocator(PractiecFormLocator.adressElement,addressValue);

        elementHelper.clickJSLocator(PractiecFormLocator.stateElement);

        elementHelper.fillPressLocator(PractiecFormLocator.stateInput,stateInputValue,Keys.ENTER);

        elementHelper.clickJSLocator(PractiecFormLocator.cityInput);

        elementHelper.fillPressLocator(PractiecFormLocator.cityInput,cityInputValue,Keys.ENTER);

        elementHelper.clickLocator(PractiecFormLocator.submitButton);
    }

    public void validateEntireContent(String expectedMessage,String firstNameValue,String lastNameValue,String emailValue,
                                      String genderValue,String mobileValue,List<String> subjectValues,
                                      List<String> hobbyValues,String uploadFile,String addressValue,
                                      String stateInputValue, String cityInputValue){
        elementHelper.validateElementText(PractiecFormLocator.thankYouElement,expectedMessage);


        List<WebElement> tableContentList = elementHelper.getListElements(PractiecFormLocator.tableContentListLocator);

        elementHelper.validateElementContainsText(tableContentList.get(0),"Student Name");
        elementHelper.validateElementContainsText(tableContentList.get(0),firstNameValue+' '+lastNameValue);

        elementHelper.validateElementContainsText(tableContentList.get(1),"Student Email");
        elementHelper.validateElementContainsText(tableContentList.get(1),emailValue);

        elementHelper.validateElementContainsText(tableContentList.get(2),"Gender");
        elementHelper.validateElementContainsText(tableContentList.get(2),genderValue);

        elementHelper.validateElementContainsText(tableContentList.get(3),"Mobile");
        elementHelper.validateElementContainsText(tableContentList.get(3),mobileValue);

        elementHelper.validateElementContainsText(tableContentList.get(5),"Subjects");
        String subjectValue = String.join(", ", subjectValues);
        elementHelper.validateElementContainsText(tableContentList.get(5),subjectValue);

        elementHelper.validateElementContainsText(tableContentList.get(6),"Hobbies");
        String hobbyValue = String.join(", ", hobbyValues);
        elementHelper.validateElementContainsText(tableContentList.get(6),hobbyValue);

        elementHelper.validateElementContainsText(tableContentList.get(7),"Picture");
        File file = new File(uploadFile);
        String fileName = file.getName();
        elementHelper.validateElementContainsText(tableContentList.get(7),fileName);

        elementHelper.validateElementContainsText(tableContentList.get(8),"Address");
        elementHelper.validateElementContainsText(tableContentList.get(8),addressValue);

        elementHelper.validateElementContainsText(tableContentList.get(9),"State and City");
        elementHelper.validateElementContainsText(tableContentList.get(9),stateInputValue+' '+cityInputValue);
    }
}
