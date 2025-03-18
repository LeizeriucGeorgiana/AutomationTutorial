package pageLocators;

import org.openqa.selenium.By;

public class PractiecFormLocator {
    public static final By firstNameElement=By.xpath("//input[@placeholder='First Name']");
    public static final By lastNameElement=By.xpath("//input[@placeholder='Last Name']");
    public static final By emailElement=By.xpath("//input[@placeholder='name@example.com']");
    public static final By genderLocator=By.xpath("//label[contains(@for,'gender-radio')]");
    public static final By mobileElement=By.xpath("//input[@placeholder='Mobile Number']");
    public static final By subjectElement=By.id("subjectsInput");
    public static final By hobbiesLocator= By.xpath("//div[@id='hobbiesWrapper']//label[@class='custom-control-label']");
    public static final By pictureElement = By.cssSelector("input[type='file']");
    public static final By adressElement = By.xpath("//textarea[@id='currentAddress']");
    public static final By stateElement= By.cssSelector("#state");
    public static final By stateInput = By.cssSelector("#react-select-3-input");
    public static final By cityInput=By.cssSelector("#react-select-4-input");
    public static final By submitButton=By.cssSelector("#submit");
    public static final By thankYouElement=By.cssSelector("#example-modal-sizes-title-lg");
    public static final By tableContentListLocator=By.cssSelector(".table>tbody>tr");

}
