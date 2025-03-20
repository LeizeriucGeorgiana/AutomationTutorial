package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Tema {
    public WebDriver driver;
    public WebDriver driver1;
    @Test
    public void tema1Test() throws InterruptedException {
        driver= new ChromeDriver();
        driver.get("https://www.automationtesting.co.uk/contactForm.html");
        driver.manage().window().maximize();

        driver1= new ChromeDriver();
        driver1.get("https://www.automationtesting.co.uk/calculator.html");
        driver1.manage().window().maximize();

        WebElement firstNameElement=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        String firstNameValue= "Georgiana";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement= driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastNameValue= "Leizeriuc";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement=driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
        String emailValue= "test@gmail";
        emailElement.sendKeys(emailValue);

        WebElement comentElement= driver.findElement(By.xpath("//textarea[@placeholder='Comments']"));
        String commentValue= " Completare finalizata";
        comentElement.sendKeys(commentValue);

        WebElement submitElement=driver.findElement(By.xpath("(//input[@value='SUBMIT'])"));
        submitElement.click();

        //adunare

        driver1.findElement(By.xpath("//input[@value='2']")).click();
        driver1.findElement(By.xpath("//input[@value='+']")).click();
        driver1.findElement(By.xpath("//input[@value='3']")).click();
        driver1.findElement(By.xpath("//input[@value='=']")).click();
        Thread.sleep(2000);

        //stergem rezultatul accesand butonul c din calculator

        driver1.findElement(By.xpath("//input[@value='c']")).click();

        //inmultire
        driver1.findElement(By.xpath("//input[@value='4']")).click();
        driver1.findElement(By.xpath("//input[@value='*']")).click();
        driver1.findElement(By.xpath("//input[@value='3']")).click();
        driver1.findElement(By.xpath("//input[@value='=']")).click();
        Thread.sleep(2000);

        driver1.findElement(By.xpath("//input[@value='c']")).click();

        //scadere

        driver1.findElement(By.xpath("//input[@value='9']")).click();
        driver1.findElement(By.xpath("//input[@value='-']")).click();
        driver1.findElement(By.xpath("//input[@value='5']")).click();
        driver1.findElement(By.xpath("//input[@value='=']")).click();
    }
}
