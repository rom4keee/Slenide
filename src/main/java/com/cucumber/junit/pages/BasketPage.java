package com.cucumber.junit.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage extends BasePage {

    private SelenideElement itemTotal = $("p.item-total");
    private SelenideElement basketTotal = $("dl.total dd");
    private SelenideElement checkoutButton = $("div.checkout-btns-wrap a[href='/payment/guest'][text()='Checkout']");
    private SelenideElement deliveryCost = $("dl.delivery-text dd");

    public SelenideElement getItemTotal(){
        itemTotal.shouldBe(Condition.visible);
        return itemTotal;
    }

    public SelenideElement getBasketTotal(){
        basketTotal.shouldBe(Condition.visible);
        return basketTotal;
    }

    public SelenideElement getCheckoutButton(){
        checkoutButton.shouldBe(Condition.visible);
        return checkoutButton;
    }

    public SelenideElement getDeliveryCost() {
        deliveryCost.shouldBe(Condition.visible);
        return deliveryCost;
    }
}
