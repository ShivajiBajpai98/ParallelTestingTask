// Run test methods parallel

package paralleltesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ParallelMethods {
    WebDriver webDriver;

    @Test
    void logoTest() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();

        webDriver.get("https://www.atmecs.com/");


        WebElement atmecsLogo = webDriver.findElement(By.xpath("//body/div[@id='header']/div[@id='mysticky-wrap']/div[@id='mysticky-nav']/div[@id='container']/div[@id='logo']/a[1]/img[1]"));

        Assert.assertTrue(atmecsLogo.isDisplayed());

        Thread.sleep(10000);
    }

    @Test
    void homePageTitle() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();

        webDriver.get("https://www.atmecs.com/");


        Assert.assertEquals(webDriver.getTitle(),"Home | ATMECS Global Inc. | Digital Solutions & Product Engineering Services");
        Thread.sleep(10000);


    }
    @AfterMethod
     void tearDown()
     {
         webDriver.quit();
     }
}
