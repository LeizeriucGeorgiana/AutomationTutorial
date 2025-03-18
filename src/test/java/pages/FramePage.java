package pages;

import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
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
        elementHelper.printLocatorText(FrameLocators.textElement);
        frameHelper.swichToParentFrame();
    }

    public void interactSecondIFrame(){
        frameHelper.swichToIFrame("frame2");
        elementHelper.printLocatorText(FrameLocators.text2Element);

    }
}
