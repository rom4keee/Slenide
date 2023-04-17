package com.cucumber.junit.hooks;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHooks {

    @Before
    public void setupDriver(){
    }

    @After
    public void quitDriver(){
        WebDriverRunner.closeWebDriver();
    }
}
