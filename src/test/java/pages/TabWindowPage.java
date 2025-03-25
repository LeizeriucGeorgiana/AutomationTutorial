package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.TabWindowLocators;

public class TabWindowPage extends BasePage {
     public TabWindowPage(WebDriver driver) {
         super(driver);
     }

    public void interactWithTab(){

        elementHelper.clickLocator(TabWindowLocators.newTabElement);
        LoggerUtility.infoLog("The user clicks on Tab Element Menu");
        System.out.println("Url-ul curent este: "+driver.getCurrentUrl());
        tabHelper.switchToSpecificTab(1);
        LoggerUtility.infoLog("The user switch to the first tab ");
        tabHelper.closeCurrentTab();
        LoggerUtility.infoLog("The user close to the current tab ");
        tabHelper.switchToSpecificTab(0);
        LoggerUtility.infoLog("The user switching back to the initial tab ");
    }

    public void interactWithWindow(){
        elementHelper.clickJSLocator(TabWindowLocators.newWindowElement);
        LoggerUtility.infoLog("The user clicks on  Window Element Menu");
        System.out.println("Url-ul curent este: " +driver.getCurrentUrl());
        tabHelper.switchToSpecificTab(1);
        LoggerUtility.infoLog("The user switch to the first window");
        tabHelper.closeCurrentTab();
        LoggerUtility.infoLog("The user close to the current window ");
        tabHelper.switchToSpecificTab(0);
        LoggerUtility.infoLog("The user switching back to the initial window ");

    }

}
