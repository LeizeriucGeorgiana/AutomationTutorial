package helperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class TabHelper {

    private WebDriver driver;

    public TabHelper(WebDriver driver) {
        this.driver = driver;
    }
    public void switchToSpecificTab(int index){
        List<String> windows= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index)); //specificam tab-ul pe care il vrem
        System.out.println("URL curent este:" +driver.getCurrentUrl());
    }

    public void closeCurrentTab(){
        driver.close();
    }
}
