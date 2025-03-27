
    package sharedData;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

    public class SharedData {
        private WebDriver driver;
        private String testName;


        //inainte de fiecare metoda de test se executa aceastA secventa
        @BeforeMethod (alwaysRun = true)
        public void prepareEnviroment(){
            testName=this.getClass().getSimpleName();
            LoggerUtility.startTest(testName);

            driver = new ChromeDriver();//deschidem un browser
            //accesam o pagina web
            driver.get("https://demoqa.com");
            //facem browserul in modul maximize
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @AfterMethod (alwaysRun = true)
        public void clearEnviroment(){
            driver.quit();
            LoggerUtility.finishTest(testName);
        }

        public WebDriver getDriver() {
            return driver;
        }
    }

