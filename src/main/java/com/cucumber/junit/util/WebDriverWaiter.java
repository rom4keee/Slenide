package com.cucumber.junit.util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class WebDriverWaiter {

    public WebDriverWaiter waitForElement(WebElement element, long seconds){
        $(element).waitUntil(Condition.appear, seconds * 1000);
        return this;
    }

    public SelenideWait getWebDriverWait(long milliseconds) {
        return new SelenideWait((WebDriver) Selenide.webdriver(), Configuration.timeout, milliseconds);
    }

    public Condition elementIsDisplayed(WebElement element) {
        return Condition.visible;
    }
}
