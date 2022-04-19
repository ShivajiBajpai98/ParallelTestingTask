package paralleltesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ParallelClass
{
    WebDriver webDriver;
    @Test
    void loginTest() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();

        webDriver.get("https://demoqa.com/login");
        webDriver.manage().window().maximize();

        webDriver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Shivaji_Bajpai");
        webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys("@Qwerty12345");
        Thread.sleep(10000);
       WebElement button= webDriver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[4]/div[1]/button[1]"));
       button.click();
        Thread.sleep(10000);
        webDriver.getTitle();
        Assert.assertEquals(webDriver.getTitle(),"ToolsQA");


        Thread.sleep(10000);
    }
    @AfterMethod
    void tearDown()
    {
        webDriver.quit();
    }
}
