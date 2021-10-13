package com.tests;

import com.base.TestBase;
import com.pages.DiarysPage;
import com.pages.DisclaimerPage;
import com.pages.LicencePage;
import com.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.utils.Log.endTestCase;
import static com.utils.Log.startTestCase;

public class Login extends TestBase {


    @Description("Open the browser and load the URL")
    @Step("Step 1")
    @Test
    public void testWebPage() {

        Class<Logger> log = Logger.class;
        startTestCase("Open the browser and load the URL");

        //Intialise
        LoginPage loginPage = new LoginPage(driver);

        //Launch the site and check all elements present
        loginPage.LaunchSite();
        loginPage.VerifyLoginPage();

        String CharmVersion = loginPage.CheckCharmVersion();
        Assert.assertTrue(CharmVersion.contains("Charm® Version"));
        Assert.assertTrue(CharmVersion.contains("-Licence Information"));
        endTestCase();

    }

    @Description("Verify Disclaimer Page")
    @Step("Step 2")
    @Test
    public void VerifyDisclaimerPage() throws InterruptedException {

        Class<Logger> log = Logger.class;
        startTestCase("Verify Disclaimer Page");

        //Intialise
        LoginPage loginPage = new LoginPage(driver);

        //Launch the website and verify the page details
        loginPage.LaunchSite();
        DisclaimerPage disclaimerPage = loginPage.checkDisclaimer();
        disclaimerPage.CheckPageTitle();
        String actualDisclaimerTitle = disclaimerPage.CheckPageTitle();
        compareStrings(actualDisclaimerTitle, "Disclaimer and Copyright Information");
        String lblHeader = disclaimerPage.CheckHeader();
        compareStrings(lblHeader, "IMPORTANT");
        endTestCase();
    }


    @Description("Verify Licence Information")
    @Step("Step 3")
    @Test
    public void VerifyLicenceInformation() throws InterruptedException {


//      Logger.getLogger(VerifyLicenceInformation.class);
        Class<Logger> log = Logger.class;
        startTestCase("Verify Licence Information");

        //Intialise
        LoginPage loginPage = new LoginPage(driver);
        LicencePage licencePage = new LicencePage(driver);

        //Launch the website and verify the page details
        loginPage.LaunchSite();
        loginPage.checkLicence();
        String licenceHeader = licencePage.CheckHeader();
        compareStrings(licenceHeader, "Licence Information");
        endTestCase();
    }


    @Description("Verify Logged in User")
    @Step("Step 4")
    @Test
    public void VerifyUserIsLogged() {

        Class<Logger> log = Logger.class;
        startTestCase("Verify Logged in User");

        //Initialise
        LoginPage loginPage = new LoginPage(driver);

        //Launch the website and login
        loginPage.LaunchSite();
        loginPage.LoginWithValidCredentials();
        DiarysPage diarysPage = loginPage.afterLogin();
        Assert.assertNotNull(diarysPage.loginConfirmend());
        endTestCase();
    }
}
