package com.kodilla.testing2.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfig {
    public static final String CHROME = "CHROME_DRIVER";
    public static final String FIREFOX = "FIREFOX_DRIVER";

    public static WebDriver getDriver(final String driver){
        System.setProperty("webdriver.gecko.driver", "C:\\selenium-drivers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\selenium-drivers\\chromedriver.exe");

        if(driver.equals(FIREFOX)){
            return new FirefoxDriver();
        } else if (driver.equals(CHROME)){
            return new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Driver name must be either \"CHROME_DRIVER\" or \"FIREFOX_DRIVER\"");
        }
    }
}
