package helperMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ElementHelper {
    private WebDriver driver;

    public ElementHelper(WebDriver driver) {

        this.driver = driver;
    }
    private void waitForVisible(By locator){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    private void waitForVisible(WebElement locator){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    private void waitForVisibleList(By locator){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    private void waitForPresenceList(By locator){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void clickJSlocator(By locator){
        waitForVisible(locator);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(locator)); // click pe acea pagina

    }

    public void clickLocator(By locator){
        waitForVisible(locator);
        driver.findElement(locator).click();
    }

    public void printlocatorText(By locator){
        waitForVisible(locator);
        System.out.println(driver.findElement(locator).getText());
    }

    public void fillLocator(By locator, String value){
        waitForVisible(locator);
        driver.findElement(locator).sendKeys(value);
    }

    public void clickJSlocator(WebElement locator){
        waitForVisible(locator);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", locator ); // click pe acea pagina

    }

    public List<WebElement> getListElements(By locator){
        waitForPresenceList(locator);
        return driver.findElements(locator);
    }

    public void fillPressLocator(By locator, String value, Keys key){
        waitForVisible(locator);
        driver.findElement(locator).sendKeys(value);
        driver.findElement(locator).sendKeys(key);
    }

    public void clearLocator(By locator){
        waitForVisible(locator);
        driver.findElement(locator).clear();
    }

    public void validateElementText(By locator, String expectedMessage){
        waitForVisible(locator);
        String actualMessage=driver.findElement(locator).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    public void validateElementContainsText(WebElement element,String value){
        waitForVisible(element);
        Assert.assertTrue(element.getText().contains(value));
    }



}
