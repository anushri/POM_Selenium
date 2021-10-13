package com.pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DisclaimerPage extends BasePage {

    WebDriver driver;
    By titleModalDisclaimer = By.cssSelector(".modal-title.pull-left");

    // Page Locators
    By lblHeader = By.cssSelector("div > .card > .card-header");
    By lblDisclaimerAndCopyright = By.cssSelector("div > .card > .card-block.padding-sides-10 > .card-title");
    By lblGeneralDisclaimer = By.cssSelector(".card-text > strong");
    By lblCharmText = By.cssSelector(".card-block.padding-sides-10 > p:nth-of-type(2)");
    By lblWithout = By.cssSelector("css	.card-block.padding-sides-10 > p:nth-of-type(3)");
    By lbla = By.cssSelector("dl > dt:nth-of-type(1)");
    By lblb = By.cssSelector("dl > dt:nth-of-type(2)");
    By lblCharmHealth = By.cssSelector("dl > dd:nth-of-type(1)");
    By lblClinicalText = By.cssSelector("dl > dd:nth-of-type(2)");
    By lblUsersText = By.cssSelector("dl > dd:nth-of-type(3)");
    By lblCopyright = By.cssSelector("p:nth-of-type(6) > strong");
    By lblThisSoftwareText = By.cssSelector(".card-block.padding-sides-10 > p:nth-of-type(7)");
    By btnOk = By.cssSelector(".btn.btn-default");
    //Constructor > the driver being passed, get set
    public DisclaimerPage(WebDriver driver) {
        super(driver);//calls the constructor of BasePage for driver
        this.driver = driver;
    }


    // Page Actions

    public String CheckPageTitle() {
        driver.switchTo().activeElement();
        fluentWait(titleModalDisclaimer);
        String titleDisclaimer = readText(titleModalDisclaimer);
        return titleDisclaimer;
    }

    public String CheckHeader() {
        return readText(lblHeader);
    }


}
