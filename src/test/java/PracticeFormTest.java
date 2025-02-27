import helperMethods.ElementHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest()
    {

       // JavascriptExecutor js = (JavascriptExecutor)getDriver();
        ElementHelper elementHelper=new ElementHelper(getDriver());

       // WebElement elementsManuForm=getDriver().findElement(By.xpath("//h5[text()='Forms']"));
       // js.executeScript("arguments[0].click();",elementsManuForm);
        By elementsManuForm=By.xpath("//h5[text()='Forms']");
        elementHelper.clickJSlocator(elementsManuForm);

        //WebElement practiceForm=getDriver().findElement(By.xpath("//span[text()='Practice Form']"));
        //js.executeScript("arguments[0].click();",practiceForm);
        By practiceForm=By.xpath("//span[text()='Practice Form']");
        elementHelper.clickJSlocator(practiceForm);

        //WebElement firstNameElement=getDriver().findElement(By.xpath("//input[@placeholder='First Name']")) ;
        By firstNameElement=By.xpath("//input[@placeholder='First Name']");
        String firstNameValue = " Georgiana";
        elementHelper.fillLocator(firstNameElement,firstNameValue);

        //WebElement lastNameElement=getDriver().findElement(By.xpath("//input[@placeholder='Last Name']"));
        By lastNameElement=By.xpath("//input[@placeholder='Last Name']");
        String lastNameValue="Leizeriuc";
        //lastNameElement.sendKeys(lastNameValue);
        elementHelper.fillLocator(lastNameElement,lastNameValue);

        By emailElement=By.xpath("//input[@placeholder='name@example.com']");
        String emailValue="petrea.georgiana91@gmail.com";
       // emailElement.sendKeys(emailValue);
        elementHelper.fillLocator(emailElement,emailValue);


        //selectarea unui element in functie de cazurile date
        String genderValue= "Female";

        By genderLocator=By.xpath("//label[contains(@for,'gender-radio')]");
        // List<WebElement> genderElement=getDriver().findElements(By.xpath("//input[@name='gender']"));
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

        //WebElement subjectElement=getDriver().findElement(By.id("subjectsInput"));
        By subjectElement=By.id("subjectsInput");
        List<String> subjectValues= Arrays.asList("Arts","Accounting","Maths");
        for(String subject:subjectValues){
           // subjectElement.sendKeys(subject);
           // subjectElement.sendKeys(Keys.ENTER); //inserare automata enter
            elementHelper.fillPressLocator(subjectElement,subject,Keys.ENTER);
        }

        By hobbiesLocator= By.xpath("//div[@id='hobbiesWrapper']//label[@class='custom-control-label']");
        List<WebElement> hobbiesElement=elementHelper.getListElements(hobbiesLocator);
        //List<WebElement> hobbiesElement=getDriver().findElements(By.xpath("//div[@id='hobbiesWrapper']//label[@class='custom-control-label']"));
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
        //pictureElement.sendKeys(file.getAbsolutePath());
        elementHelper.fillLocator(pictureElement,file.getAbsolutePath());

        //WebElement adressElement = getDriver().findElement(By.xpath("//textarea[@id='currentAddress']"));
        By adressElement = By.xpath("//textarea[@id='currentAddress']");
        String adressValue="Iasi";
       // adressElement.sendKeys(adressValue);
        elementHelper.fillPressLocator(adressElement,adressValue,Keys.ENTER);

       // WebElement stateElement= getDriver().findElement(By.cssSelector("#state"));
        //js.executeScript("arguments[0].click();", stateElement);
       By stateElement= By.cssSelector("#state");
        elementHelper.clickJSlocator(stateElement);

        By stateInput = By.cssSelector("#react-select-3-input");
        String stateValue= "NCR";
        //stateInput.sendKeys(stateValue);
        //stateInput.sendKeys(Keys.ENTER);
        elementHelper.fillPressLocator(stateInput,stateValue,Keys.ENTER);

        By cityInput=By.cssSelector("#react-select-4-input");
        String cityValue= "Noida";
        //cityInput.sendKeys(cityValue);
       // cityInput.sendKeys(Keys.ENTER);
        elementHelper.fillPressLocator(cityInput,cityValue,Keys.ENTER);

        By submitButton=By.cssSelector("#submit");
        elementHelper.clickJSlocator(submitButton);

        //wait explicit
        //WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));//
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#example-modal-sizes-title-lg")));
        // String actualMessage=thankYouElement.getText();
        //Assert.assertEquals(actualMessage,expectedMessage);

       By thankYouElement=By.cssSelector("#example-modal-sizes-title-lg");
        String expectedMessage="Thanks for submitting the form";
        elementHelper.validateElementText(thankYouElement,expectedMessage);

       By tableContentListLocator=By.cssSelector(".table>tbody>tr");
        List<WebElement> tableContentList=elementHelper.getListElements(tableContentListLocator);

        elementHelper.validateElementContainsText(tableContentList.get(0),"Student Name");
        elementHelper.validateElementContainsText(tableContentList.get(0),firstNameValue+' '+lastNameValue);

        //Assert.assertTrue(tableContentList.get(0).getText().contains("Student Name"));
        //Assert.assertTrue(tableContentList.get(0).getText().contains(firstNameValue+' '+lastNameValue));

        elementHelper.validateElementContainsText(tableContentList.get(1),"Student Email");
        elementHelper.validateElementContainsText(tableContentList.get(1),emailValue);

        //Assert.assertTrue(tableContentList.get(1).getText().contains("Student Email"));
       // Assert.assertTrue(tableContentList.get(1).getText().contains(emailValue));

        elementHelper.validateElementContainsText(tableContentList.get(2),"Gender");
        elementHelper.validateElementContainsText(tableContentList.get(2),genderValue);

       // Assert.assertTrue(tableContentList.get(2).getText().contains("Gender"));
        //Assert.assertTrue(tableContentList.get(2).getText().contains(genderValue));

        elementHelper.validateElementContainsText(tableContentList.get(3),"Mobil");
        elementHelper.validateElementContainsText(tableContentList.get(3),mobileTelefon);

       // Assert.assertTrue(tableContentList.get(3).getText().contains("Mobil"));
       // Assert.assertTrue(tableContentList.get(3).getText().contains(mobileTelefon));

        elementHelper.validateElementContainsText(tableContentList.get(5),"Subjects");
        String subjectValue = String.join(", ", subjectValues);
        elementHelper.validateElementContainsText(tableContentList.get(5),subjectValue);

        //Assert.assertTrue(tableContentList.get(5).getText().contains("Subjects"));
       // Assert.assertTrue(tableContentList.get(5).getText().contains(subjectValue));

        elementHelper.validateElementContainsText(tableContentList.get(6),"Hobbies");
        String hobbyValue = String.join(", ", hobbiesValue);
        elementHelper.validateElementContainsText(tableContentList.get(6),hobbyValue);

        //Assert.assertTrue(tableContentList.get(6).getText().contains("Hobbies"));
        //Assert.assertTrue(tableContentList.get(6).getText().contains(hobbyValue));

        elementHelper.validateElementContainsText(tableContentList.get(7),"Picture");
        String fileName= file.getName();
        elementHelper.validateElementContainsText(tableContentList.get(7),fileName);

        //Assert.assertTrue(tableContentList.get(7).getText().contains("Picture"));
       // Assert.assertTrue(tableContentList.get(7).getText().contains(fileName));

        elementHelper.validateElementContainsText(tableContentList.get(8),"Address");
        elementHelper.validateElementContainsText(tableContentList.get(8),adressValue);

        //Assert.assertTrue(tableContentList.get(8).getText().contains("Address"));
        //Assert.assertTrue(tableContentList.get(8).getText().contains(adressValue));

        //Assert.assertTrue(tableContentList.get(9).getText().contains("State and City"));
        //Assert.assertTrue(tableContentList.get(9).getText().contains(stateValue+' '+cityValue));

        elementHelper.validateElementContainsText(tableContentList.get(9),"State and City");
        elementHelper.validateElementContainsText(tableContentList.get(9),stateValue+' '+cityValue);
    }

}
