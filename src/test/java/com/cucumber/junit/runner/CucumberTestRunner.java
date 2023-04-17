package com.cucumber.junit.runner;

import com.codeborne.selenide.Configuration;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/CucumberTests.html",
                "json:target/cucumber-reports/CucumberTests.json",
                "junit:target/cucumber-reports/CucumberTests.xml"},
        monochrome = true,
        tags = "@Regression",
        glue = "com.cucumber.junit.steps",
        features = "src/test/resources/com/cucumber/junit/features/"
)
public class CucumberTestRunner {

    static {
        Configuration.browser = "chrome";
    }
}
