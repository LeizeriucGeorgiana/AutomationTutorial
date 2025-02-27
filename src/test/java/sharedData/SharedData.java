
    package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

    public class SharedData {
        //public WebDriver driver;.
        private WebDriver driver;
        //inainte de fiecare metoda de test se executa aceastA secventa

        @BeforeMethod
        public void prepareEnviroment(){
            driver = new ChromeDriver();//deschidem un browser
            //accesam o pagina web
            driver.get("https://demoqa.com");
            //facem browserul in modul maximize
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @AfterMethod
        public void clearEnviroment(){

            //driver.quit();
        }

        public WebDriver getDriver() {
            return driver;
        }
    }

