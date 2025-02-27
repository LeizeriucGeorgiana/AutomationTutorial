import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class FrameTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementHelper elementHelper= new ElementHelper(getDriver());
        FrameHelper frameHelper= new FrameHelper(getDriver());

        By frameManualElement = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJSlocator(frameManualElement);

        By frameElement = By.xpath("//span[text()='Frames']");
        elementHelper.clickJSlocator(frameElement);

        frameHelper.swichToIFrame("frame1");
        By textElement= By.id("sampleHeading");
        elementHelper.printlocatorText(textElement);

        frameHelper.swichToParentFrame();
        frameHelper.swichToIFrame("frame2");
        By text2Element= By.id("sampleHeading");
        elementHelper.printlocatorText(text2Element);

    }
}
