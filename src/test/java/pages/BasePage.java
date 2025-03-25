package pages;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
import helperMethods.TabHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;

public class BasePage {
    //pentru a fi tinute in interiorul acestui pachet
    protected WebDriver driver;
    protected AlertHelper alertHelper;
    protected ElementHelper elementHelper;
    protected FrameHelper frameHelper;
    protected  TabHelper tabHelper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        alertHelper= new AlertHelper(driver);
        LoggerUtility.infoLog("AlertHelper initialized");
        elementHelper=new ElementHelper(driver);
        LoggerUtility.infoLog("ElementHelper initialized");
        frameHelper=new FrameHelper(driver);
        LoggerUtility.infoLog("FrameHelper initialized");
        tabHelper= new TabHelper(driver);
        LoggerUtility.infoLog("TabHelper initialized");
    }
}
