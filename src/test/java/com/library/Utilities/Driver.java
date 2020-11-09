package com.library.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriver() {
        if (driver == null) {

            String browser = ConfigurationReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().deleteAllCookies();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().deleteAllCookies();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    break;
                default:
                    System.out.println("No such browser has been setup yet!");
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
