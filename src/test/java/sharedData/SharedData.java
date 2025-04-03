
    package sharedData;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

            String remoteEnv= System.getProperty("remote");
            if (Boolean.parseBoolean(remoteEnv)) // convertește string-ul remoteEnv într-o valoare booleană (true sau false).
            {
                ChromeOptions options= new ChromeOptions();
                options.addArguments("--headless=new"); //Se adaugă un argument care instruiește Chrome să ruleze într-un mod headless, adică fără a deschide o fereastră vizibilă de browser (util pentru execuția pe servere sau în medii CI/CD unde nu este necesar să vezi interfața grafică).
                driver = new ChromeDriver(options); //Se creează o instanță a ChromeDriver cu opțiunile specificate anterior, ceea ce înseamnă că se va lansa un browser Chrome într-un mod headless.
            }
            else
            {
                driver = new ChromeDriver();//deschidem un browser
                 }
            //accesam o pagina web
            driver.get("https://demoqa.com");

            //facem browserul in modul maximize
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            LoggerUtility.startTest(testName);
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

