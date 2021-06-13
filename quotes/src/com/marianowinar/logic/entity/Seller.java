package com.marianowinar.logic.entity;

public class Seller {
    private Long sellerId;
    private String name;
    private String surname;
    private String sellerCode;

    public Seller(){}

    public Seller(Long sellerId, String name, String surname, String sellerCode) {
        this.sellerId = sellerId;
        this.name = name;
        this.surname = surname;
        this.sellerCode = sellerCode;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }


}
