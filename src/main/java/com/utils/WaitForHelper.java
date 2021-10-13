package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitForHelper {

    //Initialize the driver
    public WebDriver driver;

    public WaitForHelper(WebDriver driver) {
        this.driver = driver;
    }

    /*
            public void implicitwait(){
                // #Todo We need to change or get it from the Property
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            }
    */

    //fluent wait
    public void fluentWait(final By elementIdentifier) {

        Wait<WebDriver> wait;
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(3000))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);
        WebElement identifier = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(elementIdentifier);
            }
        });
    }


    // Presence Of Element
    public WebElement presenceOfTheElement(final By elementIdentifier) {
        WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(elementIdentifier));
        return element;
    }

    // elementToBeClickable
    public WebElement elementToBeClickable(final By elementIdentifier) {
        WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(elementIdentifier));
        return element;
    }


}