package com.cucumber.junit.driver;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;

public class DriverManager {

    private static final int IMPLICIT_WAIT_TIMEOUT = 10;
    private static final int PAGE_LOAD_TIMEOUT = 20;
    private static final String CHROME_DRIVER_PATH = "src/main/resources/chromedriver.exe";
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setupDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = IMPLICIT_WAIT_TIMEOUT * 1000;
        Configuration.pageLoadTimeout = PAGE_LOAD_TIMEOUT * 1000;
        WebDriver driver = new ChromeDriver();
        webDriverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

    public static void quitDriver() {
        Optional.ofNullable(getDriver()).ifPresent(webDriver -> {
            webDriver.quit();
            webDriverThreadLocal.remove();
        });
    }
}
