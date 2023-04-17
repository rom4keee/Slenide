package com.cucumber.junit.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class BasketPopUp extends BasePage {

    private SelenideElement basketCheckoutButton = $("html body div:nth-child(11) div div div:nth-child(2) div div:nth-child(1) a:nth-child(2)");

    public SelenideElement getBasketCheckoutButton(){
        return basketCheckoutButton;
    }

    public void clickOnBasketCheckoutButton() {
        waitForElement(basketCheckoutButton, 30);
        basketCheckoutButton.click();
    }
}
