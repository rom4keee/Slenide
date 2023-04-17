package com.cucumber.junit.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import java.util.HashMap;
import java.util.Map;

public class SearchResultsPage extends BasketPage {

    private String filterSectionXPath = "//label[text()='%s']//following-sibling::select";
    private String preOrderButtonTemplate = "//a[@class='btn btn-sm btn-primary add-to-basket' and @href = '/basket/addisbn/isbn13/%s']";

    private static Map<String, String> bookInfo;

    static {
        bookInfo = new HashMap<>();
        bookInfo.put("Stranger Things Psychology", "9781684429097");
    }

    private SelenideElement addToBasketButton = $("div.primary-wrap > div > div > div > div > div > div > div > div > div:nth-child(3) > div > a");
    private SelenideElement refineResultsButton = $("button:contains('Refine results')");
    private SelenideElement preOrderButton = $("a.btn.btn-sm.btn-primary.add-to-basket[href='/basket/addisbn/isbn13/9781684429097']");
    private SelenideElement header = $("div.primary-wrap");

    private ElementsCollection allSearchResults = $$("div.book-item");

    public void clickOnPreOrderButtonForSelectedBook(String bookName) {
        String bookIsbn = bookInfo.get(bookName);
        SelenideElement btn = header.find(By.xpath(String.format(preOrderButtonTemplate, bookIsbn)));
        btn.click();
    }

    public SelenideElement getAddToBasketButton() {
        return addToBasketButton;
    }

    public SelenideElement getRefineResultsButton() {
        return refineResultsButton;
    }

    public SelenideElement getPreOrderButton() {
        return preOrderButton;
    }

    public String formatLocatorForSearchDropDown(String filterName) {
        return String.format(filterSectionXPath, filterName);
    }

    public ElementsCollection getAllSearchResults() {
        return allSearchResults;
    }

    public void clickOnRefineResultsButton() {
        refineResultsButton.waitUntil(Condition.visible, 30).click();
    }

    public void clickOnPreOrderButton() {
        preOrderButton.waitUntil(Condition.visible, 30).click();
    }
}
