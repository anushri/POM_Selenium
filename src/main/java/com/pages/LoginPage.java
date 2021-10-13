package com.pages;

import com.base.BasePage;
import com.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    //Constructor > the driver being passed, get set
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);//calls the constructor of BasePage for driver
        this.driver = driver;
    }


    // Page Locators
    By txtUsername = By.name("username");
    By txtPassword = By.name("password");
    By cmdLogin = By.xpath("//button[@type='submit']");
    By lblUsername = By.xpath("//label[contains(text(),'Username')]");
    By lblPassword = By.cssSelector("div:nth-of-type(2) > label");
    By lblByClicking = By.cssSelector("label.small:nth-child(1)");
    By lnkDisclaimer = By.xpath("//button[@type='button' and @class='btn btn-link text-danger']");
    //    By lnkDisclaimer = By.cssSelector(".btn.btn-link.text-danger");
    By lblTermsAndConditions = By.cssSelector("label.small:nth-child(3)");
    By lblEnvironmentName = By.cssSelector(".margin-left-5");
    By lnkLicenceInformation = By.xpath("//p/button[@type='button' and @class='btn btn-link']");
    By lblCharmVersion = By.cssSelector("div:nth-of-type(3) > p");
    By imgCitadel = By.cssSelector("[alt='Citadel Health Pty. Ltd.']");
    By imgCharm = By.cssSelector("[alt='Charm']");
    By lblElectronicMedical = By.xpath("//div/*[@class='login-details']/p[position()=1]");
    By lblCHARM = By.xpath("//div/*[@class='login-details']/p[position()=1]/strong");
    By lblIsUsed = By.cssSelector(".login-details > p");
    By lblLoginError = By.cssSelector(".floating-toast-notification strong");
    By lblLoginErrorText = By.xpath("div > span:nth-of-type(2)");
    By btnErrorClose = By.cssSelector(".close");
    By icnWarning = By.cssSelector(".pficon.pficon-warning-triangle-o");



    // Page Actions

    public void LaunchSite() {
        goToURL(PropertyReader.readItem("url"));
    }

    public void VerifyLoginPage() {
        waitForElementToAppear(lblPassword);
        waitForElementToAppear(lblUsername);
        waitForElementToAppear(imgCharm);
        waitForElementToAppear(imgCitadel);
        waitForElementToAppear(lblByClicking);
        waitForElementToAppear(lblIsUsed);
        waitForElementToAppear(lblCHARM);
        waitForElementToAppear(lblElectronicMedical);
        waitForElementToAppear(lnkLicenceInformation);
        waitForElementToAppear(lblTermsAndConditions);
        waitForElementToAppear(lnkDisclaimer);
        waitForElementToAppear(lblEnvironmentName);
        waitForElementToAppear(lblCharmVersion);
    }

    public String CheckCharmVersion() {
        return readText(lblCharmVersion);
    }

    public void LoginWithValidCredentials() {

        writeText(txtUsername, PropertyReader.readItem("username"));
        writeText(txtPassword, PropertyReader.readItem("password"));
        click(cmdLogin);
    }

    public DiarysPage afterLogin() {
        return new DiarysPage(driver);
    }

    public DisclaimerPage checkDisclaimer() throws InterruptedException {

        waitForElementToBeClickable(lnkDisclaimer);
        click(lnkDisclaimer);
        Thread.sleep(180);
        return new DisclaimerPage(driver);
    }

    public LicencePage checkLicence() throws InterruptedException {

        waitForElementToBeClickable(lnkLicenceInformation);
        click(lnkLicenceInformation);
        Thread.sleep(180);
        return new LicencePage(driver);
    }

}
