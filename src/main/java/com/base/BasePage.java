package com.base;

import com.utils.WaitForHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BasePage {

    //Initialize the driver
    protected WebDriver driver;

    //Constructor > the driver being passed, get set
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigation
    public void goToURL(String url) {
        driver.get(url);
    }

    //Fluent Wait
    public void fluentWait(By elementLocation) {
        new WaitForHelper(driver).fluentWait(elementLocation);
    }

    //get Page title
    public String getPageTitle(By elementLocation) {
        return driver.getTitle();
    }

    // Wait for Element
    public void waitForElementToAppear(By elementLocation) {
        new WaitForHelper(driver).presenceOfTheElement(elementLocation);
    }

    // Wait for Element to clickable
    public void waitForElementToBeClickable(By elementLocation) {
        new WaitForHelper(driver).elementToBeClickable(elementLocation);
    }

/*
    // Wait for Time
    public void waitForLoading(){
        new WaitForHelper(driver).implicitwait();
    }
*/

    // Click
    public void click(By elementLocation) {

        waitForElementToBeClickable(elementLocation);
        driver.findElement(elementLocation).click();
    }

    // WriteText
    public void writeText(By elementLocation, String text) {

        waitForElementToBeClickable(elementLocation);
        driver.findElement(elementLocation).clear();
        driver.findElement(elementLocation).sendKeys(text);
    }

    // Read Text
    public String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }

    // MoveToElement
    public void moveToWebElement(By elementLocation) {
        new Actions(driver).moveToElement(driver.findElement(elementLocation)).build().perform();
    }

}
