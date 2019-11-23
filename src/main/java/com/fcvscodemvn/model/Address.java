package com.fcvscodemvn.model;

import lombok.Data;

@Data
public class Address {
    String country;
    String province;
    String code;

    public Address(String c, String p, String cd) {
        this.country = c;
        this.province = p;
        this.code = cd;
    }

    public Address(Address origin) {
        this.country = origin.getCountry();
        this.province = origin.getProvince();
        this.code = origin.getCode();
    }
}