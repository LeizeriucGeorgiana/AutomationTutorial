import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.ArrayList;
import java.util.List;

public class WindowTest extends SharedData {

    public WebDriver getDriver;
    @Test
    public void metodaTest() {

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement windowsManualElement = getDriver().findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));// identificare pagina Alerts, Frame & Windows
        js.executeScript("arguments[0].click();", windowsManualElement); // click pe acea pagina

        WebElement windowElement = getDriver().findElement(By.xpath("//span[text()='Browser Windows']"));// identificare pagina Alerte
        js.executeScript("arguments[0].click();", windowElement);//realizare click pe acea pagina

        WebElement newTabElement= getDriver().findElement(By.id("tabButton"));//
        newTabElement.click();

        System.out.println("URL curent este:" +getDriver().getCurrentUrl());

        //identificam cate tab-uri sunt deschise
        List<String> tabs= new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1)); //specificam tab-ul pe care il vrem
        System.out.println("URL curent este:" +getDriver().getCurrentUrl());

        //cum inchidem tab-ul curent
        getDriver().close(); //inchide tab-ul curent
        //getgetDriver()().quit(); //inchide browserul, se pune la finalul testului pentru a nu ramene cu paginile deschise
        getDriver().switchTo().window(tabs.get(0));
        System.out.println("URL curent este: " + getDriver().getCurrentUrl());

        WebElement newWindowElement= getDriver().findElement(By.id("windowButton"));
        newWindowElement.click();

        System.out.println("URL curent este:" +getDriver().getCurrentUrl());

        //identificam cate tab-uri sunt deschise
        List<String> windows= new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windows.get(1)); //specificam tab-ul pe care il vrem
        System.out.println("URL curent este:" +getDriver().getCurrentUrl());

        //cum inchidem tab-ul curent
        getDriver().close(); //inchide tab-ul curent
        //getgetDriver().quit(); //inchide browserul, se pune la finalul testului pentru a nu ramene cu paginile deschise
        getDriver().switchTo().window(tabs.get(0));
        System.out.println("URL curent este: " + getDriver().getCurrentUrl());



    }

}
