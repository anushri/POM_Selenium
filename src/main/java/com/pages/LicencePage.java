package com.pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LicencePage extends BasePage {

    WebDriver driver;

    //Constructor > the driver being passed, get set
    public LicencePage(WebDriver driver) {
        super(driver);//calls the constructor of BasePage for driver
        this.driver = driver;
    }

    // Page Locators

    By titleModalLicence = By.cssSelector(".modal-title.pull-left");
    By lblHeader = By.cssSelector("div:nth-of-type(1) > .card-header");
    By lblHeaderMIMS = By.cssSelector("div:nth-of-type(2) > .card-header");
    By btnOk = By.cssSelector(".btn.btn-default");
    By imgMIMS = By.cssSelector("license-detail img");
    By lblMIMS = By.cssSelector("div:nth-of-type(2) > .card-block.padding-sides-10 > .card-title");


    // Page Actions

    public String CheckPageTitle() {

        driver.switchTo().activeElement();
        waitForElementToAppear(titleModalLicence);
        String titleLicence = readText(titleModalLicence);
        return titleLicence;
    }

    public String CheckHeader() {
        waitForElementToAppear(lblHeader);
        return readText(lblHeader);
    }


}
