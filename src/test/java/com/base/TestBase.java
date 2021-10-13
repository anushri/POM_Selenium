package com.base;

import com.utils.Log;
import com.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;


public class TestBase {
    public WebDriver driver;
    PropertyReader pr = new PropertyReader();


    SoftAssert Soft_Assert = new SoftAssert();

    public boolean compareStrings(String actualStr, String expectedStr) {
        try {
            //If this assertion will fail, It will throw exception and catch block will be executed.
            Assert.assertEquals(actualStr, expectedStr);
            Log.info("Actual ::'" + actualStr + "' matches, Expected :: " + expectedStr);
        } catch (Throwable t) {
            Soft_Assert.fail("Actual String ::" + actualStr + " And Expected String '" + expectedStr + "' Do Not Match.");
          //  Log.error("Comparison failed. Actual String :: ",t);
            Soft_Assert.assertAll();
            return false;
        }
        return true;
    }

    // Set the Driver
    // Quit the Driver

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        // Switch loop
        try {
            if ("Chrome".equalsIgnoreCase(PropertyReader.readItem("browser"))) {
                com.utils.Log.info("Chrome Browser Config Found");
                Log.info("Getting Chrome WebDriver Settings");
             //   System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                Log.info("Window maximises");

                // Chrome profile, options
            } else if ("msedge".equalsIgnoreCase(PropertyReader.readItem("browser"))) {
                com.utils.Log.info("Edge Browser Config Found");
                Log.info("Getting Edge WebDriver Settings");
             //   System.setProperty("webdriver.edge.driver", "Drivers//msedgedriver.exe");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                Log.info("Window maximises");
                // msedge profile, options
            } else if ("firefox".equalsIgnoreCase(PropertyReader.readItem("browser"))) {
            com.utils.Log.info("Firefox Browser Config Found");
            Log.info("Getting Edge WebDriver Settings");
            //   System.setProperty("webdriver.edge.driver", "Drivers//msedgedriver.exe");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            Log.info("Window maximises");
            // msedge profile, options
        }

            else {
                try {
                    throw new Exception("Browser Driver not supported");

                } catch (Exception e) {
                    Log.error("Not Browser found in Properties", e);
                }
            }

        } catch (Exception e) {
            Log.error("Browser Launch error", e);
        }


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Log.info("Stopping the WebDriver");
        driver.quit();
    }

}
