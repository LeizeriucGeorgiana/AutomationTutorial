package modelObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
//aceasta clasa reprezinta forma fisierului

public class PracticeFormModel {
    private String firstNameValue;
    private String lastNameValue;
    private String emailValue;
    private String genderValue;
    private String mobileTelefon;
    private List<String> subjectValues;
    private List<String> hobbiesValue;
    private String pictureValue;
    private String addressValue;
    private String stateInputValue;
    private String cityInputValue;
    private String expectedMessage;

    //Constructorul citește fișierul JSON specificat de calea jsonFilePath și va  popula automat obiectul PracticeFormModel cu valorile din fișier.
    //Utilizarea readerForUpdating() permite ca obiectul curent (this) să fie actualizat, în loc să creeze un obiect complet nou.
    //readValue(new File(jsonFilePath)): este metoda care efectiv citește fișierul JSON și îl deserializa într-un obiect Java.
    // În acest caz, fișierul JSON este specificat de calea jsonFilePath, care este transformată într-un obiect File (prin new File(jsonFilePath)).

    public PracticeFormModel(String jsonFilePath){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.readerForUpdating(this).readValue(new File(jsonFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load JSON file: " + jsonFilePath, e);
        }
    }


    public String getFirstNameValue() {
        return firstNameValue;
    } //citire si afisare dinamica a variabilei

    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
    }

    public String getLastNameValue() {
        return lastNameValue;
    }

    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
    }

    public String getEmailValue() {
        return emailValue;
    }

    public void setEmailValue(String emailValue) {
        this.emailValue = emailValue;
    }

    public String getGenderValue() {
        return genderValue;
    }

    public void setGenderValue(String genderValue) {
        this.genderValue = genderValue;
    }

    public String getMobileTelefon() {
        return mobileTelefon;
    }

    public void setMobileTelefon(String mobileTelefon) {
        this.mobileTelefon = mobileTelefon;
    }

    public List<String> getSubjectValues() {
        return subjectValues;
    }

    public void setSubjectValues(List<String> subjectValues) {
        this.subjectValues = subjectValues;
    }

    public List<String> getHobbiesValue() {
        return hobbiesValue;
    }

    public void setHobbiesValue(List<String> hobbiesValue) {
        this.hobbiesValue = hobbiesValue;
    }

    public String getPictureValue() {
        return pictureValue;
    }

    public void setPictureValue(String pictureValue) {
        this.pictureValue = pictureValue;
    }

    public String getAddressValue() {
        return addressValue;
    }

    public void setAddressValue(String addressValue) {
        this.addressValue = addressValue;
    }

    public String getStateInputValue() {
        return stateInputValue;
    }

    public void setStateInputValue(String stateInputValue) {
        this.stateInputValue = stateInputValue;
    }

    public String getCityInputValue() {
        return cityInputValue;
    }

    public void setCityInputValue(String cityInputValue) {
        this.cityInputValue = cityInputValue;
    }

    public String getExpectedMessage() {
        return expectedMessage;
    }

    public void setExpectedMessage(String expectedMessage) {
        this.expectedMessage = expectedMessage;
    }
}
