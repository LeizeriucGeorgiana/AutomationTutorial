import helperMethods.ElementHelper;
import helperMethods.TabHelper;
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
    public void testMethod() {

        ElementHelper elementHelper=new ElementHelper(getDriver());
        TabHelper tabHelper=new TabHelper(getDriver());

        By windowsManualElement = By.xpath("//h5[text()='Alerts, Frame & Windows']");// identificare pagina Alerts, Frame & Windows
        elementHelper.clickJSlocator((windowsManualElement));

       By windowElement = By.xpath("//span[text()='Browser Windows']");// identificare pagina Alerte
        elementHelper.clickJSlocator(windowElement);//realizare click pe acea pagina

        //new Tab
        By newTabElement= By.id("tabButton");//
        elementHelper.clickLocator(newTabElement);
        System.out.println("URL curent este:" +getDriver().getCurrentUrl());

        //identificam cate tab-uri sunt deschise
        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);


        //New Window
        By newWindowElement= By.id("windowButton");
        elementHelper.clickLocator(newWindowElement);
        System.out.println("URL curent este:" +getDriver().getCurrentUrl());

        //identificam cate tab-uri sunt deschise
        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);


    }

}
