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
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        
        driver.switchTo().frame("frame-top"); //switched to frame top
        driver.switchTo().frame("frame-left");
        String frameLeft = driver.findElement(By.xpath("//*[contains(text(), 'LEFT')]")).getText();
        
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top"); //switched to frame top
        driver.switchTo().frame("frame-middle");
        String frameMiddle = driver.findElement(By.xpath("//*[contains(text(), 'MIDDLE')]")).getText();

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top"); //switched to frame top
        driver.switchTo().frame("frame-right");
        String frameRight = driver.findElement(By.xpath("//*[contains(text(), 'RIGHT')]")).getText();

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom"); //switched to frame bottom
        String frameBottom = driver.findElement(By.xpath("//*[contains(text(), 'BOTTOM')]")).getText();

        driver.switchTo().defaultContent();

        System.out.println("Frame-Left text = " + frameLeft + " Frame-Middle text = " + frameMiddle + " Frame-Right text = " + frameRight + " Frame-BOTTOM text = " + frameBottom);
        System.out.println("end Test case: testCase02");
    }


}
