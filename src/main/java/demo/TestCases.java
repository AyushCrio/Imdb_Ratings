package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.navigate().to("https://www.linkedin.com/");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@autocomplete = \"username\"]")).sendKeys("Username");
        driver.findElement(By.xpath("//input[@autocomplete = \"current-password\"]")).sendKeys("Password");
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/form/div[2]/button")).click(); //Click on sign-in
        driver.findElement(By.xpath("//*[@id=\"ember1530\"]/div[2]")).click(); //Go to your profile
        driver.findElement(By.id("ember1550")).click(); //Move to dashboard
        String postImpression = driver.findElement(By.xpath("//*[@id=\"ember1863\"]/div/div")).getText();
        String profileViews = driver.findElement(By.xpath("//*[@id=\"ember1865\"]/div/div")).getText();
        driver.navigate().to("https://www.linkedin.com/feed/");
        driver.findElement(By.id("ember1911")).click(); //Click to start post
        driver.findElement(By.xpath("//*[@id=\"ember2155\"]/div/div[2]/div[1]/div/div/div/div/div/div/div[1]")).sendKeys("This is my first Post"); //Type something you want to share  
        driver.findElement(By.xpath("//*[@id=\"share-to-linkedin-modal__header\"]/button")).click(); //Click on the drop down and select connection only 
        driver.findElement(By.id("ember2180")).click(); //click to post
        System.out.println("Post Impression" + postImpression);
        System.out.println("Profile Views" + profileViews);
        System.out.println("end Test case: testCase02");
    }


}
