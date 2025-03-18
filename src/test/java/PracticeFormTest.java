
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.PracticeFormPage;
import sharedData.SharedData;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest()
    {
        IndexPage indexPage= new IndexPage(getDriver());
        indexPage.clickOnFormsMenu();
        indexPage.clickOnFormSubMenu();

        String firstNameValue = " Georgiana";
        String lastNameValue="Leizeriuc";
        String emailValue="petrea.georgiana91@gmail.com";
        //selectarea unui element in functie de cazurile date
        String genderValue= "Female";
        String mobileTelefon="3434357487";
        List<String> subjectValues= Arrays.asList("Arts","Accounting","Maths");
        List<String> hobbiesValue= Arrays.asList("Sports","Reading");

        String pictureValue="src/test/resources/IMG20230521062701.jpg";
        String addressValue="Iasi,Nr45a";
        String stateInputValue= "NCR";
        String cityInputValue= "Noida";
        String expectedMessage="Thanks for submitting the form";

        PracticeFormPage practiceFormPage= new PracticeFormPage(getDriver());
        practiceFormPage.populateEntireForm(firstNameValue,lastNameValue,emailValue,genderValue,mobileTelefon,
                subjectValues,hobbiesValue,pictureValue,addressValue ,stateInputValue,cityInputValue);

        practiceFormPage.validateEntireContent(expectedMessage,firstNameValue,lastNameValue,emailValue,genderValue,mobileTelefon,
                subjectValues,hobbiesValue,pictureValue,addressValue,stateInputValue,cityInputValue);
    }

}