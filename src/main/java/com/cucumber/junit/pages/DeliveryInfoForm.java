package com.cucumber.junit.pages;

import com.cucumber.junit.DTO.UserDTO;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class DeliveryInfoForm extends CheckoutPage {

    @FindBy(xpath = "//input[@name='delivery-fullName']")
    private SelenideElement fullNameInputField;

    @FindBy(xpath = "//input[@name='delivery-addressLine1']")
    private SelenideElement addressLine1InputField;

    @FindBy(xpath = "//input[@name='delivery-addressLine2']")
    private SelenideElement addressLine2InputField;

    @FindBy(xpath = "//input[@name='delivery-city']")
    private SelenideElement deliveryCityTownInputField;

    @FindBy(xpath = "//input[@name='delivery-county']")
    private SelenideElement deliveryCountyStateInputField;

    @FindBy(xpath = "//input[@name='delivery-postCode']")
    private SelenideElement deliveryPostCode;

    @FindBy(name = "deliveryCountry")
    private SelenideElement deliveryCountryDropDown;

    public DeliveryInfoForm setFullName(String fullName) {
        fullNameInputField.setValue(fullName);
        return this;
    }

    public DeliveryInfoForm setCountry(String deliveryCountry) {
        deliveryCountryDropDown.selectOptionContainingText(deliveryCountry);
        exitFrame();
        return this;
    }

    public DeliveryInfoForm setAddressLine1(String addressLine1) {
        addressLine1InputField.setValue(addressLine1);
        return this;
    }

    public DeliveryInfoForm setAddressLine2(String addressLine2) {
        addressLine2InputField.setValue(addressLine2);
        return this;
    }

    public DeliveryInfoForm setDeliveryCityTown(String cityOrTown) {
        deliveryCityTownInputField.setValue(cityOrTown);
        return this;
    }

    public DeliveryInfoForm setDeliveryCountyState(String countyOrState) {
        deliveryCountyStateInputField.setValue(countyOrState);
        return this;
    }

    public DeliveryInfoForm setDeliveryPostCode(String postCode) {
        deliveryPostCode.setValue(postCode);
        return this;
    }

    public DeliveryInfoForm fillAddressForm(UserDTO addressInfo) {
        return setFullName(addressInfo.fullName)
                .setCountry(addressInfo.deliveryCountry)
                .setAddressLine1(addressInfo.addressLine1)
                .setAddressLine2(addressInfo.addressLine2)
                .setDeliveryCityTown(addressInfo.deliveryTownOrCity)
                .setDeliveryCountyState(addressInfo.deliveryCountyOrState)
                .setDeliveryPostCode(addressInfo.postCode);
    }
}
