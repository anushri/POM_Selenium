package com.tests;


import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeEx {

    public static void main(String[] args) {

        // Start Edge Session
        //  WebDriver driver = new EdgeDriver();
        EdgeOptions options = new EdgeOptions();

        //    options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge Beta\\Application\\msedge.exe");
        System.setProperty("webdriver.edge.driver", "Drivers\\msedgedriver.exe");
        EdgeDriver driver = new EdgeDriver(options);
        driver.get("http://charmweb.citadelhealth.com.au:494/login?returnUrl=%2F");


    }
}
