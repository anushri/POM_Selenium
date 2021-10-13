package com.pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DiarysPage extends BasePage {

    WebDriver driver;
    By menu_profile = By.id("menu-profile-pic");

    // Page Locators
    By charm_logo = By.cssSelector("");
    By chadmin_name = By.id("username");
    public DiarysPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Page Actions
    public String loginConfirmend() {
        fluentWait(menu_profile);
        fluentWait(charm_logo);
        return driver.findElement(cn_name).getText();
        //click(menu_profile);
    }

}
