package helperMethods;

import org.openqa.selenium.WebDriver;

public class FrameHelper {
    private WebDriver driver;
    public FrameHelper(WebDriver driver){
        this.driver=driver;
    }

    public void swichToIFrame(String value){
        driver.switchTo().frame((value));
    }

    public void swichToParentFrame(){
        driver.switchTo().parentFrame();
    }
}
