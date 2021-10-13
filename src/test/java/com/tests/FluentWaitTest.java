package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitTest {
    public static void main(String[] args) throws Exception {
        //Calling method
        TestFluent();
    }

    // create new function
    public static void TestFluent() throws Exception {
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://charmweb.citadelhealth.com.au:493/");
        Thread.sleep(3000);
        driver.findElement(By.name("username")).sendKeys("chadmin");
        driver.findElement(By.name("password")).sendKeys("j06");
        Thread.sleep(3000);
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(3000);

        // By menu_profile = By.id("menu-profile-pic");

        //driver.findElement(By.cssSelector("body")).click();
        //driver.findElement(By.xpath("//body"));
        // driver.findElement(By.xpath("//img[@id='menu-profile-pic']")).click();
        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        Wait<WebDriver> wait;
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(3000))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);
        WebElement menu_profile = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("menu-profile-pic"));
            }
        });
        driver.findElement(By.id("menu-profile-pic")).click();

        // System.out.println(CharmVersion);
        //   Assert.assertEquals("");
        //Assert.assertTrue(CharmVersion.toLowerCase().contains("Charm® Version"+'*'+" -Licence Information"));


    }
}