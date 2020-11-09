package com.library.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtilities {

    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitInMills(int mills){
        try {
            Thread.sleep(mills);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void enterText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        wait.until(ExpectedConditions.attributeToBe(element, "value", text));
        System.out.println("Entering text: "+text);
    }
}
