import helperMethods.ElementHelper;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import sharedData.SharedData;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest()
    {

        ElementHelper elementHelper=new ElementHelper(getDriver());

        By elementsManuForm=By.xpath("//h5[text()='Forms']");
        elementHelper.clickJSlocator(elementsManuForm);

        By practiceForm=By.xpath("//span[text()='Practice Form']");
        elementHelper.clickJSlocator(practiceForm);

        By firstNameElement=By.xpath("//input[@placeholder='First Name']");
        String firstNameValue = " Georgiana";
        elementHelper.fillLocator(firstNameElement,firstNameValue);

        By lastNameElement=By.xpath("//input[@placeholder='Last Name']");
        String lastNameValue="Leizeriuc";
        elementHelper.fillLocator(lastNameElement,lastNameValue);

        By emailElement=By.xpath("//input[@placeholder='name@example.com']");
        String emailValue="petrea.georgiana91@gmail.com";
        elementHelper.fillLocator(emailElement,emailValue);

        //selectarea unui element in functie de cazurile date
        String genderValue= "Female";
        By genderLocator=By.xpath("//label[contains(@for,'gender-radio')]");
        List<WebElement>genderElement = elementHelper.getListElements(genderLocator);
        switch (genderValue){
            case "Male":
                elementHelper.clickJSlocator(genderElement.get(0)); // click "fortat"
                break;
            case "Female":

                elementHelper.clickJSlocator(genderElement.get(1));
                break;
            case "Other":

                elementHelper.clickJSlocator(genderElement.get(3));
                break;

            default:
                System.out.println("Nu exista alte valori");
                break;
        }

        By mobileElement=By.xpath("//input[@placeholder='Mobile Number']");
        String mobileTelefon="3434357487";
        elementHelper.fillLocator(mobileElement,mobileTelefon);

        By subjectElement=By.id("subjectsInput");
        List<String> subjectValues= Arrays.asList("Arts","Accounting","Maths");
        for(String subject:subjectValues){
            elementHelper.fillPressLocator(subjectElement,subject,Keys.ENTER);
        }

        By hobbiesLocator= By.xpath("//div[@id='hobbiesWrapper']//label[@class='custom-control-label']");
        List<WebElement> hobbiesElement=elementHelper.getListElements(hobbiesLocator);
        List<String> hobbiesValue= Arrays.asList("Sports","Reading");
        for(WebElement hobby:hobbiesElement){
            if(hobbiesValue.contains(hobby.getText())){
                elementHelper.clickJSlocator(hobby);
            }
        }

        //inserarea unui fisier
      By pictureElement = By.cssSelector("input[type='file']");
        String pictureValue="src/test/resources/IMG20230521062701.jpg";
        File file = new File(pictureValue);
        elementHelper.fillLocator(pictureElement,file.getAbsolutePath());

        By adressElement = By.xpath("//textarea[@id='currentAddress']");
        String adressValue="Iasi";
        elementHelper.fillPressLocator(adressElement,adressValue,Keys.ENTER);

       By stateElement= By.cssSelector("#state");
        elementHelper.clickJSlocator(stateElement);

        By stateInput = By.cssSelector("#react-select-3-input");
        String stateValue= "NCR";
        elementHelper.fillPressLocator(stateInput,stateValue,Keys.ENTER);

        By cityInput=By.cssSelector("#react-select-4-input");
        String cityValue= "Noida";
        elementHelper.fillPressLocator(cityInput,cityValue,Keys.ENTER);

        By submitButton=By.cssSelector("#submit");
        elementHelper.clickJSlocator(submitButton);
        
       By thankYouElement=By.cssSelector("#example-modal-sizes-title-lg");
        String expectedMessage="Thanks for submitting the form";
        elementHelper.validateElementText(thankYouElement,expectedMessage);

       By tableContentListLocator=By.cssSelector(".table>tbody>tr");
        List<WebElement> tableContentList=elementHelper.getListElements(tableContentListLocator);

        elementHelper.validateElementContainsText(tableContentList.get(0),"Student Name");
        elementHelper.validateElementContainsText(tableContentList.get(0),firstNameValue+' '+lastNameValue);

        elementHelper.validateElementContainsText(tableContentList.get(1),"Student Email");
        elementHelper.validateElementContainsText(tableContentList.get(1),emailValue);

        elementHelper.validateElementContainsText(tableContentList.get(2),"Gender");
        elementHelper.validateElementContainsText(tableContentList.get(2),genderValue);

        elementHelper.validateElementContainsText(tableContentList.get(3),"Mobil");
        elementHelper.validateElementContainsText(tableContentList.get(3),mobileTelefon);

        elementHelper.validateElementContainsText(tableContentList.get(5),"Subjects");
        String subjectValue = String.join(", ", subjectValues);
        elementHelper.validateElementContainsText(tableContentList.get(5),subjectValue);

        elementHelper.validateElementContainsText(tableContentList.get(6),"Hobbies");
        String hobbyValue = String.join(", ", hobbiesValue);
        elementHelper.validateElementContainsText(tableContentList.get(6),hobbyValue);

        elementHelper.validateElementContainsText(tableContentList.get(7),"Picture");
        String fileName= file.getName();
        elementHelper.validateElementContainsText(tableContentList.get(7),fileName);

        elementHelper.validateElementContainsText(tableContentList.get(8),"Address");
        elementHelper.validateElementContainsText(tableContentList.get(8),adressValue);

        elementHelper.validateElementContainsText(tableContentList.get(9),"State and City");
        elementHelper.validateElementContainsText(tableContentList.get(9),stateValue+' '+cityValue);
    }

}