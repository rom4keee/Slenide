package com.cucumber.junit.pages;

import com.codeborne.selenide.SelenideElement;
import com.cucumber.junit.jsExecutor.JSExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class CheckoutPage extends BasePage{

    @FindBy (name = "emailAddress")
    private WebElement emailInput;

    @FindBy (xpath = "//dd[@class = 'text-right total-price']")
    private WebElement orderSummaryTotal;

    @FindBy (xpath = "//dd[@class = 'text-right']")
    private WebElement orderSummarySubtotal;

    @FindBy (xpath = "//dd[@class='text-right total-tax']")
    WebElement orderSummaryTax;

    @FindBy (xpath = "//strong[text() = 'Delivery']//ancestor::dt//following-sibling::dd//strong")
    private WebElement orderSummaryDelivery;

    @FindBy (xpath = "//button[@class='btn btn-primary full-width']")
    WebElement buyNowButton;

    @FindBy (xpath = "//div[@class='block-wrap delivery-address']")
    WebElement form;

    @FindBy (xpath = "//div[@class='buynow-error-msg']")
    WebElement errorMessagesAtPaymentForm;

    @FindBy (xpath = "//div[@class='block-wrap delivery-address']//div[@class='error-block']")
    WebElement errorMessagesAtDeliveryAddressForm;

    @FindBy (xpath = "//input[@id='cvv']")
    WebElement cvv;

    @FindBy (xpath = "//iframe[@id='braintree-hosted-field-cvv']")
    WebElement cvvFrame;

    @FindBy (xpath = "//input[@id='credit-card-number']")
    WebElement cardNumber;

    @FindBy (xpath = "//iframe[@id='braintree-hosted-field-number']")
    WebElement cardNumberFrame;

    @FindBy (xpath = "//input[@id='expiration']")
    WebElement expiryDate;

    @FindBy (xpath = "//iframe[@id='braintree-hosted-field-expirationDate']")
    WebElement expiryDateFrame;

    private static final Map<String, String> deliveryErrorMessagesList;

    static {
        deliveryErrorMessagesList = new HashMap<>();
        deliveryErrorMessagesList.put("Email address", "//div[normalize-space()='Please enter your Email address']");
        deliveryErrorMessagesList.put("Full name", "//div[@id='delivery-fullName-errors']");
        deliveryErrorMessagesList.put("Address line 1", "//div[@id='delivery-addressLine1-errors']");
        deliveryErrorMessagesList.put("Town/City", "//div[@id='delivery-city-errors']");
        deliveryErrorMessagesList.put("Postcode/ZIP", "//div[@id='delivery-postCode-errors']");
    }

    public static String getDeliveryErrorMessagesLocator (String string) {
        return deliveryErrorMessagesList.get(string);
    }

    public WebElement getEmailInput(){
        return emailInput;
    }

    public WebElement getOrderSummaryTotal(){
        JSExecutor.executeHighlightingJavaScript(orderSummaryTotal);
        return orderSummaryTotal;
    }

    public WebElement getOrderSummarySubtotal(){
        JSExecutor.executeHighlightingJavaScript(orderSummarySubtotal);
        return orderSummarySubtotal;
    }

    public WebElement getOrderSummaryDelivery() {
        JSExecutor.executeHighlightingJavaScript(orderSummaryDelivery);
        return orderSummaryDelivery;}

    public WebElement getOrderSummaryTax() {
        JSExecutor.executeHighlightingJavaScript(orderSummaryTax);
        return orderSummaryTax;}


    public WebElement getBuyNowButton() {
        return buyNowButton;
    }

    public String getErrorMessageText(String string) {
        WebElement errorText = form.findElement(By.xpath(deliveryErrorMessagesList.get(string)));
        waitForElement(errorText, 30);
        return errorText.getText();
    }

    public String getTextOfErrorMessagesAtPaymentForm() {
        return errorMessagesAtPaymentForm.getText();
    }

    public void enterEmailAddress(String emailAddress) {
        emailInput.sendKeys(emailAddress);
    }
    public void enterCreditCardNumber(String creditCardNumber) {
        switchToFrame((SelenideElement) cardNumberFrame);
        cardNumber.sendKeys(creditCardNumber);
        exitFrame();
    }

    public void enterExpiryDate(String expiryDateValue) {
        switchToFrame((SelenideElement) expiryDateFrame);
        expiryDate.sendKeys(expiryDateValue);
        exitFrame();
    }

    public void enterCVV(String cvvValue) {
        switchToFrame((SelenideElement) cvvFrame);
        cvv.sendKeys(cvvValue);
        exitFrame();
    }

    public Boolean areErrorMessagesDisplayed() {
        return errorMessagesAtDeliveryAddressForm.isDisplayed();
    }

}
