package com.cucumber.junit.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {

    private static final String BOOK_DEPOSITORY_URL = "https://www.bookdepository.com/";

    public void openBookDepositoryWebsite(){
        Selenide.open(BOOK_DEPOSITORY_URL);
    }

    private SelenideElement searchField = $("input[name='searchTerm']");
    private SelenideElement searchButton = $(".header-search-btn");

    public SelenideElement getMenuSearchField(){
        return searchField;
    }

    public SelenideElement getSearchButton(){
        return searchButton;
    }

    public void searchForBook(String string) {
        searchField.shouldBe(Condition.visible).setValue(string);
        searchField.sendKeys(Keys.ENTER);
    }
}
