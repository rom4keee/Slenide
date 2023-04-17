package com.cucumber.junit.pages;


import com.codeborne.selenide.SelenideElement;
import com.cucumber.junit.util.WebDriverWaiter;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.switchTo;

public class BasePage extends WebDriverWaiter {

    public BasePage(){
        page(this);
    }

    public String getPageUrl() {
        return page(this).getPageUrl();
    }

    private static Map<String, String> expectedUrlList;

    static {
        expectedUrlList = new HashMap<>();
        expectedUrlList.put("Search results", "https://www.bookdepository.com/search?searchTerm=Stranger+things&search=Find+book");
        expectedUrlList.put("Basket page", "https://www.bookdepository.com/basket");
        expectedUrlList.put("Checkout", "https://www.bookdepository.com/payment/guest");
    }

    public static String getExpectedUrlTitle(String string) {
        return expectedUrlList.get(string);
    }

    public void exitFrame() {
        switchTo().defaultContent();
    }

    public Select getNewSelect(SelenideElement element) {
        return new Select(element);
    }

    public void switchToFrame(SelenideElement frameName) {
        switchTo().frame(frameName);
    }
}
