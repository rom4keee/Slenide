package com.cucumber.junit.steps;

import com.cucumber.junit.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class CheckoutSteps {

    private final HomePage homePage = new HomePage();
    private final BasketPage basketPage = new BasketPage();
    private final CheckoutPage checkoutPage = new CheckoutPage();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();
    private final BasketPopUp basketPopUp = new BasketPopUp();

    @Given("the user opens Book Depository website")
    public void openBookDepositoryWebsite() {
        homePage.openBookDepositoryWebsite();
    }

    @When("^the user enters ([\\w\\s]+) into the search input$")
    public void enterSearchTerm(String searchTerm) {
        homePage.getMenuSearchField().sendKeys(searchTerm);
    }

    @And("the user clicks on Search button")
    public void clickSearchButton() {
        homePage.getSearchButton().click();
    }

    @And("^Search results page with URL ((?:http|https):\\/\\/[\\w+./?=&]+) is displayed$")
    public void searchResultsPageWithURLIsDisplayed(String expectedURL) {
        Assert.assertEquals("Page URL is incorrect", expectedURL, searchResultsPage.getPageUrl());
    }

    @When("the user clicks Add to basket button for product with name Flowers for Algernon")
    public void clicksAddToBasketButton() {
        searchResultsPage.getAddToBasketButton().click();
    }

    @And("the user clicks on Basket-Checkout button in basket pop-up")
    public void clickBasketCheckoutButton() {basketPopUp.getBasketCheckoutButton().click();
    }

    @Then("Basket page opens with correct values")
    public void subtotalIsAsFollowing(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        assertSoftly(
                softAssertions -> {
                    softAssertions.assertThat(basketPage.getItemTotal().getText())
                            .as("Basket Total is incorrect")
                            .isEqualTo(rows.get(0).get("value"));
                    softAssertions.assertThat(basketPage.getBasketTotal().getText())
                            .as("Basket Subtotal is incorrect")
                            .isEqualTo(rows.get(1).get("value"));
                });
    }

    @When("the user clicks Checkout button on Basket page")
    public void clicksCheckoutButtonOnBasketPage() {
        basketPage.getCheckoutButton().click();
    }

    @And("Checkout page opens with correct values")
    public void checkoutFinalReview(DataTable table) {
        List<Map<String, String>> prices = table.asMaps(String.class, String.class);

        assertSoftly(
                softAssertions -> {
                    softAssertions.assertThat(checkoutPage.getOrderSummaryTotal().getText())
                            .as("Order Total is incorrect")
                            .isEqualTo(prices.get(0).get("value"));
                    softAssertions.assertThat(checkoutPage.getOrderSummarySubtotal().getText())
                            .as("Order Subtotal is incorrect")
                            .isEqualTo(prices.get(1).get("value"));
                });
}

    @And("^the user set ([A-Za-z0-9.\\-_]{3,25}@[A-Za-z]{3,5}\\.[A-Za-z]{3,}) as e-mail address$")
    public void setEmailAddress(String email) {
        checkoutPage.getEmailInput().sendKeys(email);
    }
}
