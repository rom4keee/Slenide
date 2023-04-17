package com.cucumber.junit.DTO;

import java.util.Map;

public class UserDTO {
    public String fullName;
    public String deliveryCountry;
    public String addressLine1;
    public String addressLine2;
    public String deliveryTownOrCity;
    public String deliveryCountyOrState;
    public String postCode;

    public UserDTO(String fullName, String deliveryCountry, String addressLine1, String addressLine2,
                   String deliveryTownOrCity, String deliveryCountyOrState, String postCode) {
        this.fullName = fullName;
        this.deliveryCountry = deliveryCountry;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.deliveryTownOrCity = deliveryTownOrCity;
        this.deliveryCountyOrState = deliveryCountyOrState;
        this.postCode = postCode;
    }

    public static UserDTO transform(Map<String, String> map) {
        return new UserDTO(map.get("Full name"), map.get("Delivery country"), map.get("Address line 1"),
                map.get("Address line 2"), map.get("Town/City"), map.get("County/State"), map.get("Postcode"));
    }
}