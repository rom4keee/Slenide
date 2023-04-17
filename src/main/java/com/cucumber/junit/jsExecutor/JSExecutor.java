package com.cucumber.junit.jsExecutor;

import com.cucumber.junit.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSExecutor {
    public static JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();

    public static String getPageURLJavaScript() {
        return jsExecutor.executeScript("return document.URL;").toString();
    }

    public static void executeHighlightingJavaScript(WebElement element) {
        jsExecutor.executeScript("arguments[0].style.background='yellow'", element);
    }
}
