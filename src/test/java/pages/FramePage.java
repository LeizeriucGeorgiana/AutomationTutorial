package pages;

import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.FrameLocators;

public class FramePage extends BasePage {


    public FramePage(WebDriver driver) {

        super(driver);
        elementHelper= new ElementHelper(driver);
        frameHelper= new FrameHelper(driver);
    }

    public void interactFirstIFrame(){
        frameHelper.swichToIFrame("frame1");
        LoggerUtility.infoLog("The user switch on the first frame  ");
        LoggerUtility.infoLog("The user print the text from first frame: ");
        elementHelper.printLocatorText(FrameLocators.textElement);
        frameHelper.swichToParentFrame();
        LoggerUtility.infoLog("The user switching back on the parent frame ");
    }

    public void interactSecondIFrame(){
        frameHelper.swichToIFrame("frame2");
        LoggerUtility.infoLog("The user switch on the second frame.");
        LoggerUtility.infoLog("The user print the text from second frame: ");
        elementHelper.printLocatorText(FrameLocators.text2Element);


    }
}
